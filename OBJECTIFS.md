# Objectifs d'apprentissage - Programmation 2 (ProgIM2)

V. Guidoux, avec l'aide de
[GitHub Copilot](https://github.com/features/copilot).

Ce travail est sous licence
[CC BY-SA 4.0](https://github.com/heig-vd-progim-course/heig-vd-progim2-course/blob/main/LICENSE.md).

Ce document présente l'ensemble des objectifs d'apprentissage pour chaque
séance du cours de Programmation 2. Les objectifs sont formulés avec des verbes
d'action mesurables basés sur la taxonomie de Bloom.

## Table des matières
 
- [Objectifs généraux du cours](#objectifs-généraux-du-cours)
- [Séance 01 - Introduction et bases](#séance-01---introduction-et-bases)
- [Séance 02 - POO : Classes et objets](#séance-02---poo--classes-et-objets)
- [Séance 03 - POO : Encapsulation et héritage](#séance-03---poo--encapsulation-et-héritage)
- [Séance 04 - POO : Polymorphisme](#séance-04---poo--polymorphisme)
- [Séance 05 - Algorithmes de tri](#séance-05---algorithmes-de-tri)
- [Séance 06 - Collections Java : Listes, sets et maps](#séance-06---collections-java--listes-sets-et-maps)
- [Évaluation intermédiaire](#évaluation-intermédiaire)
- [Séance 07 - Collections Java : Lambda et génériques](#séance-07---collections-java--lambda-et-génériques)
- [Séance 08 - Gestion d'exceptions](#séance-08---gestion-dexceptions)
- [Séance 09 - Overloading et type casting](#séance-09---overloading-et-type-casting)
- [Séance 10 - Tests unitaires avec JUnit](#séance-10---tests-unitaires-avec-junit)
- [Séance 11 - JavaFX et interfaces graphiques](#séance-11---javafx-et-interfaces-graphiques)
- [Séance 12 - Récapitulatif et préparation](#séance-12---récapitulatif-et-préparation)
- [Mini-projet fil rouge : Système de gestion de jardin communautaire](#mini-projet-fil-rouge--système-de-gestion-de-jardin-communautaire)

## Objectifs généraux du cours

À l'issue de cette unité d'enseignement, la personne qui étudie sera capable de
:

- Expliquer les concepts de la programmation orientée objet (POO) et les
  appliquer en Java.
- Organiser et structurer le code en utilisant des classes, des objets,
  l'encapsulation, l'héritage et le polymorphisme.
- Manipuler des collections de données en Java, y compris les listes, les
  ensembles et les maps.
- Gérer les exceptions en Java pour assurer la robustesse du code.
- Mettre en place des tests unitaires avec JUnit pour garantir la qualité du
  code.
- Décrire les principes de base de la création d'interfaces graphiques avec
  JavaFX et les appliquer dans des applications Java.

## Séance 01 - Introduction et bases

### Modalités de l'unité d'enseignement

- Identifier les modalités d'évaluation et les critères de réussite du cours.
- Reconnaître les ressources disponibles et les méthodes d'apprentissage
  proposées.
- Planifier son apprentissage en fonction des objectifs du cours.

### Debugging

- Utiliser les outils de débogage intégrés dans l'environnement de
  développement.
- Identifier et localiser les erreurs dans un programme Java.
- Appliquer des techniques de débogage pour résoudre des problèmes de code.
- Analyser le flux d'exécution d'un programme à l'aide de points d'arrêt.
- Évaluer l'état des variables durant l'exécution pour détecter des anomalies.

### Algèbre de Boole

- Lister les opérateurs logiques de base (AND, OR, NOT, XOR).
- Évaluer des expressions booléennes simples et complexes.
- Appliquer les tables de vérité pour valider des expressions logiques.
- Simplifier des expressions booléennes en utilisant les lois de De Morgan.
- Construire des conditions complexes pour contrôler le flux d'un programme.

## Séance 02 - POO : Classes et objets

### Classes et objets

- Définir ce qu'est une classe et un objet en programmation orientée objet.
- Différencier une classe d'un objet (modèle vs instance).
- Créer une classe Java avec des attributs et des méthodes.
- Instancier des objets à partir d'une classe.
- Utiliser le mot-clé `new` pour créer des instances.

### Attributs et méthodes

- Déclarer des attributs de différents types dans une classe.
- Implémenter des méthodes pour manipuler les attributs d'une classe.
- Utiliser le mot-clé `this` pour référencer l'instance courante.
- Créer des constructeurs pour initialiser les objets.
- Différencier les constructeurs par défaut et les constructeurs
  paramétrés.

### Encapsulation de base

- Appliquer les modificateurs d'accès (`private`, `public`).
- Créer des getters et setters pour accéder aux attributs privés.
- Justifier l'utilisation de l'encapsulation pour protéger les données.

### Mini-projet (partie 1)

- Créer les classes de base pour le système de jardin (`Plant`, `Plot`,
  `Gardener`).
- Définir les attributs essentiels de chaque classe (nom, type, taille, date de
  plantation, etc.).
- Implémenter des constructeurs appropriés.
- Ajouter des méthodes simples pour afficher les informations.

## Séance 03 - POO : Encapsulation et héritage

### Encapsulation avancée

- Appliquer le principe d'encapsulation pour cacher l'implémentation interne.
- Valider les données dans les setters pour garantir la cohérence.
- Concevoir des classes avec une interface publique claire.
- Justifier les choix de visibilité des membres d'une classe.

### Héritage

- Expliquer le concept d'héritage et sa finalité.
- Créer des classes dérivées en utilisant le mot-clé `extends`.
- Utiliser le mot-clé `super` pour appeler le constructeur de la classe parent.
- Identifier les relations "est-un" entre classes.
- Organiser une hiérarchie de classes logique.

### Classes et méthodes abstraites

- Définir une classe abstraite avec le mot-clé `abstract`.
- Créer des méthodes abstraites à implémenter dans les sous-classes.
- Différencier une classe abstraite d'une classe concrète.
- Justifier l'utilisation de classes abstraites pour factoriser du code.

### Modificateurs `protected` et `final`

- Appliquer le modificateur `protected` pour les membres accessibles aux
  sous-classes.
- Utiliser le mot-clé `final` pour empêcher la modification ou la
  redéfinition.
- Évaluer quand utiliser `final` sur des classes, méthodes ou variables.

### Mini-projet (partie 2)

- Créer une hiérarchie de classes pour différents types de plantes (légumes,
  fruits, herbes aromatiques, fleurs).
- Implémenter l'héritage entre `Plant` et ses sous-classes spécialisées.
- Ajouter des méthodes spécifiques à chaque type de plante.
- Valider les données dans les setters (dates cohérentes, tailles positives,
  etc.).

## Séance 04 - POO : Polymorphisme

### Polymorphisme

- Expliquer le concept de polymorphisme en POO.
- Utiliser des références de type parent pour des objets de type enfant.
- Appliquer le polymorphisme pour traiter différents objets de manière
  uniforme.
- Démontrer comment le polymorphisme améliore la flexibilité du code.

### Redéfinition de méthodes (`@Override`)

- Redéfinir des méthodes héritées dans les sous-classes.
- Utiliser l'annotation `@Override` pour marquer les redéfinitions.
- Différencier redéfinition (override) et surcharge (overload).
- Appliquer la redéfinition pour adapter le comportement aux sous-classes.

### Interfaces

- Définir une interface Java avec le mot-clé `interface`.
- Implémenter une ou plusieurs interfaces dans une classe.
- Différencier une interface d'une classe abstraite.
- Utiliser les interfaces pour définir des contrats de comportement.
- Justifier l'utilisation d'interfaces pour le polymorphisme.

### Méthode `toString()` et `equals()`

- Redéfinir la méthode `toString()` pour représenter un objet sous forme de
  chaîne.
- Implémenter `equals()` pour comparer deux objets de manière significative.
- Implémenter `hashCode()` en cohérence avec `equals()`.

### Mini-projet (partie 3)

- Créer des interfaces pour définir des comportements communs (`Watered`,
  `Harvestable`, `Seasonal`).
- Implémenter ces interfaces dans les classes appropriées.
- Utiliser le polymorphisme pour traiter différents types de plantes de manière
  uniforme.
- Redéfinir `toString()` et `equals()` pour les classes principales.

## Séance 05 - Algorithmes de tri

### Concepts de tri

- Expliquer pourquoi le tri de données est important en programmation.
- Identifier les critères de comparaison pour trier des objets.
- Différencier tri croissant et tri décroissant.
- Reconnaître les situations nécessitant un tri personnalisé.

### Interface `Comparable<T>`

- Implémenter l'interface `Comparable<T>` dans une classe.
- Définir la méthode `compareTo()` pour établir un ordre naturel.
- Utiliser `compareTo()` pour comparer des objets.
- Trier des collections d'objets implémentant `Comparable`.

### Interface `Comparator<T>`

- Créer des objets `Comparator<T>` pour définir des ordres de tri alternatifs.
- Différencier `Comparable` et `Comparator`.
- Utiliser des comparateurs pour trier selon différents critères.
- Appliquer plusieurs stratégies de tri sur une même collection.

### Algorithmes de tri simples

- Expliquer le fonctionnement du tri par sélection.
- Expliquer le fonctionnement du tri par insertion.
- Comparer les performances des différents algorithmes de tri (complexité).
- Utiliser `Collections.sort()` et `Arrays.sort()` pour trier efficacement.

### Mini-projet (partie 4)

- Implémenter `Comparable` pour trier les plantes par date de plantation.
- Créer des comparateurs pour trier par nom, type, ou date de récolte prévue.
- Afficher les plantes triées selon différents critères.
- Identifier la plante la plus proche de la récolte.

## Séance 06 - Collections Java : Listes, sets et maps

### Framework Collections

- Identifier les principales interfaces du framework Collections (`List`, `Set`,
  `Map`).
- Différencier les caractéristiques de chaque type de collection.
- Sélectionner la collection appropriée selon le besoin.

### Listes (`List`)

- Utiliser `ArrayList<T>` pour stocker des éléments avec ordre et doublons.
- Utiliser `LinkedList<T>` et comprendre ses avantages/inconvénients.
- Appliquer les méthodes de base : `add()`, `get()`, `remove()`, `size()`,
  `contains()`.
- Parcourir une liste avec une boucle `for-each`.
- Différencier `ArrayList` et `LinkedList` en termes de performance.

### Ensembles (`Set`)

- Utiliser `HashSet<T>` pour stocker des éléments uniques sans ordre.
- Utiliser `TreeSet<T>` pour un ensemble trié automatiquement.
- Appliquer les opérations d'ensembles (ajout, suppression, test
  d'appartenance).
- Justifier l'utilisation d'un `Set` pour éliminer les doublons.

### Maps (`Map`)

- Utiliser `HashMap<K, V>` pour associer des clés à des valeurs.
- Utiliser `TreeMap<K, V>` pour une map triée par clés.
- Appliquer les méthodes : `put()`, `get()`, `remove()`, `containsKey()`,
  `keySet()`, `values()`.
- Parcourir une map avec différentes approches.

### Itération et parcours

- Utiliser les itérateurs pour parcourir les collections.
- Appliquer la boucle `for-each` sur différentes collections.
- Modifier une collection pendant l'itération de manière sécurisée.

### Mini-projet (partie 5)

- Utiliser une `ArrayList<Plot>` pour gérer les parcelles du jardin.
- Utiliser une `HashMap<String, Gardener>` pour associer jardiniers et
  parcelles.
- Utiliser un `Set<Plant>` pour gérer les plantes uniques disponibles.
- Implémenter des méthodes pour rechercher, ajouter et supprimer des éléments.

## Évaluation intermédiaire

L'évaluation intermédiaire couvre les séances 01 à 06 et évalue la capacité à :

- Appliquer les principes de la POO dans un programme Java.
- Créer des classes avec héritage et polymorphisme.
- Manipuler des collections Java appropriées.
- Trier et organiser des données.
- Résoudre des problèmes en utilisant les concepts vus.

## Séance 07 - Collections Java : Lambda et génériques

### Expressions lambda

- Expliquer ce qu'est une expression lambda en Java.
- Créer des expressions lambda pour des interfaces fonctionnelles.
- Utiliser les lambdas pour simplifier le code (comparateurs, filtres).
- Appliquer les lambdas avec les collections (forEach, removeIf, etc.).

### Interfaces fonctionnelles

- Identifier les interfaces fonctionnelles courantes (`Predicate`, `Function`,
  `Consumer`, `Supplier`).
- Utiliser les interfaces fonctionnelles avec des lambdas.
- Créer ses propres interfaces fonctionnelles.

### Streams API

- Créer un stream à partir d'une collection.
- Appliquer les opérations intermédiaires (filter, map, sorted).
- Appliquer les opérations terminales (collect, forEach, count, reduce).
- Enchaîner plusieurs opérations pour traiter des données.

### Génériques (`<T>`)

- Expliquer l'utilité des génériques en Java.
- Créer des classes génériques avec des paramètres de type.
- Créer des méthodes génériques.
- Utiliser les génériques avec les collections pour assurer la sécurité de type.
- Comprendre les wildcards (`<? extends T>`, `<? super T>`).

### Mini-projet (partie 6)

- Utiliser des lambdas pour filtrer les plantes prêtes à récolter.
- Créer des streams pour calculer des statistiques (nombre de plantes par type,
  surface totale cultivée).
- Implémenter des méthodes génériques pour manipuler différentes collections.
- Simplifier le code existant avec les lambdas et streams.

## Séance 08 - Gestion d'exceptions

### Concepts d'exceptions

- Expliquer ce qu'est une exception et son rôle en Java.
- Différencier erreurs (Error) et exceptions (Exception).
- Identifier les exceptions vérifiées (checked) et non vérifiées (unchecked).
- Reconnaître les situations nécessitant la gestion d'exceptions.

### Try-catch-finally

- Utiliser les blocs `try-catch` pour capturer des exceptions.
- Gérer plusieurs types d'exceptions avec plusieurs blocs `catch`.
- Utiliser le bloc `finally` pour le code devant toujours s'exécuter.
- Appliquer le multi-catch pour simplifier le code.

### Lancer des exceptions

- Lancer une exception avec le mot-clé `throw`.
- Déclarer les exceptions lancées avec `throws` dans la signature de méthode.
- Différencier quand capturer et quand propager une exception.

### Exceptions personnalisées

- Créer des classes d'exceptions personnalisées héritant de `Exception`.
- Justifier la création d'exceptions spécifiques au domaine.
- Implémenter des constructeurs appropriés dans les exceptions personnalisées.
- Utiliser les exceptions personnalisées pour clarifier les erreurs.

### Mini-projet (partie 7)

- Créer des exceptions personnalisées (`InvalidPlantingDateException`,
  `PlotFullException`, `PlantNotFoundException`).
- Gérer les exceptions lors de l'ajout de plantes (dates invalides, parcelles
  pleines).
- Valider les données avec exceptions plutôt que valeurs de retour.
- Implémenter un système robuste de gestion des erreurs.

## Séance 09 - Overloading et type casting

### Surcharge de méthodes (overloading)

- Expliquer le concept de surcharge de méthodes.
- Créer plusieurs méthodes avec le même nom mais des paramètres différents.
- Différencier surcharge (overload) et redéfinition (override).
- Appliquer la surcharge pour créer des API flexibles.
- Utiliser la surcharge de constructeurs pour différentes initialisations.

### Type casting

- Expliquer la différence entre upcasting et downcasting.
- Appliquer l'upcasting implicite dans une hiérarchie de classes.
- Utiliser le downcasting explicite avec vérification de type.
- Utiliser l'opérateur `instanceof` pour vérifier le type avant le casting.
- Identifier et éviter les `ClassCastException`.

### Types primitifs et wrappers

- Différencier les types primitifs et leurs classes wrapper.
- Appliquer l'autoboxing et l'unboxing.
- Comprendre les implications de performance entre primitifs et wrappers.
- Utiliser les méthodes utilitaires des classes wrapper (`Integer.parseInt()`,
  etc.).

### Mini-projet (partie 8)

- Surcharger les méthodes pour ajouter des plantes (avec/sans date, avec
  paramètres par défaut).
- Utiliser le casting pour manipuler des collections de types différents.
- Implémenter des méthodes qui acceptent différents types de paramètres.
- Vérifier les types avec `instanceof` avant d'effectuer des opérations
  spécifiques.

## Séance 10 - Tests unitaires avec JUnit

### Principes des tests

- Expliquer l'importance des tests unitaires en développement logiciel.
- Identifier ce qui constitue un bon test unitaire.
- Différencier tests unitaires, tests d'intégration et tests fonctionnels.
- Reconnaître les avantages du développement piloté par les tests (TDD).

### JUnit - bases

- Créer une classe de test avec JUnit.
- Utiliser les annotations `@Test`, `@BeforeEach`, `@AfterEach`.
- Écrire des assertions avec `assertEquals()`, `assertTrue()`, `assertFalse()`,
  `assertNull()`.
- Exécuter les tests et interpréter les résultats.

### Tests avancés

- Tester les exceptions attendues avec `assertThrows()`.
- Utiliser `@BeforeAll` et `@AfterAll` pour l'initialisation globale.
- Organiser les tests en suites de tests.
- Appliquer les principes AAA (Arrange-Act-Assert).

### Couverture de code

- Évaluer la couverture de code des tests.
- Identifier les branches et cas limites à tester.
- Créer des tests pour les cas nominaux et les cas d'erreur.

### Mini-projet (partie 9)

- Créer des tests unitaires pour les classes principales (`Plant`, `Plot`,
  `Gardener`).
- Tester les méthodes de tri et de filtrage.
- Tester la gestion des exceptions personnalisées.
- Atteindre une couverture de code satisfaisante (>70%).

## Séance 11 - JavaFX et interfaces graphiques

### Introduction à JavaFX

- Expliquer ce qu'est JavaFX et son rôle dans la création d'interfaces
  graphiques.
- Identifier les principaux composants JavaFX (`Stage`, `Scene`, `Pane`,
  `Button`, etc.).
- Créer une fenêtre simple avec `Stage` et `Scene`.
- Organiser les composants avec des layouts (conteneurs).

### Composants de base

- Utiliser `Label` pour afficher du texte et des images.
- Utiliser `Button` pour créer des boutons interactifs.
- Utiliser `TextField` et `TextArea` pour la saisie de texte.
- Utiliser `ComboBox` et `ListView` pour les sélections.
- Appliquer `TableView` pour afficher des données tabulaires.

### Gestionnaires de disposition (layouts)

- Appliquer `FlowPane` pour une disposition en flux.
- Appliquer `BorderPane` pour diviser l'espace en zones.
- Appliquer `GridPane` pour une grille.
- Utiliser `VBox` et `HBox` pour un alignement vertical ou horizontal.
- Combiner plusieurs layouts pour des interfaces complexes.

### Gestion des événements

- Expliquer le modèle de gestion des événements en JavaFX.
- Implémenter des gestionnaires d'événements (`EventHandler`) pour réagir aux
  clics de boutons.
- Utiliser des expressions lambda pour simplifier les gestionnaires
  d'événements.
- Gérer plusieurs types d'événements (clavier, souris, fenêtre).

### Mini-projet (partie 10 - finale)

- Créer une interface graphique pour visualiser le jardin.
- Afficher la liste des parcelles et des plantes dans des `TableView` ou
  `ListView`.
- Implémenter des boutons pour ajouter, modifier, supprimer des plantes.
- Filtrer et trier les plantes via l'interface graphique.
- Afficher les informations de récolte et alertes visuelles.
- Créer un système visuel de planification du jardin.

## Séance 12 - Récapitulatif et préparation

### Révision des concepts clés

- Synthétiser les concepts de POO vus durant le semestre.
- Identifier les points importants pour l'examen.
- Résoudre des exercices de révision couvrant tous les thèmes.

### Pratique et approfondissement

- Analyser des cas complexes combinant plusieurs concepts.
- Évaluer la qualité de code selon les bonnes pratiques vues.
- Refactoriser du code pour améliorer sa structure.

### Préparation à l'examen

- Reconnaître les types de questions possibles à l'examen.
- Appliquer une méthodologie de résolution de problèmes.
- Gérer son temps efficacement durant l'épreuve.

### Finalisation du mini-projet

- Compléter toutes les fonctionnalités du système de gestion de jardin.
- Tester l'application de manière exhaustive.
- Documenter le code et l'utilisation de l'application.
- Présenter son travail et expliquer ses choix techniques.

## Mini-projet fil rouge : Système de gestion de jardin communautaire

### Objectifs globaux du mini-projet

Au fil du semestre, la personne qui étudie développera progressivement un
système complet de gestion de jardin communautaire qui permettra de :

- Gérer différents types de plantes (légumes, fruits, herbes, fleurs).
- Organiser les parcelles du jardin et leur attribution aux jardiniers.
- Planifier les plantations et suivre les récoltes.
- Calculer les besoins en eau et en entretien.
- Visualiser l'état du jardin et les prochaines tâches à effectuer.

### Compétences transversales développées

À travers ce projet, la personne qui étudie sera capable de :

- Concevoir une architecture logicielle cohérente et évolutive.
- Appliquer les principes POO dans un contexte réaliste.
- Structurer et organiser un projet de taille moyenne.
- Intégrer progressivement de nouvelles fonctionnalités.
- Tester et valider son code de manière systématique.
- Créer une interface utilisateur intuitive et fonctionnelle.

### Valeurs pédagogiques

Ce projet s'inscrit dans une démarche de développement durable et de sobriété
numérique en :

- Promouvant l'agriculture urbaine et les jardins communautaires.
- Sensibilisant à la saisonnalité et à la planification des cultures.
- Encourageant les pratiques écologiques (rotation des cultures, économie
  d'eau).
- Développant un outil utile pour des initiatives locales et citoyennes.

---

_Ce document sera mis à jour si nécessaire durant le semestre pour refléter les
ajustements pédagogiques._
