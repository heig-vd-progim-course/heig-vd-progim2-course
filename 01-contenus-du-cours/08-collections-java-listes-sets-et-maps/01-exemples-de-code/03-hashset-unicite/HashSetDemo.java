/**
 * Exemple 03 - HashSet et unicité
 *
 * Cet exemple montre comment HashSet garantit l'unicité des éléments
 * et comment l'utiliser pour éliminer les doublons d'une liste.
 */
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class HashSetDemo {

    public static void main(String[] args) {
        System.out.println("=== HashSet : espèces du jardin ===");

        // Déclaration avec le type de l'interface (Set)
        Set<String> species = new HashSet<>();

        // add() retourne true si l'élément a été ajouté, false sinon
        System.out.println("Ajout de Tomate : " + species.add("Tomate"));
        System.out.println("Ajout de Carotte : " + species.add("Carotte"));
        System.out.println("Ajout de Basilic : " + species.add("Basilic"));
        System.out.println("Ajout de Tomate (doublon) : "
                + species.add("Tomate"));
        System.out.println("Ajout de Menthe : " + species.add("Menthe"));
        System.out.println("Ajout de Carotte (doublon) : "
                + species.add("Carotte"));

        // L'ordre d'affichage n'est pas garanti
        System.out.println("\nEspèces : " + species + " (ordre variable)");
        System.out.println("Nombre d'espèces : " + species.size());

        // Vérifier la présence d'un élément
        System.out.println("\nContient Tomate : "
                + species.contains("Tomate"));
        System.out.println("Contient Persil : "
                + species.contains("Persil"));

        // Convertir une liste en ensemble pour éliminer les doublons
        System.out.println("\n=== Éliminer les doublons d'une liste ===");

        List<String> withDuplicates = new ArrayList<>(
            List.of("Tomate", "Carotte", "Tomate", "Basilic",
                    "Carotte", "Tomate")
        );

        System.out.println("Liste avec doublons : " + withDuplicates);
        System.out.println("Taille de la liste : " + withDuplicates.size());

        Set<String> noDuplicates = new HashSet<>(withDuplicates);

        System.out.println("Ensemble sans doublons : " + noDuplicates
                + " (ordre variable)");
        System.out.println("Taille de l'ensemble : " + noDuplicates.size());
    }
}
