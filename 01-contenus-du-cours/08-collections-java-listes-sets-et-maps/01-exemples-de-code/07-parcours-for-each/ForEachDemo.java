/**
 * Exemple 07 - Parcours avec for-each
 *
 * Cet exemple montre comment parcourir les trois types de collections
 * (liste, ensemble, map) avec la boucle for-each.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ForEachDemo {

    public static void main(String[] args) {
        // Parcours d'une liste
        System.out.println("=== Parcours d'une liste ===");

        List<String> plants = new ArrayList<>(
            List.of("Tomate", "Carotte", "Basilic")
        );

        for (String plant : plants) {
            System.out.println("- " + plant);
        }

        // Parcours d'un ensemble
        System.out.println("\n=== Parcours d'un ensemble ===");

        Set<String> species = new HashSet<>(
            Set.of("Tomate", "Carotte", "Basilic")
        );

        for (String s : species) {
            System.out.println("- " + s + " (ordre variable)");
        }

        // Parcours d'une map
        Map<String, String> assignments = new HashMap<>();
        assignments.put("Alice", "Parcelle A1");
        assignments.put("Bob", "Parcelle B2");
        assignments.put("Clara", "Parcelle A3");

        // Parcours avec entrySet() : paires clé-valeur
        System.out.println("\n=== Parcours d'une map avec entrySet() ===");

        for (Map.Entry<String, String> entry : assignments.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }

        // Parcours des clés seules
        System.out.println("\n=== Parcours des clés seules ===");

        for (String name : assignments.keySet()) {
            System.out.println("Jardinière : " + name);
        }

        // Parcours des valeurs seules
        System.out.println("\n=== Parcours des valeurs seules ===");

        for (String plot : assignments.values()) {
            System.out.println("Parcelle : " + plot);
        }
    }
}
