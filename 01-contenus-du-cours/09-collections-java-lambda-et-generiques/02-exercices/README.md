# Collections Java : Lambda et génériques - Exercices

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
  - [Exercice 1 - forEach avec une lambda](#exercice-1---foreach-avec-une-lambda)
  - [Exercice 2 - removeIf avec un prédicat](#exercice-2---removeif-avec-un-prédicat)
  - [Exercice 3 - sort avec un Comparator](#exercice-3---sort-avec-un-comparator)
  - [Exercice 4 - Predicate en paramètre](#exercice-4---predicate-en-paramètre)
  - [Exercice 5 - classe générique simple](#exercice-5---classe-générique-simple)
- [Exercices de prédiction](#exercices-de-prédiction)
  - [Exercice 6 - type d'une lambda](#exercice-6---type-dune-lambda)
  - [Exercice 7 - removeIf et état](#exercice-7---removeif-et-état)
  - [Exercice 8 - effacement de type](#exercice-8---effacement-de-type)
- [Exercices de comparaison](#exercices-de-comparaison)
  - [Exercice 9 - boucle for-each vs forEach](#exercice-9---boucle-for-each-vs-foreach)
  - [Exercice 10 - Comparator anonyme vs lambda](#exercice-10---comparator-anonyme-vs-lambda)
- [Exercices de modification](#exercices-de-modification)
  - [Exercice 11 - remplacement par des lambdas](#exercice-11---remplacement-par-des-lambdas)
  - [Exercice 12 - ajout d'un paramètre de type générique](#exercice-12---ajout-dun-paramètre-de-type-générique)
- [Exercices de transfert](#exercices-de-transfert)
  - [Exercice 13 - filtrage de produits avec Predicate et génériques](#exercice-13---filtrage-de-produits-avec-predicate-et-génériques)
  - [Exercice 14 - boîte générique avec transformation](#exercice-14---boîte-générique-avec-transformation)
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

Ces exercices vous permettent de pratiquer la syntaxe des expressions lambda et
des génériques en complétant du code existant.

### Exercice 1 - forEach avec une lambda

Vous gérez une liste de plantes dans un jardin. Complétez le code pour afficher
chaque plante en majuscules en utilisant `forEach` avec une lambda.

```java
import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> plants = new ArrayList<>();
        plants.add("Tomate");
        plants.add("Carotte");
        plants.add("Basilic");
        plants.add("Menthe");

        System.out.println("Plantes en majuscules :");

        // TODO: Utilisez forEach avec une lambda pour afficher
        // chaque plante en majuscules (utilisez toUpperCase())

    }
}
```

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class ForEachExample {
    public static void main(String[] args) {
        List<String> plants = new ArrayList<>();
        plants.add("Tomate");
        plants.add("Carotte");
        plants.add("Basilic");
        plants.add("Menthe");

        System.out.println("Plantes en majuscules :");

        plants.forEach(plant ->
                System.out.println("  - " + plant.toUpperCase()));
    }
}
```

Sortie attendue :

```text
Plantes en majuscules :
  - TOMATE
  - CAROTTE
  - BASILIC
  - MENTHE
```

</details>

### Exercice 2 - removeIf avec un prédicat

Vous avez une liste de distances (en km) parcourues à vélo. Supprimez toutes les
distances inférieures à 5 km en utilisant `removeIf`.

```java
import java.util.ArrayList;
import java.util.List;

public class RemoveIfExample {
    public static void main(String[] args) {
        List<Double> distances = new ArrayList<>();
        distances.add(12.5);
        distances.add(3.2);
        distances.add(7.8);
        distances.add(1.5);
        distances.add(15.0);
        distances.add(4.9);

        System.out.println("Avant : " + distances);

        // TODO: Utilisez removeIf pour supprimer les distances < 5.0


        System.out.println("Après : " + distances);
    }
}
```

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class RemoveIfExample {
    public static void main(String[] args) {
        List<Double> distances = new ArrayList<>();
        distances.add(12.5);
        distances.add(3.2);
        distances.add(7.8);
        distances.add(1.5);
        distances.add(15.0);
        distances.add(4.9);

        System.out.println("Avant : " + distances);

        distances.removeIf(d -> d < 5.0);

        System.out.println("Après : " + distances);
    }
}
```

Sortie attendue :

```text
Avant : [12.5, 3.2, 7.8, 1.5, 15.0, 4.9]
Après : [12.5, 7.8, 15.0]
```

</details>

### Exercice 3 - sort avec un Comparator

Vous avez une liste de noms de villes. Triez-les par longueur de nom (du plus
court au plus long) en utilisant `sort` avec une lambda.

```java
import java.util.ArrayList;
import java.util.List;

public class SortLambdaExample {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Lausanne");
        cities.add("Yverdon");
        cities.add("Bex");
        cities.add("Montreux");
        cities.add("Nyon");

        System.out.println("Avant : " + cities);

        // TODO: Triez la liste par longueur de nom avec sort et
        // une lambda


        System.out.println("Après : " + cities);
    }
}
```

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class SortLambdaExample {
    public static void main(String[] args) {
        List<String> cities = new ArrayList<>();
        cities.add("Lausanne");
        cities.add("Yverdon");
        cities.add("Bex");
        cities.add("Montreux");
        cities.add("Nyon");

        System.out.println("Avant : " + cities);

        cities.sort((a, b) -> a.length() - b.length());

        System.out.println("Après : " + cities);
    }
}
```

Sortie attendue :

```text
Avant : [Lausanne, Yverdon, Bex, Montreux, Nyon]
Après : [Bex, Nyon, Yverdon, Lausanne, Montreux]
```

</details>

### Exercice 4 - Predicate en paramètre

Complétez la méthode `filterList` qui prend une liste et un `Predicate` en
paramètres, et retourne une nouvelle liste contenant uniquement les éléments qui
satisfont le prédicat.

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    // TODO: Complétez la méthode filterList
    public static List<String> filterList(List<String> list,
            Predicate<String> predicate) {
        List<String> result = new ArrayList<>();

        // TODO: Utilisez forEach avec le prédicat pour remplir result


        return result;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Java");
        words.add("Python");
        words.add("C");
        words.add("JavaScript");
        words.add("Go");
        words.add("Rust");

        List<String> shortWords =
                filterList(words, w -> w.length() <= 4);
        System.out.println("Mots courts : " + shortWords);

        List<String> startsWithJ =
                filterList(words, w -> w.startsWith("J"));
        System.out.println("Commence par J : " + startsWithJ);
    }
}
```

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

    public static List<String> filterList(List<String> list,
            Predicate<String> predicate) {
        List<String> result = new ArrayList<>();
        list.forEach(item -> {
            if (predicate.test(item)) {
                result.add(item);
            }
        });
        return result;
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("Java");
        words.add("Python");
        words.add("C");
        words.add("JavaScript");
        words.add("Go");
        words.add("Rust");

        List<String> shortWords =
                filterList(words, w -> w.length() <= 4);
        System.out.println("Mots courts : " + shortWords);

        List<String> startsWithJ =
                filterList(words, w -> w.startsWith("J"));
        System.out.println("Commence par J : " + startsWithJ);
    }
}
```

Sortie attendue :

```text
Mots courts : [Java, C, Go, Rust]
Commence par J : [Java, JavaScript]
```

</details>

### Exercice 5 - classe générique simple

Complétez la classe générique `Container` qui peut stocker un élément de
n'importe quel type. Ajoutez les méthodes manquantes.

```java
public class Container<T> {
    // TODO: Déclarez un attribut privé de type T nommé "value"


    // TODO: Créez un constructeur qui prend un paramètre de type T


    // TODO: Créez un getter getValue() qui retourne la valeur


    // TODO: Créez un setter setValue(T value)


    // TODO: Créez une méthode isEmpty() qui retourne true
    // si value est null


    @Override
    public String toString() {
        if (isEmpty()) {
            return "Container[vide]";
        }
        return "Container[" + value + "]";
    }

    public static void main(String[] args) {
        Container<String> nameContainer =
                new Container<>("Alice");
        System.out.println(nameContainer);
        System.out.println("Vide : " + nameContainer.isEmpty());

        Container<Integer> numberContainer =
                new Container<>(42);
        System.out.println(numberContainer);

        Container<Double> emptyContainer =
                new Container<>(null);
        System.out.println(emptyContainer);
        System.out.println("Vide : " + emptyContainer.isEmpty());
    }
}
```

<details>
<summary>Solution</summary>

```java
public class Container<T> {
    private T value;

    public Container(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public boolean isEmpty() {
        return value == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "Container[vide]";
        }
        return "Container[" + value + "]";
    }

    public static void main(String[] args) {
        Container<String> nameContainer =
                new Container<>("Alice");
        System.out.println(nameContainer);
        System.out.println("Vide : " + nameContainer.isEmpty());

        Container<Integer> numberContainer =
                new Container<>(42);
        System.out.println(numberContainer);

        Container<Double> emptyContainer =
                new Container<>(null);
        System.out.println(emptyContainer);
        System.out.println("Vide : " + emptyContainer.isEmpty());
    }
}
```

Sortie attendue :

```text
Container[Alice]
Vide : false
Container[42]
Container[vide]
Vide : true
```

</details>

## Exercices de prédiction

Ces exercices vous demandent de prédire le résultat d'un programme sans
l'exécuter.

### Exercice 6 - type d'une lambda

Analysez le code suivant. Quel est le type de l'interface fonctionnelle utilisée
dans chaque cas ? Quel sera le résultat affiché ?

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;

public class LambdaTypes {
    public static void main(String[] args) {
        Predicate<String> isLong = s -> s.length() > 5;
        Consumer<String> printer = s -> System.out.println(">> " + s);
        Function<String, Integer> toLength = s -> s.length();

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlotte");
        names.add("Eve");

        System.out.println("Test isLong :");
        names.forEach(name -> {
            if (isLong.test(name)) {
                printer.accept(name);
            }
        });

        System.out.println("Longueurs :");
        names.forEach(name ->
                System.out.println(name + " -> "
                        + toLength.apply(name)));
    }
}
```

<details>
<summary>Solution</summary>

- `isLong` est un `Predicate<String>` : prend un `String`, retourne un
  `boolean`.
- `printer` est un `Consumer<String>` : prend un `String`, ne retourne rien.
- `toLength` est un `Function<String, Integer>` : prend un `String`, retourne un
  `Integer`.

Sortie :

```text
Test isLong :
>> Charlotte
Longueurs :
Alice -> 5
Bob -> 3
Charlotte -> 9
Eve -> 3
```

Le `Predicate` `isLong` teste si la longueur est strictement supérieure à 5.
"Alice" a 5 caractères, donc `5 > 5` est `false`. Seule "Charlotte" (9
caractères) passe le test.

</details>

### Exercice 7 - removeIf et état

Quel sera le contenu de la liste après l'exécution de ce code ?

```java
import java.util.ArrayList;
import java.util.List;

public class RemoveIfPrediction {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(25);
        numbers.add(30);
        numbers.add(5);
        numbers.add(42);
        numbers.add(18);

        numbers.removeIf(n -> n % 2 == 0 && n > 20);

        System.out.println(numbers);
    }
}
```

<details>
<summary>Solution</summary>

Le `removeIf` supprime les éléments qui sont pairs ET supérieurs à 20. Analysons
chaque élément :

- 10 : pair ET > 20 ? 10 > 20 est `false` -> conservé.
- 25 : pair ET > 20 ? 25 % 2 == 0 est `false` -> conservé.
- 30 : pair ET > 20 ? `true` ET `true` -> **supprimé**.
- 5 : pair ET > 20 ? 5 % 2 == 0 est `false` -> conservé.
- 42 : pair ET > 20 ? `true` ET `true` -> **supprimé**.
- 18 : pair ET > 20 ? 18 > 20 est `false` -> conservé.

Sortie :

```text
[10, 25, 5, 18]
```

</details>

### Exercice 8 - effacement de type

Le code suivant compile-t-il ? Si oui, quel est le résultat ? Si non, pourquoi ?

```java
public class TypeErasure {
    public static void main(String[] args) {
        Box<String> box1 = new Box<>("Hello");
        Box<Integer> box2 = new Box<>(42);

        System.out.println(box1.getClass() == box2.getClass());
        System.out.println(box1.getClass().getName());
        System.out.println(box2.getClass().getName());
    }
}

class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
```

<details>
<summary>Solution</summary>

Le code compile sans erreur. L'effacement de type (type erasure) fait que les
paramètres de type sont supprimés à la compilation. Les deux objets sont de la
même classe `Box` à l'exécution.

Sortie :

```text
true
Box
Box
```

`box1.getClass() == box2.getClass()` retourne `true` car `Box<String>` et
`Box<Integer>` deviennent simplement `Box` après compilation. Il n'existe pas de
`Box<String>.class` ou `Box<Integer>.class` distinct à l'exécution.

</details>

## Exercices de comparaison

Ces exercices vous demandent de comparer deux approches pour résoudre un même
problème.

### Exercice 9 - boucle for-each vs forEach

Comparez les deux versions suivantes. Laquelle préférez-vous et pourquoi ?
Identifiez les avantages et inconvénients de chaque approche.

**Version A : boucle for-each classique**

```java
import java.util.ArrayList;
import java.util.List;

public class VersionA {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Pomme");
        fruits.add("Poire");
        fruits.add("Cerise");

        int count = 0;
        for (String fruit : fruits) {
            if (fruit.length() > 4) {
                System.out.println(fruit);
                count++;
            }
        }
        System.out.println("Total : " + count);
    }
}
```

**Version B : forEach avec lambda**

```java
import java.util.ArrayList;
import java.util.List;

public class VersionB {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();
        fruits.add("Pomme");
        fruits.add("Poire");
        fruits.add("Cerise");

        final int[] count = {0};
        fruits.forEach(fruit -> {
            if (fruit.length() > 4) {
                System.out.println(fruit);
                count[0]++;
            }
        });
        System.out.println("Total : " + count[0]);
    }
}
```

<details>
<summary>Solution</summary>

Les deux versions produisent le même résultat :

```text
Pomme
Poire
Cerise
Total : 3
```

Comparaison :

| Critère             | Version A (for-each) | Version B (forEach)   |
| :------------------ | :------------------- | :-------------------- |
| Lisibilité          | Claire et directe.   | Plus complexe.        |
| Compteur            | Simple `int count`.  | Nécessite un tableau. |
| Variables locales   | Accès libre.         | Doivent être final.   |
| Utilisation typique | Logique complexe.    | Opérations simples.   |
| Concision           | Plus de lignes.      | Moins de lignes.      |

La version A est préférable ici car elle nécessite un compteur mutable. Les
lambdas ne peuvent accéder qu'à des variables locales `final` ou effectivement
finales. La version B contourne cette restriction avec un tableau `int[]`, ce
qui rend le code moins lisible.

La méthode `forEach` est idéale pour des opérations simples sur chaque élément
(affichage, appel de méthode) sans modification de variables locales externes.

</details>

### Exercice 10 - Comparator anonyme vs lambda

Comparez ces deux versions de tri. Identifiez les différences syntaxiques.

**Version A : classe anonyme**

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortAnonymous {
    public static void main(String[] args) {
        List<String> tools = new ArrayList<>();
        tools.add("Bêche");
        tools.add("Arrosoir");
        tools.add("Sécateur");
        tools.add("Râteau");

        tools.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return a.length() - b.length();
            }
        });

        System.out.println(tools);
    }
}
```

**Version B : lambda**

```java
import java.util.ArrayList;
import java.util.List;

public class SortLambda {
    public static void main(String[] args) {
        List<String> tools = new ArrayList<>();
        tools.add("Bêche");
        tools.add("Arrosoir");
        tools.add("Sécateur");
        tools.add("Râteau");

        tools.sort((a, b) -> a.length() - b.length());

        System.out.println(tools);
    }
}
```

<details>
<summary>Solution</summary>

Les deux versions produisent le même résultat :

```text
[Bêche, Râteau, Arrosoir, Sécateur]
```

Différences syntaxiques :

| Aspect                     |  Version A (anonyme) | Version B (lambda) |
| :------------------------- | -------------------: | -----------------: |
| Lignes de code pour le tri |                    5 |                  1 |
| Import de Comparator       |           Nécessaire |     Non nécessaire |
| Déclaration de type        | Explicite (`String`) |   Inférée par Java |
| Nom de la méthode          |  `compare` explicite |         Pas de nom |
| Mot-clé `new`              |                  Oui |                Non |

La version B est préférée car :

- La lambda remplace directement l'interface fonctionnelle `Comparator`.
- Java infère automatiquement les types des paramètres `a` et `b`.
- Le code est beaucoup plus concis tout en restant lisible.

Les deux versions créent une implémentation de l'interface `Comparator<String>`.
La lambda est simplement une syntaxe plus compacte pour écrire la même chose.

</details>

## Exercices de modification

Ces exercices vous demandent de modifier du code existant pour utiliser des
lambdas ou des génériques.

### Exercice 11 - remplacement par des lambdas

Transformez le code suivant pour utiliser `forEach`, `removeIf` et `sort` avec
des lambdas à la place des boucles et de la classe anonyme.

```java
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RefactorToLambda {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Chat");
        animals.add("Chien");
        animals.add("Poisson");
        animals.add("Hamster");
        animals.add("Lapin");

        // 1. Afficher tous les animaux
        for (String animal : animals) {
            System.out.println("Animal : " + animal);
        }

        // 2. Supprimer les animaux avec un nom > 5 caractères
        Iterator<String> it = animals.iterator();
        while (it.hasNext()) {
            String animal = it.next();
            if (animal.length() > 5) {
                it.remove();
            }
        }
        System.out.println("Après suppression : " + animals);

        // 3. Trier par ordre alphabétique inverse
        animals.sort(new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        System.out.println("Après tri inverse : " + animals);
    }
}
```

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class RefactorToLambda {
    public static void main(String[] args) {
        List<String> animals = new ArrayList<>();
        animals.add("Chat");
        animals.add("Chien");
        animals.add("Poisson");
        animals.add("Hamster");
        animals.add("Lapin");

        // 1. Afficher tous les animaux avec forEach
        animals.forEach(animal ->
                System.out.println("Animal : " + animal));

        // 2. Supprimer les animaux avec un nom > 5 caractères
        animals.removeIf(animal -> animal.length() > 5);
        System.out.println("Après suppression : " + animals);

        // 3. Trier par ordre alphabétique inverse
        animals.sort((a, b) -> b.compareTo(a));
        System.out.println("Après tri inverse : " + animals);
    }
}
```

Sortie attendue :

```text
Animal : Chat
Animal : Chien
Animal : Poisson
Animal : Hamster
Animal : Lapin
Après suppression : [Chat, Chien, Lapin]
Après tri inverse : [Lapin, Chien, Chat]
```

Modifications effectuées :

- Boucle `for-each` remplacée par `forEach` avec lambda.
- Itérateur avec `while`/`remove` remplacé par `removeIf`.
- Classe anonyme `Comparator` remplacée par une lambda.
- Import de `Comparator` et `Iterator` supprimés.

</details>

### Exercice 12 - ajout d'un paramètre de type générique

La classe `Pair` suivante utilise `Object` pour stocker deux valeurs.
Modifiez-la pour utiliser des paramètres de type génériques `<K, V>` afin
d'assurer la sécurité des types.

```java
public class Pair {
    private Object key;
    private Object value;

    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public Object getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }

    public static void main(String[] args) {
        Pair p1 = new Pair("Nom", "Alice");
        Pair p2 = new Pair("Âge", 25);

        // Sans génériques, ce cast est nécessaire et risqué
        String name = (String) p1.getValue();
        int age = (int) p2.getValue();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("Nom : " + name);
        System.out.println("Âge : " + age);
    }
}
```

<details>
<summary>Solution</summary>

```java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return key + " = " + value;
    }

    public static void main(String[] args) {
        Pair<String, String> p1 = new Pair<>("Nom", "Alice");
        Pair<String, Integer> p2 = new Pair<>("Âge", 25);

        // Avec génériques, pas de cast nécessaire
        String name = p1.getValue();
        int age = p2.getValue();

        System.out.println(p1);
        System.out.println(p2);
        System.out.println("Nom : " + name);
        System.out.println("Âge : " + age);
    }
}
```

Sortie attendue :

```text
Nom = Alice
Âge = 25
Nom : Alice
Âge : 25
```

Modifications effectuées :

- Ajout de `<K, V>` dans la déclaration de la classe.
- Remplacement de `Object` par `K` pour la clé et `V` pour la valeur.
- Remplacement de `Object` par les types appropriés dans les getters.
- Dans le `main`, déclaration explicite des types lors de la création.
- Suppression des casts (`(String)`, `(int)`) devenus inutiles.

</details>

## Exercices de transfert

Ces exercices vous demandent d'appliquer les concepts dans un nouveau contexte,
en combinant lambdas et génériques.

### Exercice 13 - filtrage de produits avec Predicate et génériques

Créez une classe `Inventory<T>` générique qui gère une liste d'éléments avec les
fonctionnalités suivantes :

- `add(T item)` : ajouter un élément.
- `displayAll()` : afficher tous les éléments avec `forEach`.
- `removeMatching(Predicate<T> predicate)` : supprimer les éléments qui
  satisfont le prédicat.
- `filter(Predicate<T> predicate)` : retourner une nouvelle liste des éléments
  qui satisfont le prédicat.

Testez avec une classe `Product` ayant un nom et un prix.

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Inventory<T> {
    private List<T> items;

    public Inventory() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public void displayAll() {
        items.forEach(item -> System.out.println("  - " + item));
    }

    public void removeMatching(Predicate<T> predicate) {
        items.removeIf(predicate);
    }

    public List<T> filter(Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        items.forEach(item -> {
            if (predicate.test(item)) {
                result.add(item);
            }
        });
        return result;
    }

    public int size() {
        return items.size();
    }
}
```

```java
public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return name + " (" + price + " CHF)";
    }
}
```

```java
import java.util.List;

public class InventoryTest {
    public static void main(String[] args) {
        Inventory<Product> inventory = new Inventory<>();
        inventory.add(new Product("Terreau", 12.50));
        inventory.add(new Product("Graines de tomate", 3.90));
        inventory.add(new Product("Arrosoir", 24.00));
        inventory.add(new Product("Gants", 8.50));
        inventory.add(new Product("Sécateur", 19.90));

        System.out.println("Inventaire complet :");
        inventory.displayAll();

        List<Product> expensive =
                inventory.filter(p -> p.getPrice() > 15.0);
        System.out.println("\nProduits > 15 CHF :");
        expensive.forEach(p ->
                System.out.println("  - " + p));

        inventory.removeMatching(p -> p.getPrice() < 5.0);
        System.out.println("\nAprès suppression des produits "
                + "< 5 CHF :");
        inventory.displayAll();
        System.out.println("Taille : " + inventory.size());
    }
}
```

Sortie attendue :

```text
Inventaire complet :
  - Terreau (12.5 CHF)
  - Graines de tomate (3.9 CHF)
  - Arrosoir (24.0 CHF)
  - Gants (8.5 CHF)
  - Sécateur (19.9 CHF)

Produits > 15 CHF :
  - Arrosoir (24.0 CHF)
  - Sécateur (19.9 CHF)

Après suppression des produits < 5 CHF :
  - Terreau (12.5 CHF)
  - Arrosoir (24.0 CHF)
  - Gants (8.5 CHF)
  - Sécateur (19.9 CHF)
Taille : 4
```

</details>

### Exercice 14 - boîte générique avec transformation

Créez une classe générique `Box<T>` avec les fonctionnalités suivantes :

- Stocker une valeur de type `T`.
- `transform(Function<T, R> function)` : retourner une nouvelle `Box<R>`
  contenant le résultat de la transformation.
- `matches(Predicate<T> predicate)` : retourner `true` si la valeur satisfait le
  prédicat.
- `display(Consumer<T> consumer)` : appliquer une action sur la valeur.

Testez en créant une `Box<String>`, en la transformant en `Box<Integer>` (la
longueur de la chaîne), et en vérifiant des conditions.

<details>
<summary>Solution</summary>

```java
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public <R> Box<R> transform(Function<T, R> function) {
        R newValue = function.apply(value);
        return new Box<>(newValue);
    }

    public boolean matches(Predicate<T> predicate) {
        return predicate.test(value);
    }

    public void display(Consumer<T> consumer) {
        consumer.accept(value);
    }

    @Override
    public String toString() {
        return "Box[" + value + "]";
    }
}
```

```java
public class BoxTest {
    public static void main(String[] args) {
        Box<String> nameBox = new Box<>("Jardin communautaire");
        System.out.println("Boîte originale : " + nameBox);

        // Transformer String -> Integer (longueur)
        Box<Integer> lengthBox =
                nameBox.transform(s -> s.length());
        System.out.println("Après transformation : " + lengthBox);

        // Vérifier une condition
        boolean isLong =
                nameBox.matches(s -> s.length() > 10);
        System.out.println("Nom long (> 10) : " + isLong);

        boolean isShort =
                nameBox.matches(s -> s.length() < 5);
        System.out.println("Nom court (< 5) : " + isShort);

        // Afficher avec un Consumer
        nameBox.display(s ->
                System.out.println("Contenu : " + s));

        // Chaîner les transformations
        Box<String> upperBox =
                nameBox.transform(s -> s.toUpperCase());
        System.out.println("En majuscules : " + upperBox);

        Box<Boolean> checkBox =
                lengthBox.transform(n -> n > 15);
        System.out.println("Longueur > 15 : " + checkBox);
    }
}
```

Sortie attendue :

```text
Boîte originale : Box[Jardin communautaire]
Après transformation : Box[21]
Nom long (> 10) : true
Nom court (< 5) : false
Contenu : Jardin communautaire
En majuscules : Box[JARDIN COMMUNAUTAIRE]
Longueur > 15 : Box[true]
```

La méthode `transform` utilise un second paramètre de type `<R>` au niveau de la
méthode. Cela permet de retourner une `Box` d'un type différent de la `Box`
originale. C'est un exemple de méthode générique : le paramètre de type `R` est
déclaré sur la méthode, pas sur la classe.

</details>

## Conclusion

Vous avez pratiqué :

- Les expressions lambda avec `forEach`, `removeIf` et `sort`.
- Les interfaces fonctionnelles `Predicate`, `Consumer` et `Function`.
- La création de classes génériques avec des paramètres de type.
- La combinaison de lambdas et génériques pour écrire du code flexible et
  réutilisable.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
