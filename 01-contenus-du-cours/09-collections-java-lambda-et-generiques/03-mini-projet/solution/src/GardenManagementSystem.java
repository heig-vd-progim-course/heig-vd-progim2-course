/**
 * Programme principal du système de gestion de jardin communautaire.
 */
public class GardenManagementSystem {

    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin "
                + "communautaire ===");
        System.out.println("Partie 5 : Les génériques\n");

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

        // --- Affichage des parcelles ---
        System.out.println("--- Affichage des parcelles ---");
        plot1.displayPlants();
        System.out.println();
        plot2.displayPlants();
        System.out.println();

        // --- FilterResult générique ---
        System.out.println("--- FilterResult générique ---");

        // Filtrer par taille minimale
        FilterResult<PlantBase> largePlants =
                plot1.filterPlantsByMinSize(30.0);
        largePlants.displaySummary();
        System.out.println();

        // Filtrer les plantes récoltables
        FilterResult<PlantBase> harvestableResult =
                plot1.filterHarvestablePlants();
        harvestableResult.displaySummary();
        System.out.println();

        // Filtrer par type dans la parcelle 2
        FilterResult<PlantBase> treeResult =
                plot2.filterPlantsByType("TreePlant");
        treeResult.displaySummary();
        System.out.println();

        // --- Démonstration de la réutilisabilité ---
        System.out.println(
                "--- Réutilisabilité de FilterResult ---");
        FilterResult<String> tagResult = new FilterResult<>(
                java.util.List.of("bio", "local"),
                5,
                "Étiquettes sélectionnées");
        tagResult.displaySummary();
        System.out.println();

        // --- Récolte et nettoyage ---
        System.out.println("--- Récolte et nettoyage ---");
        plot1.harvestAndRemoveReadyPlants();
        System.out.println();
        plot1.displayPlants();
    }
}
