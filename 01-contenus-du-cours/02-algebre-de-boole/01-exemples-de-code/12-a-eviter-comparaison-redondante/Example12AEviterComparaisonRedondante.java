// Exemple 12 : À éviter - Comparaison redondante
//
// Objectif pédagogique : comprendre pourquoi comparer un booléen à true ou
// false est redondant et nuit à la lisibilité
//
// Concepts illustrés :
// - Redondance de if (isReady == true)
// - Redondance de return isReady == true;
// - Utilisation directe des booléens
// - Amélioration de la lisibilité du code

public class Example12AEviterComparaisonRedondante {
    public static void main(String[] args) {
        System.out.println("=== À éviter : Comparaison redondante ===");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 1 : Comparaison redondante dans if
        // ========================================
        
        System.out.println("Problème 1: Comparaison redondante dans une condition");
        System.out.println();
        
        boolean isReady = true;
        
        // ❌ MAUVAIS CODE : Comparaison redondante
        System.out.println("❌ Code redondant:");
        System.out.println("if (isReady == true) {");
        System.out.println("    System.out.println(\"Système prêt\");");
        System.out.println("}");
        System.out.println();
        
        if (isReady == true) {  // Redondant !
            System.out.println("Résultat: Système prêt");
        }
        
        System.out.println();
        
        // ✓ BON CODE : Utilisation directe
        System.out.println("✓ Code simplifié:");
        System.out.println("if (isReady) {");
        System.out.println("    System.out.println(\"Système prêt\");");
        System.out.println("}");
        System.out.println();
        
        if (isReady) {  // Clair et concis
            System.out.println("Résultat: Système prêt");
        }
        
        System.out.println();
        System.out.println("Raison: isReady est déjà un booléen, pas besoin de le comparer");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 2 : Comparaison avec false
        // ========================================
        
        System.out.println("Problème 2: Comparaison redondante avec false");
        System.out.println();
        
        boolean hasError = false;
        
        // ❌ MAUVAIS CODE
        System.out.println("❌ Code redondant:");
        System.out.println("if (hasError == false) {");
        System.out.println("    System.out.println(\"Pas d'erreur\");");
        System.out.println("}");
        System.out.println();
        
        if (hasError == false) {  // Redondant !
            System.out.println("Résultat: Pas d'erreur");
        }
        
        System.out.println();
        
        // ✓ BON CODE
        System.out.println("✓ Code simplifié:");
        System.out.println("if (!hasError) {");
        System.out.println("    System.out.println(\"Pas d'erreur\");");
        System.out.println("}");
        System.out.println();
        
        if (!hasError) {  // Clair avec négation
            System.out.println("Résultat: Pas d'erreur");
        }
        
        System.out.println();
        System.out.println("Raison: Utilisez ! pour la négation au lieu de == false");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 3 : Comparaison dans return
        // ========================================
        
        System.out.println("Problème 3: Comparaison redondante dans return");
        System.out.println();
        
        boolean isConnected = true;
        boolean hasData = true;
        
        // ❌ MAUVAIS CODE
        System.out.println("❌ Code redondant:");
        System.out.println("return (isConnected && hasData) == true;");
        System.out.println();
        
        boolean result1 = (isConnected && hasData) == true;  // Redondant !
        System.out.println("Résultat: " + result1);
        System.out.println();
        
        // ✓ BON CODE
        System.out.println("✓ Code simplifié:");
        System.out.println("return (isConnected && hasData);");
        System.out.println();
        
        boolean result2 = (isConnected && hasData);  // Direct
        System.out.println("Résultat: " + result2);
        System.out.println();
        
        System.out.println("Raison: L'expression booléenne peut être retournée directement");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 4 : Return avec comparaison
        // ========================================
        
        System.out.println("Problème 4: Return d'un booléen avec comparaison redondante");
        System.out.println();
        
        System.out.println("❌ Code redondant:");
        System.out.println("boolean canAccess = checkAccess();");
        System.out.println("return canAccess == true;");
        System.out.println();
        
        boolean canAccess = checkAccessBad();
        System.out.println("Résultat de checkAccessBad(): " + canAccess);
        System.out.println();
        
        System.out.println("✓ Code simplifié:");
        System.out.println("boolean canAccess = checkAccess();");
        System.out.println("return canAccess;");
        System.out.println();
        
        canAccess = checkAccessGood();
        System.out.println("Résultat de checkAccessGood(): " + canAccess);
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 5 : Pire cas - Double négation
        // ========================================
        
        System.out.println("Problème 5: Double négation (pire cas)");
        System.out.println();
        
        boolean isInvalid = false;
        
        System.out.println("❌ Code très confus:");
        System.out.println("if (isInvalid != false) {  // Double négation !");
        System.out.println("    System.out.println(\"Non valide\");");
        System.out.println("}");
        System.out.println();
        
        if (isInvalid != false) {  // Très confus !
            System.out.println("Résultat: Non valide");
        } else {
            System.out.println("Résultat: Valide (la condition est false)");
        }
        
        System.out.println();
        
        System.out.println("✓ Code clair:");
        System.out.println("if (isInvalid) {");
        System.out.println("    System.out.println(\"Non valide\");");
        System.out.println("}");
        System.out.println();
        
        if (isInvalid) {
            System.out.println("Résultat: Non valide");
        } else {
            System.out.println("Résultat: Valide (la condition est false)");
        }
        
        System.out.println();
        
        // ========================================
        // Résumé
        // ========================================
        
        System.out.println("=== Résumé des bonnes pratiques ===");
        System.out.println("→ Utilisez if (condition) au lieu de if (condition == true)");
        System.out.println("→ Utilisez if (!condition) au lieu de if (condition == false)");
        System.out.println("→ Retournez directement les booléens sans comparaison");
        System.out.println("→ Évitez les doubles négations");
    }
    
    // ❌ Méthode avec comparaison redondante
    private static boolean checkAccessBad() {
        boolean isReady = true;
        return isReady == true;  // Redondant !
    }
    
    // ✓ Méthode correcte
    private static boolean checkAccessGood() {
        boolean isReady = true;
        return isReady;  // Direct et clair
    }
}
