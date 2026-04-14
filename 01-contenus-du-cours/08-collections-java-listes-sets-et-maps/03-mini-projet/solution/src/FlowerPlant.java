/**
 * Classe représentant une fleur ornementale dans le jardin communautaire.
 */
public class FlowerPlant extends PlantBase implements Waterable, Growable {

    private String color;
    private boolean isInBloom;

    /**
     * Constructeur pour créer une fleur.
     *
     * @param name         le nom de la plante
     * @param species      l'espèce de la plante
     * @param plantingDate la date de plantation
     * @param size         la taille en centimètres
     * @param color        la couleur de la fleur
     */
    public FlowerPlant(String name, String species, String plantingDate,
            double size, String color) {
        super(name, species, plantingDate, size);
        this.color = color;
        this.isInBloom = false;
    }

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
        System.out.println(getName() + " est maintenant en fleurs !");
    }

    @Override
    public void water(double liters) {
        System.out.println("Arrosage de " + getName() + " avec "
                + String.format("%.1f", liters) + " litres d'eau.");
        if (liters > 2.0 && getSize() > 20.0 && !isInBloom) {
            bloom();
        }
        grow(0.3);
    }

    @Override
    public double getWaterNeedsPerWeek() {
        return 3.0 + (getSize() / 30.0);
    }

    @Override
    public void grow(double centimeters) {
        setSize(getSize() + centimeters);
    }

    @Override
    public double getGrowthRate() {
        return 2.0;
    }

    @Override
    public String toString() {
        return super.toString() + " - Couleur : " + color;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type : Fleur");
        System.out.println("Couleur : " + color);
        System.out.println("En fleurs : " + (isInBloom ? "Oui" : "Non"));
    }
}
