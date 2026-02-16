// Exemple 13 : À éviter - Type non booléen dans une condition
//
// Objectif pédagogique : comprendre pourquoi Java n'accepte que des booléens
// dans les conditions et comment éviter cette erreur
//
// Concepts illustrés :
// - Erreur de type dans les conditions
// - Java vs langages avec conversion implicite
// - Nécessité d'une expression booléenne explicite
// - Comparaison correcte pour obtenir un booléen

public class Example13AEviterTypeNonBooleen {
    public static void main(String[] args) {
        System.out.println("=== À éviter : Type non booléen dans une condition ===");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 1 : Utiliser un nombre comme condition
        // ========================================
        
        System.out.println("Problème 1: Utiliser un nombre comme condition");
        System.out.println();
        
        int count = 0;
        
        System.out.println("❌ Code incorrect (commenté car erreur de compilation):");
        System.out.println("int count = 0;");
        System.out.println("if (count) {  // ERREUR : count n'est pas un booléen");
        System.out.println("    System.out.println(\"Count est non-zéro\");");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté)
        /*
        if (count) {  // ERREUR DE COMPILATION : incompatible types
            System.out.println("Count est non-zéro");
        }
        */
        
        System.out.println("Erreur de compilation:");
        System.out.println("incompatible types: int cannot be converted to boolean");
        System.out.println();
        
        // ✓ BON CODE
        System.out.println("✓ Code correct:");
        System.out.println("if (count > 0) {");
        System.out.println("    System.out.println(\"Count est positif\");");
        System.out.println("}");
        System.out.println();
        
        if (count > 0) {
            System.out.println("Résultat: Count est positif");
        } else {
            System.out.println("Résultat: Count n'est pas positif");
        }
        
        System.out.println();
        System.out.println("Raison: La comparaison produit un booléen (true ou false)");
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 2 : Utiliser 0 ou 1 comme booléen
        // ========================================
        
        System.out.println("Problème 2: Utiliser 0 ou 1 comme booléen");
        System.out.println();
        
        int flag = 1;
        
        System.out.println("❌ Code incorrect (commenté car erreur de compilation):");
        System.out.println("int flag = 1;");
        System.out.println("if (flag) {  // ERREUR même si flag vaut 1");
        System.out.println("    System.out.println(\"Flag est activé\");");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté)
        /*
        if (flag) {  // ERREUR : même avec 1, ce n'est pas un booléen
            System.out.println("Flag est activé");
        }
        */
        
        System.out.println("Note: En C ou JavaScript, 1 serait converti en true");
        System.out.println("Mais Java ne fait PAS cette conversion implicite");
        System.out.println();
        
        // ✓ BON CODE
        System.out.println("✓ Code correct:");
        System.out.println("if (flag == 1) {");
        System.out.println("    System.out.println(\"Flag est activé\");");
        System.out.println("}");
        System.out.println();
        
        if (flag == 1) {
            System.out.println("Résultat: Flag est activé");
        }
        
        System.out.println();
        
        // Meilleure solution : utiliser un booléen
        System.out.println("✓ Meilleure solution: Utiliser un booléen directement");
        System.out.println("boolean isActive = true;");
        System.out.println("if (isActive) {");
        System.out.println("    System.out.println(\"Flag est activé\");");
        System.out.println("}");
        System.out.println();
        
        boolean isActive = true;
        if (isActive) {
            System.out.println("Résultat: Flag est activé");
        }
        
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 3 : Utiliser null directement
        // ========================================
        
        System.out.println("Problème 3: Utiliser null directement");
        System.out.println();
        
        String text = null;
        
        System.out.println("❌ Code incorrect (commenté car erreur de compilation):");
        System.out.println("String text = null;");
        System.out.println("if (text) {  // ERREUR : text n'est pas un booléen");
        System.out.println("    System.out.println(\"Texte existe\");");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté)
        /*
        if (text) {  // ERREUR : String n'est pas un boolean
            System.out.println("Texte existe");
        }
        */
        
        // ✓ BON CODE
        System.out.println("✓ Code correct:");
        System.out.println("if (text != null) {");
        System.out.println("    System.out.println(\"Texte existe\");");
        System.out.println("}");
        System.out.println();
        
        if (text != null) {
            System.out.println("Résultat: Texte existe");
        } else {
            System.out.println("Résultat: Texte est null");
        }
        
        System.out.println();
        
        // ========================================
        // ❌ ERREUR 4 : Chaîne vide
        // ========================================
        
        System.out.println("Problème 4: Tester une chaîne vide");
        System.out.println();
        
        String name = "";
        
        System.out.println("❌ Code incorrect (commenté car erreur de compilation):");
        System.out.println("String name = \"\";");
        System.out.println("if (name) {  // ERREUR : name n'est pas un booléen");
        System.out.println("    System.out.println(\"Nom fourni\");");
        System.out.println("}");
        System.out.println();
        
        // ❌ MAUVAIS CODE (commenté)
        /*
        if (name) {  // ERREUR : String n'est pas un boolean
            System.out.println("Nom fourni");
        }
        */
        
        // ✓ BON CODE
        System.out.println("✓ Code correct:");
        System.out.println("if (!name.isEmpty()) {");
        System.out.println("    System.out.println(\"Nom fourni\");");
        System.out.println("}");
        System.out.println();
        
        if (!name.isEmpty()) {
            System.out.println("Résultat: Nom fourni");
        } else {
            System.out.println("Résultat: Nom est vide");
        }
        
        System.out.println();
        
        // Version plus sûre (vérifie aussi null)
        System.out.println("✓ Version plus sûre (vérifie null et vide):");
        System.out.println("if (name != null && !name.isEmpty()) {");
        System.out.println("    System.out.println(\"Nom fourni\");");
        System.out.println("}");
        System.out.println();
        
        // ========================================
        // Résumé
        // ========================================
        
        System.out.println("=== Résumé ===");
        System.out.println("En Java, les conditions doivent être de type boolean:");
        System.out.println("→ Utilisez des comparaisons: count > 0, value == 1");
        System.out.println("→ Testez null explicitement: object != null");
        System.out.println("→ Testez les chaînes vides: !text.isEmpty()");
        System.out.println("→ Préférez les booléens aux entiers 0/1");
        System.out.println();
        System.out.println("Cette rigueur de Java prévient les erreurs et rend le code explicite");
    }
}
