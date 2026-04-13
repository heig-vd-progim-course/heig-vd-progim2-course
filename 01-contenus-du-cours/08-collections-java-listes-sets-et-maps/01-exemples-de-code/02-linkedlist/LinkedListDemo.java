/**
 * Exemple 02 - LinkedList
 *
 * Cet exemple montre l'utilisation de LinkedList et les différences
 * avec ArrayList. Les deux implémentent l'interface List.
 */
import java.util.LinkedList;
import java.util.List;

public class LinkedListDemo {

    public static void main(String[] args) {
        // LinkedList : même interface List, implémentation différente
        LinkedList<String> tasks = new LinkedList<>();

        tasks.add("Arroser les tomates");
        tasks.add("Récolter les carottes");
        tasks.add("Planter du basilic");

        System.out.println("=== LinkedList : file de tâches ===");
        System.out.println("Tâches : " + tasks);

        // Méthodes spécifiques à LinkedList
        System.out.println("\nAjout en début de liste : Préparer le compost");
        tasks.addFirst("Préparer le compost");

        System.out.println("Ajout en fin de liste : Ranger les outils");
        tasks.addLast("Ranger les outils");

        System.out.println("Tâches : " + tasks);

        // Accès au premier et dernier élément
        System.out.println("\nPremière tâche : " + tasks.getFirst());
        System.out.println("Dernière tâche : " + tasks.getLast());

        // Suppression du premier et dernier élément
        System.out.println("\nSuppression de la première tâche...");
        tasks.removeFirst();

        System.out.println("Suppression de la dernière tâche...");
        tasks.removeLast();

        System.out.println("Tâches restantes : " + tasks);
    }
}
