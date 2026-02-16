// Exemple 15 : À éviter - Ordre court-circuit incorrect
//
// Objectif pédagogique : comprendre l'importance de l'ordre des conditions
// avec les opérateurs court-circuit (&& et ||)
//
// Concepts illustrés :
// - Risque de NullPointerException avec ordre incorrect
// - Ordre optimal pour l'évaluation court-circuit
// - Protection contre les erreurs d'exécution
// - Performance et sécurité du code

public class Example15AEviterOrdreCourtCircuit {
    public static void main(String[] args) {
        System.out.println("=== À éviter : Ordre court-circuit incorrect ===");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 1 : Vérification null dans le mauvais ordre
        // ========================================
        
        System.out.println("Problème 1: Vérification null après utilisation");
        System.out.println();
        
        String text = null;
        
        System.out.println("❌ Code dangereux (commenté pour éviter le crash):");
        System.out.println("String text = null;");
        System.out.println("if (text.length() > 0 && text != null) {");
        System.out.println("    // NullPointerException !");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté)
        /*
        if (text.length() > 0 && text != null) {
            // CRASH : NullPointerException sur text.length()
            System.out.println("Texte valide");
        }
        */
        
        System.out.println("Erreur: text.length() est évalué AVANT text != null");
        System.out.println("Résultat: NullPointerException car text est null");
        System.out.println();
        
        System.out.println("✓ Code correct:");
        System.out.println("if (text != null && text.length() > 0) {");
        System.out.println("    System.out.println(\"Texte valide\");");
        System.out.println("}");
        System.out.println();
        
        // ✓ BON CODE
        if (text != null && text.length() > 0) {
            System.out.println("Résultat: Texte valide");
        } else {
            System.out.println("Résultat: Texte null ou vide (pas de crash !)");
        }
        
        System.out.println();
        System.out.println("Raison: text != null est évalué EN PREMIER");
        System.out.println("Si c'est false, text.length() n'est JAMAIS évalué (court-circuit)");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 2 : Division par zéro
        // ========================================
        
        System.out.println("Problème 2: Division par zéro non protégée");
        System.out.println();
        
        int divisor = 0;
        int value = 100;
        
        System.out.println("❌ Code dangereux (commenté pour éviter le crash):");
        System.out.println("int divisor = 0;");
        System.out.println("int value = 100;");
        System.out.println("if (value / divisor > 5 && divisor != 0) {");
        System.out.println("    // ArithmeticException !");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté)
        /*
        if (value / divisor > 5 && divisor != 0) {
            // CRASH : division par zéro
            System.out.println("Résultat élevé");
        }
        */
        
        System.out.println("Erreur: value / divisor est évalué AVANT divisor != 0");
        System.out.println("Résultat: ArithmeticException (division par zéro)");
        System.out.println();
        
        System.out.println("✓ Code correct:");
        System.out.println("if (divisor != 0 && value / divisor > 5) {");
        System.out.println("    System.out.println(\"Résultat élevé\");");
        System.out.println("}");
        System.out.println();
        
        // ✓ BON CODE
        if (divisor != 0 && value / divisor > 5) {
            System.out.println("Résultat: Résultat élevé");
        } else {
            System.out.println("Résultat: Diviseur nul ou résultat faible (pas de crash !)");
        }
        
        System.out.println();
        System.out.println("Raison: divisor != 0 protège contre la division par zéro");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 3 : Ordre peu performant
        // ========================================
        
        System.out.println("Problème 3: Condition coûteuse évaluée inutilement");
        System.out.println();
        
        String[] database = {"Alice", "Bob", "Charlie"};
        String searchName = "David";
        
        System.out.println("❌ Code peu performant:");
        System.out.println("if (searchInDatabase(name) || name.length() > 3) {");
        System.out.println("    // searchInDatabase est appelé même si length > 3");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE (fonctionnel mais inefficace)
        System.out.println("Évaluation avec ordre inefficace:");
        System.out.print("Recherche dans la base... ");
        boolean found1 = searchInDatabase(database, searchName);
        System.out.println("(opération coûteuse)");
        boolean result1 = found1 || searchName.length() > 3;
        System.out.println("Résultat: " + result1);
        System.out.println("Problème: Recherche effectuée même si length > 3 suffirait");
        System.out.println();
        
        System.out.println("✓ Code optimisé:");
        System.out.println("if (name.length() > 3 || searchInDatabase(name)) {");
        System.out.println("    // Test rapide en premier");
        System.out.println("}");
        System.out.println();
        
        // ✓ BON CODE
        System.out.println("Évaluation avec ordre optimisé:");
        if (searchName.length() > 3) {
            System.out.println("Nom assez long (pas besoin de chercher)");
        } else {
            System.out.print("Nom court, recherche dans la base... ");
            boolean found2 = searchInDatabase(database, searchName);
            System.out.println();
            System.out.println("Résultat recherche: " + found2);
        }
        System.out.println("Avantage: Recherche évitée car length > 3 est déjà true");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 4 : Appel de méthode avec effet de bord
        // ========================================
        
        System.out.println("Problème 4: Méthode avec effet de bord non contrôlée");
        System.out.println();
        
        int[] counter = {0};
        boolean condition = false;
        
        System.out.println("❌ Code avec ordre incorrect:");
        System.out.println("if (incrementAndCheck(counter) && condition) {");
        System.out.println("    // incrementAndCheck est TOUJOURS appelé");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE
        System.out.println("Compteur avant: " + counter[0]);
        if (incrementAndCheck(counter) && condition) {
            System.out.println("Les deux conditions sont vraies");
        } else {
            System.out.println("Au moins une condition est fausse");
        }
        System.out.println("Compteur après: " + counter[0] + " (incrémenté inutilement)");
        System.out.println();
        
        // Réinitialisation
        counter[0] = 0;
        
        System.out.println("✓ Code avec ordre correct:");
        System.out.println("if (condition && incrementAndCheck(counter)) {");
        System.out.println("    // incrementAndCheck n'est appelé que si condition est true");
        System.out.println("}");
        System.out.println();
        
        // ✓ BON CODE
        System.out.println("Compteur avant: " + counter[0]);
        if (condition && incrementAndCheck(counter)) {
            System.out.println("Les deux conditions sont vraies");
        } else {
            System.out.println("Au moins une condition est fausse");
        }
        System.out.println("Compteur après: " + counter[0] + 
                           " (pas incrémenté car condition est false)");
        System.out.println();
        
        System.out.println("Raison: condition est false, donc incrementAndCheck n'est pas appelé");
        System.out.println();
        
        // ========================================
        // Résumé
        // ========================================
        
        System.out.println("=== Résumé ===");
        System.out.println("Avec && (AND) :");
        System.out.println("→ Vérifications de sécurité (null, limites) EN PREMIER");
        System.out.println("→ Tests rapides AVANT les tests coûteux");
        System.out.println();
        System.out.println("Avec || (OR) :");
        System.out.println("→ Conditions les plus probables EN PREMIER");
        System.out.println("→ Tests rapides AVANT les tests coûteux");
        System.out.println();
        System.out.println("Toujours penser : sécurité + performance");
    }
    
    // Méthode coûteuse pour la démonstration
    private static boolean searchInDatabase(String[] database, String name) {
        // Simulation d'une recherche coûteuse
        for (String entry : database) {
            if (entry.equals(name)) {
                return true;
            }
        }
        return false;
    }
    
    // Méthode avec effet de bord
    private static boolean incrementAndCheck(int[] counter) {
        counter[0]++;
        return counter[0] > 0;
    }
}
