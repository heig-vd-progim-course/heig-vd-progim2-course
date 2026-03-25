# Animations avec Manim

Ce répertoire contient des animations générées avec
[Manim Community Edition](https://www.manim.community/).

## Fichiers générés

Les animations sont générées à partir du fichier
[`bubble_sort_animation.py`](../bubble_sort_animation.py) et stockées dans la
structure suivante :

```
animations/
└── videos/
    └── bubble_sort_animation/
        └── 720p30/
            ├── BubbleSortAnimation.mp4
            └── BubbleSortSimple.mp4
```

## Utilisation dans le cours

### BubbleSortAnimation

Animation complète du tri à bulles montrant :

- Les comparaisons entre éléments (en jaune)
- Les échanges d'éléments (en rouge)
- Les éléments triés (en vert)
- Le parcours complet de l'algorithme

**Durée** : ~30 secondes  
**Taille** : ~750 KB

### BubbleSortSimple

Version simplifiée avec des barres verticales représentant les valeurs.

**Durée** : ~10 secondes  
**Taille** : ~100 KB

## Régénérer les animations

Pour régénérer les animations après modification du code source :

```bash
# Depuis la racine du projet
./build-all-animations.sh
```

Ou pour ce fichier spécifique :

```bash
# Avec Docker
docker run --rm \
  -v "$(pwd):/manim" \
  -u "$(id -u):$(id -g)" \
  manimcommunity/manim:v0.18.1 \
  manim render -qm -a /manim/01-contenus-du-cours/07-algorithmes-de-tri/01-exemples-de-code/03-tri-bulles/bubble_sort_animation.py \
  --media_dir /manim/01-contenus-du-cours/07-algorithmes-de-tri/01-exemples-de-code/03-tri-bulles/animations

# Avec installation locale de Manim
manim render -qm -a bubble_sort_animation.py --media_dir ./animations
```

## Options de qualité

- `-ql` : Basse qualité (480p, rapide)
- `-qm` : Qualité moyenne (720p, recommandé)
- `-qh` : Haute qualité (1080p, plus lent)
- `-qk` : Qualité 4K (2160p, très lent)

## Ressources

- [Documentation Manim](https://docs.manim.community/)
- [Exemples Manim](https://docs.manim.community/en/stable/examples.html)
- [Guide de référence](https://docs.manim.community/en/stable/reference.html)
