/**
 * Programme principal pour tester la classe Product avec un constructeur.
 */
public class Main {
    public static void main(String[] args) {
        // Création d'un objet Product avec le constructeur
        // Le mot-clé 'new' appelle le constructeur automatiquement
        Product keyboard = new Product("Clavier mécanique", 129.90, 15);
        
        // Appel de la méthode displayInfo() sur l'objet créé
        keyboard.displayInfo();
    }
}
