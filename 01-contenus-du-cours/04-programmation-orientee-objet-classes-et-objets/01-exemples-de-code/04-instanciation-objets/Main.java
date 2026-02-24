/**
 * Programme principal démontrant la création de plusieurs objets.
 */
public class Main {
    public static void main(String[] args) {
        // Création du premier produit
        Product keyboard = new Product("Clavier mécanique", 129.90, 15);
        
        // Création du deuxième produit
        Product mouse = new Product("Souris sans fil", 45.50, 28);
        
        // Création du troisième produit
        Product monitor = new Product("Écran 27 pouces", 349.00, 8);
        
        // Affichage des informations de chaque produit
        // Chaque objet est indépendant et a ses propres valeurs
        keyboard.displayInfo();
        System.out.println();  // Ligne vide pour la lisibilité
        
        mouse.displayInfo();
        System.out.println();
        
        monitor.displayInfo();
    }
}
