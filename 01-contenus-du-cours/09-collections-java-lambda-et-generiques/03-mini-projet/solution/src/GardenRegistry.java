import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Registre du jardin communautaire.
 * Associe chaque jardinière (par son nom) à sa parcelle.
 */
public class GardenRegistry {

    private Map<String, Plot> assignments;

    /**
     * Constructeur pour créer un registre vide.
     */
    public GardenRegistry() {
        this.assignments = new HashMap<>();
    }

    /**
     * Assigne une parcelle à une jardinière.
     * Si la jardinière avait déjà une parcelle, l'ancienne est remplacée.
     *
     * @param gardenerName le nom de la jardinière
     * @param plot la parcelle à assigner
     */
    public void assignPlot(String gardenerName, Plot plot) {
        Plot previous = assignments.put(gardenerName, plot);
        if (previous != null) {
            System.out.println(gardenerName
                    + " est maintenant assignée à la parcelle "
                    + plot.getNumber() + " (ancienne : "
                    + previous.getNumber() + ").");
        } else {
            System.out.println(gardenerName
                    + " est assignée à la parcelle "
                    + plot.getNumber() + ".");
        }
    }

    /**
     * Retrouve la parcelle d'une jardinière.
     *
     * @param gardenerName le nom de la jardinière
     * @return la parcelle associée, ou null si la jardinière n'est pas inscrite
     */
    public Plot getPlot(String gardenerName) {
        return assignments.get(gardenerName);
    }

    /**
     * Vérifie si une jardinière est inscrite au registre.
     *
     * @param gardenerName le nom de la jardinière
     * @return true si la jardinière est inscrite, false sinon
     */
    public boolean isRegistered(String gardenerName) {
        return assignments.containsKey(gardenerName);
    }

    /**
     * Retire une jardinière du registre.
     *
     * @param gardenerName le nom de la jardinière à retirer
     * @return la parcelle qui était associée, ou null si non inscrite
     */
    public Plot unregister(String gardenerName) {
        Plot removed = assignments.remove(gardenerName);
        if (removed != null) {
            System.out.println(gardenerName
                    + " a été retirée du registre (parcelle "
                    + removed.getNumber() + ").");
        }
        return removed;
    }

    /**
     * Affiche toutes les associations jardinière-parcelle.
     */
    public void displayAssignments() {
        System.out.println("Registre du jardin ("
                + assignments.size() + " inscription(s)) :");
        for (Map.Entry<String, Plot> entry : assignments.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> Parcelle "
                    + entry.getValue().getNumber());
        }
    }

    /**
     * Retourne le nombre total de plantes dans toutes les parcelles.
     *
     * @return le nombre total de plantes
     */
    public int getTotalPlantCount() {
        int total = 0;
        for (Plot plot : assignments.values()) {
            total += plot.getPlantCount();
        }
        return total;
    }

    /**
     * Recherche toutes les parcelles contenant une plante donnée.
     *
     * @param plant la plante à rechercher
     * @return la liste des noms de parcelles contenant la plante
     */
    public List<String> findPlotsWithPlant(PlantBase plant) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Plot> entry : assignments.entrySet()) {
            if (entry.getValue().containsPlant(plant)) {
                result.add("Parcelle " + entry.getValue().getNumber());
            }
        }
        return result;
    }
}
