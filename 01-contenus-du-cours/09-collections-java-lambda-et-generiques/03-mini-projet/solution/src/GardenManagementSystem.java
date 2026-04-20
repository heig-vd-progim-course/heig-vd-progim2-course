import java.util.List;

/**
 * Programme principal du système de gestion de jardin communautaire.
 */
public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println("Partie 5 : Lambda et génériques\n");

        // --- Créer des parcelles avec des plantes ---
        System.out.println("--- Création des parcelles ---");
        Plot plot1 = new Plot(1, 25.0, "Zone Nord");
        Plot plot2 = new Plot(2, 30.0, "Zone Sud");

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
        plot2.addPlant(rose);
        plot2.addPlant(appleTree);
        System.out.println();

        // --- Affichage avec forEach (lambda) ---
        System.out.println("--- Affichage avec forEach ---");
        plot1.displayPlants();
        System.out.println();
        plot2.displayPlants();
        System.out.println();

        // --- Trier les plantes par nom ---
        System.out.println("--- Tri par nom ---");
        plot1.getPlants().sort(
                (a, b) -> a.getName().compareTo(b.getName()));
        plot1.displayPlants();
        System.out.println();

        // --- Filtrage avec Predicate ---
        System.out.println("--- Filtrage avec Predicate ---");
        List<PlantBase> largePlants =
                plot1.filterPlants(p -> p.getSize() > 30.0);
        System.out.println("Plantes > 30 cm dans parcelle 1 :");
        largePlants.forEach(p ->
                System.out.println("  - " + p.getName()));
        System.out.println();

        // --- FilterResult générique ---
        System.out.println("--- FilterResult générique ---");
        FilterResult<PlantBase> harvestableResult =
                plot1.filterPlantsDetailed(
                        p -> p instanceof Harvestable,
                        "Plantes récoltables");
        harvestableResult.displaySummary();
        System.out.println();

        FilterResult<PlantBase> treeResult =
                plot2.filterPlantsDetailed(
                        p -> p instanceof TreePlant,
                        "Arbres");
        treeResult.displaySummary();
        System.out.println();

        // --- Récolte et suppression avec lambdas ---
        System.out.println("--- Récolte et nettoyage ---");
        plot1.harvestAndRemoveReadyPlants();
        System.out.println();
        plot1.displayPlants();
    }
}
