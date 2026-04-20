# Exemple 04 - Interface fonctionnelle Predicate

**Objectif pédagogique :** comprendre l'interface fonctionnelle `Predicate` et
son utilisation comme paramètre de méthode.

**Concepts illustrés :**

- Interface `Predicate<T>` et sa méthode `test()`.
- Passage d'un `Predicate` en paramètre de méthode.
- Combinaison de prédicats avec `and()` et `or()`.

## Description

Cet exemple montre comment utiliser `Predicate<T>` pour créer des critères de
filtrage réutilisables. Un `Predicate` est une interface fonctionnelle qui prend
un argument et retourne un `boolean`.

## Code

Le fichier `PredicateDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== Predicate : filtrage flexible ===
Nombres : [5, 12, 3, 18, 7, 25, 1, 30]

Pairs :
  [12, 18, 30]
Supérieurs à 10 :
  [12, 18, 25, 30]
Pairs ET > 10 :
  [12, 18, 30]
Pairs OU > 20 :
  [12, 18, 25, 30]
```
