/**
 * Classe représentant une fleur ornementale dans le jardin.
 * Les fleurs peuvent être arrosées et grandissent, mais ne sont pas récoltées.
 */
public class FlowerPlant extends PlantBase implements Waterable, Growable {
    
    private String color;
    private boolean isInBloom;
    
    /**
     * Constructeur pour créer une fleur.
     */
    public FlowerPlant(String name, String species, String plantingDate, 
                       double size, String color) {
        super(name, species, plantingDate, size);
        this.color = color;
        this.isInBloom = false;
    }
    
    // Getters et setters
    public String getColor() {
        return color;
    }
    
    public void setColor(String color) {
        this.color = color;
    }
    
    public boolean isInBloom() {
        return isInBloom;
    }
    
    public void bloom() {
        isInBloom = true;
        System.out.println("La fleur " + getName() + " est maintenant en fleurs !");
    }
    
    // Implémentation de Waterable
    @Override
    public void water(double liters) {
        System.out.println("Arrosage de la fleur " + getName() + " avec " + 
                         String.format("%.1f", liters) + " litres d'eau.");
        
        // Les fleurs peuvent fleurir après un bon arrosage
        if (liters > 2.0 && getSize() > 20.0 && !isInBloom) {
            bloom();
        }
        
        grow(0.3);
    }
    
    @Override
    public double getWaterNeedsPerWeek() {
        // Les fleurs ont besoin de 3 à 6 litres par semaine
        return 3.0 + (getSize() / 30.0);
    }
    
    // Implémentation de Growable
    @Override
    public void grow(double centimeters) {
        double newSize = getSize() + centimeters;
        setSize(newSize);
    }
    
    @Override
    public double getGrowthRate() {
        // Taux de croissance moyen : 2 cm par semaine
        return 2.0;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               String.format(" [Fleur %s - %s]", 
                           color, isInBloom ? "En fleurs" : "Pas encore en fleurs");
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Fleur");
        System.out.println("Couleur: " + color);
        System.out.println("En fleurs: " + (isInBloom ? "Oui" : "Non"));
    }
}
