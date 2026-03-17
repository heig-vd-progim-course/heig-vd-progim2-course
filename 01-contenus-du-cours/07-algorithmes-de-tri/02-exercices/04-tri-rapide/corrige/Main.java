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
 * Programme principal avec le tri rapide
 */
public class Main {
    
    /**
     * Trie un tableau de cartes par tri rapide (par valeur croissante)
     * @param cartes le tableau de cartes à trier
     * @param debut l'index de début
     * @param fin l'index de fin
     */
    public static void triRapide(Card[] cartes, int debut, int fin) {
        if (debut < fin) {
            // Partitionner et obtenir l'index du pivot
            int indexPivot = partitionner(cartes, debut, fin);
            
            // Trier récursivement les deux parties
            triRapide(cartes, debut, indexPivot - 1);
            triRapide(cartes, indexPivot + 1, fin);
        }
    }
    
    /**
     * Partitionne le tableau autour d'un pivot
     * @param cartes le tableau de cartes à partitionner
     * @param debut l'index de début
     * @param fin l'index de fin
     * @return l'index final du pivot
     */
    private static int partitionner(Card[] cartes, int debut, int fin) {
        // Choisir la dernière carte comme pivot
        int valeurPivot = cartes[fin].getValue();
        int i = debut - 1;
        
        // Placer les cartes avec valeur < pivot à gauche
        for (int j = debut; j < fin; j++) {
            if (cartes[j].getValue() < valeurPivot) {
                i++;
                // Échanger cartes[i] et cartes[j]
                Card temp = cartes[i];
                cartes[i] = cartes[j];
                cartes[j] = temp;
            }
        }
        
        // Placer le pivot à sa position finale
        Card temp = cartes[i + 1];
        cartes[i + 1] = cartes[fin];
        cartes[fin] = temp;
        
        return i + 1;
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
        
        System.out.println("=== Tri rapide de cartes ===");
        System.out.print("Avant le tri : ");
        afficherCartes(cartes);
        
        // Trier les cartes
        triRapide(cartes, 0, cartes.length - 1);
        
        System.out.print("Après le tri : ");
        afficherCartes(cartes);
    }
}
