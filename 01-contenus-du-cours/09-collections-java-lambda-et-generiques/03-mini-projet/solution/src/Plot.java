import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Classe représentant une parcelle dans le jardin communautaire.
 * Cette version utilise des lambdas pour simplifier le parcours
 * et le filtrage.
 */
public class Plot {
    private int number;
    private double size;
    private String location;
    private List<PlantBase> plants;

    /**
     * Constructeur pour créer une parcelle.
     *
     * @param number le numéro de la parcelle
     * @param size la taille en mètres carrés
     * @param location la localisation
     */
    public Plot(int number, double size, String location) {
        setNumber(number);
        setSize(size);
        setLocation(location);
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
                + number + ".");
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
            System.out.println(plant.getName() + " retirée de la parcelle "
                    + number + ".");
        } else {
            System.out.println(plant.getName() + " non trouvée dans la "
                    + "parcelle " + number + ".");
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
     * Affiche toutes les plantes de la parcelle avec forEach.
     */
    public void displayPlants() {
        System.out.println("Parcelle " + number + " (" + location
                + ", " + size + " m2) - "
                + plants.size() + " plante(s) :");
        plants.forEach(plant -> System.out.println("  - " + plant));
    }

    /**
     * Récolte et supprime toutes les plantes prêtes à être récoltées.
     *
     * @return le nombre de plantes récoltées et supprimées
     */
    public int harvestAndRemoveReadyPlants() {
        // Identifier les plantes prêtes à récolter
        List<PlantBase> toRemove = new ArrayList<>();
        plants.forEach(plant -> {
            if (plant instanceof Harvestable) {
                Harvestable harvestable = (Harvestable) plant;
                if (harvestable.isReadyToHarvest()) {
                    harvestable.harvest();
                    toRemove.add(plant);
                }
            }
        });

        // Supprimer les plantes récoltées
        plants.removeAll(toRemove);
        int count = toRemove.size();

        System.out.println(count
                + " plante(s) récoltée(s) et retirée(s) de la parcelle "
                + number + ".");
        return count;
    }

    /**
     * Retourne les plantes qui satisfont un prédicat.
     *
     * @param predicate le critère de filtrage
     * @return la liste des plantes correspondantes
     */
    public List<PlantBase> filterPlants(
            Predicate<PlantBase> predicate) {
        List<PlantBase> result = new ArrayList<>();
        plants.forEach(plant -> {
            if (predicate.test(plant)) {
                result.add(plant);
            }
        });
        return result;
    }

    /**
     * Filtre les plantes selon un prédicat et retourne un résultat
     * détaillé.
     *
     * @param predicate le critère de filtrage
     * @param description la description du critère
     * @return un FilterResult contenant les plantes correspondantes
     */
    public FilterResult<PlantBase> filterPlantsDetailed(
            Predicate<PlantBase> predicate, String description) {
        List<PlantBase> result = new ArrayList<>();
        plants.forEach(plant -> {
            if (predicate.test(plant)) {
                result.add(plant);
            }
        });
        return new FilterResult<>(result, plants.size(), description);
    }

    // Getters
    public int getNumber() {
        return number;
    }

    public double getSize() {
        return size;
    }

    public String getLocation() {
        return location;
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

    // Setters avec validation
    public void setNumber(int number) {
        if (number <= 0) {
            System.out.println(
                    "Erreur : le numéro de parcelle doit être positif.");
            return;
        }
        this.number = number;
    }

    public void setSize(double size) {
        if (size <= 0) {
            System.out.println(
                    "Erreur : la taille doit être positive.");
            return;
        }
        this.size = size;
    }

    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            System.out.println(
                    "Erreur : la localisation ne peut pas être vide.");
            return;
        }
        this.location = location;
    }

    /**
     * Affiche les informations de la parcelle.
     */
    public void displayInfo() {
        System.out.println("=== Informations de la parcelle ===");
        System.out.println("Numéro: " + number);
        System.out.println("Taille: " + size + " m²");
        System.out.println("Localisation: " + location);
        System.out.println("Nombre de plantes: " + plants.size());
    }
}
