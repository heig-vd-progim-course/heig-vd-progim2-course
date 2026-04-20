import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Démonstration de l'interface fonctionnelle Predicate.
 */
public class PredicateDemo {

    /**
     * Filtre une liste selon un prédicat donné.
     *
     * @param list la liste à filtrer
     * @param predicate le critère de filtrage
     * @return une nouvelle liste contenant les éléments acceptés
     */
    public static List<Integer> filter(List<Integer> list,
            Predicate<Integer> predicate) {
        List<Integer> result = new ArrayList<>();
        list.forEach(item -> {
            if (predicate.test(item)) {
                result.add(item);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        System.out.println("=== Predicate : filtrage flexible ===");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(12);
        numbers.add(3);
        numbers.add(18);
        numbers.add(7);
        numbers.add(25);
        numbers.add(1);
        numbers.add(30);

        System.out.println("Nombres : " + numbers);
        System.out.println();

        // --- Prédicat simple : nombre pair ---
        Predicate<Integer> isEven = n -> n % 2 == 0;
        System.out.println("Pairs :");
        System.out.println("  " + filter(numbers, isEven));

        // --- Prédicat simple : supérieur à 10 ---
        Predicate<Integer> greaterThan10 = n -> n > 10;
        System.out.println("Supérieurs à 10 :");
        System.out.println("  " + filter(numbers, greaterThan10));

        // --- Combinaison avec and() ---
        // Pair ET supérieur à 10
        Predicate<Integer> evenAndBig =
                isEven.and(greaterThan10);
        System.out.println("Pairs ET > 10 :");
        System.out.println("  " + filter(numbers, evenAndBig));

        // --- Combinaison avec or() ---
        // Pair OU supérieur à 20
        Predicate<Integer> greaterThan20 = n -> n > 20;
        Predicate<Integer> evenOrVeryBig =
                isEven.or(greaterThan20);
        System.out.println("Pairs OU > 20 :");
        System.out.println("  " + filter(numbers, evenOrVeryBig));
    }
}
