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
     * @param array le tableau à trier
     * @param start l'index de début
     * @param end l'index de fin
     * @return le tableau trié
     */
    public static int[] quickSort(int[] array, int start, int end) {
        if (start < end) {
            // Partitionner et obtenir l'index du pivot
            int pivotIndex = partition(array, start, end);
            
            // Trier récursivement les deux parties
            quickSort(array, start, pivotIndex - 1);
            quickSort(array, pivotIndex + 1, end);
        }
        
        return array;
    }
    
    /**
     * Partitionne le tableau autour d'un pivot
     * @param array le tableau à partitionner
     * @param start l'index de début
     * @param end l'index de fin
     * @return l'index final du pivot
     */
    private static int partition(int[] array, int start, int end) {
        // Choisir le dernier élément comme pivot
        int pivot = array[end];
        int i = start - 1;
        
        // Placer les éléments plus petits que le pivot à gauche
        for (int j = start; j < end; j++) {
            if (array[j] < pivot) {
                i++;
                // Échanger array[i] et array[j]
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        
        // Placer le pivot à sa position finale
        int temp = array[i + 1];
        array[i + 1] = array[end];
        array[end] = temp;
        
        return i + 1;
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
        
        System.out.println("=== Tri rapide ===");
        System.out.print("Avant le tri : ");
        displayArray(numbers);
        
        // Trier le tableau
        numbers = quickSort(numbers, 0, numbers.length - 1);
        
        System.out.print("Après le tri : ");
        displayArray(numbers);
    }
}
