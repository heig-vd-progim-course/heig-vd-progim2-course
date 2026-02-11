# Algorithmes de tri

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
> - Expliquer pourquoi le tri de données est important en programmation.
> - Identifier les critères de comparaison pour trier des objets.
> - Différencier tri croissant et tri décroissant.
> - Reconnaître les situations nécessitant un tri personnalisé.
> - Implémenter l'interface `Comparable<T>` dans une classe.
> - Définir la méthode `compareTo()` pour établir un ordre naturel.
> - Utiliser `compareTo()` pour comparer des objets.
> - Trier des collections d'objets implémentant `Comparable`.
> - Créer des objets `Comparator<T>` pour définir des ordres de tri alternatifs.
> - Différencier `Comparable` et `Comparator`.
> - Utiliser des comparateurs pour trier selon différents critères.
> - Appliquer plusieurs stratégies de tri sur une même collection.
> - Expliquer le fonctionnement du tri par sélection.
> - Expliquer le fonctionnement du tri par insertion.
> - Comparer les performances des différents algorithmes de tri (complexité).
> - Utiliser `Collections.sort()` et `Arrays.sort()` pour trier efficacement.
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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/07-algorithmes-de-tri/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/07-algorithmes-de-tri/07-algorithmes-de-tri-presentation.pdf
