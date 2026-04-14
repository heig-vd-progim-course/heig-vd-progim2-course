/**
 * Classe représentant un arbre fruitier dans le jardin communautaire.
 */
public class TreePlant extends PlantBase
        implements Harvestable, Waterable, Growable {

    private int ageInYears;
    private int minimumHarvestAge;

    /**
     * Constructeur pour créer un arbre fruitier.
     *
     * @param name               le nom de la plante
     * @param species            l'espèce de la plante
     * @param plantingDate       la date de plantation
     * @param size               la taille en centimètres
     * @param ageInYears         l'âge de l'arbre en années
     * @param minimumHarvestAge  l'âge minimum pour la récolte
     */
    public TreePlant(String name, String species, String plantingDate,
            double size, int ageInYears, int minimumHarvestAge) {
        super(name, species, plantingDate, size);
        this.ageInYears = ageInYears;
        this.minimumHarvestAge = minimumHarvestAge;
    }

    /**
     * Constructeur simplifié avec âge minimum de récolte par défaut (3 ans).
     *
     * @param name         le nom de la plante
     * @param species      l'espèce de la plante
     * @param plantingDate la date de plantation
     * @param size         la taille en centimètres
     * @param ageInYears   l'âge de l'arbre en années
     */
    public TreePlant(String name, String species, String plantingDate,
            double size, int ageInYears) {
        this(name, species, plantingDate, size, ageInYears, 3);
    }

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

    @Override
    public double harvest() {
        if (!isReadyToHarvest()) {
            System.out.println(getName()
                    + " n'est pas encore assez mature pour produire des "
                    + "fruits.");
            return 0.0;
        }
        double quantity = (ageInYears - minimumHarvestAge + 1) * 5.0;
        System.out.println("Récolte de " + getName() + " : "
                + String.format("%.1f", quantity) + " kg de fruits");
        return quantity;
    }

    @Override
    public boolean isReadyToHarvest() {
        return ageInYears >= minimumHarvestAge;
    }

    @Override
    public void water(double liters) {
        System.out.println("Arrosage de " + getName() + " avec "
                + String.format("%.1f", liters) + " litres d'eau.");
        grow(0.2);
    }

    @Override
    public double getWaterNeedsPerWeek() {
        return 15.0 + (getSize() / 10.0);
    }

    @Override
    public void grow(double centimeters) {
        setSize(getSize() + centimeters);
    }

    @Override
    public double getGrowthRate() {
        return 1.0;
    }

    @Override
    public String toString() {
        return super.toString() + " - Âge: " + ageInYears + " ans";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type : Arbre fruitier");
        System.out.println("Âge : " + ageInYears + " ans");
        System.out.println("Âge minimum de récolte : " + minimumHarvestAge
                + " ans");
        System.out.println("Prêt à récolter : "
                + (isReadyToHarvest() ? "Oui" : "Non"));
    }
}
