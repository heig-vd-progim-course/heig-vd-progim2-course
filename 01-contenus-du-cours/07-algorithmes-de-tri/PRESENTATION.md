---
marp: true
theme: "custom-marp-theme"
size: "16:9"
paginate: "true"
author: "V. Guidoux, avec l'aide de GitHub Copilot"
description:
  "Algorithmes de tri pour le cours ProgIM2 enseigné à la HEIG-VD, Suisse"
lang: "fr"
url: "https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/07-algorithmes-de-tri/presentation.html"
header: "[**Algorithmes de tri**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Algorithmes de tri

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-progim-course/heig-vd-progim2-course>

Visualiser le contenu complet sur GitHub [à cette
adresse][contenu-complet-sur-github].

<small>V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>Ce travail est sous licence [CC BY-SA 4.0][licence].</small>

![bg opacity:0.1][illustration-principale]

## Plus de détails sur GitHub

<!-- _class: lead -->

_Cette présentation est un résumé du contenu complet disponible sur GitHub._

_Pour plus de détails, consulter le [contenu complet sur
GitHub][contenu-complet-sur-github] ou en cliquant sur l'en-tête de ce
document._

## Objectifs (1/3)

- Expliquer pourquoi le tri de données est important en programmation.
- Identifier les critères de comparaison pour trier des objets.
- Différencier tri croissant et tri décroissant.
- Utiliser des comparateurs pour trier selon différents critères.

![bg right:40%][illustration-objectifs]

## Objectifs (2/3)

- Appliquer plusieurs stratégies de tri sur une même collection.
- Expliquer le fonctionnement du tri par sélection.
- Expliquer le fonctionnement du tri par insertion.
- Expliquer le fonctionnement du tri à bulles.

![bg right:40%][illustration-objectifs]

## Objectifs (3/3)

- Expliquer le fonctionnement du tri rapide (quicksort).
- Expliquer le fonctionnement du tri fusion (mergesort).

![bg right:40%][illustration-objectifs]

## Introduction : le problème de la recherche d'informations

<!-- _class: lead -->

### Chercher dans une base de données (1/2)

**Exemples concrets** :

- Application de contacts avec des milliers d'entrées.
- Système de gestion de bibliothèque avec des millions de livres.
- Plateforme de commerce électronique avec des centaines de milliers de
  produits.

**Le problème** : comment retrouver rapidement l'information recherchée ?

### Chercher dans une base de données (2/2)

**Recherche linéaire** : parcourir tous les éléments un par un.

- Pour 1 million d'entrées : jusqu'à 1 million de comparaisons.
- Lente et inefficace pour de grandes quantités de données.

**Recherche binaire** : diviser l'espace de recherche par deux à chaque étape.

- Pour 1 million d'entrées : maximum 20 comparaisons.
- Exponentiellement plus rapide. mais **nécessite des données triées.**

### Le tri comme solution (1/2)

Le tri rend la recherche exponentiellement plus rapide.

**Exemple du jeu de devinettes** :

- Deviner un nombre entre 1 et 100.
- Stratégie linéaire (1, 2, 3...) : jusqu'à 100 tentatives.
- Stratégie binaire (50, 25 ou 75...) : maximum 7 tentatives.

La stratégie binaire nécessite un ordre.

### Le tri comme solution (2/2)

- **Affichage** : contacts alphabétiques, produits par prix, articles par date.
- **Analyse** : calculer la médiane, détecter des doublons, regrouper des
  similaires.
- **Optimisation** : de nombreux algorithmes utilisent le tri comme étape
  préliminaire.

**Le compromis** : trier coûte du temps et des ressources, d'où l'importance de
choisir le bon algorithme.

## Comprendre le tri avec des cartes à jouer

<!-- _class: lead -->

### Observer avant d'agir (1/2)

Imaginez que vous recevez un jeu de cartes mélangées.

**Avant de commencer à trier** : vous observez les cartes pour comprendre quelle
stratégie adopter.

|                  1                   |                  2                   |                  3                   |                  4                   |                  5                   |
| :----------------------------------: | :----------------------------------: | :----------------------------------: | :----------------------------------: | :----------------------------------: |
| ![h:180px](./images/7_of_spades.svg) | ![h:180px](./images/3_of_spades.svg) | ![h:180px](./images/9_of_spades.svg) | ![h:180px](./images/2_of_spades.svg) | ![h:180px](./images/8_of_spades.svg) |

### Observer avant d'agir (2/2)

L'ordre actuel : **7, 3, 9, 2, 8**

Aucune logique apparente dans cet ordre.

**Observation** : permet d'identifier visuellement l'état initial et de
comprendre le travail à effectuer.

### Définir un critère de tri (1/2)

Avant de trier, il faut décider **comment** trier.

**Critères possibles pour des cartes** :

- **Par valeur croissante** : du plus petit au plus grand.
- **Par valeur décroissante** : du plus grand au plus petit.

Dans ce cours : focus sur le tri croissant (le plus courant et intuitif).

### Définir un critère de tri (2/2)

**Résultat attendu après tri croissant** :

|                      1                      |                      2                      |                      3                      |                      4                      |                      5                      |
| :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades_sorted.svg) | ![h:180px](./images/7_of_spades_sorted.svg) | ![h:180px](./images/8_of_spades_sorted.svg) | ![h:180px](./images/9_of_spades_sorted.svg) |

Progression naturelle du plus petit au plus grand.

### La notion de tri stable (1/3)

**Définition** : un tri est **stable** si deux éléments égaux conservent leur
ordre relatif d'origine.

**Pourquoi est-ce important ?**

Quand on trie uniquement par valeur, que se passe-t-il avec deux cartes de même
valeur mais de couleurs différentes ?

### La notion de tri stable (2/3)

**Liste initiale** :

|                  1                   |                  2                   |                  3                  |                  4                   |
| :----------------------------------: | :----------------------------------: | :---------------------------------: | :----------------------------------: |
| ![h:180px](./images/7_of_spades.svg) | ![h:180px](./images/5_of_spades.svg) | ![h:180px](./images/5_of_clubs.svg) | ![h:180px](./images/3_of_spades.svg) |

Ordre : **7♠, 5♠, 5♣, 3♠**

### La notion de tri stable (3/3)

**Avec un tri stable** :

|                      1                      |                      2                      |                     3                      |                      4                      |
| :-----------------------------------------: | :-----------------------------------------: | :----------------------------------------: | :-----------------------------------------: |
| ![h:180px](./images/3_of_spades_sorted.svg) | ![h:180px](./images/5_of_spades_sorted.svg) | ![h:180px](./images/5_of_clubs_sorted.svg) | ![h:180px](./images/7_of_spades_sorted.svg) |

Ordre : **3♠, 5♠, 5♣, 7♠**

## Les algorithmes de tri simples

<!-- _class: lead -->

### Conventions visuelles

Dans les visualisations qui suivent, code couleur pour comprendre l'état des
cartes :

|               Normale                |                 Sélectionnée                  |                    Triée                    |
| :----------------------------------: | :-------------------------------------------: | :-----------------------------------------: |
| ![h:180px](./images/6_of_spades.svg) | ![h:180px](./images/6_of_spades_selected.svg) | ![h:180px](./images/6_of_spades_sorted.svg) |
|           Pas encore triée           |             Actuellement comparée             |            À sa position finale             |

### Tri par sélection (selection sort) (1/2)

**Principe** : ressemble à la façon naturelle de trier.

1. Chercher le plus petit élément de la liste.
2. Le placer au début.
3. Chercher le plus petit élément parmi ceux qui restent.
4. Le placer en deuxième position.
5. Continuer jusqu'à ce que tous les éléments soient triés.

**Pourquoi "tri par sélection" ?** À chaque étape, on **sélectionne** le plus
petit élément.

### Tri par sélection (selection sort) (2/2)

**Avantage** : simplicité conceptuelle, fait ce qu'un humain ferait
intuitivement.

**Inconvénient** : doit toujours parcourir tous les éléments restants pour
trouver le minimum.

Le nombre de comparaisons est toujours le même, quel que soit l'état initial de
la liste.

### Tri par sélection (selection sort) - Étape initiale

|                  1                   |                  2                   |                  3                   |                  4                   |                  5                   |
| :----------------------------------: | :----------------------------------: | :----------------------------------: | :----------------------------------: | :----------------------------------: |
| ![h:180px](./images/7_of_spades.svg) | ![h:180px](./images/3_of_spades.svg) | ![h:180px](./images/9_of_spades.svg) | ![h:180px](./images/2_of_spades.svg) | ![h:180px](./images/8_of_spades.svg) |

Ordre : **7, 3, 9, 2, 8**

### Tri par sélection (selection sort) - Passage 1 : chercher

**Chercher le minimum dans toute la liste**. On trouve le **2** (position 4) qui
doit être échangé avec le **7** (position 1).

|                       1                       |                  2                   |                  3                   |                       4                       |                  5                   |
| :-------------------------------------------: | :----------------------------------: | :----------------------------------: | :-------------------------------------------: | :----------------------------------: |
| ![h:180px](./images/7_of_spades_selected.svg) | ![h:180px](./images/3_of_spades.svg) | ![h:180px](./images/9_of_spades.svg) | ![h:180px](./images/2_of_spades_selected.svg) | ![h:180px](./images/8_of_spades.svg) |

### Tri par sélection (selection sort) - Passage 1 : échanger

**Échange du 7 et du 2**. Le **2** est maintenant à sa position finale.

|                      1                      |                  2                   |                  3                   |                  4                   |                  5                   |
| :-----------------------------------------: | :----------------------------------: | :----------------------------------: | :----------------------------------: | :----------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades.svg) | ![h:180px](./images/9_of_spades.svg) | ![h:180px](./images/7_of_spades.svg) | ![h:180px](./images/8_of_spades.svg) |

### Tri par sélection (selection sort) - Passage 2 : chercher

**Chercher le minimum dans les positions 2 à 5**. On trouve le **3** (position
2), déjà à la bonne position.

|                      1                      |                       2                       |                  3                   |                  4                   |                  5                   |
| :-----------------------------------------: | :-------------------------------------------: | :----------------------------------: | :----------------------------------: | :----------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades_selected.svg) | ![h:180px](./images/9_of_spades.svg) | ![h:180px](./images/7_of_spades.svg) | ![h:180px](./images/8_of_spades.svg) |

### Tri par sélection (selection sort) - Passage 2 : déjà en place

**Pas d'échange nécessaire**. Le **3** est maintenant à sa position finale.

|                      1                      |                      2                      |                  3                   |                  4                   |                  5                   |
| :-----------------------------------------: | :-----------------------------------------: | :----------------------------------: | :----------------------------------: | :----------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades_sorted.svg) | ![h:180px](./images/9_of_spades.svg) | ![h:180px](./images/7_of_spades.svg) | ![h:180px](./images/8_of_spades.svg) |

### Tri par sélection (selection sort) - Passage 3 : chercher

**Chercher le minimum dans les positions 3 à 5**. On trouve le **7**
(position 4) qui doit être échangé avec le **9** (position 3).

|                      1                      |                      2                      |                       3                       |                       4                       |                  5                   |
| :-----------------------------------------: | :-----------------------------------------: | :-------------------------------------------: | :-------------------------------------------: | :----------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades_sorted.svg) | ![h:180px](./images/9_of_spades_selected.svg) | ![h:180px](./images/7_of_spades_selected.svg) | ![h:180px](./images/8_of_spades.svg) |

### Tri par sélection (selection sort) - Passage 3 : échanger

**Échange du 9 et du 7**. Le **7** est maintenant à sa position finale.

|                      1                      |                      2                      |                      3                      |                  4                   |                  5                   |
| :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: | :----------------------------------: | :----------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades_sorted.svg) | ![h:180px](./images/7_of_spades_sorted.svg) | ![h:180px](./images/9_of_spades.svg) | ![h:180px](./images/8_of_spades.svg) |

### Tri par sélection (selection sort) - Passage 4 : chercher

**Chercher le minimum dans les positions 4 à 5**. On trouve le **8**
(position 5) qui doit être échangé avec le **9** (position 4).

|                      1                      |                      2                      |                      3                      |                       4                       |                       5                       |
| :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: | :-------------------------------------------: | :-------------------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades_sorted.svg) | ![h:180px](./images/7_of_spades_sorted.svg) | ![h:180px](./images/9_of_spades_selected.svg) | ![h:180px](./images/8_of_spades_selected.svg) |

### Tri par sélection (selection sort) - Passage 4 : échanger

**Échange du 9 et du 8**. Le **8** est maintenant à sa position finale.

|                      1                      |                      2                      |                      3                      |                      4                      |                  5                   |
| :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: | :----------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades_sorted.svg) | ![h:180px](./images/7_of_spades_sorted.svg) | ![h:180px](./images/8_of_spades_sorted.svg) | ![h:180px](./images/9_of_spades.svg) |

### Tri par sélection (selection sort) - Terminé

**Le dernier élément est automatiquement trié**. Toutes les cartes sont
maintenant à leur position finale.

|                      1                      |                      2                      |                      3                      |                      4                      |                      5                      |
| :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: | :-----------------------------------------: |
| ![h:180px](./images/2_of_spades_sorted.svg) | ![h:180px](./images/3_of_spades_sorted.svg) | ![h:180px](./images/7_of_spades_sorted.svg) | ![h:180px](./images/8_of_spades_sorted.svg) | ![h:180px](./images/9_of_spades_sorted.svg) |

### Tri par insertion (insertion sort)

### Tri à bulles (bubble sort)

## Les algorithmes de tri avancés

### Tri rapide (quicksort)

### Tri fusion (mergesort)

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## À vous de jouer !

- (Re)lire le contenu de cours.
- Lire les exemples de code et les descriptions.
- Faire les exercices.
- Poser des questions si nécessaire. ➡️ [Visualiser le contenu complet sur
  GitHub.][contenu-complet-sur-github]

**N'hésitez pas à vous entraidez si vous avez des difficultés !**

![bg right:40%][illustration-a-vous-de-jouer]

## Sources

- [Illustration principale][illustration-principale] par
  [Amanda Jones](https://unsplash.com/fr/@amandagraphc) sur
  [Unsplash](https://unsplash.com/fr/photos/une-pile-de-cartes-a-jouer-assises-les-unes-sur-les-autres-P787-xixGio)
- [Illustration][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/low-angle-view-of-ball-shoots-in-the-ring-j6brni7fpvs)

---

- [Illustration][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/white-sony-ps4-dualshock-controller-over-persons-palm-FJFPuE1MAOM)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/07-algorithmes-de-tri/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1541278107931-e006523892df?fit=crop&h=720
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
