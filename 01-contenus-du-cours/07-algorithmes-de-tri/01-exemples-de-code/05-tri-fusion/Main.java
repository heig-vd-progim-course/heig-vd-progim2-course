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
     * @param array le tableau à trier
     * @param start l'index de début
     * @param end l'index de fin
     * @return le tableau trié
     */
    public static int[] mergeSort(int[] array, int start, int end) {
        if (start < end) {
            // Trouver le milieu
            int middle = (start + end) / 2;
            
            // Trier récursivement les deux moitiés
            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);
            
            // Fusionner les deux moitiés triées
            merge(array, start, middle, end);
        }
        
        return array;
    }
    
    /**
     * Fusionne deux parties triées d'un tableau
     * @param array le tableau contenant les deux parties
     * @param start l'index de début de la première partie
     * @param middle l'index de fin de la première partie
     * @param end l'index de fin de la deuxième partie
     */
    private static void merge(int[] array, int start, int middle, int end) {
        // Calculer les tailles des deux parties
        int leftSize = middle - start + 1;
        int rightSize = end - middle;
        
        // Créer des tableaux temporaires
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];
        
        // Copier les données dans les tableaux temporaires
        for (int i = 0; i < leftSize; i++) {
            left[i] = array[start + i];
        }
        for (int j = 0; j < rightSize; j++) {
            right[j] = array[middle + 1 + j];
        }
        
        // Fusionner les tableaux temporaires dans le tableau original
        int i = 0; // Index du tableau gauche
        int j = 0; // Index du tableau droite
        int k = start; // Index du tableau fusionné
        
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                array[k] = left[i];
                i++;
            } else {
                array[k] = right[j];
                j++;
            }
            k++;
        }
        
        // Copier les éléments restants de gauche, s'il y en a
        while (i < leftSize) {
            array[k] = left[i];
            i++;
            k++;
        }
        
        // Copier les éléments restants de droite, s'il y en a
        while (j < rightSize) {
            array[k] = right[j];
            j++;
            k++;
        }
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
        
        System.out.println("=== Tri fusion ===");
        System.out.print("Avant le tri : ");
        displayArray(numbers);
        
        // Trier le tableau
        numbers = mergeSort(numbers, 0, numbers.length - 1);
        
        System.out.print("Après le tri : ");
        displayArray(numbers);
    }
}
