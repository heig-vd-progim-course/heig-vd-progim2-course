# Exemple 00 - Exemple complet introductif

**Objectif pédagogique :** découvrir les concepts fondamentaux de la
programmation orientée objet à travers un exemple complet.

**Concepts illustrés :**

- Classe avec attributs
- Constructeur pour initialiser les objets
- Méthodes d'instance
- Utilisation du mot-clé `this`
- Création de plusieurs objets
- Interactions entre objets
- Passage d'objets en paramètre

## Description

Cet exemple introductif présente une vue d'ensemble de la programmation orientée
objet. La classe `Person` représente une personne avec un nom et un âge, et
montre comment les objets peuvent interagir entre eux.

Ce premier exemple illustre plusieurs concepts clés :

- **Attributs** : chaque personne a un nom et un âge
- **Constructeur** : permet d'initialiser les objets avec des valeurs
- **Méthodes** : permettent aux objets de réaliser des actions
- **Interactions** : les objets peuvent communiquer et se comparer

La classe `Person` contient trois méthodes intéressantes :

- `displayInfo()` : affiche les informations de base
- `displayAgeDifference(Person other)` : compare l'âge avec une autre personne
- `salute(Person other)` : permet de saluer une autre personne (ou soi-même !)

## Tutoriel pas à pas

Ce tutoriel montre l'évolution progressive du code, de l'approche procédurale
vers la programmation orientée objet. Chaque étape illustre un problème et sa
solution, jusqu'à arriver au code final.

### Étape 1 : Variables simples

#### Problème à résoudre

Nous voulons gérer les informations de plusieurs personnes (nom et âge) et
afficher ces informations, comparer les âges, et faire interagir les personnes.

#### Code

```java
public class Main {
    public static void main(String[] args) {
        String name1 = "Sacha";
        int age1 = 15;

        String name2 = "Yasmine";
        int age2 = 25;

        System.out.println(name1 + " a " + age1 + " ans.");
        System.out.println(name2 + " a " + age2 + " ans.");

        System.out.println(name2 + " est plus agée que " + name1);

        System.out.println(name2 + " salue " + name1);
    }
}
```

<details>
<summary>Description du code</summary>

Ce code utilise des variables simples pour représenter deux personnes. Pour
chaque personne, nous avons deux variables séparées : une pour le nom (`String`)
et une pour l'âge (`int`).

Les informations sont ensuite affichées en utilisant directement les noms des
variables dans les `System.out.println()`.

</details>

#### Problèmes identifiés

- **Code redondant** : chaque personne nécessite deux déclarations de variables
- **Pas de lien sémantique** : rien n'indique que `name1` et `age1` vont
  ensemble
- **Pas évolutif** : que faire si on veut gérer 3, 10 ou 100 personnes ?
- **Erreurs potentielles** : facile de mélanger les variables (utiliser `name1`
  avec `age2` par erreur)
- **Logique figée** : la comparaison d'âge est codée en dur pour ces deux
  personnes spécifiques

### Étape 2 : Utilisation de tableaux

#### Problème à résoudre

Nous voulons réduire la redondance et pouvoir gérer un nombre variable de
personnes plus facilement.

#### Code

```java
public class Main {
    public static void main(String[] args) {
        String[] names = {"Sacha", "Yasmine"};
        int[] ages = {15, 25};

        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " a " + ages[i] + " ans.");
        }

        System.out.println(names[1] + " est plus agée que " + names[0]);

        System.out.println(names[1] + " salue " + names[0]);
    }
}
```

<details>
<summary>Description du code</summary>

Cette version utilise deux tableaux parallèles : un pour les noms et un pour les
âges. L'index dans chaque tableau représente une personne (index 0 pour Sacha,
index 1 pour Yasmine).

Une boucle `for` permet d'afficher les informations de toutes les personnes sans
répéter le code.

</details>

#### Améliorations

- **Boucles possibles** : on peut parcourir toutes les personnes facilement
- **Plus extensible** : ajouter une personne = ajouter un élément dans chaque
  tableau

#### Problèmes restants

- **Tableaux parallèles** : les noms et âges sont dans des structures séparées
- **Pas de garantie de synchronisation** : rien n'empêche `names` et `ages`
  d'avoir des longueurs différentes
- **Indices sans signification** : `names[0]` ne dit pas qui est cette personne
- **Fragile** : si on modifie un tableau, il faut penser à modifier l'autre

### Étape 3 : Création de la classe `Person`

#### Problème à résoudre

Nous voulons **regrouper les données liées** (nom et âge) dans une seule entité
logique qui représente une personne.

#### Code

```java
class Person {
    String name;
    int age;
}

public class Main {
    public static void main(String[] args) {
        Person one = new Person();
        one.name = "Sacha";
        one.age = 15;

        Person two = new Person();
        two.name = "Yasmine";
        two.age = 25;

        System.out.println(one.name + " a " + one.age + " ans.");
        System.out.println(two.name + " a " + two.age + " ans.");

        System.out.println(two.name + " est plus agée que " + one.name);

        System.out.println(two.name + " salue " + one.name);
    }
}
```

<details>
<summary>Description du code</summary>

Nous créons une classe `Person` avec deux attributs : `name` et `age`. Cette
classe sert de "moule" pour créer des objets.

Dans la méthode `main`, nous créons deux objets `Person` avec `new Person()`.
Cette instruction appelle le **constructeur par défaut** qui alloue la mémoire
pour un nouvel objet.

Ensuite, nous assignons les valeurs aux attributs de chaque objet avec
`one.name`, `one.age`, etc.

</details>

#### Améliorations

- **Encapsulation des données** : le nom et l'âge sont regroupés dans un même
  objet
- **Cohérence garantie** : impossible d'avoir un nom sans âge associé
- **Code plus lisible** : `one.name` est plus clair que `names[0]`

#### Problèmes restants

- **Code encore redondant** : il faut trois lignes pour créer et initialiser un
  objet
- **Initialisation manuelle** : on doit assigner chaque attribut séparément

### Étape 4 : Ajout d'un constructeur

#### Problème à résoudre

Nous voulons **simplifier la création d'objets** en initialisant les attributs
directement lors de l'instanciation.

#### Code

```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Main {
    public static void main(String[] args) {
        Person one = new Person("Sacha", 15);
        Person two = new Person("Yasmine", 25);

        System.out.println(one.name + " a " + one.age + " ans.");
        System.out.println(two.name + " a " + two.age + " ans.");

        System.out.println(two.name + " est plus agée que " + one.name);

        System.out.println(two.name + " salue " + one.name);
    }
}
```

<details>
<summary>Description du code</summary>

Nous définissons un **constructeur** : une méthode spéciale qui porte le nom de
la classe et n'a pas de type de retour. Le constructeur est appelé
automatiquement lors de l'utilisation de `new Person(...)`.

Le mot-clé `this` permet de distinguer les attributs de l'objet (`this.name`)
des paramètres du constructeur (`name`).

**Important** : dès qu'on définit un constructeur personnalisé, le constructeur
par défaut (sans paramètres) disparaît. Si on voulait les deux, il faudrait
définir explicitement le constructeur sans paramètres.

</details>

#### Améliorations

- **Code plus concis** : une seule ligne pour créer et initialiser un objet
- **Initialisation forcée** : impossible de créer une personne sans nom ou sans
  âge
- **Moins d'erreurs** : on ne peut pas oublier d'initialiser un attribut

### Étape 5 : Ajout de la méthode `displayInfo()`

#### Problème à résoudre

Nous voulons **éviter la duplication** du code d'affichage et **encapsuler le
comportement** dans la classe elle-même.

#### Code

```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println(name + " a " + age + " ans.");
    }
}

public class Main {
    public static void main(String[] args) {
        Person one = new Person("Sacha", 15);
        Person two = new Person("Yasmine", 25);

        one.displayInfo();
        two.displayInfo();

        System.out.println(two.name + " est plus agée que " + one.name);

        System.out.println(two.name + " salue " + one.name);
    }
}
```

<details>
<summary>Description du code</summary>

Nous ajoutons une **méthode d'instance** `displayInfo()` qui affiche les
informations de l'objet courant. Cette méthode peut accéder directement aux
attributs `name` et `age` de l'objet sur lequel elle est appelée.

Lorsqu'on appelle `one.displayInfo()`, la méthode utilise les valeurs de `one`.
Lorsqu'on appelle `two.displayInfo()`, elle utilise les valeurs de `two`.

</details>

#### Améliorations

- **Responsabilité claire** : chaque objet sait comment s'afficher
- **Code plus maintenable** : si on change le format d'affichage, on le fait à
  un seul endroit
- **Polymorphisme futur** : cette approche permettra d'utiliser le polymorphisme
  plus tard

### Étape 6 : Interaction entre objets avec `displayAgeDifference()`

#### Problème à résoudre

Nous voulons **comparer deux objets** et que cette logique soit intégrée dans la
classe elle-même.

#### Code

```java
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayInfo() {
        System.out.println(name + " a " + age + " ans.");
    }

    public void displayAgeDifference(Person other) {
        if (this.age < other.age) {
            System.out.println(other.name + " est plus agée que " + this.name);
        } else if (this.age > other.age) {
            System.out.println(this.name + " est plus agée que " + other.name);
        } else {
            System.out.println("Elles ont le même âge");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Person one = new Person("Sacha", 15);
        Person two = new Person("Yasmine", 25);

        one.displayInfo();
        two.displayInfo();

        one.displayAgeDifference(two);

        System.out.println(two.name + " salue " + one.name);
    }
}
```

<details>
<summary>Description du code</summary>

La méthode `displayAgeDifference()` prend un autre objet `Person` en paramètre.
Elle compare l'âge de l'objet courant (`this.age`) avec l'âge de l'autre objet
(`other.age`).

Le mot-clé `this` représente l'objet sur lequel la méthode est appelée. Par
exemple, dans `one.displayAgeDifference(two)` :

- `this` représente `one` (Sacha)
- `other` représente `two` (Yasmine)

La méthode s'adapte automatiquement selon les objets utilisés. Si on appelle
`two.displayAgeDifference(one)`, les rôles sont inversés.

</details>

#### Améliorations

- **Logique réutilisable** : n'importe quelle personne peut se comparer à une
  autre
- **Code adaptatif** : la même méthode fonctionne pour toutes les combinaisons
  de personnes
- **Interaction entre objets** : les objets peuvent collaborer

### Étape 7 : Solution finale avec `salute()`

#### Problème à résoudre

Nous voulons permettre aux objets d'**interagir de diverses manières**, y
compris avec eux-mêmes.

#### Code (solution finale)

Voir le fichier `Main.java` pour le code complet.

<details>
<summary>Description du code</summary>

La méthode `salute()` permet à une personne de saluer une autre personne (ou
elle-même !). Comme pour `displayAgeDifference()`, elle prend un objet `Person`
en paramètre.

Des appels comme `one.salute(one)` sont parfaitement valides : un objet peut
interagir avec lui-même. Java ne fait pas de distinction particulière.

</details>

#### Avantages de la solution orientée objet finale

- **Encapsulation** : les données (attributs) et les comportements (méthodes)
  sont regroupés
- **Code auto-documenté** : `one.salute(two)` est immédiatement compréhensible
- **Extensibilité** : ajouter une troisième personne ne change rien au code
  existant
- **Maintenance facilitée** : la logique est centralisée dans la classe
- **Moins d'erreurs** : impossible de manipuler un nom sans son âge associé
- **Réutilisabilité** : la classe `Person` peut être utilisée dans d'autres
  contextes
- **Adaptabilité** : les méthodes fonctionnent avec n'importe quelle instance

### Note sur le constructeur par défaut

**Important** : Lorsqu'on ne définit aucun constructeur, Java fournit
automatiquement un **constructeur par défaut** sans paramètres :

```java
public Person() {
    // Constructeur par défaut implicite
}
```

Dès qu'on définit un constructeur personnalisé (comme
`Person(String name, int age)`), le constructeur par défaut disparaît. Si on
veut les deux, il faut les définir explicitement :

```java
public Person() {
    // Constructeur sans paramètres
}

public Person(String name, int age) {
    this.name = name;
    this.age = age;
}
```

Cela s'appelle la **surcharge de constructeur** (_constructor overloading_), un
concept que nous verrons plus en détail dans un module ultérieur.

## Code

Le fichier `Main.java` contient **deux classes** :

- La classe `Person` avec attributs, constructeur et méthodes
- La classe `Main` avec la méthode principale

**Note** : Le fichier s'appelle `Main.java` car c'est la classe `Main` qui est
publique. En Java, le nom du fichier doit correspondre au nom de la classe
publique.

## Sortie attendue

```text
Sacha a 15 ans.
Yasmine a 25 ans.
Yasmine est plus agée que Sacha
Yasmine salue Sacha
Sacha salue Sacha
Sacha salue Yasmine
Vincent salue Sacha
```
