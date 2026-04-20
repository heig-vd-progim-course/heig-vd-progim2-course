---
marp: true
theme: "custom-marp-theme"
size: "16:9"
paginate: "true"
author: "V. Guidoux, avec l'aide de GitHub Copilot"
description:
  "Collections Java - Les génériques pour le cours ProgIM2 enseigné à la
  HEIG-VD, Suisse"
lang: "fr"
url: "https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/presentation.html"
header: "[**Collections Java : Les génériques**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Collections Java : Les génériques

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

_Cette présentation est un résumé du contenu complet disponible sur GitHub._

_Pour plus de détails, consulter le [contenu complet sur
GitHub][contenu-complet-sur-github] ou en cliquant sur l'en-tête de ce
document._

## Objectifs (1/3)

- Expliquer l'utilité des génériques pour la sécurité de type et la
  réutilisabilité du code.
- Identifier les trois problèmes résolus par les génériques : code dupliqué,
  absence de sécurité de type et conversions de type manuelles.

![bg right:40%][illustration-objectifs]

## Objectifs (2/3)

- Créer des classes et des méthodes génériques avec des paramètres de type.
- Utiliser l'opérateur diamant (`<>`) pour l'inférence de type.
- Comparer les génériques avec le polymorphisme (sous-typage vs paramétrique).

![bg right:40%][illustration-objectifs]

## Objectifs (3/3)

- Appliquer les génériques avec les collections pour éviter les erreurs de type
  à la compilation.
- Expliquer le concept d'effacement de type (type erasure) et ses limitations.

![bg right:40%][illustration-objectifs]

## Introduction : écrire du code réutilisable et sûr

Dans le chapitre précédent, nous avons utilisé les collections Java :
`ArrayList<PlantBase>`, `HashMap<String, Plot>`, etc.

Ces chevrons (`<>`) utilisent un mécanisme fondamental de Java : les
**génériques**.

- Pourquoi les génériques existent.
- Comment créer nos propres classes et méthodes génériques.
- Comment les génériques se comparent au polymorphisme.

## Les génériques

<!-- _class: lead -->

### Le problème : trois raisons d'utiliser les génériques

Sans les génériques, on se heurte à trois problèmes concrets :

1. Le **code dupliqué** : une classe par type.
2. L'**absence de sécurité de type** : erreurs à l'exécution.
3. Les **conversions de type manuelles** : casts risqués.

#### Premier problème : le code dupliqué (réutilisabilité)

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

#### Deuxième problème : l'absence de sécurité de type (1/2)

On pourrait utiliser `Object` pour éviter la duplication :

```java
public class ObjectBox {
    private Object value;
    public void set(Object value) { this.value = value; }
    public Object get() { return value; }
}
```

#### Deuxième problème : l'absence de sécurité de type (2/2)

Le code n'est plus dupliqué, mais on perd la sécurité :

```java
ObjectBox box = new ObjectBox();
box.set("Tomate");
box.set(42);     // Pas d'erreur de compilation !
box.set(3.14);   // Pas d'erreur non plus !
```

Le compilateur ne vérifie plus rien. L'erreur ne se manifeste qu'à l'exécution.

#### Troisième problème : les conversions de type manuelles (casting) (1/2)

Comme `ObjectBox.get()` retourne un `Object`, il faut caster à chaque fois :

```java
ObjectBox box = new ObjectBox();
box.set("Tomate");
String value = (String) box.get(); // Cast manuel
```

#### Troisième problème : les conversions de type manuelles (casting) (2/2)

Si on se trompe de type :

```java
ObjectBox box = new ObjectBox();
box.set(42);
String value = (String) box.get(); // ClassCastException !
```

Les casts rendent le code fragile. On préférerait que le compilateur détecte ces
erreurs **avant** l'exécution.

### Les classes génériques

Une classe générique déclare un paramètre de type entre chevrons (`<>`). Ce
paramètre est remplacé par un type concret à l'utilisation :

```java
public class Box<T> {
    private T value;

    public void set(T value) { this.value = value; }
    public T get() { return value; }
}
```

`T` est un paramètre de type. Par convention : `T` (type), `E` (element), `K`
(key), `V` (value).

### Les classes génériques - utilisation

```java
Box<String> stringBox = new Box<>();
stringBox.set("Tomate");
String name = stringBox.get(); // Pas de cast !

Box<Integer> intBox = new Box<>();
intBox.set(42);
int value = intBox.get();

stringBox.set(42); // Erreur de compilation !
```

**Réutilisabilité, Sécurité, Pas de cast**

### Les classes génériques - plusieurs paramètres

<div class="two-columns">
<div>

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

</div>
<div>

```java
public class Main {
    public static void main(String[] args) {
        Pair<String, Integer> plantAge =
                new Pair<>("Pommier", 3);
        String name = plantAge.getKey();   // "Pommier"
        int age = plantAge.getValue();      // 3
    }
}
```

</div>
</div>

### Les méthodes génériques

```java
public class GardenUtils {

    public static <T> void printAll(List<T> items) {
        for (T item : items) {
            System.out.println(item);
        }
    }
    public static <T> T getFirst(List<T> items) {
        if (items.isEmpty()) {
            return null;
        }
        return items.get(0);
    }
}
```

### Les méthodes génériques - utilisation

```java
List<PlantBase> plants = new ArrayList<>();
// ...
GardenUtils.printAll(plants);
// T est inféré comme PlantBase

PlantBase first = GardenUtils.getFirst(plants); // Retourne un PlantBase, pas un Object

// ------------------
List<String> names = List.of("Tomate", "Carotte");
GardenUtils.printAll(names);
// T est inféré comme String

String firstName = GardenUtils.getFirst(names);
// Retourne un String, sans cast
```

### Génériques vs polymorphisme

<!-- _class: lead -->

Les génériques et le polymorphisme permettent tous deux de travailler avec
plusieurs types. Mais leurs mécanismes sont fondamentalement différents.

#### Le polymorphisme de sous-typage

Le comportement change selon le type réel de l'objet (résolution à l'exécution)
:

```java
PlantBase plant = new VegetablePlant(
        "Tomate", "Solanum lycopersicum",
        "2026-03-15", 45.5, 30);
System.out.println(plant.toString());
// Appelle VegetablePlant.toString()
// pas PlantBase.toString()
```

"Je ne sais pas quel sous-type tu es, mais chaque sous-type répondra
**différemment**."

#### Les génériques (polymorphisme paramétrique)

Le comportement reste identique, quel que soit le type (résolution à la
compilation) :

```java
Box<String> stringBox = new Box<>("Tomate");
Box<Integer> intBox = new Box<>(42);
// Les deux utilisent exactement le même code
```

"Je ne me soucie pas du type, le conteneur fonctionne de la **même manière**
pour tous les types."

#### Comparaison

| Critère       | Polymorphisme              | Génériques                 |
| :------------ | :------------------------- | :------------------------- |
| Mécanisme.    | Héritage et redéfinition.  | Paramètre de type (`<T>`). |
| Résolution.   | Exécution (dynamique).     | Compilation (statique).    |
| Comportement. | Varie selon le sous-type.  | Identique pour tous.       |
| Sécurité.     | Partielle (cast possible). | Complète (compilation).    |

#### Complémentarité

Les deux mécanismes se complètent. Les types bornés combinent les deux approches
:

```java
public static <T extends PlantBase> void waterAll(
        List<T> plants) {
    for (T plant : plants) {
        if (plant instanceof Waterable) {
            ((Waterable) plant).water();
        }
    }
}
```

### Limitations des génériques (1/2)

Les génériques ont quelques restrictions liées à l'**effacement de type** (type
erasure) :

- Pas de types primitifs : `List<int>` est interdit, utiliser `List<Integer>`.
- Pas de `new T()` : on ne peut pas créer d'instance d'un paramètre de type.
- Pas de `new T[10]` : on ne peut pas créer de tableau d'un type générique.

### Limitations des génériques (1/2)

Java remplace les types génériques par `Object` à la compilation. Les génériques
n'existent qu'à la compilation, pas à l'exécution :

```java
Box<String> box1 = new Box<>("Hello");
Box<Integer> box2 = new Box<>(42);
System.out.println(box1.getClass() == box2.getClass()); // true
```

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## À vous de jouer !

- (Re)lire le contenu de cours.
- Lire les exemples de code et les descriptions.
- Faire les exercices. Faire le mini-projet. Poser des questions si nécessaire.

[Visualiser le contenu complet sur GitHub.][contenu-complet-sur-github]

**N'hésitez pas à vous entraider si vous avez des difficultés !**

![bg right:30%][illustration-a-vous-de-jouer]

## Sources

- [Illustration][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/low-angle-view-of-ball-shoots-in-the-ring-j6brni7fpvs)
- [Illustration][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/white-sony-ps4-dualshock-controller-over-persons-palm-FJFPuE1MAOM)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/09-collections-java-lambda-et-generiques/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
