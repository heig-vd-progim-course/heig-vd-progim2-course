# Exercice 04 - Tri rapide

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Objectif

Implémenter le tri rapide (quicksort) pour trier un tableau de cartes à jouer
par valeur croissante.

## Consigne

### Étape 1 : Créer la classe Card

Créez une classe `Card` avec les mêmes attributs et méthodes que dans l'exercice
précédent (voir [Exercice 01](../01-tri-selection/README.md)).

### Étape 2 : Implémenter le tri rapide

Dans la classe `Main`, créez deux méthodes :

- `triRapide(Card[] cartes, int debut, int fin)` : trie un tableau de cartes par
  valeur croissante en utilisant l'algorithme de tri rapide
- `partitionner(Card[] cartes, int debut, int fin)` : méthode auxiliaire qui
  partitionne le tableau autour d'un pivot

**Principe du tri rapide** :

1. Choisir un pivot (par exemple, la dernière carte)
2. Partitionner : placer les cartes < pivot à gauche, > pivot à droite
3. Placer le pivot à sa position finale
4. Trier récursivement les deux parties

**Important** : Le tri rapide utilise la récursivité. La méthode `triRapide()`
s'appelle elle-même sur les sous-tableaux.

### Étape 3 : Tester votre implémentation

Dans la méthode `main()`, créez un tableau de cartes mélangées et utilisez votre
méthode de tri pour les trier. Affichez le tableau avant et après le tri.

**Exemple de sortie attendue** :

```
=== Tri rapide de cartes ===
Avant le tri : [7♥, 3♠, 9♦, 2♣, 8♥]
Après le tri : [2♣, 3♠, 7♥, 8♥, 9♦]
```

## Corrigé

Le corrigé est disponible dans le dossier [corrige/](./corrige/).

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
