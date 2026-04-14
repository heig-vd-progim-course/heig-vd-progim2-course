/**
 * Classe représentant un légume dans le jardin communautaire.
 */
public class VegetablePlant extends PlantBase
        implements Harvestable, Waterable, Growable {

    private int daysUntilHarvest;
    private boolean hasBeenHarvested;

    /**
     * Constructeur pour créer un légume.
     *
     * @param name             le nom de la plante
     * @param species          l'espèce de la plante
     * @param plantingDate     la date de plantation
     * @param size             la taille en centimètres
     * @param daysUntilHarvest le nombre de jours avant la récolte
     */
    public VegetablePlant(String name, String species, String plantingDate,
            double size, int daysUntilHarvest) {
        super(name, species, plantingDate, size);
        this.daysUntilHarvest = daysUntilHarvest;
        this.hasBeenHarvested = false;
    }

    public int getDaysUntilHarvest() {
        return daysUntilHarvest;
    }

    public void setDaysUntilHarvest(int daysUntilHarvest) {
        if (daysUntilHarvest >= 0) {
            this.daysUntilHarvest = daysUntilHarvest;
        }
    }

    @Override
    public double harvest() {
        if (!isReadyToHarvest()) {
            System.out.println(getName() + " n'est pas encore prête à être "
                    + "récoltée.");
            return 0.0;
        }
        double quantity = getSize() / 10.0;
        hasBeenHarvested = true;
        System.out.println("Récolte de " + getName() + " : "
                + String.format("%.1f", quantity) + " kg");
        return quantity;
    }

    @Override
    public boolean isReadyToHarvest() {
        return daysUntilHarvest == 0 && !hasBeenHarvested;
    }

    @Override
    public void water(double liters) {
        System.out.println("Arrosage de " + getName() + " avec "
                + String.format("%.1f", liters) + " litres d'eau.");
        grow(0.5);
    }

    @Override
    public double getWaterNeedsPerWeek() {
        return 5.0 + (getSize() / 20.0);
    }

    @Override
    public void grow(double centimeters) {
        setSize(getSize() + centimeters);
        if (daysUntilHarvest > 0) {
            daysUntilHarvest--;
        }
    }

    @Override
    public double getGrowthRate() {
        return 3.0;
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type : Légume");
        System.out.println("Jours avant récolte : " + daysUntilHarvest);
        System.out.println("Déjà récoltée : " + (hasBeenHarvested ? "Oui"
                : "Non"));
    }
}
