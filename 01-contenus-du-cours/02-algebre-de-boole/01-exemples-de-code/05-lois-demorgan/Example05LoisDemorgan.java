// Exemple 05 : Lois de De Morgan
//
// Objectif pédagogique : comprendre et appliquer les lois de De Morgan pour
// simplifier des expressions booléennes
//
// Concepts illustrés :
// - Première loi de De Morgan : !(A && B) est équivalent à (!A || !B)
// - Deuxième loi de De Morgan : !(A || B) est équivalent à (!A && !B)
// - Simplification d'expressions logiques
// - Amélioration de la lisibilité du code
//
// Sortie attendue : voir README.md

public class Example05LoisDemorgan {
    public static void main(String[] args) {
        // ========================================
        // Première loi de De Morgan
        // !(A && B) est équivalent à (!A || !B)
        // ========================================
        System.out.println("=== Première loi de De Morgan ===");
        System.out.println("!(A && B) est équivalent à (!A || !B)");
        System.out.println();
        
        // Cas 1: Les deux sont true
        System.out.println("Cas 1:");
        boolean hasInternet = true;
        boolean hasData = true;
        
        boolean expression1 = !(hasInternet && hasData);
        boolean expression2 = !hasInternet || !hasData;
        
        System.out.println("hasInternet: " + hasInternet + 
                           ", hasData: " + hasData);
        System.out.println("!(hasInternet && hasData) = " + expression1);
        System.out.println("!hasInternet || !hasData = " + expression2);
        System.out.println("Les deux expressions sont identiques: " + 
                           (expression1 == expression2));
        System.out.println();
        
        // Cas 2: Un est false
        System.out.println("Cas 2:");
        hasInternet = true;
        hasData = false;
        
        expression1 = !(hasInternet && hasData);
        expression2 = !hasInternet || !hasData;
        
        System.out.println("hasInternet: " + hasInternet + 
                           ", hasData: " + hasData);
        System.out.println("!(hasInternet && hasData) = " + expression1);
        System.out.println("!hasInternet || !hasData = " + expression2);
        System.out.println("Les deux expressions sont identiques: " + 
                           (expression1 == expression2));
        System.out.println();
        
        // ========================================
        // Deuxième loi de De Morgan
        // !(A || B) est équivalent à (!A && !B)
        // ========================================
        System.out.println("=== Deuxième loi de De Morgan ===");
        System.out.println("!(A || B) est équivalent à (!A && !B)");
        System.out.println();
        
        // Cas 3: Les deux sont false
        System.out.println("Cas 3:");
        boolean isClosed = false;
        boolean isFullyBooked = false;
        
        boolean canEnter1 = !(isClosed || isFullyBooked);
        boolean canEnter2 = !isClosed && !isFullyBooked;
        
        System.out.println("isClosed: " + isClosed + 
                           ", isFullyBooked: " + isFullyBooked);
        System.out.println("!(isClosed || isFullyBooked) = " + canEnter1);
        System.out.println("!isClosed && !isFullyBooked = " + canEnter2);
        System.out.println("Les deux expressions sont identiques: " + 
                           (canEnter1 == canEnter2));
        System.out.println();
        
        // Cas 4: Un est true
        System.out.println("Cas 4:");
        isClosed = true;
        isFullyBooked = false;
        
        canEnter1 = !(isClosed || isFullyBooked);
        canEnter2 = !isClosed && !isFullyBooked;
        
        System.out.println("isClosed: " + isClosed + 
                           ", isFullyBooked: " + isFullyBooked);
        System.out.println("!(isClosed || isFullyBooked) = " + canEnter1);
        System.out.println("!isClosed && !isFullyBooked = " + canEnter2);
        System.out.println("Les deux expressions sont identiques: " + 
                           (canEnter1 == canEnter2));
        System.out.println();
        
        // ========================================
        // Exemple pratique de simplification
        // ========================================
        System.out.println("=== Exemple pratique de simplification ===");
        System.out.println();
        
        boolean hasError = false;
        boolean hasWarning = false;
        
        // Avant simplification (difficile à lire)
        boolean isOk1 = !(hasError || hasWarning);
        System.out.println("Avant simplification:");
        System.out.println("!(hasError || hasWarning) = " + isOk1);
        System.out.println();
        
        // Après simplification avec De Morgan (plus clair)
        boolean isOk2 = !hasError && !hasWarning;
        System.out.println("Après simplification avec De Morgan:");
        System.out.println("!hasError && !hasWarning = " + isOk2);
        System.out.println();
        
        System.out.println("La version simplifiée est plus lisible:");
        System.out.println("\"pas d'erreur ET pas d'avertissement\"");
    }
}
