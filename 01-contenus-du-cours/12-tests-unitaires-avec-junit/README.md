# Tests unitaires avec JUnit

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
> - Exemples de code : [Accéder au contenu](./01-exemples-de-code/README.md)
> - Exercices : [Accéder au contenu](./02-exercices/README.md)
> - Mini-projet : [Accéder au contenu](./03-mini-projet/README.md)
>
> **Objectifs**
>
> À l'issue de cette séance, les personnes qui étudient devraient être capables
> de :
>
> - Expliquer l'importance des tests unitaires en développement logiciel.
> - Identifier ce qui constitue un bon test unitaire.
> - Différencier tests unitaires, tests d'intégration et tests fonctionnels.
> - Reconnaître les avantages du développement piloté par les tests (TDD).
> - Créer une classe de test avec JUnit.
> - Utiliser les annotations `@Test`, `@BeforeEach`, `@AfterEach`.
> - Écrire des assertions avec `assertEquals()`, `assertTrue()`, `assertFalse()`,
>   `assertNull()`.
> - Exécuter les tests et interpréter les résultats.
> - Tester les exceptions attendues avec `assertThrows()`.
> - Utiliser `@BeforeAll` et `@AfterAll` pour l'initialisation globale.
> - Organiser les tests en suites de tests.
> - Appliquer les principes AAA (Arrange-Act-Assert).
> - Évaluer la couverture de code des tests.
> - Identifier les branches et cas limites à tester.
> - Créer des tests pour les cas nominaux et les cas d'erreur.
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

<!-- URLs -->

[licence]:
	https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md
[presentation-web]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/12-tests-unitaires-avec-junit/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/12-tests-unitaires-avec-junit/12-tests-unitaires-avec-junit-presentation.pdf
