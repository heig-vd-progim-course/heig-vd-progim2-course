# {COURSE_CONTENT} - Exemples de code

{AUTHOR}.

Ce travail est sous licence [{LICENSE_NAME}][licence].

> [!TIP]
>
> Toutes les informations relatives à ce contenu sont décrites dans le
> [contenu principal](../README.md).

## Table des matières

- [Table des matières](#table-des-matières)
- [Introduction](#introduction)
- [Exemples](#exemples)
  - [{LEARNING_TOPIC}](#learning_topic)

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

Les exemples de code sont organisés dans deux dossiers :

- `01-exemples/` : exemples de code corrects illustrant les bonnes pratiques.
  Ces fichiers peuvent être utilisés comme référence et adaptés pour vos
  projets.
- `02-erreurs-courantes/` : exemples de code **INCORRECT** montrant les erreurs
  fréquentes, avec des commentaires expliquant le problème. **Ces fichiers sont
  uniquement à des fins pédagogiques et ne doivent jamais être copiés.**

> [!IMPORTANT]
>
> Tous les fichiers dans `01-exemples/` sont corrects et suivent les bonnes
> pratiques. Tous les fichiers dans `02-erreurs-courantes/` sont volontairement
> incorrects pour illustrer des erreurs à éviter.

## Exemples

### {LEARNING_TOPIC}

#### Exemple 1 - Cas simple et fondamental

**Fichier :** `01-exemples/Example1Basic.java`

Description de l'exemple 1 et du concept qu'il illustre.

**Objectif pédagogique :** comprendre [concept de base].

```java
// Exemple de code complet et commenté
public class ExampleBasic {
    public static void main(String[] args) {
        // Étape 1 : explication de cette partie
        int value = 42;

        // Étape 2 : explication de cette partie
        System.out.println("La valeur est : " + value);
    }
}
```

**Sortie attendue :**

```
La valeur est : 42
```

**Points clés à retenir :**

- Point clé 1.
- Point clé 2.
- Point clé 3.

---

#### Exemple 2 - Application pratique

**Fichier :** `01-exemples/Example2Practical.java`

Description de l'exemple 2 avec un contexte d'utilisation réaliste.

**Objectif pédagogique :** appliquer [concept] dans un contexte pratique.

```java
// Exemple plus élaboré avec plusieurs concepts
public class Example2Practical {
    // Code complet et bien commenté
}
```

**Sortie attendue :**

```
[Sortie du programme]
```

**Explication détaillée :**

1. Première étape du raisonnement.
2. Deuxième étape du raisonnement.
3. Résultat obtenu et pourquoi.

---

#### Exemple 3 - Comparaison d'approches

**Fichiers :** `01-exemples/ApproachA.java` et `ApproachB.java`

Comparaison entre différentes façons d'implémenter la même fonctionnalité.

**Objectif pédagogique :** évaluer différentes approches et choisir la plus
appropriée.

**Approche A - [Nom de l'approche] :**

```java
// Première approche
```

**Avantages :**

- Avantage 1.
- Avantage 2.

**Inconvénients :**

- Inconvénient 1.
- Inconvénient 2.

**Approche B - [Nom de l'approche] :**

```java
// Seconde approche
```

**Avantages :**

- Avantage 1.
- Avantage 2.

**Inconvénients :**

- Inconvénient 1.
- Inconvénient 2.

**Recommandation :** utiliser l'approche A quand [contexte], et l'approche B
quand [autre contexte].

---

## Erreurs courantes

> [!WARNING]
>
> Le dossier `02-erreurs-courantes/` contient du code **VOLONTAIREMENT
> INCORRECT** à des fins pédagogiques uniquement.
>
> **Ne copiez jamais ces fichiers dans vos projets !**
>
> Chaque fichier commence par le préfixe `ERROR-` et contient des commentaires
> détaillés expliquant pourquoi le code est incorrect et comment le corriger.

### Erreur courante 1 - [Nom de l'erreur]

**Fichier :** `02-erreurs-courantes/ERROR-[NomErreur].java`

Description de l'erreur courante et pourquoi elle se produit.

**Objectif pédagogique :** identifier et comprendre [erreur commune].

**Contenu du fichier :**

Le fichier contient du code incorrect avec des commentaires détaillés expliquant
:

- Quelle est l'erreur.
- Pourquoi elle se produit.
- Quel message d'erreur ou comportement inattendu cela génère.
- Comment la corriger (explication, pas code corrigé).
- Où trouver des exemples corrects dans `01-exemples/`.

**Exemple de structure du fichier :**

```java
// ⚠️ ERREUR COURANTE : [Nom de l'erreur]
// Ce code est INCORRECT et sert uniquement à illustrer une erreur fréquente.
// NE PAS COPIER CE CODE DANS VOS PROJETS.
//
// Problème : [description du problème]
// Résultat : [ce qui se passe quand on exécute]
//
// Pour corriger : [explication de la correction]
// Voir : 01-exemples/[FichierCorrect].java pour un exemple correct

public class ERROR[NomErreur] {
    public static void main(String[] args) {
        // Code incorrect ici
    }
}
```

**Leçon à retenir :** explication de la bonne pratique à adopter.

---

## Pour aller plus loin

> [!TIP]
>
> Une fois ces exemples maîtrisés, vous pouvez :
>
> - Modifier les exemples pour tester votre compréhension.
> - Combiner plusieurs concepts vus dans différents exemples.
> - Passer aux [exercices](../02-exercices/README.md) pour mettre en pratique.

<!-- URLs -->

[licence]: {LICENSE_URL}
