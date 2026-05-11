# Exemple 03 - Les assertions courantes

**Objectif pédagogique :** découvrir les cinq assertions fondamentales de JUnit
et savoir dans quel cas utiliser chacune.

**Concepts illustrés :**

- `assertEquals(attendu, obtenu)` : vérifier l'égalité de deux valeurs.
- `assertTrue(condition)` : vérifier qu'une condition est vraie.
- `assertFalse(condition)` : vérifier qu'une condition est fausse.
- `assertNotNull(objet)` : vérifier qu'une référence n'est pas `null`.
- `assertNull(objet)` : vérifier qu'une référence est `null`.

## Description

Ce test illustre chacune des cinq assertions courantes appliquées à
`WaterSensor`. Chaque méthode de test ne fait appel qu'à une seule assertion,
pour que le rôle de chacune soit clair.

## Code

- `WaterSensor.java` : classe de production du capteur de pH.
- `InvalidPhException.java` : exception personnalisée (nécessaire à la
  compilation).
- `AssertionsCourantesTest.java` : six tests, un par assertion (deux pour
  `assertEquals`).

## Sortie attendue

```
└─ AssertionsCourantesTest ✔
   ├─ assertEquals_identifiant_verifieEgalite() ✔
   ├─ assertEquals_phInitial_verifieEgalite() ✔
   ├─ assertTrue_identifiantNonVide_conditionVraie() ✔
   ├─ assertFalse_phInitial_conditionFausse() ✔
   ├─ assertNotNull_identifiant_objetNonNull() ✔
   └─ assertNull_capteurSansId_identifiantNull() ✔

[  6 tests found  |  6 successful  |  0 failed  ]
```

## Points clés à retenir

- Toutes ces méthodes viennent de `org.junit.jupiter.api.Assertions`.
- L'ordre des arguments de `assertEquals` : attendu en premier, obtenu en
  second.
- `assertTrue` et `assertFalse` acceptent n'importe quelle expression booléenne.
- `assertNull` et `assertNotNull` s'utilisent pour vérifier des références
  d'objets.

---

**Exemple précédent :** [02-beforeeach-et-arrange](../02-beforeeach-et-arrange/)

**Exemple suivant :** [04-valeurs-limites](../04-valeurs-limites/)
