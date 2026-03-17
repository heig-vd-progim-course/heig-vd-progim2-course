# Exercice 01 - Tri par sélection

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

## Objectif

Implémenter le tri par sélection pour trier un tableau de cartes à jouer par
valeur croissante.

## Consigne

### Étape 1 : Créer la classe Card

Créez une classe `Card` avec les attributs et méthodes suivants :

**Attributs** :

- `value` (int) : la valeur de la carte (1-13)
- `suit` (char) : la couleur de la carte (♠ ♥ ♦ ♣)

**Constructeur** :

- `Card(int value, char suit)` : initialise une carte avec une valeur et une
  couleur

**Méthode** :

- `toString()` : retourne une chaîne de caractères représentant la carte (ex:
  "7♥" pour un 7 de cœur)

**Méthodes utilitaires** (pour accéder aux attributs) :

- `getValue()` : retourne la valeur de la carte
- `getSuit()` : retourne la couleur de la carte

### Étape 2 : Implémenter le tri par sélection

Dans la classe `Main`, créez une méthode :

- `triSelection(Card[] cartes)` : trie un tableau de cartes par valeur
  croissante en utilisant l'algorithme de tri par sélection

**Principe du tri par sélection** :

1. Chercher la carte avec la plus petite valeur
2. La placer au début du tableau
3. Chercher la carte avec la plus petite valeur parmi celles qui restent
4. La placer en deuxième position
5. Continuer jusqu'à ce que toutes les cartes soient triées

### Étape 3 : Tester votre implémentation

Dans la méthode `main()`, créez un tableau de cartes mélangées et utilisez votre
méthode de tri pour les trier. Affichez le tableau avant et après le tri.

**Exemple de sortie attendue** :

```
=== Tri par sélection de cartes ===
Avant le tri : [7♥, 3♠, 9♦, 2♣, 8♥]
Après le tri : [2♣, 3♠, 7♥, 8♥, 9♦]
```

## Corrigé

Le corrigé est disponible dans le dossier [corrige/](./corrige/).

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
