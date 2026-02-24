// Classe Plot - représente une parcelle dans le jardin communautaire
//
// Cette classe illustre les concepts de base de la POO :
// - Attributs de différents types (int, double, String)
// - Constructeur pour initialiser un objet
// - Méthode pour afficher les informations
//
// Note : les attributs sont publics pour cette première version.
// Dans la prochaine session, nous verrons l'encapsulation avec des attributs
// privés et des getters/setters.

public class Plot {
    // Attributs publics (pour le moment)
    public int plotNumber;
    public double size;
    public String location;

    // Constructeur pour initialiser tous les attributs
    public Plot(int plotNumber, double size, String location) {
        this.plotNumber = plotNumber;
        this.size = size;
        this.location = location;
    }

    // Méthode pour afficher les informations de la parcelle
    public void displayInfo() {
        System.out.println("=== Informations de la parcelle ===");
        System.out.println("Numéro: " + plotNumber);
        System.out.println("Taille: " + size + " m²");
        System.out.println("Localisation: " + location);
        System.out.println();
    }
}
