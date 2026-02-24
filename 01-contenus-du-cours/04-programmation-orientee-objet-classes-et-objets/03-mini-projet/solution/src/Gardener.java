// Classe Gardener - représente une jardinière qui cultive une parcelle
//
// Cette classe illustre les concepts de base de la POO :
// - Attributs pour représenter les données de la jardinière
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

    // Méthode pour afficher les informations de la jardinière
    public void displayInfo() {
        System.out.println("=== Informations de la jardinière ===");
        System.out.println("Nom: " + name);
        System.out.println("Email: " + email);
        System.out.println("Expérience: " + experienceYears + " ans");
        System.out.println();
    }
}
