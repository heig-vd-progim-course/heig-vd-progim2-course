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
 * Programme principal avec le tri fusion
 */
public class Main {
    
    /**
     * Trie un tableau de cartes par tri fusion (par valeur croissante)
     * @param cartes le tableau de cartes à trier
     * @param debut l'index de début
     * @param fin l'index de fin
     */
    public static void triFusion(Card[] cartes, int debut, int fin) {
        if (debut < fin) {
            // Trouver le milieu
            int milieu = (debut + fin) / 2;
            
            // Trier récursivement les deux moitiés
            triFusion(cartes, debut, milieu);
            triFusion(cartes, milieu + 1, fin);
            
            // Fusionner les deux moitiés triées
            fusionner(cartes, debut, milieu, fin);
        }
    }
    
    /**
     * Fusionne deux parties triées d'un tableau
     * @param cartes le tableau contenant les deux parties
     * @param debut l'index de début de la première partie
     * @param milieu l'index de fin de la première partie
     * @param fin l'index de fin de la deuxième partie
     */
    private static void fusionner(Card[] cartes, int debut, int milieu, int fin) {
        // Calculer les tailles des deux parties
        int tailleGauche = milieu - debut + 1;
        int tailleDroite = fin - milieu;
        
        // Créer des tableaux temporaires
        Card[] gauche = new Card[tailleGauche];
        Card[] droite = new Card[tailleDroite];
        
        // Copier les données dans les tableaux temporaires
        for (int i = 0; i < tailleGauche; i++) {
            gauche[i] = cartes[debut + i];
        }
        for (int j = 0; j < tailleDroite; j++) {
            droite[j] = cartes[milieu + 1 + j];
        }
        
        // Fusionner les tableaux temporaires dans le tableau original
        int i = 0; // Index du tableau gauche
        int j = 0; // Index du tableau droite
        int k = debut; // Index du tableau fusionné
        
        while (i < tailleGauche && j < tailleDroite) {
            if (gauche[i].getValue() <= droite[j].getValue()) {
                cartes[k] = gauche[i];
                i++;
            } else {
                cartes[k] = droite[j];
                j++;
            }
            k++;
        }
        
        // Copier les cartes restantes de gauche, s'il y en a
        while (i < tailleGauche) {
            cartes[k] = gauche[i];
            i++;
            k++;
        }
        
        // Copier les cartes restantes de droite, s'il y en a
        while (j < tailleDroite) {
            cartes[k] = droite[j];
            j++;
            k++;
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
        
        System.out.println("=== Tri fusion de cartes ===");
        System.out.print("Avant le tri : ");
        afficherCartes(cartes);
        
        // Trier les cartes
        triFusion(cartes, 0, cartes.length - 1);
        
        System.out.print("Après le tri : ");
        afficherCartes(cartes);
    }
}
