# Collections Java : Lambda et génériques

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Voici quelques informations relatives à ce contenu.
>
> **Ressources annexes**
>
> - Autres formats du support de cours : [Présentation (web)][presentation-web]
>   · [Présentation (PDF)][presentation-pdf]
> - Exemples de code : [Accéder au contenu](./01-exemples-de-code/)
> - Exercices : [Accéder au contenu](./02-exercices/)
> - Mini-projet : [Accéder au contenu](./03-mini-projet/)
> - Quiz : [Accéder au contenu][quiz-web]
>
> **Objectifs**
>
> À l'issue de cette séance, les personnes qui étudient devraient être capables
> de :
>
> - Expliquer ce qu'est une expression lambda et une interface fonctionnelle en
>   Java.
> - Identifier les interfaces fonctionnelles courantes (`Predicate`, `Function`,
>   `Consumer`, `Supplier`).
> - Créer des expressions lambda pour des interfaces fonctionnelles.
> - Utiliser les lambdas avec les collections (`forEach`, `removeIf`, `sort`).
> - Expliquer l'utilité des génériques pour la sécurité de type.
> - Créer des classes et des méthodes génériques avec des paramètres de type.
> - Utiliser les wildcards (`<? extends T>`, `<? super T>`) pour écrire du code
>   flexible.
> - Appliquer les génériques avec les collections pour éviter les erreurs de
>   type à la compilation.
>
> **Méthodes d'enseignement et d'apprentissage**
>
> Les méthodes d'enseignement et d'apprentissage utilisées pour animer la séance
> sont les suivantes :
>
> - Présentation magistrale.
> - Discussions collectives.
> - Travail en autonomie.
>
> **Méthodes d'évaluation**
>
> L'évaluation prend la forme d'exercices et d'un mini-projet à réaliser en
> autonomie en classe ou à la maison.
>
> L'évaluation se fait en utilisant les critères suivants :
>
> - Capacité à répondre avec justesse.
> - Capacité à argumenter.
> - Capacité à réaliser les tâches demandées.
> - Capacité à s'approprier les exemples de code.
> - Capacité à appliquer les exemples de code à des situations similaires.
>
> Les retours se font de la manière suivante :
>
> - Corrigé des exercices.
> - Corrigé du mini-projet.
>
> L'évaluation ne donne pas lieu à une note.

## Table des matières

- [Table des matières](#table-des-matières)
- [Introduction : simplifier et généraliser le code](#introduction--simplifier-et-généraliser-le-code)
- [Les expressions lambda](#les-expressions-lambda)
	- [Le problème : trop de code pour une action simple](#le-problème--trop-de-code-pour-une-action-simple)
	- [La syntaxe d'une lambda](#la-syntaxe-dune-lambda)
	- [Les interfaces fonctionnelles](#les-interfaces-fonctionnelles)
	- [Les interfaces fonctionnelles courantes de Java](#les-interfaces-fonctionnelles-courantes-de-java)
	- [Les lambdas avec les collections](#les-lambdas-avec-les-collections)
	- [Références de méthodes](#références-de-méthodes)
- [Les génériques](#les-génériques)
	- [Le problème : le code dupliqué et les conversions de type](#le-problème--le-code-dupliqué-et-les-conversions-de-type)
	- [Les classes génériques](#les-classes-génériques)
	- [Les méthodes génériques](#les-méthodes-génériques)
	- [Les wildcards](#les-wildcards)
	- [Limitations des génériques](#limitations-des-génériques)
- [Conclusion](#conclusion)
- [Exemples de code](#exemples-de-code)
- [Exercices](#exercices)
- [Mini-projet](#mini-projet)
- [À faire pour la prochaine séance](#à-faire-pour-la-prochaine-séance)

## Introduction : simplifier et généraliser le code

Dans le chapitre précédent, nous avons découvert les collections Java :
`ArrayList`, `HashSet` et `HashMap`. Nous savons maintenant stocker, parcourir
et manipuler des ensembles d'objets de manière flexible.

Mais en travaillant avec les collections, nous avons écrit beaucoup de code
répétitif. Pour afficher toutes les plantes, nous écrivons une boucle
`for-each`. Pour filtrer les plantes prêtes à récolter, nous écrivons une autre
boucle avec une condition. Pour trier les plantes par nom, nous devons créer une
classe entière qui implémente `Comparator`.

Ce chapitre introduit deux mécanismes qui réduisent cette répétition :

- Les expressions lambda : une syntaxe compacte pour passer un comportement en
  paramètre d'une méthode.
- Les génériques : un mécanisme pour écrire des classes et des méthodes qui
  fonctionnent avec n'importe quel type, tout en restant sûres à la compilation.

## Les expressions lambda

### Le problème : trop de code pour une action simple

Imaginons que nous voulons trier une liste de plantes par nom. Avec ce que nous
connaissons jusqu'ici, il faut créer une classe qui implémente l'interface
`Comparator` :

```java
import java.util.Comparator;

public class PlantNameComparator implements Comparator<PlantBase> {

    @Override
    public int compare(PlantBase a, PlantBase b) {
        return a.getName().compareTo(b.getName());
    }
}
```

<details>
<summary>Description du code</summary>

Importation de l'interface `Comparator` du package `java.util`.

Déclaration d'une classe publique `PlantNameComparator` qui implémente
l'interface `Comparator` paramétrée avec le type `PlantBase`.

Redéfinition de la méthode `compare` qui prend deux paramètres de type
`PlantBase` nommés `a` et `b`. Retour du résultat de la comparaison des noms des
deux plantes en utilisant la méthode `compareTo` de la classe `String`.

</details>

Puis, dans le programme principal :

```java
List<PlantBase> plants = new ArrayList<>();
// ... ajout des plantes ...
plants.sort(new PlantNameComparator());
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable `plants` de type `List<PlantBase>`
avec une nouvelle instance d'`ArrayList`.

Appel de la méthode `sort` sur la liste `plants` en passant une nouvelle
instance de `PlantNameComparator` comme argument.

</details>

Pour une simple comparaison de noms, nous avons dû créer un fichier entier avec
une classe, un import et une méthode. C'est beaucoup de code pour exprimer
quelque chose d'aussi simple que "compare les noms de deux plantes".

Les expressions lambda permettent de simplifier cela.

### La syntaxe d'une lambda

Une expression lambda est une façon concise d'écrire une méthode anonyme (sans
nom). Voici la syntaxe générale :

```text
(paramètres) -> expression
```

Ou, si le corps contient plusieurs instructions :

```text
(paramètres) -> {
    instruction1;
    instruction2;
    return résultat;
}
```

Reprenons l'exemple du tri par nom. Avec une lambda, le code devient :

```java
plants.sort((a, b) -> a.getName().compareTo(b.getName()));
```

<details>
<summary>Description du code</summary>

Appel de la méthode `sort` sur la liste `plants` en passant une expression
lambda comme argument. La lambda prend deux paramètres `a` et `b` (dont les
types sont inférés comme `PlantBase`) et retourne le résultat de la comparaison
des noms des deux plantes via la méthode `compareTo`.

</details>

Toute la classe `PlantNameComparator` est remplacée par une seule ligne. Java
comprend automatiquement que `a` et `b` sont de type `PlantBase` grâce au
contexte (c'est une liste de `PlantBase`).

Voici quelques exemples de lambdas avec différentes formes :

```java
// Sans paramètre
Runnable task = () -> System.out.println("Tâche exécutée");

// Un seul paramètre (parenthèses optionnelles)
Consumer<String> printer = name -> System.out.println("Plante : " + name);

// Plusieurs paramètres
Comparator<PlantBase> byName =
        (a, b) -> a.getName().compareTo(b.getName());

// Bloc avec plusieurs instructions
Consumer<PlantBase> detailedPrinter = plant -> {
    System.out.println("Nom : " + plant.getName());
    System.out.println("Espèce : " + plant.getSpecies());
};
```

<details>
<summary>Description du code</summary>

Déclaration d'une variable `task` de type `Runnable` initialisée avec une lambda
sans paramètre qui appelle `System.out.println` avec le texte "Tâche exécutée".

Déclaration d'une variable `printer` de type `Consumer<String>` initialisée avec
une lambda à un paramètre `name` qui affiche "Plante : " suivi du nom.

Déclaration d'une variable `byName` de type `Comparator<PlantBase>` initialisée
avec une lambda à deux paramètres `a` et `b` qui compare les noms des plantes.

Déclaration d'une variable `detailedPrinter` de type `Consumer<PlantBase>`
initialisée avec une lambda à un paramètre `plant` et un bloc de deux
instructions affichant le nom et l'espèce de la plante.

</details>

> [!NOTE]
>
> Les types des paramètres d'une lambda sont optionnels. Java les déduit
> automatiquement du contexte. Vous pouvez écrire `(PlantBase a, PlantBase b)`
> ou simplement `(a, b)`.

### Les interfaces fonctionnelles

Une lambda n'existe pas seule : elle implémente toujours une interface
fonctionnelle. Une interface fonctionnelle est une interface qui ne contient
qu'une seule méthode abstraite.

Nos interfaces du mini-projet ne sont pas des interfaces fonctionnelles car
elles contiennent plusieurs méthodes (`Harvestable` a `harvest()` et
`isReadyToHarvest()`). Mais `Comparator` en est une : elle n'a qu'une seule
méthode abstraite `compare()`.

On peut créer ses propres interfaces fonctionnelles :

```java
@FunctionalInterface
public interface PlantFilter {
    boolean test(PlantBase plant);
}
```

<details>
<summary>Description du code</summary>

Annotation `@FunctionalInterface` indiquant que cette interface est
fonctionnelle (une seule méthode abstraite).

Déclaration d'une interface publique `PlantFilter` avec une méthode abstraite
`test` qui prend un paramètre de type `PlantBase` et retourne un `boolean`.

</details>

L'annotation `@FunctionalInterface` est optionnelle mais recommandée. Elle
demande au compilateur de vérifier que l'interface contient bien une seule
méthode abstraite. Si on ajoute une deuxième méthode, le compilateur signale une
erreur.

On peut ensuite utiliser cette interface avec une lambda :

```java
PlantFilter readyToHarvest = plant ->
        plant instanceof Harvestable
                && ((Harvestable) plant).isReadyToHarvest();

PlantFilter largerThan50cm = plant -> plant.getSize() > 50.0;
```

<details>
<summary>Description du code</summary>

Déclaration d'une variable `readyToHarvest` de type `PlantFilter` initialisée
avec une lambda qui vérifie si la plante est une instance de `Harvestable` et si
elle est prête à être récoltée (conjonction logique avec l'opérateur `&&`).

Déclaration d'une variable `largerThan50cm` de type `PlantFilter` initialisée
avec une lambda qui vérifie si la taille de la plante est supérieure à 50.0
(comparaison avec l'opérateur `>`).

</details>

### Les interfaces fonctionnelles courantes de Java

Java fournit des interfaces fonctionnelles prédéfinies dans le package
`java.util.function`. Voici les quatre principales :

| Interface        | Méthode             | Description                  |
| :--------------- | :------------------ | :--------------------------- |
| `Predicate<T>`   | `boolean test(T t)` | Teste une condition.         |
| `Function<T, R>` | `R apply(T t)`      | Transforme un `T` en un `R`. |
| `Consumer<T>`    | `void accept(T t)`  | Consomme un `T` sans retour. |
| `Supplier<T>`    | `T get()`           | Fournit un `T` sans entrée.  |

Ces interfaces remplacent le besoin de créer nos propres interfaces comme
`PlantFilter`. On peut directement utiliser `Predicate<PlantBase>` à la place :

```java
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

// Predicate : teste une condition
Predicate<PlantBase> isLarge = plant -> plant.getSize() > 50.0;
System.out.println(isLarge.test(tomato)); // true ou false

// Function : transforme un objet
Function<PlantBase, String> toDescription = plant ->
        plant.getName() + " (" + plant.getSpecies() + ")";
System.out.println(toDescription.apply(tomato));
// Tomate cerise (Solanum lycopersicum)

// Consumer : effectue une action
Consumer<PlantBase> printName = plant ->
        System.out.println("Plante : " + plant.getName());
printName.accept(tomato); // Plante : Tomate cerise

// Supplier : fournit un objet
Supplier<PlantBase> defaultPlant = () ->
        new VegetablePlant("Laitue", "Lactuca sativa",
                "2026-05-01", 5.0, 60);
PlantBase newPlant = defaultPlant.get();
```

<details>
<summary>Description du code</summary>

Importation des quatre interfaces fonctionnelles du package
`java.util.function`.

Déclaration d'une variable `isLarge` de type `Predicate<PlantBase>` initialisée
avec une lambda qui teste si la taille de la plante est supérieure à 50.0. Appel
de la méthode `test` du prédicat sur la variable `tomato`.

Déclaration d'une variable `toDescription` de type `Function<PlantBase, String>`
initialisée avec une lambda qui concatène le nom et l'espèce de la plante. Appel
de la méthode `apply` sur la variable `tomato`.

Déclaration d'une variable `printName` de type `Consumer<PlantBase>` initialisée
avec une lambda qui affiche le nom de la plante. Appel de la méthode `accept`
sur la variable `tomato`.

Déclaration d'une variable `defaultPlant` de type `Supplier<PlantBase>`
initialisée avec une lambda sans paramètre qui crée un nouveau `VegetablePlant`.
Appel de la méthode `get` pour obtenir la plante.

</details>

> [!TIP]
>
> En pratique, vous utiliserez surtout `Predicate` (pour filtrer) et `Consumer`
> (pour agir sur chaque élément). `Function` et `Supplier` sont utiles mais
> moins fréquents dans du code débutant.

### Les lambdas avec les collections

Les collections Java offrent plusieurs méthodes qui acceptent des lambdas. Voici
les plus courantes :

#### forEach : appliquer une action à chaque élément

La méthode `forEach` remplace la boucle `for-each` dans de nombreux cas :

```java
List<PlantBase> plants = new ArrayList<>();
// ... ajout des plantes ...

// Avant : boucle for-each
for (PlantBase plant : plants) {
    System.out.println(plant.getName());
}

// Après : avec forEach et une lambda
plants.forEach(plant -> System.out.println(plant.getName()));
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable `plants` de type `List<PlantBase>`
avec une nouvelle instance d'`ArrayList`.

Boucle `for-each` qui parcourt la liste `plants` et affiche le nom de chaque
plante.

Appel de la méthode `forEach` sur la liste `plants` en passant une lambda qui
affiche le nom de chaque plante.

</details>

#### removeIf : supprimer selon une condition

La méthode `removeIf` supprime tous les éléments qui satisfont une condition :

```java
// Supprimer les plantes de moins de 20 cm
plants.removeIf(plant -> plant.getSize() < 20.0);
```

<details>
<summary>Description du code</summary>

Appel de la méthode `removeIf` sur la liste `plants` en passant une lambda (de
type `Predicate<PlantBase>`) qui teste si la taille de la plante est inférieure
à 20.0. Tous les éléments satisfaisant la condition sont supprimés de la liste.

</details>

> [!NOTE]
>
> `removeIf` utilise un itérateur en interne. C'est une alternative plus concise
> à la boucle avec `Iterator` et `it.remove()` que nous avons vue dans le
> chapitre précédent.

#### sort : trier selon un critère

La méthode `sort` accepte un `Comparator` sous forme de lambda :

```java
// Trier par nom (ordre alphabétique)
plants.sort((a, b) -> a.getName().compareTo(b.getName()));

// Trier par taille (croissant)
plants.sort((a, b) -> Double.compare(a.getSize(), b.getSize()));
```

<details>
<summary>Description du code</summary>

Appel de la méthode `sort` sur la liste `plants` en passant une lambda qui
compare les noms de deux plantes par ordre alphabétique via `compareTo`.

Appel de la méthode `sort` sur la liste `plants` en passant une lambda qui
compare les tailles de deux plantes par ordre croissant via `Double.compare`.

</details>

#### replaceAll : transformer chaque élément (listes de String)

Pour une liste de chaînes de caractères, `replaceAll` transforme chaque élément
:

```java
List<String> names = new ArrayList<>(
        List.of("tomate", "carotte", "basilic"));
names.replaceAll(name -> name.toUpperCase());
System.out.println(names); // [TOMATE, CAROTTE, BASILIC]
```

<details>
<summary>Description du code</summary>

Déclaration et initialisation d'une variable `names` de type `List<String>` avec
une `ArrayList` contenant trois éléments créés via `List.of`.

Appel de la méthode `replaceAll` sur la liste `names` en passant une lambda (de
type `UnaryOperator<String>`) qui convertit chaque nom en majuscules via la
méthode `toUpperCase`. Affichage de la liste transformée.

</details>

### Références de méthodes

Lorsqu'une lambda se contente d'appeler une méthode existante, on peut utiliser
une référence de méthode. La syntaxe utilise l'opérateur `::` :

```java
// Lambda
plants.forEach(plant -> System.out.println(plant));

// Référence de méthode (équivalent)
plants.forEach(System.out::println);
```

<details>
<summary>Description du code</summary>

Appel de la méthode `forEach` sur la liste `plants` avec une lambda qui passe
chaque élément à `System.out.println`.

Appel de la méthode `forEach` sur la liste `plants` avec une référence de
méthode `System.out::println`, qui est équivalente à la lambda précédente.

</details>

Il existe quatre types de références de méthodes :

| Type               | Syntaxe           | Exemple               |
| :----------------- | :---------------- | :-------------------- |
| Méthode statique   | `Classe::méthode` | `Math::abs`           |
| Méthode d'instance | `objet::méthode`  | `System.out::println` |
| Méthode d'un type  | `Type::méthode`   | `String::toUpperCase` |
| Constructeur       | `Classe::new`     | `ArrayList::new`      |

> [!TIP]
>
> Les références de méthodes sont optionnelles : on peut toujours utiliser une
> lambda à la place. Elles rendent le code plus lisible quand la lambda ne fait
> qu'appeler une seule méthode existante.

## Les génériques

### Le problème : le code dupliqué et les conversions de type

Avant les génériques (Java 1.4 et avant), les collections stockaient des
`Object`. Cela posait deux problèmes.

Premier problème : les conversions de type manuelles (casting) :

```java
// Sans génériques (ancien Java)
List plants = new ArrayList();
plants.add(new VegetablePlant("Tomate", "Solanum", "2026-03-15",
        45.5, 0));
plants.add("Ceci n'est pas une plante"); // Pas d'erreur !

// Il faut caster manuellement
PlantBase plant = (PlantBase) plants.get(0); // OK
PlantBase oops = (PlantBase) plants.get(1);  // ClassCastException !
```

<details>
<summary>Description du code</summary>

Déclaration d'une variable `plants` de type `List` (sans paramètre de type)
initialisée avec une nouvelle instance d'`ArrayList`.

Ajout d'un `VegetablePlant` à la liste, puis ajout d'une `String`. Les deux
ajouts compilent sans erreur car la liste accepte n'importe quel `Object`.

Cast de l'élément à l'index 0 en `PlantBase` : fonctionne car c'est un
`VegetablePlant`. Cast de l'élément à l'index 1 en `PlantBase` : provoque une
`ClassCastException` à l'exécution car c'est une `String`.

</details>

Second problème : le code dupliqué. Si on veut écrire une classe "boîte" qui
contient un objet, il faut une classe par type :

```java
public class StringBox {
    private String value;
    public void set(String value) { this.value = value; }
    public String get() { return value; }
}

public class IntegerBox {
    private Integer value;
    public void set(Integer value) { this.value = value; }
    public Integer get() { return value; }
}
```

<details>
<summary>Description du code</summary>

Déclaration d'une classe `StringBox` avec un champ privé `value` de type
`String`, un setter `set` et un getter `get`.

Déclaration d'une classe `IntegerBox` avec un champ privé `value` de type
`Integer`, un setter `set` et un getter `get`.

Le code des deux classes est identique à l'exception du type.

</details>

Les génériques résolvent ces deux problèmes.

### Les classes génériques

Une classe générique déclare un ou plusieurs paramètres de type entre chevrons
(`<>`). Ce paramètre de type est un espace réservé qui sera remplacé par un type
concret lors de l'utilisation :

```java
public class Box<T> {
    private T value;

    public void set(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }
}
```

<details>
<summary>Description du code</summary>

Déclaration d'une classe publique `Box` avec un paramètre de type `T`.

Déclaration d'un champ privé `value` de type `T`.

Déclaration d'un setter `set` qui accepte un paramètre de type `T`.

Déclaration d'un getter `get` qui retourne une valeur de type `T`.

</details>

`T` est un paramètre de type. Par convention, on utilise des lettres majuscules
seules : `T` (type), `E` (element), `K` (key), `V` (value), `R` (return).

À l'utilisation, on spécifie le type concret :

```java
Box<String> stringBox = new Box<>();
stringBox.set("Tomate");
String name = stringBox.get(); // Pas de cast nécessaire

Box<Integer> intBox = new Box<>();
intBox.set(42);
int value = intBox.get();

// Erreur de compilation (pas d'erreur à l'exécution !)
// stringBox.set(42); // Type incompatible
```

<details>
<summary>Description du code</summary>

Déclaration d'une variable `stringBox` de type `Box<String>` initialisée avec
une nouvelle instance de `Box` (opérateur diamant `<>`).

Appel de `set` avec une `String`. Appel de `get` qui retourne directement un
`String` sans conversion de type.

Déclaration d'une variable `intBox` de type `Box<Integer>` initialisée avec une
nouvelle instance de `Box`. Appel de `set` avec un `Integer` et appel de `get`
qui retourne un `int` (auto-unboxing).

L'appel `stringBox.set(42)` provoquerait une erreur de compilation car `42`
n'est pas un `String`.

</details>

> [!IMPORTANT]
>
> Les génériques ne fonctionnent qu'avec des types de référence (objets), pas
> avec des types primitifs. Utilisez `Integer` au lieu de `int`, `Double` au
> lieu de `double`, etc.

On peut avoir plusieurs paramètres de type :

```java
public class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() { return key; }
    public V getValue() { return value; }
}
```

<details>
<summary>Description du code</summary>

Déclaration d'une classe publique `Pair` avec deux paramètres de type `K` et
`V`.

Déclaration de deux champs privés : `key` de type `K` et `value` de type `V`.

Constructeur qui prend deux paramètres de types `K` et `V` et les assigne aux
champs correspondants.

Deux getters `getKey` et `getValue` retournant respectivement `K` et `V`.

</details>

Utilisation :

```java
Pair<String, Integer> plantAge = new Pair<>("Pommier", 3);
String treeName = plantAge.getKey();    // "Pommier"
int age = plantAge.getValue();           // 3
```

<details>
<summary>Description du code</summary>

Déclaration d'une variable `plantAge` de type `Pair<String, Integer>`
initialisée avec le constructeur en passant le nom "Pommier" et l'âge 3.

Appel de `getKey()` retournant un `String` et de `getValue()` retournant un
`Integer` (auto-unboxing vers `int`).

</details>

### Les méthodes génériques

On peut aussi rendre une méthode générique sans que la classe entière le soit.
Le paramètre de type est déclaré avant le type de retour :

```java
public class GardenUtils {

    /**
     * Affiche tous les éléments d'une liste.
     */
    public static <T> void printAll(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }

    /**
     * Retourne le premier élément d'une liste ou null si vide.
     */
    public static <T> T getFirst(List<T> items) {
        if (items.isEmpty()) {
            return null;
        }
        return items.get(0);
    }
}
```

<details>
<summary>Description du code</summary>

Déclaration d'une classe `GardenUtils` avec deux méthodes statiques génériques.

La méthode `printAll` déclare un paramètre de type `<T>` avant le type de retour
`void`. Elle prend une `List<T>` et parcourt les éléments avec une boucle
`for-each` pour les afficher.

La méthode `getFirst` déclare un paramètre de type `<T>` et retourne un `T`.
Elle vérifie si la liste est vide avec `isEmpty()` et retourne `null` le cas
échéant, sinon retourne l'élément à l'index 0.

</details>

Utilisation :

```java
List<PlantBase> plants = new ArrayList<>();
// ... ajout des plantes ...

GardenUtils.printAll(plants);        // T est inféré comme PlantBase
PlantBase first = GardenUtils.getFirst(plants);

List<String> names = List.of("Tomate", "Carotte");
GardenUtils.printAll(names);         // T est inféré comme String
String firstName = GardenUtils.getFirst(names);
```

<details>
<summary>Description du code</summary>

Appel de `GardenUtils.printAll` avec une liste de `PlantBase` : le paramètre de
type `T` est automatiquement inféré comme `PlantBase`.

Appel de `GardenUtils.getFirst` qui retourne un `PlantBase`.

Appel de `GardenUtils.printAll` avec une liste de `String` : le paramètre de
type `T` est automatiquement inféré comme `String`.

Appel de `GardenUtils.getFirst` qui retourne un `String`.

</details>

### Les wildcards

Les wildcards (jokers) permettent de rendre les génériques plus flexibles. Ils
sont utilisés quand on ne connaît pas ou ne veut pas fixer le type exact.

#### Le wildcard non borné : `<?>`

Le wildcard `<?>` signifie "n'importe quel type" :

```java
public static void printList(List<?> list) {
    for (Object item : list) {
        System.out.println(item);
    }
}

// Fonctionne avec n'importe quel type de liste
printList(plants);  // List<PlantBase>
printList(names);   // List<String>
```

<details>
<summary>Description du code</summary>

Déclaration d'une méthode statique `printList` qui accepte une `List<?>` (liste
de n'importe quel type). Boucle `for-each` qui parcourt les éléments en tant
qu'`Object` et les affiche.

Appels de `printList` avec une liste de `PlantBase` et une liste de `String` :
les deux sont acceptés.

</details>

#### Le wildcard borné supérieurement : `<? extends T>`

Le wildcard `<? extends T>` signifie "un type qui est `T` ou un sous-type de
`T`". Il permet de lire les éléments en tant que `T` :

```java
public static double totalSize(List<? extends PlantBase> plants) {
    double total = 0;
    for (PlantBase plant : plants) {
        total += plant.getSize();
    }
    return total;
}

// Fonctionne avec List<PlantBase>, List<VegetablePlant>, etc.
List<VegetablePlant> vegetables = new ArrayList<>();
// ... ajout de légumes ...
double total = totalSize(vegetables); // OK
```

<details>
<summary>Description du code</summary>

Déclaration d'une méthode `totalSize` qui accepte une
`List<? extends PlantBase>` : toute liste dont le type est `PlantBase` ou un de
ses sous-types. Boucle `for-each` qui parcourt les éléments en tant que
`PlantBase` et additionne les tailles.

Déclaration d'une liste de `VegetablePlant`. Appel de `totalSize` avec cette
liste : cela fonctionne car `VegetablePlant` est un sous-type de `PlantBase`.

</details>

#### Le wildcard borné inférieurement : `<? super T>`

Le wildcard `<? super T>` signifie "un type qui est `T` ou un super-type de
`T`". Il est surtout utile pour écrire dans une collection :

```java
public static void addDefaultVegetables(
        List<? super VegetablePlant> list) {
    list.add(new VegetablePlant("Laitue", "Lactuca sativa",
            "2026-05-01", 5.0, 45));
    list.add(new VegetablePlant("Radis", "Raphanus sativus",
            "2026-05-01", 3.0, 25));
}

// Fonctionne avec List<VegetablePlant>, List<PlantBase>, List<Object>
List<PlantBase> allPlants = new ArrayList<>();
addDefaultVegetables(allPlants); // OK
```

<details>
<summary>Description du code</summary>

Déclaration d'une méthode `addDefaultVegetables` qui accepte une
`List<? super VegetablePlant>` : toute liste dont le type est `VegetablePlant`
ou un de ses super-types (`PlantBase`, `Object`). Ajout de deux `VegetablePlant`
à la liste.

Déclaration d'une liste de `PlantBase`. Appel de `addDefaultVegetables` avec
cette liste : cela fonctionne car `PlantBase` est un super-type de
`VegetablePlant`.

</details>

> [!TIP]
>
> Règle mnémotechnique PECS (Producer Extends, Consumer Super) :
>
> - Si vous **lisez** des éléments de la collection : utilisez `<? extends T>`.
> - Si vous **écrivez** des éléments dans la collection : utilisez
>   `<? super T>`.

### Limitations des génériques

Les génériques ont quelques restrictions à connaître :

- On ne peut pas utiliser des types primitifs : `List<int>` est interdit, il
  faut utiliser `List<Integer>`.
- On ne peut pas créer d'instance d'un paramètre de type : `new T()` est
  interdit.
- On ne peut pas créer de tableau d'un type générique : `new T[10]` est
  interdit.

Ces restrictions sont liées à l'effacement de type (type erasure) : Java
remplace les types génériques par `Object` à la compilation. Les génériques
n'existent qu'à la compilation, pas à l'exécution.

---

<details>
<summary>Pour aller plus loin</summary>

Les expressions lambda et les génériques ouvrent la porte à des concepts plus
avancés :

- Les streams Java (`java.util.stream`) permettent de créer des pipelines de
  traitement de données en enchaînant des opérations comme `filter`, `map` et
  `collect`.
- Les types bornés (`<T extends Comparable<T>>`) permettent de contraindre un
  paramètre de type à implémenter une interface.
- Les méthodes `default` dans les interfaces fonctionnelles permettent de
  chaîner des prédicats avec `and()`, `or()` et `negate()`.
- Le pattern Strategy utilise les interfaces fonctionnelles pour paramétrer le
  comportement d'une classe.

</details>

---

## Conclusion

Dans ce chapitre, nous avons découvert deux mécanismes qui simplifient et
généralisent le code Java :

- Les expressions lambda permettent de passer un comportement en paramètre d'une
  méthode, sans créer de classe dédiée. Elles sont particulièrement utiles avec
  les méthodes `forEach`, `removeIf` et `sort` des collections.
- Les interfaces fonctionnelles (`Predicate`, `Function`, `Consumer`,
  `Supplier`) sont les types qui rendent les lambdas possibles.
- Les génériques permettent d'écrire des classes et des méthodes qui
  fonctionnent avec n'importe quel type, tout en détectant les erreurs de type à
  la compilation plutôt qu'à l'exécution.
- Les wildcards (`? extends T`, `? super T`) ajoutent de la flexibilité aux
  génériques.

## Exemples de code

Nous vous invitons à consulter les exemples de code associés à ce contenu de
cours pour mieux comprendre les concepts abordés.

Vous trouverez les exemples de code ici :
[Exemples de code](./01-exemples-de-code/).

## Exercices

Nous vous invitons maintenant à réaliser les exercices de la séance afin de
mettre en pratique les concepts abordés.

Vous trouverez les exercices et leur corrigé ici : [Exercices](./02-exercices/).

## Mini-projet

Nous vous invitons maintenant à réaliser le mini-projet de la séance afin de
mettre en pratique les concepts abordés.

Vous trouverez les détails du mini-projet ici :
[Mini-projet](./03-mini-projet/).

## À faire pour la prochaine séance

Chaque personne est libre de gérer son temps comme elle le souhaite. Cependant,
il est recommandé pour la prochaine séance de :

- Relire le support de cours si nécessaire.
- Relire les exemples de code et leur description pour bien comprendre les
  concepts.
- Finaliser les exercices qui n'ont pas été terminés en classe.
- Finaliser la partie du mini-projet qui n'a pas été terminée en classe.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
[quiz-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/quiz.html
[presentation-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/09-collections-java-lambda-et-generiques-presentation.pdf
