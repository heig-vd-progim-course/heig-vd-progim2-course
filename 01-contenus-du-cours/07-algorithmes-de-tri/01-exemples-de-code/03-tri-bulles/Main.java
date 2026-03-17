/**
 * Exemple de tri à bulles (bubble sort)
 * 
 * Principe :
 * - Parcourir le tableau et comparer les éléments adjacents
 * - Échanger les éléments s'ils sont dans le mauvais ordre
 * - Les plus grandes valeurs "remontent" vers la fin comme des bulles
 * - Répéter jusqu'à ce qu'aucun échange ne soit nécessaire
 */
public class Main {
    
    /**
     * Trie un tableau d'entiers par bulles
     * @param tableau le tableau à trier
     */
    public static void triBulles(int[] tableau) {
        int n = tableau.length;
        boolean echange;
        
        // Répéter jusqu'à ce qu'aucun échange ne soit fait
        do {
            echange = false;
            
            // Parcourir le tableau
            for (int i = 0; i < n - 1; i++) {
                // Si deux éléments adjacents sont dans le mauvais ordre
                if (tableau[i] > tableau[i + 1]) {
                    // Les échanger
                    int temp = tableau[i];
                    tableau[i] = tableau[i + 1];
                    tableau[i + 1] = temp;
                    echange = true;
                }
            }
            
            // Réduire la zone à parcourir (le dernier élément est trié)
            n--;
        } while (echange);
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
        
        System.out.println("=== Tri à bulles ===");
        System.out.print("Avant le tri : ");
        afficherTableau(nombres);
        
        // Trier le tableau
        triBulles(nombres);
        
        System.out.print("Après le tri : ");
        afficherTableau(nombres);
    }
}
