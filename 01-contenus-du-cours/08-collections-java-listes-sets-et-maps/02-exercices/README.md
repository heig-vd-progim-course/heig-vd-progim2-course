# Collections Java : Listes, sets et maps - Exercices

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
  - [Exercice 1 - ArrayList de base](#exercice-1---arraylist-de-base)
  - [Exercice 2 - HashSet et unicité](#exercice-2---hashset-et-unicité)
  - [Exercice 3 - HashMap clé-valeur](#exercice-3---hashmap-clé-valeur)
  - [Exercice 4 - Itérateur et suppression sécurisée](#exercice-4---itérateur-et-suppression-sécurisée)
  - [Exercice 5 - Parcours d'une map](#exercice-5---parcours-dune-map)
- [Exercices de prédiction](#exercices-de-prédiction)
  - [Exercice 6 - Doublons dans un ensemble](#exercice-6---doublons-dans-un-ensemble)
  - [Exercice 7 - Comportement de put() dans une map](#exercice-7---comportement-de-put-dans-une-map)
  - [Exercice 8 - ConcurrentModificationException](#exercice-8---concurrentmodificationexception)
- [Exercices de comparaison](#exercices-de-comparaison)
  - [Exercice 9 - ArrayList vs HashSet](#exercice-9---arraylist-vs-hashset)
  - [Exercice 10 - HashMap vs TreeMap](#exercice-10---hashmap-vs-treemap)
- [Exercices de modification](#exercices-de-modification)
  - [Exercice 11 - Remplacement d'un tableau par une ArrayList](#exercice-11---remplacement-dun-tableau-par-une-arraylist)
  - [Exercice 12 - Ajout d'un ensemble pour garantir l'unicité](#exercice-12---ajout-dun-ensemble-pour-garantir-lunicité)
- [Exercices de transfert](#exercices-de-transfert)
  - [Exercice 13 - Gestion d'un inventaire de bibliothèque](#exercice-13---gestion-dun-inventaire-de-bibliothèque)
  - [Exercice 14 - Système de vote pour un conseil étudiant](#exercice-14---système-de-vote-pour-un-conseil-étudiant)
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

Ces exercices vous permettent de pratiquer la syntaxe et les concepts des
collections Java en complétant du code existant.

### Exercice 1 - ArrayList de base

Vous gérez une liste de tâches pour un jardin communautaire. Complétez le code
pour ajouter des tâches, en supprimer une et afficher la taille de la liste.

```java
import java.util.ArrayList;
import java.util.List;

public class GardenTasks {
    public static void main(String[] args) {
        // TODO: Déclarez une List<String> initialisée avec un ArrayList


        // TODO: Ajoutez les tâches suivantes :
        // "Arroser les tomates", "Désherber la parcelle A",
        // "Récolter les carottes", "Planter du basilic"




        System.out.println("Tâches : " + tasks);

        // TODO: Supprimez "Désherber la parcelle A"


        System.out.println("Après suppression : " + tasks);

        // TODO: Affichez le nombre de tâches restantes


        // TODO: Affichez la première tâche avec get()

    }
}
```

**Résultat attendu :**

```
Tâches : [Arroser les tomates, Désherber la parcelle A, Récolter les carottes, Planter du basilic]
Après suppression : [Arroser les tomates, Récolter les carottes, Planter du basilic]
Nombre de tâches : 3
Première tâche : Arroser les tomates
```

<details>
<summary>Indice</summary>

Utilisez `new ArrayList<>()` pour créer la liste, `add()` pour ajouter,
`remove()` pour supprimer, `size()` pour la taille et `get(0)` pour le premier
élément.

</details>

<details>
<summary>Afficher la solution</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class GardenTasks {
    public static void main(String[] args) {
        List<String> tasks = new ArrayList<>();

        tasks.add("Arroser les tomates");
        tasks.add("Désherber la parcelle A");
        tasks.add("Récolter les carottes");
        tasks.add("Planter du basilic");

        System.out.println("Tâches : " + tasks);

        tasks.remove("Désherber la parcelle A");

        System.out.println("Après suppression : " + tasks);

        System.out.println("Nombre de tâches : " + tasks.size());

        System.out.println("Première tâche : " + tasks.get(0));
    }
}
```

**Explication** : La variable est déclarée avec le type `List<String>`
(l'interface) et initialisée avec `new ArrayList<>()`. Les méthodes `add()`,
`remove()`, `size()` et `get()` sont les opérations de base sur une liste.

</details>

### Exercice 2 - HashSet et unicité

Vous voulez enregistrer les espèces de plantes présentes dans un jardin.
Complétez le code pour créer un ensemble et observer le comportement avec les
doublons.

```java
import java.util.HashSet;
import java.util.Set;

public class GardenSpecies {
    public static void main(String[] args) {
        // TODO: Déclarez un Set<String> initialisé avec un HashSet


        // TODO: Ajoutez les espèces suivantes :
        // "Tomate", "Carotte", "Basilic", "Tomate", "Menthe", "Carotte"






        System.out.println("Espèces : " + species);

        // TODO: Affichez le nombre d'espèces (sans les doublons)


        // TODO: Vérifiez si "Basilic" est présent dans l'ensemble


        // TODO: Supprimez "Menthe" de l'ensemble


        System.out.println("Après suppression : " + species);
    }
}
```

**Résultat attendu :**

```
Espèces : [Tomate, Carotte, Menthe, Basilic] (ordre variable)
Nombre d'espèces : 4
Basilic présent : true
Après suppression : [Tomate, Carotte, Basilic] (ordre variable)
```

<details>
<summary>Indice</summary>

Les doublons sont automatiquement ignorés par un `HashSet`. L'ordre d'affichage
n'est pas garanti. Utilisez `add()`, `size()`, `contains()` et `remove()`.

</details>

<details>
<summary>Afficher la solution</summary>

```java
import java.util.HashSet;
import java.util.Set;

public class GardenSpecies {
    public static void main(String[] args) {
        Set<String> species = new HashSet<>();

        species.add("Tomate");
        species.add("Carotte");
        species.add("Basilic");
        species.add("Tomate");
        species.add("Menthe");
        species.add("Carotte");

        System.out.println("Espèces : " + species);

        System.out.println("Nombre d'espèces : " + species.size());

        System.out.println("Basilic présent : " + species.contains("Basilic"));

        species.remove("Menthe");

        System.out.println("Après suppression : " + species);
    }
}
```

**Explication** : On ajoute 6 éléments mais seulement 4 sont conservés car
`"Tomate"` et `"Carotte"` sont des doublons. L'ensemble les ignore
silencieusement. L'ordre d'affichage n'est pas garanti avec `HashSet`.

</details>

### Exercice 3 - HashMap clé-valeur

Vous gérez l'attribution des parcelles aux jardinières. Complétez le code pour
créer une map, ajouter des entrées et effectuer des recherches.

```java
import java.util.HashMap;
import java.util.Map;

public class PlotAssignment {
    public static void main(String[] args) {
        // TODO: Déclarez une Map<String, String> initialisée avec un HashMap
        // Les clés sont les noms des jardinières, les valeurs les parcelles


        // TODO: Associez les jardinières suivantes à leurs parcelles :
        // "Alice" -> "Parcelle A1"
        // "Bob" -> "Parcelle B2"
        // "Clara" -> "Parcelle A3"



        System.out.println("Attributions : " + assignments);

        // TODO: Affichez la parcelle d'Alice


        // TODO: Vérifiez si "David" a une parcelle attribuée


        // TODO: Alice change de parcelle : mettez à jour vers "Parcelle C1"


        System.out.println("Parcelle d'Alice mise à jour : "
                + assignments.get("Alice"));

        // TODO: Affichez toutes les clés (noms des jardinières)


        // TODO: Affichez toutes les valeurs (noms des parcelles)

    }
}
```

**Résultat attendu :**

```
Attributions : {Bob=Parcelle B2, Alice=Parcelle A1, Clara=Parcelle A3}
Parcelle d'Alice : Parcelle A1
David a une parcelle : false
Parcelle d'Alice mise à jour : Parcelle C1
Jardinières : [Bob, Alice, Clara] (ordre variable)
Parcelles : [Parcelle B2, Parcelle C1, Parcelle A3] (ordre variable)
```

<details>
<summary>Indice</summary>

Utilisez `put()` pour ajouter ou modifier une entrée, `get()` pour obtenir une
valeur par sa clé, `containsKey()` pour vérifier l'existence d'une clé,
`keySet()` pour les clés et `values()` pour les valeurs.

</details>

<details>
<summary>Afficher la solution</summary>

```java
import java.util.HashMap;
import java.util.Map;

public class PlotAssignment {
    public static void main(String[] args) {
        Map<String, String> assignments = new HashMap<>();

        assignments.put("Alice", "Parcelle A1");
        assignments.put("Bob", "Parcelle B2");
        assignments.put("Clara", "Parcelle A3");

        System.out.println("Attributions : " + assignments);

        System.out.println("Parcelle d'Alice : " + assignments.get("Alice"));

        System.out.println("David a une parcelle : "
                + assignments.containsKey("David"));

        assignments.put("Alice", "Parcelle C1");

        System.out.println("Parcelle d'Alice mise à jour : "
                + assignments.get("Alice"));

        System.out.println("Jardinières : " + assignments.keySet());

        System.out.println("Parcelles : " + assignments.values());
    }
}
```

**Explication** : `put()` ajoute une entrée ou remplace la valeur si la clé
existe déjà. `get()` retourne la valeur associée à une clé. `keySet()` retourne
un `Set` des clés et `values()` retourne une `Collection` des valeurs.

</details>

### Exercice 4 - Itérateur et suppression sécurisée

Vous avez une liste de plantes et vous devez supprimer toutes les plantes dont
le nom commence par `"T"`. Complétez le code en utilisant un itérateur.

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlantFilter {
    public static void main(String[] args) {
        List<String> plants = new ArrayList<>(
            List.of("Tomate", "Carotte", "Thym", "Basilic", "Tournesol")
        );

        System.out.println("Avant : " + plants);

        // TODO: Obtenez un itérateur sur la liste


        // TODO: Parcourez la liste avec l'itérateur
        // et supprimez les plantes dont le nom commence par "T"
        // Utilisez la méthode startsWith() de String




        System.out.println("Après : " + plants);
    }
}
```

**Résultat attendu :**

```
Avant : [Tomate, Carotte, Thym, Basilic, Tournesol]
Après : [Carotte, Basilic]
```

<details>
<summary>Indice</summary>

Utilisez `plants.iterator()` pour obtenir un itérateur. Parcourez avec
`while (it.hasNext())` et `it.next()`. Utilisez `it.remove()` (et non
`plants.remove()`) pour supprimer l'élément courant de manière sécurisée.

</details>

<details>
<summary>Afficher la solution</summary>

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PlantFilter {
    public static void main(String[] args) {
        List<String> plants = new ArrayList<>(
            List.of("Tomate", "Carotte", "Thym", "Basilic", "Tournesol")
        );

        System.out.println("Avant : " + plants);

        Iterator<String> it = plants.iterator();

        while (it.hasNext()) {
            String plant = it.next();
            if (plant.startsWith("T")) {
                it.remove();
            }
        }

        System.out.println("Après : " + plants);
    }
}
```

**Explication** : On utilise `it.remove()` et non `plants.remove()` pour éviter
une `ConcurrentModificationException`. L'itérateur gère la cohérence interne de
la collection pendant la suppression.

</details>

### Exercice 5 - Parcours d'une map

Vous avez une map qui associe des noms de plantes à leur quantité. Complétez le
code pour parcourir la map et calculer le total des plantes.

```java
import java.util.HashMap;
import java.util.Map;

public class PlantInventory {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Tomate", 12);
        inventory.put("Carotte", 8);
        inventory.put("Basilic", 5);
        inventory.put("Menthe", 3);

        // TODO: Parcourez la map avec entrySet() et affichez chaque entrée
        // sous la forme "Plante : <nom> -> Quantité : <nombre>"




        // TODO: Calculez et affichez le nombre total de plantes
        int total = 0;



        System.out.println("Total des plantes : " + total);
    }
}
```

**Résultat attendu :**

```
Plante : Tomate -> Quantité : 12
Plante : Carotte -> Quantité : 8
Plante : Basilic -> Quantité : 5
Plante : Menthe -> Quantité : 3
Total des plantes : 28
```

<details>
<summary>Indice</summary>

Utilisez `inventory.entrySet()` pour obtenir les paires clé-valeur. Chaque
`Map.Entry` offre `getKey()` et `getValue()`. Pour le total, ajoutez chaque
valeur dans la boucle.

</details>

<details>
<summary>Afficher la solution</summary>

```java
import java.util.HashMap;
import java.util.Map;

public class PlantInventory {
    public static void main(String[] args) {
        Map<String, Integer> inventory = new HashMap<>();
        inventory.put("Tomate", 12);
        inventory.put("Carotte", 8);
        inventory.put("Basilic", 5);
        inventory.put("Menthe", 3);

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println("Plante : " + entry.getKey()
                    + " -> Quantité : " + entry.getValue());
        }

        int total = 0;
        for (int quantity : inventory.values()) {
            total += quantity;
        }

        System.out.println("Total des plantes : " + total);
    }
}
```

**Explication** : `entrySet()` retourne un ensemble de paires `Map.Entry`.
Chaque paire offre `getKey()` et `getValue()`. Pour le total, on itère sur
`values()` et on additionne chaque valeur.

</details>

## Exercices de prédiction

Ces exercices vous entraînent à prédire le comportement du code avant de
l'exécuter.

### Exercice 6 - Doublons dans un ensemble

Prédisez ce que va afficher ce code :

```java
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

Set<String> garden = new HashSet<>();
garden.add("Tomate");
garden.add("Basilic");
garden.add("Carotte");
garden.add("Tomate");
garden.add("Basilic");

System.out.println("Taille : " + garden.size());
System.out.println("Ajout de Menthe : " + garden.add("Menthe"));
System.out.println("Ajout de Tomate : " + garden.add("Tomate"));

Set<String> sorted = new TreeSet<>(garden);
System.out.println("Trié : " + sorted);
```

**Que va afficher ce code ?**

<details>
<summary>Afficher la solution</summary>

**Sortie attendue :**

```
Taille : 3
Ajout de Menthe : true
Ajout de Tomate : false
Trié : [Basilic, Carotte, Menthe, Tomate]
```

**Explication** :

- L'ensemble contient 3 éléments car `"Tomate"` et `"Basilic"` ajoutés en
  doublon sont ignorés.
- `add()` retourne `true` si l'élément a été ajouté, `false` s'il existait déjà.
- `TreeSet` construit avec le contenu du `HashSet` trie les éléments par ordre
  alphabétique.

</details>

### Exercice 7 - Comportement de put() dans une map

Prédisez ce que va afficher ce code :

```java
import java.util.HashMap;
import java.util.Map;

Map<String, String> registry = new HashMap<>();
registry.put("Alice", "Parcelle A1");
registry.put("Bob", "Parcelle B2");
registry.put("Alice", "Parcelle C3");

System.out.println("Taille : " + registry.size());
System.out.println("Alice : " + registry.get("Alice"));
System.out.println("Clara : " + registry.get("Clara"));
System.out.println("Contient Bob : " + registry.containsKey("Bob"));
System.out.println("Contient Parcelle A1 : "
        + registry.containsValue("Parcelle A1"));
```

**Que va afficher ce code ?**

<details>
<summary>Afficher la solution</summary>

**Sortie attendue :**

```
Taille : 2
Alice : Parcelle C3
Clara : null
Contient Bob : true
Contient Parcelle A1 : false
```

**Explication** :

- La map contient 2 entrées car le deuxième `put("Alice", ...)` remplace la
  première valeur.
- `get("Alice")` retourne `"Parcelle C3"` (la dernière valeur associée).
- `get("Clara")` retourne `null` car la clé n'existe pas.
- `containsKey("Bob")` retourne `true` car la clé `"Bob"` existe.
- `containsValue("Parcelle A1")` retourne `false` car cette valeur a été
  remplacée par `"Parcelle C3"`.

</details>

### Exercice 8 - ConcurrentModificationException

Prédisez ce que va se passer avec ce code :

```java
import java.util.ArrayList;
import java.util.List;

List<String> tools = new ArrayList<>();
tools.add("Arrosoir");
tools.add("Râteau");
tools.add("Bêche");
tools.add("Arrosoir");
tools.add("Sécateur");

for (String tool : tools) {
    if (tool.equals("Arrosoir")) {
        tools.remove(tool);
    }
}

System.out.println(tools);
```

**Que va-t-il se passer ?**

<details>
<summary>Afficher la solution</summary>

**Résultat :** Le programme lève une `ConcurrentModificationException` à
l'exécution.

**Explication** : On ne peut pas modifier une collection (appeler
`tools.remove()`) pendant qu'on la parcourt avec une boucle `for-each`. Java
détecte la modification concurrente et lève une exception.

**Solution correcte** : utiliser un itérateur avec `it.remove()` :

```java
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

List<String> tools = new ArrayList<>();
tools.add("Arrosoir");
tools.add("Râteau");
tools.add("Bêche");
tools.add("Arrosoir");
tools.add("Sécateur");

Iterator<String> it = tools.iterator();
while (it.hasNext()) {
    String tool = it.next();
    if (tool.equals("Arrosoir")) {
        it.remove();
    }
}

System.out.println(tools); // [Râteau, Bêche, Sécateur]
```

</details>

## Exercices de comparaison

Ces exercices vous aident à comprendre les différences entre les types de
collections.

### Exercice 9 - ArrayList vs HashSet

Comparez ces deux approches pour stocker les noms des personnes inscrites à un
atelier de jardinage :

**Approche A - ArrayList**

```java
List<String> participants = new ArrayList<>();
participants.add("Alice");
participants.add("Bob");
participants.add("Alice"); // Doublon
participants.add("Clara");

System.out.println("Participants : " + participants);
System.out.println("Nombre : " + participants.size());
```

**Approche B - HashSet**

```java
Set<String> participants = new HashSet<>();
participants.add("Alice");
participants.add("Bob");
participants.add("Alice"); // Doublon
participants.add("Clara");

System.out.println("Participants : " + participants);
System.out.println("Nombre : " + participants.size());
```

**Questions :**

1. Qu'affiche l'approche A ? Et l'approche B ?
2. Quelles sont les différences ?
3. Dans quel cas utiliser l'une plutôt que l'autre ?

<details>
<summary>Afficher la solution</summary>

**Approche A affiche :**

```
Participants : [Alice, Bob, Alice, Clara]
Nombre : 4
```

**Approche B affiche :**

```
Participants : [Bob, Alice, Clara] (ordre variable)
Nombre : 3
```

**Différences :**

| Aspect          | `ArrayList`                         | `HashSet`                                |
| :-------------- | :---------------------------------- | :--------------------------------------- |
| Doublons        | Autorisés (`Alice` apparaît 2 fois) | Rejetés (`Alice` n'apparaît qu'une fois) |
| Ordre           | Préservé (ordre d'insertion)        | Non garanti                              |
| Accès par index | Oui (`get(i)`)                      | Non                                      |
| Taille          | 4 (avec doublons)                   | 3 (sans doublons)                        |

**Quand utiliser :**

- **ArrayList** : quand l'ordre compte ou que les doublons sont acceptés (ex :
  liste d'attente, historique d'actions).
- **HashSet** : quand chaque élément doit être unique (ex : liste de personnes
  inscrites, catalogue d'espèces).

</details>

### Exercice 10 - HashMap vs TreeMap

Comparez ces deux approches pour stocker le nombre de plantes par espèce :

**Approche A - HashMap**

```java
Map<String, Integer> counts = new HashMap<>();
counts.put("Tomate", 12);
counts.put("Basilic", 8);
counts.put("Carotte", 15);
counts.put("Aubergine", 5);

System.out.println(counts);
```

**Approche B - TreeMap**

```java
Map<String, Integer> counts = new TreeMap<>();
counts.put("Tomate", 12);
counts.put("Basilic", 8);
counts.put("Carotte", 15);
counts.put("Aubergine", 5);

System.out.println(counts);
```

**Questions :**

1. Qu'affiche l'approche A ? Et l'approche B ?
2. Quand utiliser `HashMap` ? Et `TreeMap` ?

<details>
<summary>Afficher la solution</summary>

**Approche A affiche :**

```
{Tomate=12, Basilic=8, Carotte=15, Aubergine=5} (ordre variable)
```

**Approche B affiche :**

```
{Aubergine=5, Basilic=8, Carotte=15, Tomate=12} (trié par clé)
```

**Différences :**

| Aspect              | `HashMap`         | `TreeMap`                 |
| :------------------ | :---------------- | :------------------------ |
| Ordre des clés      | Non garanti       | Trié (ordre naturel)      |
| Performance         | Plus rapide       | Légèrement plus lent      |
| Contrainte sur clés | Pas de contrainte | Doivent être `Comparable` |

**Quand utiliser :**

- **HashMap** : quand l'ordre n'a pas d'importance et que la performance prime
  (cas le plus fréquent).
- **TreeMap** : quand on a besoin des entrées triées par clé (ex : afficher un
  rapport alphabétique, parcourir dans un ordre précis).

</details>

## Exercices de modification

Ces exercices vous demandent de modifier du code existant pour corriger des
erreurs ou ajouter des fonctionnalités.

### Exercice 11 - Remplacement d'un tableau par une ArrayList

Le code suivant utilise un tableau pour gérer une liste d'outils de jardinage.
Modifiez-le pour utiliser une `ArrayList` à la place.

**Code de départ :**

```java
public class GardenTools {
    public static void main(String[] args) {
        String[] tools = new String[5];
        int count = 0;

        tools[count++] = "Arrosoir";
        tools[count++] = "Râteau";
        tools[count++] = "Bêche";

        System.out.println("Outils :");
        for (int i = 0; i < count; i++) {
            System.out.println("- " + tools[i]);
        }

        System.out.println("Nombre d'outils : " + count);
    }
}
```

**Nouvelles exigences :**

- Remplacez le tableau `String[]` par une `ArrayList<String>`.
- Supprimez la variable `count` (utilisez `size()` à la place).
- Remplacez la boucle `for` classique par une boucle `for-each`.
- Ajoutez un 4e outil `"Sécateur"` à la fin de la liste.
- Le reste du comportement doit rester identique.

<details>
<summary>Afficher la solution</summary>

```java
import java.util.ArrayList;
import java.util.List;

public class GardenTools {
    public static void main(String[] args) {
        List<String> tools = new ArrayList<>();

        tools.add("Arrosoir");
        tools.add("Râteau");
        tools.add("Bêche");
        tools.add("Sécateur");

        System.out.println("Outils :");
        for (String tool : tools) {
            System.out.println("- " + tool);
        }

        System.out.println("Nombre d'outils : " + tools.size());
    }
}
```

**Explication** : On remplace le tableau par une `ArrayList` qui gère
automatiquement sa taille. La variable `count` n'est plus nécessaire car
`size()` retourne le nombre d'éléments. La boucle `for-each` simplifie le
parcours. L'ajout d'un 4e élément se fait simplement avec `add()` sans se
soucier de la taille.

</details>

### Exercice 12 - Ajout d'un ensemble pour garantir l'unicité

Le code suivant gère une liste de bénévoles pour un jardin communautaire. Le
problème est qu'une même personne peut être ajoutée plusieurs fois. Modifiez le
code pour garantir l'unicité des bénévoles tout en conservant l'ordre
d'inscription.

**Code de départ :**

```java
import java.util.ArrayList;
import java.util.List;

public class VolunteerList {
    public static void main(String[] args) {
        List<String> volunteers = new ArrayList<>();

        registerVolunteer(volunteers, "Alice");
        registerVolunteer(volunteers, "Bob");
        registerVolunteer(volunteers, "Alice"); // Doublon !
        registerVolunteer(volunteers, "Clara");
        registerVolunteer(volunteers, "Bob");   // Doublon !

        System.out.println("Bénévoles : " + volunteers);
        System.out.println("Nombre : " + volunteers.size());
    }

    static void registerVolunteer(List<String> list, String name) {
        list.add(name);
        System.out.println(name + " inscrit(e).");
    }
}
```

**Nouvelles exigences :**

- Ajoutez un `HashSet<String>` pour vérifier les doublons avant l'ajout.
- La méthode `registerVolunteer` doit afficher un message différent si la
  personne est déjà inscrite.
- La liste `ArrayList` doit rester pour conserver l'ordre d'inscription.

<details>
<summary>Afficher la solution</summary>

```java
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VolunteerList {
    public static void main(String[] args) {
        List<String> volunteers = new ArrayList<>();
        Set<String> knownVolunteers = new HashSet<>();

        registerVolunteer(volunteers, knownVolunteers, "Alice");
        registerVolunteer(volunteers, knownVolunteers, "Bob");
        registerVolunteer(volunteers, knownVolunteers, "Alice");
        registerVolunteer(volunteers, knownVolunteers, "Clara");
        registerVolunteer(volunteers, knownVolunteers, "Bob");

        System.out.println("Bénévoles : " + volunteers);
        System.out.println("Nombre : " + volunteers.size());
    }

    static void registerVolunteer(List<String> list, Set<String> known,
            String name) {
        if (known.contains(name)) {
            System.out.println(name + " est déjà inscrit(e).");
        } else {
            list.add(name);
            known.add(name);
            System.out.println(name + " inscrit(e).");
        }
    }
}
```

**Résultat :**

```
Alice inscrit(e).
Bob inscrit(e).
Alice est déjà inscrit(e).
Clara inscrit(e).
Bob est déjà inscrit(e).
Bénévoles : [Alice, Bob, Clara]
Nombre : 3
```

**Explication** : On utilise un `HashSet` pour vérifier rapidement si un nom
existe déjà. L'`ArrayList` conserve l'ordre d'inscription. C'est un usage
classique de combiner une liste et un ensemble pour profiter des avantages des
deux : l'ordre de la liste et la recherche rapide de l'ensemble.

</details>

## Exercices de transfert

Ces exercices vous demandent d'appliquer les concepts à de nouveaux contextes.

### Exercice 13 - Gestion d'un inventaire de bibliothèque

Créez un système simple pour gérer les livres d'une bibliothèque de quartier
utilisant différentes collections.

**Cahier des charges :**

1. Créez une classe `Book` avec :
   - Attributs : `String title`, `String author`, `int year`
   - Constructeur, getters et `toString()`
   - Méthodes `equals()` et `hashCode()` basées sur `title` et `author`

2. Dans le programme principal :
   - Créez une `List<Book>` contenant 5 livres (dont un doublon).
   - Créez un `Set<Book>` à partir de la liste pour éliminer les doublons.
   - Créez une `Map<String, List<Book>>` qui associe chaque auteur à la liste de
     ses livres.
   - Affichez le nombre de livres uniques.
   - Affichez les livres par auteur.

<details>
<summary>Indice</summary>

Pour la map par auteur, parcourez le `Set<Book>` et utilisez `containsKey()`
pour vérifier si l'auteur est déjà dans la map. Si oui, ajoutez le livre à la
liste existante. Sinon, créez une nouvelle liste.

</details>

<details>
<summary>Afficher la solution</summary>

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Book {
    String title;
    String author;
    int year;

    Book(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() {
        return title + " (" + author + ", " + year + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        Book book = (Book) obj;
        return title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        int result = title.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}

public class LibraryInventory {
    public static void main(String[] args) {
        // Liste avec un doublon
        List<Book> allBooks = new ArrayList<>();
        allBooks.add(new Book("1984", "George Orwell", 1949));
        allBooks.add(new Book("Le Petit Prince", "Antoine de Saint-Exupéry", 1943));
        allBooks.add(new Book("La Ferme des animaux", "George Orwell", 1945));
        allBooks.add(new Book("1984", "George Orwell", 1949)); // Doublon
        allBooks.add(new Book("Vol de nuit", "Antoine de Saint-Exupéry", 1931));

        System.out.println("Total (avec doublons) : " + allBooks.size());

        // Ensemble pour éliminer les doublons
        Set<Book> uniqueBooks = new HashSet<>(allBooks);
        System.out.println("Livres uniques : " + uniqueBooks.size());

        // Map par auteur
        Map<String, List<Book>> booksByAuthor = new HashMap<>();

        for (Book book : uniqueBooks) {
            if (!booksByAuthor.containsKey(book.author)) {
                booksByAuthor.put(book.author, new ArrayList<>());
            }
            booksByAuthor.get(book.author).add(book);
        }

        // Afficher les livres par auteur
        for (Map.Entry<String, List<Book>> entry : booksByAuthor.entrySet()) {
            System.out.println("\n" + entry.getKey() + " :");
            for (Book book : entry.getValue()) {
                System.out.println("  - " + book);
            }
        }
    }
}
```

**Résultat attendu :**

```
Total (avec doublons) : 5
Livres uniques : 4

George Orwell :
  - 1984 (George Orwell, 1949)
  - La Ferme des animaux (George Orwell, 1945)

Antoine de Saint-Exupéry :
  - Le Petit Prince (Antoine de Saint-Exupéry, 1943)
  - Vol de nuit (Antoine de Saint-Exupéry, 1931)
```

**Explication** : Cet exercice combine les trois types de collections :

- `ArrayList` pour stocker tous les livres (avec doublons possibles).
- `HashSet` pour éliminer les doublons grâce à `equals()` et `hashCode()`.
- `HashMap` pour regrouper les livres par auteur.

La clé de la map est l'auteur (`String`), la valeur est une `List<Book>` car un
auteur peut avoir plusieurs livres.

</details>

### Exercice 14 - Système de vote pour un conseil étudiant

Créez un programme qui gère un vote : chaque personne ne peut voter qu'une seule
fois, et le programme doit compter les votes par candidat et annoncer la
gagnante ou le gagnant.

**Cahier des charges :**

1. Utilisez un `Set<String>` pour suivre les personnes ayant déjà voté.
2. Utilisez une `Map<String, Integer>` pour compter les votes par candidat.
3. Créez une méthode `vote(String voter, String candidate, ...)` qui :
   - Vérifie si la personne a déjà voté (affiche un message si c'est le cas).
   - Enregistre le vote si la personne n'a pas encore voté.
4. Créez une méthode `displayResults(...)` qui :
   - Affiche le nombre de votes par candidat.
   - Détermine et annonce la gagnante ou le gagnant.

**Votes à simuler :**

- Alice vote pour "Marie"
- Bob vote pour "Jean"
- Clara vote pour "Marie"
- Alice vote pour "Jean" (doublon !)
- David vote pour "Marie"
- Eva vote pour "Jean"

<details>
<summary>Indice</summary>

Pour compter les votes, vérifiez si le candidat existe déjà dans la map avec
`containsKey()`. Si oui, récupérez sa valeur avec `get()`, incrémentez-la et
mettez-la à jour avec `put()`. Sinon, ajoutez-le avec une valeur de `1`.

Pour trouver le gagnant, parcourez la map et gardez la trace du candidat avec le
plus de votes.

</details>

<details>
<summary>Afficher la solution</summary>

```java
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StudentCouncilVote {

    static Set<String> voters = new HashSet<>();
    static Map<String, Integer> results = new HashMap<>();

    public static void main(String[] args) {
        vote("Alice", "Marie");
        vote("Bob", "Jean");
        vote("Clara", "Marie");
        vote("Alice", "Jean"); // Doublon
        vote("David", "Marie");
        vote("Eva", "Jean");

        System.out.println();
        displayResults();
    }

    static void vote(String voter, String candidate) {
        if (voters.contains(voter)) {
            System.out.println(voter + " a déjà voté. Vote refusé.");
            return;
        }

        voters.add(voter);

        if (results.containsKey(candidate)) {
            results.put(candidate, results.get(candidate) + 1);
        } else {
            results.put(candidate, 1);
        }

        System.out.println(voter + " a voté pour " + candidate + ".");
    }

    static void displayResults() {
        System.out.println("=== Résultats du vote ===");

        String winner = "";
        int maxVotes = 0;

        for (Map.Entry<String, Integer> entry : results.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue()
                    + " vote(s)");
            if (entry.getValue() > maxVotes) {
                maxVotes = entry.getValue();
                winner = entry.getKey();
            }
        }

        System.out.println("\nGagnant(e) : " + winner + " avec "
                + maxVotes + " vote(s) !");
    }
}
```

**Résultat attendu :**

```
Alice a voté pour Marie.
Bob a voté pour Jean.
Clara a voté pour Marie.
Alice a déjà voté. Vote refusé.
David a voté pour Marie.
Eva a voté pour Jean.

=== Résultats du vote ===
Jean : 2 vote(s)
Marie : 3 vote(s)

Gagnant(e) : Marie avec 3 vote(s) !
```

**Explication** : Le `HashSet` des personnes ayant voté permet de vérifier
rapidement si quelqu'un a déjà voté. La `HashMap` compte les votes par candidat.
Le parcours final avec `entrySet()` permet de trouver le maximum.

Ce système combine les forces de deux collections :

- le `Set` pour garantir l'unicité des votes (une personne = un vote) ;
- la `Map` pour associer chaque candidat à son nombre de votes.

</details>

## Conclusion

Ces exercices couvrent les concepts fondamentaux des collections Java :

- **Complétion** : manipulation de base des listes, ensembles et maps.
- **Prédiction** : compréhension du comportement des doublons, de `put()` et de
  la `ConcurrentModificationException`.
- **Comparaison** : choix entre `ArrayList`/`HashSet` et `HashMap`/`TreeMap`.
- **Modification** : migration de tableaux vers des collections et combinaison
  de collections.
- **Transfert** : application complète dans de nouveaux contextes (bibliothèque,
  système de vote).

N'hésitez pas à relire le [contenu de cours](../) si certains concepts sont
encore flous, puis à refaire les exercices pour consolider votre compréhension.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
