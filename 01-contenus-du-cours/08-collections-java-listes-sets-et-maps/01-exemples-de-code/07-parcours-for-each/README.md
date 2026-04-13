# Exemple 07 - Parcours avec for-each

**Objectif pédagogique :** maîtriser le parcours de collections avec la boucle
`for-each`.

**Concepts illustrés :**

- Boucle `for-each` sur une liste
- Boucle `for-each` sur un ensemble
- Parcours d'une map avec `entrySet()`, `keySet()` et `values()`
- `Map.Entry`, `getKey()`, `getValue()`

## Description

Cet exemple montre comment parcourir les trois types de collections avec la
boucle `for-each`. Pour les maps, on illustre les trois façons de parcourir :
par paires clé-valeur (`entrySet()`), par clés seules (`keySet()`) et par
valeurs seules (`values()`).

## Code

Le fichier `ForEachDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== Parcours d'une liste ===
- Tomate
- Carotte
- Basilic

=== Parcours d'un ensemble ===
- Tomate (ordre variable)
- Carotte (ordre variable)
- Basilic (ordre variable)

=== Parcours d'une map avec entrySet() ===
Alice -> Parcelle A1
Bob -> Parcelle B2
Clara -> Parcelle A3

=== Parcours des clés seules ===
Jardinière : Alice
Jardinière : Bob
Jardinière : Clara

=== Parcours des valeurs seules ===
Parcelle : Parcelle A1
Parcelle : Parcelle B2
Parcelle : Parcelle A3
```

## Points clés à retenir

- La boucle `for-each` fonctionne avec `List`, `Set` et les vues d'une `Map`.
- Pour une map, `entrySet()` donne les paires `Map.Entry` avec `getKey()` et
  `getValue()`.
- `keySet()` et `values()` permettent de parcourir clés ou valeurs séparément.
- La boucle `for-each` est plus lisible qu'une boucle `for` classique.

---

**Exemple suivant :** [08-iterateur-suppression](../08-iterateur-suppression/)
