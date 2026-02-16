// Exemple 08 : Condition complexe
//
// Objectif pédagogique : maîtriser la structure if-else if-else pour gérer
// plusieurs alternatives selon différentes conditions
//
// Concepts illustrés :
// - Structure if-else if-else
// - Cascade de conditions mutuellement exclusives
// - Combinaison de plusieurs opérateurs booléens
// - Utilisation de parenthèses pour la clarté
//
// Sortie attendue : voir README.md

public class Example08ConditionComplexe {
    public static void main(String[] args) {
        System.out.println("=== Structure if-else if-else ===");
        System.out.println();
        
        // ========================================
        // Test 1 : Classification de note
        // ========================================
        System.out.println("Test 1 : Classification de note");
        
        int score = 92;
        System.out.println("score: " + score);
        
        // Structure if-else if-else pour gérer plusieurs alternatives
        // Les conditions sont testées dans l'ordre
        if (score >= 90) {
            System.out.println("Mention: Excellent");
        } else if (score >= 70) {
            System.out.println("Mention: Bien");
        } else if (score >= 50) {
            System.out.println("Mention: Passable");
        } else {
            System.out.println("Mention: Insuffisant");
        }
        
        System.out.println();
        
        // Tests avec différents scores
        score = 75;
        System.out.println("score: " + score);
        if (score >= 90) {
            System.out.println("Mention: Excellent");
        } else if (score >= 70) {
            System.out.println("Mention: Bien");
        } else if (score >= 50) {
            System.out.println("Mention: Passable");
        } else {
            System.out.println("Mention: Insuffisant");
        }
        
        System.out.println();
        
        score = 55;
        System.out.println("score: " + score);
        if (score >= 90) {
            System.out.println("Mention: Excellent");
        } else if (score >= 70) {
            System.out.println("Mention: Bien");
        } else if (score >= 50) {
            System.out.println("Mention: Passable");
        } else {
            System.out.println("Mention: Insuffisant");
        }
        
        System.out.println();
        
        score = 42;
        System.out.println("score: " + score);
        if (score >= 90) {
            System.out.println("Mention: Excellent");
        } else if (score >= 70) {
            System.out.println("Mention: Bien");
        } else if (score >= 50) {
            System.out.println("Mention: Passable");
        } else {
            System.out.println("Mention: Insuffisant");
        }
        
        System.out.println();
        
        // ========================================
        // Test 2 : Calcul de tarif avec conditions complexes
        // ========================================
        System.out.println("Test 2 : Calcul de tarif avec conditions complexes");
        
        // Cas 1: Enfant
        int age = 5;
        boolean isStudent = false;
        boolean hasCard = false;
        int price;
        
        System.out.println("age: " + age + ", isStudent: " + isStudent + 
                           ", hasCard: " + hasCard);
        
        // Conditions complexes avec opérateurs logiques et parenthèses
        if (age < 6) {
            System.out.println("Catégorie: Enfant");
            price = 0;
        } else if ((age >= 18 && age < 26) && isStudent) {
            System.out.println("Catégorie: Étudiant");
            price = 10;
        } else if (age >= 65) {
            System.out.println("Catégorie: Senior");
            price = 8;
        } else if (hasCard) {
            System.out.println("Catégorie: Membre avec carte");
            price = 12;
        } else {
            System.out.println("Catégorie: Adulte");
            price = 15;
        }
        
        System.out.println("Tarif: " + price + " CHF");
        System.out.println();
        
        // Cas 2: Étudiant
        age = 20;
        isStudent = true;
        hasCard = false;
        System.out.println("age: " + age + ", isStudent: " + isStudent + 
                           ", hasCard: " + hasCard);
        
        if (age < 6) {
            System.out.println("Catégorie: Enfant");
            price = 0;
        } else if ((age >= 18 && age < 26) && isStudent) {
            System.out.println("Catégorie: Étudiant");
            price = 10;
        } else if (age >= 65) {
            System.out.println("Catégorie: Senior");
            price = 8;
        } else if (hasCard) {
            System.out.println("Catégorie: Membre avec carte");
            price = 12;
        } else {
            System.out.println("Catégorie: Adulte");
            price = 15;
        }
        
        System.out.println("Tarif: " + price + " CHF");
        System.out.println();
        
        // Cas 3: Senior
        age = 70;
        isStudent = false;
        hasCard = false;
        System.out.println("age: " + age + ", isStudent: " + isStudent + 
                           ", hasCard: " + hasCard);
        
        if (age < 6) {
            System.out.println("Catégorie: Enfant");
            price = 0;
        } else if ((age >= 18 && age < 26) && isStudent) {
            System.out.println("Catégorie: Étudiant");
            price = 10;
        } else if (age >= 65) {
            System.out.println("Catégorie: Senior");
            price = 8;
        } else if (hasCard) {
            System.out.println("Catégorie: Membre avec carte");
            price = 12;
        } else {
            System.out.println("Catégorie: Adulte");
            price = 15;
        }
        
        System.out.println("Tarif: " + price + " CHF");
        System.out.println();
        
        // Cas 4: Membre avec carte
        age = 35;
        isStudent = false;
        hasCard = true;
        System.out.println("age: " + age + ", isStudent: " + isStudent + 
                           ", hasCard: " + hasCard);
        
        if (age < 6) {
            System.out.println("Catégorie: Enfant");
            price = 0;
        } else if ((age >= 18 && age < 26) && isStudent) {
            System.out.println("Catégorie: Étudiant");
            price = 10;
        } else if (age >= 65) {
            System.out.println("Catégorie: Senior");
            price = 8;
        } else if (hasCard) {
            System.out.println("Catégorie: Membre avec carte");
            price = 12;
        } else {
            System.out.println("Catégorie: Adulte");
            price = 15;
        }
        
        System.out.println("Tarif: " + price + " CHF");
        System.out.println();
        
        // Cas 5: Adulte standard
        age = 30;
        isStudent = false;
        hasCard = false;
        System.out.println("age: " + age + ", isStudent: " + isStudent + 
                           ", hasCard: " + hasCard);
        
        if (age < 6) {
            System.out.println("Catégorie: Enfant");
            price = 0;
        } else if ((age >= 18 && age < 26) && isStudent) {
            System.out.println("Catégorie: Étudiant");
            price = 10;
        } else if (age >= 65) {
            System.out.println("Catégorie: Senior");
            price = 8;
        } else if (hasCard) {
            System.out.println("Catégorie: Membre avec carte");
            price = 12;
        } else {
            System.out.println("Catégorie: Adulte");
            price = 15;
        }
        
        System.out.println("Tarif: " + price + " CHF");
        System.out.println();
        
        // ========================================
        // Test 3 : Validation de données avec expressions complexes
        // ========================================
        System.out.println("Test 3 : Validation de données avec expressions complexes");
        
        double temperature = 22.0;
        int humidity = 55;
        boolean hasVentilation = true;
        
        System.out.println("temperature: " + temperature + 
                           ", humidity: " + humidity + 
                           ", hasVentilation: " + hasVentilation);
        
        // Expressions complexes avec plusieurs opérateurs et parenthèses
        if ((temperature >= 18.0 && temperature <= 25.0) && 
            (humidity >= 40 && humidity <= 60) && 
            hasVentilation) {
            System.out.println("Conditions de stockage: Optimales");
        } else if ((temperature >= 15.0 && temperature <= 28.0) && 
                   (humidity >= 30 && humidity <= 70)) {
            System.out.println("Conditions de stockage: Acceptables");
        } else {
            System.out.println("Conditions de stockage: Non conformes");
        }
        
        System.out.println();
        
        // Test avec conditions acceptables
        temperature = 18.0;
        humidity = 65;
        hasVentilation = true;
        
        System.out.println("temperature: " + temperature + 
                           ", humidity: " + humidity + 
                           ", hasVentilation: " + hasVentilation);
        
        if ((temperature >= 18.0 && temperature <= 25.0) && 
            (humidity >= 40 && humidity <= 60) && 
            hasVentilation) {
            System.out.println("Conditions de stockage: Optimales");
        } else if ((temperature >= 15.0 && temperature <= 28.0) && 
                   (humidity >= 30 && humidity <= 70)) {
            System.out.println("Conditions de stockage: Acceptables");
        } else {
            System.out.println("Conditions de stockage: Non conformes");
        }
        
        System.out.println();
        
        // Test avec conditions non conformes
        temperature = 28.0;
        humidity = 80;
        hasVentilation = false;
        
        System.out.println("temperature: " + temperature + 
                           ", humidity: " + humidity + 
                           ", hasVentilation: " + hasVentilation);
        
        if ((temperature >= 18.0 && temperature <= 25.0) && 
            (humidity >= 40 && humidity <= 60) && 
            hasVentilation) {
            System.out.println("Conditions de stockage: Optimales");
        } else if ((temperature >= 15.0 && temperature <= 28.0) && 
                   (humidity >= 30 && humidity <= 70)) {
            System.out.println("Conditions de stockage: Acceptables");
        } else {
            System.out.println("Conditions de stockage: Non conformes");
        }
    }
}
