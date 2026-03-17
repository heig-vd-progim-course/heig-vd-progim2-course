# Exemples de code - Algorithmes de tri

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Voici quelques informations relatives à ce contenu.
>
> **Ressources annexes**
>
> - Support de cours : [Retour au contenu principal](../README.md).
> - Exercices : [Accéder aux exercices](../02-exercices/).

## Table des matières

- [Table des matières](#table-des-matières)
- [Introduction](#introduction)
- [Liste des exemples](#liste-des-exemples)
  - [01 - Tri par sélection](#01---tri-par-sélection)
  - [02 - Tri par insertion](#02---tri-par-insertion)
  - [03 - Tri à bulles](#03---tri-à-bulles)
  - [04 - Tri rapide](#04---tri-rapide)
  - [05 - Tri fusion](#05---tri-fusion)

## Introduction

Cette section contient des exemples de code illustrant les différents
algorithmes de tri présentés dans le cours. Chaque exemple est contenu dans un
fichier `Main.java` autonome que vous pouvez copier, compiler et exécuter
directement.

**Objectif** : Ces exemples montrent comment implémenter chaque algorithme de
tri pour trier un tableau d'entiers (`int[]`). Ils affichent le tableau avant et
après le tri pour observer le résultat.

## Liste des exemples

### 01 - Tri par sélection

**Fichier** : [01-tri-selection/Main.java](./01-tri-selection/Main.java)

**Description** : Implémentation du tri par sélection. L'algorithme trouve le
plus petit élément et le place au début, puis recommence avec les éléments
restants.

### 02 - Tri par insertion

**Fichier** : [02-tri-insertion/Main.java](./02-tri-insertion/Main.java)

**Description** : Implémentation du tri par insertion. L'algorithme construit
progressivement une partie triée en insérant chaque élément à sa place.

### 03 - Tri à bulles

**Fichier** : [03-tri-bulles/Main.java](./03-tri-bulles/Main.java)

**Description** : Implémentation du tri à bulles. Les plus grandes valeurs
"remontent" vers la fin comme des bulles dans l'eau.

### 04 - Tri rapide

**Fichier** : [04-tri-rapide/Main.java](./04-tri-rapide/Main.java)

**Description** : Implémentation du tri rapide (quicksort). Utilise un pivot
pour partitionner le tableau et trie récursivement.

### 05 - Tri fusion

**Fichier** : [05-tri-fusion/Main.java](./05-tri-fusion/Main.java)

**Description** : Implémentation du tri fusion (mergesort). Divise le tableau en
deux, trie chaque moitié, puis fusionne les résultats.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
