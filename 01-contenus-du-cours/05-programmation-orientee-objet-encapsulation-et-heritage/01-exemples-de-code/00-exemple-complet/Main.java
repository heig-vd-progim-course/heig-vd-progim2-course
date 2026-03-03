/**
 * Exemple complet : Système de bibliothèque
 * 
 * Cet exemple montre l'évolution d'un système de bibliothèque simple vers un
 * système robuste utilisant l'encapsulation et l'héritage.
 * 
 * Nous découvrirons pourquoi ces concepts sont essentiels quand notre code
 * grandit.
 */

// ============================================================================
// ÉTAPE 1 : Version simple SANS encapsulation
// ============================================================================

/**
 * Version initiale : classe Book simple avec attributs accessibles.
 * 
 * Cette version fonctionne, mais ne protège pas contre les données invalides.
 */
class BookV1 {
    String title;
    String author;
    int pages;
    double price;
}

// ============================================================================
// ÉTAPE 2 : Version AVEC encapsulation
// ============================================================================

/**
 * Version améliorée : classe Book avec encapsulation.
 * 
 * Les attributs sont maintenant privés et protégés par des validations.
 */
class BookV2 {
    private String title;
    private String author;
    private int pages;
    private double price;

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public double getPrice() {
        return price;
    }

    // Setters avec validation
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Erreur: le titre ne peut pas être vide.");
            return;
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Erreur: l'auteur ne peut pas être vide.");
            return;
        }
        this.author = author;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            System.out.println("Erreur: le nombre de pages doit être positif.");
            return;
        }
        this.pages = pages;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Erreur: le prix ne peut pas être négatif.");
            return;
        }
        this.price = price;
    }

    public void displayInfo() {
        System.out.println("Livre: " + title + " par " + author);
        System.out.println("Pages: " + pages + ", Prix: " + price + " CHF");
    }
}

// ============================================================================
// ÉTAPE 3 : Version AVEC héritage
// ============================================================================

/**
 * Classe abstraite Document : contient tous les attributs et méthodes communs.
 * 
 * Cette classe factorise le code commun à tous les types de documents
 * (livres, magazines, DVDs).
 */
abstract class Document {
    protected String title;
    protected String author;
    protected double price;

    // Getters communs
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    // Setters avec validation communs
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            System.out.println("Erreur: le titre ne peut pas être vide.");
            return;
        }
        this.title = title;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            System.out.println("Erreur: l'auteur ne peut pas être vide.");
            return;
        }
        this.author = author;
    }

    public void setPrice(double price) {
        if (price < 0) {
            System.out.println("Erreur: le prix ne peut pas être négatif.");
            return;
        }
        this.price = price;
    }

    // Méthode abstraite : chaque type de document l'implémente différemment
    public abstract void displayInfo();
}

/**
 * Classe Book : hérite de Document et ajoute les attributs spécifiques aux livres.
 */
class Book extends Document {
    private int pages;

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        if (pages <= 0) {
            System.out.println("Erreur: le nombre de pages doit être positif.");
            return;
        }
        this.pages = pages;
    }

    @Override
    public void displayInfo() {
        System.out.println("Livre: " + title + " par " + author);
        System.out.println("Pages: " + pages + ", Prix: " + price + " CHF");
    }
}

/**
 * Classe Magazine : hérite de Document et ajoute les attributs spécifiques aux
 * magazines.
 */
class Magazine extends Document {
    private int issueNumber;

    public int getIssueNumber() {
        return issueNumber;
    }

    public void setIssueNumber(int issueNumber) {
        if (issueNumber <= 0) {
            System.out.println("Erreur: le numéro doit être positif.");
            return;
        }
        this.issueNumber = issueNumber;
    }

    @Override
    public void displayInfo() {
        System.out.println("Magazine: " + title + " par " + author);
        System.out.println("Numéro: " + issueNumber + ", Prix: " + price + " CHF");
    }
}

/**
 * Classe DVD : hérite de Document et ajoute les attributs spécifiques aux DVDs.
 */
class DVD extends Document {
    private int durationMinutes;

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        if (durationMinutes <= 0) {
            System.out.println("Erreur: la durée doit être positive.");
            return;
        }
        this.durationMinutes = durationMinutes;
    }

    @Override
    public void displayInfo() {
        System.out.println("DVD: " + title + " par " + author);
        System.out.println("Durée: " + durationMinutes + " min, Prix: " + price + " CHF");
    }
}

// ============================================================================
// Programme principal : démonstration des différentes étapes
// ============================================================================

public class Main {
    public static void main(String[] args) {
        demonstrateStep1();
        demonstrateStep2();
        demonstrateStep3();
    }

    /**
     * ÉTAPE 1 : Démontre le problème sans encapsulation.
     */
    private static void demonstrateStep1() {
        System.out.println("=== ÉTAPE 1 : Sans encapsulation ===\n");

        // Créer un livre normal
        BookV1 book1 = new BookV1();
        book1.title = "Java pour débutants";
        book1.author = "Alice Dupont";
        book1.pages = 350;
        book1.price = 45.50;

        System.out.println("Livre valide créé:");
        System.out.println("Titre: " + book1.title);
        System.out.println("Auteur: " + book1.author);
        System.out.println("Pages: " + book1.pages);
        System.out.println("Prix: " + book1.price + " CHF");

        System.out.println("\nMais nous pouvons aussi créer un livre avec des données invalides:");

        // Le problème : rien n'empêche de créer un livre invalide
        BookV1 problematicBook = new BookV1();
        problematicBook.title = "";           // Titre vide !
        problematicBook.author = null;        // Auteur null !
        problematicBook.pages = -100;         // Pages négatives !
        problematicBook.price = -50.0;        // Prix négatif !

        System.out.println("Titre: '" + problematicBook.title + "'");
        System.out.println("Auteur: " + problematicBook.author);
        System.out.println("Pages: " + problematicBook.pages);
        System.out.println("Prix: " + problematicBook.price + " CHF");
        System.out.println("\n→ Problème : aucune protection contre les données invalides !\n");
    }

    /**
     * ÉTAPE 2 : Démontre la solution avec encapsulation.
     */
    private static void demonstrateStep2() {
        System.out.println("=== ÉTAPE 2 : Avec encapsulation ===\n");

        // Créer un livre avec encapsulation
        BookV2 book = new BookV2();
        book.setTitle("Java pour débutants");
        book.setAuthor("Alice Dupont");
        book.setPages(350);
        book.setPrice(45.50);

        System.out.println("Livre valide créé:");
        book.displayInfo();

        System.out.println("\nMaintenant, essayons de définir des valeurs invalides:");

        // Tentatives avec des valeurs invalides
        BookV2 validatedBook = new BookV2();
        validatedBook.setTitle("");        // Rejeté
        validatedBook.setAuthor(null);     // Rejeté
        validatedBook.setPages(-100);      // Rejeté
        validatedBook.setPrice(-50.0);     // Rejeté

        System.out.println("\n→ Solution : les données sont protégées par la validation !\n");
    }

    /**
     * ÉTAPE 3 : Démontre la solution avec héritage.
     */
    private static void demonstrateStep3() {
        System.out.println("=== ÉTAPE 3 : Avec héritage ===\n");

        // Créer un livre
        Book book = new Book();
        book.setTitle("Java pour débutants");
        book.setAuthor("Alice Dupont");
        book.setPages(350);
        book.setPrice(45.50);

        // Créer un magazine
        Magazine magazine = new Magazine();
        magazine.setTitle("Tech Aujourd'hui");
        magazine.setAuthor("Équipe éditoriale");
        magazine.setIssueNumber(42);
        magazine.setPrice(12.90);

        // Créer un DVD
        DVD dvd = new DVD();
        dvd.setTitle("Apprendre Java");
        dvd.setAuthor("Bob Martin");
        dvd.setDurationMinutes(180);
        dvd.setPrice(29.90);

        // Afficher les informations
        System.out.println("Documents créés avec succès:\n");
        book.displayInfo();
        System.out.println();
        magazine.displayInfo();
        System.out.println();
        dvd.displayInfo();

        // Démonstration du polymorphisme
        System.out.println("\n=== Catalogue de la bibliothèque (polymorphisme) ===\n");

        Document[] library = {book, magazine, dvd};

        for (Document doc : library) {
            doc.displayInfo();  // Appelle la bonne méthode selon le type
            System.out.println("---");
        }

        System.out.println("→ Solution : code factorisé et réutilisable avec l'héritage !");
    }
}
