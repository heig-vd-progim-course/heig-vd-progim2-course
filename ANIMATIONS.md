# Animations Manim - Guide de démarrage rapide

Ce document explique comment utiliser Manim Community Edition pour créer des
animations pédagogiques dans ce cours.

## 🎯 Ce qui a été mis en place

### 1. Infrastructure d'animation

- ✅ Script de build automatique :
  [`build-all-animations.sh`](../build-all-animations.sh)
- ✅ Script de rendu individuel :
  [`render-animation.sh`](../render-animation.sh)
- ✅ Configuration `.gitignore` pour exclure les vidéos générées
- ✅ Instructions Manim :
  [`.github/instructions/manim.instructions.md`](../.github/instructions/manim.instructions.md)

### 2. Exemple fonctionnel

Animation du tri à bulles créée et testée :

- 📁 Emplacement :
  `01-contenus-du-cours/07-algorithmes-de-tri/01-exemples-de-code/03-tri-bulles/`
- 📝 Code source :
  [`bubble_sort_animation.py`](01-contenus-du-cours/07-algorithmes-de-tri/01-exemples-de-code/03-tri-bulles/bubble_sort_animation.py)
- 🎬 Vidéos générées :
  - `BubbleSortAnimation.mp4` (747 KB) - Animation complète avec comparaisons et
    échanges
  - `BubbleSortSimple.mp4` (105 KB) - Version simplifiée avec barres

## 🚀 Utilisation rapide

### Générer toutes les animations

```bash
./build-all-animations.sh
```

Cette commande :

- Trouve tous les fichiers `*_animation.py` dans le projet
- Les rend avec Docker (ou Manim local si installé)
- Place les vidéos dans le dossier `animations/` de chaque module

### Générer une animation spécifique

```bash
# Rendre toutes les scènes d'un fichier
bash render-animation.sh 01-contenus-du-cours/07-algorithmes-de-tri/01-exemples-de-code/03-tri-bulles/bubble_sort_animation.py

# Rendre une scène spécifique en basse qualité (rapide)
bash render-animation.sh bubble_sort_animation.py BubbleSortSimple l

# Rendre en haute qualité
bash render-animation.sh bubble_sort_animation.py BubbleSortAnimation h
```

**Options de qualité :**

- `l` : Basse (480p) - pour tests rapides
- `m` : Moyenne (720p) - par défaut, recommandé
- `h` : Haute (1080p) - pour version finale
- `k` : 4K (2160p) - très lent

## 📝 Créer une nouvelle animation

### 1. Structure du fichier

```python
"""
Description de l'animation

Ce que l'animation illustre pour les personnes qui étudient.
"""

from manim import *


class MonAnimation(Scene):
    """Description courte de la scène."""

    def construct(self):
        # Titre
        title = Text("Mon titre", font_size=36)
        title.to_edge(UP)
        self.play(Write(title))

        # Contenu de l'animation
        rectangle = Rectangle(width=2, height=1, fill_color=BLUE, fill_opacity=0.7)
        self.play(Create(rectangle))

        self.wait(2)
```

### 2. Conventions de nommage

- Nom du fichier : `concept_animation.py` (avec suffixe `_animation.py`)
- Nom de la classe : `ConceptAnimation` (PascalCase)
- Emplacement : dans le dossier du cours concerné
- Textes : en français (pour correspondre au cours)
- Code : en anglais (variables, fonctions, etc.)

### 3. Palette de couleurs recommandée

```python
colors = {
    "default": BLUE,       # Éléments par défaut
    "comparing": YELLOW,   # Éléments en comparaison
    "swapping": RED,       # Éléments en échange
    "sorted": GREEN,       # Éléments triés/finaux
    "highlight": ORANGE,   # Mise en évidence
}
```

## 🎨 Exemples d'animations utiles

Pour ce cours, voici les types d'animations pertinentes :

### Algorithmes de tri

- ✅ Tri à bulles (déjà créé)
- 📋 Tri par sélection
- 📋 Tri par insertion
- 📋 Tri rapide (quicksort)
- 📋 Tri fusion (mergesort)

### Structures de données

- 📋 Listes et tableaux
- 📋 Piles (stack)
- 📋 Files (queue)
- 📋 Arbres binaires

### Concepts algorithmiques

- 📋 Récursivité
- 📋 Complexité temporelle
- 📋 Parcours de graphes

## 🐳 Docker vs Installation locale

### Avantages de Docker (recommandé)

- ✅ Aucune installation requise
- ✅ Reproductible sur tous les systèmes
- ✅ Isolation des dépendances
- ✅ Identique en local et en CI/CD

### Avantages de l'installation locale

- ⚡ Plus rapide (pas de surcharge Docker)
- 🔍 Prévisualisation en temps réel
- 🛠️ Débogage plus facile

Pour installer localement :

```bash
pip install manim
```

## 📚 Ressources

- **Documentation officielle** : https://docs.manim.community/
- **Exemples** : https://docs.manim.community/en/stable/examples.html
- **Référence API** : https://docs.manim.community/en/stable/reference.html
- **Galerie communautaire** :
  https://github.com/ManimCommunity/manim/wiki/Gallery

## 💡 Bonnes pratiques

1. **Animations courtes** : 30 secondes à 2 minutes maximum
2. **Un concept par animation** : ne pas surcharger
3. **Couleurs cohérentes** : utiliser la même palette dans tout le cours
4. **Pauses appropriées** : `self.wait()` entre les étapes importantes
5. **Texte lisible** : taille de police >= 32
6. **Qualité moyenne** : suffisante pour la plupart des cas
7. **Versionner le code** : .py dans Git, pas les .mp4
8. **Documenter** : docstrings en français pour expliquer l'objectif

## 🔧 Intégration dans les supports de cours

### Dans README.md

```markdown
## Visualisation

Voir l'animation du tri à bulles :

<video src="01-exemples-de-code/03-tri-bulles/animations/videos/bubble_sort_animation/720p30/BubbleSortAnimation.mp4" controls></video>

Ou
[télécharger la vidéo](01-exemples-de-code/03-tri-bulles/animations/videos/bubble_sort_animation/720p30/BubbleSortAnimation.mp4).
```

### Dans les présentations Marp

```markdown
## Tri à bulles

![bg right:40% fit](01-exemples-de-code/03-tri-bulles/animations/videos/bubble_sort_animation/720p30/BubbleSortAnimation.mp4)

- Comparaisons successives
- Échanges si nécessaire
- Plusieurs passages
```

## ❓ Dépannage

### Erreur : "docker: command not found"

→ Installer Docker ou Manim localement

### Erreur : "No such option: --video_dir"

→ Options corrigées dans le script, mettre à jour si modifié

### Animation trop longue à générer

→ Utiliser qualité basse (`-ql`) pendant le développement

### Docker permission denied

→ Vérifier que l'utilisateur actuel a accès à Docker

---

**Note** : Les fichiers vidéo générés (`.mp4`) sont exclus du contrôle de
version via `.gitignore`. Seuls les fichiers source Python (`.py`) sont
versionnés et peuvent être régénérés à tout moment avec les scripts de build.
