// MAUVAISE PRATIQUE : encapsulation sans validation
class Product {
    private String name;
    private double price;
    private int stock;

    // Constructeur SANS validation
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    // Getters
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getStock() { return stock; }

    // Setters SANS validation
    public void setName(String name) {
        this.name = name;  // Aucune vérification !
    }

    public void setPrice(double price) {
        this.price = price;  // Aucune vérification !
    }

    public void setStock(int stock) {
        this.stock = stock;  // Aucune vérification !
    }

    public void displayInfo() {
        System.out.println("Produit: " + name);
        System.out.println("Prix: " + price + " CHF");
        System.out.println("Stock: " + stock + " unités");
    }
}

public class ErrorExample {
    public static void main(String[] args) {
        System.out.println("=== Démonstration des problèmes ===\n");

        // PROBLÈME 1 : Création avec valeurs invalides
        System.out.println("Problème 1 - Constructeur sans validation:");
        Product product1 = new Product("", -50.0, -100);
        product1.displayInfo();
        System.out.println("^ Nom vide, prix négatif, stock négatif : tous acceptés !\n");

        // PROBLÈME 2 : Setters acceptent n'importe quoi
        System.out.println("Problème 2 - Setters sans validation:");
        Product product2 = new Product("Ordinateur", 1000.0, 10);
        
        product2.setName(null);         // Null accepté !
        product2.setPrice(-999.99);     // Prix négatif accepté !
        product2.setStock(-50);         // Stock négatif accepté !
        
        product2.displayInfo();
        System.out.println("^ Toutes les modifications invalides ont été acceptées !\n");

        // PROBLÈME 3 : États incohérents
        System.out.println("Problème 3 - États incohérents:");
        Product product3 = new Product("Livre", 25.0, 5);
        
        product3.setName("");           // Produit sans nom
        product3.setPrice(0.0);         // Produit gratuit ?
        product3.setStock(Integer.MAX_VALUE);  // Stock irréaliste
        
        product3.displayInfo();
        System.out.println("^ L'objet est techniquement valide mais logiquement absurde !\n");

        // PROBLÈME 4 : Pas de protection des règles métier
        System.out.println("Problème 4 - Règles métier non respectées:");
        Product product4 = new Product("Téléphone", 800.0, 3);
        
        // Dans la vraie vie, on ne devrait pas pouvoir mettre un prix à 0.01
        product4.setPrice(0.01);
        
        // Ou un stock de 1 million alors qu'on est une petite boutique
        product4.setStock(1000000);
        
        product4.displayInfo();
        System.out.println("^ Les règles métier ne sont pas appliquées !\n");

        // PROBLÈME 5 : Fausse sécurité
        System.out.println("Problème 5 - Fausse sécurité:");
        System.out.println("Les développeurs pensent que l'encapsulation protège");
        System.out.println("les données, mais sans validation, c'est une illusion.");
        System.out.println("C'est pire que pas d'encapsulation : on croit être protégé !");
    }
}
