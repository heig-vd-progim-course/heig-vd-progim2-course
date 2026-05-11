# Exemple 01 - Structure de base d'un test JUnit

**Objectif pédagogique :** comprendre la structure minimale d'une classe de test
JUnit avec `@Test` et `assertEquals`.

**Concepts illustrés :**

- Annotation `@Test` pour déclarer une méthode de test.
- Méthode `assertEquals(attendu, obtenu)` pour vérifier une valeur.
- Patron AAA (Arrange-Act-Assert) avec les trois étapes explicites.
- Convention de nommage `méthode_contexte_résultatAttendu`.

## Description

Ce test vérifie deux comportements du constructeur de `WaterSensor` :

- `getId()` retourne bien l'identifiant fourni à la construction.
- `getLastPh()` retourne `0.0` juste après la construction.

Chaque méthode de test contient les trois étapes AAA commentées explicitement,
pour que la structure soit visible.

## Code

- `WaterSensor.java` : classe de production du capteur de pH.
- `InvalidPhException.java` : exception personnalisée (nécessaire à la
  compilation).
- `StructureDeBaseTest.java` : classe de test avec deux méthodes `@Test`.

## Sortie attendue

```
└─ StructureDeBaseTest ✔
   ├─ getId_retourneIdentifiantFourni() ✔
   └─ getLastPh_retourneZeroApresConstruction() ✔

[  2 tests found  |  2 successful  |  0 failed  ]
```

## Points clés à retenir

- `@Test` est l'annotation qui indique à JUnit qu'une méthode est un test.
- `assertEquals(attendu, obtenu)` : la valeur attendue vient en premier.
- Les étapes Arrange, Act et Assert délimitent clairement chaque partie du test.
- Le nom `getId_retourneIdentifiantFourni` décrit exactement ce que teste la
  méthode.

---

**Exemple suivant :** [02-beforeeach-et-arrange](../02-beforeeach-et-arrange/)
