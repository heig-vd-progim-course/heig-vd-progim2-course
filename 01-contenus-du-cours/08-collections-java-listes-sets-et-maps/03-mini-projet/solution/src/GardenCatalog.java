import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Catalogue des espèces disponibles dans le jardin communautaire.
 * Chaque espèce n'apparaît qu'une seule fois.
 */
public class GardenCatalog {

    private Set<String> species;

    /**
     * Constructeur pour créer un catalogue vide.
     */
    public GardenCatalog() {
        this.species = new HashSet<>();
    }

    /**
     * Ajoute une espèce au catalogue.
     *
     * @param speciesName le nom de l'espèce à ajouter
     * @return true si l'espèce a été ajoutée, false si elle existait déjà
     */
    public boolean addSpecies(String speciesName) {
        boolean added = species.add(speciesName);
        if (added) {
            System.out.println("Espèce ajoutée au catalogue : "
                    + speciesName + ".");
        } else {
            System.out.println("L'espèce " + speciesName
                    + " est déjà dans le catalogue.");
        }
        return added;
    }

    /**
     * Vérifie si une espèce est dans le catalogue.
     *
     * @param speciesName le nom de l'espèce à rechercher
     * @return true si l'espèce est dans le catalogue, false sinon
     */
    public boolean hasSpecies(String speciesName) {
        return species.contains(speciesName);
    }

    /**
     * Retourne le nombre d'espèces dans le catalogue.
     *
     * @return le nombre d'espèces
     */
    public int getSpeciesCount() {
        return species.size();
    }

    /**
     * Affiche toutes les espèces du catalogue par ordre alphabétique.
     */
    public void displayCatalog() {
        System.out.println("Catalogue du jardin (" + species.size()
                + " espèce(s)) :");
        Set<String> sorted = new TreeSet<>(species);
        for (String s : sorted) {
            System.out.println("  - " + s);
        }
    }
}
