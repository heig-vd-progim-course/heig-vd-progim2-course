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
