# Gestion des exceptions - Exercices

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Toutes les informations relatives à ce contenu sont décrites dans le
> [contenu principal](../).

## Table des matières

- [Table des matières](#table-des-matières)
- [Exercices de complétion](#exercices-de-complétion)
  - [Exercice 1 - Ajouter un bloc try-catch](#exercice-1---ajouter-un-bloc-try-catch)
  - [Exercice 2 - Créer une exception personnalisée](#exercice-2---créer-une-exception-personnalisée)
- [Exercices de prédiction](#exercices-de-prédiction)
  - [Exercice 3 - Ordre des blocs catch](#exercice-3---ordre-des-blocs-catch)
  - [Exercice 4 - Comportement du bloc finally](#exercice-4---comportement-du-bloc-finally)
- [Exercices de modification](#exercices-de-modification)
  - [Exercice 5 - Rendre un programme robuste](#exercice-5---rendre-un-programme-robuste)
- [Exercices de transfert](#exercices-de-transfert)
  - [Exercice 6 - Gestion d'un compteur d'énergie](#exercice-6---gestion-dun-compteur-dénergie)
- [Conclusion](#conclusion)

## Exercices

> [!NOTE]
>
> Bien que ces exercices puissent paraître simples et que leur solution est
> disponible dans ce même document, il est fortement recommandé de les réaliser
> sans consulter les solutions au préalable.
>
> Ils ont pour but de vous former et de pratiquer les concepts vus dans le
> contenu de cours.
>
> Il est donc important de les faire par vous-même avant de vérifier vos
> réponses avec les solutions fournies.

## Exercices de complétion

Ces exercices vous permettent de pratiquer la syntaxe de la gestion des
exceptions en complétant du code existant.

### Exercice 1 - Ajouter un bloc try-catch

Un capteur de qualité de l'air lit des indices de qualité depuis un tableau de
chaines. Le programme plante actuellement si une valeur est invalide.

Ajoutez un bloc `try-catch` pour capturer la `NumberFormatException` et afficher
un message d'erreur adapté. Le programme doit continuer après une erreur.

```java
public class AirSensor {
    public static void main(String[] args) {
        String[] rawValues = {"42", "excellent", "78", "12"};
        String[] labels = {"Mauvais", "Moyen", "Bon", "Excellent"};

        System.out.println("=== Lecture de l'indice de qualité ===");

        for (String raw : rawValues) {
            // TODO: Entourez ces lignes d'un bloc try-catch approprié.
            int index = Integer.parseInt(raw);
            System.out.println("Indice : " + index + "/100");
        }

        System.out.println("Lecture terminée.");
    }
}
```

**Résultat attendu :**

```
=== Lecture de l'indice de qualité ===
Indice : 42/100
Valeur invalide : 'excellent' - For input string: "excellent"
Indice : 78/100
Indice : 12/100
Lecture terminée.
```

<details>
<summary>Indice</summary>

Entourez uniquement `Integer.parseInt(raw)` et la ligne d'affichage dans le bloc
`try`. Dans le `catch`, utilisez `e.getMessage()` pour afficher le message de
l'exception.

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class AirSensor {
    public static void main(String[] args) {
        String[] rawValues = {"42", "excellent", "78", "12"};

        System.out.println("=== Lecture de l'indice de qualité ===");

        for (String raw : rawValues) {
            try {
                int index = Integer.parseInt(raw);
                System.out.println("Indice : " + index + "/100");
            } catch (NumberFormatException e) {
                System.out.println(
                    "Valeur invalide : '" + raw + "' - " + e.getMessage()
                );
            }
        }

        System.out.println("Lecture terminée.");
    }
}
```

</details>

---

### Exercice 2 - Créer une exception personnalisée

Complétez la classe `InvalidAirQualityException` pour qu'elle soit une exception
**vérifiée** incluant l'identifiant du capteur et la valeur invalide dans son
message.

```java
// TODO: Faites en sorte que cette classe soit une exception vérifiée.
class InvalidAirQualityException ________ {

    // TODO: Ajoutez un constructeur avec (String sensorId, int value).
    // Message attendu : "Indice de qualité invalide pour AQ-01 : 150 (attendu entre 0 et 100)"


}

public class AirQualityDemo {
    public static void main(String[] args) {
        try {
            // Simuler une lecture invalide
            int value = 150;
            String sensorId = "AQ-01";
            if (value < 0 || value > 100) {
                throw new InvalidAirQualityException(sensorId, value);
            }
        } catch (InvalidAirQualityException e) {
            System.out.println("ALERTE : " + e.getMessage());
        }
    }
}
```

**Résultat attendu :**

```
ALERTE : Indice de qualité invalide pour AQ-01 : 150 (attendu entre 0 et 100)
```

<details>
<summary>Indice</summary>

Pour une exception vérifiée, héritez d'`Exception` (pas de `RuntimeException`).
Le constructeur doit appeler `super(message)` avec le message attendu.

</details>

<details>
<summary>Afficher la solution</summary>

```java
class InvalidAirQualityException extends Exception {

    public InvalidAirQualityException(String sensorId, int value) {
        super(
            "Indice de qualité invalide pour " + sensorId
            + " : " + value
            + " (attendu entre 0 et 100)"
        );
    }
}

public class AirQualityDemo {
    public static void main(String[] args) {
        try {
            int value = 150;
            String sensorId = "AQ-01";
            if (value < 0 || value > 100) {
                throw new InvalidAirQualityException(sensorId, value);
            }
        } catch (InvalidAirQualityException e) {
            System.out.println("ALERTE : " + e.getMessage());
        }
    }
}
```

</details>

---

## Exercices de prédiction

Ces exercices vous demandent de prédire la sortie d'un programme avant de
l'exécuter.

### Exercice 3 - Ordre des blocs catch

Quelle est la sortie de ce code ? Compile-t-il ? Si non, expliquez pourquoi.

```java
public class CatchOrder {
    public static void main(String[] args) {
        String raw = "abc";
        try {
            int value = Integer.parseInt(raw);
            System.out.println("Valeur : " + value);
        } catch (RuntimeException e) {
            System.out.println("RuntimeException : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException : " + e.getMessage());
        }
    }
}
```

<details>
<summary>Afficher la réponse</summary>

**Ce code ne compile pas.**

```
error: exception NumberFormatException has already been caught
```

`NumberFormatException` hérite de `RuntimeException`. Le premier `catch` capture
déjà toutes les `RuntimeException`, rendant le second bloc **inaccessible**
(_unreachable_). Le compilateur Java refuse ce code.

Pour corriger, placez `NumberFormatException` **avant** `RuntimeException`.

</details>

---

### Exercice 4 - Comportement du bloc finally

Prédisez la sortie exacte de ce programme.

```java
public class FinallyBehavior {
    public static void main(String[] args) {
        System.out.println("Début");

        for (int i = 0; i < 3; i++) {
            try {
                if (i == 1) {
                    throw new RuntimeException("Erreur à i=" + i);
                }
                System.out.println("Traitement " + i + " : OK");
            } catch (RuntimeException e) {
                System.out.println("Erreur capturée : " + e.getMessage());
            } finally {
                System.out.println("Finally pour i=" + i);
            }
        }

        System.out.println("Fin");
    }
}
```

<details>
<summary>Afficher la réponse</summary>

```
Début
Traitement 0 : OK
Finally pour i=0
Erreur capturée : Erreur à i=1
Finally pour i=1
Traitement 2 : OK
Finally pour i=2
Fin
```

Le bloc `finally` s'exécute **à chaque itération**, qu'il y ait une exception ou
non. La boucle continue après la capture : `i=2` est traité normalement.

</details>

---

## Exercices de modification

Ces exercices vous demandent de modifier du code existant pour y intégrer une
gestion des exceptions correcte.

### Exercice 5 - Rendre un programme robuste

Le code suivant plante si le pH est hors plage ou mal formaté. Modifiez-le pour
qu'il :

1. Lance une `IllegalArgumentException` si le pH parsé est hors de [0.0 ; 14.0].
2. Déclare correctement les exceptions propagées avec `throws`.
3. Capture les deux types d'exceptions dans `main` avec des messages adaptés.

```java
class WaterSensor {

    private String id;
    private double ph;

    public WaterSensor(String id, double ph) {
        // TODO: Vérifiez que ph est dans [0.0 ; 14.0].
        // Si non, lancez une IllegalArgumentException.
        this.id = id;
        this.ph = ph;
    }

    // TODO: Déclarez throws Exception dans la signature.
    public double readFromString(String raw) {
        double value = Double.parseDouble(raw);
        // TODO: Vérifiez que value est dans [0.0 ; 14.0].
        // Si non, lancez une Exception avec un message adapté.
        return value;
    }

    public String getId() { return id; }
    public double getPh() { return ph; }
}

public class RobustSensor {
    public static void main(String[] args) {
        // TODO: Entourez la construction du capteur d'un try-catch
        // pour IllegalArgumentException.
        WaterSensor sensor = new WaterSensor("PH-01", 7.2);

        String[] readings = {"8.5", "15.0", "abc"};
        for (String raw : readings) {
            // TODO: Entourez readFromString() d'un try-catch pour Exception.
            double ph = sensor.readFromString(raw);
            System.out.println("pH : " + ph);
        }
    }
}
```

**Résultat attendu :**

```
Capteur PH-01 créé avec pH = 7.2
pH : 8.5
Erreur de lecture : Valeur de pH hors plage : 15.0
Erreur de lecture : For input string: "abc"
```

<details>
<summary>Afficher la solution</summary>

```java
class WaterSensor {

    private static final double MIN_PH = 0.0;
    private static final double MAX_PH = 14.0;

    private String id;
    private double ph;

    public WaterSensor(String id, double ph) {
        if (ph < MIN_PH || ph > MAX_PH) {
            throw new IllegalArgumentException(
                "Valeur de pH invalide : " + ph
            );
        }
        this.id = id;
        this.ph = ph;
    }

    public double readFromString(String raw) throws Exception {
        double value = Double.parseDouble(raw);
        if (value < MIN_PH || value > MAX_PH) {
            throw new Exception("Valeur de pH hors plage : " + value);
        }
        return value;
    }

    public String getId() { return id; }
    public double getPh() { return ph; }
}

public class RobustSensor {
    public static void main(String[] args) {
        WaterSensor sensor;
        try {
            sensor = new WaterSensor("PH-01", 7.2);
            System.out.println(
                "Capteur " + sensor.getId()
                + " créé avec pH = " + sensor.getPh()
            );
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de création : " + e.getMessage());
            return;
        }

        String[] readings = {"8.5", "15.0", "abc"};
        for (String raw : readings) {
            try {
                double ph = sensor.readFromString(raw);
                System.out.println("pH : " + ph);
            } catch (Exception e) {
                System.out.println("Erreur de lecture : " + e.getMessage());
            }
        }
    }
}
```

</details>

---

## Exercices de transfert

Ces exercices vous invitent à appliquer les concepts dans un nouveau contexte.

### Exercice 6 - Gestion d'un compteur d'énergie

Un compteur d'énergie solaire reçoit des mesures de production en kWh depuis un
tableau de chaines. Certaines valeurs peuvent être négatives ou mal formatées.

Créez un système complet qui :

1. Définit une exception personnalisée vérifiée `InvalidEnergyValueException`
   avec l'identifiant du compteur et la valeur invalide dans le message.
2. Crée une classe `EnergyCounter` avec :
   - Un identifiant (`id`).
   - Une méthode `readFromString(String raw) throws InvalidEnergyValueException`
     qui parse la valeur et lève l'exception si elle est négative ou si le
     format est invalide (chaînez la cause dans ce cas).
3. Dans `main`, lit les valeurs `{"12.5", "-3.0", "abc", "8.2"}` et affiche les
   mesures valides ou les alertes pour les invalides.

**Résultat attendu :**

```
=== Compteur d'énergie solaire ===
Production : 12.5 kWh
ALERTE EC-01 : Valeur d'énergie invalide pour EC-01 : -3.0
ALERTE EC-01 : Valeur d'énergie invalide pour EC-01 : NaN
  Cause : For input string: "abc"
Production : 8.2 kWh
```

<details>
<summary>Indice</summary>

- `InvalidEnergyValueException` hérite d'`Exception`.
- Deux constructeurs : un avec `(String id, double value)`, un avec
  `(String id, double value, Throwable cause)`.
- Lors d'une `NumberFormatException`, transmettez-la comme cause :
  `throw new InvalidEnergyValueException(id, Double.NaN, e)`.
- `Double.NaN` représente une valeur non numérique.

</details>

<details>
<summary>Afficher la solution</summary>

```java
class InvalidEnergyValueException extends Exception {

    public InvalidEnergyValueException(String counterId, double value) {
        super(
            "Valeur d'énergie invalide pour " + counterId + " : " + value
        );
    }

    public InvalidEnergyValueException(
            String counterId, double value, Throwable cause) {
        super(
            "Valeur d'énergie invalide pour " + counterId + " : " + value,
            cause
        );
    }
}

class EnergyCounter {

    private String id;

    public EnergyCounter(String id) {
        this.id = id;
    }

    public double readFromString(String raw)
            throws InvalidEnergyValueException {
        double value;
        try {
            value = Double.parseDouble(raw);
        } catch (NumberFormatException e) {
            throw new InvalidEnergyValueException(this.id, Double.NaN, e);
        }
        if (value < 0) {
            throw new InvalidEnergyValueException(this.id, value);
        }
        return value;
    }

    public String getId() {
        return id;
    }
}

public class EnergyMonitor {

    public static void main(String[] args) {
        EnergyCounter counter = new EnergyCounter("EC-01");
        String[] rawReadings = {"12.5", "-3.0", "abc", "8.2"};

        System.out.println("=== Compteur d'énergie solaire ===");

        for (String raw : rawReadings) {
            try {
                double kwh = counter.readFromString(raw);
                System.out.println("Production : " + kwh + " kWh");
            } catch (InvalidEnergyValueException e) {
                System.out.println("ALERTE " + counter.getId()
                    + " : " + e.getMessage());
                if (e.getCause() != null) {
                    System.out.println(
                        "  Cause : " + e.getCause().getMessage()
                    );
                }
            }
        }
    }
}
```

</details>

---

## Conclusion

Ces exercices couvrent les cas d'usage les plus fréquents de la gestion des
exceptions en Java. Une fois ces exercices maîtrisés, vous avez les bases
nécessaires pour aborder le mini-projet.

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
