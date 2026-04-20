# Exemple 06 - Référence de méthode

**Objectif pédagogique :** comprendre les références de méthode comme raccourci
pour des lambdas simples.

**Concepts illustrés :**

- Référence de méthode statique (`Class::method`).
- Référence de méthode d'instance (`object::method`).
- Référence de méthode d'instance arbitraire (`Class::method`).
- Comparaison entre lambda et référence de méthode.

## Description

Cet exemple montre que lorsqu'une lambda ne fait que transmettre son argument à
une méthode existante, on peut la remplacer par une référence de méthode. C'est
un raccourci syntaxique qui rend le code plus lisible.

## Code

Le fichier `MethodReferenceDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== Référence de méthode ===
Avec lambda :
Tomate
Basilic
Menthe

Avec référence de méthode (même résultat) :
Tomate
Basilic
Menthe

Tri avec lambda :
[Basilic, Menthe, Tomate]

Tri avec référence de méthode (même résultat) :
[Basilic, Menthe, Tomate]
```
