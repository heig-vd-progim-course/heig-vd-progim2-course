/**
 * Classe représentant un arbre fruitier dans le jardin.
 * Les arbres peuvent être récoltés, arrosés et grandissent.
 */
public class TreePlant extends PlantBase 
        implements Harvestable, Waterable, Growable {
    
    private int ageInYears;
    private int minimumHarvestAge;
    
    /**
     * Constructeur pour créer un arbre.
     */
    public TreePlant(String name, String species, String plantingDate, 
                     double size, int ageInYears, int minimumHarvestAge) {
        super(name, species, plantingDate, size);
        this.ageInYears = ageInYears;
        this.minimumHarvestAge = minimumHarvestAge;
    }
    
    // Getters et setters
    public int getAgeInYears() {
        return ageInYears;
    }
    
    public void setAgeInYears(int ageInYears) {
        if (ageInYears >= 0) {
            this.ageInYears = ageInYears;
        }
    }
    
    public int getMinimumHarvestAge() {
        return minimumHarvestAge;
    }
    
    // Implémentation de Harvestable
    @Override
    public double harvest() {
        if (!isReadyToHarvest()) {
            System.out.println("L'arbre " + getName() + 
                             " n'est pas encore assez mature pour produire des fruits.");
            return 0.0;
        }
        
        // Quantité récoltée basée sur l'âge de l'arbre
        double quantity = (ageInYears - minimumHarvestAge + 1) * 5.0;
        System.out.println("Récolte de " + getName() + " : " + 
                         String.format("%.2f", quantity) + " kg de fruits");
        return quantity;
    }
    
    @Override
    public boolean isReadyToHarvest() {
        return ageInYears >= minimumHarvestAge;
    }
    
    // Implémentation de Waterable
    @Override
    public void water(double liters) {
        System.out.println("Arrosage de l'arbre " + getName() + " avec " + 
                         String.format("%.1f", liters) + " litres d'eau.");
        grow(0.2);
    }
    
    @Override
    public double getWaterNeedsPerWeek() {
        // Les arbres ont besoin de plus d'eau selon leur taille
        return 15.0 + (getSize() / 10.0);
    }
    
    // Implémentation de Growable
    @Override
    public void grow(double centimeters) {
        double newSize = getSize() + centimeters;
        setSize(newSize);
    }
    
    @Override
    public double getGrowthRate() {
        // Les arbres grandissent plus lentement : 1 cm par semaine
        return 1.0;
    }
    
    @Override
    public String toString() {
        return super.toString() + 
               String.format(" [Arbre - Âge: %d ans]", ageInYears);
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Arbre fruitier");
        System.out.println("Âge: " + ageInYears + " ans");
        System.out.println("Âge minimum de récolte: " + minimumHarvestAge + " ans");
        System.out.println("Prêt à récolter: " + (isReadyToHarvest() ? "Oui" : "Non"));
    }
}
