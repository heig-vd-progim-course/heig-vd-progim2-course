# Le modificateur protected

## Objectif

Comprendre le modificateur d'accès `protected` et son rôle dans l'héritage :
permettre l'accès aux attributs dans les sous-classes tout en les masquant au
reste du code.

## Concept illustré

Le modificateur `protected` permet de :

- Donner accès aux attributs aux sous-classes
- Maintenir l'encapsulation vis-à-vis des autres classes
- Faciliter la réutilisation du code dans une hiérarchie de classes
- Offrir un compromis entre `private` et `public`

## Les quatre modificateurs d'accès

| Modificateur | Même classe | Même package | Sous-classe | Autre classe |
| :----------- | :---------: | :----------: | :---------: | :----------: |
| `private`    |      ✓      |              |             |              |
| (par défaut) |      ✓      |      ✓       |             |              |
| `protected`  |      ✓      |      ✓       |      ✓      |              |
| `public`     |      ✓      |      ✓       |      ✓      |      ✓       |

## Code complet

Créez un fichier `Main.java` avec le code suivant :

```java
// Classe parent avec différents modificateurs d'accès
class Vehicle {
    private String vin;              // Privé : uniquement dans Vehicle
    protected String brand;          // Protected : accessible dans les sous-classes
    public String model;             // Public : accessible partout

    public Vehicle(String vin, String brand, String model) {
        this.vin = vin;
        this.brand = brand;
        this.model = model;
    }

    protected void displayVin() {
        System.out.println("VIN: " + vin);
    }

    public void displayInfo() {
        displayVin();
        System.out.println("Marque: " + brand);
        System.out.println("Modèle: " + model);
    }
}

// Sous-classe : Car
class Car extends Vehicle {
    private int numberOfDoors;

    public Car(String vin, String brand, String model, int numberOfDoors) {
        super(vin, brand, model);
        this.numberOfDoors = numberOfDoors;
    }

    // Peut accéder aux attributs protected du parent
    public void displayBrandUpperCase() {
        // brand est accessible car il est protected
        System.out.println("Marque (majuscules): " + brand.toUpperCase());
    }

    public void testAccess() {
        System.out.println("=== Test d'accès depuis la sous-classe ===");

        // OK: model est public
        System.out.println("Accès à model (public): " + model);

        // OK: brand est protected
        System.out.println("Accès à brand (protected): " + brand);

        // ERREUR: vin est private (décommentez pour voir l'erreur)
        // System.out.println("Accès à vin (private): " + vin);

        // OK: displayVin() est protected
        displayVin();
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Nombre de portes: " + numberOfDoors);
    }
}

// Sous-classe : Motorcycle
class Motorcycle extends Vehicle {
    private String type;  // sportive, touring, etc.

    public Motorcycle(String vin, String brand, String model, String type) {
        super(vin, brand, model);
        this.type = type;
    }

    // Utilise l'attribut protected pour personnaliser l'affichage
    public void displayCustomInfo() {
        // Accès direct à brand (protected)
        System.out.println(brand + " " + model + " (" + type + ")");
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: " + type);
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car("VIN123456", "Tesla", "Model 3", 4);
        Motorcycle moto = new Motorcycle("VIN789012", "Harley-Davidson", "Street 750", "Cruiser");

        System.out.println("=== Voiture ===");
        car.displayInfo();
        car.displayBrandUpperCase();  // Utilise brand (protected)
        System.out.println();

        System.out.println("=== Moto ===");
        moto.displayInfo();
        moto.displayCustomInfo();  // Utilise brand (protected)
        System.out.println();

        // Test d'accès depuis la sous-classe
        car.testAccess();
        System.out.println();

        // Depuis Main (classe externe), test des accès
        System.out.println("=== Test d'accès depuis une classe externe ===");

        // OK: model est public
        System.out.println("Accès à car.model (public): " + car.model);

        // ERREUR: brand est protected (décommentez pour voir l'erreur)
        // System.out.println("Accès à car.brand (protected): " + car.brand);

        // ERREUR: vin est private (décommentez pour voir l'erreur)
        // System.out.println("Accès à car.vin (private): " + car.vin);
    }
}
```

<details>
<summary>Description du code</summary>

Déclaration de la classe `Vehicle` avec trois attributs ayant des modificateurs
différents : `private String vin` (accessible uniquement dans `Vehicle`),
`protected String brand` (accessible dans `Vehicle` et ses sous-classes),
`public String model` (accessible partout).

Définition du constructeur qui initialise les trois attributs.

Déclaration de la méthode `protected void displayVin()` qui affiche le VIN.
Cette méthode est accessible dans les sous-classes.

Déclaration de la méthode `public void displayInfo()` qui appelle `displayVin()`
et affiche les autres informations.

Déclaration de la classe `Car` qui hérite de `Vehicle` avec `extends`.

Ajout d'un attribut privé `numberOfDoors` et constructeur appelant
`super(vin, brand, model)`.

Déclaration de la méthode `displayBrandUpperCase()` qui accède directement à
l'attribut `protected brand` du parent et appelle `toUpperCase()`.

Déclaration de la méthode `testAccess()` qui teste les différents niveaux
d'accès : `model` (public, accessible), `brand` (protected, accessible), `vin`
(private, ligne commentée car inaccessible).

Appel de `displayVin()` qui est une méthode `protected` donc accessible dans la
sous-classe.

Redéfinition de `displayInfo()` avec `@Override`, appelant `super.displayInfo()`
puis affichant le nombre de portes.

Déclaration de la classe `Motorcycle` héritant de `Vehicle`.

Déclaration de la méthode `displayCustomInfo()` qui accède directement à `brand`
(protected) pour créer un affichage personnalisé.

Dans `main`, création d'une instance de `Car` et d'une instance de `Motorcycle`.

Appel des méthodes qui démontrent l'accès aux membres `protected` depuis les
sous-classes.

Appel de `testAccess()` pour afficher les résultats des tests d'accès.

Test d'accès depuis la classe `Main` (externe) : `model` est accessible
(public), mais `brand` et `vin` sont inaccessibles (lignes commentées).

</details>

## Exécution

Compilez et exécutez le programme :

```bash
javac Main.java
java Main
```

**Résultat attendu :**

```
=== Voiture ===
VIN: VIN123456
Marque: Tesla
Modèle: Model 3
Nombre de portes: 4
Marque (majuscules): TESLA

=== Moto ===
VIN: VIN789012
Marque: Harley-Davidson
Modèle: Street 750
Type: Cruiser
Harley-Davidson Street 750 (Cruiser)

=== Test d'accès depuis la sous-classe ===
Accès à model (public): Model 3
Accès à brand (protected): Tesla
VIN: VIN123456

=== Test d'accès depuis une classe externe ===
Accès à car.model (public): Model 3
```

## Points clés

- `protected` permet aux sous-classes d'accéder aux attributs et méthodes du
  parent
- Les attributs `protected` ne sont pas accessibles depuis des classes externes
- `protected` maintient l'encapsulation vis-à-vis du code externe
- Utilisez `protected` quand les sous-classes ont besoin d'un accès direct aux
  attributs
- `private` est plus restrictif (uniquement la même classe)
- `public` est le moins restrictif (accessible partout)

## Quand utiliser `protected` ?

**Utilisez `protected` quand :**

- Les sous-classes ont besoin d'accéder directement aux attributs
- Vous créez une hiérarchie de classes cohérente
- Vous voulez faciliter l'extension de vos classes

**Préférez `private` + getters/setters quand :**

- Vous avez besoin de validation ou de logique dans les accès
- L'encapsulation stricte est importante
- Les sous-classes n'ont pas besoin d'accès direct

## Pour aller plus loin

Consultez l'exemple suivant
([06-redefinition-methode](../06-redefinition-methode/)) pour approfondir la
redéfinition de méthodes et comprendre la différence entre redéfinition et
surcharge.
