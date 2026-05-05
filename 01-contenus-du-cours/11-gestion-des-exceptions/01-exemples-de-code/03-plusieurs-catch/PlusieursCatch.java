/**
 * Exemple 03 - Plusieurs blocs catch et leur ordre
 *
 * Ce programme lit des valeurs de pH et tente d'accéder à des labels.
 * Il peut lever deux exceptions différentes selon la valeur traitée.
 * Les blocs catch sont placés du plus spécifique au plus général.
 */
public class PlusieursCatch {

    public static void main(String[] args) {
        // Plus de valeurs que de labels : certains index seront hors limites
        String[] rawValues = {"7.2", "abc", "8.1", "9.0"};
        String[] labels = {"Niveau normal", "Niveau acide"};

        System.out.println("=== Lecture des valeurs de pH ===");

        for (int i = 0; i < rawValues.length; i++) {
            try {
                double ph = Double.parseDouble(rawValues[i]);
                // Peut lever ArrayIndexOutOfBoundsException si i >= 2
                String label = labels[i];
                System.out.println(label + " : pH = " + ph);
            } catch (NumberFormatException e) {
                // Type spécifique : format numérique invalide
                System.out.println(
                    "Format invalide pour l'entrée : " + e.getMessage()
                );
            } catch (ArrayIndexOutOfBoundsException e) {
                // Type spécifique : index hors du tableau
                System.out.println("Index hors limites : " + e.getMessage());
            }
        }

        System.out.println("Lecture terminée.");
    }
}
