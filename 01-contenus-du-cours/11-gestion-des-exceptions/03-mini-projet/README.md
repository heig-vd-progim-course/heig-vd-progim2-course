# Gestion des exceptions - Mini-projet : Système de surveillance de l'eau

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
- [Étape 1 : créer la structure de base](#étape-1--créer-la-structure-de-base)
  - [WaterSensor sans gestion d'erreurs](#watersensor-sans-gestion-derreurs)
  - [WaterMonitor sans gestion d'erreurs](#watermonitor-sans-gestion-derreurs)
  - [Observer le problème](#observer-le-problème)
- [Étape 2 : créer l'exception personnalisée](#étape-2--créer-lexception-personnalisée)
- [Étape 3 : rendre WaterSensor robuste](#étape-3--rendre-watersensor-robuste)
- [Étape 4 : rendre WaterMonitor robuste](#étape-4--rendre-watermonitor-robuste)
- [Test du projet](#test-du-projet)
  - [Compilation et exécution](#compilation-et-exécution)
  - [Sortie attendue](#sortie-attendue)
- [Solution](#solution)
- [Conclusion](#conclusion)
- [Idées pour le mini-projet personnel](#idées-pour-le-mini-projet-personnel)
- [Aller plus loin](#aller-plus-loin)

## Présentation du mini-projet

Dans ce mini-projet, vous allez construire un **système de surveillance de la
qualité de l'eau** qui lit des mesures de pH depuis plusieurs capteurs.

Le projet suit une progression en quatre étapes :

1. **Structure de base** : créer les classes sans gestion d'erreurs.
2. **Observer le problème** : constater l'arrêt brutal sur une valeur invalide.
3. **Exception personnalisée** : créer `InvalidPhException`.
4. **Système robuste** : intégrer la gestion d'erreurs dans toutes les classes.

Ce projet est **autonome** : vous le créez de zéro, sans dépendance avec les
sessions précédentes.

## Objectifs de cette session

À l'issue de cette session, vous devriez avoir pu :

- Créer une exception personnalisée vérifiée.
- Utiliser `throw` et `throws` dans une classe métier.
- Capturer des exceptions avec `try-catch` et `finally`.
- Chaîner des exceptions pour préserver la cause originale.
- Construire un système resilient qui continue après une erreur.

## Structure du projet

```text
11-gestion-des-exceptions/
└── 03-mini-projet/
    └── src/
        ├── InvalidPhException.java   (créée à l'étape 2)
        ├── WaterSensor.java          (créée à l'étape 1, modifiée à 3)
        └── WaterMonitor.java         (créée à l'étape 1, modifiée à 4)
```

Créez le dossier `src/` dans `03-mini-projet/` et placez-y tous vos fichiers.

## Étape 1 : créer la structure de base

### WaterSensor sans gestion d'erreurs

Créez le fichier `WaterSensor.java`. Cette première version est **fragile** :
elle n'a aucune gestion d'erreurs.

```java
/**
 * Un capteur de pH pour la surveillance de la qualité de l'eau.
 * Version initiale sans gestion d'erreurs.
 */
public class WaterSensor {

    private String id;
    private double lastPh;

    public WaterSensor(String id) {
        this.id = id;
        this.lastPh = 0.0;
    }

    // Aucune validation : peut planter si raw n'est pas un nombre valide
    public double readFromString(String raw) {
        double value = Double.parseDouble(raw);
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

### WaterMonitor sans gestion d'erreurs

Créez le fichier `WaterMonitor.java`. Cette version appelle `WaterSensor` sans
capturer les exceptions potentielles.

```java
/**
 * Système de surveillance de la qualité de l'eau.
 * Version initiale sans gestion d'erreurs.
 */
public class WaterMonitor {

    public static void main(String[] args) {
        System.out.println(
            "=== Système de surveillance de la qualité de l'eau ==="
        );

        WaterSensor sensor = new WaterSensor("PH-01");

        // Le tableau contient des valeurs invalides volontairement
        String[] rawReadings = {"7.2", "13.5", "abc", "8.1"};

        System.out.println("\n--- Capteur " + sensor.getId() + " ---");

        for (String raw : rawReadings) {
            double ph = sensor.readFromString(raw);
            System.out.println("Lecture : pH = " + ph);
        }

        System.out.println("\nSurveillance terminée.");
    }
}
```

### Observer le problème

Compilez et exécutez le programme :

```shell
cd src/
javac WaterMonitor.java WaterSensor.java
java WaterMonitor
```

Vous devriez voir le programme planter sur la valeur `"13.5"` ou `"abc"` :

```
=== Système de surveillance de la qualité de l'eau ===

--- Capteur PH-01 ---
Lecture : pH = 7.2
Lecture : pH = 13.5
Exception in thread "main" java.lang.NumberFormatException: For input string: "abc"
    at WaterMonitor.main(WaterMonitor.java:22)
```

> [!IMPORTANT]
>
> Le programme affiche `13.5` sans erreur car `Double.parseDouble("13.5")`
> réussit. La valeur `13.5` est un pH techniquement élevé mais numérique valide.
> Le plantage vient de `"abc"` qui n'est pas un nombre.
>
> À l'étape 3, vous ajouterez aussi une validation de la plage [0.0 ; 14.0].

La ligne `"Lecture : pH = 8.1"` et `"Surveillance terminée."` ne sont jamais
affichées. C'est exactement le problème à résoudre dans les étapes suivantes.

## Étape 2 : créer l'exception personnalisée

Créez le fichier `InvalidPhException.java`. Cette exception **vérifiée** exprime
un problème métier : une valeur de pH invalide pour un capteur identifié.

```java
/**
 * Exception levée quand une valeur de pH est invalide ou hors plage.
 * Exception vérifiée : le compilateur oblige l'appelant à la gérer.
 */
public class InvalidPhException extends Exception {

    /**
     * Exception avec identifiant du capteur et valeur invalide.
     *
     * @param sensorId l'identifiant du capteur concerné
     * @param value la valeur invalide mesurée
     */
    public InvalidPhException(String sensorId, double value) {
        super(
            "Valeur de pH hors plage pour le capteur "
            + sensorId + " : " + value
            + " (attendu entre 0.0 et 14.0)"
        );
    }

    /**
     * Exception avec cause (chaînage d'exceptions).
     *
     * @param sensorId l'identifiant du capteur concerné
     * @param value la valeur invalide
     * @param cause l'exception originale à l'origine du problème
     */
    public InvalidPhException(
            String sensorId, double value, Throwable cause) {
        super(
            "Valeur de pH hors plage pour le capteur "
            + sensorId + " : " + value
            + " (attendu entre 0.0 et 14.0)",
            cause
        );
    }
}
```

> [!NOTE]
>
> Le deuxième constructeur avec `Throwable cause` permet de chaîner les
> exceptions. Lorsque `Double.parseDouble()` échoue, vous pouvez encapsuler la
> `NumberFormatException` d'origine dans `InvalidPhException` pour ne pas perdre
> l'information de débogage.

## Étape 3 : rendre WaterSensor robuste

Modifiez `WaterSensor.java` pour valider les valeurs et lancer
`InvalidPhException` en cas de problème.

Remplacez le contenu de `WaterSensor.java` par :

```java
/**
 * Un capteur de pH pour la surveillance de la qualité de l'eau.
 * Version robuste avec gestion des exceptions.
 */
public class WaterSensor {

    private static final double MIN_PH = 0.0;
    private static final double MAX_PH = 14.0;

    private String id;
    private double lastPh;

    public WaterSensor(String id) {
        this.id = id;
        this.lastPh = 0.0;
    }

    /**
     * Lit une valeur de pH depuis une chaine de caractères.
     *
     * @param raw la valeur brute à parser
     * @return la valeur de pH parsée et validée
     * @throws InvalidPhException si le format est invalide ou hors plage
     */
    public double readFromString(String raw) throws InvalidPhException {
        double value;

        // Étape 1 : parser la valeur (peut lever NumberFormatException)
        try {
            value = Double.parseDouble(raw);
        } catch (NumberFormatException e) {
            // Chaîner l'exception : préserver la cause pour le diagnostic
            throw new InvalidPhException(this.id, Double.NaN, e);
        }

        // Étape 2 : valider la plage
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

> [!TIP]
>
> Remarquez que `readFromString` déclare maintenant `throws InvalidPhException`.
> Le compilateur va exiger que `WaterMonitor` gère cette exception. Vous verrez
> une erreur de compilation jusqu'à l'étape 4.

## Étape 4 : rendre WaterMonitor robuste

Modifiez `WaterMonitor.java` pour capturer les `InvalidPhException` et continuer
le traitement après une erreur. Ajoutez aussi un compteur de lectures et
d'erreurs avec un bloc `finally`.

Remplacez le contenu de `WaterMonitor.java` par :

```java
/**
 * Système de surveillance de la qualité de l'eau.
 * Version robuste avec gestion des exceptions et statistiques.
 */
public class WaterMonitor {

    private int totalReadings;
    private int errorCount;

    public WaterMonitor() {
        this.totalReadings = 0;
        this.errorCount = 0;
    }

    /**
     * Traite un tableau de lectures brutes pour un capteur.
     *
     * @param sensor le capteur à interroger
     * @param rawValues les valeurs brutes à lire
     */
    public void processReadings(WaterSensor sensor, String[] rawValues) {
        System.out.println("\n--- Capteur " + sensor.getId() + " ---");

        for (String raw : rawValues) {
            try {
                double ph = sensor.readFromString(raw);
                System.out.println("Lecture OK : pH = " + ph);
            } catch (InvalidPhException e) {
                System.out.println("ALERTE : " + e.getMessage());
                if (e.getCause() != null) {
                    System.out.println(
                        "  Cause : " + e.getCause().getMessage()
                    );
                }
                errorCount++;
            } finally {
                totalReadings++;
            }
        }

        System.out.println("Fin de lecture " + sensor.getId() + ".");
    }

    /**
     * Affiche un résumé des lectures effectuées.
     */
    public void printSummary() {
        int successes = totalReadings - errorCount;
        double rate = totalReadings > 0
            ? (successes * 100.0) / totalReadings
            : 0.0;

        System.out.println("\n=== Résumé ===");
        System.out.println("Lectures totales : " + totalReadings);
        System.out.println("Erreurs          : " + errorCount);
        System.out.printf("Taux de succès   : %.1f%%%n", rate);
    }

    public static void main(String[] args) {
        System.out.println(
            "=== Système de surveillance de la qualité de l'eau ==="
        );

        WaterMonitor monitor = new WaterMonitor();

        // Premier capteur avec des valeurs dont certaines sont invalides
        WaterSensor sensor1 = new WaterSensor("PH-01");
        String[] readings1 = {"7.2", "15.0", "abc", "8.1"};
        monitor.processReadings(sensor1, readings1);

        // Deuxième capteur avec des valeurs toutes valides
        WaterSensor sensor2 = new WaterSensor("PH-02");
        String[] readings2 = {"6.9", "7.5"};
        monitor.processReadings(sensor2, readings2);

        monitor.printSummary();
    }
}
```

## Test du projet

### Compilation et exécution

Compilez et exécutez depuis le dossier `src/` :

```shell
cd src/
javac InvalidPhException.java WaterSensor.java WaterMonitor.java
java WaterMonitor
```

### Sortie attendue

```
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
Taux de succès   : 66.7%
```

> [!NOTE]
>
> Le `finally` incrémente `totalReadings` à chaque tentative, qu'elle ait réussi
> ou échoué. Le programme continue après chaque erreur et affiche un résumé
> complet à la fin.

## Solution

Vous pouvez trouver la solution du mini-projet dans le dossier
[`solution`](./solution/).

> [!NOTE]
>
> La solution est fournie à titre indicatif uniquement. Il est fortement
> recommandé de développer votre propre version avant de la consulter.
>
> Il existe souvent plusieurs façons de résoudre un même problème.

## Conclusion

Vous avez construit un système de surveillance de la qualité de l'eau en
intégrant les concepts clés de la gestion des exceptions :

- Une **exception personnalisée vérifiée** (`InvalidPhException`) qui exprime le
  problème dans le vocabulaire du domaine.
- Le **chaînage d'exceptions** pour préserver la cause originale.
- Des méthodes avec `throws` qui forcent l'appelant à gérer les erreurs.
- Un bloc `try-catch-finally` pour capturer les alertes et compter les lectures
  dans tous les cas.

Le résultat est un système **resilient** : il signale chaque erreur de façon
claire et continue le traitement, là où le programme initial s'arrêtait
brutalement à la première valeur invalide.

### Prochaine étape

Dans les prochaines sessions, vous pourrez étendre ce système pour persister les
alertes dans un fichier ou envoyer des notifications.

## Idées pour le mini-projet personnel

> [!TIP]
>
> Plus tard dans le cours, vous aurez l'occasion d'ajouter des fonctionnalités à
> votre mini-projet personnel. Voici quelques idées.

- Ajouter un système de journalisation : écrire chaque alerte dans un fichier
  texte avec la date et l'heure.
- Définir des seuils d'alerte (pH < 6.0 ou pH > 8.5) en plus des limites
  absolues de la plage [0.0 ; 14.0].
- Créer plusieurs types d'exceptions (`PhTooHighException`, `PhTooLowException`)
  pour des messages encore plus précis.
- Ajouter une méthode `reset()` dans `WaterSensor` pour réinitialiser la
  dernière mesure.

## Aller plus loin

> [!TIP]
>
> Cette section est optionnelle.

- Seriez-vous capable d'utiliser `try-with-resources` pour gérer automatiquement
  la fermeture d'un fichier de journalisation ?
- Comment organiseriez-vous le code si le nombre de capteurs était inconnu à
  l'avance (utilisation d'une `List<WaterSensor>`) ?

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
