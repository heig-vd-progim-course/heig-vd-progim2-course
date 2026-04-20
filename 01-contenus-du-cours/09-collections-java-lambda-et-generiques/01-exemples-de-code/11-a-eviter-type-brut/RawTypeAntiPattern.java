import java.util.ArrayList;
import java.util.List;

/**
 * Contre-exemple : utilisation de types bruts (raw types).
 *
 * Ce code illustre pourquoi il ne faut PAS utiliser de types bruts
 * avec les collections Java.
 */
public class RawTypeAntiPattern {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        System.out.println("=== A éviter : type brut ===");
        System.out.println();

        // --- MAUVAISE PRATIQUE : type brut ---
        // List sans <String> est un "type brut".
        // Java n'effectue aucune vérification de type.
        System.out.println(
                "--- Mauvaise pratique : type brut ---");

        List rawList = new ArrayList();   // Pas de paramètre de type
        rawList.add("Tomate");
        rawList.add("Basilic");
        rawList.add(42);                  // Compile sans erreur !

        // Le problème apparaît à l'exécution :
        try {
            for (Object item : rawList) {
                // Cast nécessaire, et dangereux
                String plant = (String) item;
            }
        } catch (ClassCastException e) {
            System.out.println("Exception : " + e.getMessage());
        }
        System.out.println();

        // --- BONNE PRATIQUE : type paramétré ---
        System.out.println(
                "--- Bonne pratique : type paramétré ---");

        List<String> safeList = new ArrayList<>();
        safeList.add("Tomate");
        safeList.add("Basilic");
        // safeList.add(42);  // Erreur de compilation !
        // Le compilateur empêche l'ajout d'un Integer.
        System.out.println("Le compilateur empêche l'ajout "
                + "d'un Integer dans List<String>.");

        // Pas besoin de cast
        for (String plant : safeList) {
            // Utilisation directe comme String
        }
        System.out.println("Liste sûre : " + safeList);
    }
}
