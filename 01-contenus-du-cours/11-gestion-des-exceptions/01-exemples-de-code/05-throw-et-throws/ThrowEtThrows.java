/**
 * Exemple 05 - throw et throws
 *
 * Ce programme illustre le lancement d'exceptions avec throw et la
 * déclaration d'exceptions vérifiées avec throws dans la signature.
 *
 * La classe WaterSensor :
 * - utilise throw dans le constructeur pour signaler un pH invalide.
 * - déclare throws dans readFromString() pour forcer l'appelant à gérer
 *   l'exception potentielle.
 */
class WaterSensor {

    private static final double MIN_PH = 0.0;
    private static final double MAX_PH = 14.0;

    private String id;
    private double ph;

    // Le constructeur lance une exception si le pH est hors plage
    public WaterSensor(String id, double ph) {
        if (ph < MIN_PH || ph > MAX_PH) {
            throw new IllegalArgumentException(
                "Valeur de pH invalide : " + ph
                + " (attendu entre " + MIN_PH + " et " + MAX_PH + ")"
            );
        }
        this.id = id;
        this.ph = ph;
    }

    // throws oblige l'appelant à gérer ou à propager l'exception
    public double readFromString(String raw) throws Exception {
        double value = Double.parseDouble(raw);
        if (value < MIN_PH || value > MAX_PH) {
            throw new Exception(
                "Valeur de pH hors plage : " + value
                + " pour le capteur " + this.id
            );
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

public class ThrowEtThrows {

    public static void main(String[] args) {
        System.out.println("=== Test du throw dans le constructeur ===");

        // Cas 1 : construction avec un pH valide
        try {
            WaterSensor sensor = new WaterSensor("PH-01", 7.2);
            System.out.println("Capteur créé : " + sensor.getId()
                + " (pH = " + sensor.getPh() + ")");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Cas 2 : construction avec un pH invalide (15.0)
        try {
            WaterSensor sensor = new WaterSensor("PH-02", 15.0);
            System.out.println("Capteur créé : " + sensor.getId());
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        System.out.println("\n=== Test du throws dans readFromString ===");

        WaterSensor sensor = new WaterSensor("PH-01", 7.2);

        // Cas 3 : lecture valide
        try {
            double ph = sensor.readFromString("8.5");
            System.out.println("Lecture OK : pH = " + ph);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }

        // Cas 4 : lecture hors plage
        try {
            double ph = sensor.readFromString("15.0");
            System.out.println("Lecture OK : pH = " + ph);
        } catch (Exception e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
