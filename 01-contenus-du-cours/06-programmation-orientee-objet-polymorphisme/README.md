# Programmation orientée objet : Polymorphisme

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
> - Expliquer le concept de polymorphisme en POO.
> - Utiliser des références de type parent pour des objets de type enfant.
> - Appliquer le polymorphisme pour traiter différents objets de manière
>   uniforme.
> - Démontrer comment le polymorphisme améliore la flexibilité du code.
> - Redéfinir des méthodes héritées dans les sous-classes.
> - Utiliser l'annotation `@Override` pour marquer les redéfinitions.
> - Différencier redéfinition (override) et surcharge (overload).
> - Appliquer la redéfinition pour adapter le comportement aux sous-classes.
> - Définir une interface Java avec le mot-clé `interface`.
> - Implémenter une ou plusieurs interfaces dans une classe.
> - Différencier une interface d'une classe abstraite.
> - Utiliser les interfaces pour définir des contrats de comportement.
> - Justifier l'utilisation d'interfaces pour le polymorphisme.
> - Redéfinir la méthode `toString()` pour représenter un objet sous forme de
>   chaîne.
> - Implémenter `equals()` pour comparer deux objets de manière significative.
> - Implémenter `hashCode()` en cohérence avec `equals()`.
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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/06-programmation-orientee-objet-polymorphisme/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/06-programmation-orientee-objet-polymorphisme/06-programmation-orientee-objet-polymorphisme-presentation.pdf
