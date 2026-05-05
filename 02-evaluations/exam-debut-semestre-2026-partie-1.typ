#import "@preview/codelst:2.0.2": sourcecode
#import "@local/heig-vd-evaluations-and-exams-template:0.1.0": conf, question_types
#set text(font: "Atkinson Hyperlegible")

#let parts = (
  ("Question 1", 16),
  ("Question 2", 16),
  ("Question 3", 16),
)

#let additional_information = [

  Vous n'avez pas le droit à des pages de résumé pour cette partie.

  Vous pouvez répondre aux questions en français ou en anglais.

  Toute tentative de triche sera sanctionnée par la note de 1.

  _Examen préparé avec l'aide d'Hadrien Louis, GitHub Copilot et Claude (Anthropic)._
]

#show: doc => conf(
  evaluation_title: "Programmation Ingénierie des Médias 2 (ProgIM2)",
  evaluation_subtitle: [ProgIM2 - VGX - Partie 1#if "room" in sys.inputs [ (Salle #sys.inputs.room)]],
  evaluation_date: "01.04.2026",
  duration: "5 minutes pour lire cette partie (9h15 à 9h20), puis 45 minutes pour répondre (9h20 à 10h05). Vous pouvez demander la Partie 2 avant la fin du temps imparti. Ensuite, vous aurez 5 minutes pour lire la Partie 2 (10h05 à 10h10), puis vous commencerez directement (10h10 à 11h40).",
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
  title: "Algèbre de Boole : Système de gestion de sécurité",
  statement: [
    Un système de sécurité pour un bâtiment utilise différentes conditions pour contrôler l'accès.
    
    *Partie A (10 points)* : Analysez le code suivant et répondez aux questions :
    
    #sourcecode[```java
    public class SecuritySystem {
        
        public static boolean checkAccess(
              boolean hasBadge,
              boolean hasCode, 
              boolean isWorkingHours,
              boolean isWeekend, 
              boolean isEmergency
        ) {
            boolean normalAccess = hasBadge && hasCode && isWorkingHours;
            boolean weekendAccess = hasBadge && !isWeekend;
            boolean emergencyAccess = isEmergency || (hasBadge && hasCode);
            boolean accessBlocked = !(hasBadge || hasCode);
            
            boolean finalAccess = (normalAccess || weekendAccess || emergencyAccess) 
                                  && !accessBlocked;
            
            return finalAccess;
        }
        
        public static void main(String[] args) {
            boolean result1 = checkAccess(true, false, true, false, false);
            System.out.println("Situation 1 - Accès : " + result1);
            
            boolean result2 = checkAccess(false, true, false, true, false);
            System.out.println("Situation 2 - Accès : " + result2);
        }
    }
    ```]
    
    Pour les deux appels de la méthode `checkAccess` :
    
    *Situation 1* : `checkAccess(true, false, true, false, false)`

    Donnez les valeurs de `normalAccess`, `weekendAccess`, `emergencyAccess`, `accessBlocked` et `finalAccess`. (4.5 points)
    
    *Situation 2* : `checkAccess(false, true, false, true, false)`

    Donnez les valeurs de `normalAccess`, `weekendAccess`, `emergencyAccess`, `accessBlocked` et `finalAccess`. (4.5 points)
    
    Que sera affiché dans la console pour les deux situations ? (1 point)
    
    *Partie B (3 points)* : Application des lois de De Morgan
    
    Écrivez les expressions suivantes en appliquant les lois de De Morgan :
    1. `!(hasBadge && hasCode)` (1.5 point)
    2. `!(!isEmergency || !isWeekend)` (1.5 point)

    #colbreak()
    
    *Partie C (3 points)* : Nouvelle règle d'accès
    
    Écrivez une expression booléenne (sans valeurs prédéfinies) pour cette nouvelle règle : l'accès VIP est accordé si la personne a un badge ET un code. Cette expression ne dépend PAS des autres paramètres (horaire, jour, urgence). (3 points)
  ],
  points: 16,
)

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Partie A : Analyse du code (10 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *Situation 1* : `checkAccess(true, false, true, false, false)`
    
    1. `normalAccess = false` (car `hasCode = false`)
    
    2. `weekendAccess = true` (car `hasBadge = true` et `!isWeekend = true`)
    
    3. `emergencyAccess = false` (car `isEmergency = false` et `hasBadge && hasCode = false`)
    
    4. `accessBlocked = false` (car `!(true || false) = !true = false`)
    
    5. `finalAccess = true` (car `(false || true || false) && !false = true && true = true`)
    
    *Situation 2* : `checkAccess(false, true, false, true, false)`
    
    - `normalAccess = false`
    - `weekendAccess = false`
    - `emergencyAccess = false`
    - `accessBlocked = false`
    - `finalAccess = false`
    
    6. Affichage console :
    ```
    Situation 1 - Accès : true
    Situation 2 - Accès : false
    ```
  ],
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  height_cm: 11cm,
  margin_bottom: 0cm,
  icon_text: "Partie B : Application des lois de De Morgan (3 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    1. `!(hasBadge && hasCode)` = `!hasBadge || !hasCode` (loi de De Morgan)
    
    2. `!(!isEmergency || !isWeekend)` = `isEmergency && isWeekend` (loi de De Morgan)
  ],
)

#question_types.answer_bloc_with_icon(
  height_cm: 11cm,
  margin_bottom: 0cm,
  icon_text: "Partie C : Nouvelle règle d'accès (3 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    ```java
    boolean vipAccess = hasBadge && hasCode;
    ```
  ],
)

#pagebreak()


#align(center)[Page laissée vide]

#pagebreak()

// ============================================================================
// QUESTION 2 : Programmation Orientée Objet - Débogage
// ============================================================================

#question_types.question_statement(
  title: "POO : Débogage d'un système de produits",
  statement: [
    Le code suivant contient plusieurs erreurs. Analysez-le et répondez aux questions.
    
    #sourcecode[```java
    class Product {
        private String name;
        public double price;
        
        public Product(String name, double price) {
            name = name;
            price = price;
        }
        
        public String getInfo() {
            return name + " : " + price + " CHF";
        }
    }
    class ElectronicProduct extends Product {
        private int warranty;
        
        public ElectronicProduct(String name, double price, int warranty) {
            this.warranty = warranty;
        }
        
        public String getInfo() {
            return name + " : " + price + " CHF (Garantie: " + warranty + " ans)";
        }
    }
    public class Main {
        public static void main(String[] args) {
            Product p1 = new ElectronicProduct("Laptop", 1200.0, 2);
            System.out.println(p1.getInfo());
            
            ElectronicProduct p2 = new ElectronicProduct("Phone", 800.0, 1);
            p2.price = 750.0;
            System.out.println(p2.getInfo());
        }
    }
    ```]
    
    *Partie A (12 points)* : Identifiez 6 erreurs dans ce code. Pour chaque erreur, indiquez :
    - La classe et la ligne concernée (1 point)
    - Pourquoi c'est une erreur (1 point)
    
    *Partie B (4 points)* : Prédiction d'exécution
    
    Considérez le code suivant. _Note : ce code utilise la classe `Product` de la partie A. Supposez que les erreurs de la partie A ont été corrigées._
    
    #sourcecode[```java
        public static void main(String[] args) {
            Product p1 = new Product("Tablette", 500.0);
            System.out.println(p1.getInfo());
            
            Product p2 = new Product("Laptop", 1200.0);
            System.out.println(p2.getInfo());
        }
    ```]
    
    Que sera affiché dans la console ? (4 points)
  ],
  points: 16,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  height_cm: 15cm,
  margin_bottom: 0cm,
  icon_text: "Partie A : Identification des erreurs (12 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    *Erreur 1 :* Product, constructeur `name = name;` - Pas de `this.`, le paramètre s'assigne à lui-même
    
    *Erreur 2 :* Product, `public double price;` - L'attribut devrait être privé (encapsulation)
    
    *Erreur 3 :* ElectronicProduct, constructeur - Pas d'appel à `super(name, price)` pour initialiser la classe parent
    
    *Erreur 4 :* ElectronicProduct, méthode getInfo() - Accès direct à `name` qui est privé dans Product
    
    *Erreur 5 :* ElectronicProduct, méthode getInfo() - Manque `@Override` (bonne pratique)
    
    *Erreur 6 :* Main, ligne `p2.price = 750.0;` - Accès direct à un attribut qui devrait être privé
  ],
)


#question_types.answer_bloc_with_icon(
  height_cm: 6cm,
  margin_bottom: 0cm,
  icon_text: "Partie B : Prédiction d'exécution (4 points)",
  show_official_answer: show_official_answer,
  official_answer: [
    Sortie console :
    ```
    Tablette : 500.0 CHF
    Laptop : 1200.0 CHF
    ```
  ],
)

#pagebreak()

// ============================================================================
// QUESTION 3 : Tri à bulles - Compréhension de base
// ============================================================================

#question_types.question_statement(
  title: "Algorithmes de tri : Tri à bulles",
  statement: [
    Voici un tableau d'entiers : `[5, 2, 8, 1, 9]`
    
    Appliquez le tri à bulles (bubble sort) sur ce tableau. Complétez le tableau ci-dessous en indiquant l'état du tableau après chaque passage complet et ajoutez un commentaire pour expliquer ce qui s'est passé pendant ce passage.
    
    _Note : Le tableau contient plus de lignes que nécessaire. Vous n'avez pas besoin de remplir toutes les lignes._
    
    #table(
      columns: (1fr, 2fr, 3fr),
      align: (center, center, left),
      table.header(
        [*Passage*],
        [*État du tableau*],
        [*Commentaire*],
      ),
      [Initial], [`[5, 2, 8, 1, 9]`], [État de départ],
      [1], [`[2, 5, 8, 1, 9]`], [Comparaison 5 et 2, échange car 5 > 2],
      [2], [`[2, 5, 8, 1, 9]`], [Comparaison 5 et 8, pas d'échange],
      [3], [`[2, 5, 1, 8, 9]`], [Comparaison 8 et 1, échange car 8 > 1],
      [4], [`[2, 5, 1, 8, 9]`], [Comparaison 8 et 9, pas d'échange],
      [5], [`[2, 5, 1, 8, 9]`], [Fin du passage 1, le plus grand élément (9) est à sa place],
      [6], [`[2, 5, 1, 8, 9]`], [Comparaison 2 et 5, pas d'échange],
      [7], [`[2, 5, 1, 8, 9]`], [Comparaison 5 et 1, échange car 5 > 1],
      [8], [`[2, 1, 5, 8, 9]`], [Comparaison 5 et 8, pas d'échange],
      [9], [`[2, 1, 5, 8, 9]`], [Fin du passage 2, le deuxième plus grand élément (8) est à sa place],
      [10], [`[1, 2, 5, 8, 9]`], [Comparaison 2 et 1, échange car 2 > 1],
      [11], [`[1, 2, 5, 8, 9]`], [Comparaison 2 et 5, pas d'échange],
      [12], [`[1, 2, 5, 8, 9]`], [Fin du passage 3, le troisième plus grand élément (5) est à sa place],
      [13], [`[1, 2, 5, 8, 9]`], [Comparaison 1 et 2, pas d'échange],
      [14], [`[1, 2, 5, 8, 9]`], [Fin du passage 4, le quatrième plus grand élément (2) est à sa place],
      [15], [`[1, 2, 5, 8, 9]`], [Fin du passage 5, le tableau est trié],

    )
    
    (-8 points si vous n'avez pas parlé de tous les éléments suivants dans vos commentaires : comparaison, échange ou pas d'échange)
    (-4 points si le premier passage n'est pas détaillé et que le 8 et le 9 ont été traités comme s'ils étaient déjà à leur place)
  ],
  points: 16,
)

#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Vous pouvez utiliser cet espace pour des notes ou des brouillons, ou compléter vos réponses aux questions précédentes.",
)
#pagebreak()

#question_types.answer_bloc_with_icon(
  margin_bottom: 0cm,
  icon_text: "Vous pouvez utiliser cet espace pour des notes ou des brouillons, ou compléter vos réponses aux questions précédentes.",
)
 