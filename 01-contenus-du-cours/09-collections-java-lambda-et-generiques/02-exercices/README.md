# Collections Java : Les génériques - Exercices

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
  - [Exercice 1 - classe générique simple](#exercice-1---classe-générique-simple)
  - [Exercice 2 - méthode générique](#exercice-2---méthode-générique)
  - [Exercice 3 - classe générique à deux paramètres](#exercice-3---classe-générique-à-deux-paramètres)
- [Exercices de prédiction](#exercices-de-prédiction)
  - [Exercice 4 - effacement de type](#exercice-4---effacement-de-type)
  - [Exercice 5 - sécurité de type avec les génériques](#exercice-5---sécurité-de-type-avec-les-génériques)
- [Exercices de comparaison](#exercices-de-comparaison)
  - [Exercice 6 - Object vs générique](#exercice-6---object-vs-générique)
- [Exercices de modification](#exercices-de-modification)
  - [Exercice 7 - ajout d'un paramètre de type générique](#exercice-7---ajout-dun-paramètre-de-type-générique)
- [Exercices de transfert](#exercices-de-transfert)
  - [Exercice 8 - registre générique](#exercice-8---registre-générique)
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

Ces exercices vous permettent de pratiquer la syntaxe des génériques en
complétant du code existant.

### Exercice 1 - classe générique simple

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

### Exercice 2 - méthode générique

Complétez la classe `ArrayUtils` en créant deux méthodes génériques :

- `printAll` : affiche tous les éléments d'une liste.
- `getFirst` : retourne le premier élément d'une liste ou `null` si la liste est
  vide.

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    // TODO: Créez une méthode générique statique printAll
    // qui prend une List<T> et affiche chaque élément


    // TODO: Créez une méthode générique statique getFirst
    // qui prend une List<T> et retourne le premier élément
    // ou null si la liste est vide


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("Tous les noms :");
        printAll(names);

        String first = getFirst(names);
        System.out.println("Premier : " + first);

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Premier (liste vide) : "
                + getFirst(numbers));
    }
}
```

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class ArrayUtils {

    public static <T> void printAll(List<T> items) {
        for (T item : items) {
            System.out.println("  - " + item);
        }
    }

    public static <T> T getFirst(List<T> items) {
        if (items.isEmpty()) {
            return null;
        }
        return items.get(0);
    }

    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        System.out.println("Tous les noms :");
        printAll(names);

        String first = getFirst(names);
        System.out.println("Premier : " + first);

        List<Integer> numbers = new ArrayList<>();
        System.out.println("Premier (liste vide) : "
                + getFirst(numbers));
    }
}
```

Sortie attendue :

```text
Tous les noms :
  - Alice
  - Bob
  - Charlie
Premier : Alice
Premier (liste vide) : null
```

La syntaxe `<T>` avant le type de retour déclare le paramètre de type au niveau
de la méthode. Java infère automatiquement `T` comme `String` ou `Integer` selon
la liste passée en argument.

</details>

### Exercice 3 - classe générique à deux paramètres

Complétez la classe `Pair<K, V>` qui associe une clé à une valeur. Ajoutez les
attributs, le constructeur et les getters manquants.

```java
public class Pair<K, V> {
    // TODO: Déclarez deux attributs privés : key de type K
    // et value de type V


    // TODO: Créez un constructeur qui prend une clé et une valeur


    // TODO: Créez les getters getKey() et getValue()


    @Override
    public String toString() {
        return key + " -> " + value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> age =
                new Pair<>("Alice", 22);
        System.out.println(age);
        System.out.println("Clé : " + age.getKey());
        System.out.println("Valeur : " + age.getValue());

        Pair<Integer, String> lookup =
                new Pair<>(404, "Non trouvé");
        System.out.println(lookup);
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
        return key + " -> " + value;
    }

    public static void main(String[] args) {
        Pair<String, Integer> age =
                new Pair<>("Alice", 22);
        System.out.println(age);
        System.out.println("Clé : " + age.getKey());
        System.out.println("Valeur : " + age.getValue());

        Pair<Integer, String> lookup =
                new Pair<>(404, "Non trouvé");
        System.out.println(lookup);
    }
}
```

Sortie attendue :

```text
Alice -> 22
Clé : Alice
Valeur : 22
404 -> Non trouvé
```

La classe utilise deux paramètres de type `K` et `V`. Lors de l'instanciation,
on spécifie les types concrets : `Pair<String, Integer>` pour la première
instance et `Pair<Integer, String>` pour la seconde.

</details>

## Exercices de prédiction

Ces exercices vous demandent de prédire le résultat d'un programme sans
l'exécuter.

### Exercice 4 - effacement de type

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

### Exercice 5 - sécurité de type avec les génériques

Analysez le code suivant. Quelles lignes provoquent une erreur de compilation ?
Pourquoi ?

```java
import java.util.ArrayList;
import java.util.List;

public class TypeSafety {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add(42);                       // Ligne A

        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        String s = numbers.get(0);           // Ligne B

        List<Object> objects = new ArrayList<>();
        objects.add("Texte");
        objects.add(42);
        objects.add(3.14);                   // Ligne C

        List<String> copy = names;
        Integer n = copy.get(0);             // Ligne D
        String first = copy.get(0);          // Ligne E
    }
}
```

<details>
<summary>Solution</summary>

Erreurs de compilation :

- **Ligne A** : erreur. `names` est de type `List<String>`, on ne peut pas
  ajouter un `int` (42). Le compilateur détecte l'incompatibilité de type.
- **Ligne B** : erreur. `numbers.get(0)` retourne un `Integer`, pas un `String`.
  Le compilateur refuse l'affectation.
- **Ligne C** : pas d'erreur. `objects` est de type `List<Object>`, et `String`,
  `Integer` et `Double` héritent tous de `Object`.
- **Ligne D** : erreur. `copy.get(0)` retourne un `String`, pas un `Integer`. Le
  compilateur refuse l'affectation.
- **Ligne E** : pas d'erreur. `copy.get(0)` retourne un `String` et la variable
  est de type `String`.

Les lignes A, B et D ne compilent pas. Les génériques détectent ces erreurs
avant l'exécution, ce qui est l'un de leurs principaux avantages.

</details>

## Exercices de comparaison

Ces exercices vous demandent de comparer deux approches pour résoudre un même
problème.

### Exercice 6 - Object vs générique

Comparez les deux versions suivantes d'une classe `Box`. Identifiez les
avantages et inconvénients de chaque approche.

**Version A : avec Object**

```java
public class ObjectBox {
    private Object value;

    public ObjectBox(Object value) {
        this.value = value;
    }

    public Object getValue() {
        return value;
    }

    public static void main(String[] args) {
        ObjectBox box = new ObjectBox("Hello");
        String text = (String) box.getValue();
        System.out.println(text.toUpperCase());

        ObjectBox box2 = new ObjectBox(42);
        String oops = (String) box2.getValue();
    }
}
```

**Version B : avec générique**

```java
public class GenericBox<T> {
    private T value;

    public GenericBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public static void main(String[] args) {
        GenericBox<String> box = new GenericBox<>("Hello");
        String text = box.getValue();
        System.out.println(text.toUpperCase());

        GenericBox<Integer> box2 = new GenericBox<>(42);
        // String oops = box2.getValue(); // Erreur de compilation
    }
}
```

<details>
<summary>Solution</summary>

Comparaison :

| Critère          | Version A (Object)                | Version B (générique)                  |
| :--------------- | :-------------------------------- | :------------------------------------- |
| Sécurité de type | Aucune. Erreurs à l'exécution.    | Complète. Erreurs à la compilation.    |
| Cast nécessaire  | Oui, à chaque `getValue()`.       | Non, le type est connu.                |
| Risque runtime   | `ClassCastException` possible.    | Aucun risque de cast.                  |
| Réutilisabilité  | Accepte tout, mais sans contrôle. | Accepte tout, avec contrôle.           |
| Lisibilité       | Le type réel n'est pas visible.   | Le type est explicite (`Box<String>`). |

La version A compile sans erreur, mais `(String) box2.getValue()` provoque une
`ClassCastException` à l'exécution car la valeur est un `Integer`.

La version B est préférable car :

- Le compilateur détecte les erreurs de type avant l'exécution.
- Pas de cast manuel nécessaire.
- Le code est plus lisible car le type est explicite dans la déclaration.

</details>

## Exercices de modification

Ces exercices vous demandent de modifier du code existant pour utiliser des
génériques.

### Exercice 7 - ajout d'un paramètre de type générique

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

Ces exercices vous demandent d'appliquer les concepts des génériques dans un
nouveau contexte.

### Exercice 8 - registre générique

Créez une classe `Registry<T>` générique qui gère une collection d'éléments avec
les fonctionnalités suivantes :

- `add(T item)` : ajouter un élément.
- `get(int index)` : retourner l'élément à l'index donné.
- `size()` : retourner le nombre d'éléments.
- `displayAll()` : afficher tous les éléments.
- `contains(T item)` : vérifier si un élément est présent.

Testez avec une classe `Product` ayant un nom et un prix.

<details>
<summary>Solution</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class Registry<T> {
    private List<T> items;

    public Registry() {
        this.items = new ArrayList<>();
    }

    public void add(T item) {
        items.add(item);
    }

    public T get(int index) {
        return items.get(index);
    }

    public int size() {
        return items.size();
    }

    public void displayAll() {
        for (T item : items) {
            System.out.println("  - " + item);
        }
    }

    public boolean contains(T item) {
        return items.contains(item);
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
public class RegistryTest {
    public static void main(String[] args) {
        Registry<Product> inventory = new Registry<>();
        inventory.add(new Product("Terreau", 12.50));
        inventory.add(new Product("Graines de tomate", 3.90));
        inventory.add(new Product("Arrosoir", 24.00));

        System.out.println("Inventaire (" + inventory.size()
                + " produits) :");
        inventory.displayAll();

        Product first = inventory.get(0);
        System.out.println("\nPremier produit : " + first);

        Registry<String> tags = new Registry<>();
        tags.add("bio");
        tags.add("local");
        tags.add("saison");

        System.out.println("\nÉtiquettes :");
        tags.displayAll();
        System.out.println("Contient 'bio' : "
                + tags.contains("bio"));
        System.out.println("Contient 'import' : "
                + tags.contains("import"));
    }
}
```

Sortie attendue :

```text
Inventaire (3 produits) :
  - Terreau (12.5 CHF)
  - Graines de tomate (3.9 CHF)
  - Arrosoir (24.0 CHF)

Premier produit : Terreau (12.5 CHF)

Étiquettes :
  - bio
  - local
  - saison
Contient 'bio' : true
Contient 'import' : false
```

La classe `Registry<T>` est réutilisable avec n'importe quel type. Les méthodes
`get()` et `contains()` retournent et comparent des objets du type `T` sans
cast. On l'a testée avec `Product` et `String` pour démontrer la
réutilisabilité.

</details>

## Conclusion

Vous avez pratiqué :

- La création de classes génériques avec un ou deux paramètres de type.
- La création de méthodes génériques.
- La comparaison entre les approches avec `Object` et avec les génériques.
- L'application des génériques dans un nouveau contexte.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
