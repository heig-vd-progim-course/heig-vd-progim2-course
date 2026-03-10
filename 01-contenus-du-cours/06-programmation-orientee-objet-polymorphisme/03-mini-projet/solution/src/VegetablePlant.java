/**
 * Classe représentant un légume dans le jardin.
 * Les légumes peuvent être récoltés, arrosés et grandissent.
 */
public class VegetablePlant extends PlantBase 
        implements Harvestable, Waterable, Growable {
    
    private int daysUntilHarvest;
    private boolean hasBeenHarvested;
    
    /**
     * Constructeur pour créer un légume.
     */
    public VegetablePlant(String name, String species, String plantingDate, 
                          double size, int daysUntilHarvest) {
        super(name, species, plantingDate, size);
        this.daysUntilHarvest = daysUntilHarvest;
        this.hasBeenHarvested = false;
    }
    
    // Getters et setters
    public int getDaysUntilHarvest() {
        return daysUntilHarvest;
    }
    
    public void setDaysUntilHarvest(int daysUntilHarvest) {
        if (daysUntilHarvest >= 0) {
            this.daysUntilHarvest = daysUntilHarvest;
        }
    }
    
    // Implémentation de Harvestable
    @Override
    public double harvest() {
        if (!isReadyToHarvest()) {
            System.out.println("Le légume " + getName() + 
                             " n'est pas encore prêt à être récolté.");
            return 0.0;
        }
        
        if (hasBeenHarvested) {
            System.out.println("Le légume " + getName() + 
                             " a déjà été récolté.");
            return 0.0;
        }
        
        // Quantité récoltée basée sur la taille (formule simple)
        double quantity = getSize() / 10.0;
        hasBeenHarvested = true;
        System.out.println("Récolte de " + getName() + " : " + 
                         String.format("%.2f", quantity) + " kg");
        return quantity;
    }
    
    @Override
    public boolean isReadyToHarvest() {
        return daysUntilHarvest == 0 && !hasBeenHarvested;
    }
    
    // Implémentation de Waterable
    @Override
    public void water(double liters) {
        System.out.println("Arrosage de " + getName() + " avec " + 
                         String.format("%.1f", liters) + " litres d'eau.");
        // Simulation de croissance après arrosage
        grow(0.5);
    }
    
    @Override
    public double getWaterNeedsPerWeek() {
        // Les légumes ont besoin de 5 à 10 litres par semaine selon leur taille
        return 5.0 + (getSize() / 20.0);
    }
    
    // Implémentation de Growable
    @Override
    public void grow(double centimeters) {
        double newSize = getSize() + centimeters;
        setSize(newSize);
        
        // Réduire le nombre de jours avant récolte
        if (daysUntilHarvest > 0) {
            daysUntilHarvest--;
        }
    }
    
    @Override
    public double getGrowthRate() {
        // Taux de croissance moyen : 3 cm par semaine
        return 3.0;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               String.format(" [Légume - Récolte dans %d jours]", daysUntilHarvest);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Légume");
        System.out.println("Jours avant récolte: " + daysUntilHarvest);
        System.out.println("Déjà récolté: " + (hasBeenHarvested ? "Oui" : "Non"));
    }
}
