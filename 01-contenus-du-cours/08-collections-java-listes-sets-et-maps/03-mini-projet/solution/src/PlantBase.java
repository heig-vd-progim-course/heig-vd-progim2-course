/**
 * Classe abstraite de base pour toutes les plantes du jardin communautaire.
 */
public abstract class PlantBase {

    private String name;
    private String species;
    private String plantingDate;
    private double size;

    /**
     * Constructeur pour créer une plante.
     *
     * @param name        le nom de la plante
     * @param species     l'espèce de la plante
     * @param plantingDate la date de plantation
     * @param size        la taille de la plante en centimètres
     */
    public PlantBase(String name, String species, String plantingDate,
            double size) {
        setName(name);
        setSpecies(species);
        setPlantingDate(plantingDate);
        setSize(size);
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getSpecies() {
        return species;
    }

    public String getPlantingDate() {
        return plantingDate;
    }

    public double getSize() {
        return size;
    }

    // Setters avec validation
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Erreur : le nom ne peut pas être vide.");
            return;
        }
        this.name = name;
    }

    public void setSpecies(String species) {
        if (species == null || species.trim().isEmpty()) {
            System.out.println("Erreur : l'espèce ne peut pas être vide.");
            return;
        }
        this.species = species;
    }

    public void setPlantingDate(String plantingDate) {
        if (plantingDate == null || plantingDate.trim().isEmpty()) {
            System.out.println(
                    "Erreur : la date de plantation ne peut pas être vide.");
            return;
        }
        this.plantingDate = plantingDate;
    }

    public void setSize(double size) {
        if (size < 0) {
            System.out.println(
                    "Erreur : la taille ne peut pas être négative.");
            return;
        }
        this.size = size;
    }

    @Override
    public String toString() {
        return name + " (" + species + ") - " + size + " cm";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PlantBase other = (PlantBase) obj;
        return name.equals(other.name) && species.equals(other.species);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + species.hashCode();
        return result;
    }

    /**
     * Affiche les informations de base de la plante.
     */
    public void displayInfo() {
        System.out.println("Nom : " + name);
        System.out.println("Espèce : " + species);
        System.out.println("Date de plantation : " + plantingDate);
        System.out.println("Taille : " + size + " cm");
    }
}
