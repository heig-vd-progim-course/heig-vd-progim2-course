/**
 * Classe représentant une personne avec un nom et un âge.
 * 
 */
class Person {
    // Attributs (état de la personne)
    String name;
    int age;

    /**
     * Constructeur.
     * 
     * Initialise une personne avec un nom et un âge.
     */
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Affiche les informations de la personne.
     * 
     * Méthode sans retour (void): affiche directement les informations.
     */
    public void displayInfo() {
        System.out.println(name + " a " + age + " ans.");
    }

    /**
     * Compare l'âge avec une autre personne et affiche le résultat.
     * 
     * Utilise 'this' pour référencer l'objet courant et 'other' pour
     * l'autre personne passée en paramètre.
     */
    public void displayAgeDifference(Person other) {
        if (this.age < other.age) {
            System.out.println(other.name + " est plus agée que " + this.name);
        } else if (this.age > other.age) {
            System.out.println(this.name + " est plus agée que " + other.name);
        } else {
            System.out.println("Elles ont le même âge");
        }
    }

    /**
     * Affiche une salutation vers une autre personne.
     * 
     * Démontre qu'un objet peut interagir avec lui-même ou avec d'autres objets.
     */
    public void salute(Person other) {
        System.out.println(this.name + " salue " + other.name);
    }

}

/**
 * Programme principal démontrant l'utilisation de la classe Person.
 * 
 * Ce programme crée plusieurs objets Person et montre comment ils peuvent
 * interagir entre eux et avec eux-mêmes.
 */
public class Main {
    public static void main(String[] args) {

        // Création de trois personnes
        Person one = new Person("Sacha", 15);
        Person two = new Person("Yasmine", 25);
        Person three = new Person("Vincent", 32);

        // Affichage des informations
        one.displayInfo();
        two.displayInfo();

        // Comparaison d'âges
        one.displayAgeDifference(two);

        // Salutations entre personnes
        two.salute(one);
        one.salute(one);      // Une personne peut se saluer elle-même
        one.salute(two);
        three.salute(one);
    }
}
