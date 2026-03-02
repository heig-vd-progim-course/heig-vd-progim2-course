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

    ______(String brand, int year) {
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

**Comparaison : Classe vs Objet**

Quelle affirmation est correcte ?

**A.** Une classe est une instance d'un objet

**B.** Un objet est un modèle pour créer des classes

**C.** Une classe est un modèle pour créer des objets

**D.** Les termes "classe" et "objet" sont synonymes

## Question 7 - Réponse

**Réponse correcte : C - Une classe est un modèle pour créer des objets**

<div class="two-columns">
<div>

**Analogie :**

- **Classe** = plan d'architecte pour une maison
- **Objet** = maison réelle construite à partir du plan

</div>
<div>

**Différences :**

- **Classe** : définit les attributs et méthodes (modèle abstrait)
- **Objet** : instance concrète avec des valeurs spécifiques

</div>
</div>

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

## Question 9 - Réponse

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

## Question 10 - Réponse

**A affiche directement, B retourne une valeur**

<div class="two-columns">
<div>

```java
/**
 * Affiche l'âge directement
 */
void displayAge() {
    System.out.println("Âge: " + age);
}

/**
 * Retourne l'âge pour utilisation ultérieure
 */
int getAge() {
    return age;
}
```

</div>
<div>

**Utilisation :**

```java
// Affiche directement
person.displayAge();
// Récupère la valeur
int age = person.getAge();
// Utilise dans une condition
if (person.getAge() > 18) { }
```

</div>
</div>

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

## Question 12 - Réponse

**Réponse correcte : Un constructeur ne doit pas avoir de type de retour**

```java
// ERREUR : un constructeur ne doit pas avoir de type de retour, même pas void
void Book(String title, double price) {  // ERREUR : void

// ---

// CORRECT : pas de type de retour
public Book(String title, double price) {  // Pas de void
    this.title = title;
    this.price = price;
}
```

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Luca Bravo](https://unsplash.com/@lucabravo) sur
  [Unsplash](https://unsplash.com/photos/black-flat-screen-computer-monitor-XJXWbfSo2f0)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/04-programmation-orientee-objet-classes-et-objets/
[licence]: https://creativecommons.org/licenses/by-sa/4.0/

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1461749280684-dccba630e2f6?q=80&w=2069&auto=format&fit=crop
