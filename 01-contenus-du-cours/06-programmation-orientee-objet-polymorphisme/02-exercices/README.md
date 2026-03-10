# Programmation orientée objet : Polymorphisme - Exercices

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Toutes les informations relatives à ce contenu sont décrites dans le
> [contenu principal](../).

## Table des matières

- [Table des matières](#table-des-matières)
- [Exercices](#exercices)
- [Exercices de complétion](#exercices-de-complétion)
  - [Exercice 1 - Utilisation de instanceof](#exercice-1---utilisation-de-instanceof)
  - [Exercice 2 - Cast sécurisé](#exercice-2---cast-sécurisé)
  - [Exercice 3 - Définition d'une interface](#exercice-3---définition-dune-interface)
  - [Exercice 4 - Implémentation d'interface](#exercice-4---implémentation-dinterface)
  - [Exercice 5 - Redéfinition de toString()](#exercice-5---redéfinition-de-tostring)
- [Exercices de prédiction](#exercices-de-prédiction)
  - [Exercice 6 - Liaison dynamique](#exercice-6---liaison-dynamique)
  - [Exercice 7 - Polymorphisme avec interfaces](#exercice-7---polymorphisme-avec-interfaces)
  - [Exercice 8 - Comparaison d'objets avec equals()](#exercice-8---comparaison-dobjets-avec-equals)
- [Exercices de comparaison](#exercices-de-comparaison)
  - [Exercice 9 - Interface vs classe abstraite](#exercice-9---interface-vs-classe-abstraite)
  - [Exercice 10 - Redéfinition vs surcharge](#exercice-10---redéfinition-vs-surcharge)
- [Exercices de modification](#exercices-de-modification)
  - [Exercice 11 - Ajout d'une interface à une hiérarchie](#exercice-11---ajout-dune-interface-à-une-hiérarchie)
  - [Exercice 12 - Implémentation de equals() et hashCode()](#exercice-12---implémentation-de-equals-et-hashcode)
- [Exercices de transfert](#exercices-de-transfert)
  - [Exercice 13 - Système de gestion de véhicules de transport](#exercice-13---système-de-gestion-de-véhicules-de-transport)
  - [Exercice 14 - Application de gestion d'appareils électroniques](#exercice-14---application-de-gestion-dappareils-électroniques)
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

Ces exercices vous permettent de pratiquer la syntaxe et les concepts du
polymorphisme en complétant du code existant.

### Exercice 1 - Utilisation de instanceof

Vous avez une hiérarchie de classes pour représenter des instruments de musique.

```java
abstract class Instrument {
    String brand;

    Instrument(String brand) {
        this.brand = brand;
    }
}

class Guitar extends Instrument {
    int numberOfStrings;

    Guitar(String brand, int numberOfStrings) {
        super(brand);
        this.numberOfStrings = numberOfStrings;
    }
}

class Piano extends Instrument {
    int numberOfKeys;

    Piano(String brand, int numberOfKeys) {
        super(brand);
        this.numberOfKeys = numberOfKeys;
    }
}
```

Complétez la méthode suivante qui affiche les détails spécifiques de chaque
instrument :

```java
public static void displayDetails(Instrument instrument) {
    // TODO: Utilisez instanceof pour vérifier le type et afficher les détails




}
```

**Résultat attendu** : La méthode affiche les détails spécifiques selon le type
d'instrument.

<details>
<summary>Indice</summary>

Utilisez `instanceof` pour vérifier le type, puis effectuez un cast pour accéder
aux attributs spécifiques.

Syntaxe : `if (object instanceof Type) { Type variable = (Type) object; }`

</details>

<details>
<summary>Afficher la solution</summary>

```java
public static void displayDetails(Instrument instrument) {
    if (instrument instanceof Guitar) {
        Guitar guitar = (Guitar) instrument;
        System.out.println("Guitare " + guitar.brand + " avec " +
                          guitar.numberOfStrings + " cordes");
    } else if (instrument instanceof Piano) {
        Piano piano = (Piano) instrument;
        System.out.println("Piano " + piano.brand + " avec " +
                          piano.numberOfKeys + " touches");
    }
}
```

**Explication** : On vérifie le type avec `instanceof`, puis on effectue un cast
pour accéder aux attributs spécifiques de chaque sous-classe.

</details>

### Exercice 2 - Cast sécurisé

Vous devez implémenter une méthode qui compare deux instruments et retourne
`true` s'ils sont du même type et ont les mêmes caractéristiques.

```java
public static boolean areSameType(Instrument i1, Instrument i2) {
    // TODO: Vérifiez si les deux instruments sont du même type
    // et comparez leurs caractéristiques spécifiques




}
```

<details>
<summary>Indice</summary>

Vérifiez d'abord si les deux objets sont du même type avec `instanceof`, puis
comparez leurs attributs après le cast.

</details>

<details>
<summary>Afficher la solution</summary>

```java
public static boolean areSameType(Instrument i1, Instrument i2) {
    if (i1 instanceof Guitar && i2 instanceof Guitar) {
        Guitar g1 = (Guitar) i1;
        Guitar g2 = (Guitar) i2;
        return g1.numberOfStrings == g2.numberOfStrings;
    } else if (i1 instanceof Piano && i2 instanceof Piano) {
        Piano p1 = (Piano) i1;
        Piano p2 = (Piano) i2;
        return p1.numberOfKeys == p2.numberOfKeys;
    }
    return false;
}
```

**Explication** : On vérifie que les deux objets sont du même type avant de les
comparer. Le cast permet d'accéder aux attributs spécifiques.

</details>

### Exercice 3 - Définition d'une interface

Créez une interface `Playable` pour les instruments qui peuvent être joués.

```java
// TODO: Définissez l'interface Playable avec une méthode play()




```

<details>
<summary>Indice</summary>

Une interface se définit avec le mot-clé `interface` et contient des méthodes
abstraites (sans implémentation).

Syntaxe : `public interface NomInterface { typeRetour nomMethode(); }`

</details>

<details>
<summary>Afficher la solution</summary>

```java
public interface Playable {
    void play();
    void tune();
}
```

**Explication** : L'interface `Playable` définit un contrat : toute classe
l'implémentant doit fournir les méthodes `play()` et `tune()`.

</details>

### Exercice 4 - Implémentation d'interface

Modifiez la classe `Guitar` pour qu'elle implémente l'interface `Playable`.

```java
class Guitar extends Instrument ________________ {
    int numberOfStrings;

    Guitar(String brand, int numberOfStrings) {
        super(brand);
        this.numberOfStrings = numberOfStrings;
    }

    // TODO: Implémentez les méthodes de l'interface Playable



}
```

<details>
<summary>Indice</summary>

Utilisez le mot-clé `implements` après `extends` et fournissez une
implémentation pour chaque méthode de l'interface avec `@Override`.

</details>

<details>
<summary>Afficher la solution</summary>

```java
class Guitar extends Instrument implements Playable {
    int numberOfStrings;

    Guitar(String brand, int numberOfStrings) {
        super(brand);
        this.numberOfStrings = numberOfStrings;
    }

    @Override
    public void play() {
        System.out.println("La guitare " + brand + " joue une mélodie");
    }

    @Override
    public void tune() {
        System.out.println("Accordage de la guitare...");
    }
}
```

**Explication** : La classe `Guitar` hérite de `Instrument` ET implémente
`Playable`. Elle doit fournir du code pour toutes les méthodes de l'interface.

</details>

### Exercice 5 - Redéfinition de toString()

Ajoutez une méthode `toString()` à la classe `Guitar`.

```java
class Guitar extends Instrument implements Playable {
    int numberOfStrings;

    Guitar(String brand, int numberOfStrings) {
        super(brand);
        this.numberOfStrings = numberOfStrings;
    }

    // TODO: Redéfinissez toString() pour retourner une représentation textuelle



}
```

<details>
<summary>Indice</summary>

La méthode `toString()` retourne une `String` et utilise `@Override`. Combinez
les attributs dans une chaîne lisible.

</details>

<details>
<summary>Afficher la solution</summary>

```java
@Override
public String toString() {
    return "Guitar{brand='" + brand + "', numberOfStrings=" + numberOfStrings + "}";
}
```

**Explication** : `toString()` permet d'afficher l'objet de manière lisible.
Elle est appelée automatiquement par `System.out.println()`.

</details>

## Exercices de prédiction

Ces exercices vous entraînent à prédire le comportement du code avant de
l'exécuter.

### Exercice 6 - Liaison dynamique

Prédisez ce que va afficher ce code :

```java
abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Dessine un cercle");
    }
}

class Square extends Shape {
    @Override
    void draw() {
        System.out.println("Dessine un carré");
    }
}

// Programme principal
Shape shape1 = new Circle();
Shape shape2 = new Square();
shape1.draw();
shape2.draw();
```

**Que va afficher ce code ?**

<details>
<summary>Afficher la solution</summary>

**Sortie attendue :**

```
Dessine un cercle
Dessine un carré
```

**Explication** : Grâce à la **liaison dynamique**, Java appelle la méthode
correspondant au **type réel** de l'objet (`Circle` ou `Square`), pas au type de
la référence (`Shape`).

</details>

### Exercice 7 - Polymorphisme avec interfaces

Prédisez ce que va afficher ce code :

```java
interface Chargeable {
    void charge();
}

class Smartphone implements Chargeable {
    @Override
    public void charge() {
        System.out.println("Charge du smartphone via USB-C");
    }
}

class Laptop implements Chargeable {
    @Override
    public void charge() {
        System.out.println("Charge du laptop via adaptateur");
    }
}

// Programme principal
Chargeable[] devices = new Chargeable[2];
devices[0] = new Smartphone();
devices[1] = new Laptop();

for (Chargeable device : devices) {
    device.charge();
}
```

**Que va afficher ce code ?**

<details>
<summary>Afficher la solution</summary>

**Sortie attendue :**

```
Charge du smartphone via USB-C
Charge du laptop via adaptateur
```

**Explication** : Le polymorphisme avec interfaces permet de traiter différents
types d'objets (`Smartphone`, `Laptop`) de manière uniforme via le type
`Chargeable`. Chaque objet utilise sa propre implémentation de `charge()`.

</details>

### Exercice 8 - Comparaison d'objets avec equals()

Prédisez ce que va afficher ce code :

```java
class Book {
    String title;
    String author;

    Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }
}

// Programme principal
Book b1 = new Book("1984", "Orwell");
Book b2 = new Book("1984", "Orwell");
Book b3 = b1;

System.out.println(b1 == b2);
System.out.println(b1.equals(b2));
System.out.println(b1 == b3);
System.out.println(b1.equals(b3));
```

**Que va afficher ce code ?**

<details>
<summary>Afficher la solution</summary>

**Sortie attendue :**

```
false
true
true
true
```

**Explication** :

- `b1 == b2` : `false` car ce sont deux objets différents en mémoire
- `b1.equals(b2)` : `true` car ils ont le même contenu (title et author)
- `b1 == b3` : `true` car `b3` pointe vers le même objet que `b1`
- `b1.equals(b3)` : `true` car c'est le même objet

</details>

## Exercices de comparaison

Ces exercices vous aident à comprendre les différences entre concepts
similaires.

### Exercice 9 - Interface vs classe abstraite

Comparez ces deux approches et indiquez quand utiliser chacune :

**Approche A - Interface**

```java
interface Drawable {
    void draw();
}

class Circle implements Drawable {
    @Override
    public void draw() {
        System.out.println("Dessine un cercle");
    }
}
```

**Approche B - Classe abstraite**

```java
abstract class Shape {
    String color;

    abstract void draw();

    void setColor(String color) {
        this.color = color;
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Dessine un cercle de couleur " + color);
    }
}
```

**Question :** Quelles sont les différences ? Quand utiliser l'une ou l'autre ?

<details>
<summary>Afficher la solution</summary>

**Différences principales :**

| Aspect               | Interface                           | Classe abstraite       |
| :------------------- | :---------------------------------- | :--------------------- |
| Attributs d'instance | Non (seulement des constantes)      | Oui                    |
| Méthodes concrètes   | Par défaut non (depuis Java 8: oui) | Oui                    |
| Héritage multiple    | Oui (plusieurs interfaces)          | Non (une seule classe) |
| But                  | Définir des capacités               | Partager du code       |

**Quand utiliser :**

- **Interface** : définir des capacités pour des classes non liées (ex:
  `Drawable`, `Comparable`, `Serializable`)
- **Classe abstraite** : créer une hiérarchie avec code commun (ex: `Shape`,
  `Animal`, `Vehicle`)

**En pratique** : souvent on utilise les deux ensemble (classe abstraite +
interfaces).

</details>

### Exercice 10 - Redéfinition vs surcharge

Identifiez, pour chaque méthode, s'il s'agit de redéfinition ou de surcharge :

```java
class Animal {
    void makeSound() {
        System.out.println("Son générique");
    }

    void move() {
        System.out.println("L'animal bouge");
    }
}

class Dog extends Animal {
    @Override
    void makeSound() {             // Méthode 1
        System.out.println("Woof");
    }

    void makeSound(int times) {     // Méthode 2
        for (int i = 0; i < times; i++) {
            System.out.println("Woof");
        }
    }

    @Override
    void move() {                   // Méthode 3
        System.out.println("Le chien court");
    }
}
```

**Question :** Identifiez le type de chaque méthode (redéfinition ou surcharge).

<details>
<summary>Afficher la solution</summary>

**Réponses :**

- **Méthode 1** : **Redéfinition** (`@Override`) - même signature que dans
  `Animal`
- **Méthode 2** : **Surcharge** - même nom mais paramètres différents (ajoute
  `int times`)
- **Méthode 3** : **Redéfinition** (`@Override`) - même signature que dans
  `Animal`

**Règle mnémotechnique :**

- **Redéfinition** = même signature, classe parent/enfant → `@Override`
- **Surcharge** = même nom, paramètres différents → peut être dans la même
  classe

</details>

## Exercices de modification

Ces exercices vous demandent de modifier du code existant pour corriger des
erreurs ou ajouter des fonctionnalités.

### Exercice 11 - Ajout d'une interface à une hiérarchie

Vous avez cette hiérarchie de véhicules :

```java
abstract class Vehicle {
    String brand;
    int year;

    Vehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    abstract void start();
}

class Car extends Vehicle {
    Car(String brand, int year) {
        super(brand, year);
    }

    @Override
    void start() {
        System.out.println("La voiture démarre");
    }
}

class ElectricCar extends Vehicle {
    int batteryLevel;

    ElectricCar(String brand, int year, int batteryLevel) {
        super(brand, year);
        this.batteryLevel = batteryLevel;
    }

    @Override
    void start() {
        System.out.println("La voiture électrique démarre silencieusement");
    }
}
```

**Tâche :** Ajoutez une interface `Rechargeable` avec une méthode `charge()` et
faites en sorte que seule la classe `ElectricCar` l'implémente.

<details>
<summary>Afficher la solution</summary>

```java
// Nouvelle interface
interface Rechargeable {
    void charge();
    int getBatteryLevel();
}

// Modification de ElectricCar
class ElectricCar extends Vehicle implements Rechargeable {
    int batteryLevel;

    ElectricCar(String brand, int year, int batteryLevel) {
        super(brand, year);
        this.batteryLevel = batteryLevel;
    }

    @Override
    void start() {
        System.out.println("La voiture électrique démarre silencieusement");
    }

    @Override
    public void charge() {
        batteryLevel = 100;
        System.out.println("Batterie chargée à 100%");
    }

    @Override
    public int getBatteryLevel() {
        return batteryLevel;
    }
}

// Utilisation polymorphe
Rechargeable device = new ElectricCar("Tesla", 2024, 50);
device.charge();
```

**Explication** : L'interface `Rechargeable` définit une capacité. Seule
`ElectricCar` l'implémente car `Car` ne peut pas être rechargée. Cela permet de
traiter tous les objets rechargeables de manière uniforme.

</details>

### Exercice 12 - Implémentation de equals() et hashCode()

Ajoutez les méthodes `equals()` et `hashCode()` à cette classe :

```java
class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // TODO: Ajoutez equals()







    // TODO: Ajoutez hashCode()



}
```

<details>
<summary>Indice</summary>

- `equals()` compare les attributs un par un
- `hashCode()` combine les hash codes des attributs
- Si `equals()` retourne `true`, `hashCode()` doit retourner la même valeur

</details>

<details>
<summary>Afficher la solution</summary>

```java
class Product {
    String name;
    double price;
    String category;

    Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Product product = (Product) obj;
        return Double.compare(product.price, price) == 0 &&
               name.equals(product.name) &&
               category.equals(product.category);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + category.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "', price=" + price +
               ", category='" + category + "'}";
    }
}
```

**Explication** :

- `equals()` vérifie que tous les attributs sont égaux
- `hashCode()` combine les hash codes avec la formule `31 * result + attribut`
- Le nombre 31 est un choix courant (nombre premier)
- `toString()` fournit une représentation lisible

</details>

## Exercices de transfert

Ces exercices vous demandent d'appliquer les concepts à de nouveaux contextes.

### Exercice 13 - Système de gestion de véhicules de transport

Créez un système pour gérer différents types de véhicules de transport public.

**Cahier des charges :**

1. Créez une classe abstraite `PublicTransport` avec :
   - Attributs : `String line`, `int capacity`
   - Méthode abstraite : `void displayRoute()`
   - Méthode concrète : `void displayInfo()`

2. Créez deux sous-classes :
   - `Bus` avec un attribut `boolean isElectric`
   - `Tram` avec un attribut `int numberOfCars`

3. Créez une interface `Schedulable` avec :
   - `String getNextDeparture()`
   - `void setSchedule(String schedule)`

4. Faites implémenter `Schedulable` par les deux sous-classes

5. Créez un programme principal qui :
   - Crée plusieurs véhicules
   - Les stocke dans une `ArrayList<PublicTransport>`
   - Affiche leurs informations
   - Traite les véhicules `Schedulable` séparément

<details>
<summary>Afficher la solution</summary>

```java
// Classe abstraite parent
abstract class PublicTransport {
    String line;
    int capacity;

    PublicTransport(String line, int capacity) {
        this.line = line;
        this.capacity = capacity;
    }

    abstract void displayRoute();

    void displayInfo() {
        System.out.println("Ligne " + line + ", capacité: " + capacity + " personnes");
    }
}

// Interface
interface Schedulable {
    String getNextDeparture();
    void setSchedule(String schedule);
}

// Sous-classe Bus
class Bus extends PublicTransport implements Schedulable {
    boolean isElectric;
    String schedule;

    Bus(String line, int capacity, boolean isElectric) {
        super(line, capacity);
        this.isElectric = isElectric;
    }

    @Override
    void displayRoute() {
        System.out.println("Bus ligne " + line + " - Trajet urbain");
        if (isElectric) {
            System.out.println("(Bus électrique)");
        }
    }

    @Override
    public String getNextDeparture() {
        return schedule;
    }

    @Override
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}

// Sous-classe Tram
class Tram extends PublicTransport implements Schedulable {
    int numberOfCars;
    String schedule;

    Tram(String line, int capacity, int numberOfCars) {
        super(line, capacity);
        this.numberOfCars = numberOfCars;
    }

    @Override
    void displayRoute() {
        System.out.println("Tram ligne " + line + " - " + numberOfCars + " voitures");
    }

    @Override
    public String getNextDeparture() {
        return schedule;
    }

    @Override
    public void setSchedule(String schedule) {
        this.schedule = schedule;
    }
}

// Programme principal
class TransportDemo {
    public static void main(String[] args) {
        // Création des véhicules
        PublicTransport[] vehicles = new PublicTransport[3];
        vehicles[0] = new Bus("12", 80, true);
        vehicles[1] = new Tram("T1", 200, 3);
        vehicles[2] = new Bus("25", 60, false);

        // Affichage des informations
        System.out.println("=== Tous les véhicules ===");
        for (PublicTransport vehicle : vehicles) {
            vehicle.displayInfo();
            vehicle.displayRoute();
            System.out.println();
        }

        // Gestion des horaires
        System.out.println("=== Gestion des horaires ===");
        for (PublicTransport vehicle : vehicles) {
            if (vehicle instanceof Schedulable) {
                Schedulable s = (Schedulable) vehicle;
                s.setSchedule("Toutes les 10 minutes");
                System.out.println("Ligne " + vehicle.line + ": " +
                                  s.getNextDeparture());
            }
        }
    }
}
```

**Points clés :**

- Polymorphisme d'héritage avec `PublicTransport[]`
- Polymorphisme d'interface avec `Schedulable`
- Utilisation de `instanceof` pour traitement spécifique
- Méthodes abstraites et concrètes dans la classe parent

</details>

### Exercice 14 - Application de gestion d'appareils électroniques

Créez une application pour gérer des appareils électroniques.

**Cahier des charges :**

1. Créez une interface `Powerable` avec :
   - `void turnOn()`
   - `void turnOff()`
   - `boolean isPoweredOn()`

2. Créez une classe abstraite `ElectronicDevice` avec :
   - Attributs : `String brand`, `String model`, `boolean poweredOn`
   - Implémente `Powerable`
   - Méthode abstraite : `void displaySpecifications()`

3. Créez trois sous-classes :
   - `Smartphone` avec `int storageGB`
   - `Laptop` avec `int ramGB`
   - `Tablet` avec `double screenSize`

4. Ajoutez `toString()`, `equals()` et `hashCode()` à chaque classe

5. Créez un programme qui teste toutes les fonctionnalités

<details>
<summary>Afficher la solution</summary>

```java
// Interface
interface Powerable {
    void turnOn();
    void turnOff();
    boolean isPoweredOn();
}

// Classe abstraite
abstract class ElectronicDevice implements Powerable {
    String brand;
    String model;
    boolean poweredOn;

    ElectronicDevice(String brand, String model) {
        this.brand = brand;
        this.model = model;
        this.poweredOn = false;
    }

    @Override
    public void turnOn() {
        poweredOn = true;
        System.out.println(brand + " " + model + " allumé");
    }

    @Override
    public void turnOff() {
        poweredOn = false;
        System.out.println(brand + " " + model + " éteint");
    }

    @Override
    public boolean isPoweredOn() {
        return poweredOn;
    }

    abstract void displaySpecifications();

    @Override
    public String toString() {
        return brand + " " + model;
    }
}

// Sous-classe Smartphone
class Smartphone extends ElectronicDevice {
    int storageGB;

    Smartphone(String brand, String model, int storageGB) {
        super(brand, model);
        this.storageGB = storageGB;
    }

    @Override
    void displaySpecifications() {
        System.out.println("Smartphone: " + brand + " " + model);
        System.out.println("Stockage: " + storageGB + " GB");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Smartphone phone = (Smartphone) obj;
        return storageGB == phone.storageGB &&
               brand.equals(phone.brand) &&
               model.equals(phone.model);
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + storageGB;
        return result;
    }
}

// Sous-classe Laptop
class Laptop extends ElectronicDevice {
    int ramGB;

    Laptop(String brand, String model, int ramGB) {
        super(brand, model);
        this.ramGB = ramGB;
    }

    @Override
    void displaySpecifications() {
        System.out.println("Laptop: " + brand + " " + model);
        System.out.println("RAM: " + ramGB + " GB");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Laptop laptop = (Laptop) obj;
        return ramGB == laptop.ramGB &&
               brand.equals(laptop.brand) &&
               model.equals(laptop.model);
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + ramGB;
        return result;
    }
}

// Sous-classe Tablet
class Tablet extends ElectronicDevice {
    double screenSize;

    Tablet(String brand, String model, double screenSize) {
        super(brand, model);
        this.screenSize = screenSize;
    }

    @Override
    void displaySpecifications() {
        System.out.println("Tablette: " + brand + " " + model);
        System.out.println("Écran: " + screenSize + " pouces");
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Tablet tablet = (Tablet) obj;
        return Double.compare(tablet.screenSize, screenSize) == 0 &&
               brand.equals(tablet.brand) &&
               model.equals(tablet.model);
    }

    @Override
    public int hashCode() {
        int result = brand.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + Double.hashCode(screenSize);
        return result;
    }
}

// Programme principal
class ElectronicsDemo {
    public static void main(String[] args) {
        // Création des appareils
        ElectronicDevice[] devices = new ElectronicDevice[3];
        devices[0] = new Smartphone("Apple", "iPhone 15", 256);
        devices[1] = new Laptop("Dell", "XPS 15", 32);
        devices[2] = new Tablet("Samsung", "Galaxy Tab", 10.5);

        // Test des fonctionnalités
        System.out.println("=== Test de l'alimentation ===");
        for (ElectronicDevice device : devices) {
            device.turnOn();
            device.displaySpecifications();
            System.out.println("État: " + (device.isPoweredOn() ? "allumé" : "éteint"));
            System.out.println();
        }

        // Test de equals()
        System.out.println("=== Test de equals() ===");
        Smartphone phone1 = new Smartphone("Apple", "iPhone 15", 256);
        Smartphone phone2 = new Smartphone("Apple", "iPhone 15", 256);
        Smartphone phone3 = new Smartphone("Apple", "iPhone 15", 128);

        System.out.println("phone1.equals(phone2): " + phone1.equals(phone2));  // true
        System.out.println("phone1.equals(phone3): " + phone1.equals(phone3));  // false

        // Test de toString()
        System.out.println("\n=== Test de toString() ===");
        for (ElectronicDevice device : devices) {
            System.out.println(device.toString());
        }

        // Extinction de tous les appareils
        System.out.println("\n=== Extinction ===");
        for (ElectronicDevice device : devices) {
            device.turnOff();
        }
    }
}
```

**Points clés :**

- Hiérarchie complète : interface → classe abstraite → classes concrètes
- Implémentation de `Powerable` dans la classe abstraite (factorisation)
- Méthodes `equals()` et `hashCode()` dans chaque sous-classe
- Tests complets de toutes les fonctionnalités

</details>

## Conclusion

Ces exercices couvrent les concepts essentiels du polymorphisme en Java :

- **instanceof et cast** : vérification et conversion de types
- **Polymorphisme d'héritage** : références de type parent
- **Redéfinition** : adaptation du comportement dans les sous-classes
- **Interfaces** : contrats de comportement
- **Méthodes Object** : `toString()`, `equals()`, `hashCode()`
- **Collections polymorphes** : gestion uniforme d'objets variés

Pour aller plus loin :

- Consultez les [exemples de code](../01-exemples-de-code/) pour voir les
  concepts en action
- Réalisez le [mini-projet](../03-mini-projet/) pour un projet complet
- Relisez le [contenu de cours](../) pour approfondir la théorie

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
