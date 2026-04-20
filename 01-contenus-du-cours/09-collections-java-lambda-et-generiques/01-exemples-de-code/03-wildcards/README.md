# Exemple 09 - Wildcards

**Objectif pédagogique :** comprendre les wildcards (`?`) et les bornes
(`extends`, `super`) pour écrire du code générique flexible.

**Concepts illustrés :**

- Wildcard non borné `<?>`.
- Wildcard borné supérieur `<? extends T>` (lecture).
- Wildcard borné inférieur `<? super T>` (écriture).
- Principe PECS (Producer Extends, Consumer Super).

## Description

Cet exemple montre les trois types de wildcards. Un wildcard
`<? extends Number>` accepte une liste de `Number` ou de n'importe quelle
sous-classe (`Integer`, `Double`, etc.) mais en lecture seule. Un wildcard
`<? super Integer>` accepte une liste de `Integer` ou de n'importe quelle
super-classe et permet l'écriture.

## Code

Le fichier `WildcardDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```text
=== Wildcards ===

--- Wildcard non borné <?> ---
Éléments : 3
Éléments : 2

--- Wildcard borné <? extends Number> ---
Somme des Integer : 60.0
Somme des Double : 9.42

--- Wildcard borné <? super Integer> ---
Après ajout : [10, 20, 30, 100, 200]
```
