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

Déclaration de la classe `Main` avec le modificateur `public`.

Déclaration de la méthode `main` avec les modificateurs `public static void` et
le paramètre `String[] args`. Cette méthode est le point d'entrée du programme.

Déclaration et initialisation d'une variable de type `String` nommée `name1`
avec la valeur `"Sacha"`.

Déclaration et initialisation d'une variable de type `int` nommée `age1` avec la
valeur `15`.

Déclaration et initialisation d'une variable de type `String` nommée `name2`
avec la valeur `"Yasmine"`.

Déclaration et initialisation d'une variable de type `int` nommée `age2` avec la
valeur `25`.

Appel de la méthode statique `println` de l'objet `out` (de type `PrintStream`)
de la classe `System`. Passage en argument d'une expression de concaténation de
chaînes de caractères (opérateur `+`) entre les variables `name1`, la chaîne
`" a "`, la variable `age1` et la chaîne `" ans."`.

Appel de la méthode statique `println` avec concaténation similaire pour `name2`
et `age2`.

Appel de la méthode statique `println` avec concaténation de `name2`, la chaîne
`" est plus agée que "` et `name1`.

Appel de la méthode statique `println` avec concaténation de `name2`, la chaîne
`" salue "` et `name1`.

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

**Changements par rapport à l'Étape 1 :**

Déclaration et initialisation d'un tableau de type `String[]` nommé `names` avec
les valeurs `"Sacha"` et `"Yasmine"` (syntaxe d'initialisation avec accolades).

Déclaration et initialisation d'un tableau de type `int[]` nommé `ages` avec les
valeurs `15` et `25`.

Structure de contrôle `for` avec :

- Initialisation : déclaration et initialisation d'une variable de type `int`
  nommée `i` avec la valeur `0`.
- Condition : comparaison (opérateur `<`) entre la variable `i` et l'attribut
  `length` du tableau `names`.
- Incrémentation : post-incrémentation (opérateur `++`) de la variable `i`.

Dans le corps de la boucle : appel de `println` avec concaténation utilisant les
éléments du tableau `names` à l'index `i` et `ages` à l'index `i`.

Appel de `println` avec concaténation utilisant `names[1]` (Yasmine) et
`names[0]` (Sacha).

Appel de `println` avec concaténation utilisant `names[1]` et `names[0]`.

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

**Changements par rapport à l'Étape 2 :**

Déclaration d'une classe `Person` (sans modificateur d'accès, donc visibilité
par défaut dans le package).

Déclaration d'un attribut de type `String` nommé `name` (visibilité par défaut
dans le package).

Déclaration d'un attribut de type `int` nommé `age` (visibilité par défaut dans
le package).

Dans la méthode `main` :

Déclaration et initialisation d'une variable de type `Person` nommée `one` avec
un nouvel objet créé par l'opérateur `new` et l'appel au constructeur par défaut
`Person()` (implicite, fourni automatiquement par Java).

Affectation (opérateur `=`) de la valeur `"Sacha"` à l'attribut `name` de
l'objet référencé par `one` (accès avec opérateur `.`).

Affectation de la valeur `15` à l'attribut `age` de l'objet référencé par `one`.

Déclaration et initialisation d'une variable de type `Person` nommée `two` avec
un nouvel objet créé par l'opérateur `new` et l'appel au constructeur par défaut
`Person()`.

Affectation de la valeur `"Yasmine"` à l'attribut `name` de l'objet référencé
par `two`.

Affectation de la valeur `25` à l'attribut `age` de l'objet référencé par `two`.

Appels de `println` avec concaténation utilisant les attributs `name` et `age`
des objets `one` et `two` (accès avec opérateur `.`).

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

**Changements par rapport à l'Étape 3 :**

Dans la classe `Person` :

Déclaration d'un constructeur avec le modificateur `public`, portant le nom de
la classe `Person`, sans type de retour. Le constructeur prend deux paramètres :
un paramètre de type `String` nommé `name` et un paramètre de type `int` nommé
`age`.

Dans le corps du constructeur : affectation de la valeur du paramètre `name` à
l'attribut `name` de l'objet courant (référencé par le mot-clé `this`). Le
mot-clé `this` permet de lever l'ambiguïté entre le paramètre et l'attribut de
même nom.

Affectation de la valeur du paramètre `age` à l'attribut `age` de l'objet
courant (référencé par `this`).

Dans la méthode `main` :

Déclaration et initialisation d'une variable de type `Person` nommée `one` avec
un nouvel objet créé par l'opérateur `new` et l'appel au constructeur
`Person(String, int)` avec les arguments `"Sacha"` et `15`.

Déclaration et initialisation d'une variable de type `Person` nommée `two` avec
un nouvel objet créé par l'appel au constructeur `Person(String, int)` avec les
arguments `"Yasmine"` et `25`.

**Note** : les affectations manuelles aux attributs (comme `one.name = ...`) ne
sont plus nécessaires, l'initialisation se fait dans le constructeur.

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

**Changements par rapport à l'Étape 4 :**

Dans la classe `Person` :

Déclaration d'une méthode d'instance avec le modificateur `public`, de type de
retour `void`, nommée `displayInfo`, sans paramètre.

Dans le corps de la méthode : appel de `println` avec concaténation des
attributs `name` et `age` de l'objet courant (accès direct sans `this` car il
n'y a pas d'ambiguïté).

Dans la méthode `main` :

Appel de la méthode `displayInfo` sur l'objet référencé par `one` (opérateur
`.`).

Appel de la méthode `displayInfo` sur l'objet référencé par `two`.

**Note** : les appels directs à `System.out.println(one.name + ...)` ne sont
plus nécessaires, remplacés par les appels à la méthode `displayInfo()`.

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

**Changements par rapport à l'Étape 5 :**

Dans la classe `Person` :

Déclaration d'une méthode d'instance avec le modificateur `public`, de type de
retour `void`, nommée `displayAgeDifference`, prenant un paramètre de type
`Person` nommé `other`.

Dans le corps de la méthode : structure conditionnelle `if-else if-else` :

- Condition `if` : comparaison (opérateur `<`) entre l'attribut `age` de l'objet
  courant (`this.age`) et l'attribut `age` de l'objet `other` (`other.age`). Si
  vrai, appel de `println` avec concaténation indiquant que `other` est plus
  agée que `this`.
- Condition `else if` : comparaison (opérateur `>`) entre `this.age` et
  `other.age`. Si vrai, appel de `println` indiquant que `this` est plus agée
  que `other`.
- Bloc `else` : appel de `println` avec le message `"Elles ont le même âge"`.

Dans la méthode `main` :

Appel de la méthode `displayAgeDifference` sur l'objet référencé par `one` avec
comme argument l'objet référencé par `two`.

**Note** : l'appel direct à
`System.out.println(two.name + " est plus agée que " + one.name)` est remplacé
par l'appel à la méthode `displayAgeDifference()`.

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

**Changements par rapport à l'Étape 6 :**

Dans la classe `Person` :

Déclaration d'une méthode d'instance avec le modificateur `public`, de type de
retour `void`, nommée `salute`, prenant un paramètre de type `Person` nommé
`other`.

Dans le corps de la méthode : appel de `println` avec concaténation de
l'attribut `name` de l'objet courant, la chaîne `" salue "` et l'attribut `name`
de l'objet `other`.

Dans la méthode `main` :

La méthode `salute()` est appelée plusieurs fois (voir le fichier `Main.java`
pour les détails complets), y compris avec des appels comme `one.salute(one)` où
un objet interagit avec lui-même.

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
