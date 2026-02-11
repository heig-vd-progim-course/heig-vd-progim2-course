# Programmation orientée objet : Encapsulation et héritage

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
> - Appliquer le principe d'encapsulation pour cacher l'implémentation interne.
> - Valider les données dans les setters pour garantir la cohérence.
> - Concevoir des classes avec une interface publique claire.
> - Justifier les choix de visibilité des membres d'une classe.
> - Expliquer le concept d'héritage et sa finalité.
> - Créer des classes dérivées en utilisant le mot-clé `extends`.
> - Utiliser le mot-clé `super` pour appeler le constructeur de la classe
>   parent.
> - Identifier les relations "est-un" entre classes.
> - Organiser une hiérarchie de classes logique.
> - Définir une classe abstraite avec le mot-clé `abstract`.
> - Créer des méthodes abstraites à implémenter dans les sous-classes.
> - Différencier une classe abstraite d'une classe concrète.
> - Justifier l'utilisation de classes abstraites pour factoriser du code.
> - Appliquer le modificateur `protected` pour les membres accessibles aux
>   sous-classes.
> - Utiliser le mot-clé `final` pour empêcher la modification ou la
>   redéfinition.
> - Évaluer quand utiliser `final` sur des classes, méthodes ou variables.
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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/05-programmation-orientee-objet-encapsulation-et-heritage/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/05-programmation-orientee-objet-encapsulation-et-heritage/05-programmation-orientee-objet-encapsulation-et-heritage-presentation.pdf
