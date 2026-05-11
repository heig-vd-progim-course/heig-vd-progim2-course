---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: "V. Guidoux, avec l'aide de GitHub Copilot"
description:
  "Quiz sur les tests unitaires avec JUnit pour le cours ProgIM2 enseigné à la
  HEIG-VD, Suisse"
lang: "fr"
url: "https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/12-tests-unitaires-avec-junit/quiz.html"
header: "[**Tests unitaires avec JUnit - Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Tests unitaires avec JUnit - Quiz

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-progim-course/heig-vd-progim2-course>

Visualiser le contenu complet sur GitHub [à cette
adresse][contenu-complet-sur-github].

<small>V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>Ce travail est sous licence [CC BY-SA 4.0][licence].</small>

![bg opacity:0.1][illustration-principale]

## Plus de détails sur GitHub

<!-- _class: lead -->

_Cette présentation est un quiz pour tester ses connaissances sur le chapitre en
cours. Pour plus de détails, consultez le [contenu complet sur
GitHub][contenu-complet-sur-github]._

## Structure du quiz

<!-- _class: lead -->

**Répartition des questions :**

- Questions 1-5 : tests unitaires avec JUnit (chapitre actuel).
- Question 6 : révision de la gestion des exceptions (séance 11).
- Question 7 : mise en lien de plusieurs concepts.

## Question 1 - Donnée

**Complétion : annotations JUnit**

Complétez le code avec les bonnes annotations :

```java
class WaterSensorTest {

    private WaterSensor sensor;

    ___________
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }

    ___________
    void getId_retourneIdentifiantFourni() {
        assertEquals("TEST-01", sensor.getId());
    }
}
```

Quelles annotations remplacent les `___________` ?

## Question 1 - Réponse

**Réponse correcte : `@BeforeEach` et `@Test`**

```java
class WaterSensorTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }

    @Test
    void getId_retourneIdentifiantFourni() {
        assertEquals("TEST-01", sensor.getId());
    }
}
```

`@BeforeEach` : exécuté avant chaque test. `@Test` : marque une méthode comme
test à exécuter.

## Question 2 - Donnée

**Prédiction : ordre des arguments de assertEquals**

Ce test contient une erreur de convention. Que va afficher JUnit ?

```java
@Test
void getLastPh_test() {
    WaterSensor sensor = new WaterSensor("TEST-01");
    // Attention : les arguments sont inversés
    assertEquals(sensor.getLastPh(), 1.0);
}
```

Quatre réponses possibles :

- **A.** Le test passe.
- **B.** Le test échoue : `expected: <0.0> but was: <1.0>`
- **C.** Le test échoue : `expected: <1.0> but was: <0.0>`
- **D.** Erreur de compilation.

## Question 2 - Réponse

**Réponse correcte : B**

JUnit traite le premier argument comme la valeur attendue :

```
expected: <0.0> but was: <1.0>
```

Le message est trompeur : il dit "expected 0.0" alors que c'est la valeur réelle
du capteur, pas la valeur que l'on souhaitait vérifier.

La convention `assertEquals(attendu, obtenu)` doit être respectée pour que les
messages d'erreur soient lisibles.

## Question 3 - Donnée

**Comparaison : types de tests**

Associez chaque description au type de test qui lui correspond.

| Description                                                    | Type |
| :------------------------------------------------------------- | :--- |
| Vérifie que `readFromString("7.0")` retourne `7.0`.            | ?    |
| Vérifie que la lecture d'un CSV met à jour la base de données. | ?    |
| Vérifie que l'application répond à une requête HTTP.           | ?    |

Types disponibles : unitaire, intégration, fonctionnel.

## Question 3 - Réponse

**Réponses correctes :**

| Description                                                    | Type         |
| :------------------------------------------------------------- | :----------- |
| Vérifie que `readFromString("7.0")` retourne `7.0`.            | Unitaire.    |
| Vérifie que la lecture d'un CSV met à jour la base de données. | Intégration. |
| Vérifie que l'application répond à une requête HTTP.           | Fonctionnel. |

Le test unitaire vérifie une méthode isolée. Le test d'intégration vérifie
plusieurs composants ensemble. Le test fonctionnel vérifie l'application
entière.

## Question 4 - Donnée

**Prédiction : combien de fois @BeforeEach est exécuté**

Combien de fois la méthode `setUp()` est-elle appelée lors de l'exécution de
cette classe de test ?

```java
class WaterSensorTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() { sensor = new WaterSensor("TEST-01"); }

    @Test void test1() { /* ... */ }
    @Test void test2() { /* ... */ }
    @Test void test3() { /* ... */ }
}
```

## Question 4 - Réponse

**Réponse correcte : 3 fois**

`@BeforeEach` est exécuté avant chaque test, sans exception.

Ordre d'exécution :

1. `setUp()` → `test1()`
2. `setUp()` → `test2()`
3. `setUp()` → `test3()`

Cela garantit que chaque test part d'un état initial propre, indépendamment de
ce que les autres tests ont pu modifier.

## Question 5 - Donnée

**Complétion : assertThrows**

Complétez le test pour vérifier que `readFromString("abc")` lève bien une
`InvalidPhException` :

```java
@Test
void readFromString_formatInvalide_leveInvalidPhException() {
    _____________(InvalidPhException.class,
        () -> sensor.readFromString("abc"));
}
```

Quel appel de méthode remplace `_____________` ?

## Question 5 - Réponse

**Réponse correcte : `assertThrows`**

```java
@Test
void readFromString_formatInvalide_leveInvalidPhException() {
    assertThrows(InvalidPhException.class,
        () -> sensor.readFromString("abc"));
}
```

Le premier argument est la classe de l'exception attendue. Le second est un
lambda qui contient le code à exécuter. Si aucune exception n'est levée, ou si
une exception d'un autre type est levée, le test échoue.

## Question 6 - Donnée

**Révision : exceptions personnalisées (séance 11)**

Quelles affirmations sur `InvalidPhException` sont correctes ?

- **A.** `InvalidPhException` est une exception non vérifiée.
- **B.** `InvalidPhException extends Exception` la rend vérifiée.
- **C.** Le compilateur oblige l'appelant à gérer ou déclarer
  `InvalidPhException`.
- **D.** `assertThrows` peut capturer une `InvalidPhException` dans un test.

## Question 6 - Réponse

**Réponses correctes : B, C et D**

| Affirmation | Correct ? | Raison                                             |
| :---------- | :-------: | :------------------------------------------------- |
| A           |   Non.    | Elle hérite d'`Exception`, elle est vérifiée.      |
| B           |   Oui.    | C'est la définition d'une exception vérifiée.      |
| C           |   Oui.    | Le compilateur impose `try-catch` ou `throws`.     |
| D           |   Oui.    | `assertThrows` capture n'importe quelle exception. |

## Question 7 - Donnée

**Connexion : identifier les parties AAA**

Identifiez les étapes Arrange, Act et Assert dans ce test :

```java
@Test
void readFromString_valeurNominale_metAJourLastPh()
        throws InvalidPhException {
    WaterSensor sensor = new WaterSensor("TEST-01");  // (1)
    sensor.readFromString("7.0");                     // (2)
    assertEquals(7.0, sensor.getLastPh());            // (3)
}
```

Associez (1), (2) et (3) aux étapes Arrange, Act et Assert.

## Question 7 - Réponse

**Réponse correcte :**

| Ligne | Etape    | Rôle                                                    |
| :---: | :------- | :------------------------------------------------------ |
|  (1)  | Arrange. | Préparer l'état initial : créer le capteur.             |
|  (2)  | Act.     | Appeler la méthode à tester.                            |
|  (3)  | Assert.  | Vérifier que `lastPh` vaut bien `7.0` après la lecture. |

Le patron AAA donne une structure claire et lisible à chaque test, quelle que
soit sa complexité.

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## Sources

- [Illustration principale][illustration-principale] par
  [Nguyen Dang Hoang Nhu](https://unsplash.com/@nguyendhn) sur
  [Unsplash](https://unsplash.com/photos/person-writing-on-white-paper-qDgTQOYk6B8)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/12-tests-unitaires-avec-junit/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1455849318743-b2233052fcff?fit=crop&h=720
