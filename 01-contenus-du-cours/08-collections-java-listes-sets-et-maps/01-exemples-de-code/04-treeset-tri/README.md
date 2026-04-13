# Exemple 04 - TreeSet et tri automatique

**Objectif pédagogique :** comprendre le tri automatique offert par `TreeSet`.

**Concepts illustrés :**

- Création d'un `TreeSet`
- Tri automatique des éléments
- Comparaison avec `HashSet`
- Contrainte : les éléments doivent implémenter `Comparable`

## Description

Cet exemple montre comment `TreeSet` maintient ses éléments triés par ordre
naturel (alphabétique pour les `String`). On compare le résultat avec un
`HashSet` pour illustrer la différence d'ordre.

## Code

Le fichier `TreeSetDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== Comparaison HashSet vs TreeSet ===

HashSet (ordre non garanti) : [Tomate, Carotte, Menthe, Basilic, Aubergine] (ordre variable)
TreeSet (trié)              : [Aubergine, Basilic, Carotte, Menthe, Tomate]

=== TreeSet : opérations sur un ensemble trié ===
Premier élément : Aubergine
Dernier élément : Tomate

Ajout de Courgette...
Ensemble trié : [Aubergine, Basilic, Carotte, Courgette, Menthe, Tomate]
Courgette est automatiquement placée à la bonne position.
```

## Points clés à retenir

- `TreeSet` trie automatiquement les éléments par ordre naturel.
- Les éléments doivent implémenter `Comparable` (c'est le cas de `String`,
  `Integer`, etc.).
- `TreeSet` est légèrement plus lent que `HashSet` car il maintient l'ordre.
- Utile quand on a besoin d'éléments uniques ET triés.

---

**Exemple suivant :** [05-hashmap-cle-valeur](../05-hashmap-cle-valeur/)
