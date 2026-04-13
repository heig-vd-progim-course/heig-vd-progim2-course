# Exemple 05 - HashMap : associations clé-valeur

**Objectif pédagogique :** comprendre le fonctionnement d'une `HashMap` pour les
associations clé-valeur.

**Concepts illustrés :**

- Création d'une `HashMap`
- Opérations : `put()`, `get()`, `containsKey()`, `remove()`
- Remplacement de valeur avec `put()` sur une clé existante
- Accès aux clés (`keySet()`) et aux valeurs (`values()`)

## Description

Cet exemple montre comment utiliser une `HashMap` pour associer des noms de
jardinières à leurs parcelles. On illustre le double rôle de `put()` (ajout et
remplacement), la recherche par clé et le comportement avec une clé inexistante.

## Code

Le fichier `HashMapDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== HashMap : attribution des parcelles ===
Attributions : {Bob=Parcelle B2, Alice=Parcelle A1, Clara=Parcelle A3} (ordre variable)

Parcelle d'Alice : Parcelle A1
Parcelle de David : null

Contient la clé Bob : true
Contient la clé David : false

=== Mise à jour et suppression ===
Alice change de parcelle...
Parcelle d'Alice : Parcelle C1

Suppression de Bob...
Attributions : {Alice=Parcelle C1, Clara=Parcelle A3} (ordre variable)
Taille : 2

=== Clés et valeurs ===
Jardinières (clés) : [Alice, Clara] (ordre variable)
Parcelles (valeurs) : [Parcelle C1, Parcelle A3] (ordre variable)
```

## Points clés à retenir

- `put()` ajoute une entrée ou remplace la valeur si la clé existe déjà.
- `get()` retourne `null` si la clé n'existe pas.
- `keySet()` retourne un `Set` (les clés sont uniques).
- `values()` retourne une `Collection` (les valeurs peuvent avoir des doublons).
- L'ordre d'affichage n'est pas garanti avec `HashMap`.

---

**Exemple suivant :** [06-treemap-tri-par-cle](../06-treemap-tri-par-cle/)
