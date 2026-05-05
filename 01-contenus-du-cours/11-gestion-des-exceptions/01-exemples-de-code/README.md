# Gestion des exceptions - Exemples de code

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
- [Exemples](#exemples)
  - [Observer le comportement sans gestion d'erreurs](#observer-le-comportement-sans-gestion-derreurs)
  - [Capturer les exceptions](#capturer-les-exceptions)
  - [Lancer des exceptions](#lancer-des-exceptions)
  - [Créer ses propres exceptions](#créer-ses-propres-exceptions)
- [Progression suggérée](#progression-suggérée)
- [En cas de difficulté](#en-cas-de-difficulté)

## Introduction

Ce dossier contient des exemples de code en lien avec les éléments vus en cours
sur la gestion des exceptions en Java.

Ces exemples ont trois buts bien précis :

1. Vous familiariser à la lecture de code et sa compréhension de façon autonome.
2. Servir de base pour les exercices et les projets à réaliser.
3. Illustrer les bonnes pratiques et les erreurs courantes à éviter.

Ces exemples sont construits selon le principe des **exemples travaillés**
(_worked examples_) pour faciliter l'apprentissage :

- Le code est complet et exécutable.
- Les commentaires expliquent chaque étape importante.
- La sortie attendue est clairement indiquée.
- Les bonnes pratiques sont identifiées et expliquées.

## Exemples

### Observer le comportement sans gestion d'erreurs

- [01-programme-fragile](./01-programme-fragile/) : programme sans gestion
  d'erreurs qui plante sur une valeur invalide.

### Capturer les exceptions

- [02-try-catch-base](./02-try-catch-base/) : bloc `try-catch` de base pour
  capturer une `NumberFormatException`.
- [03-plusieurs-catch](./03-plusieurs-catch/) : plusieurs blocs `catch` pour
  gérer deux types d'exceptions distincts.
- [04-multi-catch-et-finally](./04-multi-catch-et-finally/) : syntaxe
  multi-catch avec `|` et bloc `finally`.

### Lancer des exceptions

- [05-throw-et-throws](./05-throw-et-throws/) : lancer une exception avec
  `throw` et déclarer une exception propagée avec `throws`.

### Créer ses propres exceptions

- [06-exception-personnalisee](./06-exception-personnalisee/) : créer
  `InvalidPhException`, l'intégrer dans `WaterSensor` et construire un système
  de surveillance robuste.

## Progression suggérée

1. Lire le code de [01-programme-fragile](./01-programme-fragile/) et observer
   la sortie du plantage.
2. Étudier [02-try-catch-base](./02-try-catch-base/) pour voir comment `try` et
   `catch` modifient le comportement.
3. Comparer [03-plusieurs-catch](./03-plusieurs-catch/) et
   [04-multi-catch-et-finally](./04-multi-catch-et-finally/) pour comprendre
   quand utiliser chaque approche.
4. Étudier [05-throw-et-throws](./05-throw-et-throws/) pour comprendre le
   lancement et la propagation.
5. Finir avec [06-exception-personnalisee](./06-exception-personnalisee/) qui
   combine tous les concepts dans un système complet.

## En cas de difficulté

- Relire le [contenu principal](../) pour la théorie.
- Exécuter chaque exemple en ajoutant des `System.out.println()` pour tracer le
  flux d'exécution.
- Modifier les valeurs d'entrée pour observer des comportements différents.
- Poser vos questions pendant les séances ou sur le forum du cours.

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
