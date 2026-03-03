# Exemple complet : Système de bibliothèque

Dans cet exemple, nous allons créer un système de gestion de bibliothèque. Nous
allons découvrir pourquoi l'encapsulation et l'héritage sont essentiels quand
notre code grandit.

## Ce que nous allons construire

Nous allons créer un système pour gérer une bibliothèque. Nous commencerons par
un système simple avec des livres, puis nous ajouterons d'autres types de
documents (magazines, DVDs).

En chemin, nous rencontrerons des problèmes concrets qui nous montreront
pourquoi l'encapsulation et l'héritage sont nécessaires.

## Étape 1 : Version simple sans encapsulation

Créez un nouveau fichier nommé `Main.java`. Dans ce fichier, nous allons créer
une classe `Book` simple avec des attributs directement accessibles, puis nous
allons l'utiliser dans le `main`.

Voici le code complet à écrire dans `Main.java` :

```java
class Book {
    String title;
    String author;
    int pages;
    double price;
}

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book();
        book1.title = "Java pour débutants";
        book1.author = "Alice Dupont";
        book1.pages = 350;
        book1.price = 45.50;

        System.out.println("Livre créé:");
        System.out.println("Titre: " + book1.title);
        System.out.println("Auteur: " + book1.author);
        System.out.println("Pages: " + book1.pages);
        System.out.println("Prix: " + book1.price + " CHF");
    }
}
```

Exécutez ce programme. Vous devriez voir l'affichage des informations du livre.

C'est simple et ça fonctionne.

### Le problème apparaît

Maintenant, ajoutez ce code dans votre `main`, juste après la création de
`book1` :

```java
public class Main {
    public static void main(String[] args) {
        // ... code précédent pour book1 ...

        // Le problème : on peut créer un livre avec des données invalides !
        Book problematicBook = new Book();
        problematicBook.title = "";           // Titre vide !
        problematicBook.author = null;        // Auteur null !
        problematicBook.pages = -100;         // Pages négatives !
        problematicBook.price = -50.0;        // Prix négatif !

        System.out.println("\nLivre problématique créé:");
        System.out.println("Titre: '" + problematicBook.title + "'");
        System.out.println("Auteur: " + problematicBook.author);
        System.out.println("Pages: " + problematicBook.pages);
        System.out.println("Prix: " + problematicBook.price + " CHF");
    }
}
```

Exécutez le programme. **Vous remarquez que** : le programme accepte ces valeurs
invalides sans aucun problème ! Rien n'empêche de créer un livre avec des
données qui n'ont pas de sens.

C'est exactement le problème que l'encapsulation résout.

## Étape 2 : Ajout de l'encapsulation

Pour protéger nos données, nous allons rendre les attributs `private` et ajouter
des getters et setters avec validation.

Modifiez votre fichier `Main.java` pour utiliser cette nouvelle version de
`Book` :

```java
class Book {
    private String title;
    private String author;
    private int pages;
    private double price;

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getPages() { return pages; }
    public double getPrice() { return price; }

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

public class Main {
    public static void main(String[] args) {
        // Créer un livre valide
        Book book = new Book();
        book.setTitle("Java pour débutants");
        book.setAuthor("Alice Dupont");
        book.setPages(350);
        book.setPrice(45.50);

        System.out.println("Livre valide créé:");
        book.displayInfo();

        // Maintenant, essayons de définir des valeurs invalides
        System.out.println("\nTentative avec des valeurs invalides:");
        Book validatedBook = new Book();
        validatedBook.setTitle("");        // Va afficher une erreur
        validatedBook.setPages(-100);      // Va afficher une erreur
        validatedBook.setPrice(-50.0);     // Va afficher une erreur
    }
}
```

Exécutez le programme. **Vous remarquez que** : les tentatives de définir des
valeurs invalides sont maintenant rejetées avec des messages d'erreur clairs.
Nos données sont protégées !

## Étape 3 : Besoin de plusieurs types de documents

Notre bibliothèque grandit. Nous voulons maintenant gérer des magazines et des
DVDs en plus des livres.

Sans héritage, nous aurions trois classes avec beaucoup de code dupliqué :

```java
class Book {
    private String title;
    private String author;
    private int pages;
    private double price;
    // Getters, setters, validation...
}

class Magazine {
    private String title;        // Dupliqué !
    private String author;       // Dupliqué !
    private int pages;           // Dupliqué !
    private double price;        // Dupliqué !
    private int issueNumber;     // Spécifique aux magazines
    // Getters, setters, validation... tous dupliqués !
}

class DVD {
    private String title;        // Dupliqué !
    private String author;       // Dupliqué ! (réalisateur)
    private double price;        // Dupliqué !
    private int durationMinutes; // Spécifique aux DVDs
    // Getters, setters, validation... tous dupliqués !
}
```

**Vous remarquez que** : le code pour `title`, `author`, `price` et toutes leurs
validations est dupliqué trois fois. Si nous voulons changer la validation du
prix, nous devons le faire dans trois endroits différents.

C'est exactement le problème que l'héritage résout.

## Étape 4 : Solution avec l'héritage

Nous allons créer une classe abstraite `Document` qui contient tous les
attributs et méthodes communs, puis nos classes spécifiques hériteront de cette
classe.

Modifiez votre fichier `Main.java` avec ce nouveau code complet :

```java
// Classe abstraite contenant tout le code commun
abstract class Document {
    protected String title;
    protected String author;
    protected double price;

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }

    // Setters avec validation (communs à tous les documents)
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

// Classe Book : hérite de Document
class Book extends Document {
    private int pages;

    public int getPages() { return pages; }

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

// Classe Magazine : hérite de Document
class Magazine extends Document {
    private int issueNumber;

    public int getIssueNumber() { return issueNumber; }

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

// Classe DVD : hérite de Document
class DVD extends Document {
    private int durationMinutes;

    public int getDurationMinutes() { return durationMinutes; }

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

public class Main {
    public static void main(String[] args) {
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
        System.out.println("=== Documents de la bibliothèque ===\n");
        book.displayInfo();
        System.out.println();
        magazine.displayInfo();
        System.out.println();
        dvd.displayInfo();
    }
}
```

Exécutez le programme. **Vous remarquez que** : chaque classe hérite des
attributs et méthodes communs. Le code de validation du titre, de l'auteur et du
prix n'existe plus qu'à un seul endroit dans la classe `Document` !

## Bonus : Polymorphisme

Grâce à l'héritage, nous pouvons traiter tous les documents de manière uniforme.
Ajoutez ce code à la fin de votre `main` :

```java
public class Main {
    public static void main(String[] args) {
        // ... code précédent ...

        // Polymorphisme : traiter tous les documents uniformément
        System.out.println("\n=== Catalogue complet (polymorphisme) ===\n");

        Document[] library = {book, magazine, dvd};

        for (Document doc : library) {
            doc.displayInfo();  // Appelle la bonne méthode selon le type
            System.out.println("---");
        }
    }
}
```

Exécutez le programme. **Vous remarquez que** : nous pouvons stocker différents
types de documents dans un même tableau `Document[]` et appeler `displayInfo()`
sur chacun. Java appelle automatiquement la bonne méthode selon le type réel de
l'objet. C'est le pouvoir du polymorphisme !

## Ce que vous avez accompli

Vous avez construit un système de bibliothèque complet qui :

- **Protège les données** avec l'encapsulation
- **Valide les entrées** pour éviter les états invalides
- **Réutilise le code** avec l'héritage
- **Évite la duplication** en factorisant le code commun
- **Permet l'extension** facile avec de nouveaux types de documents

Ce système illustre les principes fondamentaux de la programmation orientée
objet que vous pourrez appliquer dans tous vos projets.

## Pour aller plus loin

Essayez d'ajouter un nouveau type de document à la bibliothèque :

- Un `AudioBook` (livre audio) avec une durée en minutes
- Un `Newspaper` (journal) avec une date de publication

Vous remarquerez que grâce à l'héritage, ajouter un nouveau type est simple :
vous n'avez qu'à hériter de `Document` et implémenter `displayInfo()`.
