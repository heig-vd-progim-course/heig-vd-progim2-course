#import "@preview/codelst:2.0.2": sourcecode
#import "@local/heig-vd-evaluations-and-exams-template:0.1.0": conf, question_types
#set text(font: "Atkinson Hyperlegible")

#let parts = (
  ("Question 1", 18),
  ("Question 2", 16),
  ("Question 3", 14),
)

#let additional_information = [

  Vous n'avez pas le droit à des pages de résumé pour cette partie.

  Vous pouvez répondre aux questions en français ou en anglais.

  Toute tentative de triche sera sanctionnée par la note de 1.

  _Examen préparé avec l'aide d'Hadrien Louis, GitHub Copilot et Claude (Anthropic)._
]

#show: doc => conf(
  evaluation_title: "Programmation Ingénierie des Médias 2 (ProgIM2)",
  evaluation_subtitle: [Évaluation de début de semestre - Partie 1#if "room" in sys.inputs [ (Salle #sys.inputs.room)]],
  evaluation_date: "01.04.2026",
  duration: "45 minutes (9h15 à 10h). Entre les deux parties, tout le monde doit quitter la classe le temps que les copies soient ramassées et que la partie 2 soit distribuée.",
  parts,
  additional_information,
  doc,
)

#let show_official_answer = if "show_official_answer" in sys.inputs {
  sys.inputs.show_official_answer == "true"
} else {
  false
}

#pagebreak()

#align(center)[Page laissée vide]

#pagebreak()

// ============================================================================
// QUESTION 1 : Algèbre de Boole et expressions booléennes complexes
// ============================================================================

#question_types.question_statement(
  title: "Algèbre de Boole : Système de validation d'accès",
  statement: [
    Vous développez un système de contrôle d'accès pour un data center qui doit gérer différents niveaux de sécurité.
    
    *Partie A (6 points)* : Analysez le code suivant et répondez aux questions :
    
    #sourcecode[```java
    public class AccessValidator {
        public static void main(String[] args) {
            boolean hasKeycard = true;
            boolean hasBiometricAccess = false;
            boolean isEmergency = false;
            boolean isMaintenanceMode = true;
            boolean isBusinessHours = false;
            
            // Règle 1 : Accès standard
            boolean standardAccess = hasKeycard && hasBiometricAccess && isBusinessHours;
            
            // Règle 2 : Accès maintenance
            boolean maintenanceAccess = hasKeycard && isMaintenanceMode;
            
            // Règle 3 : Accès d'urgence
            boolean emergencyAccess = isEmergency || (hasKeycard && !isBusinessHours);
            
            // Règle 4 : Accès refusé
            boolean accessDenied = !(hasKeycard || hasBiometricAccess);
            
            // Règle 5 : Accès final
            boolean finalAccess = (standardAccess || maintenanceAccess || emergencyAccess) 
                                  && !accessDenied;
            
            System.out.println("Accès accordé : " + finalAccess);
        }
    }
    ```]
    
    1. Quelle est la valeur de `standardAccess` ? Justifiez votre réponse en détaillant l'évaluation de l'expression.
    2. Quelle est la valeur de `maintenanceAccess` ? Justifiez.
    3. Quelle est la valeur de `emergencyAccess` ? Justifiez en détaillant le court-circuit si applicable.
    4. Quelle est la valeur de `accessDenied` ? Justifiez.
    5. Quelle est la valeur finale de `finalAccess` ? Justifiez en montrant le calcul complet.
    6. Que sera affiché dans la console ?
    
    *Partie B (6 points)* : Simplification avec les lois de De Morgan
    
    Simplifiez les expressions suivantes en appliquant les lois de De Morgan et les règles de simplification booléenne :
    
    1. `!(hasKeycard && hasBiometricAccess)`
    2. `!(isEmergency || isMaintenanceMode)`
    3. `!(!hasKeycard || !hasBiometricAccess)`
    
    Pour chaque expression, donnez l'expression simplifiée et expliquez les étapes de simplification.


    #colbreak()
    
    *Partie C (6 points)* : Modification du système
    
    Modifiez le code pour implémenter les nouvelles règles suivantes :
    
    1. L'accès standard nécessite maintenant (badge OU biométrie) ET heures ouvrables
    2. L'accès d'urgence est accordé SEULEMENT si c'est une urgence ET qu'il y a au moins un badge OU une biométrie
    3. Ajoutez une nouvelle règle : l'accès VIP qui est accordé si la personne a les deux (badge ET biométrie) quel que soit l'horaire
    
    Écrivez le code complet pour ces trois nouvelles règles.
  ],
  points: 18,
)


#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie A : Analyse du code (6 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *standardAccess = false* (1 point)
    
    `hasKeycard && hasBiometricAccess && isBusinessHours`  

    $  =$ `true && false && false`

    $  =$ `false` (dès que && rencontre false, le résultat est false)
    
    *maintenanceAccess = true* (1 point)
    
    `hasKeycard && isMaintenanceMode`
    
    $  =$ `true && true`
    
    $  =$ `true`
    
    *emergencyAccess = true* (1 point)
    
    `isEmergency || (hasKeycard && !isBusinessHours)`
    
    $  =$ `false || (true && !false)`
    
    $  =$ `false || (true && true)`
    
    $  =$ `false || true`
    
    $  =$ `true`
    
    *accessDenied = false* (1 point)
    
    `!(hasKeycard || hasBiometricAccess)`
    
    $  =$ `!(true || false)`
    
    $  =$ `!true`
    
    $  =$ `false`
    
    *finalAccess = true* (1.5 point)
    
    `(standardAccess || maintenanceAccess || emergencyAccess) && !accessDenied`
    
    $  =$ `(false || true || true) && !false`
    
    $  =$ `true && true`
    
    $  =$ `true`
    
    *Affichage : "Accès accordé : true"* (0.5 point)
  ],
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  height_cm: 12cm,
  margin_bottom: 0cm,
  icon_text: "Partie B : Simplification (6 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *Simplification de `!(hasKeycard && hasBiometricAccess)` (2 points)*
    
    Loi de De Morgan : `!(A && B)` = `!A || !B`
    
    Résultat : `!hasKeycard || !hasBiometricAccess`
    
    *Simplification de `!(isEmergency || isMaintenanceMode)` (2 points)*
    
    Loi de De Morgan : `!(A || B)` = `!A && !B`
    
    Résultat : `!isEmergency && !isMaintenanceMode`
    
    *Simplification de `!(!hasKeycard || !hasBiometricAccess)` (2 points)*
    
    Étape 1 : Appliquer De Morgan : `!(A || B)` = `!A && !B`
    
    $  =$ `!!hasKeycard && !!hasBiometricAccess`
    
    Étape 2 : Simplifier les doubles négations : `!!A` = `A`
    
    $  =$ `hasKeycard && hasBiometricAccess`
    
    Résultat : `hasKeycard && hasBiometricAccess`
  ],
)


#question_types.answer_bloc_with_icon(
  height_cm: 12cm,
  margin_bottom: 0cm,
  icon_text: "Partie C : Modification du système (6 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    // Nouvelle règle 1 : Accès standard (2 points)
    boolean standardAccess = (hasKeycard || hasBiometricAccess) && isBusinessHours;
    
    // Nouvelle règle 2 : Accès d'urgence (2 points)
    boolean emergencyAccess = isEmergency && (hasKeycard || hasBiometricAccess);
    
    // Nouvelle règle 3 : Accès VIP (2 points)
    boolean vipAccess = hasKeycard && hasBiometricAccess;
    ```
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 2 : Programmation Orientée Objet - Débogage
// ============================================================================

#question_types.question_statement(
  title: "POO : Débogage d'un système de capteurs IoT",
  statement: [
    Une personne a écrit un système de gestion de capteurs IoT, mais son code contient plusieurs erreurs. Votre tâche est de les identifier et de les corriger.
    
    *Code fourni :*
    
    #sourcecode[```java
    // Fichier : Sensor.java
    public class Sensor {
        private String id;
        private String location;
        public double temperature;
        private boolean isActive;
        
        public Sensor(String id) {
            this.id = id;
            this.temperature = 20.0;
            this.isActive = true;
        }
        
        public void updateTemperature(double temp) {
            temperature = temp;
        }
        
        public String getLocation() {
            return location;
        }
        
        public String getInfo() {
            return "Capteur " + id + " à " + location + 
                   " : " + temperature + "°C";
        }
    }
    
    // Fichier : Main.java
    public class Main {
        public static void main(String[] args) {
            Sensor sensor1 = new Sensor("S042", "Salle 404");
            sensor1.updateTemperature(22.5);
            
            System.out.println(sensor1.getInfo());
            System.out.println("Température : " + sensor1.temperature);
            
            Sensor sensor2 = new Sensor("S067");
            sensor2.location = "Laboratoire";
            System.out.println("Localisation : " + sensor2.getLocation());
        }
    }
    ```]
    
    *Partie A (10 points)* : Identification des erreurs
    
    Identifiez TOUTES les erreurs dans ce code (il y en a 5). Pour chaque erreur :
    1. Indiquez le numéro de ligne ou la section concernée
    2. Expliquez pourquoi c'est une erreur
    3. Proposez la correction

    #colbreak()
    
    *Partie B (6 points)* : Prédiction d'exécution
    
    Considérez maintenant le code suivant qui utilise la classe Sensor *telle quelle* (avec les erreurs) :
    
    #sourcecode[```java
    public class TestSensor {
        public static void main(String[] args) {
            Sensor capteur1 = new Sensor("S404");
            System.out.println(capteur1.getInfo());
            
            capteur1.updateTemperature(25.5);
            System.out.println("Température : " + capteur1.temperature);
            
            Sensor capteur2 = new Sensor("S067");
            capteur2.temperature = 21.0;
            System.out.println(capteur2.getInfo());
        }
    }
    ```]
    
    Donnez la sortie complète de ce programme. Justifiez chaque ligne affichée en expliquant ce qui se passe (y compris les problèmes causés par les erreurs).
  ],
  points: 16,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie A : Identification des erreurs (10 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *Erreur 1 (2 points) : Attribut temperature est public au lieu de private*
    
    Ligne : `public double temperature;`
    
    Problème : Viole le principe d'encapsulation. Les attributs doivent être privés pour protéger les données.
    
    Correction : `private double temperature;`
    
    *Erreur 2 (2 points) : Constructeur ne prend pas location en paramètre*
    
    Ligne : `public Sensor(String id)`
    
    Problème : Le constructeur ne permet pas d'initialiser `location`. Dans le main, on essaie de passer deux paramètres `new Sensor("S042", "Salle 404")` mais le constructeur n'en accepte qu'un.
    
    Correction : `public Sensor(String id, String location)` et ajouter `this.location = location;`
    
    *Erreur 3 (2 points) : Accès direct à l'attribut privé location dans Main*
    
    Ligne : `sensor2.location = "Laboratoire";`
    
    Problème : `location` est privé, on ne peut pas y accéder directement depuis l'extérieur de la classe. Viole l'encapsulation.
    
    Correction : Ajouter un setter `setLocation(String location)` dans la classe Sensor et l'utiliser : `sensor2.setLocation("Laboratoire");`
    
    *Erreur 4 (2 points) : Accès direct à l'attribut temperature dans Main*
    
    Ligne : `System.out.println("Température : " + sensor1.temperature);`
    
    Problème : Même si `temperature` est actuellement public (ce qui est une erreur), après correction il sera privé. Il faut utiliser un getter.
    
    Correction : Ajouter `getTemperature()` dans Sensor et utiliser : `sensor1.getTemperature()`
    
    *Erreur 5 (2 points) : Attribut location jamais initialisé pour sensor1*
    
    Ligne : Constructeur de Sensor
    
    Problème : L'attribut `location` n'est jamais initialisé dans le constructeur, il reste `null`. Quand `getInfo()` est appelé, cela affichera "null".
    
    Correction : Incluse dans la correction de l'erreur 2 - ajouter `location` comme paramètre du constructeur.
  ],
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie B : Prédiction d'exécution (6 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *Sortie complète du programme :*
    
    ```
    Capteur S404 à null : 20.0°C
    Température : 25.5
    Capteur S067 à null : 21.0°C
    ```
    
    *Justifications détaillées (2 points par ligne correcte) :*
    
    *Ligne 1* : `Capteur S404 à null : 20.0°C`
    
    Le capteur1 est créé avec seulement l'id "S404". Le constructeur n'initialise pas `location`, qui reste donc `null`. La température est initialisée à 20.0 par défaut. La méthode `getInfo()` affiche "null" pour la localisation car l'attribut n'a jamais été initialisé.
    
    *Ligne 2* : `Température : 25.5`
    
    La méthode `updateTemperature(25.5)` modifie la température à 25.5. On peut accéder directement à `capteur1.temperature` car l'attribut est *public* (erreur d'encapsulation), donc l'accès direct fonctionne et affiche 25.5.
    
    *Ligne 3* : `Capteur S067 à null : 21.0°C`
    
    Le capteur2 est créé avec id="S067" et location reste `null` (même problème que capteur1). On modifie directement `capteur2.temperature = 21.0` car l'attribut est public. La méthode `getInfo()` affiche "null" pour la localisation et 21.0 pour la température.
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 3 : Introduction aux algorithmes de tri - Compréhension
// ============================================================================

#question_types.question_statement(
  title: "Algorithmes de tri : Analyse et compréhension",
  statement: [
    *Partie A (6 points)* : Lecture et analyse de code
    
    Analysez le code de tri suivant :
    
    #sourcecode[```java
    public static void mysterySort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
    ```]
    
    1. Quel algorithme de tri est implémenté ici ? (1 point)
    
    2. Expliquez en détail comment fonctionne cet algorithme (principe général). (3 points)
    
       _Note : Si vous n'avez pas pu identifier l'algorithme, vous pouvez expliquer le fonctionnement d'un algorithme de tri de votre choix pour obtenir des points partiels (2 points maximum)._
    
    3. Tracez l'exécution de cet algorithme sur le tableau `[42, 17, 67, 3]`. Montrez l'état du tableau après chaque passage de la boucle externe (après chaque valeur de `i`). (2 points)
    
    *Partie B (8 points)* : Vrai ou Faux sur les algorithmes de tri
    
    Pour chacune des affirmations suivantes, indiquez si elle est VRAIE ou FAUSSE et justifiez brièvement votre réponse.
    
    1. Le tri à bulles compare toujours des éléments adjacents (côte à côte). *(2 points)*
    
    2. Le tri par sélection fait plus d'échanges d'éléments que le tri à bulles. *(2 points)*
    
    3. Le tri à bulles est plus efficace sur un tableau presque trié que sur un tableau complètement mélangé. *(2 points)*
    
    4. Un tableau déjà trié `[1, 2, 3, 4, 5]` prendra autant de temps à trier avec le tri à bulles qu'un tableau en ordre inverse `[5, 4, 3, 2, 1]`. *(2 points)*
  ],
  points: 14,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  height_cm: 10cm,
  margin_bottom: 0cm,
  icon_text: "Partie A : Lecture et analyse (6 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *1. Algorithme identifié : Tri à bulles (Bubble Sort) (1 point)*
    
    *2. Principe de fonctionnement (3 points) :*
    
    Le tri à bulles fonctionne en comparant et échangeant des éléments adjacents :
    - On parcourt le tableau plusieurs fois
    - À chaque passage, on compare chaque paire d'éléments adjacents (voisins)
    - Si deux éléments adjacents sont dans le mauvais ordre, on les échange
    - Les plus grands éléments "remontent" (comme des bulles) vers la fin du tableau
    - Après chaque passage complet, le plus grand élément non trié est à sa position finale
    - On répète jusqu'à ce que le tableau soit trié
    
    *Critères d'évaluation :*
    - Mention de la comparaison d'éléments adjacents : 1 point
    - Explication des passages multiples et échanges : 1 point
    - Mention que les grands éléments remontent/se placent progressivement : 1 point
    
    *3. Traçage sur [42, 17, 67, 3] (2 points) :*
    
    État initial : `[42, 17, 67, 3]`
    
    Passage 1 (i=0) :
    - `[42, 17]` → échange → `[17, 42, 67, 3]`
    - `[42, 67]` → pas d'échange → `[17, 42, 67, 3]`
    - `[67, 3]` → échange → `[17, 42, 3, 67]`
    - Résultat : `[17, 42, 3, 67]` (67 est à sa place finale)
    
    Passage 2 (i=1) :
    - `[17, 42]` → pas d'échange
    - `[42, 3]` → échange → `[17, 3, 42, 67]`
    - Résultat : `[17, 3, 42, 67]` (42 est à sa place finale)
    
    Passage 3 (i=2) :
    - `[17, 3]` → échange → `[3, 17, 42, 67]`
    - Résultat final : `[3, 17, 42, 67]`
    
    *(1 point pour avoir montré les passages progressifs, 1 point pour le résultat correct)*
  ],
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie B : Vrai ou Faux (8 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *1. VRAI (2 points)*
    
    Le tri à bulles compare toujours des éléments adjacents (côte à côte). C'est le principe fondamental de cet algorithme : il compare `array[j]` avec `array[j+1]` et les échange si nécessaire. Les éléments "remontent" progressivement par échanges successifs avec leurs voisins.
    
    *(1 point pour VRAI, 1 point pour la justification)*
    
    *2. FAUX (2 points)*
    
    Le tri par sélection fait MOINS d'échanges que le tri à bulles. Le tri par sélection ne fait qu'un seul échange par passage (placer le minimum à sa position), tandis que le tri à bulles peut faire plusieurs échanges par passage. Pour un tableau de n éléments, le tri par sélection fait au maximum n-1 échanges, alors que le tri à bulles peut en faire beaucoup plus.
    
    *(1 point pour FAUX, 1 point pour la justification)*
    
    *3. VRAI (2 points)*
    
    Le tri à bulles est effectivement plus efficace sur un tableau presque trié. Sur un tableau presque trié, il y aura très peu d'échanges à effectuer car la plupart des éléments sont déjà à leur bonne position. En revanche, sur un tableau complètement mélangé, le tri à bulles devra faire beaucoup plus de comparaisons et d'échanges. C'est pour cela qu'on dit que le tri à bulles "s'adapte" à l'état initial du tableau.
    
    *(1 point pour VRAI, 1 point pour la justification)*
    
    *4. FAUX (2 points)*
    
    Un tableau déjà trié sera beaucoup plus rapide à trier qu'un tableau en ordre inverse. Pour un tableau déjà trié, le tri à bulles ne fera aucun échange (il parcourt juste le tableau pour vérifier), tandis que pour un tableau en ordre inverse, il devra faire le maximum d'échanges possibles. Le nombre d'opérations n'est donc pas le même.
    
    *(1 point pour FAUX, 1 point pour la justification)*
  ],
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Vous pouvez utiliser cet espace pour des notes ou des brouillons, ou compléter vos réponses aux questions précédentes.",
)
