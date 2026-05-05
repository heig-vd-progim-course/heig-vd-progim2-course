/**
 * Exemple 02 - Bloc try-catch de base
 *
 * Ce programme lit des valeurs de pH et capture l'exception levée quand
 * une valeur est mal formatée. Le programme continue après l'erreur.
 */
public class TryCatchBase {

    public static void main(String[] args) {
        // Valeurs reçues depuis l'extérieur (non validées)
        String[] rawValues = {"7.2", "abc", "13.5"};

        System.out.println("=== Lecture des valeurs de pH ===");

        for (String raw : rawValues) {
            try {
                // Code susceptible de lever une exception
                double ph = Double.parseDouble(raw);
                System.out.println("pH lu : " + ph);
            } catch (NumberFormatException e) {
                // Exécuté uniquement si Double.parseDouble() échoue
                System.out.println(
                    "Valeur invalide : '" + raw + "' - " + e.getMessage()
                );
            }
            // Cette ligne s'exécute dans tous les cas (succès ou erreur)
            System.out.println("Fin de traitement de : " + raw);
        }

        System.out.println("Lecture terminée.");
    }
}
