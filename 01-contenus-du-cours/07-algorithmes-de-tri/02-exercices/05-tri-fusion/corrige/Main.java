/**
 * Classe représentant une carte à jouer
 */
class Card {
    private final int value;    // Valeur de la carte (1-13)
    private final char suit;    // Couleur : ♠ ♥ ♦ ♣
    
    /**
     * Constructeur
     * @param value la valeur de la carte (1 = As, 11 = Valet, 12 = Dame, 13 = Roi)
     * @param suit la couleur de la carte (♠ ♥ ♦ ♣)
     */
    public Card(int value, char suit) {
        this.value = value;
        this.suit = suit;
    }
    
    /**
     * Retourne la valeur de la carte
     * @return la valeur (1-13)
     */
    public int getValue() {
        return value;
    }
    
    /**
     * Retourne la couleur de la carte
     * @return la couleur (♠ ♥ ♦ ♣)
     */
    public char getSuit() {
        return suit;
    }
    
    /**
     * Représentation textuelle de la carte
     * @return une chaîne comme "7♥"
     */
    @Override
    public String toString() {
        return value + "" + suit;
    }
}

/**
 * Programme principal avec le tri fusion
 */
public class Main {
    
    /**
     * Trie un tableau de cartes par tri fusion (par valeur croissante)
     * @param cards le tableau de cartes à trier
     * @param start l'index de début
     * @param end l'index de fin
     */
    public static void mergeSort(Card[] cards, int start, int end) {
        if (start < end) {
            // Trouver le milieu
            int middle = (start + end) / 2;
            
            // Trier récursivement les deux moitiés
            mergeSort(cards, start, middle);
            mergeSort(cards, middle + 1, end);
            
            // Fusionner les deux moitiés triées
            merge(cards, start, middle, end);
        }
    }
    
    /**
     * Fusionne deux parties triées d'un tableau
     * @param cards le tableau contenant les deux parties
     * @param start l'index de début de la première partie
     * @param middle l'index de fin de la première partie
     * @param end l'index de fin de la deuxième partie
     */
    private static void merge(Card[] cards, int start, int middle, int end) {
        // Calculer les tailles des deux parties
        int leftSize = middle - start + 1;
        int rightSize = end - middle;
        
        // Créer des tableaux temporaires
        Card[] left = new Card[leftSize];
        Card[] right = new Card[rightSize];
        
        // Copier les données dans les tableaux temporaires
        for (int i = 0; i < leftSize; i++) {
            left[i] = cards[start + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = cards[middle + 1 + j];
        }
        
        // Fusionner les tableaux temporaires dans le tableau original
        int i = 0; // Index du tableau gauche
        int j = 0; // Index du tableau droite
        int k = start; // Index du tableau fusionné
        
        while (i < leftSize && j < rightSize) {
            if (left[i].getValue() <= right[j].getValue()) {
                cards[k] = left[i];
                i++;
            } else {
                cards[k] = right[j];
                j++;
            }
            k++;
        }
        
        // Copier les cartes restantes de gauche, s'il y en a
        while (i < leftSize) {
            cards[k] = left[i];
            i++;
            k++;
        }
        
        // Copier les cartes restantes de droite, s'il y en a
        while (j < rightSize) {
            cards[k] = right[j];
            j++;
            k++;
        }
    }
    
    /**
     * Affiche un tableau de cartes
     * @param cards le tableau à afficher
     */
    public static void displayCards(Card[] cards) {
        System.out.print("[");
        for (int i = 0; i < cards.length; i++) {
            System.out.print(cards[i]);
            if (i < cards.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Créer un tableau de cartes mélangées
        Card[] cards = {
            new Card(7, '♥'),
            new Card(3, '♠'),
            new Card(9, '♦'),
            new Card(2, '♣'),
            new Card(8, '♥')
        };
        
        System.out.println("=== Tri fusion de cartes ===");
        System.out.print("Avant le tri : ");
        displayCards(cards);
        
        // Trier les cartes
        mergeSort(cards, 0, cards.length - 1);
        
        System.out.print("Après le tri : ");
        displayCards(cards);
    }
}
