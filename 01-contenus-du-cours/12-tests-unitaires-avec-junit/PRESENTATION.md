---
marp: true
theme: "custom-marp-theme"
size: "16:9"
paginate: "true"
author: "V. Guidoux, avec l'aide de GitHub Copilot"
description:
  "Tests unitaires avec JUnit pour le cours ProgIM2 enseigné à la HEIG-VD,
  Suisse"
lang: "fr"
url: "https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/12-tests-unitaires-avec-junit/presentation.html"
header: "[**Tests unitaires avec JUnit**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Tests unitaires avec JUnit

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

_Cette présentation est un résumé du contenu complet disponible sur GitHub._

_Pour plus de détails, consulter le [contenu complet sur
GitHub][contenu-complet-sur-github] ou en cliquant sur l'en-tête de ce
document._

## Objectifs (1/3)

- Accepter que les tests unitaires font partie intégrante du développement
  logiciel.
- Différencier tests unitaires, tests d'intégration et tests fonctionnels.
- Décrire ce qui constitue un bon test unitaire.

![bg right:40%][illustration-objectifs]

## Objectifs (2/3)

- Reconnaître les avantages du développement piloté par les tests (TDD).
- Créer une classe de test JUnit avec `@Test` et `@BeforeEach`.
- Écrire des assertions avec `assertEquals()`, `assertTrue()`,
  `assertFalse()`, `assertNull()` et `assertThrows()`.

![bg right:40%][illustration-objectifs]

## Objectifs (3/3)

- Appliquer les principes AAA (Arrange-Act-Assert) pour structurer ses tests.
- Évaluer la couverture de code et identifier les branches et cas limites.
- Argumenter l'utilité des tests unitaires dans le contexte d'un projet
  logiciel.

![bg right:40%][illustration-objectifs]

## Le code sans filet

<!-- _class: lead -->

### Le problème

Nous avons un `WaterSensor` qui fonctionne en séance 11.

Comment savoir qu'il fonctionne **dans tous les cas** ?

Et si une modification future casse quelque chose ?

![bg right:40% w:100%](./images/water-monitoring-system.svg)

### Ce qui nous manque

Le programme fonctionne quand on l'exécute manuellement.

Mais :

- Qui vérifie le cas `pH = 0.0` ? Le cas `pH = 14.0` ?
- Qui vérifie qu'une entrée `"abc"` lève bien une exception ?
- Qui vérifie que `lastPh` n'est pas modifié après une erreur ?

Les tests unitaires répondent à ces questions de façon **automatique** et
**reproductible**.

## Qu'est-ce qu'un test unitaire ?

<!-- _class: lead -->

### Définition

Un test unitaire vérifie le comportement d'une **unité de code isolée** —
généralement une méthode — dans un contexte contrôlé.

Il est :

- **Automatisé** : exécuté par le code, pas par un humain.
- **Reproductible** : le même résultat à chaque exécution.
- **Rapide** : des millisecondes, pas des minutes.
- **Indépendant** : chaque test part d'un état propre.

### Les trois types de tests

| Type | Quoi ? | Vitesse |
| :--- | :----- | :------ |
| Unitaire | Une méthode isolée | Très rapide |
| Intégration | Plusieurs composants ensemble | Moyen |
| Fonctionnel | L'application entière | Lent |

Dans ce cours : **tests unitaires**.

### Un bon test unitaire

Un bon test unitaire est :

- **Lisible** : son nom décrit ce qu'il vérifie.
- **Focalisé** : il vérifie une seule chose.
- **Déterministe** : il donne toujours le même résultat.
- **Indépendant** : il ne dépend pas de l'ordre d'exécution.

Exemple de nom : `readFromString_formatInvalide_leveInvalidPhException`.

## Arrange, Act, Assert

<!-- _class: lead -->

### Le patron AAA

Chaque test suit trois étapes :

1. **Arrange** : préparer l'état initial.
2. **Act** : appeler la méthode à tester.
3. **Assert** : vérifier le résultat.

### AAA en pratique

```java
@Test
void readFromString_valeurNominale_retourneValeur()
        throws InvalidPhException {
    // Arrange
    WaterSensor sensor = new WaterSensor("TEST-01");

    // Act
    double result = sensor.readFromString("7.0");

    // Assert
    assertEquals(7.0, result);
}
```

L'étape "Arrange" est souvent déléguée à `@BeforeEach`.

## JUnit : mise en place

<!-- _class: lead -->

### Le JAR autonome

JUnit est distribué sous forme d'un seul fichier JAR autonome.

Pas besoin de Maven ni de Gradle.

Téléchargement via `setup.sh` :

```shell
bash setup.sh
```

Le JAR `junit-platform-console-standalone-6.0.3.jar` est placé dans `lib/`.

### Structure du projet

```text
03-mini-projet/
├── setup.sh
├── lib/
│   └── junit-platform-console-standalone-6.0.3.jar
├── src/
│   ├── WaterSensor.java
│   ├── InvalidPhException.java
│   └── WaterSensorTest.java   ← à créer
└── out/                       ← créé à la compilation
```

## Écrire des tests

<!-- _class: lead -->

### La classe de test

```java
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WaterSensorTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }
}
```

`@BeforeEach` garantit un capteur frais avant chaque test.

### @Test et assertEquals

```java
    @Test
    void getId_retourneIdentifiantFourni() {
        assertEquals("TEST-01", sensor.getId());
    }

    @Test
    void getLastPh_retourneZeroApresConstruction() {
        assertEquals(0.0, sensor.getLastPh());
    }
```

`assertEquals(attendu, obtenu)` : l'ordre des arguments compte — `attendu` en
premier.

### Les assertions courantes (1/2)

| Méthode | Vérifie |
| :--- | :--- |
| `assertEquals(a, b)` | `a` est égal à `b`. |
| `assertTrue(cond)` | `cond` est vraie. |
| `assertFalse(cond)` | `cond` est fausse. |
| `assertNull(obj)` | `obj` est `null`. |

### Les assertions courantes (2/2)

| Méthode | Vérifie |
| :--- | :--- |
| `assertNotNull(obj)` | `obj` n'est pas `null`. |
| `assertThrows(Type, lambda)` | le code lève une exception du type `Type`. |

Toutes ces méthodes viennent de `org.junit.jupiter.api.Assertions`.

### Tester les valeurs limites

```java
    @Test
    void readFromString_borneMinimale_accepte()
            throws InvalidPhException {
        assertEquals(0.0, sensor.readFromString("0.0"));
    }

    @Test
    void readFromString_borneMaximale_accepte()
            throws InvalidPhException {
        assertEquals(14.0, sensor.readFromString("14.0"));
    }
```

Les **valeurs limites** (0.0 et 14.0) sont les cas les plus susceptibles de
contenir des bugs.

### Tester les exceptions

```java
import static org.junit.jupiter.api.Assertions.assertThrows;

    @Test
    void readFromString_formatInvalide_leveInvalidPhException() {
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("abc"));
    }
```

Le lambda `() -> ...` contient le code à exécuter. Le test échoue si
aucune exception n'est levée.

### Tester les effets de bord

```java
    @Test
    void readFromString_erreurFormat_lastPhInchange()
            throws InvalidPhException {
        sensor.readFromString("7.0");
        try {
            sensor.readFromString("invalide");
        } catch (InvalidPhException e) {
            // exception attendue
        }
        assertEquals(7.0, sensor.getLastPh());
    }
```

Un test peut vérifier qu'une opération ratée ne modifie pas l'état interne.

## Compiler et exécuter

<!-- _class: lead -->

### Compilation

```shell
javac \
  -cp lib/junit-platform-console-standalone-6.0.3.jar \
  src/*.java \
  -d out/
```

Compile les classes de production et les classes de test **en une commande**.

### Exécution

```shell
java -jar lib/junit-platform-console-standalone-6.0.3.jar execute \
  --class-path out/ \
  --scan-class-path
```

JUnit découvre automatiquement toutes les classes dont le nom se termine par
`Test` ou `Tests`.

### Lire les résultats

```text
└─ WaterSensorTest ✔
   ├─ getId_retourneIdentifiantFourni() ✔
   ├─ getLastPh_retourneZeroApresConstruction() ✔
   ├─ readFromString_borneMinimale_accepte() ✔
   └─ readFromString_formatInvalide_leveInvalidPhException() ✔

[  4 tests found  |  4 successful  |  0 failed  ]
```

Un `✔` vert : le test passe. Un `✘` rouge : le test échoue.

### Quand un test échoue

```text
org.opentest4j.AssertionFailedError:
expected: <MAUVAIS-ID>
 but was: <TEST-01>
```

JUnit affiche la valeur attendue et la valeur obtenue. Cela permet de
localiser rapidement le problème.

## La valeur des tests

<!-- _class: lead -->

### Le filet de sécurité

Introduisons un bug volontaire dans `WaterSensor` : supprimons la validation de
la plage.

Les tests détectent immédiatement la régression :

```text
readFromString_phTropEleve_leveInvalidPhException ✘
readFromString_phTropBas_leveInvalidPhException ✘
```

Sans les tests, ce bug pourrait passer inaperçu jusqu'en production.

### TDD : tester d'abord

Le développement piloté par les tests (_Test-Driven Development_) inverse
l'ordre habituel :

1. Écrire le test **avant** le code de production.
2. Constater l'échec du test (rouge).
3. Écrire le code minimal pour le faire passer (vert).
4. Améliorer le code sans casser les tests (refactorisation).

Ce cycle s'appelle **rouge-vert-refactorisation**.

### Couverture de code

La couverture de code mesure le **pourcentage de code exécuté** par les tests.

Ce qu'il faut viser :

- Tester les **cas nominaux** (valeurs normales).
- Tester les **valeurs limites** (0.0, 14.0, `null`).
- Tester les **cas d'erreur** (format invalide, valeur hors plage).

Une couverture de 100 % ne garantit pas l'absence de bugs, mais une couverture
faible garantit des zones non testées.

### Pourquoi les tests perdurent ?

Un test écrit aujourd'hui continue de fonctionner dans six mois, quand :

- Une nouvelle personne rejoint l'équipe.
- Une dépendance est mise à jour.
- Une fonctionnalité est refactorisée.

Les tests sont une **documentation vivante** du comportement attendu.

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## À vous de jouer !

- (Re)lire le contenu de cours, lire les exemples de code et les descriptions.
- Faire les exercices.
- Faire le mini-projet.
- Poser des questions si nécessaire.

➡️ [Visualiser le contenu complet sur GitHub.][contenu-complet-sur-github]

**N'hésitez pas à vous entraider si vous avez des difficultés !**

![bg right:30%][illustration-a-vous-de-jouer]

## Sources

- [Illustration principale][illustration-principale] par
  [Nguyen Dang Hoang Nhu](https://unsplash.com/@nguyendhn) sur
  [Unsplash](https://unsplash.com/photos/person-writing-on-white-paper-qDgTQOYk6B8)
- [Illustration][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/low-angle-view-of-ball-shoots-in-the-ring-j6brni7fpvs)
- [Illustration][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/white-sony-ps4-dualshock-controller-over-persons-palm-FJFPuE1MAOM)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/12-tests-unitaires-avec-junit/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1455849318743-b2233052fcff?fit=crop&h=720
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
