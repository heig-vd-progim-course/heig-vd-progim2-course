#!/usr/bin/env bash

# Script pour prévisualiser rapidement une animation Manim
# Usage: ./render-animation.sh <fichier.py> [nom-de-scene] [qualité]

set -e

ANIMATION_FILE="$1"
SCENE_NAME="${2:-}"
QUALITY="${3:-m}"  # l (low), m (medium), h (high), k (4k)

if [ -z "$ANIMATION_FILE" ]; then
    echo "Usage: $0 <fichier_animation.py> [nom-scene] [qualité]"
    echo ""
    echo "Qualité: l (basse), m (moyenne, défaut), h (haute), k (4K)"
    echo ""
    echo "Exemples:"
    echo "  $0 bubble_sort_animation.py"
    echo "  $0 bubble_sort_animation.py BubbleSortSimple l"
    exit 1
fi

if [ ! -f "$ANIMATION_FILE" ]; then
    echo "Erreur: Le fichier $ANIMATION_FILE n'existe pas"
    exit 1
fi

WORKDIR=$(pwd)
ANIMATION_DIR=$(dirname "$ANIMATION_FILE")
MANIM_DOCKER_IMAGE="manimcommunity/manim:v0.18.1"

# Construire la commande
if command -v "manim" > /dev/null 2>&1; then
    echo "Utilisation de Manim local..."
    if [ -n "$SCENE_NAME" ]; then
        manim render -q${QUALITY} -p "$ANIMATION_FILE" "$SCENE_NAME" \
            --media_dir "$ANIMATION_DIR/animations"
    else
        manim render -q${QUALITY} -p -a "$ANIMATION_FILE" \
            --media_dir "$ANIMATION_DIR/animations"
    fi
else
    echo "Utilisation de Docker..."
    
    # Convertir le chemin relatif en chemin absolu si nécessaire
    if [[ "$ANIMATION_FILE" != /* ]]; then
        ABS_PATH="$WORKDIR/$ANIMATION_FILE"
    else
        ABS_PATH="$ANIMATION_FILE"
    fi
    
    # Calculer le chemin relatif depuis WORKDIR
    REL_PATH="${ABS_PATH#$WORKDIR/}"
    
    if [ -n "$SCENE_NAME" ]; then
        docker run --rm \
            --volume="$WORKDIR:/manim" \
            --user="$(id -u):$(id -g)" \
            "$MANIM_DOCKER_IMAGE" \
            manim render -q${QUALITY} "/manim/$REL_PATH" "$SCENE_NAME" \
                --media_dir "/manim/$ANIMATION_DIR/animations"
    else
        docker run --rm \
            --volume="$WORKDIR:/manim" \
            --user="$(id -u):$(id -g)" \
            "$MANIM_DOCKER_IMAGE" \
            manim render -q${QUALITY} -a "/manim/$REL_PATH" \
                --media_dir "/manim/$ANIMATION_DIR/animations"
    fi
fi

echo ""
echo "✓ Animation rendue avec succès dans:"
echo "  $ANIMATION_DIR/animations/"
