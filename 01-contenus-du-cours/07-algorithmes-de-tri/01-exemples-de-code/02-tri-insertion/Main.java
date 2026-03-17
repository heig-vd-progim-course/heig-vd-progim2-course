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
     * @param array le tableau à trier
     * @return le tableau trié
     */
    public static int[] insertionSort(int[] array) {
        int n = array.length;
        
        // Pour chaque élément à partir du deuxième
        for (int i = 1; i < n; i++) {
            int elementToInsert = array[i];
            int j = i - 1;
            
            // Décaler les éléments plus grands vers la droite
            while (j >= 0 && array[j] > elementToInsert) {
                array[j + 1] = array[j];
                j--;
            }
            
            // Insérer l'élément à sa place
            array[j + 1] = elementToInsert;
        }
        
        return array;
    }
    
    /**
     * Affiche un tableau d'entiers
     * @param array le tableau à afficher
     */
    public static void displayArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        // Créer un tableau non trié
        int[] numbers = {7, 3, 9, 2, 8};
        
        System.out.println("=== Tri par insertion ===");
        System.out.print("Avant le tri : ");
        displayArray(numbers);
        
        // Trier le tableau
        numbers = insertionSort(numbers);
        
        System.out.print("Après le tri : ");
        displayArray(numbers);
    }
}
