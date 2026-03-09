---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Quiz sur le contenu Programmation orientée objet - Encapsulation et héritage
  pour le cours ProgIM2 enseigné à la HEIG-VD, Suisse
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/05-programmation-orientee-objet-encapsulation-et-heritage/quiz.html
header:
  "[**Programmation orientée objet : Encapsulation et héritage -
  Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Programmation orientée objet : Encapsulation et héritage - Quiz

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

_Cette présentation est un quiz pour tester ses connaissances sur le chapitre en
cours. Pour plus de détails, consultez le [contenu complet sur
GitHub][contenu-complet-sur-github]._

## Question 1 - Donnée

**Complétion : Modificateurs d'accès**

Quel modificateur permet de rendre un attribut accessible uniquement depuis la
classe elle-même ?

- **A.** `public`
- **B.** `private`
- **C.** `protected`
- **D.** `default`

## Question 1 - Réponse

**Réponse correcte : B** `private`

```java
class BankAccount {
    private double balance;  // Accessible uniquement depuis BankAccount
}
```

- **private** : accès uniquement dans la classe
- **public** : accès depuis partout
- **protected** : accès dans la classe et ses sous-classes
- **default** : accès dans le même package

## Question 2 - Donnée

**Complétion : Getters et setters**

Comment appelle-t-on une méthode qui retourne la valeur d'un attribut privé ?

- **A.** Un mutateur (setter)
- **B.** Un constructeur
- **C.** Un accesseur (getter)
- **D.** Un modificateur

## Question 2 - Réponse

**Réponse correcte : C - Un accesseur (getter)**

```java
class Person {
    private String name;

    // Accesseur (getter)
    public String getName() {
        return name;
    }

    // Mutateur (setter)
    public void setName(String name) {
        this.name = name;
    }
}
```

## Question 3 - Donnée

Quel code valide correctement l'âge dans un setter ?

```java
// Option A
public void setAge(int age) {
    this.age = age;
}

// Option B
public void setAge(int age) {
    if (age > 0) {
        this.age = age;
    }
}
```

## Question 3 - Réponse

**Réponse correcte : B - Validation avec condition**

```java
class Person {
    private int age;

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        }
    }
}
```

Un setter permet de valider les données avant de les affecter.

## Question 4 - Donnée

**Complétion : Le mot-clé final**

Que signifie le mot-clé `final` sur une variable ?

```java
final double PI = 3.14159;
```

- **A.** La variable peut changer une seule fois
- **B.** La variable ne peut jamais être modifiée
- **C.** La variable est privée
- **D.** La variable est publique

## Question 4 - Réponse

**Réponse correcte : B - La variable ne peut jamais être modifiée**

```java
class Circle {
    final double PI = 3.14159;  // Constante

    void test() {
        PI = 3.14;  // ERREUR : ne compile pas
    }
}
```

**Explications :** `final` crée une constante qui ne peut plus être modifiée
après son initialisation.

## Question 6 - Donnée

Que fait le mot-clé `super` dans ce constructeur ?

```java
class Vehicle {
    String brand;
    Vehicle(String brand) {
        this.brand = brand;
    }
}
class Car extends Vehicle {
    String model;
    Car(String brand, String model) {
        super(brand);
        this.model = model;
    }
}
```

## Question 6 - Réponse

**Réponse correcte : Appelle le constructeur de la classe parent**

**Explications :**

- `super()` appelle le constructeur de la classe parent
- Doit être la **première instruction** du constructeur

## Question 7 - Donnée

Quelle différence entre `private` et `protected` ?

```java
class Parent {
    private int x = 10;
    protected int y = 20;
}

class Child extends Parent {
    void display() {
        // System.out.println(x);  // ?
        // System.out.println(y);  // ?
    }
}
```

## Question 7 - Réponse

`private` : inaccessible aux sous-classes  
`protected` : accessible aux sous-classes

```java
class Parent {
    private int x = 10;     // Inaccessible dans Child
    protected int y = 20;   // Accessible dans Child
}
class Child extends Parent {
    void display() {
        // System.out.println(x);  // ERREUR
        System.out.println(y);     // OK : affiche 20
    }
}
```

## Question 8 - Donnée

Quelle est la différence entre ces deux classes ?

```java
// Classe A
abstract class Animal {
    abstract void makeSound();
}

// Classe B
class Dog {
    void makeSound() {
        System.out.println("Woof");
    }
}
```

## Question 8 - Réponse

```java
abstract class Animal {  // Classe ABSTRAITE
    abstract void makeSound();  // Méthode abstraite (pas d'implémentation)
}

class Dog extends Animal {  // Classe CONCRÈTE
    void makeSound() {  // Implémentation de la méthode abstraite
        System.out.println("Woof");
    }
}

Animal a = new Animal();  // ERREUR : classe abstraite
Dog d = new Dog();  // OK : classe concrète
```

## Question 9 - Donnée

Quelle est la différence entre ces deux méthodes `display` ?

```java
class Parent {
    void display() {
        System.out.println("Parent");
    }
}
class Child extends Parent {
    void display() {              // Méthode 1
        System.out.println("Child");
    }

    void display(String msg) {     // Méthode 2
        System.out.println(msg);
    }
}
```

## Question 9 - Réponse

**Méthode 1 = redéfinition, Méthode 2 = surcharge**

```java
class Child extends Parent {
    @Override
    void display() {              // REDÉFINITION
        System.out.println("Child");  // Même signature que Parent
    }

    void display(String msg) {     // SURCHARGE
        System.out.println(msg);   // Signature différente
    }
}
```

**Explications :**

- **Redéfinition** : même signature que dans la classe parent (@Override)
- **Surcharge** : même nom mais paramètres différents

## Question 10 - Donnée

**Modification : Classe abstraite manquante**

Ce code ne compile pas. Pourquoi ?

```java
class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    double radius;

    double getArea() {
        return Math.PI * radius * radius;
    }
}
```

## Question 10 - Réponse

**Réponse correcte : La classe doit être déclarée `abstract`**

```java
// ERREUR : méthode abstraite dans une classe non-abstraite
class Shape {
    abstract double getArea();  // ERREUR
}

// ---

// CORRECT : classe abstraite avec méthode abstraite
abstract class Shape {
    abstract double getArea();
}

class Circle extends Shape {
    double radius;

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }
}
```

## Question 11 - Donnée

**Modification : Utilisation du mot-clé final**

Quel modificateur empêche une méthode d'être redéfinie dans une sous-classe ?

```java
class Vehicle {
    ______ void start() {
        System.out.println("Starting...");
    }
}

class Car extends Vehicle {
    void start() {  // Devrait être impossible
        System.out.println("Car starting...");
    }
}
```

## Question 11 - Réponse

**Réponse correcte : `final`**

```java
class Vehicle {
    final void start() {  // Ne peut pas être redéfinie
        System.out.println("Starting...");
    }
}

class Car extends Vehicle {
    @Override
    void start() {  // ERREUR : ne compile pas
        System.out.println("Car starting...");
    }
}
```

**Explications :** `final` sur une méthode empêche sa redéfinition dans les
sous-classes.

## Question 12 - Donnée

**Prédiction : Hiérarchie de classes**

Combien de classes peuvent hériter directement de `Animal` ?

```java
abstract class Animal { }

class Dog extends Animal { }
class Cat extends Animal { }
class Bird extends Animal { }
```

- **A.** Aucune limite
- **B.** Maximum 3 classes
- **C.** Une seule classe
- **D.** Maximum 10 classes

## Question 12 - Réponse

**Réponse correcte : A - Aucune limite**

```java
abstract class Animal { }

class Dog extends Animal { }
class Cat extends Animal { }
class Bird extends Animal { }
class Fish extends Animal { }
// ... autant de sous-classes que nécessaire
```

**Explications :**

- Une classe parent peut avoir **plusieurs sous-classes**
- Une sous-classe ne peut avoir qu'**un seul parent** (pas d'héritage multiple)

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Markus Spiske](https://unsplash.com/@markusspiske) sur
  [Unsplash](https://unsplash.com/photos/blue-and-white-logo-guessing-game-iar-afB0QQw)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/05-programmation-orientee-objet-encapsulation-et-heritage/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1611519541067-46c8f2d05f11?fit=crop&h=720
