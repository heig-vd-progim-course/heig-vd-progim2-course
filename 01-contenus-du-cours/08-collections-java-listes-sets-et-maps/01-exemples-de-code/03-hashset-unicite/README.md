# Exemple 03 - HashSet et unicité

**Objectif pédagogique :** comprendre comment `HashSet` garantit l'unicité des
éléments.

**Concepts illustrés :**

- Création d'un `HashSet`
- Rejet automatique des doublons
- Valeur de retour de `add()` (`true`/`false`)
- Conversion d'une liste en ensemble pour éliminer les doublons

## Description

Cet exemple montre le comportement d'un `HashSet` lorsqu'on tente d'ajouter des
doublons. La méthode `add()` retourne `false` si l'élément existait déjà. On
montre aussi comment convertir une liste contenant des doublons en un ensemble
pour obtenir les éléments uniques.

## Code

Le fichier `HashSetDemo.java` contient un exemple complet et commenté.

## Sortie attendue

```
=== HashSet : espèces du jardin ===
Ajout de Tomate : true
Ajout de Carotte : true
Ajout de Basilic : true
Ajout de Tomate (doublon) : false
Ajout de Menthe : true
Ajout de Carotte (doublon) : false

Espèces : [Tomate, Carotte, Menthe, Basilic] (ordre variable)
Nombre d'espèces : 4

Contient Tomate : true
Contient Persil : false

=== Éliminer les doublons d'une liste ===
Liste avec doublons : [Tomate, Carotte, Tomate, Basilic, Carotte, Tomate]
Taille de la liste : 6
Ensemble sans doublons : [Tomate, Carotte, Basilic] (ordre variable)
Taille de l'ensemble : 3
```

## Points clés à retenir

- `HashSet` ignore silencieusement les doublons.
- `add()` retourne `true` si l'élément a été ajouté, `false` s'il existait déjà.
- L'ordre d'affichage n'est pas garanti avec `HashSet`.
- On peut convertir une liste en `HashSet` pour supprimer les doublons.

---

**Exemple suivant :** [04-treeset-tri](../04-treeset-tri/)
