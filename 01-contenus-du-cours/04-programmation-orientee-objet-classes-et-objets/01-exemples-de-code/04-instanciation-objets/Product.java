/**
 * Classe représentant un produit.
 */
public class Product {
    String name;
    double price;
    int stockQuantity;
    
    public Product(String name, double price, int stockQuantity) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }
    
    void displayInfo() {
        System.out.println("=== Informations du produit ===");
        System.out.println("Nom: " + name);
        System.out.println("Prix: " + price + " CHF");
        System.out.println("Quantité en stock: " + stockQuantity);
        System.out.println("================================");
    }
}
