import java.util.List;

/**
 * Programme principal du système de gestion de jardin communautaire.
 */
public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println("Partie 4 : Collections\n");

        // --- Créer le catalogue d'espèces ---
        System.out.println("--- Catalogue des espèces ---");
        GardenCatalog catalog = new GardenCatalog();
        catalog.addSpecies("Solanum lycopersicum");
        catalog.addSpecies("Daucus carota");
        catalog.addSpecies("Rosa");
        catalog.addSpecies("Malus domestica");
        catalog.addSpecies("Solanum lycopersicum"); // Doublon
        System.out.println();
        catalog.displayCatalog();
        System.out.println();

        // --- Créer des parcelles avec des listes ---
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

        plot1.displayPlants();
        System.out.println();
        plot2.displayPlants();
        System.out.println();

        // --- Créer le registre jardinière-parcelle ---
        System.out.println("--- Registre du jardin ---");
        GardenRegistry registry = new GardenRegistry();
        registry.assignPlot("Alice", plot1);
        registry.assignPlot("Bob", plot2);
        System.out.println();

        registry.displayAssignments();
        System.out.println();

        // --- Rechercher des informations ---
        System.out.println("--- Recherches ---");
        System.out.println("Nombre total de plantes : "
                + registry.getTotalPlantCount());

        Plot alicePlot = registry.getPlot("Alice");
        if (alicePlot != null) {
            System.out.println("Parcelle d'Alice : "
                    + alicePlot.getNumber());
        }

        System.out.println("Bob est inscrit : "
                + registry.isRegistered("Bob"));
        System.out.println("Clara est inscrite : "
                + registry.isRegistered("Clara"));
        System.out.println();

        List<String> plotsWithTomato =
                registry.findPlotsWithPlant(tomato);
        System.out.println("Parcelles avec des tomates : "
                + plotsWithTomato);
        System.out.println();

        // --- Vérifier si une plante existe dans la parcelle ---
        System.out.println("--- Vérifications ---");
        System.out.println("Parcelle 1 contient la tomate : "
                + plot1.containsPlant(tomato));
        System.out.println("Parcelle 2 contient la tomate : "
                + plot2.containsPlant(tomato));
        System.out.println();

        // --- Récolter et supprimer des plantes ---
        System.out.println("--- Récolte et nettoyage ---");
        plot1.harvestAndRemoveReadyPlants();
        System.out.println();
        plot1.displayPlants();
    }
}
