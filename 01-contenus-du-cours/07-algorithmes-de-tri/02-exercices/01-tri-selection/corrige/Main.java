/**
 * Classe représentant une carte à jouer
 */
class Card {
    private int value;    // Valeur de la carte (1-13)
    private char suit;    // Couleur : ♠ ♥ ♦ ♣
    
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
     * @param cartes le tableau de cartes à trier
     */
    public static void triSelection(Card[] cartes) {
        int n = cartes.length;
        
        // Pour chaque position
        for (int i = 0; i < n - 1; i++) {
            // Chercher la carte avec la plus petite valeur
            int indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if (cartes[j].getValue() < cartes[indexMin].getValue()) {
                    indexMin = j;
                }
            }
            
            // Échanger la carte trouvée avec la carte à la position i
            Card temp = cartes[i];
            cartes[i] = cartes[indexMin];
            cartes[indexMin] = temp;
        }
    }
    
    /**
     * Affiche un tableau de cartes
     * @param cartes le tableau à afficher
     */
    public static void afficherCartes(Card[] cartes) {
        System.out.print("[");
        for (int i = 0; i < cartes.length; i++) {
            System.out.print(cartes[i]);
            if (i < cartes.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Créer un tableau de cartes mélangées
        Card[] cartes = {
            new Card(7, '♥'),
            new Card(3, '♠'),
            new Card(9, '♦'),
            new Card(2, '♣'),
            new Card(8, '♥')
        };
        
        System.out.println("=== Tri par sélection de cartes ===");
        System.out.print("Avant le tri : ");
        afficherCartes(cartes);
        
        // Trier les cartes
        triSelection(cartes);
        
        System.out.print("Après le tri : ");
        afficherCartes(cartes);
    }
}
