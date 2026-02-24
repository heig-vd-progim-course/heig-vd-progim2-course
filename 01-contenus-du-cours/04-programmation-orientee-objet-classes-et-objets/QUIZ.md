---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Quiz sur le contenu Programmation orientée objet - Classes et objets pour le
  cours ProgIM2 enseigné à la HEIG-VD, Suisse
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/04-programmation-orientee-objet-classes-et-objets/quiz.html
header:
  "[**Programmation orientée objet : Classes et objets -
  Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Programmation orientée objet : Classes et objets - Quiz

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

**Complétion : Déclaration d'une classe**

Quel code déclare correctement une classe `Book` en Java ?

- **A.** `class Book { }`
- **B.** `Book class { }`
- **C.** `class book { }`
- **D.** `new Book { }`

## Question 1 - Réponse

**Réponse correcte : A** `class Book { }`

**Explications :**

- **A** : syntaxe correcte, le nom de la classe commence par une majuscule
- **B** : le mot-clé `class` doit être avant le nom
- **C** : par convention, les noms de classes commencent par une majuscule
- **D** : `new` sert à créer des objets, pas à déclarer des classes

## Question 2 - Donnée

**Complétion : Déclaration d'attributs**

Quel code déclare correctement un attribut `title` de type `String` dans une
classe ?

- **A.** `String title;`
- **B.** `title String;`
- **C.** `String = title;`
- **D.** `var title: String;`

## Question 2 - Réponse

**Réponse correcte : A** `String title;`

```java
class Book {
    String title;  // Déclaration correcte
}
```

**Explications :**

- **B** : l'ordre est inversé
- **C** : utilise l'opérateur d'affectation au lieu de la déclaration
- **D** : syntaxe d'autres langages (TypeScript, Kotlin), pas Java

## Question 3 - Donnée

**Complétion : Constructeur manquant**

Complétez le constructeur de la classe `Car` :

```java
class Car {
    String brand;
    int year;

    ___(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }
}
```

## Question 3 - Réponse

**Réponse correcte : public Car(String brand, int year)**

```java
public Car(String brand, int year) {
    this.brand = brand;
    this.year = year;
}
```

**Explications :**

- Un constructeur a le **même nom que la classe**
- Un constructeur **n'a pas de type de retour** (même pas `void`)

## Question 4 - Donnée

**Complétion : Utilisation du mot-clé `this`**

Pourquoi utilise-t-on `this` dans ce code ?

```java
public Person(String name, int age) {
    this.name = name;
    this.age = age;
}
```

## Question 4 - Réponse

**Réponse correcte : B - `this` fait référence à l'instance courante et
différencie les attributs des paramètres**

```java
public Person(String name, int age) {
    this.name = name;  // this.name = attribut, name = paramètre
    this.age = age;
}
```

**Explications :**

- Sans `this`, on modifierait le paramètre, pas l'attribut

## Question 5 - Donnée

**Prédiction : Création d'objet**

Combien d'objets `Product` sont créés dans ce code ?

```java
Product laptop = new Product("Laptop", 899.90);
Product mouse = new Product("Mouse", 25.50);
Product screen = laptop;
```

**A.** 1 objet **B.** 2 objets **C.** 3 objets **D.** 4 objets

## Question 5 - Réponse

**Réponse correcte : B** - 2 objets sont créés

```java
Product laptop = new Product("Laptop", 899.90);  // Objet 1
Product mouse = new Product("Mouse", 25.50);     // Objet 2
Product screen = laptop;  // Pas de nouvel objet, screen pointe vers laptop
```

**Explications :**

- `new` crée un nouvel objet en mémoire
- `screen = laptop;` copie la référence, pas l'objet
- `screen` et `laptop` pointent vers le **même objet**

## Question 6 - Donnée

**Prédiction : Indépendance des objets**

Que vaut `book2.price` après l'exécution de ce code ?

```java
Book book1 = new Book("Java Guide", 45.0);
Book book2 = new Book("Python Basics", 35.0);
book1.price = 50.0;
```

**A.** `35.0` **B.** `45.0` **C.** `50.0` **D.** Erreur de compilation

## Question 6 - Réponse

**Réponse correcte : A** - `book2.price` vaut `35.0`

```java
Book book1 = new Book("Java Guide", 45.0);
Book book2 = new Book("Python Basics", 35.0);
book1.price = 50.0;  // Modifie uniquement book1
```

**Explications :**

- Chaque objet est **indépendant** et a ses propres valeurs
- Modifier `book1.price` n'affecte **pas** `book2.price`
- `book2` conserve sa valeur initiale de `35.0`

## Question 7 - Donnée

**Prédiction : Méthode avec retour**

Que vaut `area` après l'exécution de ce code ?

```java
class Rectangle {
    double width;
    double height;

    double calculateArea() {
        return width * height;
    }
}

Rectangle rect = new Rectangle();
rect.width = 5.0;
rect.height = 3.0;
double area = rect.calculateArea();
```

**A.** `0.0` **B.** `8.0` **C.** `15.0` **D.** Erreur

## Question 7 - Réponse

**Réponse correcte : C** - `area` vaut `15.0`

```java
double area = rect.calculateArea();
// width * height = 5.0 * 3.0 = 15.0
```

**Explications :**

- La méthode `calculateArea()` retourne `width * height`
- Les attributs `width` et `height` valent `5.0` et `3.0`
- Le calcul donne `5.0 * 3.0 = 15.0`
- La valeur retournée est stockée dans la variable `area`

## Question 8 - Donnée

**Comparaison : Classe vs Objet**

Quelle affirmation est correcte ?

**A.** Une classe est une instance d'un objet

**B.** Un objet est un modèle pour créer des classes

**C.** Une classe est un modèle pour créer des objets

**D.** Les termes "classe" et "objet" sont synonymes

## Question 8 - Réponse

**Réponse correcte : C**

**Une classe est un modèle pour créer des objets**

**Analogie :**

- **Classe** = plan d'architecte pour une maison
- **Objet** = maison réelle construite à partir du plan

**Différences :**

- **Classe** : définit les attributs et méthodes (modèle abstrait)
- **Objet** : instance concrète avec des valeurs spécifiques

## Question 9 - Donnée

**Comparaison : Attribut vs Variable locale**

Quelle est la différence entre ces deux variables `name` ?

```java
class Person {
    String name;  // Variable 1

    void displayInfo() {
        String name = "Temporary";  // Variable 2
        System.out.println(name);
    }
}
```

**A.** Aucune différence

**B.** Variable 1 = attribut, Variable 2 = variable locale

**C.** Variable 1 est publique, Variable 2 est privée

**D.** Variable 2 est un paramètre

## Question 9 - Réponse

**Réponse correcte : B**

**Variable 1 = attribut, Variable 2 = variable locale**

```java
class Person {
    String name;  // ATTRIBUT : appartient à l'objet

    void displayInfo() {
        String name = "Temporary";  // VARIABLE LOCALE : dans la méthode
        System.out.println(name);   // Affiche "Temporary"
        System.out.println(this.name);  // Affiche l'attribut
    }
}
```

**Différences :**

- **Attribut** : visible dans toute la classe, existe tant que l'objet existe
- **Variable locale** : visible uniquement dans la méthode, disparaît après

## Question 10 - Donnée

**Comparaison : Méthode void vs avec retour**

Quelle est la différence entre ces deux méthodes ?

```java
// Méthode A
void displayAge() {
    System.out.println("Âge: " + age);
}

// Méthode B
int getAge() {
    return age;
}
```

**A.** Aucune différence, elles font la même chose

**B.** A affiche, B retourne une valeur

**C.** A est publique, B est privée

**D.** B est un constructeur

## Question 10 - Réponse

**Réponse correcte : B**

**A affiche directement, B retourne une valeur**

```java
void displayAge() {
    System.out.println("Âge: " + age);  // Affiche directement
}

int getAge() {
    return age;  // Retourne la valeur pour utilisation ultérieure
}
```

**Utilisation :**

```java
person.displayAge();           // Affiche directement
int age = person.getAge();     // Récupère la valeur
if (person.getAge() > 18) { }  // Utilise dans une condition
```

## Question 11 - Donnée

**Modification : Ajouter un constructeur**

Cette classe n'a pas de constructeur. Ajoutez-en un qui initialise tous les
attributs :

```java
class Student {
    String name;
    int age;
    double averageGrade;
}
```

**A.** `void Student(String n, int a, double g)`

**B.** `public Student(String name, int age, double averageGrade)`

**C.** `new Student(String name, int age, double averageGrade)`

**D.** `Student() { }`

## Question 11 - Réponse

**Réponse correcte : B**

```java
class Student {
    String name;
    int age;
    double averageGrade;

    public Student(String name, int age, double averageGrade) {
        this.name = name;
        this.age = age;
        this.averageGrade = averageGrade;
    }
}
```

**Explications :**

- Constructeur = même nom que la classe, pas de type de retour
- Utilise `this` pour distinguer attributs et paramètres
- Permet de créer : `new Student("Alice", 20, 5.2)`

## Question 12 - Donnée

**Modification : Correction d'erreur**

Ce code ne compile pas. Quelle est l'erreur ?

```java
class Book {
    String title;
    double price;

    void Book(String title, double price) {
        this.title = title;
        this.price = price;
    }
}
```

**A.** Les attributs doivent être privés

**B.** Un constructeur ne doit pas avoir de type de retour (`void`)

**C.** Il manque le mot-clé `public`

**D.** `this` est mal utilisé

## Question 12 - Réponse

**Réponse correcte : B**

**Un constructeur ne doit pas avoir de type de retour**

**Code incorrect :**

```java
void Book(String title, double price) {  // ERREUR : void
```

**Code correct :**

```java
public Book(String title, double price) {  // Pas de void
    this.title = title;
    this.price = price;
}
```

**Règle :** Un constructeur n'a **jamais** de type de retour, même pas `void`

## Question 13 - Donnée

**Modification : Méthode qui modifie l'état**

Comment créer une méthode `incrementAge()` qui augmente l'âge de 1 ?

```java
class Person {
    String name;
    int age;

    // Ajoutez la méthode ici
}
```

**A.** `void incrementAge() { age = age + 1; }`

**B.** `int incrementAge() { return age + 1; }`

**C.** `void incrementAge() { int age = age + 1; }`

**D.** `void incrementAge(int age) { this.age = age + 1; }`

## Question 13 - Réponse

**Réponse correcte : A**

```java
class Person {
    String name;
    int age;

    void incrementAge() {
        age = age + 1;  // ou age++;
    }
}
```

**Explications :**

- **A** : modifie l'attribut directement, correct
- **B** : retourne une valeur mais ne modifie pas l'attribut
- **C** : crée une variable locale, ne modifie pas l'attribut
- **D** : prend un paramètre inutile qui masque l'attribut

## Question 14 - Donnée

**Transfert : Application complète**

Créez une classe `Counter` avec :

- Un attribut `value` (int)
- Un constructeur qui initialise `value` à 0
- Une méthode `increment()` qui augmente `value`
- Une méthode `getValue()` qui retourne `value`

Quelle implémentation est correcte ?

_(Voir options sur slide suivant)_

## Question 14 - Réponse (1/2)

**Option A (correcte) :**

```java
class Counter {
    int value;

    public Counter() {
        value = 0;
    }

    void increment() {
        value++;
    }

    int getValue() {
        return value;
    }
}
```

## Question 14 - Réponse (2/2)

**Réponse correcte : Option A**

**Pourquoi c'est correct :**

- Attribut `value` déclaré
- -Constructeur initialise à 0
- `increment()` modifie l'état (sans retour)
- `getValue()` retourne la valeur

**Utilisation :**

```java
Counter counter = new Counter();  // value = 0
counter.increment();               // value = 1
counter.increment();               // value = 2
int current = counter.getValue();  // current = 2
```

## Question 15 - Donnée

**Transfert : Système de bibliothèque**

Vous devez créer une classe `Book` pour un système de bibliothèque. Un livre a
un titre, un auteur, et peut être emprunté ou disponible. Quelle conception est
la meilleure ?

**A.** Trois classes séparées : `Title`, `Author`, `Status`

**B.** Une classe `Book` avec trois attributs et une méthode `borrow()`

**C.** Une classe `Book` avec seulement un attribut `String info`

**D.** Utiliser uniquement des variables sans classe

## Question 15 - Réponse (1/2)

**Réponse correcte : B**

```java
class Book {
    String title;
    String author;
    boolean isAvailable;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }

    boolean borrow() {
        if (isAvailable) {
            isAvailable = false;
            return true;
        }
        return false;
    }
}
```

## Question 15 - Réponse (2/2)

**Pourquoi cette conception ?**

**Avantages :**

- Regroupe les données et comportements liés
- État clair (`isAvailable`)
- Méthode qui modifie l'état de manière contrôlée
- Facile à utiliser et à maintenir

**Alternatives problématiques :**

- **A** : trop complexe pour ce besoin simple
- **C** : perte de structure, difficile à manipuler
- **D** : pas de POO, difficile à maintenir

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Luca Bravo](https://unsplash.com/@lucabravo) sur
  [Unsplash](https://unsplash.com/photos/black-flat-screen-computer-monitor-XJXWbfSo2f0)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/04-programmation-orientee-objet-classes-et-objets/README.md
[licence]: https://creativecommons.org/licenses/by-sa/4.0/

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1461749280684-dccba630e2f6?q=80&w=2069&auto=format&fit=crop
