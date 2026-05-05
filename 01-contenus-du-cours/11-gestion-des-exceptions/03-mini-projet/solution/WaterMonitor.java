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
                // Incrémenté dans tous les cas : succès ou erreur
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
