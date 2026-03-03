// Classe parent avec différents modificateurs d'accès
class Vehicle {
    private String vin;              // Privé : uniquement dans Vehicle
    protected String brand;          // Protected : accessible dans les sous-classes
    public String model;             // Public : accessible partout

    public Vehicle(String vin, String brand, String model) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
    }

    protected void displayVin() {
        System.out.println("VIN: " + vin);
    }

    public void displayInfo() {
        displayVin();
        System.out.println("Marque: " + brand);
        System.out.println("Modèle: " + model);
    }
}

// Sous-classe : Car
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String vin, String brand, String model, int numberOfDoors) {
        super(vin, brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    // Peut accéder aux attributs protected du parent
    public void displayBrandUpperCase() {
        // brand est accessible car il est protected
        System.out.println("Marque (majuscules): " + brand.toUpperCase());
    }

    public void testAccess() {
        System.out.println("=== Test d'accès depuis la sous-classe ===");
        
        // OK: model est public
        System.out.println("Accès à model (public): " + model);
        
        // OK: brand est protected
        System.out.println("Accès à brand (protected): " + brand);
        
        // ERREUR: vin est private (décommentez pour voir l'erreur)
        // System.out.println("Accès à vin (private): " + vin);
        
        // OK: displayVin() est protected
        displayVin();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Nombre de portes: " + numberOfDoors);
    }
}

// Sous-classe : Motorcycle
class Motorcycle extends Vehicle {
    private String type;  // sportive, touring, etc.

    public Motorcycle(String vin, String brand, String model, String type) {
        super(vin, brand, model);
        this.type = type;
    }

    // Utilise l'attribut protected pour personnaliser l'affichage
    public void displayCustomInfo() {
        // Accès direct à brand (protected)
        System.out.println(brand + " " + model + " (" + type + ")");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("VIN123456", "Tesla", "Model 3", 4);
        Motorcycle moto = new Motorcycle("VIN789012", "Harley-Davidson", "Street 750", "Cruiser");

        System.out.println("=== Voiture ===");
        car.displayInfo();
        car.displayBrandUpperCase();  // Utilise brand (protected)
        System.out.println();

        System.out.println("=== Moto ===");
        moto.displayInfo();
        moto.displayCustomInfo();  // Utilise brand (protected)
        System.out.println();

        // Test d'accès depuis la sous-classe
        car.testAccess();
        System.out.println();

        // Depuis Main (classe externe), test des accès
        System.out.println("=== Test d'accès depuis une classe externe ===");
        
        // OK: model est public
        System.out.println("Accès à car.model (public): " + car.model);
        
        // ERREUR: brand est protected (décommentez pour voir l'erreur)
        // System.out.println("Accès à car.brand (protected): " + car.brand);
        
        // ERREUR: vin est private (décommentez pour voir l'erreur)
        // System.out.println("Accès à car.vin (private): " + car.vin);
    }
}
