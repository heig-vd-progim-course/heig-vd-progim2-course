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
 * Programme principal avec le tri à bulles
 */
public class Main {
    
    /**
     * Trie un tableau de cartes par bulles (par valeur croissante)
     * @param cards le tableau de cartes à trier
     * @return le tableau trié
     */
    public static Card[] bubbleSort(Card[] cards) {
        int n = cards.length;
        boolean swapped;
        
        // Répéter jusqu'à ce qu'aucun échange ne soit fait
        do {
            swapped = false;
            
            // Parcourir le tableau
            for (int i = 0; i < n - 1; i++) {
                // Si deux cartes adjacentes sont dans le mauvais ordre
                if (cards[i].getValue() > cards[i + 1].getValue()) {
                    // Les échanger
                    Card temp = cards[i];
                    cards[i] = cards[i + 1];
                    cards[i + 1] = temp;
                    swapped = true;
                }
            }
            
            // Réduire la zone à parcourir (la dernière carte est triée)
            n--;
        } while (swapped);
        
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
        
        System.out.println("=== Tri à bulles de cartes ===");
        System.out.print("Avant le tri : ");
        displayCards(cards);
        
        // Trier les cartes
        cards = bubbleSort(cards);
        
        System.out.print("Après le tri : ");
        displayCards(cards);
    }
}
