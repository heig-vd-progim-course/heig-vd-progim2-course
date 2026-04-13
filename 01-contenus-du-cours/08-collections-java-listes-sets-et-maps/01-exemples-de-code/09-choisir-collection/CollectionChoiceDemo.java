/**
 * Exemple 09 - Choisir la bonne collection
 *
 * Cet exemple montre un jardin communautaire utilisant simultanément
 * une ArrayList, un HashSet et une HashMap pour répondre à des
 * besoins différents.
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionChoiceDemo {

    public static void main(String[] args) {
        System.out.println("=== Jardin communautaire : choix des collections ===");

        // ArrayList : les tâches du jour (l'ordre est important)
        List<String> dailyTasks = new ArrayList<>();
        dailyTasks.add("Arroser les tomates");
        dailyTasks.add("Récolter les carottes");
        dailyTasks.add("Planter du basilic");
        dailyTasks.add("Préparer le compost");

        System.out.println("\n--- Tâches du jour (ArrayList : ordre important) ---");
        int taskNumber = 1;
        for (String task : dailyTasks) {
            System.out.println(taskNumber + ". " + task);
            taskNumber++;
        }

        // HashSet : les espèces disponibles (chaque espèce est unique)
        Set<String> availableSpecies = new HashSet<>();
        availableSpecies.add("Tomate");
        availableSpecies.add("Carotte");
        availableSpecies.add("Basilic");
        availableSpecies.add("Menthe");
        availableSpecies.add("Tomate");   // Doublon ignoré
        availableSpecies.add("Carotte");  // Doublon ignoré

        System.out.println(
                "\n--- Espèces disponibles (HashSet : unicité) ---");
        System.out.println("Espèces : " + availableSpecies
                + " (ordre variable)");
        System.out.println("Nombre d'espèces uniques : "
                + availableSpecies.size());
        System.out.println("La Tomate est disponible : "
                + availableSpecies.contains("Tomate"));

        // HashMap : attribution des parcelles (clé = jardinière, valeur = parcelle)
        Map<String, String> plotAssignments = new HashMap<>();
        plotAssignments.put("Alice", "Parcelle A1");
        plotAssignments.put("Bob", "Parcelle B2");
        plotAssignments.put("Clara", "Parcelle A3");

        System.out.println(
                "\n--- Attributions (HashMap : association clé-valeur) ---");
        for (Map.Entry<String, String> entry
                : plotAssignments.entrySet()) {
            System.out.println(entry.getKey() + " -> "
                    + entry.getValue());
        }

        // Résumé
        System.out.println("\n=== Résumé ===");
        System.out.println(dailyTasks.size() + " tâches à réaliser");
        System.out.println(
                availableSpecies.size() + " espèces disponibles");
        System.out.println(
                plotAssignments.size() + " parcelles attribuées");
    }
}
