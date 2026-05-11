# Exemple 05 - Tester les exceptions avec assertThrows

**Objectif pédagogique :** savoir vérifier qu'une méthode lève bien une
exception dans les cas d'erreur avec `assertThrows`.

**Concepts illustrés :**

- Méthode `assertThrows(TypeException.class, lambda)`.
- Expression lambda `() -> ...` pour envelopper le code à tester.
- Différence entre un test qui `throws` l'exception et un test qui l'attend avec
  `assertThrows`.
- Cas d'erreur variés : format invalide, valeur hors plage, chaîne vide.

## Description

Ce test vérifie que `readFromString` lève une `InvalidPhException` dans quatre
cas d'erreur distincts. L'utilisation de `assertThrows` distingue clairement les
tests qui attendent une exception de ceux qui n'en attendent pas.

## Code

- `WaterSensor.java` : classe de production du capteur de pH.
- `InvalidPhException.java` : exception personnalisée.
- `AssertThrowsTest.java` : quatre tests avec `assertThrows`.

## Sortie attendue

```
└─ AssertThrowsTest ✔
   ├─ readFromString_formatInvalide_leveInvalidPhException() ✔
   ├─ readFromString_phNegatif_leveInvalidPhException() ✔
   ├─ readFromString_phTropEleve_leveInvalidPhException() ✔
   └─ readFromString_chaineVide_leveInvalidPhException() ✔

[  4 tests found  |  4 successful  |  0 failed  ]
```

## Points clés à retenir

- `assertThrows` échoue si aucune exception n'est levée.
- `assertThrows` échoue aussi si une exception d'un type différent est levée.
- Les tests avec `assertThrows` ne déclarent pas `throws` : le lambda absorbe
  l'exception.
- Contrairement aux tests nominaux, les tests avec `assertThrows` ne testent pas
  la valeur de retour mais le comportement en cas d'erreur.

---

**Exemple précédent :** [04-valeurs-limites](../04-valeurs-limites/)

**Exemple suivant :** [06-effets-de-bord](../06-effets-de-bord/)
