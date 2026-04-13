/**
 * Exemple 04 - TreeSet et tri automatique
 *
 * Cet exemple montre comment TreeSet maintient ses éléments triés
 * et compare le comportement avec HashSet.
 */
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        System.out.println("=== Comparaison HashSet vs TreeSet ===");

        // HashSet : ordre non garanti
        Set<String> hashSet = new HashSet<>();
        hashSet.add("Tomate");
        hashSet.add("Basilic");
        hashSet.add("Carotte");
        hashSet.add("Menthe");
        hashSet.add("Aubergine");

        System.out.println("\nHashSet (ordre non garanti) : " + hashSet
                + " (ordre variable)");

        // TreeSet : trié automatiquement
        Set<String> treeSet = new TreeSet<>();
        treeSet.add("Tomate");
        treeSet.add("Basilic");
        treeSet.add("Carotte");
        treeSet.add("Menthe");
        treeSet.add("Aubergine");

        System.out.println("TreeSet (trié)              : " + treeSet);

        // Opérations spécifiques au TreeSet
        System.out.println("\n=== TreeSet : opérations sur un ensemble trié ===");

        // On peut caster vers TreeSet pour accéder aux méthodes spécifiques
        TreeSet<String> sorted = (TreeSet<String>) treeSet;
        System.out.println("Premier élément : " + sorted.first());
        System.out.println("Dernier élément : " + sorted.last());

        // L'ajout place automatiquement l'élément au bon endroit
        System.out.println("\nAjout de Courgette...");
        sorted.add("Courgette");
        System.out.println("Ensemble trié : " + sorted);
        System.out.println(
                "Courgette est automatiquement placée à la bonne position.");
    }
}
