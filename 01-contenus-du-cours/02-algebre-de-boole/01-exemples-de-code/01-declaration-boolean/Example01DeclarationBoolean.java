// Exemple 01 : Déclaration de variables booléennes
//
// Objectif pédagogique : comprendre comment déclarer et initialiser des
// variables booléennes en Java
//
// Concepts illustrés :
// - Type primitif boolean
// - Valeurs true et false
// - Convention de nommage pour les variables booléennes
//
// Sortie attendue :
// État de connexion
// isConnected: true
// hasError: false
// isValidInput: true
//
// Vérifications
// canEdit: true
// shouldSave: false
// isReady: true

public class Example01DeclarationBoolean {
    public static void main(String[] args) {
        // Déclaration et initialisation de variables booléennes
        // Convention : utiliser des préfixes comme is, has, can, should
        
        System.out.println("État de connexion");
        
        // Préfixe "is" : indique un état
        boolean isConnected = true;
        System.out.println("isConnected: " + isConnected);
        
        // Préfixe "has" : indique la possession ou la présence
        boolean hasError = false;
        System.out.println("hasError: " + hasError);
        
        boolean isValidInput = true;
        System.out.println("isValidInput: " + isValidInput);
        
        System.out.println();
        System.out.println("Vérifications");
        
        // Préfixe "can" : indique une capacité ou permission
        boolean canEdit = true;
        System.out.println("canEdit: " + canEdit);
        
        // Préfixe "should" : indique une recommandation
        boolean shouldSave = false;
        System.out.println("shouldSave: " + shouldSave);
        
        // État général
        boolean isReady = true;
        System.out.println("isReady: " + isReady);
    }
}
