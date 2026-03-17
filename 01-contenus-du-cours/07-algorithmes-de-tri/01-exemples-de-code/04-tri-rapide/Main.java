/**
 * Exemple de tri rapide (quicksort)
 * 
 * Principe :
 * - Choisir un pivot
 * - Partitionner : placer les éléments < pivot à gauche, > pivot à droite
 * - Trier récursivement les deux parties
 */
public class Main {
    
    /**
     * Trie un tableau d'entiers par tri rapide
     * @param tableau le tableau à trier
     * @param debut l'index de début
     * @param fin l'index de fin
     */
    public static void triRapide(int[] tableau, int debut, int fin) {
        if (debut < fin) {
            // Partitionner et obtenir l'index du pivot
            int indexPivot = partitionner(tableau, debut, fin);
            
            // Trier récursivement les deux parties
            triRapide(tableau, debut, indexPivot - 1);
            triRapide(tableau, indexPivot + 1, fin);
        }
    }
    
    /**
     * Partitionne le tableau autour d'un pivot
     * @param tableau le tableau à partitionner
     * @param debut l'index de début
     * @param fin l'index de fin
     * @return l'index final du pivot
     */
    private static int partitionner(int[] tableau, int debut, int fin) {
        // Choisir le dernier élément comme pivot
        int pivot = tableau[fin];
        int i = debut - 1;
        
        // Placer les éléments plus petits que le pivot à gauche
        for (int j = debut; j < fin; j++) {
            if (tableau[j] < pivot) {
                i++;
                // Échanger tableau[i] et tableau[j]
                int temp = tableau[i];
                tableau[i] = tableau[j];
                tableau[j] = temp;
            }
        }
        
        // Placer le pivot à sa position finale
        int temp = tableau[i + 1];
        tableau[i + 1] = tableau[fin];
        tableau[fin] = temp;
        
        return i + 1;
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
        
        System.out.println("=== Tri rapide ===");
        System.out.print("Avant le tri : ");
        afficherTableau(nombres);
        
        // Trier le tableau
        triRapide(nombres, 0, nombres.length - 1);
        
        System.out.print("Après le tri : ");
        afficherTableau(nombres);
    }
}
