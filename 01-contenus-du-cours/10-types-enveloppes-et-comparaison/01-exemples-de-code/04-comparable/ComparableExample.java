import java.util.ArrayList;
import java.util.Collections;

// Types enveloppes - exemple 04 : Comparable et tri
//
// Objectif : implémenter Comparable<Movie> et trier une liste de films
// avec Collections.sort() et list.sort(null).
//
// Sortie attendue :
//   --- Avant tri ---
//   Interstellar (2014) - 8.6/10
//   Inception (2010) - 9.0/10
//   Tenet (2020) - 7.4/10
//   The Dark Knight (2008) - 9.0/10
//   --- Après Collections.sort() (par note décroissante) ---
//   Inception (2010) - 9.0/10
//   The Dark Knight (2008) - 9.0/10
//   Interstellar (2014) - 8.6/10
//   Tenet (2020) - 7.4/10
//   --- Tri d'une liste d'Integer ---
//   Avant : [5, 1, 3, 2, 4]
//   Après  : [1, 2, 3, 4, 5]

public class ComparableExample {

    public static void main(String[] args) {
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Interstellar", 2014, 169, 8.6));
        movies.add(new Movie("Inception", 2010, 148, 9.0));
        movies.add(new Movie("Tenet", 2020, 150, 7.4));
        movies.add(new Movie("The Dark Knight", 2008, 152, 9.0));

        // --- Avant tri ---
        System.out.println("--- Avant tri ---");
        for (Movie m : movies) {
            System.out.println(m);
        }

        // --- Tri avec Collections.sort() ---
        // Utilise compareTo() de Movie (ordre décroissant par note)
        Collections.sort(movies);

        System.out.println("\n--- Après Collections.sort() (par note décroissante) ---");
        for (Movie m : movies) {
            System.out.println(m);
        }

        // --- Tri avec list.sort(null) : équivalent à Collections.sort() ---
        movies.sort(null);
        System.out.println("\n--- Après list.sort(null) (résultat identique) ---");
        for (Movie m : movies) {
            System.out.println(m);
        }

        // --- Integer implémente aussi Comparable ---
        // Collections.sort() fonctionne automatiquement (ordre croissant)
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(1);
        numbers.add(3);
        numbers.add(2);
        numbers.add(4);

        System.out.println("\n--- Tri d'une liste d'Integer ---");
        System.out.println("Avant : " + numbers);
        Collections.sort(numbers);
        System.out.println("Après  : " + numbers);
    }
}
