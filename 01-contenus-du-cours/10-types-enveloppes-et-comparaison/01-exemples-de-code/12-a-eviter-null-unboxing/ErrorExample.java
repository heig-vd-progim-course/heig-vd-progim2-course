import java.util.ArrayList;

// ERREUR À ÉVITER : NullPointerException lors de l'unboxing
//
// Problème : un objet Integer peut être null. Si Java tente de l'unboxer
// (appel implicite de intValue()), une NullPointerException est levée.
//
// Ce piège est fréquent avec les collections, les valeurs de retour de méthodes
// ou les attributs non initialisés.

public class ErrorExample {

    public static void main(String[] args) {

        // --- Cas 1 : unboxing direct d'une valeur null ---
        System.out.println("--- Cas 1 : unboxing direct de null ---");
        Integer value = null;
        try {
            int i = value;  // NullPointerException !
            System.out.println("i = " + i);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException lors de l'unboxing !");
        }

        // --- Cas 2 : null dans une collection avec boucle unboxante ---
        System.out.println("\n--- Cas 2 : null dans une collection ---");
        ArrayList<Integer> durations = new ArrayList<>();
        durations.add(148);
        durations.add(null);   // Java autorise l'ajout de null
        durations.add(97);

        try {
            for (int d : durations) {  // NullPointerException sur null !
                System.out.println("Durée : " + d);
            }
        } catch (NullPointerException e) {
            System.out.println("NullPointerException en itérant la liste !");
        }

        // --- La bonne façon : vérifier null avant l'unboxing ---
        System.out.println("\n--- Bonne pratique : vérifier null ---");
        for (Integer dur : durations) {
            if (dur != null) {
                int d = dur;  // Unboxing sûr
                System.out.println("Durée : " + d + " min");
            } else {
                System.out.println("Durée inconnue");
            }
        }
    }
}
