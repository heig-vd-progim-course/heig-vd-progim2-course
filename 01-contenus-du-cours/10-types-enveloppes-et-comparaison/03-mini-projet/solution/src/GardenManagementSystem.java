import java.util.HashSet;

/**
 * Programme principal du système de gestion de jardin communautaire.
 */
public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println("Partie 6 : Types enveloppes et "
                + "comparaison d'objets\n");

        // --- Création des plantes et des parcelles ---
        System.out.println("--- Création des parcelles ---");
        Plot plot1 = new Plot(1, 25.0, "Zone Nord");

        VegetablePlant tomato = new VegetablePlant(
                "Tomate cerise", "Solanum lycopersicum",
                "2026-03-15", 45.5, 0);
        VegetablePlant carrot = new VegetablePlant(
                "Carotte", "Daucus carota",
                "2026-03-20", 12.0, 30);
        FlowerPlant rose = new FlowerPlant(
                "Rose", "Rosa",
                "2026-04-01", 35.0, "Rouge");
        TreePlant appleTree = new TreePlant(
                "Pommier", "Malus domestica",
                "2026-02-01", 180.0, 3, 3);

        plot1.addPlant(tomato);
        plot1.addPlant(carrot);
        plot1.addPlant(rose);
        plot1.addPlant(appleTree);
        System.out.println();

        // --- Test de la détection des doublons ---
        System.out.println("--- Détection des doublons (equals + hashCode) ---");
        // Même nom et même espèce que tomato, mais données différentes
        VegetablePlant tomatoCopy = new VegetablePlant(
                "Tomate cerise", "Solanum lycopersicum",
                "2026-05-01", 10.0, 15);
        plot1.addPlant(tomatoCopy);  // doit être refusé
        System.out.println();

        // --- equals() sur les plantes ---
        System.out.println("--- equals() sur les plantes ---");
        System.out.println("tomato == tomatoCopy : "
                + (tomato == tomatoCopy));
        System.out.println("tomato.equals(tomatoCopy) : "
                + tomato.equals(tomatoCopy));
        System.out.println();

        // --- equals() et hashCode() sur Gardener ---
        System.out.println("--- equals() et hashCode() sur Gardener ---");
        Gardener g1 = new Gardener("Alice Martin", "alice@jardin.ch", 5);
        Gardener g2 = new Gardener("Alice M.", "alice@jardin.ch", 3);
        System.out.println("g1 == g2 : " + (g1 == g2));
        System.out.println("g1.equals(g2) : " + g1.equals(g2));

        HashSet<Gardener> gardeners = new HashSet<>();
        gardeners.add(g1);
        gardeners.add(g2);  // doublon : même email
        System.out.println("Taille du HashSet (attendu 1) : "
                + gardeners.size());
        System.out.println();

        // --- Tri par taille croissante ---
        System.out.println("--- Tri des plantes par taille croissante ---");
        plot1.displayPlants();
        System.out.println();
        plot1.displayPlantsSorted();
    }
}

