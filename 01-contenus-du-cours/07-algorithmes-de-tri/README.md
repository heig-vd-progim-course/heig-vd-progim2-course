# Algorithmes de tri

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Voici quelques informations relatives à ce contenu.
>
> **Ressources annexes**
>
> - Autres formats du support de cours : [Présentation (web)][presentation-web]
>   · [Présentation (PDF)][presentation-pdf]
> - Exemples de code : [Accéder au contenu](./01-exemples-de-code/)
> - Exercices : [Accéder au contenu](./02-exercices/)
> - Mini-projet : [Accéder au contenu](./03-mini-projet/)
> - Quiz : [Accéder au contenu][quiz-web]
>
> **Objectifs**
>
> À l'issue de cette séance, les personnes qui étudient devraient être capables
> de :
>
> - Expliquer pourquoi le tri de données est important en programmation.
> - Identifier les critères de comparaison pour trier des objets.
> - Différencier tri croissant et tri décroissant.
> - Utiliser des comparateurs pour trier selon différents critères.
> - Appliquer plusieurs stratégies de tri sur une même collection.
> - Expliquer le fonctionnement du tri par sélection.
> - Expliquer le fonctionnement du tri par insertion.
> - Expliquer le fonctionnement du tri à bulles.
> - Expliquer le fonctionnement du tri rapide (quicksort).
> - Expliquer le fonctionnement du tri fusion (mergesort).
> - Reconnaître les situations nécessitant un tri personnalisé.
> - Implémenter l'interface `Comparable<T>` dans une classe.
> - Définir la méthode `compareTo()` pour établir un ordre naturel.
> - Utiliser `compareTo()` pour comparer des objets.
> - Trier des collections d'objets implémentant `Comparable`.
> - Créer des objets `Comparator<T>` pour définir des ordres de tri alternatifs.
> - Différencier `Comparable` et `Comparator`.
>
> **Méthodes d'enseignement et d'apprentissage**
>
> Les méthodes d'enseignement et d'apprentissage utilisées pour animer la séance
> sont les suivantes :
>
> - Présentation magistrale.
> - Discussions collectives.
> - Travail en autonomie.
>
> **Méthodes d'évaluation**
>
> L'évaluation prend la forme d'exercices et d'un mini-projet à réaliser en
> autonomie en classe ou à la maison.
>
> L'évaluation se fait en utilisant les critères suivants :
>
> - Capacité à répondre avec justesse.
> - Capacité à argumenter.
> - Capacité à réaliser les tâches demandées.
> - Capacité à s'approprier les exemples de code.
> - Capacité à appliquer les exemples de code à des situations similaires.
>
> Les retours se font de la manière suivante :
>
> - Corrigé des exercices.
> - Corrigé du mini-projet.
>
> L'évaluation ne donne pas lieu à une note.

## Table des matières

- [Table des matières](#table-des-matières)
- [Objectifs](#objectifs)
- [Introduction : le problème de la recherche d'informations](#introduction--le-problème-de-la-recherche-dinformations)
  - [Chercher dans une base de données](#chercher-dans-une-base-de-données)
  - [Le tri comme solution](#le-tri-comme-solution)
- [Comprendre le tri avec des cartes à jouer](#comprendre-le-tri-avec-des-cartes-à-jouer)
  - [Observer avant d'agir](#observer-avant-dagir)
  - [Définir un critère de tri](#définir-un-critère-de-tri)
- [Les algorithmes de tri simples](#les-algorithmes-de-tri-simples)
  - [Tri par sélection (selection sort)](#tri-par-sélection-selection-sort)
  - [Tri par insertion (insertion sort)](#tri-par-insertion-insertion-sort)
  - [Tri à bulles (bubble sort)](#tri-à-bulles-bubble-sort)
- [Les algorithmes de tri avancés](#les-algorithmes-de-tri-avancés)
  - [Tri rapide (quicksort)](#tri-rapide-quicksort)
  - [Tri fusion (mergesort)](#tri-fusion-mergesort)
- [Comparer des objets en Java](#comparer-des-objets-en-java)
  - [L'interface Comparable\<T\>](#linterface-comparablet)
  - [L'interface Comparator\<T\>](#linterface-comparatort)
  - [Quand utiliser Comparable ou Comparator ?](#quand-utiliser-comparable-ou-comparator-)
- [Conclusion](#conclusion)
- [Exemples de code](#exemples-de-code)
- [Exercices](#exercices)
- [Mini-projet](#mini-projet)
- [À faire pour la prochaine séance](#à-faire-pour-la-prochaine-séance)

## Objectifs

Ce contenu de cours a pour objectifs de permettre aux personnes qui étudient de
comprendre les principes fondamentaux du tri de données, d'expliquer le
fonctionnement des principaux algorithmes de tri, et de maîtriser l'utilisation
des interfaces `Comparable<T>` et `Comparator<T>` en Java pour définir des
critères de tri personnalisés.

La liste complète des objectifs est disponible dans la section _"Objectifs"_ du
bloc d'information en haut de ce contenu.

## Introduction : le problème de la recherche d'informations

### Chercher dans une base de données

Nous devons souvent chercher des informations dans des bases de données.
Imaginez une application de contacts avec des milliers d'entrées, un système de
gestion de bibliothèque avec des millions de livres, ou une plateforme de
commerce électronique avec des centaines de milliers de produits. Comment
retrouver rapidement l'information recherchée ?

La façon la plus simple de chercher un élément dans une collection serait de
parcourir tous les éléments un par un jusqu'à trouver celui qu'on cherche. Cette
approche, appelée recherche linéaire, fonctionne mais devient très lente quand
la quantité de données augmente. Pour trouver un élément parmi un million
d'entrées, il faudrait dans le pire cas examiner un million d'éléments.

Historiquement, ce problème a toujours préoccupé l'humanité. Les bibliothèques
médiévales organisaient leurs manuscrits selon un système de classement, les
comptables tenaient des registres ordonnés, les botanistes cataloguaient leurs
spécimens. L'ordre facilitait la recherche et permettait de retrouver rapidement
ce qu'on cherchait.

### Le tri comme solution

Le tri répond à ce problème de recherche. Lorsque les données sont triées, la
recherche devient exponentiellement plus rapide. Avec la recherche binaire sur
des données triées, trouver un élément parmi un million d'entrées ne nécessite
que 20 comparaisons au maximum, au lieu d'un million.

Cette différence de performance est radicale. C'est la différence entre une
recherche instantanée et une recherche qui prend plusieurs secondes, voire
plusieurs minutes pour de très grandes quantités de données.

Le tri n'est pas seulement utile pour la recherche :

**Pour l'affichage** : présenter des données de manière ordonnée améliore
l'expérience utilisateur. Une liste de contacts alphabétique, un catalogue de
produits par prix, des articles de blog par date - l'ordre rend l'information
plus accessible.

**Pour l'analyse** : certaines analyses nécessitent des données triées. Par
exemple, pour calculer la médiane d'une série de valeurs, pour détecter des
doublons, ou pour regrouper des éléments similaires.

**Pour l'optimisation** : de nombreux algorithmes complexes utilisent le tri
comme étape préliminaire. Le tri peut transformer un problème difficile en un
problème simple à résoudre.

Cependant, le tri a un coût. Trier des millions d'éléments demande du temps et
des ressources. C'est pourquoi les informaticien.nes ont développé de nombreux
algorithmes de tri, chacun avec ses avantages et ses inconvénients selon le
contexte d'utilisation. Le choix de l'algorithme peut faire la différence entre
une application réactive et une application lente.

## Comprendre le tri avec des cartes à jouer

### Observer avant d'agir

Imaginez que vous recevez un jeu de cartes mélangées. Avant de commencer à
trier, vous observez naturellement les cartes pour comprendre quelle stratégie
adopter.

Voici un exemple de cartes désordonnées :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![7](./images/7_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

Cette représentation visuelle nous permet de voir immédiatement que les cartes
sont actuellement dans un ordre qui ne suit aucune logique apparente : 7, 3, 5,
2, 8, 4, 6, 9.

### Définir un critère de tri

Avant de trier, il faut décider **comment** trier. Dans le cas de cartes à
jouer, plusieurs critères sont possibles :

- **Par valeur croissante** : du plus petit au plus grand (2, 3, 4, 5, 6, 7, 8,
  9).
- **Par valeur décroissante** : du plus grand au plus petit (9, 8, 7, 6, 5, 4,
  3, 2).

Dans ce cours, nous nous concentrerons principalement sur le tri par valeur
croissante, car c'est le critère le plus simple à comprendre et à illustrer.
Cependant, les algorithmes présentés fonctionnent avec n'importe quel critère de
comparaison.

Voici le résultat attendu après un tri par valeur croissante :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![7](./images/7_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

Cette progression naturelle du plus petit au plus grand est facile à vérifier
visuellement et correspond à notre intuition du tri.

## Les algorithmes de tri simples

Les algorithmes de tri simples sont appelés ainsi parce qu'ils sont faciles à
comprendre et à implémenter. Ils fonctionnent bien pour de petites collections
de données. Cependant, leur performance devient problématique pour de grandes
quantités de données.

Ces algorithmes ont néanmoins une grande valeur pédagogique : ils permettent de
comprendre les principes de base du tri et illustrent différentes façons
d'aborder le même problème.

### Tri par sélection (selection sort)

Le tri par sélection est probablement l'algorithme de tri le plus intuitif. Son
principe ressemble à la façon dont beaucoup de personnes trient naturellement :

1. Chercher le plus petit élément de la liste.
2. Le placer au début.
3. Chercher le plus petit élément parmi ceux qui restent.
4. Le placer en deuxième position.
5. Continuer jusqu'à ce que tous les éléments soient triés.

**Visualisation avec des cartes**

Partons de nos cartes désordonnées :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![7](./images/7_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 1** : on cherche la plus petite carte dans toute la liste. C'est le 2
(position 4). On l'échange avec la première carte (le 7).

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts_selected.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![7](./images/7_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 2** : on cherche maintenant la plus petite carte parmi celles qui
restent (positions 2 à 8). C'est le 3 (position 2), qui est déjà à la bonne
place. Aucun échange nécessaire.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts.svg) | ![3](./images/3_of_hearts_selected.svg) | ![5](./images/5_of_hearts.svg) | ![7](./images/7_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 3** : on cherche la plus petite carte parmi les positions 3 à 8. C'est
le 4 (position 6). On l'échange avec la carte en position 3 (le 5).

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![4](./images/4_of_hearts_selected.svg) | ![7](./images/7_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 4** : on cherche la plus petite carte parmi les positions 4 à 8. C'est
le 5 (position 6). On l'échange avec la carte en position 4 (le 7).

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![5](./images/5_of_hearts_selected.svg) | ![8](./images/8_of_hearts.svg) | ![7](./images/7_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

En continuant ce processus, on obtient finalement :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![7](./images/7_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Réflexion sur le tri par sélection**

Pourquoi cet algorithme s'appelle-t-il "tri par sélection" ? Parce qu'à chaque
étape, on **sélectionne** le plus petit élément parmi ceux qui restent à trier.

L'avantage de cet algorithme est sa simplicité conceptuelle : il fait exactement
ce qu'un humain ferait intuitivement. Son inconvénient est qu'il doit toujours
parcourir tous les éléments restants pour trouver le minimum, même si la liste
est presque triée. Le nombre de comparaisons est toujours le même, quel que soit
l'état initial de la liste.

### Tri par insertion (insertion sort)

Le tri par insertion s'inspire de la façon dont on trie des cartes à jouer dans
la main. Imaginez que vous recevez des cartes une par une et que vous les
insérez au bon endroit dans votre main déjà triée.

Le principe :

1. On considère que le premier élément est déjà trié (une liste d'un élément est
   toujours triée).
2. On prend le deuxième élément et on l'insère au bon endroit parmi les éléments
   déjà triés.
3. On prend le troisième élément et on l'insère au bon endroit parmi les
   éléments déjà triés.
4. On continue jusqu'au dernier élément.

**Visualisation avec des cartes**

Partons à nouveau de nos cartes désordonnées :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![7](./images/7_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 1** : le 7 de cœur (position 1) est considéré comme déjà trié.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![7](./images/7_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 2** : on prend le 3 (position 2) et on l'insère au bon endroit. Le 3 est
plus petit que le 7, donc on le place avant.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![3](./images/3_of_hearts_selected.svg) | ![7](./images/7_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 3** : on prend le 5 (position 3) et on l'insère au bon endroit. Le 5 est
plus grand que le 3 mais plus petit que le 7, donc on le place entre les deux.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts_selected.svg) | ![7](./images/7_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 4** : on prend le 2 (position 4) et on l'insère au bon endroit. Le 2 est
le plus petit, donc on le place tout au début.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts_selected.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![7](./images/7_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

En continuant ce processus avec les cartes restantes, on obtient finalement la
liste triée.

**Réflexion sur le tri par insertion**

Le tri par insertion est particulièrement efficace quand la liste est presque
triée. Dans ce cas, chaque élément est déjà proche de sa position finale et
nécessite peu de déplacements. C'est pourquoi cet algorithme est souvent utilisé
comme étape finale d'algorithmes plus complexes, ou pour trier de petites
listes.

Une autre qualité du tri par insertion est qu'il est **stable** : deux éléments
égaux conservent leur ordre relatif après le tri. Cette propriété est importante
lorsqu'on trie des objets complexes où l'égalité ne signifie pas identité
complète.

### Tri à bulles (bubble sort)

Le tri à bulles tire son nom du fait que les plus grandes valeurs "remontent"
progressivement vers la fin de la liste, comme des bulles d'air dans l'eau.

Le principe :

1. On parcourt la liste et on compare chaque paire d'éléments adjacents.
2. Si deux éléments adjacents sont dans le mauvais ordre, on les échange.
3. On répète le processus jusqu'à ce qu'aucun échange ne soit nécessaire.

**Visualisation avec des cartes**

Partons à nouveau de nos cartes désordonnées :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![7](./images/7_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Premier passage - Étape 1** : on compare les cartes 1 et 2 (7 et 3). Le 7 est
plus grand que le 3, donc on les échange.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![3](./images/3_of_hearts_selected.svg) | ![7](./images/7_of_hearts_selected.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Premier passage - Étape 2** : on compare les cartes 2 et 3 (7 et 5). Le 7 est
plus grand que le 5, donc on les échange.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts_selected.svg) | ![7](./images/7_of_hearts_selected.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Premier passage - Étape 3** : on compare les cartes 3 et 4 (7 et 2). Le 7 est
plus grand que le 2, donc on les échange.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts_selected.svg) | ![7](./images/7_of_hearts_selected.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

En continuant ce processus sur toute la liste, le 8 (la plus grande valeur)
finira par "remonter" à la dernière position. Puis on recommence le processus,
et ainsi de suite jusqu'à ce que la liste soit complètement triée.

**Réflexion sur le tri à bulles**

Le tri à bulles a la réputation d'être l'algorithme de tri le moins efficace
parmi les algorithmes classiques. Il effectue de nombreux échanges inutiles et
est rarement utilisé en pratique pour des données réelles.

Cependant, il a un avantage : il est très simple à comprendre et à implémenter.
C'est pourquoi il est souvent enseigné comme premier algorithme de tri, même si
on ne devrait jamais l'utiliser en production. Sa principale valeur est
pédagogique.

## Les algorithmes de tri avancés

Les algorithmes de tri avancés utilisent des stratégies plus sophistiquées pour
améliorer les performances. Ils reposent souvent sur le principe de "diviser
pour régner" : diviser un problème complexe en sous-problèmes plus simples,
résoudre ces sous-problèmes, puis combiner les solutions.

### Tri rapide (quicksort)

Le tri rapide est l'un des algorithmes de tri les plus utilisés en pratique. Son
nom vient du fait qu'il est généralement très rapide, bien que sa performance
puisse varier selon les données.

Le principe :

1. Choisir un élément appelé "pivot".
2. Réorganiser la liste pour que tous les éléments plus petits que le pivot
   soient à gauche et tous les éléments plus grands soient à droite.
3. Appliquer récursivement le même processus aux sous-listes de gauche et de
   droite.

**Visualisation avec des cartes**

Partons de nos cartes désordonnées :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![7](./images/7_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 1** : choisissons le 5 (carte au milieu) comme pivot. On réorganise la
liste pour placer les cartes plus petites que 5 à gauche, et les cartes plus
grandes ou égales à 5 à droite.

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |            Carte 5             |            Carte 6             |            Carte 7             |            Carte 8             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![3](./images/3_of_hearts.svg) | ![2](./images/2_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![9](./images/9_of_hearts.svg) | ![5](./images/5_of_hearts_selected.svg) | ![7](./images/7_of_hearts.svg) | ![8](./images/8_of_hearts.svg) | ![6](./images/6_of_hearts.svg) |

Le pivot (5) est maintenant à sa position finale. On a deux sous-listes à trier
:

- À gauche du pivot (< 5) : 3, 2, 4, 3.
- À droite du pivot (≥ 5) : 7, 8, 6.

**Étape 2** : on applique récursivement le processus à chaque sous-liste. Pour
la sous-liste de gauche, on choisit le 4 comme pivot, pour la sous-liste de
droite, on choisit le 8 comme pivot. Et ainsi de suite jusqu'à obtenir une liste
complètement triée.

**Réflexion sur le tri rapide**

Le choix du pivot est crucial pour les performances du tri rapide. Un mauvais
choix de pivot (par exemple, toujours choisir le premier élément d'une liste
déjà triée) peut conduire à de très mauvaises performances. C'est pourquoi il
existe différentes stratégies pour choisir le pivot : élément du milieu, élément
aléatoire, médiane de trois éléments, etc.

Le tri rapide n'est pas stable : deux éléments égaux peuvent changer d'ordre
relatif pendant le tri. Cependant, il a l'avantage de trier "sur place" (in-
place), c'est-à-dire qu'il ne nécessite pas de copier tous les éléments dans une
nouvelle structure de données, ce qui économise de la mémoire.

### Tri fusion (mergesort)

Le tri fusion est un algorithme élégant qui illustre parfaitement le principe de
"diviser pour régner". Historiquement, il a été inventé par John von Neumann en
1945, l'un des pionniers de l'informatique.

Le principe :

1. Diviser la liste en deux moitiés.
2. Trier récursivement chaque moitié.
3. Fusionner les deux moitiés triées pour obtenir une liste triée complète.

**Visualisation conceptuelle avec des cartes**

Contrairement aux autres algorithmes, le tri fusion est plus difficile à
visualiser avec des cartes physiques car il nécessite de créer temporairement de
nouvelles piles de cartes. Voici néanmoins comment cela fonctionne :

**Étape 1 - Division** : on divise notre pile de 8 cartes en deux piles de 4
cartes.

Pile gauche :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![7](./images/7_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![2](./images/2_of_hearts.svg) |

Pile droite :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![8](./images/8_of_hearts.svg) | ![4](./images/4_of_hearts.svg) | ![6](./images/6_of_hearts.svg) | ![9](./images/9_of_hearts.svg) |

**Étape 2 - Subdivision** : on continue à diviser jusqu'à avoir des piles d'une
seule carte (une carte seule est toujours triée).

**Étape 3 - Fusion** : on commence à fusionner les petites piles triées pour
former des piles plus grandes mais toujours triées.

Par exemple, pour fusionner deux piles :

Pile gauche triée :

|            Carte 1             |            Carte 2             |
| :----------------------------: | :----------------------------: |
| ![3](./images/3_of_hearts.svg) | ![7](./images/7_of_hearts.svg) |

Pile droite triée :

|            Carte 1             |            Carte 2             |
| :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts.svg) | ![5](./images/5_of_hearts.svg) |

On compare les premières cartes de chaque pile (3 et 2), on prend la plus petite
(2) et on la place dans la nouvelle pile. Puis on compare à nouveau (3 et 5), on
prend la plus petite (3), et ainsi de suite.

Résultat de la fusion :

|            Carte 1             |            Carte 2             |            Carte 3             |            Carte 4             |
| :----------------------------: | :----------------------------: | :----------------------------: | :----------------------------: |
| ![2](./images/2_of_hearts.svg) | ![3](./images/3_of_hearts.svg) | ![5](./images/5_of_hearts.svg) | ![7](./images/7_of_hearts.svg) |

**Étape 4** : on continue à fusionner les piles de plus en plus grandes jusqu'à
obtenir une seule pile complètement triée.

**Réflexion sur le tri fusion**

Le tri fusion a des performances très prévisibles : il trie toujours à la même
vitesse, quelle que soit la distribution initiale des données. Contrairement au
tri rapide, il est stable et garantit de bonnes performances même dans le pire
cas.

Son principal inconvénient est qu'il nécessite de la mémoire supplémentaire pour
créer les piles temporaires lors de la fusion. Dans l'exemple ci-dessus, nous
avons dû créer de nouvelles piles pour fusionner les résultats. Ce n'est pas
toujours un problème en pratique, mais cela peut le devenir pour de très grandes
listes ou dans des environnements avec peu de mémoire disponible.

Le tri fusion est souvent utilisé quand on a besoin d'un tri stable et
prévisible, ou quand on trie des données accessibles séquentiellement (par
exemple, des données stockées sur disque dur ou provenant d'un flux réseau).

## Comparer des objets en Java

Jusqu'à présent, nous avons trié des cartes selon leur valeur numérique. Mais
comment Java sait-il comment comparer deux objets ? Comment peut-on définir
plusieurs façons de trier la même collection ?

### L'interface Comparable\<T\>

L'interface `Comparable<T>` permet de définir un **ordre naturel** pour une
classe. Lorsqu'une classe implémente `Comparable<T>`, elle déclare qu'il existe
une façon évidente et naturelle de comparer ses instances.

Par exemple, pour des cartes à jouer, l'ordre naturel pourrait être l'ordre par
valeur :

```java
public class Card implements Comparable<Card> {
    private int value;
    private String suit;

    @Override
    public int compareTo(Card other) {
        return Integer.compare(this.value, other.value);
    }
}
```

La méthode `compareTo()` doit retourner :

- Un nombre négatif si `this` est plus petit que `other`.
- Zéro si `this` est égal à `other`.
- Un nombre positif si `this` est plus grand que `other`.

Une fois que la classe implémente `Comparable<T>`, on peut simplement trier une
liste de cartes avec `Collections.sort(cards)` ou `cards.sort(null)`. Java
utilisera automatiquement la méthode `compareTo()` pour déterminer l'ordre.

### L'interface Comparator\<T\>

Mais que faire si on veut trier les mêmes cartes de différentes façons ? Par
exemple, parfois par valeur, parfois par couleur ? C'est là qu'intervient
l'interface `Comparator<T>`.

Un `Comparator<T>` est un objet externe qui définit une façon de comparer deux
objets. On peut créer autant de comparateurs qu'on veut pour la même classe :

```java
// Comparateur par valeur
Comparator<Card> byValue = (card1, card2) ->
    Integer.compare(card1.getValue(), card2.getValue());

// Comparateur par couleur
Comparator<Card> bySuit = (card1, card2) ->
    card1.getSuit().compareTo(card2.getSuit());

// Comparateur par couleur puis par valeur
Comparator<Card> bySuitThenValue = (card1, card2) -> {
    int suitComparison = card1.getSuit().compareTo(card2.getSuit());
    if (suitComparison != 0) {
        return suitComparison;
    }
    return Integer.compare(card1.getValue(), card2.getValue());
};
```

Pour utiliser un comparateur :

```java
cards.sort(byValue);      // Trier par valeur
cards.sort(bySuit);       // Trier par couleur
cards.sort(bySuitThenValue);  // Trier par couleur puis valeur
```

### Quand utiliser Comparable ou Comparator ?

**Utilisez `Comparable<T>` quand :**

- Il existe un ordre naturel évident pour votre classe.
- Cet ordre sera utilisé la plupart du temps.
- Vous contrôlez le code source de la classe.

Par exemple : des nombres, des dates, des chaînes de caractères ont tous un
ordre naturel.

**Utilisez `Comparator<T>` quand :**

- Vous voulez plusieurs façons de trier la même classe.
- L'ordre n'est pas naturel mais dépend du contexte.
- Vous ne contrôlez pas le code source de la classe.
- Vous voulez créer des ordres de tri complexes ou composés.

Par exemple : trier des personnes par nom, par âge, par salaire, ou par une
combinaison de ces critères.

**Dans la pratique**, il est courant d'avoir les deux : une classe implémente
`Comparable<T>` pour son ordre naturel le plus courant, et on crée des
`Comparator<T>` pour les ordres alternatifs selon les besoins.

## Conclusion

Le tri de données est une opération fondamentale en programmation, omniprésente
dans nos applications quotidiennes. À travers l'exemple concret des cartes à
jouer, nous avons exploré différentes façons d'aborder ce problème.

Les algorithmes de tri simples (sélection, insertion, bulles) nous apprennent
que même un problème simple peut être résolu de multiples façons, chacune avec
ses avantages et ses inconvénients. Ils nous montrent aussi que l'intuition
humaine peut être traduite en algorithmes, mais que ce qui semble naturel n'est
pas forcément le plus efficace.

Les algorithmes de tri avancés (quicksort, mergesort) illustrent des concepts
plus sophistiqués comme le principe de "diviser pour régner". Ils nous
enseignent qu'investir du temps dans une stratégie plus complexe peut se
traduire par des gains significatifs en performance, surtout pour de grandes
quantités de données.

Enfin, les interfaces `Comparable<T>` et `Comparator<T>` en Java nous rappellent
qu'en programmation orientée objet, la flexibilité est essentielle. Pouvoir
définir plusieurs façons de comparer et de trier les mêmes objets est une
capacité puissante qui rend nos programmes plus adaptables et réutilisables.

Au-delà des algorithmes eux-mêmes, le tri nous enseigne des leçons plus
générales : l'importance de choisir le bon outil pour le bon contexte, la
nécessité de comprendre les compromis entre simplicité et performance, et la
valeur d'une bonne abstraction pour rendre notre code flexible et maintenable.

## Exemples de code

Nous vous invitons à consulter les exemples de code associés à ce contenu de
cours pour mieux comprendre les concepts abordés.

Vous trouverez les exemples de code ici :
[Exemples de code](./01-exemples-de-code/).

## Exercices

Nous vous invitons maintenant à réaliser les exercices de la séance afin de
mettre en pratique les concepts abordés.

Vous trouverez les exercices et leur corrigé ici : [Exercices](./02-exercices/).

## Mini-projet

Nous vous invitons maintenant à réaliser le mini-projet de la séance afin de
mettre en pratique les concepts abordés.

Vous trouverez les détails du mini-projet ici :
[Mini-projet](./03-mini-projet/).

## À faire pour la prochaine séance

Chaque personne est libre de gérer son temps comme elle le souhaite. Cependant,
il est recommandé pour la prochaine séance de :

- Relire le support de cours si nécessaire.
- Relire les exemples de code et leur description pour bien comprendre les
  concepts.
- Finaliser les exercices qui n'ont pas été terminés en classe.
- Finaliser la partie du mini-projet qui n'a pas été terminée en classe.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
[quiz-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/07-algorithmes-de-tri/quiz.html
[presentation-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/07-algorithmes-de-tri/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/07-algorithmes-de-tri/07-algorithmes-de-tri-presentation.pdf
