/**
 * Exemple 04 - Multi-catch et finally
 *
 * Ce programme illustre la syntaxe multi-catch (|) et le bloc finally.
 * Le bloc finally s'exécute dans tous les cas, qu'une exception soit levée
 * ou non. Le compteur de tentatives est incrémenté à chaque itération.
 */
public class MultiCatchEtFinally {

    public static void main(String[] args) {
        String[] rawValues = {"7.2", "abc", "8.1", "9.0"};
        String[] labels = {"Niveau normal", "Niveau acide"};
        int readCount = 0;

        System.out.println("=== Lecture des valeurs de pH ===");

        for (int i = 0; i < rawValues.length; i++) {
            try {
                double ph = Double.parseDouble(rawValues[i]);
                String label = labels[i];
                System.out.println(label + " : pH = " + ph);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                // Multi-catch : les deux exceptions ont le même traitement
                System.out.println("Erreur de lecture : " + e.getMessage());
            } finally {
                // Exécuté dans TOUS les cas : succès ou erreur
                readCount++;
                System.out.println("Tentatives de lecture : " + readCount);
            }
        }

        System.out.println("Total des tentatives : " + readCount);
    }
}
