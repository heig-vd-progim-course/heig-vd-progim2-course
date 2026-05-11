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
