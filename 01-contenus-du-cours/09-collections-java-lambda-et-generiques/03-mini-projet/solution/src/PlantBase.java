/**
 * Classe abstraite de base pour toutes les plantes du jardin.
 * Cette classe contient les attributs et méthodes communs à toutes les plantes.
 */
public abstract class PlantBase {
    private String name;
    private String species;
    private String plantingDate;
    private double size;
    
    /**
     * Constructeur pour créer une plante.
     * 
     * @param name le nom de la plante
     * @param species l'espèce de la plante
     * @param plantingDate la date de plantation
     * @param size la taille de la plante en centimètres
     */
    public PlantBase(String name, String species, String plantingDate, double size) {
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
            System.out.println("Erreur : la date de plantation ne peut pas être vide.");
            return;
        }
        this.plantingDate = plantingDate;
    }
    
    public void setSize(double size) {
        if (size < 0) {
            System.out.println("Erreur : la taille ne peut pas être négative.");
            return;
        }
        this.size = size;
    }
    
    /**
     * Retourne une représentation textuelle de la plante.
     */
    @Override
    public String toString() {
        return String.format("%s (%s) - %.1f cm - Planté le %s", 
                           name, species, size, plantingDate);
    }
    
    /**
     * Compare cette plante avec un autre objet pour l'égalité.
     * Deux plantes sont égales si elles ont le même nom et la même espèce.
     */
    @Override
    public boolean equals(Object obj) {
        // Vérifier si c'est le même objet
        if (this == obj) {
            return true;
        }
        
        // Vérifier si l'objet est null ou d'un type différent
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        
        // Comparer les attributs
        PlantBase other = (PlantBase) obj;
        return name.equals(other.name) && species.equals(other.species);
    }
    
    /**
     * Retourne un code de hachage pour cette plante.
     * Le code de hachage est basé sur le nom et l'espèce.
     */
    @Override
    public int hashCode() {
        // Combiner les codes de hachage du nom et de l'espèce
        int result = name.hashCode();
        result = 31 * result + species.hashCode();
        return result;
    }
    
    /**
     * Affiche les informations de base de la plante.
     */
    public void displayInfo() {
        System.out.println("=== Informations de la plante ===");
        System.out.println("Nom: " + name);
        System.out.println("Espèce: " + species);
        System.out.println("Date de plantation: " + plantingDate);
        System.out.println("Taille: " + size + " cm");
    }
}
