---
marp: true
theme: "custom-marp-theme"
size: "16:9"
paginate: "true"
author: "V. Guidoux, avec l'aide de GitHub Copilot"
description:
  "Gestion des exceptions pour le cours ProgIM2 enseigné à la HEIG-VD, Suisse"
lang: "fr"
url: "https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/11-gestion-des-exceptions/presentation.html"
header: "[**Gestion des exceptions**][contenu-complet-sur-github]"
footer:
  "[**HEIG-VD**](https://heig-vd.ch) - [ProgIM2
  2025-2026](https://github.com/heig-vd-progim-course/heig-vd-progim2-course) -
  [CC BY-SA 4.0][licence]"
headingDivider: 6
---

# Gestion des exceptions

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

- Nommer les mots-clés Java : `try`, `catch`, `finally`, `throw`, `throws`.
- Expliquer ce qu'est une exception et son rôle dans un programme Java.
- Différencier les exceptions vérifiées (checked) des non vérifiées (unchecked).

![bg right:40%][illustration-objectifs]

## Objectifs (2/3)

- Utiliser `try-catch`, multi-catch et `finally` pour capturer des exceptions.
- Lancer une exception avec `throw`.
- Déclarer les exceptions propagées avec `throws`.

![bg right:40%][illustration-objectifs]

## Objectifs (3/3)

- Distinguer les situations où capturer d'avec celles où propager.
- Justifier la création d'une exception personnalisée.
- Concevoir et implémenter une classe d'exception.

![bg right:40%][illustration-objectifs]

## Un programme fragile

<!-- _class: lead -->

### Le contexte : un capteur d'eau

Un `WaterSensor` lit des valeurs de pH depuis l'extérieur.

![bg right:40% w:100%](./images/water-monitoring-system.svg)

### Un code qui plante

```java
String rawIndex = "deux"; // valeur reçue depuis l'extérieur

int index = Integer.parseInt(rawIndex); // Crash ici !
System.out.println("Index : " + index); // Jamais atteint
```

Résultat dans le terminal :

```
Exception in thread "main" java.lang.NumberFormatException: For input string: "deux"
    at java.base/java.lang.Integer.parseInt(Integer.java:668)
    at Main.main(Main.java:5)
```

Le programme s'arrête **brutalement** sans explication métier.

### Ce que Java fait

Quand quelque chose d'anormal se produit, Java :

1. **Crée** un objet représentant le problème : une exception.
2. **Lance** (_throw_) cet objet qui remonte la pile d'appels.
3. **Cherche** un bloc de gestion (_catch_) correspondant.
4. **Plante** si aucun bloc ne le capture.

Ce mécanisme garantit qu'aucune erreur ne passe **silencieusement inaperçue**.

## La hiérarchie des exceptions

<!-- _class: lead -->

### Throwable : la racine commune

![w:950](./images/exception-hierarchy.svg)

### Error et Exception

**`Error`** : erreurs graves de la JVM.

- `OutOfMemoryError`, `StackOverflowError`.
- Ne jamais tenter de les capturer.

**`Exception`** : situations anormales mais **prévisibles**.

- Un pH hors normes, un entier mal formaté, un fichier absent.
- Le programme peut et doit les gérer.

### Vérifiées et non vérifiées (1/2)

Les **exceptions vérifiées** (checked) héritent d'`Exception` :

- Le **compilateur** vérifie qu'elles sont gérées ou déclarées.
- Utilisées pour des situations prévisibles que l'appelant doit pouvoir traiter.
- Exemples : `IOException`, `SQLException`.

### Vérifiées et non vérifiées (2/2)

Les **exceptions non vérifiées** (unchecked) héritent de `RuntimeException` :

- Le **compilateur** ne les vérifie pas.
- Signalent des erreurs de programmation.
- Exemples : `NullPointerException`, `NumberFormatException`.

| Type       | Héritage           | Vérification |
| :--------- | :----------------- | :----------- |
| Vérifiée   | `Exception`        | Compilateur  |
| Non vérif. | `RuntimeException` | Aucune       |

## Capturer les exceptions

<!-- _class: lead -->

### Le bloc try-catch

```java
try {
    // Code susceptible de lancer une exception
    int index = Integer.parseInt(rawIndex);
    System.out.println("Index : " + index);
} catch (NumberFormatException e) {
    // Exécuté uniquement si l'exception est levée
    System.out.println(
        "Index invalide : '" + rawIndex + "'"
    );
}

System.out.println("Le programme continue."); // Toujours affiché
```

### Accéder à l'exception

L'objet `e` donne accès aux informations de l'exception :

```java
catch (NumberFormatException e) {
    // Message court décrivant l'exception
    System.out.println(e.getMessage());

    // Trace de pile complète dans la console
    e.printStackTrace();
}
```

`getMessage()` : message de l'exception. `printStackTrace()` : trace complète —
utile pendant le développement.

### Plusieurs blocs catch

```java
try {
    int index = Integer.parseInt(rawIndex);
    System.out.println("Label : " + labels[index]);
} catch (NumberFormatException e) {
    System.out.println("Format invalide : " + e.getMessage());
} catch (ArrayIndexOutOfBoundsException e) {
    System.out.println("Index hors limites : " + e.getMessage());
}
```

Les blocs `catch` sont parcourus **dans l'ordre**. Toujours placer les types les
**plus spécifiques en premier**.

### Ordre incorrect (ne compile pas)

```java
try {
    sensor.read();
} catch (Exception e) {           // Trop général : capture tout
    System.out.println("Erreur.");
} catch (NumberFormatException e) { // Jamais atteint !
    System.out.println("Format invalide.");
}
```

Le compilateur refuse ce code avec :

```
error: exception NumberFormatException has already been caught
```

### Le multi-catch

Pour traiter plusieurs exceptions **de la même façon**, on utilise `|` :

```java
try {
    int index = Integer.parseInt(rawIndex);
    System.out.println("Label : " + labels[index]);
} catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
    System.out.println("Données invalides : " + e.getMessage());
}
```

Utile quand le traitement est **identique** pour plusieurs types. Si le
traitement doit différer, utiliser des blocs `catch` séparés.

### Le bloc finally

```java
try {
    int index = Integer.parseInt(rawIndex);
    System.out.println("Index : " + index);
} catch (NumberFormatException e) {
    System.out.println("Format invalide.");
} finally {
    // Exécuté dans TOUS les cas : succès ou erreur
    System.out.println("Fin de lecture du capteur.");
}
```

Le bloc `finally` sert au **code de nettoyage** qui doit s'exécuter dans tous
les cas.

## Lancer des exceptions

<!-- _class: lead -->

### Le mot-clé throw

```java
public WaterSensor(String id, double ph) {
    if (ph < 0.0 || ph > 14.0) {
        throw new IllegalArgumentException(
            "Valeur de pH invalide : " + ph
            + " (attendu entre 0.0 et 14.0)"
        );
    }
    this.id = id;
    this.ph = ph;
}
```

`throw` est suivi d'une instance d'exception créée avec `new`. L'exécution de la
méthode **s'arrête immédiatement**.

### Déclarer avec throws

```java
public double readFromString(String raw) throws Exception {
    double value = Double.parseDouble(raw);
    if (value < 0.0 || value > 14.0) {
        throw new Exception(
            "Valeur hors plage : " + value
        );
    }
    return value;
}
```

`throws` dans la signature déclare que la méthode peut lancer une exception
**vérifiée**. Le compilateur oblige l'appelant à la gérer.

### throw vs throws

| Mot-clé  | Où ?                    | Rôle                                       |
| :------- | :---------------------- | :----------------------------------------- |
| `throw`  | Corps de la méthode     | Lance une instance d'exception.            |
| `throws` | Signature de la méthode | Déclare qu'une exception peut être lancée. |

### Capturer ou propager ? (1/2)

**On capture** quand :

- On peut faire quelque chose d'**utile** (récupérer la situation, afficher un
  message adapté, retourner une valeur par défaut).
- On est dans la couche qui a le **contexte** pour comprendre l'erreur.

### Capturer ou propager ? (2/2)

**On propage** quand :

- On ne sait **pas quoi faire** avec l'exception à ce niveau.
- L'**appelant** a plus de contexte pour décider comment réagir.

**Ne jamais laisser un `catch` vide** : cela cache les erreurs et rend le
débogage extrêmement difficile.

## Créer ses propres exceptions

<!-- _class: lead -->

### Pourquoi des exceptions personnalisées ?

`IllegalArgumentException` ou `Exception` sont génériques.

Un `catch (Exception e)` ne dit pas : _"ici, je gère un problème de pH de
capteur"_.

Les exceptions personnalisées permettent de :

- Exprimer les erreurs dans le **vocabulaire du domaine**.
- Rendre les blocs `catch` **plus intentionnels**.
- Transporter des **informations métier** précises.

### La hiérarchie personnalisée

![Hiérarchie des exceptions personnalisées](./images/custom-exceptions.svg)

### InvalidPhException (1/2)

```java
class InvalidPhException extends Exception {

    public InvalidPhException(String sensorId, double value) {
        super(
            "Valeur de pH hors plage pour le capteur "
            + sensorId + " : " + value
            + " (attendu entre 0.0 et 14.0)"
        );
    }
}
```

Hérite d'`Exception` : **exception vérifiée**. Le compilateur oblige à la gérer
à l'appel.

### InvalidPhException (2/2)

```java
class InvalidPhException extends Exception {

    // Avec cause : pour le chaînage d'exceptions
    public InvalidPhException(
            String sensorId, double value, Throwable cause) {
        super(
            "Valeur de pH hors plage pour le capteur "
            + sensorId + " : " + value
            + " (attendu entre 0.0 et 14.0)",
            cause
        );
    }
}
// Le **chaînage** préserve la cause originale pour le diagnostic.
```

### Utiliser l'exception (1/2)

```java
public WaterSensor(String id, double ph)
        throws InvalidPhException {
    if (ph < 0.0 || ph > 14.0) {
        throw new InvalidPhException(id, ph);
    }
    this.id = id;
    this.ph = ph;
}
```

### Utiliser l'exception (2/2)

Le `catch` est maintenant **expressif** :

```java
} catch (InvalidPhException e) {
    System.out.println("ALERTE pH : " + e.getMessage());
}
```

## Le système robuste

<!-- _class: lead -->

### Avant / Après

**Avant** : le programme plante à la première erreur.

```
Exception in thread "main" java.lang.NumberFormatException
```

**Après** : chaque erreur est identifiée, le traitement continue.

```
Lecture OK : pH = 7.2
ALERTE : Valeur de pH hors plage pour le capteur PH-01 : 15.0 ...
ALERTE : Valeur de pH hors plage pour le capteur PH-01 : NaN ...
Lecture OK : pH = 8.1
```

### Bonnes pratiques (1/2)

- Ne **jamais laisser un `catch` vide** : cela cache les erreurs.
- Capturer le type **le plus précis** possible — éviter `catch (Exception e)`
  sauf au plus haut niveau.
- Ne pas utiliser les exceptions pour le **flux normal** de contrôle : elles
  sont pour les situations anormales, pas pour remplacer un `if`.

### Bonnes pratiques (2/2)

- Préférer les **exceptions personnalisées** pour le code métier.
- Toujours inclure la **cause originale** lors du chaînage, pour ne pas perdre
  d'information lors du diagnostic.
- Documenter les exceptions avec `@throws` dans la **Javadoc**.

## Questions

<!-- _class: lead -->

Est-ce que vous avez des questions ?

## À vous de jouer !

- (Re)lire le contenu de cours, lire les exemples de code et les descriptions,
  faire les exercices, faire le mini-projet et poser des questions si
  nécessaire.

➡️ [Visualiser le contenu complet sur GitHub.][contenu-complet-sur-github]

**N'hésitez pas à vous entraider si vous avez des difficultés !**

![bg right:30%][illustration-a-vous-de-jouer]

## Sources

- [Illustration principale][illustration-principale] par
  [Claudio Schwarz](https://unsplash.com/@purzlbaum) sur
  [Unsplash](https://unsplash.com/photos/a-close-up-of-a-faucet-with-water-running-out-of-it-fyeOxvYvIyY)
- [Illustration][illustration-objectifs] par
  [Aline de Nadai](https://unsplash.com/@alinedenadai) sur
  [Unsplash](https://unsplash.com/photos/low-angle-view-of-ball-shoots-in-the-ring-j6brni7fpvs)
- [Illustration][illustration-a-vous-de-jouer] par
  [Nikita Kachanovsky](https://unsplash.com/@nkachanovskyyy) sur
  [Unsplash](https://unsplash.com/photos/white-sony-ps4-dualshock-controller-over-persons-palm-FJFPuE1MAOM)

<!-- URLs -->

[contenu-complet-sur-github]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/tree/main/01-contenus-du-cours/11-gestion-des-exceptions/
[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md

<!-- Illustrations -->

[illustration-principale]:
	https://images.unsplash.com/photo-1558618666-fcd25c85cd64?fit=crop&h=720
[illustration-objectifs]:
	https://images.unsplash.com/photo-1516389573391-5620a0263801?fit=crop&h=720
[illustration-a-vous-de-jouer]:
	https://images.unsplash.com/photo-1509198397868-475647b2a1e5?fit=crop&h=720
