import java.util.ArrayList;
import java.util.List;

/**
 * Démonstration de sort avec des expressions lambda.
 */
public class SortLambdaDemo {
    public static void main(String[] args) {
        System.out.println("=== sort avec lambda ===");

        List<String> plants = new ArrayList<>();
        plants.add("Menthe");
        plants.add("Basilic");
        plants.add("Tomate");
        plants.add("Persil");
        plants.add("Ail");

        System.out.println("Liste initiale : " + plants);
        System.out.println();

        // --- Tri alphabétique ---
        // La lambda (a, b) -> a.compareTo(b) compare deux chaînes
        // dans l'ordre naturel (alphabétique).
        plants.sort((a, b) -> a.compareTo(b));
        System.out.println("Tri alphabétique :");
        System.out.println(plants);
        System.out.println();

        // --- Tri par longueur de nom ---
        // a.length() - b.length() : ordre croissant de longueur.
        // Si le résultat est négatif, a est plus court que b.
        plants.sort((a, b) -> a.length() - b.length());
        System.out.println("Tri par longueur de nom :");
        System.out.println(plants);
        System.out.println();

        // --- Tri alphabétique inverse ---
        // En inversant a et b, on obtient l'ordre inverse.
        plants.sort((a, b) -> b.compareTo(a));
        System.out.println("Tri alphabétique inverse :");
        System.out.println(plants);
    }
}
