import java.util.ArrayList;
import java.util.List;

/**
 * Démonstration des wildcards avec les génériques.
 */
public class WildcardDemo {

    /**
     * Affiche la taille d'une liste de n'importe quel type.
     * Le wildcard <?> accepte List<String>, List<Integer>, etc.
     *
     * @param list la liste
     */
    public static void printSize(List<?> list) {
        System.out.println("Éléments : " + list.size());
    }

    /**
     * Calcule la somme d'une liste de nombres.
     * <? extends Number> accepte List<Integer>, List<Double>,
     * List<Number>, etc.
     * On peut LIRE les éléments comme des Number,
     * mais on ne peut PAS en ajouter.
     *
     * @param list la liste de nombres
     * @return la somme
     */
    public static double sum(List<? extends Number> list) {
        double total = 0;
        for (Number n : list) {
            total += n.doubleValue();
        }
        return total;
    }

    /**
     * Ajoute des entiers dans une liste.
     * <? super Integer> accepte List<Integer>, List<Number>,
     * List<Object>.
     * On peut ÉCRIRE des Integer dedans,
     * mais la lecture retourne Object.
     *
     * @param list la liste destination
     */
    public static void addNumbers(List<? super Integer> list) {
        list.add(100);
        list.add(200);
    }

    public static void main(String[] args) {
        System.out.println("=== Wildcards ===");
        System.out.println();

        // --- Wildcard non borné <?> ---
        System.out.println("--- Wildcard non borné <?> ---");
        List<String> strings = new ArrayList<>();
        strings.add("A");
        strings.add("B");
        strings.add("C");
        printSize(strings);

        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        printSize(integers);
        System.out.println();

        // --- Wildcard borné <? extends Number> ---
        // La méthode sum() accepte List<Integer> et List<Double>
        // car Integer et Double étendent Number.
        System.out.println(
                "--- Wildcard borné <? extends Number> ---");

        List<Integer> intList = new ArrayList<>();
        intList.add(10);
        intList.add(20);
        intList.add(30);
        System.out.println(
                "Somme des Integer : " + sum(intList));

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(3.14);
        doubleList.add(2.71);
        doubleList.add(3.57);
        System.out.println(
                "Somme des Double : " + sum(doubleList));
        System.out.println();

        // --- Wildcard borné <? super Integer> ---
        // La méthode addNumbers() peut ajouter des Integer
        // dans une List<Integer> ou une List<Number>.
        System.out.println(
                "--- Wildcard borné <? super Integer> ---");
        List<Number> numberList = new ArrayList<>();
        numberList.add(10);
        numberList.add(20);
        numberList.add(30);
        addNumbers(numberList);
        System.out.println("Après ajout : " + numberList);
    }
}
