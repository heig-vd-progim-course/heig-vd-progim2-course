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
     * @param array le tableau à trier
     * @return le tableau trié
     */
    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        boolean swapped;
        
        // Répéter jusqu'à ce qu'aucun échange ne soit fait
        do {
            swapped = false;
            
            // Parcourir le tableau
            for (int i = 0; i < n - 1; i++) {
                // Si deux éléments adjacents sont dans le mauvais ordre
                if (array[i] > array[i + 1]) {
                    // Les échanger
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
            
            // Réduire la zone à parcourir (le dernier élément est trié)
            n--;
        } while (swapped);
        
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
        
        System.out.println("=== Tri à bulles ===");
        System.out.print("Avant le tri : ");
        displayArray(numbers);
        
        // Trier le tableau
        numbers = bubbleSort(numbers);
        
        System.out.print("Après le tri : ");
        displayArray(numbers);
    }
}
