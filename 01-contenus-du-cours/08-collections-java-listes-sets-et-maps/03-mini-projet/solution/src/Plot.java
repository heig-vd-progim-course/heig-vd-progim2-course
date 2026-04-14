import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Classe représentant une parcelle du jardin communautaire.
 */
public class Plot {

    private String name;
    private double area;
    private List<PlantBase> plants;

    /**
     * Constructeur pour créer une parcelle.
     *
     * @param name le nom de la parcelle
     * @param area la surface en mètres carrés
     */
    public Plot(String name, double area) {
        this.name = name;
        this.area = area;
        this.plants = new ArrayList<>();
    }

    /**
     * Ajoute une plante à la parcelle.
     *
     * @param plant la plante à ajouter
     */
    public void addPlant(PlantBase plant) {
        plants.add(plant);
        System.out.println(plant.getName() + " ajoutée à la parcelle "
                + name + ".");
    }

    /**
     * Supprime une plante de la parcelle.
     *
     * @param plant la plante à supprimer
     * @return true si la plante a été supprimée, false sinon
     */
    public boolean removePlant(PlantBase plant) {
        boolean removed = plants.remove(plant);
        if (removed) {
            System.out.println(plant.getName()
                    + " retirée de la parcelle " + name + ".");
        } else {
            System.out.println(plant.getName()
                    + " non trouvée dans la parcelle " + name + ".");
        }
        return removed;
    }

    /**
     * Vérifie si la parcelle contient une plante donnée.
     *
     * @param plant la plante à rechercher
     * @return true si la plante est présente, false sinon
     */
    public boolean containsPlant(PlantBase plant) {
        return plants.contains(plant);
    }

    /**
     * Affiche toutes les plantes de la parcelle.
     */
    public void displayPlants() {
        System.out.println("Parcelle " + name + " (" + area + " m2) - "
                + plants.size() + " plante(s) :");
        for (PlantBase plant : plants) {
            System.out.println("  - " + plant);
        }
    }

    /**
     * Supprime toutes les plantes qui ont été récoltées.
     *
     * @return le nombre de plantes supprimées
     */
    public int removeHarvestedPlants() {
        int count = 0;
        Iterator<PlantBase> it = plants.iterator();
        while (it.hasNext()) {
            PlantBase plant = it.next();
            if (plant instanceof Harvestable) {
                Harvestable harvestable = (Harvestable) plant;
                if (!harvestable.isReadyToHarvest()) {
                    continue;
                }
                System.out.println("Retrait de " + plant.getName()
                        + " (récoltée).");
                it.remove();
                count++;
            }
        }
        System.out.println(count + " plante(s) récoltée(s) retirée(s) de "
                + name + ".");
        return count;
    }

    // Getters
    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public List<PlantBase> getPlants() {
        return plants;
    }

    /**
     * Retourne le nombre de plantes dans la parcelle.
     *
     * @return le nombre de plantes
     */
    public int getPlantCount() {
        return plants.size();
    }
}
