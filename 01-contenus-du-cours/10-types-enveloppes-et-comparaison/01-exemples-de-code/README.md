# Types enveloppes et comparaison d'objets - Exemples de code

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence [CC BY-SA 4.0][licence].

> [!TIP]
>
> Toutes les informations relatives à ce contenu sont décrites dans le
> [contenu principal](../).

## Table des matières

- [Table des matières](#table-des-matières)
- [Introduction](#introduction)
- [Structure des exemples](#structure-des-exemples)
- [Exemples](#exemples)
  - [Types enveloppes et autoboxing](#types-enveloppes-et-autoboxing)
  - [Méthodes utilitaires](#méthodes-utilitaires)
  - [equals() et hashCode()](#equals-et-hashcode)
  - [Comparable et tri](#comparable-et-tri)
  - [Erreurs courantes](#erreurs-courantes)
- [Progression suggérée](#progression-suggérée)

## Introduction

Ce dossier contient des exemples de code en lien avec les éléments vus en cours.

Ces exemples ont trois buts bien précis :

1. Vous familiariser à la lecture de code et sa compréhension de façon autonome.
2. Servir de base pour les exercices et les projets à réaliser.
3. Illustrer les bonnes pratiques et les erreurs courantes à éviter.

Ces exemples sont construits selon le principe des **exemples travaillés**
(_worked examples_) pour faciliter l'apprentissage :

- Le code est complet et exécutable.
- Les commentaires expliquent chaque étape importante.
- La sortie attendue est clairement indiquée.
- Les erreurs courantes sont identifiées et expliquées.

Ces exemples sont triés par ordre de complexité croissante. Nous vous
conseillons de les explorer dans l'ordre et de prendre le temps de les exécuter
sur votre machine et de les comprendre en profondeur **sans recourir à de l'aide
externe (particulièrement les outils IA)**.

> [!NOTE]
>
> Il est recommandé d'étudier attentivement chaque exemple avant de passer aux
> exercices. Essayez de comprendre le raisonnement derrière chaque ligne de code
> plutôt que de simplement copier-coller.

Si vous avez des questions ou des problèmes à les comprendre, n'hésitez pas à
demander de l'aide envers vos collègues ou au corps enseignant.

## Structure des exemples

Les exemples de code sont organisés selon une numérotation claire :

- **`0*-titre/`** : exemples de code **corrects** illustrant les bonnes
  pratiques, du plus simple au plus complexe. Ces fichiers peuvent être utilisés
  comme référence et adaptés pour vos projets.
- **`1*-a-eviter-titre/`** : exemples de code **INCORRECTS** montrant les
  erreurs fréquentes, avec des commentaires expliquant le problème. **Ces
  fichiers sont uniquement à des fins pédagogiques et ne doivent jamais être
  copiés.**

> [!IMPORTANT]
>
> - Tous les dossiers commençant par `0*` sans mention "a-eviter" contiennent du
>   code **correct** et suivent les bonnes pratiques.
> - Tous les dossiers contenant `a-eviter` contiennent du code **volontairement
>   incorrect** pour illustrer des erreurs à éviter.

## Exemples

Les exemples sont organisés par ordre de complexité croissante.

### Types enveloppes et autoboxing

#### [01-types-enveloppes](./01-types-enveloppes/)

**Objectif :** comprendre les classes enveloppes et le mécanisme d'autoboxing et
d'unboxing.

Cet exemple montre la création explicite d'objets enveloppes avec `valueOf()`,
l'autoboxing et l'unboxing automatiques, et l'utilisation des enveloppes dans
les collections.

**Concepts illustrés :** `Integer.valueOf()`, `intValue()`, autoboxing,
unboxing, `ArrayList<Integer>`.

---

### Méthodes utilitaires

#### [02-methodes-utilitaires](./02-methodes-utilitaires/)

**Objectif :** utiliser les méthodes utilitaires des classes enveloppes.

Cet exemple montre `Integer.parseInt()`, `Double.parseDouble()`,
`Integer.MAX_VALUE`, `Integer.MIN_VALUE`, et les méthodes de `Character`.

**Concepts illustrés :** `parseInt()`, `parseDouble()`, `MAX_VALUE`,
`MIN_VALUE`, `Character.isLetter()`, `Character.isDigit()`.

---

### equals() et hashCode()

#### [03-equals-hashcode](./03-equals-hashcode/)

**Objectif :** comprendre la différence entre `==` et `equals()`, et implémenter
`equals()` et `hashCode()` correctement.

Cet exemple montre une classe `Movie` complète avec `equals()` et `hashCode()`
redéfinis, et illustre le comportement d'un `HashSet` avec et sans ces méthodes.

**Concepts illustrés :** `==` vs `equals()`, `@Override`, contrat
`equals`/`hashCode`, `HashSet`.

---

### Comparable et tri

#### [04-comparable](./04-comparable/)

**Objectif :** implémenter `Comparable<T>` et trier une liste avec
`Collections.sort()`.

Cet exemple montre une classe `Movie` qui implémente `Comparable<Movie>` pour un
tri par note décroissante, et illustre le tri avec `Collections.sort()` et
`list.sort(null)`.

**Concepts illustrés :** `Comparable<T>`, `compareTo()`, `Collections.sort()`,
`Double.compare()`.

---

### Erreurs courantes

#### [11-a-eviter-comparaison-entiers](./11-a-eviter-comparaison-entiers/)

**Objectif :** comprendre le piège de la comparaison d'`Integer` avec `==`.

Cet exemple montre le comportement imprévisible de `==` sur des objets
`Integer`, lié au cache JVM pour les valeurs entre -128 et 127.

**Concepts illustrés :** cache `Integer`, `==` vs `equals()`, comportement
indéfini.

---

#### [12-a-eviter-null-unboxing](./12-a-eviter-null-unboxing/)

**Objectif :** comprendre et éviter la `NullPointerException` lors de l'unboxing
d'une valeur `null`.

Cet exemple montre les cas fréquents de `NullPointerException` causés par
l'unboxing, et la façon correcte de s'en prémunir.

**Concepts illustrés :** `NullPointerException`, unboxing, vérification `null`.

---

## Progression suggérée

Pour tirer le meilleur parti de ces exemples :

1. Lire le code sans l'exécuter et prédire la sortie.
2. Exécuter le code et comparer avec votre prédiction.
3. Modifier le code pour explorer des variantes.
4. Lire ensuite les contre-exemples (`11-a-eviter-*`, `12-a-eviter-*`) pour
   comprendre les pièges.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
