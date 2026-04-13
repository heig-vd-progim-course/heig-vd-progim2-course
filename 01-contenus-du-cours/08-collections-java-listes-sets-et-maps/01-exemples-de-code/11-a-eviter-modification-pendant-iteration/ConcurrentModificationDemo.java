/**
 * À ÉVITER 11 - Modification pendant l'itération
 *
 * CE CODE CONTIENT UNE ERREUR VOLONTAIRE.
 * Il montre ce qu'il ne faut PAS faire : utiliser collection.remove()
 * dans une boucle for-each.
 *
 * Voir l'exemple 08-iterateur-suppression pour la bonne approche.
 */
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

public class ConcurrentModificationDemo {

    public static void main(String[] args) {
        // === ERREUR : modification pendant for-each ===
        System.out.println("=== ERREUR : modification pendant for-each ===");

        List<String> plants = new ArrayList<>(
            List.of("Tomate", "Carotte", "Thym", "Basilic", "Tournesol")
        );

        System.out.println("Plantes avant : " + plants);
        System.out.println("Tentative de suppression pendant for-each...");

        try {
            // ERREUR : ceci provoque une ConcurrentModificationException
            for (String plant : plants) {
                if (plant.startsWith("T")) {
                    plants.remove(plant); // NE JAMAIS FAIRE CELA !
                }
            }
        } catch (ConcurrentModificationException e) {
            System.out.println("ConcurrentModificationException attrapée !");
            System.out.println("Message : " + e.getMessage());
        }

        // === SOLUTION : utiliser Iterator.remove() ===
        System.out.println("\n=== SOLUTION : utiliser Iterator.remove() ===");

        // On recrée la liste car elle peut être dans un état incohérent
        List<String> plants2 = new ArrayList<>(
            List.of("Tomate", "Carotte", "Thym", "Basilic", "Tournesol")
        );

        System.out.println("Plantes avant : " + plants2);
        System.out.println("Suppression avec itérateur...");

        Iterator<String> it = plants2.iterator();
        while (it.hasNext()) {
            String plant = it.next();
            if (plant.startsWith("T")) {
                it.remove(); // Suppression sécurisée
            }
        }

        System.out.println("Plantes après : " + plants2);
    }
}
