# Programmation orientée objet : Classes et objets - Exercices

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Toutes les informations relatives à ce contenu sont décrites dans le
> [contenu principal](../README.md).

## Table des matières

- [Table des matières](#table-des-matières)
- [Exercices](#exercices)
- [Exercices de complétion](#exercices-de-complétion)
  - [Exercice 1 - Déclaration d'une classe simple](#exercice-1---déclaration-dune-classe-simple)
  - [Exercice 2 - Ajout d'attributs](#exercice-2---ajout-dattributs)
  - [Exercice 3 - Création d'un constructeur](#exercice-3---création-dun-constructeur)
  - [Exercice 4 - Ajout de méthodes](#exercice-4---ajout-de-méthodes)
  - [Exercice 5 - Utilisation du mot-clé `this`](#exercice-5---utilisation-du-mot-clé-this)
- [Exercices de prédiction](#exercices-de-prédiction)
  - [Exercice 6 - Prédiction de sortie avec objets](#exercice-6---prédiction-de-sortie-avec-objets)
  - [Exercice 7 - État d'objets multiples](#exercice-7---état-dobjets-multiples)
- [Exercices de comparaison](#exercices-de-comparaison)
  - [Exercice 8 - Comparaison d'approches d'initialisation](#exercice-8---comparaison-dapproches-dinitialisation)
  - [Exercice 9 - Comparaison de conception de classes](#exercice-9---comparaison-de-conception-de-classes)
- [Exercices de modification](#exercices-de-modification)
  - [Exercice 10 - Ajout d'un constructeur à une classe existante](#exercice-10---ajout-dun-constructeur-à-une-classe-existante)
  - [Exercice 11 - Refactorisation avec `this`](#exercice-11---refactorisation-avec-this)
- [Exercices de transfert](#exercices-de-transfert)
  - [Exercice 12 - Système de gestion de recettes](#exercice-12---système-de-gestion-de-recettes)
  - [Exercice 13 - Application de suivi de dépenses](#exercice-13---application-de-suivi-de-dépenses)
- [Conclusion](#conclusion)

## Exercices

> [!NOTE]
>
> Bien que ces exercices puissent paraître simples et que leur solution est
> disponible dans ce même document, il est fortement recommandé de les réaliser
> sans consulter les solutions au préalable.
>
> Ils ont pour but de vous former et de pratiquer les concepts vus dans le
> contenu de cours.
>
> Il est donc important de les faire par vous-même avant de vérifier vos
> réponses avec les solutions fournies.

## Exercices de complétion

Ces exercices vous permettent de pratiquer la syntaxe et les concepts de base en
complétant du code existant. La difficulté augmente progressivement.

### Exercice 1 - Déclaration d'une classe simple

Vous devez créer une classe `Student` (étudiant) pour représenter les personnes
qui étudient dans un programme universitaire.

Complétez le code suivant :

```java
// TODO: Déclarez une classe publique nommée Student


    // Le corps de la classe sera ajouté dans les exercices suivants

```

**Résultat attendu** : Une déclaration de classe valide qui peut être compilée.

<details>
<summary>Indice</summary>

En Java, une classe se déclare avec le mot-clé `class` précédé de `public` pour
qu'elle soit accessible partout. Le nom de la classe commence par une majuscule.

Syntaxe : `public class NomClasse { }`

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class Student {
    // Le corps de la classe sera ajouté dans les exercices suivants
}
```

**Explication** : La déclaration `public class Student` crée une nouvelle classe
nommée `Student` accessible depuis n'importe où dans le programme. Les accolades
`{ }` délimitent le corps de la classe.

</details>

### Exercice 2 - Ajout d'attributs

Complétez la classe `Student` en ajoutant les attributs suivants :

- `name` : le nom de la personne qui étudie (String)
- `studentId` : le numéro d'identification (int)
- `major` : la filière d'études (String)
- `creditsEarned` : le nombre de crédits obtenus (int)

```java
public class Student {
    // TODO: Déclarez les quatre attributs




}
```

**Résultat attendu** : Une classe avec quatre attributs correctement déclarés.

<details>
<summary>Afficher la solution</summary>

```java
public class Student {
    String name;
    int studentId;
    String major;
    int creditsEarned;
}
```

**Explication** : Les attributs sont déclarés avec leur type (`String` pour le
texte, `int` pour les nombres entiers). Chaque attribut peut ensuite stocker une
valeur spécifique pour chaque objet `Student` créé.

</details>

### Exercice 3 - Création d'un constructeur

Ajoutez un constructeur à la classe `Student` qui initialise tous les attributs.

```java
public class Student {
    String name;
    int studentId;
    String major;
    int creditsEarned;

    // TODO: Créez un constructeur public qui prend 4 paramètres
    // (name, studentId, major, creditsEarned) et initialise les attributs




}
```

**Résultat attendu** : Un constructeur permettant de créer un objet `Student`
avec toutes les informations nécessaires.

<details>
<summary>Indice</summary>

Un constructeur porte le même nom que la classe et n'a pas de type de retour.
Utilisez `this.attribut = parametre` pour initialiser chaque attribut.

Syntaxe : `public NomClasse(parametres) { this.attribut = parametre; }`

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class Student {
    String name;
    int studentId;
    String major;
    int creditsEarned;

    public Student(String name, int studentId, String major, int creditsEarned) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.creditsEarned = creditsEarned;
    }
}
```

**Explication** : Le constructeur `Student` prend quatre paramètres et utilise
`this` pour différencier les attributs de l'instance des paramètres du
constructeur. Maintenant, on peut créer un objet avec
`new Student("Alice", 12345, "Informatique", 60)`.

</details>

### Exercice 4 - Ajout de méthodes

Ajoutez deux méthodes à la classe `Student` :

1. `displayInfo()` : affiche toutes les informations de la personne qui étudie
2. `addCredits(int credits)` : ajoute des crédits au total

```java
public class Student {
    String name;
    int studentId;
    String major;
    int creditsEarned;

    public Student(String name, int studentId, String major, int creditsEarned) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.creditsEarned = creditsEarned;
    }

    // TODO: Créez une méthode displayInfo() qui affiche toutes les infos



    // TODO: Créez une méthode addCredits(int credits) qui ajoute des crédits


}
```

**Résultat attendu** :

- `displayInfo()` affiche :
  `"Nom: Alice, ID: 12345, Filière: Informatique, Crédits: 60"`
- `addCredits(5)` augmente `creditsEarned` de 5

<details>
<summary>Indice</summary>

- Pour `displayInfo()` : utilisez `System.out.println()` avec concaténation
- Pour `addCredits()` : utilisez `creditsEarned = creditsEarned + credits` ou
  `creditsEarned += credits`

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class Student {
    String name;
    int studentId;
    String major;
    int creditsEarned;

    public Student(String name, int studentId, String major, int creditsEarned) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.creditsEarned = creditsEarned;
    }

    void displayInfo() {
        System.out.println("Nom: " + name + ", ID: " + studentId +
                           ", Filière: " + major + ", Crédits: " + creditsEarned);
    }

    void addCredits(int credits) {
        creditsEarned = creditsEarned + credits;
    }
}
```

**Explication** :

- `displayInfo()` utilise `System.out.println()` avec l'opérateur `+` pour
  concaténer les chaînes et les valeurs des attributs
- `addCredits()` modifie l'attribut `creditsEarned` en y ajoutant la valeur du
  paramètre `credits`

</details>

### Exercice 5 - Utilisation du mot-clé `this`

Modifiez la méthode `addCredits()` pour qu'elle utilise explicitement `this` et
ajoutez une méthode `updateMajor(String major)` qui change la filière d'études.

```java
public class Student {
    String name;
    int studentId;
    String major;
    int creditsEarned;

    public Student(String name, int studentId, String major, int creditsEarned) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.creditsEarned = creditsEarned;
    }

    void displayInfo() {
        System.out.println("Nom: " + name + ", ID: " + studentId +
                           ", Filière: " + major + ", Crédits: " + creditsEarned);
    }

    void addCredits(int credits) {
        // TODO: Modifiez pour utiliser this.creditsEarned

    }

    // TODO: Créez updateMajor(String major) qui utilise this


}
```

**Résultat attendu** : Les deux méthodes utilisent `this` pour clarifier qu'on
modifie les attributs de l'instance courante.

<details>
<summary>Indice</summary>

Utilisez `this.attribut` pour référencer explicitement l'attribut de l'instance,
surtout quand le paramètre a le même nom.

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class Student {
    String name;
    int studentId;
    String major;
    int creditsEarned;

    public Student(String name, int studentId, String major, int creditsEarned) {
        this.name = name;
        this.studentId = studentId;
        this.major = major;
        this.creditsEarned = creditsEarned;
    }

    void displayInfo() {
        System.out.println("Nom: " + name + ", ID: " + studentId +
                           ", Filière: " + major + ", Crédits: " + creditsEarned);
    }

    void addCredits(int credits) {
        this.creditsEarned = this.creditsEarned + credits;
    }

    void updateMajor(String major) {
        this.major = major;
    }
}
```

**Explication** : L'utilisation de `this` est particulièrement importante dans
`updateMajor()` où le paramètre `major` a le même nom que l'attribut. Sans
`this`, l'assignation `major = major` ne ferait rien (elle assignerait le
paramètre à lui-même).

</details>

## Exercices de prédiction

Ces exercices développent votre capacité à anticiper le résultat d'un programme
sans l'exécuter.

### Exercice 6 - Prédiction de sortie avec objets

Prédisez la sortie du programme suivant :

```java
public class Rectangle {
    int width;
    int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    int calculateArea() {
        return width * height;
    }

    void displayInfo() {
        System.out.println("Rectangle: " + width + "x" + height +
                           " (aire: " + calculateArea() + ")");
    }
}

public class Main {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(5, 3);
        Rectangle r2 = new Rectangle(10, 2);

        r1.displayInfo();
        r2.displayInfo();

        r1.width = 8;
        r1.displayInfo();
    }
}
```

**Question** : Quelle sera la sortie exacte du programme ?

<details>
<summary>Afficher la solution</summary>

**Sortie** :

```
Rectangle: 5x3 (aire: 15)
Rectangle: 10x2 (aire: 20)
Rectangle: 8x3 (aire: 24)
```

**Explication détaillée** :

1. `Rectangle r1 = new Rectangle(5, 3)` crée un rectangle avec `width=5` et
   `height=3`
2. `Rectangle r2 = new Rectangle(10, 2)` crée un rectangle avec `width=10` et
   `height=2`
3. `r1.displayInfo()` affiche `"Rectangle: 5x3 (aire: 15)"` car `5 * 3 = 15`
4. `r2.displayInfo()` affiche `"Rectangle: 10x2 (aire: 20)"` car `10 * 2 = 20`
5. `r1.width = 8` modifie la largeur de `r1` à 8 (la hauteur reste 3)
6. `r1.displayInfo()` affiche maintenant `"Rectangle: 8x3 (aire: 24)"` car
   `8 * 3 = 24`

**Points clés** :

- Chaque objet (`r1` et `r2`) a ses propres valeurs d'attributs
- Modifier `r1.width` n'affecte pas `r2`
- `calculateArea()` utilise toujours les valeurs actuelles des attributs

</details>

### Exercice 7 - État d'objets multiples

Analysez le code suivant et prédisez l'état final des objets :

```java
public class BankAccount {
    String owner;
    double balance;

    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        this.balance = initialBalance;
    }

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    void displayBalance() {
        System.out.println(owner + ": " + balance + " CHF");
    }
}

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount("Alice", 1000.0);
        BankAccount account2 = new BankAccount("Bob", 500.0);

        account1.deposit(200.0);
        account2.withdraw(100.0);
        account1.withdraw(50.0);

        account1.displayBalance();
        account2.displayBalance();
    }
}
```

**Questions** :

1. Quel sera le solde final d'Alice ?
2. Quel sera le solde final de Bob ?
3. Quelle sera la sortie exacte du programme ?

<details>
<summary>Afficher la solution</summary>

**Réponses** :

1. Le solde final d'Alice : **1150.0 CHF**
   - Initial : 1000.0
   - Après deposit(200.0) : 1200.0
   - Après withdraw(50.0) : 1150.0

2. Le solde final de Bob : **400.0 CHF**
   - Initial : 500.0
   - Après withdraw(100.0) : 400.0

3. **Sortie du programme** :

   ```bashg
   Alice: 1150.0 CHF
   Bob: 400.0 CHF
   ```

**Explication** : Chaque objet `BankAccount` maintient son propre état (owner et
balance). Les opérations sur `account1` n'affectent pas `account2` et vice
versa. C'est le principe d'encapsulation : chaque objet gère ses propres
données.

</details>

## Exercices de comparaison

Ces exercices vous aident à évaluer différentes approches et à choisir la
meilleure solution.

### Exercice 8 - Comparaison d'approches d'initialisation

Comparez les deux approches suivantes pour créer et initialiser un objet :

**Approche A** :

```java
public class Product {
    String name;
    double price;
    int stock;
}

// Utilisation
Product p = new Product();
p.name = "Laptop";
p.price = 999.99;
p.stock = 10;
```

**Approche B** :

```java
public class Product {
    String name;
    double price;
    int stock;

    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}

// Utilisation
Product p = new Product("Laptop", 999.99, 10);
```

**Questions** :

1. Quels sont les avantages et inconvénients de chaque approche ?
2. Quelle approche est préférable et pourquoi ?
3. Dans quels cas pourrait-on utiliser l'approche A ?

<details>
<summary>Afficher la solution</summary>

**Comparaison** :

| Critère         | Approche A (sans constructeur)               | Approche B (avec constructeur)                    |
| --------------- | -------------------------------------------- | ------------------------------------------------- |
| **Simplicité**  | Plus simple à écrire                         | Nécessite un constructeur                         |
| **Sûreté**      | Risque d'oublier d'initialiser un attribut   | Garantit que tous les attributs sont initialisés  |
| **Lisibilité**  | 4 lignes pour créer un objet                 | 1 ligne pour créer un objet complet               |
| **Maintenance** | Difficile de changer les attributs requis    | Le constructeur documente les données nécessaires |
| **Erreurs**     | Objets potentiellement dans un état invalide | Objets toujours dans un état valide               |

**Réponses détaillées** :

1. **Avantages et inconvénients** :
   - **Approche A** :
     - Plus rapide à écrire pour un prototype
     - Flexible (on peut ne définir que certains attributs)
     - Risque d'oublier d'initialiser un attribut
     - Code plus verbeux
     - Objets potentiellement incomplets

   - **Approche B** :
     - Force l'initialisation complète
     - Code plus concis à l'utilisation
     - Meilleure documentation du code
     - Moins d'erreurs potentielles
     - Nécessite d'écrire le constructeur

2. **Approche préférable** : **L'approche B avec constructeur** est généralement
   préférable car :
   - Elle garantit que les objets sont toujours créés dans un état valide
   - Elle rend le code plus robuste et moins sujet aux erreurs
   - Elle documente clairement quelles données sont nécessaires
   - Elle facilite la maintenance à long terme

3. **Cas d'utilisation de l'approche A** :
   - Prototypage rapide ou tests temporaires
   - Classes de données très simples avec des valeurs par défaut acceptables
   - Situations où tous les attributs ne sont pas toujours nécessaires
   - **Note** : Même dans ces cas, un constructeur reste souvent préférable

**Conclusion** : Utilisez toujours des constructeurs pour les classes
importantes de votre application. L'approche sans constructeur devrait être
réservée à des cas très spécifiques ou temporaires.

</details>

### Exercice 9 - Comparaison de conception de classes

Comparez les deux conceptions suivantes pour une classe `Circle` :

**Conception A** :

```java
public class Circle {
    double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    double getArea() {
        return 3.14159 * radius * radius;
    }

    double getCircumference() {
        return 2 * 3.14159 * radius;
    }
}
```

**Conception B** :

```java
public class Circle {
    double radius;
    double area;
    double circumference;

    public Circle(double radius) {
        this.radius = radius;
        this.area = 3.14159 * radius * radius;
        this.circumference = 2 * 3.14159 * radius;
    }
}
```

**Questions** :

1. Quelles sont les différences fondamentales entre ces conceptions ?
2. Que se passe-t-il si on modifie le rayon après création ?
3. Quelle conception est préférable et pourquoi ?

<details>
<summary>Afficher la solution</summary>

**Analyse des conceptions** :

**Différences fondamentales** :

| Aspect          | Conception A (calculée)                         | Conception B (stockée)                      |
| --------------- | ----------------------------------------------- | ------------------------------------------- |
| **Stockage**    | Stocke uniquement `radius`                      | Stocke `radius`, `area`, et `circumference` |
| **Calcul**      | Calcule l'aire et la circonférence à la demande | Calcule une seule fois à la création        |
| **Mémoire**     | Moins de mémoire (1 attribut)                   | Plus de mémoire (3 attributs)               |
| **Performance** | Recalcule à chaque appel                        | Accès immédiat aux valeurs                  |
| **Cohérence**   | Toujours à jour                                 | Peut devenir incohérent                     |

**2. Modification du rayon** :

**Conception A** :

```java
Circle c = new Circle(5.0);
System.out.println(c.getArea());  // 78.53975
c.radius = 10.0;
System.out.println(c.getArea());  // 314.159 Correct
```

**Conception B** :

```java
Circle c = new Circle(5.0);
System.out.println(c.area);  // 78.53975
c.radius = 10.0;
System.out.println(c.area);  // 78.53975 Incohérent !
```

Dans la conception B, modifier le rayon ne met pas à jour l'aire et la
circonférence, créant une incohérence dangereuse.

**3. Conception préférable** :

**La Conception A est clairement préférable** car :

1. **Cohérence garantie** : L'aire et la circonférence sont toujours calculées à
   partir du rayon actuel
2. **Moins de mémoire** : Ne stocke que les données essentielles
3. **Plus simple** : Moins d'attributs à maintenir
4. **Plus robuste** : Impossible d'avoir des valeurs incohérentes
5. **Coût de calcul négligeable** : Les calculs sont simples et rapides

**Principe important** : **Ne stockez pas de valeurs dérivées** (qui peuvent
être calculées à partir d'autres) car cela crée des risques incohérence.
Préférez calculer ces valeurs à la demande.

**Exception** : Si les calculs sont très coûteux et effectués très fréquemment,
on peut envisager de stocker les résultats (technique appelée "mise en cache" ou
"memoization"), mais cela nécessite de gérer la synchronisation quand les
données changent.

</details>

## Exercices de modification

Ces exercices demandent de modifier du code existant pour améliorer sa qualité
ou ajouter des fonctionnalités.

### Exercice 10 - Ajout d'un constructeur à une classe existante

Voici une classe `Book` sans constructeur. Modifiez-la pour ajouter un
constructeur approprié et testez-la.

**Code initial** :

```java
public class Book {
    String title;
    String author;
    int pages;
    boolean isAvailable;

    void displayInfo() {
        System.out.println(title + " par " + author + " (" + pages + " pages)");
        System.out.println("Disponible: " + (isAvailable ? "Oui" : "Non"));
    }

    void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Livre emprunté avec succès");
        } else {
            System.out.println("Livre non disponible");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println("Livre retourné");
    }
}
```

**Tâches** :

1. Ajoutez un constructeur qui initialise tous les attributs
2. Faites que le livre soit disponible par défaut lors de la création
3. Créez une classe `Main` pour tester votre code

<details>
<summary>Afficher la solution</summary>

**Code modifié** :

```java
public class Book {
    String title;
    String author;
    int pages;
    boolean isAvailable;

    // Constructeur ajouté
    public Book(String title, String author, int pages) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.isAvailable = true;  // Disponible par défaut
    }

    void displayInfo() {
        System.out.println(title + " par " + author + " (" + pages + " pages)");
        System.out.println("Disponible: " + (isAvailable ? "Oui" : "Non"));
    }

    void borrow() {
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Livre emprunté avec succès");
        } else {
            System.out.println("Livre non disponible");
        }
    }

    void returnBook() {
        isAvailable = true;
        System.out.println("Livre retourné");
    }
}

// Classe de test
public class Main {
    public static void main(String[] args) {
        // Création de livres
        Book book1 = new Book("1984", "George Orwell", 328);
        Book book2 = new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 96);

        // Test des fonctionnalités
        book1.displayInfo();
        book1.borrow();
        book1.displayInfo();
        book1.borrow();  // Devrait afficher "non disponible"
        book1.returnBook();
        book1.displayInfo();

        System.out.println("\n---\n");

        book2.displayInfo();
    }
}
```

**Sortie attendue** :

```bash
1984 par George Orwell (328 pages)
Disponible: Oui
Livre emprunté avec succès
1984 par George Orwell (328 pages)
Disponible: Non
Livre non disponible
Livre retourné
1984 par George Orwell (328 pages)
Disponible: Oui

---

Le Petit Prince par Antoine de Saint-Exupéry (96 pages)
Disponible: Oui
```

**Explications des modifications** :

1. **Constructeur ajouté** : Prend trois paramètres (title, author, pages) et
   initialise `isAvailable` à `true` automatiquement
2. **Initialisation par défaut** : Le livre est toujours disponible à la
   création, ce qui est logique pour un nouveau livre dans le système
3. **Classe de test** : Démontre la création de livres et l'utilisation de
   toutes les méthodes

**Avantages de cette modification** :

- Impossible de créer un livre sans titre, auteur ou nombre de pages
- Le code est plus concis et plus sûr
- La valeur par défaut de `isAvailable` est documentée dans le constructeur

</details>

### Exercice 11 - Refactorisation avec `this`

Le code suivant fonctionne mais manque de clarté. Refactorisez-le pour utiliser
`this` de manière appropriée.

**Code initial** :

```java
public class Temperature {
    double celsius;

    public Temperature(double c) {
        celsius = c;
    }

    void setCelsius(double c) {
        celsius = c;
    }

    double getCelsius() {
        return celsius;
    }

    double getFahrenheit() {
        return celsius * 9.0 / 5.0 + 32;
    }

    void displayTemperatures() {
        System.out.println("Température: " + getCelsius() + "°C (" +
                           getFahrenheit() + "°F)");
    }
}
```

**Tâches** :

1. Utilisez des noms de paramètres plus clairs (pas `c`)
2. Utilisez systématiquement `this` pour accéder aux attributs et méthodes
3. Le code doit rester fonctionnellement identique

<details>
<summary>Afficher la solution</summary>

**Code refactorisé** :

```java
public class Temperature {
    double celsius;

    public Temperature(double celsius) {
        this.celsius = celsius;
    }

    void setCelsius(double celsius) {
        this.celsius = celsius;
    }

    double getCelsius() {
        return this.celsius;
    }

    double getFahrenheit() {
        return this.celsius * 9.0 / 5.0 + 32;
    }

    void displayTemperatures() {
        System.out.println("Température: " + this.getCelsius() + "°C (" +
                           this.getFahrenheit() + "°F)");
    }
}
```

**Améliorations apportées** :

1. **Noms de paramètres clairs** : `celsius` au lieu de `c` rend le code plus
   lisible et compréhensible

2. **Utilisation de `this`** :
   - Dans le constructeur et `setCelsius()` : **obligatoire** pour distinguer le
     paramètre de l'attribut
   - Dans `getCelsius()` et `getFahrenheit()` : **recommandé** pour la clarté,
     indique explicitement qu'on accède à l'attribut
   - Dans `displayTemperatures()` : **recommandé** quand on appelle d'autres
     méthodes de l'instance

3. **Cohérence** : L'utilisation systématique de `this` rend le code plus
   uniforme et plus facile à comprendre

**Exemple d'utilisation** :

```java
public class Main {
    public static void main(String[] args) {
        Temperature temp = new Temperature(25.0);
        temp.displayTemperatures();

        temp.setCelsius(0.0);
        temp.displayTemperatures();

        temp.setCelsius(100.0);
        temp.displayTemperatures();
    }
}
```

**Sortie** :

```
Température: 25.0°C (77.0°F)
Température: 0.0°C (32.0°F)
Température: 100.0°C (212.0°F)
```

**Note importante** : L'utilisation de `this` dans les getters (`getCelsius()`)
n'est pas strictement obligatoire car il n'y a pas d'ambiguïté, mais c'est une
bonne pratique qui améliore la lisibilité et la cohérence du code.

</details>

## Exercices de transfert

Ces exercices vous demandent d'appliquer les concepts appris à de nouveaux
contextes.

### Exercice 12 - Système de gestion de recettes

Créez un système pour gérer des recettes de cuisine avec les spécifications
suivantes :

**Classe `Recipe` (Recette)** :

- Attributs :
  - `name` (String) : nom de la recette
  - `servings` (int) : nombre de portions
  - `prepTimeMinutes` (int) : temps de préparation en minutes
  - `difficulty` (String) : niveau de difficulté ("Facile", "Moyen",
    "Difficile")

- Constructeur :
  - Initialise tous les attributs

- Méthodes :
  - `displayRecipe()` : affiche toutes les informations de la recette
  - `adjustServings(int newServings)` : modifie le nombre de portions
  - `getTotalTimeMinutes()` : retourne le temps total (préparation + 30 minutes
    de cuisson par défaut)

**Programme de test** :

- Créez au moins 2 recettes différentes
- Affichez leurs informations
- Ajustez le nombre de portions d'une recette
- Affichez le temps total pour chaque recette

<details>
<summary>Indice</summary>

1. Commencez par déclarer la classe avec ses attributs
2. Créez le constructeur en utilisant `this`
3. Implémentez chaque méthode une par une
4. Testez chaque méthode individuellement avant de passer à la suivante

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class Recipe {
    String name;
    int servings;
    int prepTimeMinutes;
    String difficulty;

    public Recipe(String name, int servings, int prepTimeMinutes, String difficulty) {
        this.name = name;
        this.servings = servings;
        this.prepTimeMinutes = prepTimeMinutes;
        this.difficulty = difficulty;
    }

    void displayRecipe() {
        System.out.println("=== " + name + " ===");
        System.out.println("Portions: " + servings);
        System.out.println("Temps de préparation: " + prepTimeMinutes + " minutes");
        System.out.println("Temps total: " + getTotalTimeMinutes() + " minutes");
        System.out.println("Difficulté: " + difficulty);
    }

    void adjustServings(int newServings) {
        System.out.println("Ajustement des portions de " + servings +
                           " à " + newServings);
        servings = newServings;
    }

    int getTotalTimeMinutes() {
        return prepTimeMinutes + 30;  // +30 minutes de cuisson
    }
}

public class Main {
    public static void main(String[] args) {
        // Création de recettes
        Recipe pasta = new Recipe("Pâtes carbonara", 4, 15, "Facile");
        Recipe cake = new Recipe("Gâteau au chocolat", 8, 25, "Moyen");

        // Affichage des recettes
        pasta.displayRecipe();
        System.out.println();
        cake.displayRecipe();

        // Ajustement des portions
        System.out.println("\n--- Ajustement ---\n");
        pasta.adjustServings(6);
        pasta.displayRecipe();
    }
}
```

**Sortie attendue** :

```
=== Pâtes carbonara ===
Portions: 4
Temps de préparation: 15 minutes
Temps total: 45 minutes
Difficulté: Facile

=== Gâteau au chocolat ===
Portions: 8
Temps de préparation: 25 minutes
Temps total: 55 minutes
Difficulté: Moyen

--- Ajustement ---

Ajustement des portions de 4 à 6
=== Pâtes carbonara ===
Portions: 6
Temps de préparation: 15 minutes
Temps total: 45 minutes
Difficulté: Facile
```

**Points clés de la solution** :

1. **Structure claire** : La classe `Recipe` encapsule toutes les données et
   comportements liés à une recette

2. **Constructeur complet** : Force l'initialisation de toutes les données
   nécessaires

3. **Méthode calculée** : `getTotalTimeMinutes()` calcule le temps à la demande
   plutôt que de stocker une valeur

4. **Modification d'état** : `adjustServings()` modifie l'état de l'objet et
   affiche un message informatif

5. **Séparation des responsabilités** : La classe `Recipe` gère les recettes, la
   classe `Main` gère l'interaction

**Extensions possibles** :

- Ajouter un attribut `cookTimeMinutes` variable
- Créer une méthode `scaleIngredients()` qui calcule les quantités ajustées
- Ajouter une liste d'ingrédients
- Implémenter une méthode `isQuickMeal()` qui retourne `true` si temps total <
  30 min

</details>

### Exercice 13 - Application de suivi de dépenses

Développez une application simple pour suivre des dépenses personnelles.

**Classe `Expense` (Dépense)** :

- Attributs :
  - `description` (String) : description de la dépense
  - `amount` (double) : montant en CHF
  - `category` (String) : catégorie ("Nourriture", "Transport", "Loisirs", etc.)
  - `date` (String) : date au format "DD.MM.YYYY"

- Constructeur :
  - Initialise tous les attributs

- Méthodes :
  - `displayExpense()` : affiche les détails de la dépense
  - `isMajorExpense()` : retourne `true` si le montant > 100 CHF
  - `updateAmount(double newAmount)` : modifie le montant

**Classe `ExpenseTracker`** :

- Attributs :
  - `totalExpenses` (double) : total des dépenses
  - `numberOfExpenses` (int) : nombre de dépenses

- Constructeur :
  - Initialise les compteurs à 0

- Méthodes :
  - `addExpense(Expense expense)` : ajoute une dépense aux totaux
  - `displaySummary()` : affiche le résumé (total et nombre)
  - `getAverageExpense()` : retourne la dépense moyenne

**Programme de test** :

- Créez un `ExpenseTracker`
- Créez et ajoutez au moins 4 dépenses de différentes catégories
- Affichez chaque dépense
- Affichez le résumé

<details>
<summary>Indice</summary>

1. Créez d'abord la classe `Expense` complète
2. Testez `Expense` avec quelques objets
3. Créez ensuite la classe `ExpenseTracker`
4. Dans `addExpense`, mettez à jour `totalExpenses` et `numberOfExpenses`
5. Pour la moyenne, divisez le total par le nombre (attention à la division par
   zéro!)

</details>

<details>
<summary>Afficher la solution</summary>

```java
public class Expense {
    String description;
    double amount;
    String category;
    String date;

    public Expense(String description, double amount, String category, String date) {
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    void displayExpense() {
        System.out.println("[" + category + "] " + description);
        System.out.println("  Montant: " + amount + " CHF");
        System.out.println("  Date: " + date);
        if (isMajorExpense()) {
            System.out.println("  ⚠️  Dépense importante");
        }
    }

    boolean isMajorExpense() {
        return amount > 100.0;
    }

    void updateAmount(double newAmount) {
        System.out.println("Mise à jour du montant de " + amount +
                           " CHF à " + newAmount + " CHF");
        amount = newAmount;
    }
}

public class ExpenseTracker {
    double totalExpenses;
    int numberOfExpenses;

    public ExpenseTracker() {
        totalExpenses = 0.0;
        numberOfExpenses = 0;
    }

    void addExpense(Expense expense) {
        totalExpenses += expense.amount;
        numberOfExpenses++;
        System.out.println("✓ Dépense ajoutée: " + expense.description);
    }

    void displaySummary() {
        System.out.println("\n=== RÉSUMÉ DES DÉPENSES ===");
        System.out.println("Nombre de dépenses: " + numberOfExpenses);
        System.out.println("Total: " + totalExpenses + " CHF");
        if (numberOfExpenses > 0) {
            System.out.println("Moyenne: " + getAverageExpense() + " CHF");
        }
    }

    double getAverageExpense() {
        if (numberOfExpenses == 0) {
            return 0.0;
        }
        return totalExpenses / numberOfExpenses;
    }
}

public class Main {
    public static void main(String[] args) {
        // Création du tracker
        ExpenseTracker tracker = new ExpenseTracker();

        // Création des dépenses
        Expense groceries = new Expense("Courses hebdomadaires", 85.50,
                                        "Nourriture", "20.02.2026");
        Expense transport = new Expense("Abonnement CFF", 150.00,
                                       "Transport", "01.02.2026");
        Expense coffee = new Expense("Café au restaurant", 4.50,
                                    "Loisirs", "21.02.2026");
        Expense cinema = new Expense("Cinéma avec amis", 25.00,
                                    "Loisirs", "22.02.2026");

        // Ajout et affichage des dépenses
        tracker.addExpense(groceries);
        groceries.displayExpense();
        System.out.println();

        tracker.addExpense(transport);
        transport.displayExpense();
        System.out.println();

        tracker.addExpense(coffee);
        coffee.displayExpense();
        System.out.println();

        tracker.addExpense(cinema);
        cinema.displayExpense();

        // Affichage du résumé
        tracker.displaySummary();

        // Test de modification
        System.out.println("\n--- Modification ---\n");
        groceries.updateAmount(95.75);
        groceries.displayExpense();
    }
}
```

**Sortie attendue** :

```
✓ Dépense ajoutée: Courses hebdomadaires
[Nourriture] Courses hebdomadaires
  Montant: 85.5 CHF
  Date: 20.02.2026

✓ Dépense ajoutée: Abonnement CFF
[Transport] Abonnement CFF
  Montant: 150.0 CHF
  Date: 01.02.2026
  ⚠️  Dépense importante

✓ Dépense ajoutée: Café au restaurant
[Loisirs] Café au restaurant
  Montant: 4.5 CHF
  Date: 21.02.2026

✓ Dépense ajoutée: Cinéma avec amis
[Loisirs] Cinéma avec amis
  Montant: 25.0 CHF
  Date: 22.02.2026

=== RÉSUMÉ DES DÉPENSES ===
Nombre de dépenses: 4
Total: 265.0 CHF
Moyenne: 66.25 CHF

--- Modification ---

Mise à jour du montant de 85.5 CHF à 95.75 CHF
[Nourriture] Courses hebdomadaires
  Montant: 95.75 CHF
  Date: 20.02.2026
```

**Points clés de la solution** :

1. **Classe `Expense`** :
   - Encapsule toutes les données d'une dépense
   - `isMajorExpense()` fournit une logique métier utile
   - `displayExpense()` présente les informations de manière lisible

2. **Classe `ExpenseTracker`** :
   - Maintient l'état global (total et compteur)
   - `addExpense()` met à jour automatiquement les totaux
   - `getAverageExpense()` gère le cas de la division par zéro

3. **Séparation des responsabilités** :
   - `Expense` gère une dépense individuelle
   - `ExpenseTracker` gère l'agrégation et les statistiques
   - `Main` orchestre l'application

4. **Bonnes pratiques** :
   - Constructeurs complets
   - Méthodes cohésives (une responsabilité par méthode)
   - Gestion des cas limites (division par zéro)
   - Messages utilisateur informatifs

**Extensions possibles** :

- Ajouter une méthode `getTotalByCategory(String category)` dans
  `ExpenseTracker`
- Créer une méthode `getMostExpensiveCategory()`
- Ajouter une liste de dépenses dans `ExpenseTracker` pour garder l'historique
- Implémenter une méthode `removeExpense(Expense expense)`

**Note importante** : Cette solution montre comment deux classes peuvent
collaborer pour créer un système plus complexe. `ExpenseTracker` utilise des
objets `Expense` sans les modifier, ce qui est une bonne pratique de conception.

</details>

---

## Conclusion

Ces exercices couvrent les concepts fondamentaux de la programmation orientée
objet :

- Déclaration de classes et d'attributs
- Création de constructeurs
- Implémentation de méthodes
- Utilisation du mot-clé `this`
- Instanciation et manipulation d'objets
- Conception de classes cohérentes

Pour aller plus loin, pratiquez en créant vos propres classes pour modéliser des
objets du monde réel : vélos, smartphones, comptes utilisateur, etc.

N'hésitez pas à consulter le [contenu principal du cours](../README.md) et le
[mini-projet](../03-mini-projet/) pour approfondir ces concepts.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
