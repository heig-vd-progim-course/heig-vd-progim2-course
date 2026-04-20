import java.util.ArrayList;
import java.util.List;

/**
 * Démonstration de removeIf avec des expressions lambda.
 */
public class RemoveIfDemo {
    public static void main(String[] args) {
        System.out.println("=== removeIf avec lambda ===");

        // Créer une liste de tailles de plantes (en cm)
        List<Double> sizes = new ArrayList<>();
        sizes.add(3.2);
        sizes.add(15.0);
        sizes.add(7.5);
        sizes.add(1.8);
        sizes.add(22.0);
        sizes.add(4.0);

        System.out.println("Liste initiale : " + sizes);
        System.out.println();

        // --- removeIf avec lambda ---
        // Supprime tous les éléments pour lesquels la lambda
        // retourne true.
        // Ici : supprimer les tailles inférieures à 5.0 cm.
        System.out.println(
                "Suppression des valeurs < 5.0 avec removeIf :");
        sizes.removeIf(size -> size < 5.0);
        System.out.println("Après removeIf : " + sizes);
        System.out.println();

        // On peut enchaîner plusieurs removeIf
        System.out.println("Suppression des valeurs > 20.0 :");
        sizes.removeIf(size -> size > 20.0);
        System.out.println("Après removeIf : " + sizes);
    }
}
