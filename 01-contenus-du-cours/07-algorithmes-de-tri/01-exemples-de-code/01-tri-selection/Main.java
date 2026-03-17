/**
 * Exemple de tri par sélection (selection sort)
 * 
 * Principe :
 * - Chercher le plus petit élément et le placer au début
 * - Chercher le plus petit parmi les éléments restants et le placer en deuxième position
 * - Continuer jusqu'à ce que tous les éléments soient triés
 */
public class Main {
    
    /**
     * Trie un tableau d'entiers par sélection
     * @param tableau le tableau à trier
     */
    public static void triSelection(int[] tableau) {
        int n = tableau.length;
        
        // Pour chaque position
        for (int i = 0; i < n - 1; i++) {
            // Chercher le minimum dans la partie non triée
            int indexMin = i;
            for (int j = i + 1; j < n; j++) {
                if (tableau[j] < tableau[indexMin]) {
                    indexMin = j;
                }
            }
            
            // Échanger le minimum trouvé avec l'élément à la position i
            int temp = tableau[i];
            tableau[i] = tableau[indexMin];
            tableau[indexMin] = temp;
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
        
        System.out.println("=== Tri par sélection ===");
        System.out.print("Avant le tri : ");
        afficherTableau(nombres);
        
        // Trier le tableau
        triSelection(nombres);
        
        System.out.print("Après le tri : ");
        afficherTableau(nombres);
    }
}
