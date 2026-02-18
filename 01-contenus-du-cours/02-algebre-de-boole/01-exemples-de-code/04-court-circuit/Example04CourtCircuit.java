// Exemple 04 : Court-circuit des opérateurs logiques
//
// Objectif pédagogique : comprendre le comportement court-circuit des
// opérateurs && et || et son importance
//
// Concepts illustrés :
// - Évaluation court-circuit avec AND (&&)
// - Évaluation court-circuit avec OR (||)
// - Ordre des conditions pour éviter les erreurs
// - Optimisation des performances
//
// Sortie attendue : voir README.md

public class Example04CourtCircuit {
    
    // Variables pour suivre les évaluations
    static int evaluationCount = 0;
    
    // Méthode qui simule une condition et compte les évaluations
    static boolean evaluateCondition1(boolean value) {
        System.out.println("Évaluation de la condition 1: " + value);
        evaluationCount++;
        return value;
    }
    
    static boolean evaluateCondition2(boolean value) {
        System.out.println("Évaluation de la condition 2: " + value);
        evaluationCount++;
        return value;
    }
    
    public static void main(String[] args) {
        // ========================================
        // Court-circuit avec AND (&&)
        // ========================================
        System.out.println("=== Court-circuit avec AND (&&) ===");
        System.out.println();
        
        // Test 1: Première condition false -> court-circuit
        System.out.println("Test 1: Première condition false");
        evaluationCount = 0;
        boolean result1 = evaluateCondition1(false) && evaluateCondition2(true);
        System.out.println("Résultat: " + result1);
        System.out.println("Condition 2 évaluée ? " + 
            (evaluationCount == 2 ? "OUI" : "NON (grâce au court-circuit)"));
        System.out.println();
        
        // Test 2: Première condition true -> évalue la seconde
        System.out.println("Test 2: Première condition true");
        evaluationCount = 0;
        boolean result2 = evaluateCondition1(true) && evaluateCondition2(true);
        System.out.println("Résultat: " + result2);
        System.out.println("Condition 2 évaluée ? " + 
            (evaluationCount == 2 ? "OUI" : "NON"));
        System.out.println();
        
        // ========================================
        // Court-circuit avec OR (||)
        // ========================================
        System.out.println("=== Court-circuit avec OR (||) ===");
        System.out.println();
        
        // Test 3: Première condition true -> court-circuit
        System.out.println("Test 3: Première condition true");
        evaluationCount = 0;
        boolean result3 = evaluateCondition1(true) || evaluateCondition2(false);
        System.out.println("Résultat: " + result3);
        System.out.println("Condition 2 évaluée ? " + 
            (evaluationCount == 2 ? "OUI" : "NON (grâce au court-circuit)"));
        System.out.println();
        
        // Test 4: Première condition false -> évalue la seconde
        System.out.println("Test 4: Première condition false");
        evaluationCount = 0;
        boolean result4 = evaluateCondition1(false) || evaluateCondition2(false);
        System.out.println("Résultat: " + result4);
        System.out.println("Condition 2 évaluée ? " + 
            (evaluationCount == 2 ? "OUI" : "NON"));
        System.out.println();
        
        // ========================================
        // Application pratique: Éviter NullPointerException
        // ========================================
        System.out.println("=== Application pratique: Éviter NullPointerException ===");
        System.out.println();
        
        // Test avec null
        System.out.println("Test avec null:");
        String text = null;
        boolean isValid = checkTextIsValid(text);
        System.out.println("Est valide ? " + isValid);
        System.out.println();
        
        // Test avec texte vide
        System.out.println("Test avec texte vide:");
        text = "";
        isValid = checkTextIsValid(text);
        System.out.println("Est valide ? " + isValid);
        System.out.println();
        
        // Test avec texte valide
        System.out.println("Test avec texte valide:");
        text = "Bonjour";
        isValid = checkTextIsValid(text);
        System.out.println("Est valide ? " + isValid);
    }
    
    // Méthode qui vérifie un texte en utilisant le court-circuit
    static boolean checkTextIsValid(String text) {
        // IMPORTANT: L'ordre est crucial !
        // On vérifie d'abord si text n'est pas null
        // Si text est null, la deuxième condition (text.length() > 0)
        // ne sera jamais évaluée grâce au court-circuit
        
        // Utilisation du court-circuit avec &&
        // Si text est null, text.length() ne sera JAMAIS appelé
        System.out.println("Vérification: text != null ? " + (text != null));
        
        if (text != null && text.length() > 0) {
            // Si on arrive ici, les deux conditions sont vraies
            System.out.println("text est valide");
            return true;
        } else {
            System.out.println("text est invalide (null ou vide)");
            return false;
        }
    }
    
}
