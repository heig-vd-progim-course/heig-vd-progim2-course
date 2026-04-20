import java.util.ArrayList;
import java.util.List;

/**
 * Contre-exemple : limitations de instanceof avec les génériques.
 *
 * Ce code illustre les limites imposées par l'effacement de type
 * (type erasure) en Java.
 */
public class TypeErasureAntiPattern {
    public static void main(String[] args) {
        System.out.println(
                "=== A éviter : instanceof avec génériques ===");
        System.out.println();

        // --- Effacement de type ---
        System.out.println("--- Effacement de type ---");

        // À la compilation, Box<String> et Box<Integer> sont
        // des types distincts. Mais à l'exécution, les deux
        // deviennent simplement "Box" (le type paramétré
        // est effacé).
        GenericBox<String> box1 = new GenericBox<>("Hello");
        GenericBox<Integer> box2 = new GenericBox<>(42);

        System.out.println("box1 est de type : "
                + box1.getClass().getSimpleName());
        System.out.println("box2 est de type : "
                + box2.getClass().getSimpleName());
        System.out.println("Même classe ? "
                + (box1.getClass() == box2.getClass()));
        System.out.println();

        // --- Limitations ---
        System.out.println("--- Limitations ---");

        List<String> list = new ArrayList<>();
        list.add("test");

        // Ce code ne compile PAS :
        // if (list instanceof List<String>) { }
        // Erreur : impossible de vérifier le type paramétré
        // à l'exécution.
        System.out.println("On ne peut pas écrire : "
                + "if (list instanceof List<String>)");

        // On ne peut pas non plus :
        // - créer une instance de T : new T()
        // - créer un tableau de T : new T[10]
        System.out.println("On ne peut pas écrire : "
                + "new T() ou new T[]");

        // On peut uniquement tester avec un wildcard :
        System.out.println("On peut seulement tester : "
                + "if (list instanceof List<?>)");
        System.out.println("list est une List<?> : "
                + (list instanceof List<?>));
    }
}

/**
 * Classe générique simple pour la démonstration.
 */
class GenericBox<T> {
    private T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
