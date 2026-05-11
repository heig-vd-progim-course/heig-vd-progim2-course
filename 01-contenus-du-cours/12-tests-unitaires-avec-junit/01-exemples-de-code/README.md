# Tests unitaires avec JUnit - Exemples de code

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
- [Prérequis](#prérequis)
- [Exemples](#exemples)
  - [Structurer un test JUnit](#structurer-un-test-junit)
  - [Les assertions](#les-assertions)
  - [Tester les cas limites et les exceptions](#tester-les-cas-limites-et-les-exceptions)
  - [Tester les effets de bord](#tester-les-effets-de-bord)
- [Progression suggérée](#progression-suggérée)
- [En cas de difficulté](#en-cas-de-difficulté)

## Introduction

Ce dossier contient des exemples de code en lien avec les éléments vus en cours
sur les tests unitaires avec JUnit.

Ces exemples ont trois buts bien précis :

1. Vous familiariser à la lecture de code et sa compréhension de façon autonome.
2. Servir de base pour les exercices et les projets à réaliser.
3. Illustrer les bonnes pratiques et les erreurs courantes à éviter.

Ces exemples sont construits selon le principe des exemples travaillés (_worked
examples_) pour faciliter l'apprentissage :

- Le code est complet et exécutable.
- Les commentaires expliquent chaque étape importante.
- La sortie attendue est clairement indiquée.
- Les bonnes pratiques sont identifiées et expliquées.

## Prérequis

Chaque exemple contient les fichiers Java nécessaires. Pour compiler et exécuter
un exemple, le fichier JAR autonome de JUnit 6.0.3 est nécessaire. Il est
téléchargé automatiquement par le script `setup.sh` du mini-projet :

```shell
cd ../03-mini-projet
bash setup.sh
```

Ensuite, depuis le répertoire de l'exemple choisi :

```shell
# Créer le répertoire de sortie
mkdir -p out

# Compiler
javac \
  -cp ../../../03-mini-projet/lib/junit-platform-console-standalone-6.0.3.jar \
  *.java \
  -d out/

# Exécuter les tests
java \
  -jar ../../../03-mini-projet/lib/junit-platform-console-standalone-6.0.3.jar \
  execute --class-path out/ --scan-class-path
```

## Exemples

### Structurer un test JUnit

- [01-test-structure-de-base](./01-test-structure-de-base/) : classe de test
  minimale avec `@Test` et `assertEquals`, sans `@BeforeEach`.
- [02-beforeeach-et-arrange](./02-beforeeach-et-arrange/) : même tests, mais
  avec `@BeforeEach` pour centraliser l'étape Arrange.

### Les assertions

- [03-assertions-courantes](./03-assertions-courantes/) : les cinq assertions
  fondamentales : `assertEquals`, `assertTrue`, `assertFalse`, `assertNull` et
  `assertNotNull`.

### Tester les cas limites et les exceptions

- [04-valeurs-limites](./04-valeurs-limites/) : tester les bornes d'une plage
  valide et les premières valeurs hors plage.
- [05-assertthrows](./05-assertthrows/) : vérifier qu'une méthode lève bien une
  exception avec `assertThrows`.

### Tester les effets de bord

- [06-effets-de-bord](./06-effets-de-bord/) : vérifier qu'un état interne est
  correctement mis à jour, ou qu'il n'est pas modifié en cas d'erreur.

## Progression suggérée

1. Lire [01-test-structure-de-base](./01-test-structure-de-base/) pour
   comprendre la structure minimale d'un test JUnit.
2. Comparer avec [02-beforeeach-et-arrange](./02-beforeeach-et-arrange/) pour
   voir l'apport de `@BeforeEach`.
3. Explorer [03-assertions-courantes](./03-assertions-courantes/) pour découvrir
   les assertions disponibles.
4. Étudier [04-valeurs-limites](./04-valeurs-limites/) pour comprendre
   l'importance de tester les bornes.
5. Étudier [05-assertthrows](./05-assertthrows/) pour tester les cas d'erreur.
6. Finir avec [06-effets-de-bord](./06-effets-de-bord/) qui illustre les tests
   d'état interne.

## En cas de difficulté

- Relire le [contenu principal](../) pour la théorie.
- Exécuter chaque exemple et observer la sortie de JUnit.
- Modifier une assertion (changer une valeur attendue) pour observer l'échec.
- Poser vos questions pendant les séances ou sur le forum du cours.

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
