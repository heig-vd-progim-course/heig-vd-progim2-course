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
 * Programme principal avec le tri rapide
 */
public class Main {
    
    /**
     * Trie un tableau de cartes par tri rapide (par valeur croissante)
     * @param cards le tableau de cartes à trier
     * @param start l'index de début
     * @param end l'index de fin
     */
    public static void quickSort(Card[] cards, int start, int end) {
        if (start < end) {
            // Partitionner et obtenir l'index du pivot
            int pivotIndex = partition(cards, start, end);
            
            // Trier récursivement les deux parties
            quickSort(cards, start, pivotIndex - 1);
            quickSort(cards, pivotIndex + 1, end);
        }
    }
    
    /**
     * Partitionne le tableau autour d'un pivot
     * @param cards le tableau de cartes à partitionner
     * @param start l'index de début
     * @param end l'index de fin
     * @return l'index final du pivot
     */
    private static int partition(Card[] cards, int start, int end) {
        // Choisir la dernière carte comme pivot
        int pivotValue = cards[end].getValue();
        int i = start - 1;
        
        // Placer les cartes avec valeur < pivot à gauche
        for (int j = start; j < end; j++) {
            if (cards[j].getValue() < pivotValue) {
                i++;
                // Échanger cards[i] et cards[j]
                Card temp = cards[i];
                cards[i] = cards[j];
                cards[j] = temp;
            }
        }
        
        // Placer le pivot à sa position finale
        Card temp = cards[i + 1];
        cards[i + 1] = cards[end];
        cards[end] = temp;
        
        return i + 1;
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
        
        System.out.println("=== Tri rapide de cartes ===");
        System.out.print("Avant le tri : ");
        displayCards(cards);
        
        // Trier les cartes
        quickSort(cards, 0, cards.length - 1);
        
        System.out.print("Après le tri : ");
        displayCards(cards);
    }
}
