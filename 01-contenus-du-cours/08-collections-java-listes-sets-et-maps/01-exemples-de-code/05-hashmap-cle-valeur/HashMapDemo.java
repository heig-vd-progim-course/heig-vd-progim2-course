/**
 * Exemple 05 - HashMap : associations clé-valeur
 *
 * Cet exemple montre comment utiliser une HashMap pour associer
 * des jardinières à leurs parcelles dans un jardin communautaire.
 */
import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {

    public static void main(String[] args) {
        System.out.println("=== HashMap : attribution des parcelles ===");

        // Déclaration avec le type de l'interface (Map)
        Map<String, String> assignments = new HashMap<>();

        // Ajouter des entrées clé-valeur
        assignments.put("Alice", "Parcelle A1");
        assignments.put("Bob", "Parcelle B2");
        assignments.put("Clara", "Parcelle A3");

        System.out.println("Attributions : " + assignments
                + " (ordre variable)");

        // Accéder à une valeur par sa clé
        System.out.println("\nParcelle d'Alice : "
                + assignments.get("Alice"));
        System.out.println("Parcelle de David : "
                + assignments.get("David")); // null car la clé n'existe pas

        // Vérifier l'existence d'une clé
        System.out.println("\nContient la clé Bob : "
                + assignments.containsKey("Bob"));
        System.out.println("Contient la clé David : "
                + assignments.containsKey("David"));

        // Mise à jour et suppression
        System.out.println("\n=== Mise à jour et suppression ===");

        // put() remplace la valeur si la clé existe déjà
        System.out.println("Alice change de parcelle...");
        assignments.put("Alice", "Parcelle C1");
        System.out.println("Parcelle d'Alice : "
                + assignments.get("Alice"));

        // Supprimer une entrée par sa clé
        System.out.println("\nSuppression de Bob...");
        assignments.remove("Bob");
        System.out.println("Attributions : " + assignments
                + " (ordre variable)");
        System.out.println("Taille : " + assignments.size());

        // Accéder aux clés et aux valeurs séparément
        System.out.println("\n=== Clés et valeurs ===");
        System.out.println("Jardinières (clés) : " + assignments.keySet()
                + " (ordre variable)");
        System.out.println("Parcelles (valeurs) : " + assignments.values()
                + " (ordre variable)");
    }
}
