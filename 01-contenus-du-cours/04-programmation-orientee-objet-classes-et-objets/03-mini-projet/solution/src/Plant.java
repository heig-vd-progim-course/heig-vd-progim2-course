// Classe Plant - représente une plante dans le jardin
//
// Cette classe illustre les concepts de base de la POO :
// - Attributs pour stocker les données
// - Constructeur pour initialiser un objet
// - Méthode pour afficher les informations
//
// Note : les attributs sont publics pour cette première version.
// Dans la prochaine session, nous verrons l'encapsulation avec des attributs
// privés et des getters/setters.

public class Plant {
    // Attributs publics (pour le moment)
    public String name;
    public String species;
    public String plantingDate;
    public double size;
    public boolean isHarvested;

    // Constructeur pour initialiser tous les attributs
    public Plant(String name, String species, String plantingDate, double size) {
        this.name = name;
        this.species = species;
        this.plantingDate = plantingDate;
        this.size = size;
        this.isHarvested = false; // Par défaut, la plante n'est pas récoltée
    }

    // Méthode pour afficher les informations de la plante
    public void displayInfo() {
        System.out.println("=== Informations de la plante ===");
        System.out.println("Nom: " + name);
        System.out.println("Espèce: " + species);
        System.out.println("Date de plantation: " + plantingDate);
        System.out.println("Taille: " + size + " cm");
        System.out.println("Récoltée: " + (isHarvested ? "Oui" : "Non"));
        System.out.println();
    }

    // Méthode pour récolter la plante
    public void harvest() {
        if (isHarvested) {
            System.out.println("La plante " + name + " a déjà été récoltée.");
        } else {
            isHarvested = true;
            System.out.println("La plante " + name + " a été récoltée avec succès !");
        }
    }
}
