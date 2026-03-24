#import "@preview/codelst:2.0.2": sourcecode
#import "@local/heig-vd-evaluations-and-exams-template:0.1.0": conf, question_types
#set text(font: "Atkinson Hyperlegible")

#let parts = (
  ("Question 1", 20),
  ("Question 2", 18),
  ("Question 3", 14),
)

#let additional_information = [

  Vous avez le droit à une page A4 recto-verso de résumé avec vos propres notes.

  Vous pouvez répondre aux questions en français ou en anglais.

  Toute tentative de triche sera sanctionnée par la note de 1.

  _Examen préparé avec l'aide d'Hadrien Louis, GitHub Copilot et Claude (Anthropic)._
]

#show: doc => conf(
  evaluation_title: "Programmation Ingénierie des Médias 2 (ProgIM2)",
  evaluation_subtitle: [Évaluation de début de semestre - Partie 2#if "room" in sys.inputs [ (Salle #sys.inputs.room)]],
  evaluation_date: "01.04.2026",
  duration: "90 minutes (10h30 à 12h)",
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
// QUESTION 1 : Encapsulation, Héritage et Polymorphisme - Débogage
// ============================================================================

#question_types.question_statement(
  title: "POO Avancée : Débogage d'un système d'appareils IoT",
  statement: [
    Une personne a écrit un système de gestion d'appareils IoT avec héritage et polymorphisme, mais son code contient plusieurs erreurs. Votre tâche est de les identifier.
    
    *Code fourni :*
    
    #sourcecode[```java
    class Device {
        private String brand;
        public int powerWatts;
        private boolean isOn;
        
        public Device(String brand, int power) {
            brand = brand;
            this.powerWatts = power;
            this.isOn = false;
        }
        
        public void turnOn() {
            isOn = true;
        }
        
        public String getInfo() {
            return "Appareil " + brand + " - " + powerWatts + "W";
        }
    }
    
    class SmartLight extends Device {
        private int brightness;
        
        public SmartLight(String brand, int power) {
            this.brightness = 50;
        }
        
        public void setBrightness(int level) {
            this.brightness = level;
        }
        
        public String getInfo() {
            return "Lumière " + brand + " - " + powerWatts + 
                   "W - Luminosité: " + brightness + "%";
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            Device device1 = new SmartLight("Philips", 10);
            device1.turnOn();
            System.out.println(device1.getInfo());
            
            SmartLight light2 = (SmartLight) device1;
            light2.setBrightness(75);
            System.out.println("Luminosité : " + light2.brightness);
            
            Device device2 = new Device("Generic", 5);
            SmartLight light3 = (SmartLight) device2;
            light3.setBrightness(100);
        }
    }
    ```]
    
    *Partie A (14 points)* : Identification des erreurs
    
    Identifiez TOUTES les erreurs dans ce code (il y en a 7). Pour chaque erreur :
    1. Indiquez la classe et la ligne/section concernée
    2. Expliquez pourquoi c'est une erreur
    3. Proposez la correction

    #colbreak()
    
    *Partie B (6 points)* : Prédiction d'exécution
    
    Considérez maintenant ce code qui utilise les classes *telles quelles* (avec les erreurs identifiées ci-dessus) :
    
    #sourcecode[```java
    public class Main {
        public static void main(String[] args) {
            Device device1 = new Device("Philips", 10);
            System.out.println(device1.getInfo());
            System.out.println("Puissance accessible : " + device1.powerWatts + "W");
            
            SmartLight light1 = new SmartLight("IKEA", 8);
            light1.setBrightness(67);
            System.out.println("Lumière créée");
        }
    }
    ```]
    
    En supposant que nous avons ajouté le minimum nécessaire pour que le code compile (comme un getter `getBrand()` pour résoudre les erreurs de visibilité), donnez la sortie complète de ce programme. Expliquez les valeurs affichées en lien avec les erreurs du code (notamment les erreurs #1 et #2).
  ],
  points: 20,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie A : Identification des erreurs (14 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *Erreur 1 (2 points) : Attribut powerWatts est public au lieu de private*
    
    Classe Device, ligne : `public int powerWatts;`
    
    Problème : Viole le principe d'encapsulation. Les attributs doivent être privés.
    
    Correction : `private int powerWatts;` et ajouter un getter `getPowerWatts()`
    
    *Erreur 2 (2 points) : Constructeur ne stocke pas le paramètre brand correctement*
    
    Classe Device, ligne : `brand = brand;`
    
    Problème : Affectation du paramètre à lui-même au lieu de l'affecter à l'attribut. Il manque `this.` pour référencer l'attribut de la classe.
    
    Correction : `this.brand = brand;`
    
    *Erreur 3 (2 points) : Pas d'appel au constructeur parent dans SmartLight*
    
    Classe SmartLight, constructeur
    
    Problème : Le constructeur de SmartLight n'appelle pas le constructeur de Device avec `super(brand, power)`. Sans cet appel, les attributs de la classe parent ne sont pas initialisés.
    
    Correction : Ajouter `super(brand, power);` comme première ligne du constructeur
    
    *Erreur 4 (2 points) : Accès à l'attribut privé brand de la classe parent*
    
    Classe SmartLight, méthode getInfo(), ligne : `"Lumière " + brand`
    
    Problème : `brand` est privé dans Device, donc inaccessible directement dans SmartLight. Il faut utiliser un getter ou rendre l'attribut protected.
    
    Correction : Ajouter `getBrand()` dans Device et utiliser `getBrand()` au lieu de `brand`
    
    *Erreur 5 (2 points) : Méthode getInfo() n'utilise pas `@Override`*
    
    Classe SmartLight, méthode getInfo()
    
    Problème : Pour une bonne pratique et éviter les erreurs, on devrait utiliser `@Override` pour indiquer qu'on redéfinit une méthode de la classe parent.
    
    Correction : Ajouter `@Override` avant la méthode getInfo()
    
    *Erreur 6 (2 points) : Accès direct à l'attribut privé brightness*
    
    Classe Main, ligne : `light2.brightness`
    
    Problème : `brightness` est privé, on ne peut pas y accéder directement depuis l'extérieur de la classe.
    
    Correction : Ajouter un getter `getBrightness()` dans SmartLight et l'utiliser
    
    *Erreur 7 (2 points) : Cast impossible d'un Device en SmartLight*
    
    Classe Main, lignes : `Device device2 = new Device(...)` puis `SmartLight light3 = (SmartLight) device2;`
    
    Problème : On essaie de caster un objet Device en SmartLight, mais device2 n'est PAS un SmartLight, c'est un Device pur. Cela provoquera une ClassCastException à l'exécution.
    
    Correction : Supprimer ces lignes ou créer un vrai SmartLight : `SmartLight light3 = new SmartLight("Brand", 10);`
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
    Appareil null - 10W
    Puissance accessible : 10W
    Lumière créée
    ```
    
    *Justifications détaillées :*
    
    *Ligne 1* : `Appareil null - 10W` (2 points)
    
    À cause de l'*erreur #2*, le constructeur de Device fait `brand = brand` au lieu de `this.brand = brand`. Cela signifie que l'attribut `brand` de l'instance reste à sa valeur par défaut `null`. Le paramètre est affecté à lui-même et perdu. Donc quand `getInfo()` concatène le brand, il affiche `null`. Le powerWatts est correctement initialisé à 10.
    
    *Ligne 2* : `Puissance accessible : 10W` (2 points)
    
    À cause de l'*erreur #1*, l'attribut `powerWatts` est déclaré `public` au lieu de `private`. Cela viole l'encapsulation et permet d'accéder directement à l'attribut depuis l'extérieur de la classe avec `device1.powerWatts`. La valeur 10 est affichée car elle a été correctement initialisée dans le constructeur.
    
    *Ligne 3* : `Lumière créée` (2 points)
    
    Le SmartLight est créé malgré l'*erreur #3* (pas d'appel à `super()`). Le constructeur SmartLight s'exécute et initialise `brightness = 50`. Cependant, les attributs hérités de Device (brand, powerWatts, isOn) ne sont PAS correctement initialisés car `super()` n'est pas appelé. Si on appelait `getInfo()` sur light1, brand serait null et powerWatts serait 0 (valeur par défaut d'un int).
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 2 : Classes abstraites et Interfaces - Débogage
// ============================================================================

#question_types.question_statement(
  title: "POO Avancée : Débogage avec classes abstraites et interfaces",
  statement: [
    Une personne a écrit un système de notifications avec une classe abstraite et des interfaces, mais son code contient plusieurs erreurs. Votre tâche est de les identifier.
    
    *Code fourni :*
    
    #sourcecode[```java
    interface Sendable {
        void send();
        String getRecipient();
    }
    
    interface Loggable {
        void log();
    }
    
    public abstract class Notification {
        private String message;
        public String priority;
        
        public Notification(String message) {
            message = message;
        }
        
        public String getMessage() {
            return message;
        }
        
        public abstract void display();
    }
    
    class EmailNotification extends Notification implements Sendable {
        private String recipient;
        
        public EmailNotification(String message, String recipient) {
            this.message = message;
            this.recipient = recipient;
        }
        
        public void display() {
            System.out.println("Email: " + message);
        }
        
        public void send() {
            System.out.println("Envoi email à " + recipient);
        }
        
        public String getRecipient() {
            return recipient;
        }
    }
    
    class SMSNotification extends Notification implements Sendable, Loggable {
        private String phoneNumber;
        
        public SMSNotification(String message, String phone) {
            super(message);
            this.phoneNumber = phone;
        }
        
        public void display() {
            System.out.println("SMS: " + getMessage() + " à " + phoneNumber);
        }
        
        public void send() {
            System.out.println("Envoi SMS");
        }
        
        public void log() {
            System.out.println("Log: SMS envoyé à " + phoneNumber);
        }
    }
    
    public class Main {
        public static void main(String[] args) {
            EmailNotification email = new EmailNotification("Réunion", "user@example.com");
            email.display();
            email.send();
            System.out.println("Priorité: " + email.priority);
            
            Notification notif = new SMSNotification("Alerte", "+41 79 123 45 67");
            notif.send();
        }
    }
    ```]
    
    *Partie A (12 points)* : Identification des erreurs
    
    Identifiez TOUTES les erreurs dans ce code (il y en a 6). Pour chaque erreur :
    1. Indiquez la classe/interface et la ligne/section concernée
    2. Expliquez pourquoi c'est une erreur
    3. Proposez la correction

    #colbreak()
    
    *Partie B (6 points)* : Prédiction d'exécution
    
    Considérez maintenant ce code qui utilise les classes *telles quelles* (avec les erreurs identifiées ci-dessus, mais en supposant qu'on a fait le minimum pour compiler) :
    
    #sourcecode[```java
    public class Test {
        public static void main(String[] args) {
            EmailNotification email = new EmailNotification("Test", "admin@heig-vd.ch");
            System.out.println(email.getMessage());
            email.priority = "HAUTE";
            System.out.println("Priorité définie: " + email.priority);
            
            SMSNotification sms = new SMSNotification("Code: 67", "+41 79 404 42 42");
            sms.display();
        }
    }
    ```]
    
    En supposant que nous avons corrigé uniquement les erreurs qui empêchent la compilation (mais pas les erreurs d'encapsulation), donnez la sortie complète de ce programme. Expliquez les valeurs affichées en lien avec les erreurs du code (notamment l'erreur sur le constructeur d'EmailNotification et l'attribut public priority).
  ],
  points: 18,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie A : Identification des erreurs (12 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *Erreur 1 (2 points) : Attribut priority est public au lieu de private*
    
    Classe Notification, ligne : `public String priority;`
    
    Problème : Viole le principe d'encapsulation. Les attributs doivent être privés, même dans une classe abstraite.
    
    Correction : `private String priority;` et ajouter getter/setter
    
    *Erreur 2 (2 points) : Constructeur ne stocke pas le paramètre message correctement*
    
    Classe Notification, ligne : `message = message;`
    
    Problème : Affectation du paramètre à lui-même. Il manque `this.` pour référencer l'attribut.
    
    Correction : `this.message = message;`
    
    *Erreur 3 (2 points) : Pas d'appel au constructeur parent et accès direct à attribut privé*
    
    Classe EmailNotification, constructeur : `this.message = message;`
    
    Problème : EmailNotification étend Notification mais n'appelle pas `super(message)`. De plus, `message` est privé dans Notification, donc inaccessible directement.
    
    Correction : Remplacer par `super(message);` comme première ligne
    
    *Erreur 4 (2 points) : Accès direct à l'attribut privé message de la classe parent*
    
    Classe EmailNotification, méthode display(), ligne : `"Email: " + message`
    
    Problème : `message` est privé dans Notification, inaccessible dans la classe fille.
    
    Correction : Utiliser `getMessage()` au lieu de `message` directement
    
    *Erreur 5 (2 points) : Méthode getRecipient() manquante dans SMSNotification*
    
    Classe SMSNotification
    
    Problème : SMSNotification implémente Sendable qui définit la méthode `getRecipient()`, mais cette méthode n'est pas implémentée. L'interface Sendable exige cette méthode.
    
    Correction : Ajouter la méthode `public String getRecipient() { return phoneNumber; }`
    
    *Erreur 6 (2 points) : Appel de méthode non définie par le type de référence*
    
    Classe Main, ligne : `notif.send();`
    
    Problème : `notif` est de type `Notification` (classe abstraite), et `send()` n'est pas définie dans Notification mais dans l'interface Sendable. On ne peut pas appeler `send()` sur une référence de type Notification.
    
    Correction : Soit changer le type en `Sendable notif = new SMSNotification(...)`, soit caster : `((Sendable) notif).send();`
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
    null
    Priorité définie: HAUTE
    SMS: Code: 67 à +41 79 404 42 42
    ```
    
    *Justifications détaillées :*
    
    *Ligne 1* : `null` (2 points)
    
    À cause de l'*erreur #3*, le constructeur d'EmailNotification fait `this.message = message` au lieu d'appeler `super(message)`. Mais `message` est privé dans Notification, donc inaccessible. Si on corrige juste pour compiler (en supprimant cette ligne), l'attribut `message` de Notification n'est jamais initialisé. De plus, l'*erreur #2* fait que même si on initialise, le constructeur de Notification ne stocke pas correctement le message. Donc `getMessage()` retourne `null`.
    
    *Ligne 2* : `Priorité définie: HAUTE` (2 points)
    
    À cause de l'*erreur #1*, l'attribut `priority` est `public` dans Notification. Cela viole l'encapsulation mais permet d'accéder directement à l'attribut avec `email.priority = "HAUTE"`. La valeur est correctement affectée et affichée. Cela démontre le problème des attributs publics : n'importe qui peut modifier l'état interne de l'objet.
    
    *Ligne 3* : `SMS: Code: 67 à +41 79 404 42 42` (2 points)
    
    SMSNotification appelle correctement `super(message)` dans son constructeur, donc le message est bien initialisé (malgré l'erreur #2 qui affecte comment Notification le stocke). La méthode `display()` utilise `getMessage()` pour accéder au message. Si on a corrigé l'erreur #2 pour la compilation, le message s'affiche correctement.
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 3 : Algorithmes de tri avancés - Compréhension
// ============================================================================

#question_types.question_statement(
  title: "Algorithmes de tri : Analyse et compréhension",
  statement: [
    *Partie A (6 points)* : Lecture et analyse de code
    
    Analysez le code de tri suivant :
    
    #sourcecode[```java
    public static void mysterySort(int[] array) {
        if (array.length <= 1) {
            return;
        }
        
        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];
        
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length; i++) {
            right[i - mid] = array[i];
        }
        
        mysterySort(left);
        mysterySort(right);
        merge(array, left, right);
    }
    
    public static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
    }
    ```]
    
    1. Quel algorithme de tri est implémenté ici ? (1 point)
    
    2. Expliquez en détail comment fonctionne cet algorithme (principe général de "diviser pour régner"). (3 points)
    
       _Note : Si vous n'avez pas pu identifier l'algorithme, vous pouvez expliquer le fonctionnement d'un algorithme de tri de votre choix pour obtenir des points partiels (2 points maximum)._
    
    3. Tracez l'exécution de cet algorithme sur le tableau `[42, 17, 67, 3]`. Montrez les divisions successives et les fusions. (2 points)
    
    *Partie B (8 points)* : Vrai ou Faux sur les algorithmes de tri
    
    Pour chacune des affirmations suivantes, indiquez si elle est VRAIE ou FAUSSE et justifiez brièvement votre réponse.
    
    1. Le tri par fusion nécessite de la mémoire supplémentaire pour créer des sous-tableaux temporaires. *(2 points)*
    
    2. Le tri par fusion est plus efficace que le tri à bulles même dans le pire des cas. *(2 points)*
    
    3. Le tri par fusion divise toujours le tableau en deux moitiés égales (ou presque égales). *(2 points)*
    
    4. Le tri à bulles sur un tableau déjà trié est plus rapide que le tri par fusion sur le même tableau. *(2 points)*
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
    *1. Algorithme identifié : Tri par fusion (Merge Sort) (1 point)*
    
    *2. Principe de fonctionnement (3 points) :*
    
    Le tri par fusion utilise la stratégie "diviser pour régner" :
    - *Diviser* : On divise le tableau en deux moitiés égales (ou presque)
    - *Régner* : On trie récursivement chaque moitié (appels récursifs)
    - *Fusionner* : On fusionne les deux moitiés triées en un seul tableau trié
    - La fusion compare les éléments des deux sous-tableaux et les place dans l'ordre
    - Cas de base : un tableau de 0 ou 1 élément est déjà trié
    - L'algorithme remonte récursivement en fusionnant les sous-tableaux triés
    
    *Critères d'évaluation :*
    - Mention de "diviser pour régner" et division en deux : 1 point
    - Explication de la récursion : 1 point
    - Explication de la fusion des sous-tableaux triés : 1 point
    
    *3. Traçage sur [42, 17, 67, 3] (2 points) :*
    
    *Phase de division :*
    ```
    [42, 17, 67, 3]
         ↓
    [42, 17]  [67, 3]     (division en 2)
       ↓         ↓
    [42] [17] [67] [3]    (sous-tableaux de taille 1)
    ```
    
    *Phase de fusion :*
    ```
    [42] [17]  →  [17, 42]  (fusion: 17 < 42)
    [67] [3]   →  [3, 67]   (fusion: 3 < 67)
    
    [17, 42] [3, 67]  →  [3, 17, 42, 67]
    ```
    
    Fusion finale détaillée :
    - Compare 17 et 3 → prend 3
    - Compare 17 et 67 → prend 17
    - Compare 42 et 67 → prend 42
    - Reste 67 → prend 67
    - Résultat : [3, 17, 42, 67]
    
    *(1 point pour la division correcte, 1 point pour les fusions)*
  ],
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie B : Vrai ou Faux (8 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *1. VRAI (2 points)*
    
    Le tri par fusion nécessite effectivement de la mémoire supplémentaire. À chaque division, il crée de nouveaux tableaux temporaires (left et right) pour stocker les sous-parties. Pendant la fusion, ces tableaux temporaires sont utilisés. Il faut donc de l'espace mémoire supplémentaire pour stocker ces sous-tableaux, contrairement au tri à bulles qui trie "en place" sans avoir besoin de tableaux temporaires.
    
    *(1 point pour VRAI, 1 point pour la justification)*
    
    *2. VRAI (2 points)*
    
    Le tri par fusion est plus efficace que le tri à bulles dans tous les cas (meilleur, moyen et pire cas). Grâce à sa stratégie "diviser pour régner", il divise le problème en sous-problèmes plus petits et effectue moins de comparaisons. Le tri à bulles, lui, doit comparer tous les éléments même dans le pire des cas, ce qui le rend beaucoup moins efficace sur de grandes quantités de données.
    
    *(1 point pour VRAI, 1 point pour la justification)*
    
    *3. VRAI (2 points)*
    
    Le tri par fusion divise toujours le tableau au milieu : `int mid = array.length / 2`. Si le tableau a un nombre pair d'éléments, les deux moitiés sont égales. Si le nombre est impair, une moitié a un élément de plus que l'autre. C'est un principe fondamental de l'algorithme : diviser en deux parties de taille similaire pour garantir une complexité équilibrée.
    
    *(1 point pour VRAI, 1 point pour la justification)*
    
    *4. FAUX (2 points)*
    
    Bien que le tri à bulles soit efficace sur un tableau déjà trié (avec optimisation d'arrêt anticipé, il peut s'arrêter rapidement), le tri par fusion maintient une performance prévisible. Pour de petits tableaux déjà triés, le tri à bulles peut être légèrement plus rapide en pratique car il évite les divisions et fusions récursives. Cependant, pour des tableaux plus grands, même triés, le tri par fusion reste compétitif car il effectue toujours un nombre raisonnable d'opérations grâce à sa structure. La réponse est FAUX car la différence n'est pas aussi significative qu'on pourrait le penser, surtout pour de grandes quantités de données.
    
    *(1 point pour FAUX, 1 point pour la justification)*
  ],
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Vous pouvez utiliser cet espace pour des notes ou des brouillons, ou compléter vos réponses aux questions précédentes.",
)
