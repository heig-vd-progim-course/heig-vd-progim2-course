import java.util.ArrayList;
import java.util.List;

/**
 * Démonstration de méthodes génériques.
 */
public class GenericMethodDemo {

    /**
     * Retourne le premier élément d'une liste.
     * Le paramètre de type <T> est déclaré avant le type de retour.
     *
     * @param list la liste
     * @param <T> le type des éléments
     * @return le premier élément, ou null si la liste est vide
     */
    public static <T> T getFirst(List<T> list) {
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    /**
     * Affiche tous les éléments d'un tableau.
     *
     * @param items le tableau d'éléments
     * @param <T> le type des éléments
     */
    public static <T> void printAll(T[] items) {
        for (T item : items) {
            System.out.println("  - " + item);
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Méthode générique ===");

        // --- getFirst avec String ---
        // Java infère automatiquement que T = String
        // grâce au type de la liste passée en argument.
        List<String> plants = new ArrayList<>();
        plants.add("Tomate");
        plants.add("Basilic");
        String firstPlant = getFirst(plants);
        System.out.println(
                "Premier élément (String) : " + firstPlant);

        // --- getFirst avec Integer ---
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        Integer firstNumber = getFirst(numbers);
        System.out.println(
                "Premier élément (Integer) : " + firstNumber);

        // --- getFirst avec Double ---
        List<Double> decimals = new ArrayList<>();
        decimals.add(3.14);
        decimals.add(2.71);
        Double firstDecimal = getFirst(decimals);
        System.out.println(
                "Premier élément (Double) : " + firstDecimal);
        System.out.println();

        // --- printAll avec différents types ---
        System.out.println("=== Affichage générique ===");
        String[] names = {"Alice", "Bob", "Charlotte"};
        System.out.println("Tableau de String :");
        printAll(names);
        System.out.println();

        Integer[] nums = {1, 2, 3};
        System.out.println("Tableau de Integer :");
        printAll(nums);
    }
}
