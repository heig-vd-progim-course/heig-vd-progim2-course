# Exemple 01 - Lambda avec forEach

**Objectif pédagogique :** comprendre la syntaxe d'une expression lambda et son
utilisation avec `forEach`.

**Concepts illustrés :**

- Syntaxe des expressions lambda.
- Utilisation de `forEach` sur une `List`.
- Comparaison entre boucle `for-each` classique et `forEach` avec lambda.

## Description

Cet exemple montre comment remplacer une boucle `for-each` classique par un
appel à `forEach` avec une expression lambda. La lambda
`plant -> System.out.println(plant)` est un `Consumer<String>` qui est appliqué
à chaque élément de la liste.

## Code

Le fichier `ForEachDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== forEach avec lambda ===
Avec boucle for-each :
  - Tomate
  - Basilic
  - Menthe
  - Persil

Avec forEach et lambda :
  - Tomate
  - Basilic
  - Menthe
  - Persil

Avec forEach et bloc lambda :
  1. TOMATE
  2. BASILIC
  3. MENTHE
  4. PERSIL
```
