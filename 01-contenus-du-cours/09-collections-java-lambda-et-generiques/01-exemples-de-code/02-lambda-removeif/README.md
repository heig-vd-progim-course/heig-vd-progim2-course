# Exemple 02 - Lambda avec removeIf

**Objectif pédagogique :** comprendre comment `removeIf` simplifie la
suppression conditionnelle dans une collection.

**Concepts illustrés :**

- Utilisation de `removeIf` avec un `Predicate`.
- Comparaison avec l'itérateur pour la suppression sécurisée.
- Lambda retournant un `boolean`.

## Description

Cet exemple montre comment remplacer un itérateur avec suppression par un appel
à `removeIf`. Le `Predicate` passé en argument teste chaque élément et retourne
`true` pour les éléments à supprimer.

## Code

Le fichier `RemoveIfDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== removeIf avec lambda ===
Liste initiale : [3.2, 15.0, 7.5, 1.8, 22.0, 4.0]

Suppression des valeurs < 5.0 avec removeIf :
Après removeIf : [15.0, 7.5, 22.0]

Suppression des valeurs > 20.0 :
Après removeIf : [15.0, 7.5]
```
