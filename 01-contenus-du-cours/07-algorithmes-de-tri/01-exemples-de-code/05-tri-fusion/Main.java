/**
 * Exemple de tri fusion (mergesort)
 * 
 * Principe :
 * - Diviser le tableau en deux moitiés
 * - Trier récursivement chaque moitié
 * - Fusionner les deux moitiés triées
 */
public class Main {
    
    /**
     * Trie un tableau d'entiers par tri fusion
     * @param tableau le tableau à trier
     * @param debut l'index de début
     * @param fin l'index de fin
     */
    public static void triFusion(int[] tableau, int debut, int fin) {
        if (debut < fin) {
            // Trouver le milieu
            int milieu = (debut + fin) / 2;
            
            // Trier récursivement les deux moitiés
            triFusion(tableau, debut, milieu);
            triFusion(tableau, milieu + 1, fin);
            
            // Fusionner les deux moitiés triées
            fusionner(tableau, debut, milieu, fin);
        }
    }
    
    /**
     * Fusionne deux parties triées d'un tableau
     * @param tableau le tableau contenant les deux parties
     * @param debut l'index de début de la première partie
     * @param milieu l'index de fin de la première partie
     * @param fin l'index de fin de la deuxième partie
     */
    private static void fusionner(int[] tableau, int debut, int milieu, int fin) {
        // Calculer les tailles des deux parties
        int tailleGauche = milieu - debut + 1;
        int tailleDroite = fin - milieu;
        
        // Créer des tableaux temporaires
        int[] gauche = new int[tailleGauche];
        int[] droite = new int[tailleDroite];
        
        // Copier les données dans les tableaux temporaires
        for (int i = 0; i < tailleGauche; i++) {
            gauche[i] = tableau[debut + i];
        }
        for (int j = 0; j < tailleDroite; j++) {
            droite[j] = tableau[milieu + 1 + j];
        }
        
        // Fusionner les tableaux temporaires dans le tableau original
        int i = 0; // Index du tableau gauche
        int j = 0; // Index du tableau droite
        int k = debut; // Index du tableau fusionné
        
        while (i < tailleGauche && j < tailleDroite) {
            if (gauche[i] <= droite[j]) {
                tableau[k] = gauche[i];
                i++;
            } else {
                tableau[k] = droite[j];
                j++;
            }
            k++;
        }
        
        // Copier les éléments restants de gauche, s'il y en a
        while (i < tailleGauche) {
            tableau[k] = gauche[i];
            i++;
            k++;
        }
        
        // Copier les éléments restants de droite, s'il y en a
        while (j < tailleDroite) {
            tableau[k] = droite[j];
            j++;
            k++;
        }
    }
    
    /**
     * Affiche un tableau d'entiers
     * @param tableau le tableau à afficher
     */
    public static void afficherTableau(int[] tableau) {
        System.out.print("[");
        for (int i = 0; i < tableau.length; i++) {
            System.out.print(tableau[i]);
            if (i < tableau.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Créer un tableau non trié
        int[] nombres = {7, 3, 9, 2, 8};
        
        System.out.println("=== Tri fusion ===");
        System.out.print("Avant le tri : ");
        afficherTableau(nombres);
        
        // Trier le tableau
        triFusion(nombres, 0, nombres.length - 1);
        
        System.out.print("Après le tri : ");
        afficherTableau(nombres);
    }
}
