/**
 * Classe représentant une parcelle dans le jardin communautaire.
 */
public class Plot {
    private int number;
    private double size;
    private String location;
    
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
    
    // Setters avec validation
    public void setNumber(int number) {
        if (number <= 0) {
            System.out.println("Erreur : le numéro de parcelle doit être positif.");
            return;
        }
        this.number = number;
    }
    
    public void setSize(double size) {
        if (size <= 0) {
            System.out.println("Erreur : la taille doit être positive.");
            return;
        }
        this.size = size;
    }
    
    public void setLocation(String location) {
        if (location == null || location.trim().isEmpty()) {
            System.out.println("Erreur : la localisation ne peut pas être vide.");
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
    }
}
