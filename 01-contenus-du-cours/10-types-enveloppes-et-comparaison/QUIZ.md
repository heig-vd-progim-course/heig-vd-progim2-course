---
marp: true
theme: custom-marp-theme
size: 16:9
paginate: true
author: V. Guidoux, avec l'aide de GitHub Copilot
description:
  "Quiz sur le contenu Types enveloppes et comparaison d'objets pour le cours
  ProgIM2 enseigné à la HEIG-VD, Suisse"
url: https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/10-types-enveloppes-et-comparaison/quiz.html
header:
  "[**Types enveloppes et comparaison d'objets -
  Quiz**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Types enveloppes et comparaison d'objets - Quiz

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

Associez chaque type primitif à sa classe enveloppe :

| Type primitif | Classe enveloppe |
| :------------ | :--------------- |
| `int`         | ?                |
| `double`      | ?                |
| `boolean`     | ?                |
| `char`        | ?                |

## Question 1 - Réponse

**Réponse correcte :** `Integer`, `Double`, `Boolean`, `Character`

| Type primitif | Classe enveloppe |
| :------------ | :--------------- |
| `int`         | `Integer`        |
| `double`      | `Double`         |
| `boolean`     | `Boolean`        |
| `char`        | `Character`      |

Seuls `Integer` et `Character` ont des noms différents du type primitif. Tous
les autres suivent le pattern `PremièreLettreMajuscule`.

## Question 2 - Donnée

Pour chaque ligne, indiquez si Java effectue un **autoboxing**, un **unboxing**,
ou **ni l'un ni l'autre** :

```java
Integer a = 42;                    // Ligne A
int b = Integer.valueOf(10);       // Ligne B
Integer c = Integer.valueOf(5);    // Ligne C
int d = c;                         // Ligne D
```

## Question 2 - Réponse

```java
Integer a = 42;                    // A : autoboxing (int → Integer)
int b = Integer.valueOf(10);       // B : unboxing  (Integer → int)
Integer c = Integer.valueOf(5);    // C : aucun (valueOf() crée déjà un Integer)
int d = c;                         // D : unboxing  (Integer → int)
```

- **A** : Java appelle `Integer.valueOf(42)` implicitement.
- **B** : `valueOf()` retourne un `Integer`, assigné à `int` → Java appelle
  `.intValue()` implicitement.
- **C** : `valueOf()` retourne un `Integer`, assigné à `Integer` → aucune
  conversion.
- **D** : Java appelle `c.intValue()` implicitement.

## Question 3 - Donnée

Quelle est la sortie de ce programme ?

```java
Integer a = 100;
Integer b = 100;
Integer x = 200;
Integer y = 200;

System.out.println(a == b);
System.out.println(x == y);
System.out.println(a.equals(b));
System.out.println(x.equals(y));
```

## Question 3 - Réponse

```text
true
false
true
true
```

La JVM met en cache les `Integer` entre **-128 et 127**. `a` et `b` pointent
vers le même objet (dans le cache) → `==` retourne `true`. `x` et `y` valent 200
(hors du cache) → deux objets distincts → `==` retourne `false`. `equals()`
compare toujours les **valeurs**, quel que soit le cache → `true` dans les deux
cas.

## Question 4 - Donnée

Ces deux versions du code sont-elles équivalentes ?

<div class="two-columns">
<div>

**Version A**

```java
Integer year = 2010;
```

</div>
<div>

**Version B**

```java
Integer year = Integer.valueOf(2010);
```

</div>
</div>

## Question 4 - Réponse

**Oui, elles produisent exactement le même résultat.**

L'autoboxing (version A) est du sucre syntaxique : le compilateur génère
exactement l'appel `Integer.valueOf(2010)` (version B).

La version B n'est pas obsolète : elle reste valide et explicite ce que
l'autoboxing fait en coulisses.

`new Integer(2010)` (ancienne API) est, elle, dépréciée depuis Java 9.

## Question 5 - Donnée

Que se passe-t-il à l'exécution de ce code ?

```java
ArrayList<Integer> durations = new ArrayList<>();
durations.add(148);
durations.add(null);
durations.add(97);

for (int d : durations) {
    System.out.println(d);
}
```

## Question 5 - Réponse

**`NullPointerException` à l'exécution.**

La boucle `for (int d : durations)` tente d'unboxer chaque `Integer` en `int`.
Sur la valeur `null`, Java appelle `null.intValue()` → `NullPointerException`
Pour éviter ce problème :

```java
for (Integer d : durations) {  // pas de unboxing immédiat
    if (d != null) {
        System.out.println(d);
    }
}
```

## Question 6 - Donnée

Comparez ces deux implémentations de `equals()` pour une classe `Movie` (champs
`title` et `year`) :

<div class="two-columns">
<div>

**Version A**

```java
@Override
public boolean equals(Object obj) {
    Movie other = (Movie) obj;
    return title.equals(other.title)
        && year.equals(other.year);
}
```

</div>
<div>

**Version B**

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null
            || getClass() != obj.getClass())
        return false;
    Movie other = (Movie) obj;
    return title.equals(other.title)
        && year.equals(other.year);
}
```

</div>
</div>

Laquelle est correcte ? Pourquoi ?

## Question 6 - Réponse

**La version B est correcte.**

La version A a deux défauts :

- Si `obj` est `null` → le cast `(Movie) obj` provoque une
  `NullPointerException`.
- Si `obj` n'est pas un `Movie` → le cast provoque une `ClassCastException`.

## Question 7 - Donnée

`equals()` est redéfini dans `Movie` (mêmes titre et année = même film), mais
`hashCode()` **ne l'est pas**. Quelle est la sortie ?

```java
HashSet<Movie> favorites = new HashSet<>();
favorites.add(new Movie("Inception", 2010, 148, 9.0));

Movie search = new Movie("Inception", 2010, 148, 9.0);
System.out.println(search.equals(favorites.iterator().next()));
System.out.println(favorites.contains(search));
```

## Question 7 - Réponse

```text
true
false
```

`search.equals(...)` retourne `true` : `equals()` est bien redéfini et compare
titre + année.

`favorites.contains(search)` retourne `false` : `HashSet` utilise `hashCode()`
pour trouver la bonne case. Sans redéfinition, `hashCode()` est basé sur la
référence → les deux objets ont des `hashCode` différents → `HashSet` ne les
considère pas dans la même case.

**Toujours redéfinir `equals()` et `hashCode()` ensemble.**

## Question 8 - Donnée

Quelle est la sortie de ce programme ?

```java
ArrayList<Movie> movies = new ArrayList<>();
movies.add(new Movie("Tenet", 2020, 150, 7.4));
movies.add(new Movie("Inception", 2010, 148, 9.0));
movies.add(new Movie("Interstellar", 2014, 169, 8.6));

Collections.sort(movies);  // Movie implements Comparable<Movie>
                            // compareTo : Double.compare(other.rating, this.rating)
for (Movie m : movies) {
    System.out.println(m.getTitle() + " : " + m.getRating());
}
```

## Question 8 - Réponse

```text
Inception : 9.0
Interstellar : 8.6
Tenet : 7.4
```

`Double.compare(other.rating, this.rating)` produit un tri **décroissant** :
Inception (9.0) > Interstellar (8.6) > Tenet (7.4).

Si on avait écrit `Double.compare(this.rating, other.rating)`, le tri aurait été
**croissant** : Tenet, Interstellar, Inception.

## Question 9 - Donnée

Comparez ces deux `compareTo()` pour trier des films :

<div class="two-columns">
<div>

**Version A : ordre croissant**

```java
@Override
public int compareTo(Movie other) {
    return Double.compare(
        this.rating, other.rating);
}
```

</div>
<div>

**Version B : ordre décroissant**

```java
@Override
public int compareTo(Movie other) {
    return Double.compare(
        other.rating, this.rating);
}
```

</div>
</div>

Avec la liste : `Tenet (7.4)`, `Inception (9.0)`, `Interstellar (8.6)`, après
`Collections.sort()`, quel est l'ordre dans **chaque version** ?

## Question 9 - Réponse

**Version A (croissant) :** Tenet (7.4), Interstellar (8.6), Inception (9.0).

**Version B (décroissant) :** Inception (9.0), Interstellar (8.6), Tenet (7.4).

`Double.compare(a, b)` retourne :

- Négatif si `a < b` → `a` est placé avant `b`.
- Positif si `a > b` → `a` est placé après `b`.

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions sur le quiz ou le contenu ?

## Sources

- [Illustration principale][illustration-principale] par
  [Noom Peerapong](https://unsplash.com/@imnoom) sur
  [Unsplash](https://unsplash.com/photos/white-and-black-remote-control-2dlzDMFHaGk)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/10-types-enveloppes-et-comparaison/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1489599849927-2ee91cede3ba?fit=crop&h=720
