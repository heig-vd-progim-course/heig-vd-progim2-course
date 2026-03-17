/**
 * Exemple de tri par insertion (insertion sort)
 * 
 * Principe :
 * - Construire progressivement une partie triée
 * - Prendre chaque élément et l'insérer à sa place dans la partie triée
 * - Semblable au tri de cartes dans la main
 */
public class Main {
    
    /**
     * Trie un tableau d'entiers par insertion
     * @param tableau le tableau à trier
     */
    public static void triInsertion(int[] tableau) {
        int n = tableau.length;
        
        // Pour chaque élément à partir du deuxième
        for (int i = 1; i < n; i++) {
            int elementAInserer = tableau[i];
            int j = i - 1;
            
            // Décaler les éléments plus grands vers la droite
            while (j >= 0 && tableau[j] > elementAInserer) {
                tableau[j + 1] = tableau[j];
                j--;
            }
            
            // Insérer l'élément à sa place
            tableau[j + 1] = elementAInserer;
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
        
        System.out.println("=== Tri par insertion ===");
        System.out.print("Avant le tri : ");
        afficherTableau(nombres);
        
        // Trier le tableau
        triInsertion(nombres);
        
        System.out.print("Après le tri : ");
        afficherTableau(nombres);
    }
}
