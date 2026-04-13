# Exemple 08 - Itérateur et suppression sécurisée

**Objectif pédagogique :** comprendre l'utilisation d'un itérateur pour modifier
une collection pendant le parcours.

**Concepts illustrés :**

- Création d'un itérateur avec `iterator()`
- Parcours avec `hasNext()` et `next()`
- Suppression sécurisée avec `it.remove()`
- Différence entre `it.remove()` et `collection.remove()`

## Description

Cet exemple montre comment utiliser un `Iterator` pour parcourir une liste et
supprimer des éléments de manière sécurisée. C'est la seule façon correcte de
modifier une collection pendant son parcours, contrairement à l'utilisation de
`collection.remove()` dans une boucle `for-each` qui provoque une
`ConcurrentModificationException`.

## Code

Le fichier `IteratorDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== Itérateur : parcours simple ===
Plante : Tomate
Plante : Carotte
Plante : Thym
Plante : Basilic
Plante : Tournesol
Plante : Tomate

=== Suppression avec itérateur ===
Plantes avant : [Tomate, Carotte, Thym, Basilic, Tournesol, Tomate]
Suppression de tous les noms commençant par T...
Plantes après : [Carotte, Basilic]
```

## Points clés à retenir

- `iterator()` crée un itérateur pour parcourir la collection.
- `hasNext()` vérifie s'il reste des éléments, `next()` retourne l'élément
  courant.
- Utilisez `it.remove()` (et jamais `collection.remove()`) pour supprimer
  pendant l'itération.
- L'itérateur que l'on utilise est indispensable quand on doit modifier une
  collection pendant le parcours.

---

**Exemple suivant :** [09-choisir-collection](../09-choisir-collection/)
