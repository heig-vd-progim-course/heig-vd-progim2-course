/**
 * Classe représentant un produit avec un constructeur.
 * 
 * Le constructeur est une méthode spéciale appelée automatiquement lors de la
 * création d'un objet. Il permet d'initialiser les attributs de l'objet.
 */
public class Product {
    // Attributs de la classe
    String name;
    double price;
    int stockQuantity;
    
    /**
     * Constructeur de la classe Product.
     * 
     * Ce constructeur prend trois paramètres et les utilise pour initialiser
     * les attributs de l'objet.
     * 
     * @param name          Le nom du produit
     * @param price         Le prix du produit
     * @param stockQuantity La quantité en stock
     */
    public Product(String name, double price, int stockQuantity) {
        // Le mot-clé 'this' permet de distinguer les attributs des paramètres
        // this.name fait référence à l'attribut, name fait référence au paramètre
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    /**
     * Méthode pour afficher les informations du produit.
     */
    void displayInfo() {
        System.out.println("=== Informations du produit ===");
        System.out.println("Nom: " + name);
        System.out.println("Prix: " + price + " CHF");
        System.out.println("Quantité en stock: " + stockQuantity);
        System.out.println("================================");
    }
}
