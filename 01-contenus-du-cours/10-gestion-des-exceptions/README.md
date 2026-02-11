# Gestion des exceptions

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
> À l'issue de cette séance,les personnes qui étudient devraient être capables
> de :
>
> - Expliquer ce qu'est une exception et son rôle en Java.
> - Différencier erreurs (Error) et exceptions (Exception).
> - Identifier les exceptions vérifiées (checked) et non vérifiées (unchecked).
> - Reconnaître les situations nécessitant la gestion d'exceptions.
> - Utiliser les blocs `try-catch` pour capturer des exceptions.
> - Gérer plusieurs types d'exceptions avec plusieurs blocs `catch`.
> - Utiliser le bloc `finally` pour le code devant toujours s'exécuter.
> - Appliquer le multi-catch pour simplifier le code.
> - Lancer une exception avec le mot-clé `throw`.
> - Déclarer les exceptions lancées avec `throws` dans la signature de méthode.
> - Différencier quand capturer et quand propager une exception.
> - Créer des classes d'exceptions personnalisées héritant de `Exception`.
> - Justifier la création d'exceptions spécifiques au domaine.
> - Implémenter des constructeurs appropriés dans les exceptions personnalisées.
> - Utiliser les exceptions personnalisées pour clarifier les erreurs.
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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/10-gestion-des-exceptions/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/10-gestion-des-exceptions/10-gestion-des-exceptions-presentation.pdf
