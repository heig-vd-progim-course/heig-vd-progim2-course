# Overloading et type casting

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
> - Expliquer le concept de surcharge de méthodes.
> - Créer plusieurs méthodes avec le même nom mais des paramètres différents.
> - Différencier surcharge (overload) et redéfinition (override).
> - Appliquer la surcharge pour créer des API flexibles.
> - Utiliser la surcharge de constructeurs pour différentes initialisations.
> - Expliquer la différence entre upcasting et downcasting.
> - Appliquer l'upcasting implicite dans une hiérarchie de classes.
> - Utiliser le downcasting explicite avec vérification de type.
> - Utiliser l'opérateur `instanceof` pour vérifier le type avant le casting.
> - Identifier et éviter les `ClassCastException`.
> - Différencier les types primitifs et leurs classes wrapper.
> - Appliquer l'autoboxing et l'unboxing.
> - Comprendre les implications de performance entre primitifs et wrappers.
> - Utiliser les méthodes utilitaires des classes wrapper
>   (`Integer.parseInt()`, etc.).
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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/11-overloading-et-type-casting/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/11-overloading-et-type-casting/11-overloading-et-type-casting-presentation.pdf
