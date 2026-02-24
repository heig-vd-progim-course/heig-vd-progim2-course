/**
 * Programme principal démontrant l'utilisation du mot-clé 'this'.
 */
public class Main {
    public static void main(String[] args) {
        // Création d'une personne qui étudie
        // Le constructeur utilise 'this' et appelle displayCreationMessage()
        Student alice = new Student("Alice Dupont", 20, 5.2);
        
        // Affichage des informations
        alice.displayInfo();
        System.out.println();
        
        // Changement de nom
        // La méthode changeName() utilise 'this' pour modifier l'attribut
        alice.changeName("Alice Martin");
        
        // Affichage des informations mises à jour
        alice.displayInfo();
    }
}
