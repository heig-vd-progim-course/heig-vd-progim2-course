# Tests unitaires avec JUnit - Mini-projet : Système de surveillance de l'eau

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Trouvez d'autres informations relatives à ce contenu dans le
> [contenu principal](../).

## Table des matières

- [Table des matières](#table-des-matières)
- [Présentation du mini-projet](#présentation-du-mini-projet)
- [Objectifs de cette session](#objectifs-de-cette-session)
- [Structure du projet](#structure-du-projet)
- [Étape 1 : télécharger JUnit](#étape-1--télécharger-junit)
  - [Linux et macOS](#linux-et-macos)
  - [Windows](#windows)
- [Étape 2 : créer le dossier de compilation](#étape-2--créer-le-dossier-de-compilation)
- [Étape 3 : écrire le premier test](#étape-3--écrire-le-premier-test)
  - [Structure d'une classe de test](#structure-dune-classe-de-test)
  - [Tester le constructeur et les accesseurs](#tester-le-constructeur-et-les-accesseurs)
- [Étape 4 : compiler et exécuter les tests](#étape-4--compiler-et-exécuter-les-tests)
  - [Compilation](#compilation)
  - [Exécution](#exécution)
  - [Sortie attendue](#sortie-attendue)
- [Étape 5 : tester les cas nominaux](#étape-5--tester-les-cas-nominaux)
- [Étape 6 : tester les cas d'erreur avec assertThrows](#étape-6--tester-les-cas-derreur-avec-assertthrows)
- [Étape 7 : vérifier les effets de bord](#étape-7--vérifier-les-effets-de-bord)
- [Résultat final](#résultat-final)
- [Configurer son IDE](#configurer-son-ide)
  - [IntelliJ IDEA](#intellij-idea)
  - [Visual Studio Code](#visual-studio-code)
- [Solution](#solution)
- [Conclusion](#conclusion)
- [Aller plus loin](#aller-plus-loin)

## Présentation du mini-projet

Dans les sessions précédentes, vous avez construit un **système de surveillance
de la qualité de l'eau** composé de trois classes :

- `WaterSensor` : lit et valide des mesures de pH.
- `InvalidPhException` : exception levée pour une valeur invalide.
- `WaterMonitor` : orchestre plusieurs capteurs et affiche un résumé.

Le code fonctionne, mais comment savoir avec certitude que `WaterSensor` se
comporte correctement dans tous les cas ? Et comment s'assurer qu'une
modification future ne casse pas ce qui marche déjà ?

La réponse : les **tests unitaires**. Dans cette session, vous allez ajouter une
classe de test à ce projet, sans modifier le code existant.

## Objectifs de cette session

À l'issue de cette session, vous devriez avoir pu :

- Télécharger JUnit sans gestionnaire de dépendances.
- Créer une classe de test JUnit avec `@Test` et `@BeforeEach`.
- Écrire des assertions avec `assertEquals()` et `assertThrows()`.
- Appliquer la structure Arrange-Act-Assert à chaque test.
- Compiler et exécuter les tests depuis le terminal.

## Structure du projet

```text
12-tests-unitaires-avec-junit/
└── 03-mini-projet/
    ├── setup.sh                    (script de téléchargement de JUnit)
    ├── lib/                        (créé par setup.sh)
    │   └── junit-platform-console-standalone-6.0.3.jar
    ├── src/
    │   ├── InvalidPhException.java (repris de la session 11)
    │   ├── WaterMonitor.java       (repris de la session 11)
    │   ├── WaterSensor.java        (repris de la session 11)
    │   └── WaterSensorTest.java    (à créer dans cette session)
    └── out/                        (créé lors de la compilation)
```

Les fichiers `src/InvalidPhException.java`, `src/WaterMonitor.java` et
`src/WaterSensor.java` sont fournis : il s'agit du code produit lors de la
session 11. Vous n'avez pas à les modifier.

## Étape 1 : télécharger JUnit

JUnit est distribué sous forme d'un fichier JAR autonome qui contient tout le
nécessaire pour écrire et exécuter des tests. Un script de téléchargement est
fourni avec ce mini-projet.

### Linux et macOS

Ouvrez un terminal dans le dossier `03-mini-projet/` et exécutez :

```shell
bash setup.sh
```

Le script télécharge JUnit 6.0.3 et le place dans le dossier `lib/`. Si le
fichier est déjà présent, le script ne télécharge rien.

Vous devriez voir :

```text
Téléchargement de JUnit 6.0.3...
JUnit 6.0.3 téléchargé avec succès dans lib/.
```

### Windows

Sur Windows, le script `setup.sh` peut être exécuté dans **Git Bash** (inclus
avec Git for Windows) ou dans **WSL** (Windows Subsystem for Linux).

Si vous préférez ne pas utiliser de terminal, vous pouvez télécharger le fichier
JAR manuellement :

1. Rendez-vous sur la page de téléchargement :
   <https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/6.0.3/junit-platform-console-standalone-6.0.3.jar>
2. Enregistrez le fichier dans un dossier `lib/` que vous créez à l'intérieur
   de `03-mini-projet/`.

> [!NOTE]
>
> Si vous utilisez IntelliJ IDEA, consultez la section
> [Configurer son IDE](#intellij-idea) pour une approche alternative.

## Étape 2 : créer le dossier de compilation

Le compilateur Java (`javac`) a besoin d'un dossier où placer les fichiers
compilés. Créez-le :

```shell
mkdir out
```

Ce dossier est créé une seule fois. Vous n'avez pas à le recréer à chaque
compilation.

## Étape 3 : écrire le premier test

Créez le fichier `src/WaterSensorTest.java`.

### Structure d'une classe de test

Une classe de test JUnit suit toujours la même structure de base :

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

Importation statique de la méthode `assertEquals` depuis
`org.junit.jupiter.api.Assertions`.

Importation des annotations `BeforeEach` et `Test` depuis le package
`org.junit.jupiter.api`.

Déclaration de la classe `WaterSensorTest` sans modificateur d'accès.

Déclaration d'un champ d'instance `sensor` de type `WaterSensor`, initialisé à
`null`.

Déclaration de la méthode `setUp()` annotée `@BeforeEach` : JUnit appelle cette
méthode avant chaque méthode de test. Elle instancie un nouveau `WaterSensor`
avec l'identifiant `"TEST-01"` et l'affecte au champ `sensor`.

</details>

> [!NOTE]
>
> `@BeforeEach` garantit que chaque test part d'un état propre : un capteur
> fraîchement créé, sans historique de lecture.

### Tester le constructeur et les accesseurs

Ajoutez deux premiers tests dans la classe `WaterSensorTest` :

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

Déclaration de la méthode `getId_retourneIdentifiantFourni()` annotée `@Test` :
JUnit la reconnaît comme un test à exécuter.

Appel de `assertEquals("TEST-01", sensor.getId())` : comparaison de la valeur
attendue `"TEST-01"` avec la valeur retournée par `sensor.getId()`. Le test
échoue si les deux valeurs sont différentes.

Déclaration de la méthode `getLastPh_retourneZeroApresConstruction()` annotée
`@Test`.

Appel de `assertEquals(0.0, sensor.getLastPh())` : vérification que la valeur
initiale de `lastPh` est bien `0.0` après construction.

</details>

La structure de chaque test suit le patron **Arrange-Act-Assert** :

- **Arrange** : préparer l'état initial (`@BeforeEach` s'en charge ici).
- **Act** : appeler la méthode à tester (`sensor.getId()`).
- **Assert** : vérifier le résultat (`assertEquals`).

## Étape 4 : compiler et exécuter les tests

### Compilation

Compilez l'ensemble des fichiers sources et de tests en une seule commande :

```shell
javac -cp lib/junit-platform-console-standalone-6.0.3.jar src/*.java -d out/
```

> [!NOTE]
>
> Sur Windows (invite de commandes), remplacez `:` par `;` dans le classpath :
>
> ```shell
> javac -cp "lib\junit-platform-console-standalone-6.0.3.jar" src\*.java -d out\
> ```

### Exécution

Lancez les tests avec le lanceur de console JUnit :

```shell
java -jar lib/junit-platform-console-standalone-6.0.3.jar execute \
  --class-path out/ \
  --scan-class-path
```

> [!NOTE]
>
> Sur Windows (invite de commandes) :
>
> ```shell
> java -jar lib\junit-platform-console-standalone-6.0.3.jar execute ^
>   --class-path out\ ^
>   --scan-class-path
> ```

### Sortie attendue

```text
╷
├─ JUnit Platform Suite ✔
├─ JUnit Jupiter ✔
│  └─ WaterSensorTest ✔
│     ├─ getId_retourneIdentifiantFourni() ✔
│     └─ getLastPh_retourneZeroApresConstruction() ✔
└─ JUnit Vintage ✔

Test run finished after 56 ms
[         4 containers found      ]
[         0 containers skipped    ]
[         4 containers started    ]
[         0 containers aborted    ]
[         4 containers successful ]
[         0 containers failed     ]
[         2 tests found           ]
[         0 tests skipped         ]
[         2 tests started         ]
[         0 tests aborted         ]
[         2 tests successful      ]
[         0 tests failed          ]
```

Les deux tests passent. Vous pouvez maintenant en ajouter d'autres.

## Étape 5 : tester les cas nominaux

Ajoutez des tests pour vérifier que `readFromString` fonctionne correctement
avec des valeurs valides :

```java
    @Test
    void readFromString_valeurNominale_retourneValeur()
            throws InvalidPhException {
        double result = sensor.readFromString("7.0");
        assertEquals(7.0, result);
    }

    @Test
    void readFromString_valeurNominale_metAJourLastPh()
            throws InvalidPhException {
        sensor.readFromString("6.5");
        assertEquals(6.5, sensor.getLastPh());
    }

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

<details>
<summary>Description du code</summary>

Chaque méthode de test déclare `throws InvalidPhException` car `readFromString`
est une méthode vérifiée qui peut lever cette exception. Ici, les valeurs
fournies sont valides, donc l'exception ne sera pas levée.

Appel de `sensor.readFromString("7.0")` suivi d'un `assertEquals(7.0, result)`
: vérification que la valeur retournée correspond à la valeur parsée.

Appel de `sensor.readFromString("6.5")` puis `assertEquals(6.5,
sensor.getLastPh())` : vérification que l'attribut `lastPh` est mis à jour après
une lecture réussie.

Les deux derniers tests vérifient les **valeurs limites** : `0.0` (minimum
autorisé) et `14.0` (maximum autorisé). Ces cas limites sont importants car ce
sont souvent là que les bugs apparaissent.

</details>

Recompilez et relancez les tests pour vérifier que les quatre nouveaux tests
passent.

## Étape 6 : tester les cas d'erreur avec assertThrows

`WaterSensor.readFromString()` doit lever une `InvalidPhException` pour toute
valeur invalide. Ajoutez des tests qui vérifient ce comportement :

```java
    @Test
    void readFromString_formatInvalide_leveInvalidPhException() {
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("abc"));
    }

    @Test
    void readFromString_phTropEleve_leveInvalidPhException() {
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("15.0"));
    }

    @Test
    void readFromString_phTropBas_leveInvalidPhException() {
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("-1.0"));
    }
```

<details>
<summary>Description du code</summary>

Importation statique d'`assertThrows` à ajouter en tête de fichier :
`import static org.junit.jupiter.api.Assertions.assertThrows;`

Appel de `assertThrows(InvalidPhException.class, () ->
sensor.readFromString("abc"))` : vérification qu'une `InvalidPhException` est
bien levée lors de l'appel à `readFromString` avec la valeur `"abc"`. L'argument
`() -> sensor.readFromString("abc")` est une expression lambda passée comme
code à exécuter. Le test échoue si aucune exception n'est levée ou si une
exception d'un type différent est levée.

Les deux tests suivants utilisent le même mécanisme pour vérifier les cas de pH
hors plage : `15.0` (supérieur à 14.0) et `-1.0` (inférieur à 0.0).

</details>

> [!NOTE]
>
> Ces tests ne déclarent pas `throws InvalidPhException` car `assertThrows`
> capture l'exception à l'intérieur du lambda : elle ne se propage jamais
> jusqu'à la méthode de test.

## Étape 7 : vérifier les effets de bord

Un test utile vérifie qu'une lecture échouée ne modifie pas `lastPh` :

```java
    @Test
    void readFromString_erreurFormat_lastPhInchange()
            throws InvalidPhException {
        sensor.readFromString("7.0");
        try {
            sensor.readFromString("invalide");
        } catch (InvalidPhException e) {
            // exception attendue : on la capture pour continuer le test
        }
        assertEquals(7.0, sensor.getLastPh());
    }
```

<details>
<summary>Description du code</summary>

Appel de `sensor.readFromString("7.0")` : mise en état initiale avec une lecture
valide qui positionne `lastPh` à `7.0`.

Bloc `try-catch` : appel de `sensor.readFromString("invalide")` qui lève une
`InvalidPhException`. L'exception est capturée dans le bloc `catch` pour que le
test puisse continuer.

Appel de `assertEquals(7.0, sensor.getLastPh())` : vérification que `lastPh`
n'a pas été modifié par la tentative de lecture invalide.

</details>

## Résultat final

Recompilez et relancez les tests une dernière fois. La sortie attendue est :

```text
╷
├─ JUnit Platform Suite ✔
├─ JUnit Jupiter ✔
│  └─ WaterSensorTest ✔
│     ├─ readFromString_valeurNominale_metAJourLastPh() ✔
│     ├─ getLastPh_retourneZeroApresConstruction() ✔
│     ├─ getId_retourneIdentifiantFourni() ✔
│     ├─ readFromString_formatInvalide_leveInvalidPhException() ✔
│     ├─ readFromString_phTropBas_leveInvalidPhException() ✔
│     ├─ readFromString_valeurNominale_retourneValeur() ✔
│     ├─ readFromString_phTropEleve_leveInvalidPhException() ✔
│     ├─ readFromString_erreurFormat_lastPhInchange() ✔
│     ├─ readFromString_borneMinimale_accepte() ✔
│     └─ readFromString_borneMaximale_accepte() ✔
└─ JUnit Vintage ✔

Test run finished after 59 ms
[         4 containers found      ]
[         0 containers skipped    ]
[         4 containers started    ]
[         0 containers aborted    ]
[         4 containers successful ]
[         0 containers failed     ]
[        10 tests found           ]
[         0 tests skipped         ]
[        10 tests started         ]
[         0 tests aborted         ]
[        10 tests successful      ]
[         0 tests failed          ]
```

## Configurer son IDE

Les commandes présentées ci-dessus fonctionnent depuis n'importe quel terminal.
Les IDE peuvent en plus afficher les résultats de tests directement dans
l'éditeur.

### IntelliJ IDEA

IntelliJ reconnaît nativement JUnit et propose une intégration complète (icônes
dans la marge, résultats en arborescence, relance test par test).

1. Ouvrez le dossier `03-mini-projet/` dans IntelliJ IDEA (_File_ > _Open_).
2. Ouvrez la fenêtre _Project Structure_ (`Ctrl+Alt+Shift+S` / `⌘;`).
3. Allez dans _Libraries_ > cliquez sur `+` > _Java_.
4. Sélectionnez le fichier `lib/junit-platform-console-standalone-6.0.3.jar`.
5. Cliquez sur _OK_ pour confirmer.
6. Marquez le dossier `src/` comme _Sources Root_ si IntelliJ ne l'a pas fait
   automatiquement (clic droit sur le dossier > _Mark Directory as_ > _Sources
   Root_).

Vous pouvez maintenant lancer les tests en cliquant sur l'icône verte dans la
marge à côté de `class WaterSensorTest` ou de chaque méthode de test.

> [!TIP]
>
> IntelliJ propose aussi de télécharger JUnit automatiquement lorsqu'il détecte
> une annotation `@Test` dans un fichier sans JUnit sur le classpath. Vous
> pouvez utiliser cette fonctionnalité à la place de `setup.sh` si vous le
> préférez.

### Visual Studio Code

Avec l'extension **Extension Pack for Java** (déjà installée dans
l'environnement du cours), VS Code peut exécuter les tests JUnit depuis l'onglet
_Testing_ (icône ballon dans la barre latérale).

Pour que VS Code trouve le JAR JUnit :

1. Ouvrez les paramètres de l'espace de travail (`.vscode/settings.json`).
2. Ajoutez la ligne suivante :

   ```json
   "java.project.referencedLibraries": [
       "01-contenus-du-cours/12-tests-unitaires-avec-junit/03-mini-projet/lib/**/*.jar"
   ]
   ```

3. Rechargez la fenêtre (_Ctrl+Shift+P_ > _Reload Window_).

VS Code découvre alors la classe `WaterSensorTest` et affiche les tests dans
l'onglet _Testing_.

> [!NOTE]
>
> Si vous utilisez la ligne de commande (recommandé pour comprendre ce qui se
> passe), cette configuration n'est pas nécessaire.

## Solution

La solution complète est disponible dans le dossier
[`solution/`](./solution/).

> [!NOTE]
>
> La solution est fournie à titre indicatif. Réalisez le mini-projet par
> vous-même avant de la consulter.

Pour compiler et exécuter la solution :

```shell
# Depuis 03-mini-projet/
bash setup.sh
mkdir -p out/
javac -cp lib/junit-platform-console-standalone-6.0.3.jar \
  src/*.java solution/test/*.java -d out/
java -jar lib/junit-platform-console-standalone-6.0.3.jar execute \
  --class-path out/ --scan-class-path
```

## Conclusion

Vous avez ajouté dix tests unitaires à un projet existant sans en modifier le
code de production. Vous avez couvert :

- les cas nominaux (valeurs valides, valeurs limites),
- les cas d'erreur (format invalide, pH hors plage),
- les effets de bord (état interne non modifié après une erreur).

Ces tests constituent un **filet de sécurité** : si vous modifiez `WaterSensor`
dans le futur, ils vous alerteront immédiatement si quelque chose se casse.

## Aller plus loin

> [!TIP]
>
> Cette section est optionnelle.

- Pourriez-vous écrire des tests pour `WaterMonitor` ? Quelles difficultés
  rencontreriez-vous avec une méthode qui écrit sur `System.out` ?
- JUnit permet de paramétrer un test pour qu'il s'exécute avec plusieurs valeurs
  via `@ParameterizedTest`. Seriez-vous capable de regrouper les trois tests
  `phTropEleve`, `phTropBas` et `formatInvalide` en un seul test paramétré ?
  Référez-vous à la documentation :
  <https://docs.junit.org/6.0.3/writing-tests/parameterized-tests.html>

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
