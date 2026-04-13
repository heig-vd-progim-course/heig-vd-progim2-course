---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Quiz sur le contenu Algorithmes de tri pour le cours ProgIM2 enseigné à la
  HEIG-VD, Suisse
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/07-algorithmes-de-tri/quiz.html
header: "[**Algorithmes de tri - Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Algorithmes de tri - Quiz

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

_Cette présentation est un quiz pour tester ses connaissances sur le chapitre en
cours. Pour plus de détails, consultez le [contenu complet sur
GitHub][contenu-complet-sur-github]._

## Question 1 - Donnée

**Pourquoi le tri est-il important en programmation ?**

- **A.** Il permet d'afficher les données plus rapidement.
- **B.** Il permet d'utiliser la recherche binaire, beaucoup plus efficace que
  la recherche linéaire.
- **C.** Il est obligatoire pour stocker des données dans un tableau.
- **D.** Il réduit la taille des données en mémoire.

## Question 1 - Réponse

**Réponse correcte : B**

La recherche binaire nécessite des données triées et réduit drastiquement le
nombre de comparaisons :

| Éléments  | Recherche linéaire | Recherche binaire |
| :-------- | :----------------- | :---------------- |
| 1'000     | Jusqu'à 1'000      | Maximum 10        |
| 1'000'000 | Jusqu'à 1'000'000  | Maximum 20        |

Le tri est un prérequis pour de nombreux algorithmes efficaces.

## Question 2 - Donnée

**Prédiction : tri par sélection**

Quelles sont les étapes du tri par sélection pour trier `[5, 3, 1, 4, 2]` en
ordre croissant ?

- **A.** Chercher le minimum et le placer au début, puis recommencer sur le
  reste non trié.
- **B.** Comparer chaque paire adjacente et échanger si nécessaire.
- **C.** Diviser le tableau en deux, trier chaque moitié, puis fusionner.
- **D.** Insérer chaque élément à sa position correcte dans la partie triée.

## Question 2 - Réponse

**Réponse correcte : A** - Sélectionner le minimum, le placer, recommencer.

```text
[5, 3, 1, 4, 2]  -> min = 1 -> swap(5,1) -> [1, 3, 5, 4, 2]
[1, 3, 5, 4, 2]  -> min = 2 -> swap(3,2) -> [1, 2, 5, 4, 3]
[1, 2, 5, 4, 3]  -> min = 3 -> swap(5,3) -> [1, 2, 3, 4, 5]
[1, 2, 3, 4, 5]  -> min = 4 -> pas de swap
[1, 2, 3, 4, 5]  -> terminé
```

A chaque étape, on **sélectionne** le plus petit élément restant et on le place
à la bonne position.

## Question 3 - Donnée

**Prédiction : tri à bulles**

Comment fonctionne le tri à bulles ?

- **A.** On sélectionne le minimum et on le place au début.
- **B.** On compare chaque paire d'éléments adjacents et on les échange si
  nécessaire, en répétant jusqu'à ce que le tableau soit trié.
- **C.** On divise le tableau en deux, on trie chaque moitié, puis on fusionne.
- **D.** On choisit un pivot et on partitionne le tableau autour de ce pivot.

## Question 3 - Réponse

**Réponse correcte : B** - Comparer les paires adjacentes et échanger.

```text
[5, 3, 1, 4, 2]
 ^  ^            -> swap -> [3, 5, 1, 4, 2]
    ^  ^         -> swap -> [3, 1, 5, 4, 2]
       ^  ^      -> swap -> [3, 1, 4, 5, 2]
          ^  ^   -> swap -> [3, 1, 4, 2, 5]  -> 5 est à sa place
```

Les plus grands éléments "remontent" comme des bulles vers la fin du tableau. On
répète jusqu'à ce qu'aucun échange ne soit nécessaire.

## Question 4 - Donnée

**Complétion : tri par sélection en Java**

Complétez le code du tri par sélection :

```java
void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] _______ array[minIndex]) {
                _______ = j;
            }
        }
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
```

## Question 4 - Réponse

**Réponse correcte :**

```java
void selectionSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < array.length; j++) {
            if (array[j] < array[minIndex]) {  // < pour tri croissant
                minIndex = j;                   // mettre à jour l'index
            }
        }
        int temp = array[i];
        array[i] = array[minIndex];
        array[minIndex] = temp;
    }
}
```

On cherche le minimum (`<`) et on met à jour `minIndex` lorsqu'on en trouve un
plus petit.

## Question 5 - Donnée

**Complétion : tri rapide (quicksort)**

Quel est le principe du tri rapide ?

- **A.** Choisir un pivot, partitionner le tableau en éléments plus petits et
  plus grands que le pivot, puis trier récursivement chaque partition.
- **B.** Diviser le tableau en deux moitiés égales, trier chaque moitié, puis
  fusionner les résultats.
- **C.** Sélectionner le minimum à chaque itération et le placer au début.
- **D.** Comparer les éléments adjacents et les échanger si nécessaire.

## Question 5 - Réponse

**Réponse correcte : A** - Pivot + partition + récursion

```text
[3, 6, 8, 10, 1, 2, 1]  pivot = 3
    partition:
    [1, 2, 1]  3  [6, 8, 10]
    récursion sur chaque partie...
```

Le tri rapide utilise la stratégie **diviser pour régner** :

1. Choisir un **pivot**.
2. **Partitionner** : éléments < pivot à gauche, > pivot à droite.
3. **Trier récursivement** chaque partition.

La réponse B décrit le tri **fusion** (mergesort).

## Question 6 - Donnée

**Comparaison : tri rapide vs tri fusion**

Quelle est la différence principale entre le tri rapide (quicksort) et le tri
fusion (mergesort) ?

- **A.** Le quicksort est toujours plus rapide.
- **B.** Le mergesort divise en moitiés égales puis fusionne ; le quicksort
  partitionne autour d'un pivot.
- **C.** Le mergesort ne fonctionne que sur des tableaux d'entiers.
- **D.** Le quicksort n'est pas récursif.

## Question 6 - Réponse

**Réponse correcte : B**

| Aspect     | Tri rapide (quicksort)      | Tri fusion (mergesort)        |
| :--------- | :-------------------------- | :---------------------------- |
| Division   | Autour d'un pivot (inégale) | En deux moitiés (égale)       |
| Travail    | Lors de la partition        | Lors de la fusion             |
| Mémoire    | En place (peu de mémoire)   | Tableau auxiliaire nécessaire |
| Complexité | O(n log n) en moyenne       | O(n log n) garanti            |

Les deux utilisent "diviser pour régner" mais de manière différente.

## Question 7 - Donnée

**Complétion : Comparable en Java**

Complétez le code pour permettre le tri d'objets `Plant` par nom :

```java
class Plant __________ Comparable<Plant> {
    String name;

    @Override
    public int __________(Plant other) {
        return this.name.compareTo(other.name);
    }
}

List<Plant> plants = new ArrayList<>();
plants.add(new Plant("Tomate"));
plants.add(new Plant("Carotte"));
Collections.sort(plants);
```

## Question 7 - Réponse

**Réponse correcte :**

```java
class Plant implements Comparable<Plant> {
    String name;

    @Override
    public int compareTo(Plant other) {
        return this.name.compareTo(other.name);
    }
}
```

- `implements Comparable<Plant>` : indique que `Plant` peut être comparé.
- `compareTo()` retourne un entier négatif, zéro ou positif :
  - Négatif : `this` < `other`
  - Zéro : `this` == `other`
  - Positif : `this` > `other`

## Question 8 - Donnée

**Prédiction : Comparator**

Que va afficher ce code ?

```java
List<String> fruits = new ArrayList<>();
fruits.add("Banane");
fruits.add("Pomme");
fruits.add("Kiwi");

fruits.sort((a, b) -> a.length() - b.length());
System.out.println(fruits);
```

- **A.** `[Banane, Kiwi, Pomme]`
- **B.** `[Kiwi, Pomme, Banane]`
- **C.** `[Pomme, Banane, Kiwi]`
- **D.** `[Kiwi, Banane, Pomme]`

## Question 8 - Réponse

**Réponse correcte : B** - `[Kiwi, Pomme, Banane]`

Le comparateur `(a, b) -> a.length() - b.length()` trie par **longueur
croissante** :

- `"Kiwi"` : 4 lettres
- `"Pomme"` : 5 lettres
- `"Banane"` : 6 lettres

Un `Comparator` permet de trier selon un critère différent de l'ordre naturel,
sans modifier la classe des objets.

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Markus Spiske](https://unsplash.com/@markusspiske) sur
  [Unsplash](https://unsplash.com/photos/blue-and-white-logo-guessing-game-iar-afB0QQw)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/07-algorithmes-de-tri/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1611519541067-46c8f2d05f11?fit=crop&h=720
