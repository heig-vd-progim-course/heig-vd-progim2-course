// Exemple 14 : À éviter - Négations multiples
//
// Objectif pédagogique : comprendre pourquoi les négations multiples nuisent
// à la lisibilité et comment les simplifier
//
// Concepts illustrés :
// - Difficulté de lecture des négations multiples
// - Application des lois de De Morgan pour simplifier
// - Impact sur la compréhension du code
// - Importance de la clarté dans les conditions

public class Example14AEviterNegationsMultiples {
    public static void main(String[] args) {
        System.out.println("=== À éviter : Négations multiples ===");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 1 : Double négation
        // ========================================
        
        System.out.println("Problème 1: Double négation inutile");
        System.out.println();
        
        boolean isReady = true;
        
        System.out.println("❌ Code confus:");
        System.out.println("if (!(!isReady)) {");
        System.out.println("    System.out.println(\"Système prêt\");");
        System.out.println("}");
        System.out.println();
        
        if (!(!isReady)) {  // Double négation = identité
            System.out.println("Résultat: Système prêt");
        }
        
        System.out.println();
        
        System.out.println("✓ Code simplifié:");
        System.out.println("if (isReady) {");
        System.out.println("    System.out.println(\"Système prêt\");");
        System.out.println("}");
        System.out.println();
        
        if (isReady) {  // Simple et clair
            System.out.println("Résultat: Système prêt");
        }
        
        System.out.println();
        System.out.println("Raison: !!x est toujours équivalent à x");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 2 : Négation de conjonction
        // ========================================
        
        System.out.println("Problème 2: Négation d'une expression AND complexe");
        System.out.println();
        
        boolean hasError = false;
        boolean hasWarning = false;
        
        System.out.println("❌ Code difficile à lire:");
        System.out.println("if (!(!hasError && !hasWarning)) {");
        System.out.println("    System.out.println(\"Problèmes détectés\");");
        System.out.println("}");
        System.out.println();
        System.out.println("Analyse: Il faut lire attentivement pour comprendre");
        System.out.println();
        
        if (!(!hasError && !hasWarning)) {  // Très confus !
            System.out.println("Résultat: Problèmes détectés");
        } else {
            System.out.println("Résultat: Aucun problème");
        }
        
        System.out.println();
        
        System.out.println("✓ Code simplifié avec De Morgan:");
        System.out.println("if (hasError || hasWarning) {");
        System.out.println("    System.out.println(\"Problèmes détectés\");");
        System.out.println("}");
        System.out.println();
        System.out.println("Application: !(!A && !B) = !(!A) || !(!B) = A || B");
        System.out.println();
        
        if (hasError || hasWarning) {  // Beaucoup plus clair !
            System.out.println("Résultat: Problèmes détectés");
        } else {
            System.out.println("Résultat: Aucun problème");
        }
        
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 3 : Négation de disjonction
        // ========================================
        
        System.out.println("Problème 3: Négation d'une expression OR");
        System.out.println();
        
        boolean isClosed = true;
        boolean isFullyBooked = false;
        
        System.out.println("❌ Code avec négations multiples:");
        System.out.println("if (!(isClosed || isFullyBooked)) {");
        System.out.println("    System.out.println(\"Accès possible\");");
        System.out.println("}");
        System.out.println();
        
        if (!(isClosed || isFullyBooked)) {
            System.out.println("Résultat: Accès possible");
        } else {
            System.out.println("Résultat: Accès impossible");
        }
        
        System.out.println();
        
        System.out.println("✓ Code simplifié avec De Morgan:");
        System.out.println("if (!isClosed && !isFullyBooked) {");
        System.out.println("    System.out.println(\"Accès possible\");");
        System.out.println("}");
        System.out.println();
        System.out.println("Application: !(A || B) = !A && !B");
        System.out.println();
        
        if (!isClosed && !isFullyBooked) {
            System.out.println("Résultat: Accès possible");
        } else {
            System.out.println("Résultat: Accès impossible");
        }
        
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 4 : Noms de variables négatifs
        // ========================================
        
        System.out.println("Problème 4: Variables avec noms négatifs");
        System.out.println();
        
        boolean isNotReady = true;
        
        System.out.println("❌ Code avec double négation implicite:");
        System.out.println("boolean isNotReady = true;");
        System.out.println("if (!isNotReady) {  // \"pas pas prêt\" = confus");
        System.out.println("    System.out.println(\"Système prêt\");");
        System.out.println("}");
        System.out.println();
        
        if (!isNotReady) {  // "pas pas prêt" = difficile à lire
            System.out.println("Résultat: Système prêt");
        } else {
            System.out.println("Résultat: Système pas prêt");
        }
        
        System.out.println();
        
        System.out.println("✓ Code avec nom positif:");
        System.out.println("boolean isReady = false;");
        System.out.println("if (isReady) {");
        System.out.println("    System.out.println(\"Système prêt\");");
        System.out.println("}");
        System.out.println();
        
        boolean isReady2 = false;  // Nom positif
        if (isReady2) {  // Facile à lire
            System.out.println("Résultat: Système prêt");
        } else {
            System.out.println("Résultat: Système pas prêt");
        }
        
        System.out.println();
        System.out.println("Raison: Préférez des noms positifs pour éviter les doubles négations");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 5 : Condition très complexe
        // ========================================
        
        System.out.println("Problème 5: Condition excessivement complexe");
        System.out.println();
        
        boolean hasInternet = true;
        boolean hasData = true;
        boolean isOfflineMode = false;
        
        System.out.println("❌ Code avec négations multiples:");
        System.out.println("if (!((!hasInternet && !hasData) || isOfflineMode)) {");
        System.out.println("    System.out.println(\"Connexion disponible\");");
        System.out.println("}");
        System.out.println();
        
        if (!((!hasInternet && !hasData) || isOfflineMode)) {
            System.out.println("Résultat: Connexion disponible");
        } else {
            System.out.println("Résultat: Pas de connexion");
        }
        
        System.out.println();
        
        System.out.println("✓ Code avec variable intermédiaire:");
        System.out.println("boolean hasConnection = (hasInternet || hasData) && !isOfflineMode;");
        System.out.println("if (hasConnection) {");
        System.out.println("    System.out.println(\"Connexion disponible\");");
        System.out.println("}");
        System.out.println();
        
        // Variable intermédiaire avec nom descriptif
        boolean hasConnection = (hasInternet || hasData) && !isOfflineMode;
        if (hasConnection) {
            System.out.println("Résultat: Connexion disponible");
        } else {
            System.out.println("Résultat: Pas de connexion");
        }
        
        System.out.println();
        System.out.println("Raison: Une variable intermédiaire bien nommée améliore la clarté");
        System.out.println();
        
        // ========================================
        // Résumé
        // ========================================
        
        System.out.println("=== Résumé ===");
        System.out.println("→ Évitez les doubles négations: !!x = x");
        System.out.println("→ Appliquez De Morgan: !(A && B) = !A || !B");
        System.out.println("→ Appliquez De Morgan: !(A || B) = !A && !B");
        System.out.println("→ Préférez des noms de variables positifs");
        System.out.println("→ Utilisez des variables intermédiaires pour les conditions complexes");
    }
}
