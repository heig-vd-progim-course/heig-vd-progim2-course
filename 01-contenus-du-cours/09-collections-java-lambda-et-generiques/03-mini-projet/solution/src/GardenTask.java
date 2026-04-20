/**
 * Classe représentant les tâches de jardinage.
 * Cette classe utilise le polymorphisme pour effectuer des actions
 * sur différents types de plantes.
 */
public class GardenTask {
    
    /**
     * Arrose toutes les plantes qui peuvent être arrosées.
     */
    public static void waterAllPlants(Waterable[] plants) {
        System.out.println("\n=== Arrosage des plantes ===");
        
        for (Waterable plant : plants) {
            double waterNeeded = plant.getWaterNeedsPerWeek();
            plant.water(waterNeeded);
        }
    }
    
    /**
     * Récolte toutes les plantes qui peuvent être récoltées.
     */
    public static double harvestAllReadyPlants(Harvestable[] plants) {
        System.out.println("\n=== Récolte des plantes ===");
        
        double totalHarvest = 0.0;
        for (Harvestable plant : plants) {
            if (plant.isReadyToHarvest()) {
                totalHarvest += plant.harvest();
            }
        }
        
        System.out.println("\nRécolte totale: " + 
                         String.format("%.2f", totalHarvest) + " kg");
        return totalHarvest;
    }
    
    /**
     * Fait grandir toutes les plantes pendant une semaine.
     */
    public static void simulateWeekGrowth(Growable[] plants) {
        System.out.println("\n=== Simulation d'une semaine de croissance ===");
        
        for (Growable plant : plants) {
            double growth = plant.getGrowthRate();
            plant.grow(growth);
            
            // Afficher le nom si c'est une PlantBase
            if (plant instanceof PlantBase) {
                PlantBase p = (PlantBase) plant;
                System.out.println(p.getName() + " a grandi de " + 
                                 String.format("%.1f", growth) + 
                                 " cm (nouvelle taille: " + 
                                 String.format("%.1f", p.getSize()) + " cm)");
            }
        }
    }
    
    /**
     * Affiche un rapport sur toutes les plantes.
     */
    public static void generatePlantReport(PlantBase[] plants) {
        System.out.println("\n=== Rapport du jardin ===");
        System.out.println("Nombre total de plantes: " + plants.length);
        
        int harvestableCount = 0;
        int waterableCount = 0;
        int growableCount = 0;
        
        for (PlantBase plant : plants) {
            if (plant instanceof Harvestable) {
                harvestableCount++;
            }
            if (plant instanceof Waterable) {
                waterableCount++;
            }
            if (plant instanceof Growable) {
                growableCount++;
            }
        }
        
        System.out.println("Plantes récoltables: " + harvestableCount);
        System.out.println("Plantes arrosables: " + waterableCount);
        System.out.println("Plantes en croissance: " + growableCount);
    }
}
