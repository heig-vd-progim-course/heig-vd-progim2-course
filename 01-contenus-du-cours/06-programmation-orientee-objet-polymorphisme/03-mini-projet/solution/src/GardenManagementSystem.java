public class GardenManagementSystem {
    public static void main(String[] args) {
        System.out.println("=== Système de gestion de jardin communautaire ===");
        System.out.println("Partie 3 : Polymorphisme\n");
        
        // Créer différents types de plantes
        VegetablePlant tomato = new VegetablePlant(
            "Tomate cerise", "Solanum lycopersicum", "2025-04-15", 45.5, 7
        );
        
        VegetablePlant carrot = new VegetablePlant(
            "Carotte", "Daucus carota", "2025-03-20", 12.0, 0
        );
        
        FlowerPlant rose = new FlowerPlant(
            "Rose", "Rosa", "2025-05-01", 35.0, "Rouge"
        );
        
        FlowerPlant tulip = new FlowerPlant(
            "Tulipe", "Tulipa", "2025-04-10", 22.0, "Jaune"
        );
        
        TreePlant appleTree = new TreePlant(
            "Pommier", "Malus domestica", "2022-03-15", 180.0, 3, 3
        );
        
        TreePlant cherryTree = new TreePlant(
            "Cerisier", "Prunus avium", "2024-04-01", 95.0, 1, 4
        );
        
        // Démonstration de toString()
        System.out.println("--- Affichage avec toString() ---");
        System.out.println(tomato);
        System.out.println(rose);
        System.out.println(appleTree);
        
        // Tableau de toutes les plantes (polymorphisme avec PlantBase)
        PlantBase[] allPlants = {tomato, carrot, rose, tulip, appleTree, cherryTree};
        
        // Générer un rapport
        GardenTask.generatePlantReport(allPlants);
        
        // Arrosage (polymorphisme avec Waterable)
        Waterable[] waterablePlants = {tomato, carrot, rose, tulip, appleTree, cherryTree};
        GardenTask.waterAllPlants(waterablePlants);
        
        // Simulation de croissance (polymorphisme avec Growable)
        Growable[] growablePlants = {tomato, carrot, rose, tulip, appleTree, cherryTree};
        GardenTask.simulateWeekGrowth(growablePlants);
        
        // Récolte (polymorphisme avec Harvestable)
        Harvestable[] harvestablePlants = {tomato, carrot, appleTree, cherryTree};
        GardenTask.harvestAllReadyPlants(harvestablePlants);
        
        // Afficher les informations détaillées après les opérations
        System.out.println("\n--- État final du jardin ---");
        for (PlantBase plant : allPlants) {
            System.out.println("\n" + plant);
            plant.displayInfo();
        }
        
        // Démonstration de equals()
        System.out.println("\n--- Test de equals() ---");
        VegetablePlant tomato2 = new VegetablePlant(
            "Tomate cerise", "Solanum lycopersicum", "2025-05-01", 30.0, 14
        );
        
        System.out.println("tomato.equals(carrot): " + tomato.equals(carrot));
        System.out.println("tomato.equals(tomato2): " + tomato.equals(tomato2));
        System.out.println("tomato.hashCode(): " + tomato.hashCode());
        System.out.println("tomato2.hashCode(): " + tomato2.hashCode());
    }
}
