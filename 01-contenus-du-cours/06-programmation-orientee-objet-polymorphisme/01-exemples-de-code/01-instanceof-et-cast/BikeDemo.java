/**
 * Exemple d'utilisation de instanceof et cast
 * 
 * Ce programme montre comment vérifier le type d'un objet
 * et effectuer un cast de manière sécurisée.
 */

// Classe parent abstraite
abstract class Bike {
    String brand;
    String model;
    
    Bike(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }
    
    abstract void displayInfo();
}

// Sous-classe pour vélos électriques
class ElectricBike extends Bike {
    int batteryLevel;
    
    ElectricBike(String brand, String model, int batteryLevel) {
        super(brand, model);
        this.batteryLevel = batteryLevel;
    }
    
    @Override
    void displayInfo() {
        System.out.println("Vélo électrique " + brand + " " + model);
        System.out.println("  Niveau batterie: " + batteryLevel + "%");
    }
    
    void charge() {
        batteryLevel = 100;
        System.out.println("Batterie chargée à 100%");
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
    void displayInfo() {
        System.out.println("Vélo classique " + brand + " " + model);
        System.out.println("  Nombre de vitesses: " + numberOfGears);
    }
}

// Programme principal
class BikeDemo {
    public static void main(String[] args) {
        // Création de vélos avec type parent
        Bike bike1 = new ElectricBike("VanMoof", "S3", 75);
        Bike bike2 = new HumanPoweredBike("Decathlon", "Riverside", 21);
        Bike bike3 = new ElectricBike("Stromer", "ST5", 50);
        
        // Test de instanceof
        System.out.println("=== Test de instanceof ===");
        System.out.println("bike1 est un Bike: " + (bike1 instanceof Bike));
        System.out.println("bike1 est un ElectricBike: " + (bike1 instanceof ElectricBike));
        System.out.println("bike1 est un HumanPoweredBike: " + (bike1 instanceof HumanPoweredBike));
        
        System.out.println("\nbike2 est un Bike: " + (bike2 instanceof Bike));
        System.out.println("bike2 est un ElectricBike: " + (bike2 instanceof ElectricBike));
        System.out.println("bike2 est un HumanPoweredBike: " + (bike2 instanceof HumanPoweredBike));
        
        // Gestion spécifique selon le type
        System.out.println("\n=== Gestion spécifique par type ===");
        manageBike(bike1);
        manageBike(bike2);
        manageBike(bike3);
    }
    
    /**
     * Méthode qui traite un vélo selon son type
     * Utilise instanceof et cast pour accéder aux méthodes spécifiques
     */
    static void manageBike(Bike bike) {
        // Vérification et cast pour ElectricBike
        if (bike instanceof ElectricBike) {
            // Cast sécurisé après vérification
            ElectricBike electric = (ElectricBike) bike;
            electric.displayInfo();
            
            // Accès aux membres spécifiques
            if (electric.batteryLevel < 20) {
                System.out.println("  Attention: batterie faible!");
                electric.charge();
            }
        }
        // Vérification et cast pour HumanPoweredBike
        else if (bike instanceof HumanPoweredBike) {
            HumanPoweredBike classic = (HumanPoweredBike) bike;
            classic.displayInfo();
            
            // Accès aux membres spécifiques
            if (classic.numberOfGears > 20) {
                System.out.println("  Configuration sportive");
            }
        }
        
        System.out.println();
    }
}
