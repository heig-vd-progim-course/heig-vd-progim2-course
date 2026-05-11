# Exemple 02 - @BeforeEach et l'étape Arrange

**Objectif pédagogique :** comprendre comment `@BeforeEach` centralise l'étape
Arrange et garantit l'indépendance des tests.

**Concepts illustrés :**

- Annotation `@BeforeEach` pour exécuter une méthode avant chaque test.
- Champ d'instance pour partager l'objet testé entre les méthodes de test.
- Garantie d'un état initial propre pour chaque test.
- Comparaison avec l'exemple 01 (sans `@BeforeEach`).

## Description

Ce test reprend les mêmes vérifications que l'exemple 01 (comportement du
constructeur de `WaterSensor`), mais centralise la création du capteur dans une
méthode `setUp()` annotée `@BeforeEach`.

JUnit appelle `setUp()` avant chaque méthode de test. Cela supprime la
répétition de l'étape Arrange et garantit qu'aucun test ne peut influencer
l'état vu par un autre test.

## Code

- `WaterSensor.java` : classe de production du capteur de pH.
- `InvalidPhException.java` : exception personnalisée (nécessaire à la
  compilation).
- `AvecBeforeEachTest.java` : classe de test avec `@BeforeEach`.

## Sortie attendue

```
└─ AvecBeforeEachTest ✔
   ├─ getId_retourneIdentifiantFourni() ✔
   └─ getLastPh_retourneZeroApresConstruction() ✔

[  2 tests found  |  2 successful  |  0 failed  ]
```

## Points clés à retenir

- `@BeforeEach` est appelé avant chaque méthode `@Test`, sans exception.
- Le champ `sensor` déclaré au niveau de la classe est réinitialisé avant chaque
  test.
- Même si un test modifie `sensor`, le suivant repart toujours d'un état propre.
- Comparer avec l'exemple 01 : même résultat, code plus concis.

---

**Exemple précédent :**
[01-test-structure-de-base](../01-test-structure-de-base/)

**Exemple suivant :** [03-assertions-courantes](../03-assertions-courantes/)
