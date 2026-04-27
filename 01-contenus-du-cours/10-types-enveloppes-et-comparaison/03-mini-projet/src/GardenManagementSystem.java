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
        // TODO étape 2 : tenter d'ajouter tomatoCopy dans plot1
        //   VegetablePlant tomatoCopy = new VegetablePlant(
        //       "Tomate cerise", "Solanum lycopersicum",
        //       "2026-05-01", 10.0, 15);
        //   plot1.addPlant(tomatoCopy);

        // --- equals() sur les plantes ---
        // TODO étape 2 : afficher tomato == tomatoCopy et
        //   tomato.equals(tomatoCopy)

        // --- equals() et hashCode() sur Gardener ---
        // TODO étape 3 : créer g1, g2 avec le même email
        //   et montrer qu'un HashSet<Gardener> ne garde qu'un seul élément

        // --- Tri par taille croissante ---
        // TODO étape 5 : appeler plot1.displayPlants()
        //   puis plot1.displayPlantsSorted()
    }
}
