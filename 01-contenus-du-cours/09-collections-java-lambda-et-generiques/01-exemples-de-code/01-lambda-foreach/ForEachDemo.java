import java.util.ArrayList;
import java.util.List;

/**
 * Démonstration de forEach avec des expressions lambda.
 */
public class ForEachDemo {
    public static void main(String[] args) {
        System.out.println("=== forEach avec lambda ===");

        // Créer une liste de plantes
        List<String> plants = new ArrayList<>();
        plants.add("Tomate");
        plants.add("Basilic");
        plants.add("Menthe");
        plants.add("Persil");

        // --- Boucle for-each classique ---
        System.out.println("Avec boucle for-each :");
        for (String plant : plants) {
            System.out.println("  - " + plant);
        }
        System.out.println();

        // --- forEach avec lambda ---
        // La lambda remplace la boucle for-each.
        // "plant -> ..." est un Consumer<String> :
        // elle prend un String et ne retourne rien.
        System.out.println("Avec forEach et lambda :");
        plants.forEach(plant -> System.out.println("  - " + plant));
        System.out.println();

        // --- forEach avec bloc lambda (plusieurs instructions) ---
        // Quand la lambda contient plusieurs instructions,
        // on utilise des accolades.
        System.out.println("Avec forEach et bloc lambda :");
        final int[] counter = {0};
        plants.forEach(plant -> {
            counter[0]++;
            System.out.println("  " + counter[0] + ". "
                    + plant.toUpperCase());
        });
    }
}
