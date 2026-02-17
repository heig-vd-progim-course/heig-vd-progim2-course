// Exemple 16 : À éviter - Expression complexe sans décomposition
//
// Objectif pédagogique : comprendre pourquoi les expressions booléennes
// complexes doivent être décomposées avec des variables intermédiaires bien
// nommées
//
// Concepts illustrés :
// - Impact négatif d'expressions trop complexes
// - Importance des variables intermédiaires
// - Amélioration de la lisibilité et maintenabilité
// - Documentation implicite par les noms de variables

public class Example16AEviterExpressionComplexe {
    public static void main(String[] args) {
        System.out.println("=== À éviter : Expression complexe sans décomposition ===");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 1 : Condition de contrôle d'accès complexe
        // ========================================
        
        System.out.println("Problème 1: Condition d'accès complexe");
        System.out.println();
        
        int age = 25;
        boolean hasLicense = true;
        boolean hasSuspension = false;
        int experienceYears = 3;
        
        System.out.println("Données:");
        System.out.println("age: " + age);
        System.out.println("hasLicense: " + hasLicense);
        System.out.println("hasSuspension: " + hasSuspension);
        System.out.println("experienceYears: " + experienceYears);
        System.out.println();
        
        System.out.println("❌ Code avec expression complexe:");
        System.out.println("if ((age >= 18 && age < 25 && hasLicense && !hasSuspension && experienceYears >= 2) ||");
        System.out.println("    (age >= 25 && age < 65 && hasLicense && !hasSuspension) ||");
        System.out.println("    (age >= 65 && hasLicense && !hasSuspension && experienceYears >= 10)) {");
        System.out.println("    System.out.println(\"Accès autorisé\");");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE
        if ((age >= 18 && age < 25 && hasLicense && !hasSuspension && experienceYears >= 2) ||
            (age >= 25 && age < 65 && hasLicense && !hasSuspension) ||
            (age >= 65 && hasLicense && !hasSuspension && experienceYears >= 10)) {
            System.out.println("Résultat: Accès autorisé");
        } else {
            System.out.println("Résultat: Accès refusé");
        }
        
        System.out.println();
        System.out.println("Problème: Expression très difficile à lire et comprendre");
        System.out.println("- Impossible de comprendre la logique du premier coup d'œil");
        System.out.println("- Difficile à déboguer");
        System.out.println("- Difficile à modifier");
        System.out.println();
        
        System.out.println("✓ Code avec décomposition:");
        System.out.println("boolean isYoungDriver = age >= 18 && age < 25;");
        System.out.println("boolean isAdult = age >= 25 && age < 65;");
        System.out.println("boolean isSenior = age >= 65;");
        System.out.println("boolean hasValidLicense = hasLicense && !hasSuspension;");
        System.out.println("boolean hasEnoughExperienceYoung = experienceYears >= 2;");
        System.out.println("boolean hasEnoughExperienceSenior = experienceYears >= 10;");
        System.out.println();
        System.out.println("boolean canAccess = (isYoungDriver && hasValidLicense && hasEnoughExperienceYoung) ||");
        System.out.println("                    (isAdult && hasValidLicense) ||");
        System.out.println("                    (isSenior && hasValidLicense && hasEnoughExperienceSenior);");
        System.out.println();
        System.out.println("if (canAccess) {");
        System.out.println("    System.out.println(\"Accès autorisé\");");
        System.out.println("}");
        System.out.println();
        
        // ✓ BON CODE
        boolean isYoungDriver = age >= 18 && age < 25;
        boolean isAdult = age >= 25 && age < 65;
        boolean isSenior = age >= 65;
        boolean hasValidLicense = hasLicense && !hasSuspension;
        boolean hasEnoughExperienceYoung = experienceYears >= 2;
        boolean hasEnoughExperienceSenior = experienceYears >= 10;
        
        boolean canAccess = (isYoungDriver && hasValidLicense && hasEnoughExperienceYoung) ||
                            (isAdult && hasValidLicense) ||
                            (isSenior && hasValidLicense && hasEnoughExperienceSenior);
        
        if (canAccess) {
            System.out.println("Résultat: Accès autorisé");
        } else {
            System.out.println("Résultat: Accès refusé");
        }
        
        System.out.println();
        System.out.println("Avantages:");
        System.out.println("- Chaque variable a un nom explicite");
        System.out.println("- La logique métier est claire");
        System.out.println("- Facile à déboguer (on peut afficher chaque variable)");
        System.out.println("- Facile à modifier (changer une règle métier)");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 2 : Validation de formulaire complexe
        // ========================================
        
        System.out.println("Problème 2: Validation de formulaire complexe");
        System.out.println();
        
        String username = "alice";
        String password = "Secret123!";
        String email = "alice@example.com";
        boolean agreedToTerms = true;
        
        System.out.println("❌ Code avec expression complexe:");
        System.out.println("if (username != null && username.length() >= 3 && username.length() <= 20 &&");
        System.out.println("    password != null && password.length() >= 8 && containsUpperCase(password) &&");
        System.out.println("    containsLowerCase(password) && containsDigit(password) &&");
        System.out.println("    email != null && email.contains(\"@\") && email.contains(\".\") &&");
        System.out.println("    agreedToTerms) {");
        System.out.println("    System.out.println(\"Formulaire valide\");");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté pour la démonstration)
        /*
        if (username != null && username.length() >= 3 && username.length() <= 20 &&
            password != null && password.length() >= 8 && containsUpperCase(password) &&
            containsLowerCase(password) && containsDigit(password) &&
            email != null && email.contains("@") && email.contains(".") &&
            agreedToTerms) {
            System.out.println("Résultat: Formulaire valide");
        }
        */
        
        System.out.println("✓ Code avec décomposition:");
        System.out.println("boolean hasValidUsername = username != null &&");
        System.out.println("                           username.length() >= 3 &&");
        System.out.println("                           username.length() <= 20;");
        System.out.println();
        System.out.println("boolean hasValidPassword = password != null &&");
        System.out.println("                           password.length() >= 8 &&");
        System.out.println("                           containsUpperCase(password) &&");
        System.out.println("                           containsLowerCase(password) &&");
        System.out.println("                           containsDigit(password);");
        System.out.println();
        System.out.println("boolean hasValidEmail = email != null &&");
        System.out.println("                        email.contains(\"@\") &&");
        System.out.println("                        email.contains(\".\");");
        System.out.println();
        System.out.println("boolean isFormValid = hasValidUsername &&");
        System.out.println("                      hasValidPassword &&");
        System.out.println("                      hasValidEmail &&");
        System.out.println("                      agreedToTerms;");
        System.out.println();
        System.out.println("if (isFormValid) {");
        System.out.println("    System.out.println(\"Formulaire valide\");");
        System.out.println("}");
        System.out.println();
        
        // ✓ BON CODE
        boolean hasValidUsername = username != null &&
                                   username.length() >= 3 &&
                                   username.length() <= 20;
        
        boolean hasValidPassword = password != null &&
                                   password.length() >= 8 &&
                                   containsUpperCase(password) &&
                                   containsLowerCase(password) &&
                                   containsDigit(password);
        
        boolean hasValidEmail = email != null &&
                                email.contains("@") &&
                                email.contains(".");
        
        boolean isFormValid = hasValidUsername &&
                              hasValidPassword &&
                              hasValidEmail &&
                              agreedToTerms;
        
        System.out.println("Détails de validation:");
        System.out.println("- Nom d'utilisateur valide: " + hasValidUsername);
        System.out.println("- Mot de passe valide: " + hasValidPassword);
        System.out.println("- Email valide: " + hasValidEmail);
        System.out.println("- Conditions acceptées: " + agreedToTerms);
        System.out.println();
        
        if (isFormValid) {
            System.out.println("Résultat: Formulaire valide");
        } else {
            System.out.println("Résultat: Formulaire invalide");
        }
        
        System.out.println();
        System.out.println("Avantage: On peut facilement identifier quelle partie est invalide");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 3 : Condition métier complexe
        // ========================================
        
        System.out.println("Problème 3: Règle métier complexe");
        System.out.println();
        
        double price = 150.0;
        boolean isMember = true;
        int loyaltyPoints = 500;
        boolean hasPromoCode = false;
        String dayOfWeek = "Tuesday";
        
        System.out.println("❌ Code illisible:");
        System.out.println("if ((price >= 100 && isMember && loyaltyPoints >= 500) ||");
        System.out.println("    (hasPromoCode && price >= 50) ||");
        System.out.println("    (dayOfWeek.equals(\"Tuesday\") && price >= 75 && isMember)) {");
        System.out.println("    System.out.println(\"Réduction applicable\");");
        System.out.println("}");
        System.out.println();
        
        System.out.println("✓ Code avec logique métier claire:");
        System.out.println("boolean qualifiesForLoyaltyDiscount = price >= 100 && isMember && loyaltyPoints >= 500;");
        System.out.println("boolean qualifiesForPromoDiscount = hasPromoCode && price >= 50;");
        System.out.println("boolean qualifiesForTuesdayDiscount = dayOfWeek.equals(\"Tuesday\") && price >= 75 && isMember;");
        System.out.println();
        System.out.println("boolean canGetDiscount = qualifiesForLoyaltyDiscount ||");
        System.out.println("                         qualifiesForPromoDiscount ||");
        System.out.println("                         qualifiesForTuesdayDiscount;");
        System.out.println();
        
        // ✓ BON CODE
        boolean qualifiesForLoyaltyDiscount = price >= 100 && isMember && loyaltyPoints >= 500;
        boolean qualifiesForPromoDiscount = hasPromoCode && price >= 50;
        boolean qualifiesForTuesdayDiscount = dayOfWeek.equals("Tuesday") && price >= 75 && isMember;
        
        boolean canGetDiscount = qualifiesForLoyaltyDiscount ||
                                 qualifiesForPromoDiscount ||
                                 qualifiesForTuesdayDiscount;
        
        System.out.println("Types de réduction disponibles:");
        System.out.println("- Réduction fidélité: " + qualifiesForLoyaltyDiscount);
        System.out.println("- Réduction code promo: " + qualifiesForPromoDiscount);
        System.out.println("- Réduction mardi: " + qualifiesForTuesdayDiscount);
        System.out.println();
        
        if (canGetDiscount) {
            System.out.println("Résultat: Réduction applicable");
        } else {
            System.out.println("Résultat: Aucune réduction");
        }
        
        System.out.println();
        System.out.println("Avantage: La logique métier est auto-documentée");
        System.out.println();
        
        // ========================================
        // Résumé
        // ========================================
        
        System.out.println("=== Résumé ===");
        System.out.println("→ Décomposez les expressions complexes en variables intermédiaires");
        System.out.println("→ Choisissez des noms explicites pour chaque variable");
        System.out.println("→ Les noms doivent refléter la logique métier");
        System.out.println("→ Facilite la lecture, le débogage et la maintenance");
        System.out.println("→ Un bon nom vaut mieux qu'un long commentaire");
    }
    
    // Méthodes utilitaires pour la validation
    private static boolean containsUpperCase(String text) {
        return text.chars().anyMatch(Character::isUpperCase);
    }
    
    private static boolean containsLowerCase(String text) {
        return text.chars().anyMatch(Character::isLowerCase);
    }
    
    private static boolean containsDigit(String text) {
        return text.chars().anyMatch(Character::isDigit);
    }
}
