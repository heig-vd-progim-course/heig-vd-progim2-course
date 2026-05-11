# Démo en direct : tests unitaires JUnit (séance 12)

Ce guide explique comment montrer les tests unitaires en direct pendant la
séance 12, en utilisant les fichiers du dépôt comme support. La démo reprend le
projet de surveillance de l'eau construit à la séance 11 et y ajoute des tests
pas à pas.

## Table des matières

- [Table des matières](#table-des-matières)
- [Préparation avant la séance](#préparation-avant-la-séance)
  - [Télécharger JUnit](#télécharger-junit)
  - [Tester la démo complète](#tester-la-démo-complète)
- [Déroulement de la démo](#déroulement-de-la-démo)
  - [Point de départ : le projet de la séance 11](#point-de-départ--le-projet-de-la-séance-11)
  - [Étape 1 : pourquoi tester ?](#étape-1--pourquoi-tester-)
  - [Étape 2 : structure minimale d'un test](#étape-2--structure-minimale-dun-test)
  - [Étape 3 : faire échouer un test volontairement](#étape-3--faire-échouer-un-test-volontairement)
  - [Étape 4 : tester les cas d'erreur avec assertThrows](#étape-4--tester-les-cas-derreur-avec-assertthrows)
  - [Étape 5 : montrer la valeur des tests](#étape-5--montrer-la-valeur-des-tests)
- [Commandes de référence](#commandes-de-référence)
- [Variante : démonstration dans IntelliJ IDEA](#variante--démonstration-dans-intellij-idea)

## Préparation avant la séance

### Télécharger JUnit

Les fichiers de la séance 12 se trouvent dans :

```text
01-contenus-du-cours/12-tests-unitaires-avec-junit/03-mini-projet/
```

Depuis ce dossier, lancez le script de téléchargement :

```shell
bash setup.sh
```

JUnit 6.0.3 est téléchargé dans `lib/`. Cette étape ne doit être faite qu'une
seule fois.

### Tester la démo complète

Avant la séance, vérifiez que tout fonctionne en compilant et en lançant les
tests de la solution :

```shell
# Depuis 12-tests-unitaires-avec-junit/03-mini-projet/
mkdir -p out/
javac -cp lib/junit-platform-console-standalone-6.0.3.jar \
  src/*.java solution/test/*.java -d out/
java -jar lib/junit-platform-console-standalone-6.0.3.jar execute \
  --class-path out/ --scan-class-path
```

Attendu : 10 tests, 0 échecs.

## Déroulement de la démo

### Point de départ : le projet de la séance 11

Ouvrez les trois fichiers sources dans votre éditeur :

```text
src/
├── InvalidPhException.java
├── WaterSensor.java
└── WaterMonitor.java
```

Compilez et exécutez `WaterMonitor` pour rappeler ce que les personnes ont
construit la semaine précédente :

```shell
mkdir -p out/
javac src/*.java -d out/
java -cp out/ WaterMonitor
```

Sortie attendue :

```text
=== Système de surveillance de la qualité de l'eau ===

--- Capteur PH-01 ---
Lecture OK : pH = 7.2
ALERTE : Valeur de pH hors plage pour le capteur PH-01 : 15.0 (attendu entre 0.0 et 14.0)
ALERTE : Valeur de pH hors plage pour le capteur PH-01 : NaN (attendu entre 0.0 et 14.0)
  Cause : For input string: "abc"
Lecture OK : pH = 8.1
Fin de lecture PH-01.

--- Capteur PH-02 ---
Lecture OK : pH = 6.9
Lecture OK : pH = 7.5
Fin de lecture PH-02.

=== Résumé ===
Lectures totales : 6
Erreurs          : 2
Taux de succès   : 66,7%
```

Posez la question : _"Comment sait-on que `WaterSensor` se comporte
correctement dans tous les cas ?"_ Laissez les personnes répondre, puis
introduisez les tests unitaires comme réponse.

### Étape 2 : structure minimale d'un test

Créez le fichier `src/WaterSensorTest.java` en direct :

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

    @Test
    void getId_retourneIdentifiantFourni() {
        assertEquals("TEST-01", sensor.getId());
    }
}
```

Compilez et exécutez :

```shell
javac -cp lib/junit-platform-console-standalone-6.0.3.jar src/*.java -d out/
java -jar lib/junit-platform-console-standalone-6.0.3.jar execute \
  --class-path out/ --scan-class-path
```

Montrez le résultat `✔` dans le terminal. Points à souligner :

- `@BeforeEach` crée un capteur frais avant chaque test.
- Le nom du test décrit ce qu'il vérifie.
- `assertEquals(valeur_attendue, valeur_obtenue)` : l'ordre compte.

### Étape 3 : faire échouer un test volontairement

Modifiez temporairement le test pour qu'il échoue :

```java
    @Test
    void getId_retourneIdentifiantFourni() {
        assertEquals("MAUVAIS-ID", sensor.getId()); // volontairement faux
    }
```

Recompilez et relancez. Montrez le message d'erreur :

```text
org.opentest4j.AssertionFailedError:
expected: <MAUVAIS-ID>
 but was: <TEST-01>
```

Restaurez ensuite la bonne valeur. Ce moment montre que JUnit détecte vraiment
les régressions.

### Étape 4 : tester les cas d'erreur avec assertThrows

Ajoutez un test d'exception pour montrer `assertThrows` :

```java
import static org.junit.jupiter.api.Assertions.assertThrows;

    @Test
    void readFromString_formatInvalide_leveInvalidPhException() {
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("abc"));
    }
```

Insistez sur le fait que le test vérifie le comportement du code face à une
entrée invalide, sans avoir besoin d'exécuter tout le système.

### Étape 5 : montrer la valeur des tests

Pour conclure la démo, introduisez volontairement un bug dans `WaterSensor` :
supprimez temporairement la validation de la plage :

```java
// Commentez temporairement ces lignes dans WaterSensor.readFromString :
// if (value < MIN_PH || value > MAX_PH) {
//     throw new InvalidPhException(this.id, value);
// }
```

Recompilez et relancez les tests. Le test `readFromString_phTropEleve` échoue
immédiatement. Restaurez le code et montrez que les tests repassent.

Ce moment illustre concrètement la phrase : _"les tests sont un filet de
sécurité"_.

## Commandes de référence

Depuis le dossier `03-mini-projet/` :

| Action | Commande |
| :----- | :------- |
| Télécharger JUnit | `bash setup.sh` |
| Compiler sources + tests | `javac -cp lib/junit-platform-console-standalone-6.0.3.jar src/*.java -d out/` |
| Lancer les tests | `java -jar lib/junit-platform-console-standalone-6.0.3.jar execute --class-path out/ --scan-class-path` |
| Lancer WaterMonitor | `java -cp out/ WaterMonitor` |

## Variante : démonstration dans IntelliJ IDEA

IntelliJ affiche les résultats de tests dans une arborescence graphique, ce qui
peut être plus lisible pour les personnes qui regardent.

1. Ouvrez le dossier `03-mini-projet/` dans IntelliJ (_File_ > _Open_).
2. Ajoutez le JAR JUnit via _Project Structure_ > _Libraries_ > `+` > _Java_,
   puis sélectionnez `lib/junit-platform-console-standalone-6.0.3.jar`.
3. Marquez `src/` comme _Sources Root_ si ce n'est pas fait
   automatiquement.
4. Cliquez sur l'icône verte dans la marge à côté de `class WaterSensorTest`
   pour lancer tous les tests.

Les résultats apparaissent dans le panneau _Run_ avec une arborescence verte.
Pour simuler un échec, modifiez une assertion et relancez : IntelliJ affiche le
diff attendu/obtenu directement dans le panneau.

> [!TIP]
>
> La vue IntelliJ est particulièrement utile pour montrer la différence entre un
> test qui passe et un test qui échoue sans que les personnes aient à lire les
> logs du terminal.
