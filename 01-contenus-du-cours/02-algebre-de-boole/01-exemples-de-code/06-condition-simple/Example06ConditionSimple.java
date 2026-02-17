// Exemple 06 : Condition simple
//
// Objectif pédagogique : maîtriser la structure if simple pour exécuter du
// code conditionnellement
//
// Concepts illustrés :
// - Structure if simple
// - Expression booléenne comme condition
// - Bloc d'instructions conditionnel
// - Comparaisons et expressions booléennes
//
// Sortie attendue : voir README.md

public class Example06ConditionSimple {
    public static void main(String[] args) {
        System.out.println("=== Structure if simple ===");
        System.out.println();
        
        // ========================================
        // Test 1 : Vérification d'une variable booléenne
        // ========================================
        System.out.println("Test 1 : Vérification d'une variable booléenne");
        
        boolean isConnected = true;
        System.out.println("isConnected: " + isConnected);
        
        // Structure if simple : exécute le bloc uniquement si la condition
        // est vraie
        if (isConnected) {
            System.out.println("La connexion est établie.");
        }
        
        System.out.println();
        
        // ========================================
        // Test 2 : Utilisation d'une comparaison
        // ========================================
        System.out.println("Test 2 : Utilisation d'une comparaison");
        
        int score = 85;
        System.out.println("score: " + score);
        
        // La condition est une expression de comparaison
        if (score >= 60) {
            System.out.println("Le score est suffisant.");
        }
        
        // Deuxième test avec un score différent
        score = 40;
        System.out.println("score: " + score);
        
        // Cette fois, la condition est fausse, le bloc n'est pas exécuté
        if (score >= 60) {
            System.out.println("Le score est suffisant.");
        }
        
        System.out.println();
        
        // ========================================
        // Test 3 : Utilisation d'une expression booléenne complexe
        // ========================================
        System.out.println("Test 3 : Utilisation d'une expression booléenne complexe");
        
        int age = 25;
        boolean hasLicense = true;
        System.out.println("age: " + age + ", hasLicense: " + hasLicense);
        
        // La condition combine plusieurs expressions avec l'opérateur AND
        if (age >= 18 && hasLicense) {
            System.out.println("Vous pouvez conduire le véhicule.");
        }
        
        System.out.println();
        
        // ========================================
        // Test 4 : Sans message si la condition est fausse
        // ========================================
        System.out.println("Test 4 : Sans message si la condition est fausse");
        
        double balance = 50.0;
        double purchaseAmount = 75.0;
        System.out.println("balance: " + balance + 
                           ", purchaseAmount: " + purchaseAmount);
        
        // Si la condition est fausse, rien ne se passe
        if (balance >= purchaseAmount) {
            System.out.println("Achat effectué.");
            balance = balance - purchaseAmount;
            System.out.println("Nouveau solde: " + balance);
        }
        
        // Le programme continue normalement
        System.out.println("Fin du programme (achat non effectué).");
    }
}
