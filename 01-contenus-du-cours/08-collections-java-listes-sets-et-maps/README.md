# Collections Java : Listes, sets et maps

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
> - Identifier les principales interfaces du framework Collections (`List`,
>   `Set`, `Map`).
> - Différencier les caractéristiques de chaque type de collection.
> - Sélectionner la collection appropriée selon le besoin.
> - Utiliser `ArrayList<T>` pour stocker des éléments avec ordre et doublons.
> - Utiliser `LinkedList<T>` et comprendre ses avantages/inconvénients.
> - Appliquer les méthodes de base : `add()`, `get()`, `remove()`, `size()`,
>   `contains()`.
> - Parcourir une liste avec une boucle `for-each`.
> - Différencier `ArrayList` et `LinkedList` en termes de performance.
> - Utiliser `HashSet<T>` pour stocker des éléments uniques sans ordre.
> - Utiliser `TreeSet<T>` pour un ensemble trié automatiquement.
> - Appliquer les opérations d'ensembles (ajout, suppression, test
>   d'appartenance).
> - Justifier l'utilisation d'un `Set` pour éliminer les doublons.
> - Utiliser `HashMap<K, V>` pour associer des clés à des valeurs.
> - Utiliser `TreeMap<K, V>` pour une map triée par clés.
> - Appliquer les méthodes : `put()`, `get()`, `remove()`, `containsKey()`,
>   `keySet()`, `values()`.
> - Parcourir une map avec différentes approches.
> - Utiliser les itérateurs pour parcourir les collections.
> - Appliquer la boucle `for-each` sur différentes collections.
> - Modifier une collection pendant l'itération de manière sécurisée.
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
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/08-collections-java-listes-sets-et-maps/presentation.html
[presentation-pdf]:
	https://heig-vd-progim-course.github.io/heig-vd-progim2-course/01-contenus-du-cours/08-collections-java-listes-sets-et-maps/08-collections-java-listes-sets-et-maps-presentation.pdf
