/**
 * Classe représentant un livre dans une bibliothèque.
 * 
 * Cette classe intègre tous les concepts de la POO vus dans les exemples précédents:
 * - Attributs
 * - Constructeur
 * - Méthodes de consultation (avec retour)
 * - Méthodes de modification (changement d'état)
 * - Utilisation de 'this'
 * - Validations
 */
public class Book {
    // Attributs (état du livre)
    String title;
    String author;
    int pages;
    boolean isAvailable;  // true si disponible, false si emprunté
    
    /**
     * Constructeur.
     * 
     * Initialise un livre avec ses informations.
     * Par défaut, un livre est disponible.
     */
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;  // Valeur par défaut
    }
    
    /**
     * Retourne le titre du livre.
     * 
     * Méthode de CONSULTATION: lit l'état sans le modifier.
     */
    String getTitle() {
        return this.title;
    }
    
    /**
     * Retourne l'auteur du livre.
     */
    String getAuthor() {
        return this.author;
    }
    
    /**
     * Retourne le nombre de pages.
     */
    int getPages() {
        return this.pages;
    }
    
    /**
     * Vérifie si le livre est disponible.
     */
    boolean isAvailable() {
        return this.isAvailable;
    }
    
    /**
     * Emprunte le livre.
     * 
     * Méthode de MODIFICATION: change l'état du livre.
     * 
     * @return true si l'emprunt a réussi, false si le livre n'était pas disponible
     */
    boolean borrow() {
        if (this.isAvailable) {
            this.isAvailable = false;  // Modification de l'état
            System.out.println("Le livre \"" + this.title + "\" a été emprunté avec succès.");
            return true;
        } else {
            System.out.println("Impossible d'emprunter \"" + this.title + "\": le livre n'est pas disponible.");
            return false;
        }
    }
    
    /**
     * Retourne le livre à la bibliothèque.
     * 
     * Méthode de MODIFICATION: change l'état du livre.
     * 
     * @return true si le retour a réussi, false si le livre était déjà disponible
     */
    boolean returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;  // Modification de l'état
            System.out.println("Le livre \"" + this.title + "\" a été retourné avec succès.");
            return true;
        } else {
            System.out.println("Erreur: le livre \"" + this.title + "\" n'était pas emprunté.");
            return false;
        }
    }
    
    /**
     * Affiche les informations complètes du livre.
     * 
     * Méthode de CONSULTATION utilisant plusieurs attributs.
     */
    void displayInfo() {
        System.out.println("Titre: " + this.title);
        System.out.println("Auteur: " + this.author);
        System.out.println("Pages: " + this.pages);
        System.out.println("Disponible: " + (this.isAvailable ? "Oui" : "Non"));
    }
}
