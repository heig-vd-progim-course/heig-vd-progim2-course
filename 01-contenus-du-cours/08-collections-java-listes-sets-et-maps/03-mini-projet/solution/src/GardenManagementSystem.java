import java.util.List;

/**
 * Programme principal du système de gestion de jardin communautaire.
 */
public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println();

        // --- Créer le catalogue d'espèces ---
        System.out.println("--- Catalogue des espèces ---");
        GardenCatalog catalog = new GardenCatalog();
        catalog.addSpecies("Solanum lycopersicum");
        catalog.addSpecies("Daucus carota");
        catalog.addSpecies("Rosa gallica");
        catalog.addSpecies("Malus domestica");
        catalog.addSpecies("Solanum lycopersicum"); // Doublon
        System.out.println();
        catalog.displayCatalog();
        System.out.println();

        // --- Créer des parcelles avec des listes ---
        System.out.println("--- Création des parcelles ---");
        Plot plotA = new Plot("Parcelle A", 25.0);
        Plot plotB = new Plot("Parcelle B", 30.0);

        VegetablePlant tomato = new VegetablePlant(
                "Tomate", "Solanum lycopersicum",
                "2026-03-15", 45.0, 0);
        VegetablePlant carrot = new VegetablePlant(
                "Carotte", "Daucus carota",
                "2026-03-20", 20.0, 30);
        FlowerPlant rose = new FlowerPlant(
                "Rose", "Rosa gallica",
                "2026-04-01", 60.0, "Rouge");
        TreePlant appleTree = new TreePlant(
                "Pommier", "Malus domestica",
                "2026-02-01", 150.0, 4);

        plotA.addPlant(tomato);
        plotA.addPlant(carrot);
        plotB.addPlant(rose);
        plotB.addPlant(appleTree);
        System.out.println();

        plotA.displayPlants();
        System.out.println();
        plotB.displayPlants();
        System.out.println();

        // --- Créer le registre jardinière-parcelle ---
        System.out.println("--- Registre du jardin ---");
        GardenRegistry registry = new GardenRegistry();
        registry.assignPlot("Alice", plotA);
        registry.assignPlot("Bob", plotB);
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
                    + alicePlot.getName());
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
        System.out.println("Parcelle A contient la tomate : "
                + plotA.containsPlant(tomato));
        System.out.println("Parcelle B contient la tomate : "
                + plotB.containsPlant(tomato));
        System.out.println();

        // --- Supprimer des plantes récoltées ---
        System.out.println("--- Récolte et nettoyage ---");
        tomato.harvest();
        System.out.println();
        plotA.removeHarvestedPlants();
        System.out.println();
        plotA.displayPlants();
    }
}
