/**
 * Exemple 01 - Programme fragile
 *
 * Ce programme tente de lire des valeurs de pH depuis un tableau de chaines.
 * Il n'a aucune gestion d'erreurs : une valeur mal formatée provoque un
 * plantage brutal du programme.
 */
public class ProgrammeFragile {

    public static void main(String[] args) {
        // Valeurs reçues depuis l'extérieur (non validées)
        String[] rawValues = {"7.2", "abc", "13.5"};

        System.out.println("=== Lecture des valeurs de pH ===");

        for (String raw : rawValues) {
            // Cette ligne plante si raw n'est pas un nombre valide
            double ph = Double.parseDouble(raw);
            System.out.println("pH lu : " + ph);
        }

        // Cette ligne n'est jamais atteinte si une exception est levée
        System.out.println("Lecture terminée.");
    }
}
