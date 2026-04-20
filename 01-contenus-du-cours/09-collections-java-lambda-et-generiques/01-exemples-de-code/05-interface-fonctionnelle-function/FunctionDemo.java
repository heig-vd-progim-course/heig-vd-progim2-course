import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * Démonstration des interfaces fonctionnelles Function et Consumer.
 */
public class FunctionDemo {
    public static void main(String[] args) {
        System.out.println(
                "=== Function : transformation de valeurs ===");

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlotte");
        names.add("Eve");

        System.out.println("Noms : " + names);
        System.out.println();

        // --- Function<String, Integer> : String -> Integer ---
        // apply() prend un String et retourne un Integer.
        Function<String, Integer> toLength = s -> s.length();

        System.out.println("Longueurs des noms :");
        names.forEach(name -> System.out.println("  " + name
                + " -> " + toLength.apply(name)));
        System.out.println();

        // --- Function<String, String> : String -> String ---
        Function<String, String> toUpper = s -> s.toUpperCase();

        System.out.println("En majuscules :");
        names.forEach(name -> System.out.println("  " + name
                + " -> " + toUpper.apply(name)));
        System.out.println();

        // --- Consumer<String> : String -> void ---
        // accept() prend un String et ne retourne rien.
        Consumer<String> fancyPrinter =
                s -> System.out.println("  >>> " + s + " <<<");

        System.out.println(
                "Avec Consumer (affichage personnalisé) :");
        names.forEach(fancyPrinter);
    }
}
