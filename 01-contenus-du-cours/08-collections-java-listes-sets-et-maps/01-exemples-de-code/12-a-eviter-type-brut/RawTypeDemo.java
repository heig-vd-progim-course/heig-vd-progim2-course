/**
 * À ÉVITER 12 - Types bruts (raw types)
 *
 * CE CODE CONTIENT UNE ERREUR VOLONTAIRE.
 * Il montre ce qu'il ne faut PAS faire : utiliser des collections
 * sans type générique paramétré.
 *
 * Voir l'exemple 01-arraylist-base pour la bonne approche.
 */
import java.util.ArrayList;
import java.util.List;

public class RawTypeDemo {

    @SuppressWarnings("unchecked") // Supprime les avertissements pour l'exemple
    public static void main(String[] args) {
        // === ERREUR : type brut (sans générique) ===
        System.out.println("=== ERREUR : utilisation de types bruts ===");

        // MAUVAIS : pas de type générique
        List rawList = new ArrayList();
        System.out.println(
                "Ajout de différents types dans la même liste...");

        // Le compilateur ne peut pas vérifier les types !
        rawList.add("Tomate");  // String
        rawList.add(42);        // Integer
        rawList.add(true);      // Boolean

        System.out.println("Contenu : " + rawList);

        // L'erreur survient à l'exécution, pas à la compilation
        System.out.println(
                "\nTentative de parcours en tant que String...");
        try {
            for (Object item : rawList) {
                // Cast nécessaire car le type n'est pas garanti
                String text = (String) item;
                System.out.println("Element : " + text);
            }
        } catch (ClassCastException e) {
            System.out.println("ClassCastException attrapée !");
            System.out.println("Message : " + e.getMessage());
        }

        // === SOLUTION : utiliser les types génériques ===
        System.out.println(
                "\n=== SOLUTION : utiliser les types génériques ===");

        // BON : type générique spécifié
        List<String> typedList = new ArrayList<>();
        typedList.add("Tomate");
        typedList.add("Carotte");
        typedList.add("Basilic");
        // typedList.add(42); // ERREUR DE COMPILATION : incompatible types

        System.out.println("Liste typée créée avec succès.");
        System.out.println("Contenu : " + typedList);
        System.out.println(
                "Chaque élément est garanti être un String.");
    }
}
