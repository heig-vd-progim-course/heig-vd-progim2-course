// Types enveloppes - exemple 01 : types enveloppes et autoboxing
//
// Objectif : comprendre les classes enveloppes, le mécanisme d'autoboxing
// et d'unboxing, et leur utilisation dans les collections.
//
// Sortie attendue :
//   year (valueOf) : 2010
//   rating (autoboxing) : 9.0
//   first (unboxing) : 148
//   [148, 97, 132]
//   Somme : 377

import java.util.ArrayList;

public class WrapperTypesExample {

    public static void main(String[] args) {

        // --- Création explicite avec valueOf() ---
        Integer year = Integer.valueOf(2010);
        Double rating = Double.valueOf(9.0);
        Boolean available = Boolean.valueOf(true);

        System.out.println("year (valueOf) : " + year);
        System.out.println("rating (valueOf) : " + rating);
        System.out.println("available (valueOf) : " + available);

        // --- Autoboxing : le compilateur appelle valueOf() automatiquement ---
        // Java convertit le int en Integer sans appel explicite
        Integer duration = 148;
        // équivaut à : Integer duration = Integer.valueOf(148);

        System.out.println("duration (autoboxing) : " + duration);

        // --- Unboxing : le compilateur appelle intValue() automatiquement ---
        int d = duration;
        // équivaut à : int d = duration.intValue();

        System.out.println("d (unboxing) : " + d);

        // --- Autoboxing dans les collections ---
        ArrayList<Integer> durations = new ArrayList<>();
        durations.add(148);   // autoboxing : 148 → Integer.valueOf(148)
        durations.add(97);
        durations.add(132);

        System.out.println(durations);

        // --- Unboxing depuis une collection ---
        int first = durations.get(0);  // unboxing : Integer → int
        System.out.println("first (unboxing) : " + first);

        // --- Opérations arithmétiques : unboxing automatique ---
        int sum = 0;
        for (Integer dur : durations) {
            sum += dur;  // unboxing sur chaque dur
        }
        System.out.println("Somme : " + sum);
    }
}
