// Exemple 03 : Opérateur XOR (OU exclusif)
//
// Objectif pédagogique : comprendre et utiliser l'opérateur XOR pour les choix
// exclusifs
//
// Concepts illustrés :
// - Opérateur XOR (^) - ou exclusif
// - Table de vérité
// - Cas d'usage pratiques (choix mutuellement exclusifs)
//
// Sortie attendue : voir README.md

public class Example03OperateurXor {
    public static void main(String[] args) {
        System.out.println("=== Opérateur XOR (^) ===");
        System.out.println();
        
        // Exemple pratique : vérifier qu'une seule source d'énergie est utilisée
        System.out.println("Exemple 1: Source d'énergie unique");
        boolean usesSolarPower = true;
        boolean usesGridPower = false;
        boolean usesOnlyOneSource = usesSolarPower ^ usesGridPower;
        
        System.out.println("usesSolarPower: " + usesSolarPower + 
                           ", usesGridPower: " + usesGridPower);
        System.out.println("usesOnlyOneSource: " + usesOnlyOneSource);
        System.out.println();
        
        // Cas où les deux sources sont activées (erreur)
        System.out.println("Exemple 2: Deux sources activées");
        usesSolarPower = true;
        usesGridPower = true;
        usesOnlyOneSource = usesSolarPower ^ usesGridPower;
        
        System.out.println("usesSolarPower: " + usesSolarPower + 
                           ", usesGridPower: " + usesGridPower);
        System.out.println("usesOnlyOneSource: " + usesOnlyOneSource);
        System.out.println();
        
        // Cas où aucune source n'est activée (erreur aussi)
        System.out.println("Exemple 3: Aucune source");
        usesSolarPower = false;
        usesGridPower = false;
        usesOnlyOneSource = usesSolarPower ^ usesGridPower;
        
        System.out.println("usesSolarPower: " + usesSolarPower + 
                           ", usesGridPower: " + usesGridPower);
        System.out.println("usesOnlyOneSource: " + usesOnlyOneSource);
        System.out.println();
        
        // Table de vérité XOR
        System.out.println("Table de vérité XOR:");
        System.out.println("true  ^ true  = " + (true ^ true));
        System.out.println("true  ^ false = " + (true ^ false));
        System.out.println("false ^ true  = " + (false ^ true));
        System.out.println("false ^ false = " + (false ^ false));
        System.out.println();
        
        // Comparaison avec OR pour montrer la différence
        System.out.println("Comparaison XOR vs OR:");
        System.out.println("Avec XOR (^): Une seule option doit être vraie");
        System.out.println("true ^ false = " + (true ^ false));
        System.out.println("false ^ true = " + (false ^ true));
        System.out.println("true ^ true = " + (true ^ true) + "  ← Différent de OR");
        System.out.println();
        
        System.out.println("Avec OR (||): Au moins une option doit être vraie");
        System.out.println("true || false = " + (true || false));
        System.out.println("false || true = " + (false || true));
        System.out.println("true || true = " + (true || true) + "  ← Toujours vrai");
    }
}
