# Exercice 05 - Tri fusion

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Objectif

Implémenter le tri fusion (mergesort) pour trier un tableau de cartes à jouer
par valeur croissante.

## Consigne

### Étape 1 : Créer la classe Card

Créez une classe `Card` avec les mêmes attributs et méthodes que dans l'exercice
précédent (voir [Exercice 01](../01-tri-selection/README.md)).

### Étape 2 : Implémenter le tri fusion

Dans la classe `Main`, créez deux méthodes :

- `triFusion(Card[] cartes, int debut, int fin)` : trie un tableau de cartes par
  valeur croissante en utilisant l'algorithme de tri fusion
- `fusionner(Card[] cartes, int debut, int milieu, int fin)` : méthode
  auxiliaire qui fusionne deux parties triées du tableau

**Principe du tri fusion** :

1. Diviser le tableau en deux moitiés
2. Trier récursivement chaque moitié
3. Fusionner les deux moitiés triées en une seule partie triée

**Important** : Le tri fusion utilise la récursivité et nécessite des tableaux
temporaires pour la fusion.

### Étape 3 : Tester votre implémentation

Dans la méthode `main()`, créez un tableau de cartes mélangées et utilisez votre
méthode de tri pour les trier. Affichez le tableau avant et après le tri.

**Exemple de sortie attendue** :

```
=== Tri fusion de cartes ===
Avant le tri : [7♥, 3♠, 9♦, 2♣, 8♥]
Après le tri : [2♣, 3♠, 7♥, 8♥, 9♦]
```

## Corrigé

Le corrigé est disponible dans le dossier [corrige/](./corrige/).

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
