/**
 * Exemple 06 - Exception personnalisée et système robuste
 *
 * Ce programme illustre la création d'une exception personnalisée
 * (InvalidPhException) et son intégration dans un système complet de
 * surveillance de qualité de l'eau.
 *
 * Tous les concepts vus dans les exemples précédents sont réunis ici.
 */

// Exception personnalisée : hérite d'Exception (vérifiée)
class InvalidPhException extends Exception {

    // Constructeur avec identifiant et valeur
    public InvalidPhException(String sensorId, double value) {
        super(
            "Valeur de pH hors plage pour le capteur "
            + sensorId + " : " + value
            + " (attendu entre 0.0 et 14.0)"
        );
    }

    // Constructeur avec cause (chaînage d'exceptions)
    public InvalidPhException(String sensorId, double value, Throwable cause) {
        super(
            "Valeur de pH hors plage pour le capteur "
            + sensorId + " : " + value
            + " (attendu entre 0.0 et 14.0)",
            cause
        );
    }
}

class WaterSensor {

    private static final double MIN_PH = 0.0;
    private static final double MAX_PH = 14.0;

    private String id;
    private double ph;

    public WaterSensor(String id, double ph) throws InvalidPhException {
        if (ph < MIN_PH || ph > MAX_PH) {
            throw new InvalidPhException(id, ph);
        }
        this.id = id;
        this.ph = ph;
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
        return value;
    }

    public String getId() {
        return id;
    }

    public double getPh() {
        return ph;
    }
}

public class ExceptionPersonnalisee {

    public static void main(String[] args) {
        System.out.println("=== Système de surveillance de l'eau ===\n");

        // Tentative de création d'un capteur avec une valeur invalide
        System.out.println("--- Création du capteur ---");
        WaterSensor sensor = null;
        try {
            sensor = new WaterSensor("PH-01", 7.2);
            System.out.println("Capteur " + sensor.getId() + " initialisé.");
        } catch (InvalidPhException e) {
            System.out.println("ALERTE : " + e.getMessage());
            return; // Arrêt si le capteur ne peut pas être créé
        }

        // Lecture de plusieurs valeurs
        System.out.println("\n--- Lecture des mesures ---");
        String[] rawReadings = {"7.2", "15.0", "abc", "8.1"};

        for (String raw : rawReadings) {
            try {
                double ph = sensor.readFromString(raw);
                System.out.println("Lecture OK : pH = " + ph);
            } catch (InvalidPhException e) {
                System.out.println("ALERTE pH : " + e.getMessage());
                if (e.getCause() != null) {
                    System.out.println("  Cause : " + e.getCause().getMessage());
                }
            }
        }

        System.out.println("\nSurveillance terminée.");
    }
}
