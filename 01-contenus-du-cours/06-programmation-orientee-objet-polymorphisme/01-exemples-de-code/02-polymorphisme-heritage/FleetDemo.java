import java.util.ArrayList;

/**
 * Exemple de polymorphisme d'héritage
 * 
 * Ce programme montre comment traiter différents objets de manière
 * uniforme grâce au polymorphisme, sans utiliser instanceof.
 */

// Classe parent abstraite
abstract class Bike {
    String brand;
    String model;
    
    Bike(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    // Méthode abstraite que chaque sous-classe doit implémenter
    abstract void repair();
    
    // Méthode concrète partagée
    void displayAvailability() {
        System.out.println("Vélo disponible : " + brand + " " + model);
    }
    
    @Override
    public String toString() {
        return "Bike{brand='" + brand + "', model='" + model + "'}";
    }
}

// Sous-classe pour vélos classiques
class HumanPoweredBike extends Bike {
    int numberOfGears;
    
    HumanPoweredBike(String brand, String model, int numberOfGears) {
        super(brand, model);
        this.numberOfGears = numberOfGears;
    }
    
    @Override
    void repair() {
        System.out.println("Réparation vélo classique : ajustement des freins et vitesses");
    }
}

// Sous-classe pour vélos électriques
class ElectricBike extends Bike {
    int batteryLevel;
    
    ElectricBike(String brand, String model, int batteryLevel) {
        super(brand, model);
        this.batteryLevel = batteryLevel;
    }
    
    @Override
    void repair() {
        System.out.println("Réparation vélo électrique : vérification batterie et moteur");
    }
}

// Programme principal
class FleetDemo {
    public static void main(String[] args) {
        // Collection polymorphe : stocke différents types de vélos
        ArrayList<Bike> fleet = new ArrayList<>();
        fleet.add(new HumanPoweredBike("Decathlon", "Riverside", 21));
        fleet.add(new ElectricBike("VanMoof", "S3", 75));
        fleet.add(new ElectricBike("Stromer", "ST5", 50));
        
        // Réparation de tous les vélos
        // Polymorphisme : chaque vélo utilise SA méthode repair()
        System.out.println("=== Réparation de tous les vélos ===");
        repairAllBikes(fleet);
        
        // Affichage avec toString()
        System.out.println("\n=== Informations de la flotte ===");
        for (Bike bike : fleet) {
            System.out.println(bike);  // Appelle automatiquement toString()
        }
        
        // Traitement uniforme
        System.out.println("\n=== Traitement uniforme ===");
        for (Bike bike : fleet) {
            bike.displayAvailability();  // Même méthode pour tous
        }
        
        System.out.println("\nTotal de vélos : " + fleet.size());
    }
    
    /**
     * Répare tous les vélos de la flotte
     * Grâce au polymorphisme, pas besoin de instanceof !
     */
    static void repairAllBikes(ArrayList<Bike> bikes) {
        for (Bike bike : bikes) {
            // La bonne méthode repair() est appelée automatiquement
            // selon le type réel de l'objet (liaison dynamique)
            bike.repair();
        }
    }
    
    /**
     * Exemple d'une nouvelle méthode qui fonctionne pour TOUS les types
     * Sans modification même si on ajoute de nouveaux types !
     */
    static int countBikes(ArrayList<Bike> bikes) {
        return bikes.size();
    }
}
