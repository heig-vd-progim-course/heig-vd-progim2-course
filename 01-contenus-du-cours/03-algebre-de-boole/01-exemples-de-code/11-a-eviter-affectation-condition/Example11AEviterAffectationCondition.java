// Exemple 11 : À éviter - Affectation dans une condition
//
// Objectif pédagogique : comprendre pourquoi l'affectation (=) dans une
// condition est une erreur courante et dangereuse
//
// Concepts illustrés :
// - Confusion entre affectation (=) et comparaison (==)
// - Impact d'une affectation dans une condition
// - Erreur de compilation en Java
// - Bonne pratique : utiliser == pour les comparaisons

public class Example11AEviterAffectationCondition {
    public static void main(String[] args) {
        System.out.println("=== À éviter : Affectation dans une condition ===");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR : Affectation au lieu de comparaison
        // ========================================
        
        boolean isReady = false;
        
        System.out.println("Valeur initiale de isReady: " + isReady);
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté pour éviter l'erreur de compilation)
        // Cette ligne AFFECTE la valeur true à isReady au lieu de la COMPARER
        /*
        if (isReady = true) {
            System.out.println("Système prêt !");
        }
        */
        
        System.out.println("❌ Code incorrect (commenté):");
        System.out.println("if (isReady = true) {");
        System.out.println("    System.out.println(\"Système prêt !\");");
        System.out.println("}");
        System.out.println();
        
        System.out.println("Problème:");
        System.out.println("- L'opérateur = est une AFFECTATION");
        System.out.println("- Il modifie la variable isReady en lui donnant la valeur true");
        System.out.println("- La condition devient TOUJOURS vraie");
        System.out.println("- Le bloc if s'exécute même si isReady était false au départ");
        System.out.println();
        
        // ========================================
        // ✓ CORRECTION : Utilisation correcte
        // ========================================
        
        System.out.println("✓ Code correct:");
        System.out.println();
        
        // Réinitialisation
        isReady = false;
        System.out.println("Valeur de isReady: " + isReady);
        
        // Solution 1: Utilisation directe de la variable booléenne (MEILLEUR)
        System.out.println("\nSolution 1 (recommandée) - Utilisation directe:");
        System.out.println("if (isReady) {");
        System.out.println("    System.out.println(\"Système prêt !\");");
        System.out.println("}");
        
        if (isReady) {
            System.out.println("Système prêt !");
        } else {
            System.out.println("Résultat: Le bloc ne s'exécute pas (correct)");
        }
        
        System.out.println();
        
        // Solution 2: Comparaison explicite avec == (acceptable mais redondant)
        System.out.println("Solution 2 (acceptable mais redondante) - Comparaison explicite:");
        System.out.println("if (isReady == true) {");
        System.out.println("    System.out.println(\"Système prêt !\");");
        System.out.println("}");
        
        if (isReady == true) {
            System.out.println("Système prêt !");
        } else {
            System.out.println("Résultat: Le bloc ne s'exécute pas (correct)");
        }
        
        System.out.println();
        
        // ========================================
        // Démonstration de l'erreur avec un nombre
        // ========================================
        
        System.out.println("=== Autre exemple avec un nombre ===");
        System.out.println();
        
        int count = 5;
        System.out.println("Valeur initiale de count: " + count);
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté)
        /*
        if (count = 10) {  // ERREUR : affectation au lieu de comparaison
            System.out.println("Count est 10");
        }
        */
        
        System.out.println("❌ Code incorrect (commenté):");
        System.out.println("if (count = 10) {  // Erreur de compilation en Java!");
        System.out.println("    System.out.println(\"Count est 10\");");
        System.out.println("}");
        System.out.println();
        
        System.out.println("Note: En Java, cette erreur produit une erreur de compilation");
        System.out.println("car le résultat de l'affectation (10) n'est pas un booléen.");
        System.out.println();
        
        // ✓ CODE CORRECT
        System.out.println("✓ Code correct:");
        System.out.println("if (count == 10) {  // Comparaison correcte");
        System.out.println("    System.out.println(\"Count est 10\");");
        System.out.println("}");
        
        if (count == 10) {
            System.out.println("Count est 10");
        } else {
            System.out.println("Résultat: Count n'est pas 10 (correct)");
        }
        
        System.out.println();
        System.out.println("=== Résumé ===");
        System.out.println("→ Utilisez == pour comparer");
        System.out.println("→ Utilisez = pour affecter");
        System.out.println("→ Pour les booléens, préférez l'utilisation directe");
    }
}
