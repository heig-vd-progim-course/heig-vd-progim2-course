/**
 * Classe représentant les tâches de jardinage.
 */
public class GardenTask {

    /**
     * Arrose toutes les plantes arrosables.
     *
     * @param plants le tableau des plantes arrosables
     */
    public static void waterAllPlants(Waterable[] plants) {
        System.out.println("=== Arrosage des plantes ===");
        for (Waterable plant : plants) {
            double waterNeeded = plant.getWaterNeedsPerWeek();
            plant.water(waterNeeded);
        }
    }

    /**
     * Récolte toutes les plantes prêtes à être récoltées.
     *
     * @param plants le tableau des plantes récoltables
     * @return la quantité totale récoltée en kg
     */
    public static double harvestAllReadyPlants(Harvestable[] plants) {
        System.out.println("=== Récolte des plantes ===");
        double totalHarvest = 0.0;
        for (Harvestable plant : plants) {
            if (plant.isReadyToHarvest()) {
                totalHarvest += plant.harvest();
            }
        }
        System.out.println("Récolte totale : "
                + String.format("%.1f", totalHarvest) + " kg");
        return totalHarvest;
    }

    /**
     * Simule une semaine de croissance pour toutes les plantes.
     *
     * @param plants le tableau des plantes en croissance
     */
    public static void simulateWeekGrowth(Growable[] plants) {
        System.out.println("=== Simulation d'une semaine de croissance ===");
        for (Growable plant : plants) {
            double growth = plant.getGrowthRate();
            plant.grow(growth);
            if (plant instanceof PlantBase) {
                PlantBase p = (PlantBase) plant;
                System.out.println(p.getName() + " a grandi de "
                        + String.format("%.1f", growth)
                        + " cm (taille : "
                        + String.format("%.1f", p.getSize()) + " cm)");
            }
        }
    }

    /**
     * Affiche un rapport sur toutes les plantes.
     *
     * @param plants le tableau des plantes
     */
    public static void generatePlantReport(PlantBase[] plants) {
        System.out.println("=== Rapport du jardin ===");
        System.out.println("Nombre total de plantes : " + plants.length);
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
        System.out.println("Plantes récoltables : " + harvestableCount);
        System.out.println("Plantes arrosables : " + waterableCount);
        System.out.println("Plantes en croissance : " + growableCount);
    }
}
