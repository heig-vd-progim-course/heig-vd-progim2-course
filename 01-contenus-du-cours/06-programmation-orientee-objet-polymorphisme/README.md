# Programmation orientée objet : Polymorphisme

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
> - Expliquer le concept de polymorphisme en POO.
> - Utiliser des références de type parent pour des objets de type enfant.
> - Appliquer le polymorphisme pour traiter différents objets de manière
>   uniforme.
> - Démontrer comment le polymorphisme améliore la flexibilité du code.
> - Appliquer la redéfinition pour adapter le comportement aux sous-classes.
> - Définir une interface Java avec le mot-clé `interface`.
> - Implémenter une ou plusieurs interfaces dans une classe.
> - Différencier une interface d'une classe abstraite.
> - Justifier l'utilisation d'interfaces pour le polymorphisme.
> - Redéfinir la méthode `toString()` pour représenter un objet sous forme de
>   chaîne.
> - Implémenter `equals()` pour comparer deux objets de manière significative.
> - Implémenter `hashCode()` en cohérence avec `equals()`.
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
- [Introduction au polymorphisme](#introduction-au-polymorphisme)
	- [Pourquoi le polymorphisme est-il important ?](#pourquoi-le-polymorphisme-est-il-important-)
	- [Les trois piliers de la POO](#les-trois-piliers-de-la-poo)
- [Le polymorphisme d'héritage](#le-polymorphisme-dhéritage)
	- [Références de type parent](#références-de-type-parent)
	- [Liaison dynamique](#liaison-dynamique)
	- [Avantages du polymorphisme d'héritage](#avantages-du-polymorphisme-dhéritage)
- [La redéfinition de méthodes](#la-redéfinition-de-méthodes)
	- [Règles de la redéfinition](#règles-de-la-redéfinition)
	- [L'annotation @Override](#lannotation-override)
- [Les interfaces en Java](#les-interfaces-en-java)
	- [Qu'est-ce qu'une interface ?](#quest-ce-quune-interface-)
	- [Définir une interface](#définir-une-interface)
	- [Implémenter une interface](#implémenter-une-interface)
	- [Implémenter plusieurs interfaces](#implémenter-plusieurs-interfaces)
	- [Polymorphisme avec les interfaces](#polymorphisme-avec-les-interfaces)
- [Interface vs classe abstraite](#interface-vs-classe-abstraite)
	- [Les points communs](#les-points-communs)
	- [Les différences](#les-différences)
	- [Quand utiliser quoi ?](#quand-utiliser-quoi-)
- [Redéfinition des méthodes de Object](#redéfinition-des-méthodes-de-object)
	- [La méthode toString()](#la-méthode-tostring)
	- [Les méthodes equals() et hashCode()](#les-méthodes-equals-et-hashcode)
	- [Pourquoi redéfinir equals() et hashCode() ensemble ?](#pourquoi-redéfinir-equals-et-hashcode-ensemble-)
- [Le polymorphisme en pratique](#le-polymorphisme-en-pratique)
	- [Collections polymorphes](#collections-polymorphes)
	- [Conception flexible](#conception-flexible)
- [Conclusion](#conclusion)
- [Exemples de code](#exemples-de-code)
- [Exercices](#exercices)
- [Mini-projet](#mini-projet)
- [À faire pour la prochaine séance](#à-faire-pour-la-prochaine-séance)

## Introduction au polymorphisme

Le polymorphisme est l'un des concepts fondamentaux de la programmation orientée
objet, aux côtés de l'encapsulation et de l'héritage que nous avons déjà
étudiés. Le terme vient du grec _poly_ (plusieurs) et _morphe_ (forme),
signifiant littéralement "plusieurs formes".

En programmation orientée objet, le polymorphisme permet à un même code de
manipuler des objets de types différents de manière uniforme. C'est la capacité
d'un objet à prendre différentes formes tout en conservant une interface
commune.

### Pourquoi le polymorphisme est-il important ?

Sans polymorphisme, notre code serait rigide et difficile à maintenir. Imaginons
un jardin communautaire où nous devons gérer différents types de plantes :
légumes, fleurs, arbres fruitiers. Sans polymorphisme, nous devrions écrire du
code spécifique pour chaque type :

```java
if (plant instanceof VegetablePlant) {
    VegetablePlant veg = (VegetablePlant) plant;
    veg.water();
} else if (plant instanceof FlowerPlant) {
    FlowerPlant flower = (FlowerPlant) plant;
    flower.water();
} else if (plant instanceof TreePlant) {
    TreePlant tree = (TreePlant) plant;
    tree.water();
}
```

Avec le polymorphisme, ce code devient simplement :

```java
plant.water();
```

Le polymorphisme nous permet d'écrire du code plus flexible, plus facile à
maintenir et à étendre. Ajouter un nouveau type de plante ne nécessite pas de
modifier le code existant, seulement d'implémenter l'interface ou d'hériter de
la classe appropriée.

### Les trois piliers de la POO

Rappelons les trois concepts fondamentaux de la programmation orientée objet,
qui travaillent ensemble :

1. **L'encapsulation** : protège les données en les cachant derrière des
   méthodes publiques. Elle définit ce qui est visible et accessible de
   l'extérieur d'une classe.

2. **L'héritage** : permet de créer de nouvelles classes à partir de classes
   existantes, en réutilisant et en étendant leurs fonctionnalités. Il établit
   une relation "est un" entre les classes.

3. **Le polymorphisme** : permet de traiter des objets de classes différentes de
   manière uniforme, tant qu'ils partagent une interface ou une classe parent
   commune. Il exploite l'héritage pour permettre la flexibilité.

Ces trois concepts se renforcent mutuellement. L'encapsulation cache les détails
d'implémentation, l'héritage établit des relations entre classes, et le
polymorphisme permet d'exploiter ces relations pour écrire du code flexible et
réutilisable.

## Le polymorphisme d'héritage

Le polymorphisme d'héritage repose sur la hiérarchie de classes que nous avons
construite dans les séances précédentes. Il exploite le fait qu'une sous-classe
hérite du type de sa classe parent.

### Références de type parent

En Java, une variable peut avoir un type déclaré différent du type réel de
l'objet qu'elle référence, à condition qu'il existe une relation d'héritage
entre les deux types.

Prenons notre exemple de plantes. Si nous avons une hiérarchie :

```text
PlantBase (classe parente)
├── VegetablePlant
├── FlowerPlant
└── TreePlant
```

Nous pouvons écrire :

```java
PlantBase plant1 = new VegetablePlant("Tomate", "Solanum lycopersicum");
PlantBase plant2 = new FlowerPlant("Rose", "Rosa");
PlantBase plant3 = new TreePlant("Pommier", "Malus domestica");
```

Ici, le type déclaré est `PlantBase`, mais les objets réels sont de types
`VegetablePlant`, `FlowerPlant` et `TreePlant`. C'est possible parce que ces
trois classes héritent de `PlantBase` : un légume **est une** plante, une fleur
**est une** plante, un arbre **est une** plante.

Cette capacité est fondamentale pour le polymorphisme. Elle nous permet de
stocker différents types d'objets dans une même collection :

```java
ArrayList<PlantBase> plants = new ArrayList<>();
plants.add(new VegetablePlant("Tomate", "Solanum lycopersicum"));
plants.add(new FlowerPlant("Rose", "Rosa"));
plants.add(new TreePlant("Pommier", "Malus domestica"));

for (PlantBase plant : plants) {
    plant.displayInfo();  // Appelle la méthode appropriée pour chaque type
}
```

### Liaison dynamique

Quand nous appelons une méthode sur une référence de type parent qui pointe vers
un objet de type enfant, Java utilise la **liaison dynamique** (ou résolution
dynamique) pour déterminer quelle version de la méthode exécuter.

```java
PlantBase plant = new VegetablePlant("Tomate", "Solanum lycopersicum");
plant.displayInfo();  // Appelle la version de VegetablePlant, pas celle de PlantBase
```

La décision de quelle méthode appeler se fait **à l'exécution** (runtime), pas à
la compilation. Java regarde le type réel de l'objet (ici `VegetablePlant`), pas
le type de la référence (ici `PlantBase`).

Cette mécanisme est automatique et transparent. C'est la machine virtuelle Java
(JVM) qui s'occupe de tout. Pour la personne qui développe, il suffit de
comprendre que l'objet réel détermine quelle méthode sera exécutée.

### Avantages du polymorphisme d'héritage

Le polymorphisme d'héritage offre plusieurs avantages concrets :

**1. Code plus court et plus clair**

Au lieu d'écrire une méthode pour chaque type de plante :

```java
public void waterVegetable(VegetablePlant veg) { ... }
public void waterFlower(FlowerPlant flower) { ... }
public void waterTree(TreePlant tree) { ... }
```

Nous écrivons une seule méthode :

```java
public void waterPlant(PlantBase plant) {
    plant.water();
}
```

**2. Extensibilité sans modification**

Si nous ajoutons un nouveau type de plante (par exemple `HerbPlant`), le code
existant continue de fonctionner sans modification. C'est le principe
ouvert/fermé : le code est ouvert à l'extension mais fermé à la modification.

**3. Réduction de la duplication**

Au lieu de dupliquer la logique pour chaque type, nous l'écrivons une fois et
elle fonctionne pour tous les types qui partagent la même hiérarchie.

**4. Abstraction du type concret**

Le code qui utilise les objets n'a pas besoin de connaître leur type exact. Il
manipule des concepts abstraits (une plante) plutôt que des détails concrets (un
légume, une fleur).

## La redéfinition de méthodes

La redéfinition (ou surcharge en français, _override_ en anglais) permet à une
sous-classe de fournir sa propre implémentation d'une méthode héritée de sa
classe parent. C'est un mécanisme essentiel du polymorphisme.

Imaginons que notre classe `PlantBase` définit une méthode `water()` générique,
mais que chaque type de plante a des besoins spécifiques en eau :

```java
public class PlantBase {
    public void water() {
        System.out.println("Arrosage standard de la plante.");
    }
}

public class VegetablePlant extends PlantBase {
    @Override
    public void water() {
        System.out.println("Arrosage quotidien du légume avec contrôle de l'humidité.");
    }
}
```

Quand nous appelons `water()` sur un objet `VegetablePlant`, c'est la version
redéfinie qui est exécutée, même si la référence est de type `PlantBase` :

```java
PlantBase plant = new VegetablePlant("Tomate", "Solanum lycopersicum");
plant.water();  // Affiche le message spécifique aux légumes
```

### Règles de la redéfinition

Pour redéfinir correctement une méthode en Java, plusieurs règles doivent être
respectées :

1. **Même signature** : la méthode doit avoir le même nom, les mêmes types de
   paramètres et le même nombre de paramètres que dans la classe parent.

2. **Type de retour compatible** : le type de retour doit être le même ou un
   sous-type (_covariant_). Par exemple, si la méthode parent retourne
   `PlantBase`, la méthode enfant peut retourner `VegetablePlant`.

3. **Visibilité égale ou plus grande** : si la méthode parent est `public`, la
   méthode redéfinie doit aussi être `public`. Elle ne peut pas être `private`
   ou `protected`.

4. **Exceptions plus spécifiques** : la méthode redéfinie peut lever les mêmes
   exceptions que la méthode parent, ou des exceptions plus spécifiques, mais
   pas d'exceptions plus générales ou nouvelles.

5. **Méthodes non final** : seules les méthodes non marquées `final` dans la
   classe parent peuvent être redéfinies.

Si une de ces règles n'est pas respectée, le compilateur Java génère une erreur.

### L'annotation @Override

Java fournit l'annotation `@Override` pour marquer explicitement qu'une méthode
est destinée à redéfinir une méthode de la classe parent :

```java
@Override
public void water() {
    // Implémentation spécifique
}
```

Cette annotation n'est pas obligatoire, mais elle est **fortement recommandée**
pour plusieurs raisons :

1. **Vérification à la compilation** : si la méthode ne redéfinit pas vraiment
   une méthode parent (par exemple à cause d'une faute de frappe dans le nom),
   le compilateur génère une erreur.

2. **Documentation** : elle rend explicite l'intention de redéfinir une méthode,
   ce qui améliore la lisibilité du code.

3. **Protection contre les erreurs** : si la signature de la méthode parent
   change dans une future version, le compilateur signalera que l'annotation
   `@Override` n'est plus valide.

C'est une bonne pratique de toujours utiliser `@Override` quand on redéfinit une
méthode.

## Les interfaces en Java

Les interfaces représentent l'autre forme majeure de polymorphisme en Java, aux
côtés de l'héritage de classes. Elles permettent de définir des contrats que les
classes doivent respecter, indépendamment de leur hiérarchie d'héritage.

### Qu'est-ce qu'une interface ?

Une interface est un contrat qui spécifie un ensemble de méthodes qu'une classe
doit implémenter, sans définir comment ces méthodes fonctionnent. C'est une
promesse : "Si tu implémentes cette interface, tu dois fournir ces méthodes".

Prenons un exemple concret. Dans notre jardin, certaines plantes peuvent être
récoltées (légumes, arbres fruitiers) mais pas d'autres (fleurs ornementales).
Au lieu de mettre une méthode `harvest()` dans toutes les classes, nous créons
une interface `Harvestable` :

```java
public interface Harvestable {
    boolean isReadyToHarvest();
    void harvest();
}
```

Cette interface dit : "Tout objet qui implémente `Harvestable` doit fournir ces
deux méthodes". Elle ne dit pas comment les implémenter, seulement qu'elles
doivent exister.

### Définir une interface

La syntaxe pour définir une interface est similaire à celle d'une classe, mais
avec le mot-clé `interface` :

```java
public interface Waterable {
    double getWaterNeedsPerWeek();
    void water();
}
```

Les caractéristiques d'une interface :

1. **Méthodes abstraites** : par défaut, toutes les méthodes sont publiques et
   abstraites (pas d'implémentation). Vous n'avez pas besoin d'écrire
   `public abstract` devant chaque méthode.

2. **Constantes** : les interfaces peuvent contenir des constantes (variables
   `public static final`), mais pas de variables d'instance.

3. **Pas de constructeur** : les interfaces ne peuvent pas avoir de constructeur
   car elles ne peuvent pas être instanciées directement.

4. **Méthodes par défaut (depuis Java 8)** : les interfaces peuvent contenir des
   méthodes avec une implémentation par défaut en utilisant le mot-clé
   `default`.

5. **Méthodes statiques** : les interfaces peuvent contenir des méthodes
   statiques avec implémentation.

Pour notre cours, nous nous concentrons sur les méthodes abstraites, qui sont le
cas d'usage principal des interfaces.

### Implémenter une interface

Une classe implémente une interface en utilisant le mot-clé `implements` :

```java
public class VegetablePlant extends PlantBase implements Harvestable {
    @Override
    public boolean isReadyToHarvest() {
        return this.age >= this.daysToHarvest;
    }

    @Override
    public void harvest() {
        if (isReadyToHarvest()) {
            System.out.println("Récolte de " + this.name);
        } else {
            System.out.println("Pas encore prêt à être récolté.");
        }
    }
}
```

Quand une classe implémente une interface, elle **doit** fournir une
implémentation pour toutes les méthodes de l'interface. Si elle ne le fait pas,
le compilateur génère une erreur, sauf si la classe est déclarée `abstract`.

Notez l'utilisation de `@Override` : même si nous implémentons une méthode
d'interface (et pas d'une classe parent), `@Override` est approprié et
recommandé.

### Implémenter plusieurs interfaces

Contrairement à l'héritage de classes (où une classe ne peut hériter que d'une
seule classe parent), une classe peut implémenter plusieurs interfaces. C'est
une des forces majeures des interfaces.

```java
public class VegetablePlant extends PlantBase
        implements Harvestable, Waterable, Growable {
    // Doit implémenter toutes les méthodes de Harvestable, Waterable et Growable
}
```

Les interfaces multiples permettent de composer des comportements de manière
flexible. Un légume peut être récoltable, arrosable et capable de grandir, tout
en héritant de `PlantBase`.

Cela résout le problème de l'héritage multiple (qu'une classe ne peut avoir
qu'un seul parent direct). Les interfaces permettent à une classe d'adopter
plusieurs "rôles" ou "capacités" sans les contraintes de l'héritage multiple.

### Polymorphisme avec les interfaces

Comme avec l'héritage de classes, les interfaces permettent le polymorphisme.
Une variable de type interface peut référencer tout objet dont la classe
implémente cette interface :

```java
Harvestable item1 = new VegetablePlant("Tomate", "Solanum lycopersicum");
Harvestable item2 = new TreePlant("Pommier", "Malus domestica");

// Les deux peuvent être traités de la même manière
if (item1.isReadyToHarvest()) {
    item1.harvest();
}

if (item2.isReadyToHarvest()) {
    item2.harvest();
}
```

Le type réel de l'objet (`VegetablePlant` ou `TreePlant`) n'a pas d'importance
tant qu'il implémente l'interface `Harvestable`. Nous pouvons même créer une
collection d'objets récoltables :

```java
ArrayList<Harvestable> harvestableItems = new ArrayList<>();
harvestableItems.add(new VegetablePlant("Tomate", "Solanum lycopersicum"));
harvestableItems.add(new TreePlant("Pommier", "Malus domestica"));
// Mais pas : harvestableItems.add(new FlowerPlant(...))  car FlowerPlant n'implémente pas Harvestable

for (Harvestable item : harvestableItems) {
    if (item.isReadyToHarvest()) {
        item.harvest();
    }
}
```

Cette approche est extrêmement puissante. Elle nous permet de regrouper et de
traiter des objets en fonction de leurs capacités (ce qu'ils peuvent faire)
plutôt que de leur type exact (ce qu'ils sont).

## Interface vs classe abstraite

Les interfaces et les classes abstraites semblent parfois similaires : les deux
définissent des méthodes que les sous-classes doivent implémenter. Cependant,
ils ont des objectifs et des caractéristiques différents.

### Les points communs

Interfaces et classes abstraites :

1. **Ne peuvent pas être instanciées** : on ne peut pas faire
   `new MyInterface()` ou `new MyAbstractClass()`.

2. **Définissent des contrats** : ils spécifient des méthodes que les classes
   concrètes doivent fournir.

3. **Permettent le polymorphisme** : une variable de type interface ou classe
   abstraite peut référencer des objets de types concrets.

4. **Servent de types** : on peut déclarer des variables, des paramètres de
   méthodes, et des types de retour avec ces types.

### Les différences

Les différences fondamentales entre interfaces et classes abstraites :

| Aspect                  | Interface                         | Classe abstraite             |
| :---------------------- | :-------------------------------- | :--------------------------- |
| Héritage multiple       | Une classe peut implémenter       | Une classe ne peut hériter   |
|                         | plusieurs interfaces              | que d'une seule classe       |
| Méthodes                | Seulement abstraites (par défaut) | Abstraites et concrètes      |
| Attributs               | Seulement constantes              | Attributs d'instance et      |
|                         | (`public static final`)           | constantes                   |
| Constructeur            | Pas de constructeur               | Peut avoir des constructeurs |
| Relation                | Définit "ce que l'objet peut      | Définit "ce que l'objet est" |
|                         | faire" (capacités)                | (nature)                     |
| Visibilité des méthodes | Toujours `public`                 | `public`, `protected`, ou    |
|                         |                                   | _package-private_            |
| Mot-clé                 | `implements`                      | `extends`                    |
| Usage typique           | Contrats de comportement          | Hiérarchie avec code commun  |

### Quand utiliser quoi ?

**Utilisez une interface quand :**

1. Vous voulez définir des capacités ou des comportements que des classes non
   liées peuvent partager. Par exemple, `Harvestable` peut s'appliquer à des
   légumes et des arbres qui n'ont pas forcément de lien hiérarchique.

2. Vous avez besoin qu'une classe adopte plusieurs rôles. Une classe peut
   implémenter plusieurs interfaces.

3. Vous voulez spécifier un contrat sans imposer de structure d'héritage. Les
   interfaces sont plus flexibles et moins contraignantes.

4. Vous concevez une API publique où vous voulez laisser le maximum de
   flexibilité aux personnes qui utilisent votre code.

**Utilisez une classe abstraite quand :**

1. Vous avez du code commun à partager entre plusieurs classes. Les classes
   abstraites peuvent contenir des méthodes concrètes avec implémentation.

2. Vous voulez définir une hiérarchie claire avec une relation "est un". Par
   exemple, `VegetablePlant` **est une** `PlantBase`.

3. Vous avez besoin d'attributs d'instance partagés. Les classes abstraites
   peuvent avoir des attributs non constants.

4. Vous voulez contrôler la construction des objets. Les classes abstraites
   peuvent avoir des constructeurs.

Dans notre exemple de jardin :

- `PlantBase` est une classe abstraite parce qu'elle définit ce qu'est une
  plante (nature) et fournit du code commun (attributs `name`, `species`, etc.).

- `Harvestable`, `Waterable`, `Growable` sont des interfaces parce qu'elles
  définissent des capacités que différentes plantes peuvent avoir indépendamment
  de leur type exact.

En pratique, on utilise souvent les deux ensemble : une hiérarchie de classes
pour la structure et l'état partagé, et des interfaces pour les comportements et
capacités.

## Redéfinition des méthodes de Object

En Java, toutes les classes héritent automatiquement de la classe `Object`, même
si ce n'est pas explicitement écrit. La classe `Object` est la racine de la
hiérarchie de classes Java.

`Object` fournit plusieurs méthodes que toutes les classes héritent. Trois
d'entre elles sont particulièrement importantes à redéfinir pour améliorer le
comportement de nos classes : `toString()`, `equals()` et `hashCode()`.

### La méthode toString()

La méthode `toString()` retourne une représentation textuelle d'un objet. Elle
est appelée automatiquement dans plusieurs situations :

1. Quand on utilise `System.out.println(object)`
2. Quand on concatène un objet avec une chaîne : `"Objet: " + object`
3. Dans le débogueur pour afficher les valeurs

Par défaut, `toString()` retourne quelque chose comme `VegetablePlant@15db9742`
(le nom de la classe suivi d'un code hexadécimal), ce qui n'est pas très utile.

Redéfinir `toString()` nous permet de fournir une représentation plus
significative :

```java
@Override
public String toString() {
    return "PlantBase{name='" + name + "', species='" + species + "'}";
}
```

Maintenant, `System.out.println(plant)` affiche quelque chose d'utile comme
`PlantBase{name='Tomate', species='Solanum lycopersicum'}`.

**Bonnes pratiques pour toString() :**

1. Incluez les attributs importants qui identifient l'objet
2. Utilisez un format cohérent dans toute votre base de code
3. N'incluez pas d'informations sensibles (mots de passe, etc.)
4. Gardez la représentation concise et lisible

Les sous-classes peuvent redéfinir `toString()` à leur tour pour ajouter leurs
propres attributs :

```java
@Override
public String toString() {
    return "VegetablePlant{" +
           "name='" + getName() + "', " +
           "species='" + getSpecies() + "', " +
           "daysToHarvest=" + daysToHarvest +
           "}";
}
```

Une technique courante est d'appeler `super.toString()` et d'ajouter les
informations spécifiques :

```java
@Override
public String toString() {
    return super.toString() + ", daysToHarvest=" + daysToHarvest;
}
```

### Les méthodes equals() et hashCode()

Les méthodes `equals()` et `hashCode()` travaillent ensemble pour permettre la
comparaison d'objets et leur utilisation dans des collections comme `HashSet` ou
`HashMap`.

**La méthode equals()**

Par défaut, `equals()` compare les références : deux variables sont égales
seulement si elles pointent vers le même objet en mémoire. Souvent, nous voulons
une comparaison basée sur le contenu plutôt que sur l'identité.

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;  // Même objet
    if (obj == null || getClass() != obj.getClass()) return false;  // Null ou type différent

    PlantBase that = (PlantBase) obj;
    return name.equals(that.name) && species.equals(that.species);
}
```

Cette implémentation dit : deux plantes sont égales si elles ont le même nom et
la même espèce, même si ce sont deux objets distincts en mémoire.

**La méthode hashCode()**

La méthode `hashCode()` retourne un entier qui sert de "signature" de l'objet.
Elle est utilisée par les structures de données basées sur le hachage comme
`HashSet` et `HashMap` pour organiser efficacement les objets.

```java
@Override
public int hashCode() {
    int result = name.hashCode();
    result = 31 * result + species.hashCode();
    return result;
}
```

La formule `31 * result + ...` est une convention courante. Le nombre 31 est
utilisé parce que c'est un nombre premier, ce qui donne une bonne distribution
des codes de hachage et réduit les collisions.

### Pourquoi redéfinir equals() et hashCode() ensemble ?

En Java, c'est une règle fondamentale : **si vous redéfinissez `equals()`, vous
devez aussi redéfinir `hashCode()`**, et vice-versa.

Le contrat entre `equals()` et `hashCode()` stipule que :

1. Si deux objets sont égaux selon `equals()`, ils doivent avoir le même
   `hashCode()`.
2. Si deux objets ont des `hashCode()` différents, ils ne peuvent pas être égaux
   selon `equals()`.
3. Si deux objets ont le même `hashCode()`, ils peuvent être égaux ou non selon
   `equals()` (collision possible).

Si vous ne respectez pas ce contrat, les collections basées sur le hachage
(`HashSet`, `HashMap`, etc.) ne fonctionneront pas correctement. Par exemple,
vous pourriez ajouter un objet à un `HashSet`, puis le chercher et ne pas le
trouver !

**Exemple du problème :**

```java
// Sans hashCode() redéfini
PlantBase plant1 = new PlantBase("Tomate", "Solanum lycopersicum");
PlantBase plant2 = new PlantBase("Tomate", "Solanum lycopersicum");

Set<PlantBase> plants = new HashSet<>();
plants.add(plant1);

// plant2 est égal à plant1 selon equals(), mais...
System.out.println(plants.contains(plant2));  // Pourrait retourner false !
```

Ce comportement inattendu se produit parce que `HashSet` utilise d'abord
`hashCode()` pour trouver l'emplacement où chercher l'objet. Si les `hashCode()`
diffèrent, `HashSet` ne cherche pas au bon endroit et ne trouve pas l'objet,
même s'il est présent.

**En résumé :** redéfinissez toujours `equals()` et `hashCode()` ensemble, en
utilisant les mêmes attributs dans les deux méthodes.

## Le polymorphisme en pratique

Maintenant que nous avons comprendre les mécanismes du polymorphisme, voyons
comment l'utiliser efficacement dans nos programmes.

### Collections polymorphes

L'un des usages les plus courants du polymorphisme est de stocker et manipuler
des objets de types différents dans une même collection :

```java
ArrayList<PlantBase> garden = new ArrayList<>();
garden.add(new VegetablePlant("Tomate", "Solanum lycopersicum"));
garden.add(new FlowerPlant("Rose", "Rosa"));
garden.add(new TreePlant("Pommier", "Malus domestica"));

// Traitement uniforme
for (PlantBase plant : garden) {
    plant.displayInfo();  // Chaque plante affiche ses informations spécifiques
}
```

Nous pouvons aussi organiser les objets selon leurs capacités :

```java
ArrayList<Harvestable> harvestables = new ArrayList<>();
ArrayList<Waterable> waterables = new ArrayList<>();

PlantBase plant = new VegetablePlant("Tomate", "Solanum lycopersicum");

// Un légume est à la fois récoltable et arrosable
if (plant instanceof Harvestable) {
    harvestables.add((Harvestable) plant);
}
if (plant instanceof Waterable) {
    waterables.add((Waterable) plant);
}
```

Cette organisation permet de traiter les objets en fonction de ce qu'ils peuvent
faire, indépendamment de ce qu'ils sont exactement.

### Conception flexible

Le polymorphisme encourage une conception flexible où l'ajout de nouvelles
fonctionnalités n'oblige pas à modifier le code existant. C'est le principe
**ouvert/fermé** de la conception orientée objet : le code doit être ouvert à
l'extension mais fermé à la modification.

**Exemple sans polymorphisme (rigide) :**

```java
public void processGarden(ArrayList<VegetablePlant> vegetables,
                          ArrayList<FlowerPlant> flowers,
                          ArrayList<TreePlant> trees) {
    for (VegetablePlant veg : vegetables) {
        veg.water();
    }
    for (FlowerPlant flower : flowers) {
        flower.water();
    }
    for (TreePlant tree : trees) {
        tree.water();
    }
}
```

Si nous ajoutons un nouveau type de plante, nous devons modifier cette méthode
pour ajouter une nouvelle boucle. C'est fragile et peu maintenable.

**Exemple avec polymorphisme (flexible) :**

```java
public void processGarden(ArrayList<Waterable> plants) {
    for (Waterable plant : plants) {
        plant.water();
    }
}
```

Avec cette approche, ajouter un nouveau type de plante ne nécessite aucune
modification de la méthode `processGarden()`. Il suffit que le nouveau type
implémente `Waterable`.

Cette flexibilité est particulièrement précieuse dans les grands projets où le
code doit évoluer au fil du temps. Le polymorphisme permet d'ajouter des
fonctionnalités sans risquer de casser le code existant.

## Conclusion

Le polymorphisme est un concept puissant qui transforme la façon dont nous
concevons et organisons notre code. En permettant à un même code de manipuler
des objets de types différents de manière uniforme, il améliore la flexibilité,
la réutilisabilité et la maintenabilité de nos programmes.

Les points clés à retenir :

1. **Le polymorphisme d'héritage** exploite les relations parent-enfant pour
   traiter des objets de sous-classes à travers des références de type parent.
   La liaison dynamique assure que la bonne méthode est appelée au moment de
   l'exécution.

2. **La redéfinition de méthodes** permet aux sous-classes d'adapter le
   comportement hérité à leurs besoins spécifiques. L'annotation `@Override`
   aide à éviter les erreurs et documente l'intention.

3. **Les interfaces** définissent des contrats de comportement indépendants de
   la hiérarchie d'héritage. Une classe peut implémenter plusieurs interfaces,
   ce qui permet de composer des capacités de manière flexible.

4. **Interfaces vs classes abstraites** : les interfaces définissent ce qu'un
   objet peut faire (capacités), tandis que les classes abstraites définissent
   ce qu'un objet est (nature) et partagent du code commun.

5. **Les méthodes de Object** (`toString()`, `equals()`, `hashCode()`) doivent
   être redéfinies pour améliorer le comportement de nos classes. Il est crucial
   de redéfinir `equals()` et `hashCode()` ensemble pour maintenir leur contrat.

6. **Le polymorphisme en pratique** permet d'écrire du code plus court, plus
   clair et plus extensible. Il encourage le principe ouvert/fermé : ouvert à
   l'extension, fermé à la modification.

Le polymorphisme n'est pas seulement un concept théorique. C'est un outil
pratique qui, combiné avec l'encapsulation et l'héritage, forme la base d'une
conception orientée objet solide et maintenable.

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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/06-programmation-orientee-objet-polymorphisme/quiz.html
[presentation-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/06-programmation-orientee-objet-polymorphisme/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/06-programmation-orientee-objet-polymorphisme/06-programmation-orientee-objet-polymorphisme-presentation.pdf
