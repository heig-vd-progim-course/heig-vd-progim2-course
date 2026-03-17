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
 * Programme principal avec le tri par sélection
 */
public class Main {
    
    /**
     * Trie un tableau de cartes par sélection (par valeur croissante)
     * @param cards le tableau de cartes à trier
     * @return le tableau trié
     */
    public static Card[] selectionSort(Card[] cards) {
        int n = cards.length;
        
        // Pour chaque position
        for (int i = 0; i < n - 1; i++) {
            // Chercher la carte avec la plus petite valeur
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (cards[j].getValue() < cards[minIndex].getValue()) {
                    minIndex = j;
                }
            }
            
            // Échanger la carte trouvée avec la carte à la position i
            Card temp = cards[i];
            cards[i] = cards[minIndex];
            cards[minIndex] = temp;
        }
        
        return cards;
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
        
        System.out.println("=== Tri par sélection de cartes ===");
        System.out.print("Avant le tri : ");
        displayCards(cards);
        
        // Trier les cartes
        cards = selectionSort(cards);
        
        System.out.print("Après le tri : ");
        displayCards(cards);
    }
}
