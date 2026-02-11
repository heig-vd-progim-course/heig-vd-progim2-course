# JavaFX et interfaces graphiques

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
> - Expliquer ce qu'est JavaFX et son rôle dans la création d'interfaces
>   graphiques.
> - Identifier les principaux composants JavaFX (`Stage`, `Scene`, `Pane`,
>   `Button`, etc.).
> - Créer une fenêtre simple avec `Stage` et `Scene`.
> - Organiser les composants avec des layouts (conteneurs).
> - Utiliser `Label` pour afficher du texte et des images.
> - Utiliser `Button` pour créer des boutons interactifs.
> - Utiliser `TextField` et `TextArea` pour la saisie de texte.
> - Utiliser `ComboBox` et `ListView` pour les sélections.
> - Appliquer `TableView` pour afficher des données tabulaires.
> - Appliquer `FlowPane` pour une disposition en flux.
> - Appliquer `BorderPane` pour diviser l'espace en zones.
> - Appliquer `GridPane` pour une grille.
> - Utiliser `VBox` et `HBox` pour un alignement vertical ou horizontal.
> - Combiner plusieurs layouts pour des interfaces complexes.
> - Expliquer le modèle de gestion des événements en JavaFX.
> - Implémenter des gestionnaires d'événements (`EventHandler`) pour réagir aux
>   clics de boutons.
> - Utiliser des expressions lambda pour simplifier les gestionnaires
>   d'événements.
> - Gérer plusieurs types d'événements (clavier, souris, fenêtre).
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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/13-javafx-et-interfaces-graphiques/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/13-javafx-et-interfaces-graphiques/13-javafx-et-interfaces-graphiques-presentation.pdf
