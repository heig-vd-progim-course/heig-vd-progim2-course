/**
 * Exemple d'interface simple
 * 
 * Ce programme montre comment définir et implémenter une interface
 * pour créer des contrats de comportement.
 */

// Interface définissant le contrat pour les objets électriques
interface Electric {
    // Méthodes abstraites (pas d'implémentation)
    int getBatteryLevel();
    void charge();
}

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

// Vélo électrique : hérite de Bike ET implémente Electric
class ElectricBike extends Bike implements Electric {
    int batteryLevel;
    
    ElectricBike(String brand, String model, int batteryLevel) {
        super(brand, model);
        this.batteryLevel = batteryLevel;
    }
    
    @Override
    void displayInfo() {
        System.out.println("Vélo électrique " + brand + " " + model);
    }
    
    // Implémentation des méthodes de l'interface Electric
    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }
    
    @Override
    public void charge() {
        System.out.println("  Charge en cours...");
        batteryLevel = 100;
        System.out.println("  Batterie chargée à 100%");
    }
}

// Vélo classique : hérite de Bike mais N'implémente PAS Electric
class HumanPoweredBike extends Bike {
    int numberOfGears;
    
    HumanPoweredBike(String brand, String model, int numberOfGears) {
        super(brand, model);
        this.numberOfGears = numberOfGears;
    }
    
    @Override
    void displayInfo() {
        System.out.println("Vélo classique " + brand + " " + model);
    }
}

// Programme principal
class InterfaceDemo {
    public static void main(String[] args) {
        // Création de vélos
        ElectricBike bike1 = new ElectricBike("VanMoof", "S3", 75);
        ElectricBike bike2 = new ElectricBike("Stromer", "ST5", 15);
        HumanPoweredBike bike3 = new HumanPoweredBike("Decathlon", "Riverside", 21);
        
        // Collection d'objets électriques (polymorphisme d'interface)
        Electric[] electricDevices = new Electric[2];
        electricDevices[0] = bike1;
        electricDevices[1] = bike2;
        // electricDevices[2] = bike3;  // ERREUR : HumanPoweredBike n'est pas Electric
        
        // Vérification des batteries
        System.out.println("=== Vérification des batteries ===");
        checkBatteries(electricDevices);
        
        // Statistiques
        System.out.println("\n=== Statistiques ===");
        System.out.println("Nombre d'appareils électriques : " + electricDevices.length);
    }
    
    /**
     * Vérifie et charge les batteries si nécessaire
     * Fonctionne avec TOUT objet implémentant Electric
     */
    static void checkBatteries(Electric[] devices) {
        for (Electric device : devices) {
            // Affichage (cast pour accéder aux attributs Bike)
            if (device instanceof ElectricBike) {
                ElectricBike bike = (ElectricBike) device;
                System.out.println(bike.brand + " " + bike.model + 
                                 " - Batterie: " + device.getBatteryLevel() + "%");
            }
            
            // Traitement uniforme via l'interface
            if (device.getBatteryLevel() < 20) {
                System.out.println("  Attention: batterie faible!");
                device.charge();
            } else {
                System.out.println("  Batterie OK");
            }
        }
    }
}
