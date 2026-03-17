# Exercice 02 - Tri par insertion

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Objectif

Implémenter le tri par insertion pour trier un tableau de cartes à jouer par
valeur croissante.

## Consigne

### Étape 1 : Créer la classe Card

Créez une classe `Card` avec les mêmes attributs et méthodes que dans l'exercice
précédent (voir [Exercice 01](../01-tri-selection/README.md)).

### Étape 2 : Implémenter le tri par insertion

Dans la classe `Main`, créez une méthode :

- `triInsertion(Card[] cartes)` : trie un tableau de cartes par valeur
  croissante en utilisant l'algorithme de tri par insertion

**Principe du tri par insertion** :

1. Construire progressivement une partie triée du tableau
2. Pour chaque carte, l'insérer à sa place dans la partie déjà triée
3. Décaler les cartes plus grandes vers la droite pour faire de la place
4. Continuer jusqu'à ce que toutes les cartes soient triées

**Analogie** : C'est comme trier des cartes dans votre main. Vous prenez une
carte et vous la placez au bon endroit parmi celles déjà triées.

### Étape 3 : Tester votre implémentation

Dans la méthode `main()`, créez un tableau de cartes mélangées et utilisez votre
méthode de tri pour les trier. Affichez le tableau avant et après le tri.

**Exemple de sortie attendue** :

```
=== Tri par insertion de cartes ===
Avant le tri : [7♥, 3♠, 9♦, 2♣, 8♥]
Après le tri : [2♣, 3♠, 7♥, 8♥, 9♦]
```

## Corrigé

Le corrigé est disponible dans le dossier [corrige/](./corrige/).

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
