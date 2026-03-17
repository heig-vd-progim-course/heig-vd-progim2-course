# Exercice 03 - Tri à bulles

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Objectif

Implémenter le tri à bulles pour trier un tableau de cartes à jouer par valeur
croissante.

## Consigne

### Étape 1 : Créer la classe Card

Créez une classe `Card` avec les mêmes attributs et méthodes que dans l'exercice
précédent (voir [Exercice 01](../01-tri-selection/README.md)).

### Étape 2 : Implémenter le tri à bulles

Dans la classe `Main`, créez une méthode :

- `triBulles(Card[] cartes)` : trie un tableau de cartes par valeur croissante
  en utilisant l'algorithme de tri à bulles

**Principe du tri à bulles** :

1. Parcourir le tableau et comparer les cartes adjacentes
2. Si deux cartes adjacentes sont dans le mauvais ordre, les échanger
3. Les cartes avec les plus grandes valeurs "remontent" vers la fin
4. Répéter jusqu'à ce qu'aucun échange ne soit nécessaire

**Analogie** : C'est comme des bulles d'air dans l'eau qui remontent à la
surface. Les plus grandes valeurs remontent progressivement vers la fin du
tableau.

### Étape 3 : Tester votre implémentation

Dans la méthode `main()`, créez un tableau de cartes mélangées et utilisez votre
méthode de tri pour les trier. Affichez le tableau avant et après le tri.

**Exemple de sortie attendue** :

```
=== Tri à bulles de cartes ===
Avant le tri : [7♥, 3♠, 9♦, 2♣, 8♥]
Après le tri : [2♣, 3♠, 7♥, 8♥, 9♦]
```

## Corrigé

Le corrigé est disponible dans le dossier [corrige/](./corrige/).

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
