# Exemple 06 - TreeMap : tri par clé

**Objectif pédagogique :** comprendre le tri automatique des clés offert par
`TreeMap`.

**Concepts illustrés :**

- Création d'une `TreeMap`
- Tri automatique par clé
- Comparaison avec `HashMap`
- Contrainte : les clés doivent implémenter `Comparable`

## Description

Cet exemple compare `HashMap` et `TreeMap` pour stocker le nombre de plantes par
espèce. `TreeMap` maintient les entrées triées par clé, ce qui est utile pour
afficher un rapport alphabétique.

## Code

Le fichier `TreeMapDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== Comparaison HashMap vs TreeMap ===

HashMap (ordre non garanti) : {Tomate=12, Basilic=8, Carotte=15, Aubergine=5} (ordre variable)
TreeMap (trié par clé)      : {Aubergine=5, Basilic=8, Carotte=15, Tomate=12}

=== Rapport trié des plantes ===
Aubergine : 5 plantes
Basilic : 8 plantes
Carotte : 15 plantes
Tomate : 12 plantes
```

## Points clés à retenir

- `TreeMap` trie automatiquement les entrées par clé.
- Les clés doivent implémenter `Comparable` (comme `String`, `Integer`).
- `TreeMap` est légèrement plus lent que `HashMap` à cause du maintien de
  l'ordre.
- Utile pour les rapports, les affichages triés et les parcours ordonnés.

---

**Exemple suivant :** [07-parcours-for-each](../07-parcours-for-each/)
