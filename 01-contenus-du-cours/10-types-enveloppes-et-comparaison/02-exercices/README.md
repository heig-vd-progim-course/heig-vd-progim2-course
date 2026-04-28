# Types enveloppes et comparaison d'objets - Exercices

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
  - [Exercice 1a - compléter le code](#exercice-1a---compléter-le-code)
  - [Exercice 1b - autoboxing ou unboxing ?](#exercice-1b---autoboxing-ou-unboxing-)
  - [Exercice 2 - méthodes utilitaires](#exercice-2---méthodes-utilitaires)
  - [Exercice 3 - redéfinir equals()](#exercice-3---redéfinir-equals)
  - [Exercice 4 - redéfinir hashCode()](#exercice-4---redéfinir-hashcode)
  - [Exercice 5 - implémenter compareTo()](#exercice-5---implémenter-compareto)
- [Exercices de prédiction](#exercices-de-prédiction)
  - [Exercice 6 - comparaison d'Integer](#exercice-6---comparaison-dinteger)
  - [Exercice 7 - tri avec Comparable](#exercice-7---tri-avec-comparable)
- [Exercices de comparaison](#exercices-de-comparaison)
  - [Exercice 8 - int vs Integer](#exercice-8---int-vs-integer)
- [Exercices de modification](#exercices-de-modification)
  - [Exercice 9 - changer l'ordre de tri](#exercice-9---changer-lordre-de-tri)
- [Exercices de transfert](#exercices-de-transfert)
  - [Exercice 10 - la classe Book](#exercice-10---la-classe-book)
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

Ces exercices permettent de pratiquer la syntaxe des classes enveloppes et des
méthodes liées à la comparaison en complétant du code existant.

### Exercice 1a - compléter le code

Complétez le code suivant en remplaçant les `______` par les valeurs correctes.
Les commentaires indiquent ce qu'il faut compléter.

```java
Integer a = ______;                     // (1) assigner un entier
Integer c = ______;                     // (2) créer un Integer avec valueOf()
int d = ______;                         // (3) récupérer la valeur primitive de c
ArrayList<Integer> list = new ArrayList<>();
list.add(______);                       // (4) ajouter un entier littéral
```

> [!NOTE]
>
> Par "entier littéral", on entend un nombre entier écrit directement dans le
> code, par exemple `42` ou `-5`.

<details>
<summary>Corrigé</summary>

```java
Integer a = 10;
int b = Integer.valueOf(42);
Integer c = Integer.valueOf(5);
int d = c;
ArrayList<Integer> list = new ArrayList<>();
list.add(7);
int first = list.get(0);
```

</details>

### Exercice 1b - autoboxing ou unboxing ?

En vous basant sur le code complété de l'exercice 1a, indiquez pour chacune des
lignes numérotées si Java effectue un autoboxing, un unboxing, ou ni l'un ni
l'autre.

```java
Integer a = 10;                 // (1)
int b = Integer.valueOf(42);    // (2)
Integer c = Integer.valueOf(5); // (3)
int d = c;                      // (4)
ArrayList<Integer> list = new ArrayList<>();
list.add(7);                    // (5)
int first = list.get(0);        // (6)
```

<details>
<summary>Corrigé</summary>

- **(1)** : autoboxing — `int 10` est converti implicitement en `Integer`.
- **(2)** : unboxing — `Integer.valueOf(42)` retourne un `Integer`, assigné à
  `int b`.
- **(3)** : ni l'un ni l'autre — appel explicite à `valueOf()`, pas de
  conversion implicite.
- **(4)** : unboxing — `Integer c` est converti implicitement en `int`.
- **(5)** : autoboxing — `list.add()` attend un `Integer`, Java convertit `7`
  implicitement.
- **(6)** : unboxing — `list.get(0)` retourne un `Integer`, assigné à `int`.

</details>

### Exercice 2 - méthodes utilitaires

Écrivez le code pour :

1. Convertir la chaîne `"2014"` en `int` et stocker le résultat dans une
   variable `year`.
2. Convertir la chaîne `"8.6"` en `double` et stocker le résultat dans une
   variable `rating`.
3. Afficher la valeur maximale d'un `int`.
4. Tester si le caractère `'Z'` est une lettre et afficher le résultat.
5. Convertir le caractère `'Z'` en minuscule et afficher le résultat.

<details>
<summary>Corrigé</summary>

```java
// 1. Convertir une chaîne en int
int year = Integer.parseInt("2014");

// 2. Convertir une chaîne en double
double rating = Double.parseDouble("8.6");

// 3. Afficher la valeur maximale d'un int
System.out.println(Integer.MAX_VALUE);  // 2147483647

// 4. Tester si 'Z' est une lettre
System.out.println(Character.isLetter('Z'));  // true

// 5. Convertir 'Z' en minuscule
System.out.println(Character.toLowerCase('Z'));  // 'z'
```

</details>

### Exercice 3 - redéfinir equals()

Voici une classe `Book` incomplète. Deux livres sont considérés identiques s'ils
ont le même ISBN. Complétez la méthode `equals()`.

```java
public class Book {
    private String title;
    private String author;
    private String isbn;
    private Integer year;

    public Book(String title, String author, String isbn, Integer year) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
    }

    @Override
    public boolean equals(Object obj) {
        if (______ == obj) {
            return ______;
        }
        if (obj == ______ || ______ != obj.______()) {
            return ______;
        }
        Book other = (______) obj;
        return ______.equals(______);
    }
}
```

<details>
<summary>Corrigé</summary>

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (obj == null || getClass() != obj.getClass()) {
        return false;
    }
    Book other = (Book) obj;
    return isbn.equals(other.isbn);
}
```

Explication :

1. `this == obj` : si c'est le même objet, retourner `true` directement
   (optimisation).
2. `obj == null || getClass() != obj.getClass()` : si `obj` est `null` ou d'un
   autre type, retourner `false`.
3. Cast en `Book` et comparaison de l'ISBN avec `equals()`.

</details>

### Exercice 4 - redéfinir hashCode()

En utilisant la classe `Book` de l'exercice précédent, complétez la méthode
`hashCode()` en utilisant le même champ que dans `equals()`.

```java
@Override
public int hashCode() {
    return ______.hashCode();
}
```

Ensuite, répondez à cette question : si on ajoute un second champ à `equals()`
(par exemple l'auteur), que faut-il faire dans `hashCode()` ?

<details>
<summary>Corrigé</summary>

```java
@Override
public int hashCode() {
    return isbn.hashCode();
}
```

Si on ajoute `author` à `equals()` :

```java
@Override
public boolean equals(Object obj) {
    // ...
    return isbn.equals(other.isbn) && author.equals(other.author);
}

@Override
public int hashCode() {
    int result = isbn.hashCode();
    result = 31 * result + author.hashCode();
    return result;
}
```

Le contrat exige que `hashCode()` utilise **les mêmes champs** que `equals()`.
Si deux objets sont `equals()`, ils doivent avoir le même `hashCode()`.

</details>

### Exercice 5 - implémenter compareTo()

Complétez la méthode `compareTo()` dans la classe `Book` pour trier les livres
par **titre alphabétique** (ordre croissant A → Z).

```java
public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String isbn;
    private Integer year;

    // ...

    @Override
    public int compareTo(Book other) {
        return ______.compareTo(______);
    }
}
```

<details>
<summary>Corrigé</summary>

```java
@Override
public int compareTo(Book other) {
    return this.title.compareTo(other.title);
}
```

`String.compareTo()` retourne un entier négatif, nul ou positif selon l'ordre
alphabétique, ce qui est exactement le contrat de `compareTo()`. On délègue donc
à la méthode `compareTo()` de `String`.

Pour un tri décroissant (Z → A), il suffirait d'inverser :
`return other.title.compareTo(this.title);`

</details>

## Exercices de prédiction

Ces exercices consistent à prédire la sortie d'un programme sans l'exécuter.

### Exercice 6 - comparaison d'Integer

Quelle est la sortie de ce programme ?

```java
Integer a = 127;
Integer b = 127;
Integer x = 128;
Integer y = 128;

System.out.println(a == b);
System.out.println(x == y);
System.out.println(a.equals(b));
System.out.println(x.equals(y));
```

<details>
<summary>Corrigé</summary>

```text
true
false
true
true
```

- `a == b` : `true` car 127 est dans le cache JVM (-128 à 127), les deux
  variables pointent vers le même objet.
- `x == y` : `false` car 128 est hors du cache, Java crée deux objets distincts.
- `a.equals(b)` : `true`, `equals()` compare les valeurs.
- `x.equals(y)` : `true`, `equals()` compare les valeurs.

Leçon : ne jamais utiliser `==` pour comparer des `Integer` ; toujours utiliser
`equals()`.

</details>

### Exercice 7 - tri avec Comparable

Voici une classe `Temperature` qui implémente `Comparable<Temperature>` :

```java
public class Temperature implements Comparable<Temperature> {
    private double value;  // en degrés Celsius

    public Temperature(double value) { this.value = value; }

    public double getValue() { return value; }

    @Override
    public int compareTo(Temperature other) {
        return Double.compare(this.value, other.value);
    }

    @Override
    public String toString() { return value + "°C"; }
}
```

Quelle est la sortie de ce code ?

```java
ArrayList<Temperature> temps = new ArrayList<>();
temps.add(new Temperature(22.5));
temps.add(new Temperature(-5.0));
temps.add(new Temperature(37.2));
temps.add(new Temperature(0.0));

Collections.sort(temps);

for (Temperature t : temps) {
    System.out.println(t);
}
```

<details>
<summary>Corrigé</summary>

```text
-5.0°C
0.0°C
22.5°C
37.2°C
```

`Double.compare(this.value, other.value)` produit un tri croissant (de la plus
froide à la plus chaude). Pour un tri décroissant, il faudrait inverser :
`Double.compare(other.value, this.value)`.

</details>

## Exercices de comparaison

Ces exercices demandent de comparer deux approches différentes.

### Exercice 8 - int vs Integer

Comparez les deux versions de la classe `Counter` : l'une utilise `int`, l'autre
`Integer`.

**Version A :**

```java
public class Counter {
    private int count;

    public Counter() { count = 0; }

    public void increment() { count++; }

    public boolean isZero() { return count == 0; }

    public int getCount() { return count; }
}
```

**Version B :**

```java
public class Counter {
    private Integer count;

    public Counter() { count = 0; }

    public void increment() { count++; }

    public boolean isZero() { return count == 0; }

    public Integer getCount() { return count; }
}
```

Répondez :

1. Quelle version est préférable pour un compteur simple ? Pourquoi ?
2. Dans quels cas pourrait-on préférer `Integer` à `int` ?
3. Y a-t-il un risque dans la version B ? Lequel ?

<details>
<summary>Corrigé</summary>

1. **Version A est préférable** pour un compteur simple. Les types primitifs
   sont plus performants (pas d'allocation d'objet), plus lisibles et sans
   risque de `NullPointerException`.

2. On préférerait `Integer` quand la valeur peut être **absente** (null) : par
   exemple, un champ optionnel dans une classe de données, ou une valeur dans
   une `ArrayList<Integer>`. `Integer` permet de distinguer "non défini" de 0.

3. Dans la version B, si `count` était initialisé à `null` (au lieu de `0`),
   `count++` provoquerait une `NullPointerException` : Java tenterait d'unboxer
   `null` pour effectuer l'incrémentation.

</details>

## Exercices de modification

Ces exercices consistent à modifier du code existant pour changer son
comportement.

### Exercice 9 - changer l'ordre de tri

Voici la méthode `compareTo()` de `Movie` qui trie par note décroissante :

```java
@Override
public int compareTo(Movie other) {
    return Double.compare(other.rating, this.rating);
}
```

Modifiez-la pour trier par **titre alphabétique** (A → Z), puis par **année
croissante** en cas de titre identique.

<details>
<summary>Corrigé</summary>

```java
@Override
public int compareTo(Movie other) {
    // Tri primaire : titre alphabétique
    int titleComparison = this.title.compareTo(other.title);
    if (titleComparison != 0) {
        return titleComparison;
    }
    // Tri secondaire : année croissante
    return Integer.compare(this.year, other.year);
}
```

Si `titleComparison` est différent de zéro, les titres sont différents et on
retourne ce résultat. Si les titres sont identiques (résultat 0), on trie par
année avec `Integer.compare()`.

</details>

## Exercices de transfert

Ces exercices demandent d'appliquer les concepts du chapitre à une situation
nouvelle.

### Exercice 10 - la classe Book

Créez une classe `Book` complète avec les attributs suivants :

- `title` : `String`
- `author` : `String`
- `isbn` : `String`
- `year` : `Integer`
- `price` : `Double`

La classe doit :

1. Avoir un constructeur avec tous les attributs.
2. Avoir des getters pour chaque attribut.
3. Redéfinir `toString()` au format : `"Titre - Auteur (Année) - Prix CHF"`.
4. Redéfinir `equals()` : deux livres sont identiques s'ils ont le même ISBN.
5. Redéfinir `hashCode()` : utiliser l'ISBN.
6. Implémenter `Comparable<Book>` : tri par prix croissant.

Écrivez ensuite un programme principal qui :

1. Crée une liste de 4 livres.
2. Trie la liste avec `Collections.sort()`.
3. Affiche la liste triée.
4. Vérifie si un livre est présent dans un `HashSet` (en créant un nouvel objet
   avec le même ISBN).

<details>
<summary>Corrigé</summary>

```java
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Book implements Comparable<Book> {
    private String title;
    private String author;
    private String isbn;
    private Integer year;
    private Double price;

    public Book(String title, String author,
            String isbn, Integer year, Double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public Integer getYear() { return year; }
    public Double getPrice() { return price; }

    @Override
    public String toString() {
        return title + " - " + author
                + " (" + year + ") - " + price + " CHF";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Book other = (Book) obj;
        return isbn.equals(other.isbn);
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public int compareTo(Book other) {
        return Double.compare(this.price, other.price);
    }

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Clean Code", "R. Martin",
                "978-0132350884", 2008, 45.90));
        books.add(new Book("The Pragmatic Programmer",
                "D. Thomas", "978-0135957059", 2019, 55.00));
        books.add(new Book("Effective Java", "J. Bloch",
                "978-0134685991", 2018, 48.50));
        books.add(new Book("Head First Java", "K. Sierra",
                "978-0596009205", 2005, 38.00));

        Collections.sort(books);
        System.out.println("--- Livres triés par prix ---");
        for (Book b : books) {
            System.out.println(b);
        }

        HashSet<Book> library = new HashSet<>();
        library.add(books.get(0));
        Book search = new Book("Clean Code", "R. Martin",
                "978-0132350884", 2008, 45.90);
        System.out.println("\nlibrary.contains(search) : "
                + library.contains(search));  // true
    }
}
```

</details>

## Conclusion

Ces exercices couvrent les compétences principales du chapitre :

- L'autoboxing et l'unboxing, explicites et implicites.
- Les méthodes utilitaires des classes enveloppes.
- La redéfinition cohérente de `equals()` et `hashCode()`.
- L'implémentation de `Comparable<T>` pour définir un ordre naturel.
- Les pièges liés à `==` sur les `Integer` et à l'unboxing de `null`.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
