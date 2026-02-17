// Exemple 07 : Condition if-else
//
// Objectif pédagogique : maîtriser la structure if-else pour gérer deux
// alternatives selon une condition
//
// Concepts illustrés :
// - Structure if-else
// - Choix entre deux alternatives exclusives
// - Bloc d'instructions pour chaque branche
// - Applications pratiques du branchement
//
// Sortie attendue : voir README.md

public class Example07ConditionIfElse {
    public static void main(String[] args) {
        System.out.println("=== Structure if-else ===");
        System.out.println();
        
        // ========================================
        // Test 1 : Nombre pair ou impair
        // ========================================
        System.out.println("Test 1 : Nombre pair ou impair");
        
        int number = 42;
        System.out.println("number: " + number);
        
        // Utilisation de if-else pour gérer deux alternatives exclusives
        if (number % 2 == 0) {
            System.out.println("Le nombre est pair.");
        } else {
            System.out.println("Le nombre est impair.");
        }
        
        System.out.println();
        
        // Deuxième test avec un nombre impair
        number = 17;
        System.out.println("number: " + number);
        
        if (number % 2 == 0) {
            System.out.println("Le nombre est pair.");
        } else {
            System.out.println("Le nombre est impair.");
        }
        
        System.out.println();
        
        // ========================================
        // Test 2 : Température et message approprié
        // ========================================
        System.out.println("Test 2 : Température et message approprié");
        
        double temperature = 22.5;
        System.out.println("temperature: " + temperature);
        
        if (temperature >= 20.0) {
            System.out.println("La température est confortable.");
        } else {
            System.out.println("La température est fraîche.");
        }
        
        System.out.println();
        
        // Deuxième test avec température basse
        temperature = 15.0;
        System.out.println("temperature: " + temperature);
        
        if (temperature >= 20.0) {
            System.out.println("La température est confortable.");
        } else {
            System.out.println("La température est fraîche.");
        }
        
        System.out.println();
        
        // ========================================
        // Test 3 : Accès autorisé ou refusé
        // ========================================
        System.out.println("Test 3 : Accès autorisé ou refusé");
        
        int age = 25;
        boolean hasTicket = true;
        System.out.println("age: " + age + ", hasTicket: " + hasTicket);
        
        // La condition combine plusieurs expressions
        if (age >= 18 && hasTicket) {
            System.out.println("Accès autorisé.");
        } else {
            System.out.println("Accès refusé.");
        }
        
        System.out.println();
        
        // Deuxième test avec âge insuffisant
        age = 16;
        hasTicket = true;
        System.out.println("age: " + age + ", hasTicket: " + hasTicket);
        
        if (age >= 18 && hasTicket) {
            System.out.println("Accès autorisé.");
        } else {
            System.out.println("Accès refusé.");
        }
        
        System.out.println();
        
        // ========================================
        // Test 4 : Calcul avec conditions
        // ========================================
        System.out.println("Test 4 : Calcul avec conditions");
        
        int batteryLevel = 75;
        int brightness;
        
        System.out.println("batteryLevel: " + batteryLevel);
        
        // Chaque bloc peut contenir plusieurs instructions
        if (batteryLevel > 20) {
            System.out.println("Mode normal activé.");
            brightness = 100;
        } else {
            System.out.println("Mode économie d'énergie activé.");
            brightness = 30;
        }
        
        System.out.println("Luminosité: " + brightness + "%");
        
        System.out.println();
        
        // Deuxième test avec batterie faible
        batteryLevel = 15;
        System.out.println("batteryLevel: " + batteryLevel);
        
        if (batteryLevel > 20) {
            System.out.println("Mode normal activé.");
            brightness = 100;
        } else {
            System.out.println("Mode économie d'énergie activé.");
            brightness = 30;
        }
        
        System.out.println("Luminosité: " + brightness + "%");
    }
}
