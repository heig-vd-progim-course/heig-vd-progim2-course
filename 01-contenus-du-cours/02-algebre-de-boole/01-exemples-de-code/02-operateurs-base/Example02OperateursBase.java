// Exemple 02 : Opérateurs logiques de base (NOT, AND, OR)
//
// Objectif pédagogique : comprendre et utiliser les trois opérateurs logiques
// fondamentaux
//
// Concepts illustrés :
// - Opérateur NOT (!) - négation
// - Opérateur AND (&&) - conjonction
// - Opérateur OR (||) - disjonction
// - Tables de vérité
//
// Sortie attendue : voir README.md

public class Example02OperateursBase {
    public static void main(String[] args) {
        // ========================================
        // Opérateur NOT (!) - Négation
        // ========================================
        System.out.println("=== Opérateur NOT (!) ===");
        
        boolean isActive = true;
        boolean isInactive = !isActive;  // Inverse la valeur
        
        System.out.println("isActive: " + isActive);
        System.out.println("isInactive: " + isInactive);
        System.out.println();
        
        // Table de vérité NOT
        System.out.println("Table de vérité NOT:");
        System.out.println("!true  = " + !true);
        System.out.println("!false = " + !false);
        System.out.println();
        
        // ========================================
        // Opérateur AND (&&) - Conjonction
        // ========================================
        System.out.println("=== Opérateur AND (&&) ===");
        
        // Exemple 1: AND avec deux true
        boolean hasInternet = true;
        boolean hasSubscription = true;
        boolean canStream = hasInternet && hasSubscription;
        
        System.out.println("hasInternet: " + hasInternet + 
                           ", hasSubscription: " + hasSubscription);
        System.out.println("canStream: " + canStream);
        System.out.println();
        
        // Exemple 2: AND avec un false
        hasSubscription = false;
        canStream = hasInternet && hasSubscription;
        
        System.out.println("hasInternet: " + hasInternet + 
                           ", hasSubscription: " + hasSubscription);
        System.out.println("canStream: " + canStream);
        System.out.println();
        
        // Table de vérité AND
        System.out.println("Table de vérité AND:");
        System.out.println("true  && true  = " + (true && true));
        System.out.println("true  && false = " + (true && false));
        System.out.println("false && true  = " + (false && true));
        System.out.println("false && false = " + (false && false));
        System.out.println();
        
        // ========================================
        // Opérateur OR (||) - Disjonction
        // ========================================
        System.out.println("=== Opérateur OR (||) ===");
        
        // Exemple 1: OR avec un true
        boolean isAdmin = false;
        boolean isModerator = true;
        boolean hasAccess = isAdmin || isModerator;
        
        System.out.println("isAdmin: " + isAdmin + 
                           ", isModerator: " + isModerator);
        System.out.println("hasAccess: " + hasAccess);
        System.out.println();
        
        // Exemple 2: OR avec deux false
        isAdmin = false;
        isModerator = false;
        hasAccess = isAdmin || isModerator;
        
        System.out.println("isAdmin: " + isAdmin + 
                           ", isModerator: " + isModerator);
        System.out.println("hasAccess: " + hasAccess);
        System.out.println();
        
        // Table de vérité OR
        System.out.println("Table de vérité OR:");
        System.out.println("true  || true  = " + (true || true));
        System.out.println("true  || false = " + (true || false));
        System.out.println("false || true  = " + (false || true));
        System.out.println("false || false = " + (false || false));
    }
}
