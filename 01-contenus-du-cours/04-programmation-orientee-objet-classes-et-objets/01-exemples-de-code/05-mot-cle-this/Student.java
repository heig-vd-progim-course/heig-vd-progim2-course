/**
 * Classe représentant une personne qui étudie.
 * 
 * Cette classe démontre les différentes utilisations du mot-clé 'this'.
 */
public class Student {
    // Attributs
    String name;
    int age;
    double averageGrade;
    
    /**
     * Constructeur.
     * 
     * Le mot-clé 'this' est obligatoire ici pour différencier les attributs
     * des paramètres qui ont le même nom.
     */
    public Student(String name, int age, double averageGrade) {
        this.name = name;              // this.name = attribut, name = paramètre
        this.age = age;                // this.age = attribut, age = paramètre
        this.averageGrade = averageGrade;
        
        // Appel d'une autre méthode de la classe avec 'this'
        this.displayCreationMessage();
    }
    
    /**
     * Affiche un message de création.
     */
    void displayCreationMessage() {
        System.out.println("Création de la personne qui étudie: " + this.name);
        System.out.println();
    }
    
    /**
     * Affiche les informations de la personne qui étudie.
     */
    void displayInfo() {
        System.out.println("=== Informations de la personne qui étudie ===");
        System.out.println("Nom: " + this.name);
        System.out.println("Âge: " + this.age + " ans");
        System.out.println("Moyenne: " + this.averageGrade);
        System.out.println("========================================");
    }
    
    /**
     * Change le nom de la personne qui étudie.
     * 
     * Ici, 'this' est nécessaire pour distinguer l'attribut du paramètre.
     */
    void changeName(String name) {
        this.name = name;  // Sans 'this', on modifierait le paramètre, pas l'attribut
        
        // Appel d'une autre méthode avec 'this'
        this.displayChangeMessage();
    }
    
    /**
     * Affiche un message de changement.
     */
    void displayChangeMessage() {
        System.out.println("La personne qui étudie a changé de nom: " + this.name);
        System.out.println();
    }
}
