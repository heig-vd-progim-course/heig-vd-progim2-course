/**
 * Exemple 01 - ArrayList de base
 *
 * Cet exemple montre les opérations fondamentales d'une ArrayList
 * pour gérer une liste de plantes dans un jardin communautaire.
 */
import java.util.ArrayList;
import java.util.List;

public class ArrayListDemo {

    public static void main(String[] args) {
        // Déclaration avec le type de l'interface (List), pas l'implémentation
        List<String> plants = new ArrayList<>();

        // Ajouter des éléments
        plants.add("Tomate");
        plants.add("Carotte");
        plants.add("Basilic");
        plants.add("Tomate"); // Les doublons sont autorisés

        System.out.println("=== ArrayList : gestion des plantes ===");
        System.out.println("Plantes : " + plants);

        // Accéder à un élément par son index
        System.out.println("\nPremière plante : " + plants.get(0));
        System.out.println("Dernière plante : "
                + plants.get(plants.size() - 1));

        // Vérifier si un élément existe
        System.out.println("\nContient Basilic : "
                + plants.contains("Basilic"));
        System.out.println("Contient Menthe : "
                + plants.contains("Menthe"));

        // Supprimer un élément (première occurrence)
        System.out.println("\nSuppression de Basilic...");
        plants.remove("Basilic");
        System.out.println("Plantes après suppression : " + plants);
        System.out.println("Nombre de plantes : " + plants.size());

        // Insérer à une position spécifique
        System.out.println("\nAjout de Menthe à l'index 1...");
        plants.add(1, "Menthe");
        System.out.println("Plantes : " + plants);
    }
}
