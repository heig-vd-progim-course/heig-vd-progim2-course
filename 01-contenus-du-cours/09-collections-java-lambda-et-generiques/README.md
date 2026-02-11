# Collections Java : Lambda et génériques

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
> - Expliquer ce qu'est une expression lambda en Java.
> - Créer des expressions lambda pour des interfaces fonctionnelles.
> - Utiliser les lambdas pour simplifier le code (comparateurs, filtres).
> - Appliquer les lambdas avec les collections (forEach, removeIf, etc.).
> - Identifier les interfaces fonctionnelles courantes (`Predicate`, `Function`,
>   `Consumer`, `Supplier`).
> - Utiliser les interfaces fonctionnelles avec des lambdas.
> - Créer ses propres interfaces fonctionnelles.
> - Créer un stream à partir d'une collection.
> - Appliquer les opérations intermédiaires (filter, map, sorted).
> - Appliquer les opérations terminales (collect, forEach, count, reduce).
> - Enchaîner plusieurs opérations pour traiter des données.
> - Expliquer l'utilité des génériques en Java.
> - Créer des classes génériques avec des paramètres de type.
> - Créer des méthodes génériques.
> - Utiliser les génériques avec les collections pour assurer la sécurité de
>   type.
> - Comprendre les wildcards (`<? extends T>`, `<? super T>`).
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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/09-collections-java-lambda-et-generiques/09-collections-java-lambda-et-generiques-presentation.pdf
