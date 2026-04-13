---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  Quiz sur le contenu Programmation orientée objet - Polymorphisme pour le cours
  ProgIM2 enseigné à la HEIG-VD, Suisse
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/06-programmation-orientee-objet-polymorphisme/quiz.html
header:
  "[**Programmation orientée objet : Polymorphisme -
  Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Programmation orientée objet : Polymorphisme - Quiz

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

**Complétion : instanceof**

Que retourne l'expression `instrument instanceof Guitar` ?

```java
Instrument instrument = new Guitar("Fender", 6);
System.out.println(instrument instanceof Guitar);
System.out.println(instrument instanceof Piano);
```

- **A.** `true`, `true`
- **B.** `true`, `false`
- **C.** `false`, `true`
- **D.** Erreur de compilation

## Question 1 - Réponse

**Réponse correcte : B** - `true`, `false`

```java
Instrument instrument = new Guitar("Fender", 6);
System.out.println(instrument instanceof Guitar);  // true
System.out.println(instrument instanceof Piano);   // false
```

`instanceof` vérifie le **type réel** de l'objet, pas le type de la référence.
L'objet est un `Guitar`, donc `instanceof Guitar` retourne `true` et
`instanceof Piano` retourne `false`.

## Question 2 - Donnée

**Prédiction : liaison dynamique**

Que va afficher ce code ?

```java
class Animal {
    void speak() { System.out.println("..."); }
}
class Dog extends Animal {
    @Override
    void speak() { System.out.println("Woof"); }
}
class Cat extends Animal {
    @Override
    void speak() { System.out.println("Meow"); }
}

Animal a = new Dog();
Animal b = new Cat();
a.speak();
b.speak();
```

## Question 2 - Réponse

**Sortie :**

```
Woof
Meow
```

Grâce à la **liaison dynamique**, Java appelle la méthode correspondant au
**type réel** de l'objet :

- `a` est déclaré `Animal` mais son type réel est `Dog` -> `speak()` de `Dog`
- `b` est déclaré `Animal` mais son type réel est `Cat` -> `speak()` de `Cat`

C'est le principe fondamental du polymorphisme.

## Question 3 - Donnée

**Complétion : interface**

Complétez le code pour définir et implémenter une interface :

```java
________ Waterable {
    void water(double liters);
}

class VegetablePlant extends PlantBase __________ Waterable {
    @Override
    public void water(double liters) {
        System.out.println("Arrosage avec " + liters + " litres");
    }
}
```

## Question 3 - Réponse

**Réponse correcte :**

```java
interface Waterable {
    void water(double liters);
}

class VegetablePlant extends PlantBase implements Waterable {
    @Override
    public void water(double liters) {
        System.out.println("Arrosage avec " + liters + " litres");
    }
}
```

- `interface` pour définir le contrat.
- `implements` pour s'engager à fournir l'implémentation.
- Les méthodes doivent être `public` dans la classe.

## Question 4 - Donnée

**Comparaison : interface vs classe abstraite**

Quelle est la différence principale entre une interface et une classe abstraite
en Java ?

- **A.** Une interface peut contenir des attributs d'instance, pas une classe
  abstraite.
- **B.** Une classe peut implémenter plusieurs interfaces mais hériter d'une
  seule classe abstraite.
- **C.** Une classe abstraite ne peut pas avoir de méthodes concrètes.
- **D.** Il n'y a aucune différence.

## Question 4 - Réponse

**Réponse correcte : B**

| Aspect               | Interface                  | Classe abstraite       |
| :------------------- | :------------------------- | :--------------------- |
| Attributs d'instance | Non (constantes seulement) | Oui                    |
| Méthodes concrètes   | Depuis Java 8 (par défaut) | Oui                    |
| Héritage multiple    | Oui (plusieurs interfaces) | Non (une seule classe) |
| But principal        | Définir des capacités      | Partager du code       |

## Question 5 - Donnée

**Complétion : toString()**

Que va afficher ce code ?

```java
class Plant {
    String name;
    Plant(String name) { this.name = name; }
}

class Flower extends Plant {
    Flower(String name) { super(name); }

    @Override
    public String toString() {
        return "Fleur: " + name;
    }
}

System.out.println(new Plant("Rose"));
System.out.println(new Flower("Tulipe"));
```

## Question 5 - Réponse

**Sortie :**

```
Plant@1a2b3c4d  (adresse mémoire)
Fleur: Tulipe
```

- `Plant` n'a pas redéfini `toString()` -> affiche le nom de la classe et
  l'adresse mémoire (hérité de `Object`).
- `Flower` a redéfini `toString()` -> affiche `"Fleur: Tulipe"`.
- `System.out.println()` appelle automatiquement `toString()`.

## Question 6 - Donnée

**Prédiction : equals()**

Que va afficher ce code ?

```java
class Seed {
    String name;
    Seed(String name) { this.name = name; }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Seed seed = (Seed) obj;
        return name.equals(seed.name);
    }
}

Seed s1 = new Seed("Tomate");
Seed s2 = new Seed("Tomate");
Seed s3 = s1;
System.out.println(s1 == s2);
System.out.println(s1.equals(s2));
System.out.println(s1 == s3);
```

## Question 6 - Réponse

**Sortie :**

```
false
true
true
```

- `s1 == s2` : `false` car ce sont deux objets différents en mémoire.
- `s1.equals(s2)` : `true` car `equals()` compare le contenu (`name`).
- `s1 == s3` : `true` car `s3` est une copie de la référence, ils pointent vers
  le même objet.

## Question 7 - Donnée

**Complétion : polymorphisme avec tableau**

Complétez le code pour traiter des objets de manière polymorphe :

```java
interface Harvestable {
    double harvest();
}

Harvestable[] crops = new Harvestable[2];
crops[0] = new VegetablePlant("Tomate", "Solanum", "2026-03-15", 0, 90);
crops[1] = new VegetablePlant("Carotte", "Daucus", "2026-04-01", 0, 120);

double totalHarvest = 0;
for (________________ crop : crops) {
    totalHarvest += crop.________();
}
```

## Question 7 - Réponse

**Réponse correcte :**

```java
for (Harvestable crop : crops) {
    totalHarvest += crop.harvest();
}
```

Le type de la boucle `for-each` est `Harvestable` (l'interface). On peut appeler
`harvest()` sur chaque élément car toutes les classes du tableau implémentent
l'interface `Harvestable`.

C'est le polymorphisme par interface : traiter des objets différents de manière
uniforme.

## Question 8 - Donnée

**Prédiction : hashCode()**

Pourquoi faut-il toujours redéfinir `hashCode()` en même temps que `equals()` ?

- **A.** C'est une obligation du compilateur Java.
- **B.** Sans cela, les collections comme `HashSet` ne fonctionnent pas
  correctement.
- **C.** `hashCode()` est appelé avant `equals()` dans tous les cas.
- **D.** C'est une convention de style, pas une obligation technique.

## Question 8 - Réponse

**Réponse correcte : B**

Si deux objets sont égaux selon `equals()`, ils **doivent** avoir le même
`hashCode()`.

```java
Seed s1 = new Seed("Tomate");
Seed s2 = new Seed("Tomate");

// Sans hashCode() correct :
Set<Seed> set = new HashSet<>();
set.add(s1);
set.add(s2);
// set.size() = 2  (devrait être 1 !)
```

Les `HashSet` et `HashMap` utilisent `hashCode()` pour localiser les objets.
Sans cohérence avec `equals()`, ils ne détectent pas les doublons.

## Question 9 - Donnée

Ce code ne compile pas. Pourquoi ?

```java
interface Printable {
    void print();
}

class Report implements Printable {
    void print() {
        System.out.println("Rapport imprimé");
    }
}
```

- **A.** Une interface ne peut pas avoir de méthode `print()`.
- **B.** La méthode `print()` doit être déclarée `public` dans `Report`.
- **C.** Il manque `@Override` avant la méthode.
- **D.** `Report` devrait utiliser `extends` au lieu de `implements`.

## Question 9 - Réponse

**Réponse correcte : B**

```java
class Report implements Printable {
    @Override
    public void print() {  // DOIT être public
        System.out.println("Rapport imprimé");
    }
}
```

Les méthodes d'une interface sont implicitement `public`. Lors de
l'implémentation, la visibilité ne peut pas être réduite. Il faut donc
explicitement déclarer la méthode `public`.

## Question 10 - Donnée

**Prédiction : plusieurs interfaces**

Ce code compile-t-il ?

```java
interface Flyable {
    void fly();
}

interface Swimmable {
    void swim();
}

class Duck implements Flyable, Swimmable {
    @Override
    public void fly() {
        System.out.println("Le canard vole");
    }

    @Override
    public void swim() {
        System.out.println("Le canard nage");
    }
}
```

## Question 10 - Réponse

**Oui, ce code compile parfaitement.**

Une classe peut implémenter **plusieurs interfaces**. C'est un avantage des
interfaces par rapport à l'héritage simple.

```java
Duck donald = new Duck();
donald.fly();   // "Le canard vole"
donald.swim();  // "Le canard nage"

// Polymorphisme : on peut utiliser chaque interface
Flyable flyer = donald;
Swimmable swimmer = donald;
```

C'est impossible avec des classes : Java ne supporte pas l'héritage multiple de
classes (`extends A, B` ne compile pas).

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Markus Spiske](https://unsplash.com/@markusspiske) sur
  [Unsplash](https://unsplash.com/photos/blue-and-white-logo-guessing-game-iar-afB0QQw)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/06-programmation-orientee-objet-polymorphisme/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1611519541067-46c8f2d05f11?fit=crop&h=720
