# Collections Java : Listes, sets et maps - Exemples de code

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
  - [Les listes](#les-listes)
  - [Les ensembles](#les-ensembles)
  - [Les maps](#les-maps)
  - [Parcours et itération](#parcours-et-itération)
  - [Choisir la bonne collection](#choisir-la-bonne-collection)
- [Navigation rapide](#navigation-rapide)
- [Points clés à retenir](#points-clés-à-retenir)
- [Comment travailler efficacement avec ces exemples](#comment-travailler-efficacement-avec-ces-exemples)
  - [Pour les exemples corrects (0\*)](#pour-les-exemples-corrects-0)
  - [Pour les contre-exemples (1\*-a-eviter)](#pour-les-contre-exemples-1-a-eviter)
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
- **`1*-a-eviter-titre/`** : exemples de code **INCORRECTS** montrant les
  erreurs fréquentes, avec des commentaires expliquant le problème. **Ces
  fichiers sont uniquement à des fins pédagogiques et ne doivent jamais être
  copiés.**

> [!IMPORTANT]
>
> - Tous les dossiers commençant par `0*` contiennent du code **correct** et
>   suivent les bonnes pratiques.
> - Tous les dossiers commençant par `1*-a-eviter` contiennent du code
>   **volontairement incorrect** pour illustrer des erreurs à éviter.

## Exemples

Les exemples sont organisés par ordre de complexité croissante. Commencez par
les exemples numérotés `01`, `02`, etc., puis consultez les contre-exemples
`11-a-eviter`, `12-a-eviter`, etc. pour comprendre les erreurs à éviter.

### Les listes

#### [01-arraylist-base](./01-arraylist-base/)

**Objectif :** comprendre le fonctionnement d'une `ArrayList` et ses opérations
courantes.

Cet exemple montre comment créer une liste avec `ArrayList`, ajouter et
supprimer des éléments, accéder par index et vérifier la présence d'un élément.
Utilise le contexte d'un jardin communautaire.

**Concepts illustrés :** `ArrayList`, `List`, `add()`, `remove()`, `get()`,
`contains()`, `size()`.

---

#### [02-linkedlist](./02-linkedlist/)

**Objectif :** comprendre les différences entre `ArrayList` et `LinkedList`.

Cet exemple montre l'utilisation de `LinkedList` avec la même interface `List`.
Il illustre que le code appelant est identique quelle que soit l'implémentation.

**Concepts illustrés :** `LinkedList`, polymorphisme d'implémentation, ajout et
suppression au début et à la fin.

---

### Les ensembles

#### [03-hashset-unicite](./03-hashset-unicite/)

**Objectif :** comprendre comment `HashSet` garantit l'unicité des éléments.

Cet exemple montre le comportement d'un `HashSet` avec l'ajout de doublons, la
vérification de présence et la conversion d'une liste en ensemble.

**Concepts illustrés :** `HashSet`, `Set`, unicité, `add()` retournant
`true`/`false`, conversion liste vers ensemble.

---

#### [04-treeset-tri](./04-treeset-tri/)

**Objectif :** comprendre le tri automatique offert par `TreeSet`.

Cet exemple montre comment `TreeSet` maintient ses éléments triés et compare
l'affichage avec un `HashSet`.

**Concepts illustrés :** `TreeSet`, tri automatique, `Comparable`.

---

### Les maps

#### [05-hashmap-cle-valeur](./05-hashmap-cle-valeur/)

**Objectif :** comprendre le fonctionnement d'une `HashMap` pour les
associations clé-valeur.

Cet exemple montre comment associer des clés à des valeurs, accéder à une valeur
par sa clé, remplacer une valeur existante et parcourir les clés et les valeurs.

**Concepts illustrés :** `HashMap`, `Map`, `put()`, `get()`, `containsKey()`,
`keySet()`, `values()`.

---

#### [06-treemap-tri-par-cle](./06-treemap-tri-par-cle/)

**Objectif :** comprendre le tri automatique des clés offert par `TreeMap`.

Cet exemple montre comment `TreeMap` maintient ses entrées triées par clé et
compare l'affichage avec un `HashMap`.

**Concepts illustrés :** `TreeMap`, tri par clé, `Comparable`.

---

### Parcours et itération

#### [07-parcours-for-each](./07-parcours-for-each/)

**Objectif :** maîtriser le parcours de collections avec la boucle `for-each`.

Cet exemple montre comment parcourir une liste, un ensemble et une map avec la
boucle `for-each`, y compris l'utilisation de `entrySet()`.

**Concepts illustrés :** boucle `for-each`, `entrySet()`, `getKey()`,
`getValue()`.

---

#### [08-iterateur-suppression](./08-iterateur-suppression/)

**Objectif :** comprendre l'utilisation d'un itérateur pour modifier une
collection pendant le parcours.

Cet exemple montre comment utiliser un `Iterator` pour parcourir une collection
et supprimer des éléments de manière sécurisée avec `it.remove()`.

**Concepts illustrés :** `Iterator`, `hasNext()`, `next()`, `it.remove()`,
suppression sécurisée.

---

### Choisir la bonne collection

#### [09-choisir-collection](./09-choisir-collection/)

**Objectif :** illustrer le choix de la bonne collection selon le besoin.

Cet exemple complet montre un jardin communautaire utilisant simultanément une
`ArrayList`, un `HashSet` et une `HashMap` pour différents besoins.

**Concepts illustrés :** combinaison de collections, choix selon le contexte,
programmation vers l'interface.

---

#### [11-a-eviter-modification-pendant-iteration](./11-a-eviter-modification-pendant-iteration/)

**À éviter :** modifier une collection avec `collection.remove()` pendant une
boucle `for-each`.

Cet exemple montre l'erreur classique qui provoque une
`ConcurrentModificationException` et explique comment la corriger.

**Concepts concernés :** `ConcurrentModificationException`, boucle `for-each`,
modification concurrente.

---

#### [12-a-eviter-type-brut](./12-a-eviter-type-brut/)

**À éviter :** utiliser des types bruts (raw types) au lieu des types
génériques.

Cet exemple montre les problèmes causés par l'utilisation de collections sans
type paramétré (`ArrayList` au lieu de `ArrayList<String>`).

**Concepts concernés :** types bruts, types génériques, sûreté de typage.

---

## Navigation rapide

**Bonnes pratiques (0\*):**

- [01-arraylist-base](./01-arraylist-base/)
- [02-linkedlist](./02-linkedlist/)
- [03-hashset-unicite](./03-hashset-unicite/)
- [04-treeset-tri](./04-treeset-tri/)
- [05-hashmap-cle-valeur](./05-hashmap-cle-valeur/)
- [06-treemap-tri-par-cle](./06-treemap-tri-par-cle/)
- [07-parcours-for-each](./07-parcours-for-each/)
- [08-iterateur-suppression](./08-iterateur-suppression/)
- [09-choisir-collection](./09-choisir-collection/)

**À éviter (1\*):**

- [11-a-eviter-modification-pendant-iteration](./11-a-eviter-modification-pendant-iteration/)
- [12-a-eviter-type-brut](./12-a-eviter-type-brut/)

## Points clés à retenir

- Toujours déclarer les variables avec le type de l'interface (`List`, `Set`,
  `Map`) et non l'implémentation (`ArrayList`, `HashSet`, `HashMap`).
- Utiliser `it.remove()` (et jamais `collection.remove()`) pour supprimer
  pendant une itération.
- Toujours spécifier le type générique (ex : `List<String>`) pour éviter les
  erreurs à l'exécution.
- Choisir la collection en fonction du besoin : ordre, unicité ou association
  clé-valeur.

## Comment travailler efficacement avec ces exemples

### Pour les exemples corrects (0\*)

1. **Lisez** d'abord le README.md du dossier pour comprendre l'objectif.
2. **Étudiez** le code en suivant les commentaires ligne par ligne.
3. **Exécutez** le programme et comparez avec la sortie attendue.
4. **Expérimentez** en modifiant le code pour tester votre compréhension.
5. **Utilisez** ces exemples comme base pour les exercices.

### Pour les contre-exemples (1\*-a-eviter)

1. **Lisez** d'abord le README.md pour comprendre quelle erreur est illustrée.
2. **Essayez de prédire** quel sera le problème avant d'exécuter le code.
3. **Exécutez** le code incorrect pour observer l'erreur.
4. **Analysez** les messages d'erreur ou le comportement inattendu.
5. **Comprenez** pourquoi l'erreur se produit grâce aux commentaires.
6. **Consultez** l'exemple correct correspondant pour voir la bonne approche.

> [!TIP]
>
> Le meilleur moyen d'apprendre est de :
>
> 1. Comprendre **pourquoi** le code fonctionne (exemples 0\*).
> 2. Comprendre **pourquoi** le code ne fonctionne pas (exemples 1\*).
> 3. **Pratiquer** en écrivant votre propre code sans copier-coller.

## Progression suggérée

1. Commencez par `01-arraylist-base` pour les fondamentaux des listes.
2. Progressez vers `02-linkedlist` pour comparer les implémentations.
3. Explorez les ensembles avec `03-hashset-unicite` et `04-treeset-tri`.
4. Passez aux maps avec `05-hashmap-cle-valeur` et `06-treemap-tri-par-cle`.
5. Maîtrisez le parcours avec `07-parcours-for-each` et
   `08-iterateur-suppression`.
6. Terminez par `09-choisir-collection` qui combine tous les concepts.
7. Consultez les contre-exemples `11` et `12` pour comprendre les erreurs
   courantes.

## En cas de difficulté

Si vous rencontrez des difficultés avec un exemple :

1. **Relisez** les commentaires dans le code attentivement.
2. **Consultez** le contenu du cours principal pour revoir le concept.
3. **Comparez** avec d'autres exemples similaires.
4. **Demandez de l'aide** à vos collègues ou au corps enseignant.
5. **Évitez** de recourir immédiatement à des outils IA - c'est en réfléchissant
   par vous-même que vous apprendrez le mieux.

---

## Pour aller plus loin

> [!TIP]
>
> Une fois ces exemples maîtrisés, vous pouvez :
>
> - Modifier les exemples pour tester votre compréhension.
> - Combiner plusieurs concepts vus dans différents exemples.
> - Créer vos propres exemples en vous inspirant de la structure.
> - Passer aux [exercices](../02-exercices/) pour mettre en pratique.

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
