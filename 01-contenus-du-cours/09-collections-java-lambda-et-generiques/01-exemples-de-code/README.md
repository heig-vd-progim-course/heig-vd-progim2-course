# Collections Java : Les génériques - Exemples de code

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
  - [Génériques](#génériques)
- [Navigation rapide](#navigation-rapide)
- [Points clés à retenir](#points-clés-à-retenir)
- [Comment travailler efficacement avec ces exemples](#comment-travailler-efficacement-avec-ces-exemples)
  - [Pour les exemples corrects (0\*)](#pour-les-exemples-corrects-0)
  - [Pour les contre-exemples (0\*-a-eviter)](#pour-les-contre-exemples-0-a-eviter)
- [Progression suggérée](#progression-suggérée)
- [En cas de difficulté](#en-cas-de-difficulté)
- [Pour aller plus loin](#pour-aller-plus-loin)

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
- **`0*-a-eviter-titre/`** : exemples de code **INCORRECTS** montrant les
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

Les exemples sont organisés par ordre de complexité croissante. Commencez par
les exemples numérotés `01`, `02`, etc., puis consultez les contre-exemples
`04-a-eviter`, `05-a-eviter`, etc. pour comprendre les erreurs à éviter.

### Génériques

#### [01-classe-generique](./01-classe-generique/)

**Objectif :** comprendre comment créer et utiliser une classe générique.

Cet exemple montre une classe `Box<T>` et une classe `Pair<K, V>` avec des
paramètres de type, l'inférence de type avec l'opérateur diamant `<>`, et
l'instanciation avec différents types concrets.

**Concepts illustrés :** `<T>`, `<K, V>`, opérateur diamant, sécurité des types.

---

#### [02-methode-generique](./02-methode-generique/)

**Objectif :** comprendre comment déclarer une méthode générique indépendante de
la classe.

Cet exemple montre des méthodes statiques génériques avec le paramètre de type
déclaré avant le type de retour, et l'inférence de type lors de l'appel.

**Concepts illustrés :** `<T>` au niveau méthode, inférence de type, méthode
statique générique.

---

#### [03-wildcards](./03-wildcards/)

**Objectif :** comprendre les wildcards et les bornes pour écrire du code
générique flexible.

Cet exemple montre les trois types de wildcards : non borné (`<?>`), borné
supérieur (`<? extends T>`) pour la lecture, et borné inférieur (`<? super T>`)
pour l'écriture.

**Concepts illustrés :** `<?>`, `<? extends T>`, `<? super T>`, PECS.

---

#### [04-a-eviter-type-brut](./04-a-eviter-type-brut/)

**Objectif :** comprendre pourquoi utiliser un type brut (sans paramètre de
type) est dangereux.

Ce contre-exemple montre qu'un `List` sans paramètre de type accepte n'importe
quel objet, ce qui provoque une `ClassCastException` à l'exécution.

**Concepts illustrés :** type brut, perte de la vérification de type,
`ClassCastException`.

---

#### [05-a-eviter-instanceof-avec-generiques](./05-a-eviter-instanceof-avec-generiques/)

**Objectif :** comprendre les limitations de `instanceof` avec les génériques à
cause de l'effacement de type.

Ce contre-exemple montre que `Box<String>` et `Box<Integer>` sont la même classe
à l'exécution, et qu'on ne peut pas tester le type paramétré avec `instanceof`.

**Concepts illustrés :** effacement de type (type erasure), limitations de
`instanceof`, `getClass()`.

## Navigation rapide

| #   | Exemple                                                 | Concept principal           |
| :-- | :------------------------------------------------------ | :-------------------------- |
| 01  | [classe générique](./01-classe-generique/)              | `Box<T>`, `Pair<K,V>`       |
| 02  | [méthode générique](./02-methode-generique/)            | `<T> T method()`            |
| 03  | [wildcards](./03-wildcards/)                            | `<?>`, `extends`, `super`   |
| 04  | [type brut](./04-a-eviter-type-brut/)                   | Erreur : `List` sans `<>`   |
| 05  | [instanceof](./05-a-eviter-instanceof-avec-generiques/) | Erreur : effacement de type |

## Points clés à retenir

- Une **classe générique** utilise un paramètre de type `<T>` pour fonctionner
  avec différents types.
- Une **méthode générique** déclare son paramètre de type avant le type de
  retour (`<T> T method()`).
- Les **wildcards** (`<? extends T>`, `<? super T>`) rendent les méthodes
  génériques plus flexibles.
- L'**effacement de type** supprime les paramètres de type à la compilation : on
  ne peut pas tester le type paramétré à l'exécution.

## Comment travailler efficacement avec ces exemples

### Pour les exemples corrects (0\*)

1. **Lire** le fichier README pour comprendre l'objectif.
2. **Étudier** le code source en lisant les commentaires.
3. **Prédire** la sortie avant d'exécuter.
4. **Exécuter** le code et comparer avec votre prédiction.
5. **Modifier** le code pour tester des variantes.

### Pour les contre-exemples (0\*-a-eviter)

1. **Identifier** le problème dans le code.
2. **Comprendre** pourquoi c'est problématique.
3. **Proposer** une correction avant de lire l'explication.
4. **Ne jamais reproduire** ces erreurs dans vos projets.

## Progression suggérée

1. Commencez par l'exemple 01 pour apprendre les classes génériques.
2. Continuez avec 02 pour les méthodes génériques.
3. Passez à l'exemple 03 pour comprendre les wildcards.
4. Terminez avec les contre-exemples 04 et 05 pour connaître les pièges.

## En cas de difficulté

- Relisez le [contenu de cours](../) correspondant.
- Exécutez le code pas à pas dans votre IDE.
- Ajoutez des `System.out.println` pour observer les valeurs intermédiaires.
- Discutez avec vos collègues ou demandez de l'aide au corps enseignant.

## Pour aller plus loin

- Documentation officielle Oracle :
  [Generics](https://docs.oracle.com/javase/tutorial/java/generics/index.html)

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
