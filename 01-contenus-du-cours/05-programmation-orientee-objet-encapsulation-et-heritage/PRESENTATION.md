---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Programmation orientée objet - Encapsulation et héritage pour le cours ProgIM2
  enseigné à la HEIG-VD, Suisse
lang: fr
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/05-programmation-orientee-objet-encapsulation-et-heritage/presentation.html
header:
  "[**Programmation orientée objet : Encapsulation et
  héritage**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Programmation orientée objet : Encapsulation et héritage

<!--
_class: lead
_paginate: false
-->

<https://github.com/heig-vd-progim-course/heig-vd-progim2-course>

Visualiser le contenu complet sur GitHub [à cette
adresse][contenu-complet-sur-github].

<small>V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).</small>

<small>Ce travail est sous licence [CC BY-SA 4.0][licence].</small>

![bg opacity:0.1][illustration-principale]

## Plus de détails sur GitHub

<!-- _class: lead -->

_Cette présentation est un résumé du contenu complet disponible sur GitHub._

_Pour plus de détails, consulter le [contenu complet sur
GitHub][contenu-complet-sur-github] ou en cliquant sur l'en-tête de ce
document._

## Objectifs (1/5)

- Appliquer le principe d'encapsulation pour cacher l'implémentation interne.
- Valider les données dans les setters pour garantir la cohérence.
- Concevoir des classes avec une interface publique claire.
- Justifier les choix de visibilité des membres d'une classe.

![bg right:40%][illustration-objectifs]

## Objectifs (2/5)

- Expliquer le concept d'héritage et sa finalité.
- Créer des classes dérivées en utilisant le mot-clé `extends`.
- Utiliser le mot-clé `super` pour appeler le constructeur de la classe parent.
- Identifier les relations "est-un" entre classes.

![bg right:40%][illustration-objectifs]

## Objectifs (3/5)

- Organiser une hiérarchie de classes logique.
- Définir une classe abstraite avec le mot-clé `abstract`.
- Créer des méthodes abstraites à implémenter dans les sous-classes.
- Différencier une classe abstraite d'une classe concrète.

![bg right:40%][illustration-objectifs]

## Objectifs (4/5)

- Justifier l'utilisation de classes abstraites pour factoriser du code.
- Appliquer le modificateur `protected` pour les membres accessibles aux
  sous-classes.
- Utiliser le mot-clé `final` pour empêcher la modification ou la redéfinition.

![bg right:40%][illustration-objectifs]

## Objectifs (5/5)

- Évaluer quand utiliser `final` sur des classes, méthodes ou variables.

![bg right:40%][illustration-objectifs]

## Rappel : Classes et objets

Dans la session précédente, nous avons créé des classes simples avec des
attributs **directement accessibles** (sans encapsulation).

**Problèmes** :

- N'importe qui peut modifier directement les données.
- Difficile de contrôler les modifications.
- Code difficile à maintenir.
- Duplication de code entre classes similaires.

## Solutions : Encapsulation et héritage

**Encapsulation** : protéger les données et contrôler leur accès.

**Héritage** : réutiliser du code et créer des hiérarchies de classes.

![bg right:40%][illustration-concepts]

## L'encapsulation

<!-- _class: lead -->

Protéger les données et contrôler leur accès

## Problème sans encapsulation

```java
class BankAccount {
    public String owner;
    public double balance;
}
```

```java
BankAccount account = new BankAccount();
account.balance = -5000.0;  // Solde négatif !
account.balance = 999999999; // Montant irréaliste !
```

**Aucune protection** : modifications directes non contrôlées.

## Bénéfices de l'encapsulation

- **Protection des données** : empêche les modifications directes non
  contrôlées.
- **Validation** : vérifie que les valeurs sont valides.
- **Maintenabilité** : facilite les modifications futures.
- **Interface claire** : définit ce qui peut être fait avec un objet.

## Les modificateurs d'accès

| Modificateur | Visibilité                             | Usage typique                |
| ------------ | -------------------------------------- | ---------------------------- |
| `public`     | Accessible de partout                  | Méthodes publiques, classes  |
| `private`    | Accessible uniquement dans la classe   | Attributs, méthodes internes |
| `protected`  | Accessible dans classe et sous-classes | Héritage                     |
| par défaut   | Accessible dans le même package        | Classes utilitaires internes |

## Rendre les attributs privés

```java
class BankAccount {
    private String owner;
    private double balance;

    public void displayInfo() {
        System.out.println("Solde: " + balance + " CHF");
    }
}

// ... dans une autre classe

BankAccount account = new BankAccount();
account.balance = 1000.0; // ERREUR : balance est privé
```

## Les getters et setters

```java
class BankAccount {
    private String owner;
    private double balance;

    // Getters
    public String getOwner() { return owner; }
    public double getBalance() { return balance; }

    // Setters
    public void setOwner(String owner) { this.owner = owner; }
    public void setBalance(double balance) { this.balance = balance; }
}
```

## Validation des données

```java
public void setBalance(double balance) {
    if (balance < 0) {
        System.out.println("Erreur: solde négatif.");
        return;
    }
    this.balance = balance;
}

public void withdraw(double amount) {
    if (amount > balance) {
        System.out.println("Erreur: solde insuffisant.");
        return;
    }
    balance -= amount;
}
```

## Le modificateur final

```java
class Circle {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    // Pas de setRadius() car radius est final
}
```

**Utile pour** : constantes, identifiants uniques, valeurs qui ne doivent pas
changer.

## L'héritage

<!-- _class: lead -->

Réutiliser du code et créer des hiérarchies

## Problème sans héritage

```java
class Car {
    private String brand;
    private String model;
    private int year;
    private int numberOfDoors;
}

class Motorcycle {
    private String brand; // Code dupliqué
    private String model; // Code dupliqué
    private int year; // Code dupliqué
    private boolean hasSidecar;
}
```

## Solution avec héritage

```java
class Vehicle {
    protected String brand;
    protected String model;
    protected int year;
}

class Car extends Vehicle {  // Hérite de brand, model, year
    private int numberOfDoors;
}

class Motorcycle extends Vehicle { // Hérite de brand, model, year
    private boolean hasSidecar;
}
```

## Bénéfices de l'héritage

- **Réutilisation du code** : évite la duplication.
- **Organisation logique** : hiérarchie qui reflète le monde réel.
- **Maintenabilité** : modifications propagées automatiquement.
- **Extensibilité** : facile d'ajouter de nouveaux types.

![bg right:40%][illustration-heritage]

## La relation "est-un"

L'héritage modélise une relation **"est-un"** (is-a) :

- Une voiture **est un** véhicule.
- Un chien **est un** animal.
- Une rose **est une** fleur.

**Attention** : ne pas confondre avec "a-un" (has-a) :

- Une voiture **a un** moteur (composition, pas héritage).

## Créer une sous-classe avec extends

```java
class Animal {
    protected String name;
    protected int age;

    public void eat() {
        System.out.println(name + " mange.");
    }
}

class Dog extends Animal {
    private String breed;

    public void bark() {
        System.out.println(name + " aboie !");
    }
}
```

`Dog` hérite des attributs et méthodes de `Animal`.

## Le mot-clé super

**Appeler le constructeur parent** :

```java
class Dog extends Animal {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);  // Appelle Animal(name, age)
        this.breed = breed;
    }
}
```

`super()` doit être la **première instruction** du constructeur.

## Le modificateur protected

```java
class Parent {
    private String secret;      // Non accessible aux sous-classes
    protected String family;    // Accessible aux sous-classes
    public String forEveryone;  // Accessible partout
}

class Child extends Parent {
    public void test() {
        // secret = "test";  // ERREUR
        family = "test";     // OK
        forEveryone = "test"; // OK
    }
}
```

## Les méthodes abstraites

Une **méthode abstraite** n'a pas d'implémentation :

```java
abstract class Shape {
    protected String color;

    public abstract double calculateArea(); // Pas de corps

    public void displayColor() {
        System.out.println("Couleur: " + color);
    }
}
```

Les sous-classes **doivent** l'implémenter.

## Implémenter les méthodes abstraites

```java
class Circle extends Shape {
    private double radius;

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    private double width, height;

    @Override
    public double calculateArea() {
        return width * height;
    }
}
```

Chaque forme implémente le calcul d'aire différemment.

## Les classes abstraites

Une **classe abstraite** ne peut pas être instanciée :

```java
abstract class Employee {
    protected String name;
    public abstract double calculateSalary();
}

class FullTimeEmployee extends Employee {
    @Override
    public double calculateSalary() { return baseSalary; }
}

/Employee e = new Employee(); // ERREUR !
FullTimeEmployee e = new FullTimeEmployee(); // OK
```

Sert de modèle pour les sous-classes.

## Classe abstraite vs concrète

| Classe abstraite               | Classe concrète              |
| ------------------------------ | ---------------------------- |
| Mot-clé `abstract`             | Pas de `abstract`            |
| Ne peut pas être instanciée    | Peut être instanciée         |
| Peut avoir méthodes abstraites | Toutes méthodes implémentées |
| Sert de modèle                 | Utilisable directement       |

## Redéfinition vs surcharge (1/2)

**Redéfinition (overriding)** :

- Même nom, **mêmes paramètres**, dans une **sous-classe**.
- Utilise `@Override`.

**Surcharge (overloading)** :

- Même nom, **paramètres différents**, dans la **même classe**.
- Pas d'annotation.

## Redéfinition vs surcharge (2/2)

```java
class Calculator {
    public int add(int a, int b) { return a + b; }        // Surcharge
    public double add(double a, double b) { return a + b; } // Surcharge
}
```

## Le modificateur final (suite)

**Sur une méthode** : empêche la redéfinition dans les sous-classes.

```java
class Parent {
    public final void criticalMethod() {
        // Ne peut pas être redéfinie
    }
}
```

**Sur une classe** : empêche l'héritage.

```java
public final class MathUtils { /* Aucune sous-classe possible */ }
```

## Organiser une hiérarchie de classes

**Principes** :

1. Identifier les caractéristiques communes.
2. Appliquer la relation "est-un".
3. Utiliser des classes abstraites pour les concepts généraux.
4. Créer des sous-classes pour les spécialisations.
5. Éviter les hiérarchies trop profondes (>3-4 niveaux).

## Ressources

**Documentation officielle** :

- [Java Inheritance (Oracle)](https://docs.oracle.com/javase/tutorial/java/IandI/subclasses.html)
- [Java Encapsulation (Oracle)](https://docs.oracle.com/javase/tutorial/java/javaOO/accesscontrol.html)

**Tutoriels** :

- [W3Schools Java Tutorial](https://www.w3schools.com/java/default.asp)
- [Java Modifiers](https://www.w3schools.com/java/java_modifiers.asp)

## À vous de jouer !

- (Re)lire le contenu de cours.
- Lire les exemples de code et les descriptions.
- Faire les exercices.
- Faire le mini-projet.
- Poser des questions si nécessaire.
- Entraidez-vous

➡️ [Contenu complet sur GitHub.][contenu-complet-sur-github]

![bg right:40%][illustration-a-vous-de-jouer]

## Questions ?

<!-- _class: lead -->

Des questions sur l'encapsulation ou l'héritage ?

![bg opacity:0.2][illustration-questions]

## Sources

- [Illustration principale][illustration-principale] par
  [Luca Bravo](https://unsplash.com/@lucabravo) sur
  [Unsplash](https://unsplash.com/photos/black-flat-screen-computer-monitor-XJXWbfSo2f0)
- [Illustration][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/low-angle-view-of-ball-shoots-in-the-ring-j6brni7fpvs)
- [Illustration][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/white-sony-ps4-dualshock-controller-over-persons-palm-FJFPuE1MAOM)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/05-programmation-orientee-objet-encapsulation-et-heritage
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
[illustration-principale]:
	https://images.unsplash.com/photo-1555066931-4365d14bab8c?q=80&w=1920
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720&auto=format&fit=cro
[illustration-concepts]:
	https://images.unsplash.com/photo-1558618666-fcd25c85cd64?q=80&w=800
[illustration-heritage]:
	https://images.unsplash.com/photo-1530281700549-e82e7bf110d6?q=80&w=800
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
[illustration-questions]:
	https://images.unsplash.com/photo-1516321318423-f06f85e504b3?q=80&w=1920
