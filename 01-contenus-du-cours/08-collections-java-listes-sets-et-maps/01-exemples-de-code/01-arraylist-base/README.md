# Exemple 01 - ArrayList de base

**Objectif pédagogique :** comprendre le fonctionnement d'une `ArrayList` et ses
opérations courantes.

**Concepts illustrés :**

- Création d'une `ArrayList`
- Déclaration avec le type de l'interface `List`
- Opérations : `add()`, `remove()`, `get()`, `contains()`, `size()`
- Doublons autorisés

## Description

Cet exemple montre les opérations fondamentales d'une `ArrayList` dans le
contexte d'un jardin communautaire. On gère une liste de noms de plantes :
ajout, accès par index, suppression, vérification de présence et taille.

La variable est déclarée avec le type `List<String>` (l'interface) et non
`ArrayList<String>` (l'implémentation). C'est une bonne pratique de
programmation orientée objet : programmer vers l'interface.

## Code

Le fichier `ArrayListDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== ArrayList : gestion des plantes ===
Plantes : [Tomate, Carotte, Basilic, Tomate]

Première plante : Tomate
Dernière plante : Tomate

Contient Basilic : true
Contient Menthe : false

Suppression de Basilic...
Plantes après suppression : [Tomate, Carotte, Tomate]
Nombre de plantes : 3

Ajout de Menthe à l'index 1...
Plantes : [Tomate, Menthe, Carotte, Tomate]
```

## Points clés à retenir

- Déclarer avec `List<String>` (interface), créer avec `new ArrayList<>()`
  (implémentation).
- Les doublons sont autorisés dans une liste.
- `get(i)` accède par index (commence à 0).
- `remove()` supprime la première occurrence trouvée.
- `add(index, element)` insère à une position spécifique.

---

**Exemple suivant :** [02-linkedlist](../02-linkedlist/)
