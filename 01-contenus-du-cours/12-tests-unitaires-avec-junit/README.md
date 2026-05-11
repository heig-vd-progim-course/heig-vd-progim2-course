# Tests unitaires avec JUnit

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Voici quelques informations relatives à ce contenu.
>
> **Ressources annexes**
>
> - Autres formats du support de cours : [Présentation (web)][presentation-web]
>   · [Présentation (PDF)][presentation-pdf]
> - Exemples de code : [Accéder au contenu](./01-exemples-de-code/)
> - Exercices : [Accéder au contenu](./02-exercices/)
> - Mini-projet : [Accéder au contenu](./03-mini-projet/)
> - Quiz : [Accéder au contenu][quiz-web]
>
> **Objectifs**
>
> À l'issue de cette séance, les personnes qui étudient devraient être capables
> de :
>
> - Accepter que les tests unitaires font partie intégrante du développement
>   logiciel.
> - Différencier tests unitaires, tests d'intégration et tests fonctionnels.
> - Décrire ce qui constitue un bon test unitaire.
> - Reconnaître les avantages du développement piloté par les tests (TDD).
> - Créer une classe de test JUnit avec les annotations `@Test` et
>   `@BeforeEach`.
> - Écrire des assertions avec `assertEquals()`, `assertTrue()`,
>   `assertFalse()`, `assertNull()` et `assertThrows()`.
> - Appliquer les principes AAA (Arrange-Act-Assert) pour structurer ses tests.
> - Évaluer la couverture de code et identifier les branches et cas limites à
>   tester.
> - Argumenter l'utilité des tests unitaires dans le contexte d'un projet
>   logiciel.
>
> **Méthodes d'enseignement et d'apprentissage**
>
> Les méthodes d'enseignement et d'apprentissage utilisées pour animer la séance
> sont les suivantes :
>
> - Présentation magistrale.
> - Discussions collectives.
> - Travail en autonomie.
>
> **Méthodes d'évaluation**
>
> L'évaluation prend la forme d'exercices et d'un mini-projet à réaliser en
> autonomie en classe ou à la maison.
>
> L'évaluation se fait en utilisant les critères suivants :
>
> - Capacité à répondre avec justesse.
> - Capacité à argumenter.
> - Capacité à réaliser les tâches demandées.
> - Capacité à s'approprier les exemples de code.
> - Capacité à appliquer les exemples de code à des situations similaires.
>
> Les retours se font de la manière suivante :
>
> - Corrigé des exercices.
> - Corrigé du mini-projet.
>
> L'évaluation ne donne pas lieu à une note.

## Table des matières

- [Table des matières](#table-des-matières)
- [Objectifs](#objectifs)
- [Le code sans filet](#le-code-sans-filet)
	- [Un code qu'on ne sait pas vérifier](#un-code-quon-ne-sait-pas-vérifier)
	- [Ce qui nous manque](#ce-qui-nous-manque)
- [Qu'est-ce qu'un test unitaire ?](#quest-ce-quun-test-unitaire-)
	- [Définition](#définition)
	- [Les trois types de tests](#les-trois-types-de-tests)
	- [Un bon test unitaire](#un-bon-test-unitaire)
- [Le patron AAA](#le-patron-aaa)
	- [Arrange, Act, Assert](#arrange-act-assert)
	- [AAA en pratique](#aaa-en-pratique)
	- [@BeforeEach : déléguer l'étape Arrange](#beforeeach--déléguer-létape-arrange)
- [JUnit : mise en place](#junit--mise-en-place)
	- [Le JAR autonome](#le-jar-autonome)
	- [Structure du projet](#structure-du-projet)
- [Écrire des tests](#écrire-des-tests)
	- [La classe de test](#la-classe-de-test)
	- [@Test et assertEquals](#test-et-assertequals)
	- [Les assertions courantes](#les-assertions-courantes)
	- [Tester les valeurs limites](#tester-les-valeurs-limites)
	- [Tester les exceptions](#tester-les-exceptions)
	- [Tester les effets de bord](#tester-les-effets-de-bord)
- [Compiler et exécuter](#compiler-et-exécuter)
	- [Compilation](#compilation)
	- [Exécution](#exécution)
	- [Lire les résultats](#lire-les-résultats)
	- [Quand un test échoue](#quand-un-test-échoue)
- [La valeur des tests](#la-valeur-des-tests)
	- [Le filet de sécurité](#le-filet-de-sécurité)
	- [Le développement piloté par les tests](#le-développement-piloté-par-les-tests)
	- [La couverture de code](#la-couverture-de-code)
	- [Pourquoi les tests perdurent](#pourquoi-les-tests-perdurent)
- [Conclusion](#conclusion)
- [Aller plus loin](#aller-plus-loin)
- [Exemples de code](#exemples-de-code)
- [Exercices](#exercices)
- [Mini-projet](#mini-projet)
- [À faire pour la prochaine séance](#à-faire-pour-la-prochaine-séance)

## Objectifs

Ce contenu de cours a pour objectifs de permettre aux personnes qui étudient de
comprendre pourquoi les tests unitaires font partie intégrante du développement
logiciel, et d'acquérir les outils pour écrire des tests efficaces avec JUnit.
Nous partirons d'un programme fonctionnel mais non vérifié pour construire
progressivement une suite de tests qui constitue un véritable filet de sécurité.

La liste complète des objectifs est disponible dans la section _"Objectifs"_ du
bloc d'information en haut de ce contenu.

## Le code sans filet

### Un code qu'on ne sait pas vérifier

A la fin de la séance 11, nous disposons d'un `WaterSensor` capable de lire une
valeur de pH depuis une chaîne de caractères et de lever une
`InvalidPhException` si la valeur est hors plage ou mal formatée.

```java
public class WaterSensor {

    private static final double MIN_PH = 0.0;
    private static final double MAX_PH = 14.0;

    private String id;
    private double lastPh;

    public WaterSensor(String id) {
        this.id = id;
        this.lastPh = 0.0;
    }

    public double readFromString(String raw) throws InvalidPhException {
        double value;

        try {
            value = Double.parseDouble(raw);
        } catch (NumberFormatException e) {
            throw new InvalidPhException(this.id, Double.NaN, e);
        }

        if (value < MIN_PH || value > MAX_PH) {
            throw new InvalidPhException(this.id, value);
        }

        this.lastPh = value;
        return value;
    }

    public String getId() {
        return id;
    }

    public double getLastPh() {
        return lastPh;
    }
}
```

<details>
<summary>Description du code</summary>

La classe `WaterSensor` encapsule un identifiant de capteur et la dernière
valeur de pH lue. La méthode `readFromString` tente d'abord de convertir la
chaîne en `double`. Si la conversion échoue, elle lève une `InvalidPhException`.
Si la valeur est hors de la plage `[0.0, 14.0]`, elle lève également une
`InvalidPhException`. Sinon, elle met à jour `lastPh` et retourne la valeur.

</details>

Ce code semble correct, mais comment en être sûr ? Si l'on exécute le programme
et que l'affichage est correct, cela prouve uniquement que le cas testé
manuellement fonctionne à cet instant précis.

### Ce qui nous manque

La vérification manuelle présente des lacunes importantes :

- Qui vérifie que `pH = 0.0` est accepté et que `pH = -0.1` est refusé ?
- Qui vérifie que `pH = 14.0` est accepté et que `pH = 14.1` est refusé ?
- Qui vérifie qu'une entrée `"abc"` lève bien une `InvalidPhException` ?
- Qui vérifie que `lastPh` n'est pas modifié après une entrée invalide ?
- Qui revérifie tout cela après chaque modification du code ?

Les tests unitaires répondent à ces questions de façon automatique et
reproductible. Ils s'exécutent en quelques millisecondes et signalent
immédiatement toute régression.

## Qu'est-ce qu'un test unitaire ?

### Définition

Un test unitaire vérifie le comportement d'une unité de code isolée —
généralement une méthode — dans un contexte contrôlé.

Un test unitaire est :

- Automatisé : exécuté par le code, pas par une personne.
- Reproductible : le même résultat à chaque exécution.
- Rapide : des millisecondes, pas des minutes.
- Indépendant : chaque test part d'un état propre.

### Les trois types de tests

Dans le développement logiciel, on distingue généralement trois niveaux de tests
:

| Type        | Quoi ?                         | Vitesse      |
| :---------- | :----------------------------- | :----------- |
| Unitaire    | Une méthode isolée.            | Très rapide. |
| Intégration | Plusieurs composants ensemble. | Moyen.       |
| Fonctionnel | L'application entière.         | Lent.        |

Dans ce cours, nous nous concentrons sur les tests unitaires, qui constituent la
base de toute stratégie de test. Ils sont les plus nombreux, les plus rapides et
les plus faciles à isoler.

### Un bon test unitaire

Un bon test unitaire est :

- Lisible : son nom décrit ce qu'il vérifie.
- Focalisé : il vérifie une seule chose.
- Déterministe : il donne toujours le même résultat.
- Indépendant : il ne dépend pas de l'ordre d'exécution des autres tests.

La convention de nommage utilisée dans ce cours suit le schéma :

```text
méthode_contexte_résultatAttendu
```

Par exemple : `readFromString_formatInvalide_leveInvalidPhException`. Ce nom
indique clairement quelle méthode est testée (`readFromString`), dans quel
contexte (format invalide), et quel résultat est attendu (lève une
`InvalidPhException`).

> [!TIP]
>
> Un test dont le nom est difficile à formuler est souvent un test qui vérifie
> trop de choses à la fois. Si l'on ne sait pas quoi mettre dans le nom, c'est
> un signal pour le diviser.

## Le patron AAA

### Arrange, Act, Assert

Tous les tests unitaires suivent un patron structurant en trois étapes, appelé
AAA :

1. Arrange : préparer l'état initial (créer les objets, initialiser les
   données).
2. Act : appeler la méthode à tester.
3. Assert : vérifier que le résultat est bien celui attendu.

Ce patron rend les tests lisibles d'un coup d'oeil : on sait immédiatement où se
trouve la préparation, l'action et la vérification.

### AAA en pratique

Voici un exemple complet avec les trois étapes bien séparées :

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

<details>
<summary>Description du code</summary>

L'étape Arrange crée un capteur avec l'identifiant `"TEST-01"`. L'étape Act
appelle `readFromString("7.0")` et stocke le résultat dans `result`. L'étape
Assert vérifie que `result` vaut `7.0`. Si ce n'est pas le cas, JUnit signale
l'échec du test.

</details>

L'annotation `@Test` indique à JUnit que cette méthode est un test à exécuter.
La méthode déclare `throws InvalidPhException` parce que `readFromString` est
une méthode vérifiée : si JUnit laisse propager l'exception, le test échoue avec
un message d'erreur explicite.

### @BeforeEach : déléguer l'étape Arrange

Dans une classe de test, la plupart des méthodes de test commencent par la même
étape Arrange : créer un `WaterSensor` frais. Répéter cette ligne dans chaque
test alourdit le code.

JUnit fournit l'annotation `@BeforeEach` pour factoriser cette préparation. Une
méthode annotée `@BeforeEach` est exécutée automatiquement avant chaque méthode
de test. Elle est idéale pour déléguer l'étape Arrange :

```java
@BeforeEach
void setUp() {
    sensor = new WaterSensor("TEST-01");
}
```

<details>
<summary>Description du code</summary>

La méthode `setUp()` est annotée `@BeforeEach`, ce qui signifie que JUnit
l'appelle avant chaque méthode de test. Elle initialise le champ `sensor` avec
un nouveau `WaterSensor` portant l'identifiant `"TEST-01"`. Chaque test dispose
ainsi d'un capteur dans un état initial propre, sans que l'un puisse influencer
l'autre.

</details>

> [!NOTE]
>
> L'annotation `@BeforeEach` garantit l'indépendance des tests : même si un test
> modifie l'état du capteur, le suivant repart toujours d'un état propre.

## JUnit : mise en place

### Le JAR autonome

JUnit est distribué sous la forme d'un seul fichier JAR autonome qui contient
tout le nécessaire pour écrire et exécuter des tests, sans Maven ni Gradle.

Le fichier à obtenir est : `junit-platform-console-standalone-6.0.3.jar`

Il doit être placé dans le répertoire `lib/` du projet.

**Si vous avez cloné le dépôt du cours localement**, un script automatise le
téléchargement depuis Maven Central. Depuis le répertoire `03-mini-projet/` :

```shell
bash setup.sh
```

**Si vous n'avez pas le dépôt localement**, créez la structure manuellement,
puis téléchargez le JAR avec `curl` ou `wget` :

```shell
mkdir -p lib
curl -L -o lib/junit-platform-console-standalone-6.0.3.jar \
  https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/6.0.3/junit-platform-console-standalone-6.0.3.jar
```

Dans les deux cas, après exécution, le fichier
`junit-platform-console-standalone-6.0.3.jar` est disponible dans le répertoire
`lib/`.

### Structure du projet

Le mini-projet suit la structure suivante :

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

Les classes de production (`WaterSensor`, `InvalidPhException`) et la classe de
test (`WaterSensorTest`) cohabitent dans le même répertoire `src/`. Lors de la
compilation, les fichiers `.class` sont générés dans `out/`.

## Écrire des tests

### La classe de test

Une classe de test est une classe Java ordinaire dont le nom se termine par
`Test`. Elle ne nécessite aucune déclaration spéciale, mais doit importer les
annotations et méthodes de JUnit :

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

<details>
<summary>Description du code</summary>

L'import statique `assertEquals` permet d'appeler cette méthode directement sans
préfixe de classe. Les imports `BeforeEach` et `Test` sont les annotations
utilisées pour déclarer la méthode de préparation et les méthodes de test. Le
champ `sensor` est déclaré au niveau de la classe pour être accessible par
toutes les méthodes de test. La méthode `setUp()` annotée `@BeforeEach` recrée
un capteur frais avant chaque test.

</details>

### @Test et assertEquals

L'annotation `@Test` marque une méthode comme un test JUnit. La méthode
`assertEquals(attendu, obtenu)` vérifie que deux valeurs sont égales. Si elles
ne le sont pas, le test échoue et JUnit affiche les deux valeurs pour faciliter
le diagnostic.

L'ordre des arguments est important : la valeur attendue (celle que l'on connaît
à l'avance) vient en premier, la valeur obtenue (le résultat réel) vient en
second.

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

<details>
<summary>Description du code</summary>

Le premier test vérifie que `getId()` retourne bien l'identifiant fourni lors de
la construction. Le second vérifie que `getLastPh()` retourne `0.0` juste après
la construction, avant toute lecture. Ces deux tests couvrent le comportement du
constructeur.

</details>

### Les assertions courantes

JUnit fournit plusieurs méthodes d'assertion, toutes disponibles dans
`org.junit.jupiter.api.Assertions` :

| Méthode                      | Vérifie                                    |
| :--------------------------- | :----------------------------------------- |
| `assertEquals(a, b)`         | `a` est égal à `b`.                        |
| `assertTrue(condition)`      | `condition` est vraie.                     |
| `assertFalse(condition)`     | `condition` est fausse.                    |
| `assertNull(objet)`          | `objet` est `null`.                        |
| `assertNotNull(objet)`       | `objet` n'est pas `null`.                  |
| `assertThrows(Type, lambda)` | Le code lève une exception du type `Type`. |

> [!NOTE]
>
> L'ordre `assertEquals(attendu, obtenu)` est une convention JUnit. Si l'on
> inverse les arguments, les tests fonctionnent de la même façon, mais les
> messages d'erreur (`expected: X but was: Y`) seront inversés et prêteront à
> confusion.

### Tester les valeurs limites

Les valeurs aux bornes d'une plage autorisée sont les plus susceptibles de
contenir des bugs : une condition `<` au lieu de `<=`, ou une constante
légèrement mal saisie. Il est donc indispensable de les tester explicitement.

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

@Test
void readFromString_phTropBas_leveInvalidPhException() {
    assertThrows(InvalidPhException.class,
        () -> sensor.readFromString("-1.0"));
}

@Test
void readFromString_phTropEleve_leveInvalidPhException() {
    assertThrows(InvalidPhException.class,
        () -> sensor.readFromString("15.0"));
}
```

<details>
<summary>Description du code</summary>

Les deux premiers tests vérifient que les valeurs exactement aux bornes de la
plage valide (`0.0` et `14.0`) sont acceptées. Les deux suivants vérifient que
les premières valeurs hors plage (`-1.0` et `15.0`) lèvent bien une
`InvalidPhException`. Ces quatre tests ensemble garantissent que la plage
`[0.0, 14.0]` est correctement implémentée.

</details>

### Tester les exceptions

Pour vérifier qu'une méthode lève bien une exception dans un cas donné, on
utilise `assertThrows`. Cette méthode prend le type d'exception attendu et une
expression lambda contenant le code à exécuter.

```java
import static org.junit.jupiter.api.Assertions.assertThrows;

@Test
void readFromString_formatInvalide_leveInvalidPhException() {
    assertThrows(InvalidPhException.class,
        () -> sensor.readFromString("abc"));
}
```

<details>
<summary>Description du code</summary>

Le premier argument de `assertThrows` est la classe de l'exception attendue. Le
second est une expression lambda `() -> ...` qui contient le code à exécuter.
JUnit exécute le lambda, et le test réussit si et seulement si le code lève bien
une exception du type indiqué. Si aucune exception n'est levée, ou si une
exception d'un autre type est levée, le test échoue.

</details>

Contrairement aux tests qui déclarent `throws InvalidPhException`, les tests
avec `assertThrows` ne déclarent aucune exception propagée : le lambda absorbe
l'exception attendue, et JUnit vérifie son type.

### Tester les effets de bord

Certaines méthodes modifient l'état d'un objet en plus de retourner une valeur.
Il est important de vérifier que cet état est modifié correctement dans les cas
nominaux, et qu'il n'est pas modifié en cas d'erreur.

```java
@Test
void readFromString_valeurNominale_metAJourLastPh()
        throws InvalidPhException {
    sensor.readFromString("6.5");
    assertEquals(6.5, sensor.getLastPh());
}

@Test
void readFromString_erreurFormat_lastPhInchange()
        throws InvalidPhException {
    sensor.readFromString("7.0");
    try {
        sensor.readFromString("invalide");
    } catch (InvalidPhException e) {
        // exception attendue, on continue
    }
    assertEquals(7.0, sensor.getLastPh());
}
```

<details>
<summary>Description du code</summary>

Le premier test vérifie que `lastPh` est bien mis à jour après une lecture
réussie. Le second teste qu'une lecture invalide ne modifie pas `lastPh` : on
lit d'abord `"7.0"` avec succès, puis on tente `"invalide"` en absorbant
manuellement l'exception attendue (pour ne pas faire échouer le test pour la
mauvaise raison), et on vérifie que `lastPh` vaut toujours `7.0`.

</details>

## Compiler et exécuter

### Compilation

La compilation se fait en une seule commande qui inclut à la fois les classes de
production et la classe de test :

```shell
javac \
  -cp lib/junit-platform-console-standalone-6.0.3.jar \
  src/*.java \
  -d out/
```

<details>
<summary>Description de la commande</summary>

L'option `-cp` (classpath) indique à Java où trouver les classes de JUnit.
`src/*.java` compile tous les fichiers `.java` du répertoire `src/`. L'option
`-d out/` place les fichiers `.class` générés dans le répertoire `out/`.

</details>

### Exécution

Une fois la compilation terminée, on lance JUnit avec la commande suivante :

```shell
java -jar lib/junit-platform-console-standalone-6.0.3.jar execute \
  --class-path out/ \
  --scan-class-path
```

<details>
<summary>Description de la commande</summary>

L'option `execute` lance l'exécution des tests. `--class-path out/` indique à
JUnit où trouver les classes compilées. `--scan-class-path` demande à JUnit de
découvrir automatiquement toutes les classes de test présentes dans le
classpath. JUnit détecte les classes de test en cherchant les méthodes annotées
`@Test`.

</details>

### Lire les résultats

JUnit affiche un rapport dans le terminal :

```text
└─ WaterSensorTest ✔
   ├─ getId_retourneIdentifiantFourni() ✔
   ├─ getLastPh_retourneZeroApresConstruction() ✔
   ├─ readFromString_valeurNominale_retourneValeur() ✔
   ├─ readFromString_borneMinimale_accepte() ✔
   ├─ readFromString_borneMaximale_accepte() ✔
   ├─ readFromString_formatInvalide_leveInvalidPhException() ✔
   ├─ readFromString_phTropEleve_leveInvalidPhException() ✔
   ├─ readFromString_phTropBas_leveInvalidPhException() ✔
   ├─ readFromString_valeurNominale_metAJourLastPh() ✔
   └─ readFromString_erreurFormat_lastPhInchange() ✔

[  10 tests found  |  10 successful  |  0 failed  ]
```

Chaque `✔` indique que le test correspondant a réussi. Le résumé final donne le
nombre total de tests trouvés, de succès et d'échecs.

### Quand un test échoue

Si un test échoue, JUnit affiche un `✘` et un message d'erreur détaillé :

```text
└─ WaterSensorTest ✘
   └─ getId_retourneIdentifiantFourni() ✘

org.opentest4j.AssertionFailedError:
expected: <TEST-01>
 but was: <MAUVAIS-ID>
```

JUnit indique la valeur attendue et la valeur obtenue. Cela permet de localiser
rapidement le problème dans le code de production.

## La valeur des tests

### Le filet de sécurité

Imaginons qu'on introduise un bug dans `WaterSensor` : on supprime
accidentellement la validation de la plage de pH.

```java
// Bug : la validation a été supprimée
// if (value < MIN_PH || value > MAX_PH) {
//     throw new InvalidPhException(this.id, value);
// }
this.lastPh = value;
return value;
```

En relançant les tests, JUnit détecte immédiatement les régressions :

```text
readFromString_phTropEleve_leveInvalidPhException ✘
readFromString_phTropBas_leveInvalidPhException ✘

[  10 tests found  |  8 successful  |  2 failed  ]
```

Sans les tests, ce bug pourrait passer inaperçu jusqu'en production et produire
des données de surveillance erronées.

### Le développement piloté par les tests

Le développement piloté par les tests (_Test-Driven Development_, TDD) inverse
l'ordre habituel de travail :

1. Écrire le test avant le code de production.
2. Constater que le test échoue (rouge).
3. Écrire le code minimal pour faire passer le test (vert).
4. Améliorer le code sans casser les tests (refactorisation).

Ce cycle, appelé rouge-vert-refactorisation, force à réfléchir au comportement
attendu avant de l'implémenter. Il en résulte un code mieux conçu et entièrement
couvert par des tests dès le départ.

> [!TIP]
>
> Le TDD n'est pas une obligation. Il est toutefois utile de l'expérimenter sur
> un petit exemple pour comprendre comment il change la façon d'aborder un
> problème.

### La couverture de code

La couverture de code mesure le pourcentage de lignes de code exécutées lors de
l'exécution des tests. Elle aide à identifier les zones non testées, mais n'est
pas une fin en soi.

Pour un code de qualité, il convient de tester :

- Les cas nominaux : valeurs normales que la méthode doit accepter.
- Les valeurs limites : bornes d'une plage, premier et dernier élément d'une
  liste, etc.
- Les cas d'erreur : format invalide, valeur hors plage, argument `null`, etc.

> [!WARNING]
>
> Une couverture de 100 % ne garantit pas l'absence de bugs. Il est possible
> d'exécuter toutes les lignes sans vérifier tous les comportements. La
> couverture est un indicateur, pas une garantie.

### Pourquoi les tests perdurent

Un test écrit aujourd'hui continue de fonctionner dans six mois, quand :

- Une nouvelle personne rejoint l'équipe et modifie du code existant.
- Une dépendance est mise à jour.
- Une fonctionnalité est refactorisée.

Les tests constituent une documentation vivante du comportement attendu. A la
différence des commentaires ou des spécifications, ils ne peuvent pas devenir
obsolètes silencieusement : si le comportement change, les tests échouent et
alertent immédiatement.

## Conclusion

Les tests unitaires sont un outil fondamental du développement logiciel
professionnel. Cette séance a présenté les concepts et les outils de base pour
écrire des tests en Java avec JUnit.

Les éléments vus dans cette séance sont :

- Le patron AAA (Arrange-Act-Assert) pour structurer chaque test.
- L'annotation `@BeforeEach` pour factoriser l'étape Arrange.
- L'annotation `@Test` pour déclarer les méthodes de test.
- Les assertions `assertEquals`, `assertTrue`, `assertFalse`, `assertNull`,
  `assertNotNull` et `assertThrows`.
- La notion de valeurs limites et d'effets de bord à tester.
- Le cycle rouge-vert-refactorisation du TDD.

La question "quoi tester ?" sera une constante dans la pratique. La réponse
dépend du contexte et de la criticité du code. Une bonne heuristique est de
commencer par les cas nominaux, puis les valeurs limites, puis les cas d'erreur.

## Aller plus loin

Pour approfondir les tests unitaires en Java :

- [Écrire des tests avec JUnit 6 (docs.junit.org)](https://docs.junit.org/6.0.3/writing-tests/intro.html)
- [JUnit 5 User Guide (junit.org)](https://junit.org/junit5/docs/current/user-guide/)
- [JUnit 5 API - Annotations (javadoc.io)](https://javadoc.io/doc/org.junit.jupiter/junit-jupiter-api/latest/org/junit/jupiter/api/package-summary.html)
- _Effective Software Testing_, Maurício Aniche (Manning, 2022) : une approche
  systématique du test de logiciel.
- _Test-Driven Development: By Example_, Kent Beck (Addison-Wesley, 2002) : la
  référence du TDD.

## Exemples de code

Nous vous invitons à consulter les exemples de code associés à ce contenu de
cours pour mieux comprendre les concepts abordés.

Vous trouverez les exemples de code ici :
[Exemples de code](./01-exemples-de-code/).

## Exercices

Nous vous invitons maintenant à réaliser les exercices de la séance afin de
mettre en pratique les concepts abordés.

Vous trouverez les exercices et leur corrigé ici : [Exercices](./02-exercices/).

## Mini-projet

Nous vous invitons maintenant à réaliser le mini-projet de la séance afin de
mettre en pratique les concepts abordés.

Vous trouverez les détails du mini-projet ici :
[Mini-projet](./03-mini-projet/).

## À faire pour la prochaine séance

Chaque personne est libre de gérer son temps comme elle le souhaite. Cependant,
il est recommandé pour la prochaine séance de :

- Relire le support de cours si nécessaire.
- Relire les exemples de code et leur description pour bien comprendre les
  concepts.
- Finaliser les exercices qui n'ont pas été terminés en classe.
- Finaliser la partie du mini-projet qui n'a pas été terminée en classe.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
[quiz-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/12-tests-unitaires-avec-junit/quiz.html
[presentation-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/12-tests-unitaires-avec-junit/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/12-tests-unitaires-avec-junit/12-tests-unitaires-avec-junit-presentation.pdf
