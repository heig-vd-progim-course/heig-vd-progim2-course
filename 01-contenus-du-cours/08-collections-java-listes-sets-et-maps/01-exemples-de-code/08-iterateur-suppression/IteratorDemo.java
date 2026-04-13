/**
 * Exemple 08 - Itérateur et suppression sécurisée
 *
 * Cet exemple montre comment utiliser un Iterator pour parcourir
 * une collection et supprimer des éléments de manière sécurisée.
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorDemo {

    public static void main(String[] args) {
        List<String> plants = new ArrayList<>(
            List.of("Tomate", "Carotte", "Thym", "Basilic",
                    "Tournesol", "Tomate")
        );

        // Parcours simple avec un itérateur
        System.out.println("=== Itérateur : parcours simple ===");

        Iterator<String> it = plants.iterator();

        while (it.hasNext()) {
            String plant = it.next();
            System.out.println("Plante : " + plant);
        }

        // Suppression sécurisée avec l'itérateur
        System.out.println("\n=== Suppression avec itérateur ===");
        System.out.println("Plantes avant : " + plants);
        System.out.println(
                "Suppression de tous les noms commençant par T...");

        // On crée un nouvel itérateur (le précédent est épuisé)
        Iterator<String> it2 = plants.iterator();

        while (it2.hasNext()) {
            String plant = it2.next();
            if (plant.startsWith("T")) {
                // it2.remove() supprime l'élément courant de manière sécurisée
                // Ne JAMAIS utiliser plants.remove() ici !
                it2.remove();
            }
        }

        System.out.println("Plantes après : " + plants);
    }
}
