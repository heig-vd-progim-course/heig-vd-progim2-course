#!/usr/bin/env bash
#
# Script pour mettre à jour automatiquement les chemins source Java dans
# .vscode/settings.json
#
# Ce script scanne tous les dossiers d'exemples de code et génère la
# configuration java.project.sourcePaths

set -euo pipefail

# Déterminer le répertoire racine du workspace
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
cd "$SCRIPT_DIR"

SETTINGS_FILE=".vscode/settings.json"
TEMP_FILE=$(mktemp)

echo "🔍 Recherche des dossiers d'exemples de code Java..."

# Trouver tous les dossiers contenant des fichiers .java
# en excluant les dossiers cachés, node_modules, etc.
SOURCE_PATHS=$(find . -type f -name "*.java" \
    -not -path "*/node_modules/*" \
    -not -path "*/.git/*" \
    -not -path "*/build/*" \
    -not -path "*/target/*" \
    -not -path "*/.vscode/*" \
    -exec dirname {} \; | \
    sort -u | \
    sed 's|^\./||' | \
    sed 's|^|		"|' | \
    sed 's|$|",|')

# Supprimer la dernière virgule
SOURCE_PATHS=$(echo "$SOURCE_PATHS" | sed '$ s/,$//')

echo "📁 Dossiers trouvés:"
echo "$SOURCE_PATHS" | sed 's/^		"/  - /' | sed 's/"$//'

# Lire le fichier settings.json et remplacer la section java.project.sourcePaths
if [ ! -f "$SETTINGS_FILE" ]; then
    echo "Erreur: $SETTINGS_FILE n'existe pas"
    exit 1
fi

# Utiliser jq pour manipuler le JSON correctement
if command -v jq &> /dev/null; then
    echo "Utilisation de jq pour mettre à jour le JSON..."
    
    # Extraire les chemins en tant que tableau JSON
    PATHS_ARRAY=$(find . -type f -name "*.java" \
        -not -path "*/node_modules/*" \
        -not -path "*/.git/*" \
        -not -path "*/build/*" \
        -not -path "*/target/*" \
        -not -path "*/.vscode/*" \
        -exec dirname {} \; | \
        sort -u | \
        sed 's|^\./||' | \
        jq -R -s -c 'split("\n") | map(select(length > 0))')
    
    # Mettre à jour le fichier settings.json
    jq ".\"java.project.sourcePaths\" = $PATHS_ARRAY" "$SETTINGS_FILE" > "$TEMP_FILE"
    mv "$TEMP_FILE" "$SETTINGS_FILE"
    
    echo "$SETTINGS_FILE mis à jour avec succès!"
else
    echo " jq n'est pas installé. Mise à jour manuelle requise."
    echo ""
    echo "Ajoutez cette configuration dans $SETTINGS_FILE:"
    echo ""
    echo '	"java.project.sourcePaths": ['
    echo "$SOURCE_PATHS"
    echo '	],'
    exit 1
fi

echo ""
echo "🎉 Configuration des chemins source Java terminée!"
echo "   Rechargez VS Code pour appliquer les changements."
