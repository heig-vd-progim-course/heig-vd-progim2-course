// Classe Gardener - représente un jardinier qui cultive une parcelle
//
// Cette classe illustre les concepts de base de la POO :
// - Attributs pour représenter les données du jardinier
// - Constructeur pour initialiser un objet
// - Méthode pour afficher les informations
//
// Note : les attributs sont publics pour cette première version.
// Dans la prochaine session, nous verrons l'encapsulation avec des attributs
// privés et des getters/setters.

public class Gardener {
    // Attributs publics (pour le moment)
    public String name;
    public String email;
    public int experienceYears;

    // Constructeur pour initialiser tous les attributs
    public Gardener(String name, String email, int experienceYears) {
        this.name = name;
        this.email = email;
        this.experienceYears = experienceYears;
    }

    // Méthode pour afficher les informations du jardinier
    public void displayInfo() {
        System.out.println("=== Informations du jardinier ===");
        System.out.println("Nom: " + name);
        System.out.println("Email: " + email);
        System.out.println("Expérience: " + experienceYears + " ans");
        System.out.println();
    }
}
