import java.util.ArrayList;
import java.util.List;

/**
 * Démonstration des références de méthode.
 */
public class MethodReferenceDemo {
    public static void main(String[] args) {
        System.out.println("=== Référence de méthode ===");

        List<String> plants = new ArrayList<>();
        plants.add("Tomate");
        plants.add("Basilic");
        plants.add("Menthe");

        // --- Lambda classique ---
        // La lambda prend un paramètre et le passe à println.
        System.out.println("Avec lambda :");
        plants.forEach(plant -> System.out.println(plant));
        System.out.println();

        // --- Référence de méthode ---
        // System.out::println est équivalent à la lambda ci-dessus.
        // C'est une référence vers la méthode println de l'objet
        // System.out.
        System.out.println(
                "Avec référence de méthode (même résultat) :");
        plants.forEach(System.out::println);
        System.out.println();

        // --- Tri avec lambda ---
        // La lambda (a, b) -> a.compareTo(b) appelle compareTo
        // sur le premier argument avec le second.
        plants.sort((a, b) -> a.compareTo(b));
        System.out.println("Tri avec lambda :");
        System.out.println(plants);
        System.out.println();

        // --- Tri avec référence de méthode ---
        // String::compareTo est une référence vers la méthode
        // d'instance compareTo de la classe String.
        // Java comprend que le premier argument appelle compareTo
        // sur le second.
        plants.sort(String::compareTo);
        System.out.println(
                "Tri avec référence de méthode (même résultat) :");
        System.out.println(plants);
    }
}
