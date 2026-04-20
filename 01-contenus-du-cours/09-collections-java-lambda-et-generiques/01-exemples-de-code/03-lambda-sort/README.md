# Exemple 03 - Lambda avec sort

**Objectif pédagogique :** comprendre comment utiliser `sort` avec une lambda
pour trier une liste selon un critère personnalisé.

**Concepts illustrés :**

- Utilisation de `sort` avec un `Comparator` lambda.
- Tri par différents critères (alphabétique, longueur, inverse).
- Comparaison entre `Comparator` anonyme et lambda.

## Description

Cet exemple montre comment trier une liste en passant une expression lambda
comme `Comparator`. Le `Comparator` est une interface fonctionnelle avec une
méthode `compare(T a, T b)` qui retourne un entier négatif, zéro ou positif.

## Code

Le fichier `SortLambdaDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== sort avec lambda ===
Liste initiale : [Menthe, Basilic, Tomate, Persil, Ail]

Tri alphabétique :
[Ail, Basilic, Menthe, Persil, Tomate]

Tri par longueur de nom :
[Ail, Menthe, Persil, Tomate, Basilic]

Tri alphabétique inverse :
[Tomate, Persil, Menthe, Basilic, Ail]
```
