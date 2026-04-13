/**
 * Exemple 06 - TreeMap : tri par clé
 *
 * Cet exemple compare HashMap et TreeMap pour stocker le nombre
 * de plantes par espèce dans un jardin communautaire.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapDemo {

    public static void main(String[] args) {
        System.out.println("=== Comparaison HashMap vs TreeMap ===");

        // HashMap : ordre non garanti
        Map<String, Integer> hashMap = new HashMap<>();
        hashMap.put("Tomate", 12);
        hashMap.put("Basilic", 8);
        hashMap.put("Carotte", 15);
        hashMap.put("Aubergine", 5);

        System.out.println("\nHashMap (ordre non garanti) : " + hashMap
                + " (ordre variable)");

        // TreeMap : trié automatiquement par clé
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Tomate", 12);
        treeMap.put("Basilic", 8);
        treeMap.put("Carotte", 15);
        treeMap.put("Aubergine", 5);

        System.out.println("TreeMap (trié par clé)      : " + treeMap);

        // Parcours trié pour un rapport
        System.out.println("\n=== Rapport trié des plantes ===");
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue()
                    + " plantes");
        }
    }
}
