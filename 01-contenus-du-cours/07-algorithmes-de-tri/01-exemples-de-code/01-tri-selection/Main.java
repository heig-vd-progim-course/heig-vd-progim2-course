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
     * @param array le tableau à trier
     * @return le tableau trié
     */
    public static int[] selectionSort(int[] array) {
        int n = array.length;
        
        // Pour chaque position
        for (int i = 0; i < n - 1; i++) {
            // Chercher le minimum dans la partie non triée
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            
            // Échanger le minimum trouvé avec l'élément à la position i
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
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
        
        System.out.println("=== Tri par sélection ===");
        System.out.print("Avant le tri : ");
        displayArray(numbers);
        
        // Trier le tableau
        numbers = selectionSort(numbers);
        
        System.out.print("Après le tri : ");
        displayArray(numbers);
    }
}
