import java.util.HashSet;

// Types enveloppes - exemple 03 : equals() et hashCode()
//
// Objectif : comprendre la différence entre == et equals(), et implémenter
// equals() et hashCode() correctement dans la classe Movie.
//
// Sortie attendue :
//   --- Comparaison avec == ---
//   m1 == m2 : false
//   m1 == m1 : true
//   --- Avant redéfinition de equals() ---
//   m1.equals(m2) sans redéfinition : voir Movie.java (commentaire)
//   --- Après redéfinition de equals() ---
//   m1.equals(m2) : true
//   m1.equals(m3) : false
//   --- HashSet sans hashCode() cohérent ---
//   (voir les commentaires dans Movie.java)
//   --- HashSet avec hashCode() cohérent ---
//   favorites.contains(search) : true

public class EqualsHashCodeExample {

    public static void main(String[] args) {
        Movie m1 = new Movie("Inception", 2010, 148, 9.0);
        Movie m2 = new Movie("Inception", 2010, 148, 9.0);
        Movie m3 = new Movie("Interstellar", 2014, 169, 8.6);

        // --- Comparaison avec == ---
        System.out.println("--- Comparaison avec == ---");
        System.out.println("m1 == m2 : " + (m1 == m2));  // false : deux objets
        System.out.println("m1 == m1 : " + (m1 == m1));  // true : même objet

        // --- Comparaison avec equals() ---
        System.out.println("\n--- Comparaison avec equals() ---");
        System.out.println("m1.equals(m2) : " + m1.equals(m2));  // true
        System.out.println("m1.equals(m3) : " + m1.equals(m3));  // false
        System.out.println("m1.equals(null) : " + m1.equals(null));  // false

        // --- HashSet avec equals() et hashCode() cohérents ---
        System.out.println("\n--- HashSet avec equals() et hashCode() ---");
        HashSet<Movie> favorites = new HashSet<>();
        favorites.add(m1);
        favorites.add(m3);
        System.out.println("Taille : " + favorites.size());  // 2

        // On cherche un film par valeur, pas par référence
        Movie search = new Movie("Inception", 2010, 148, 9.0);
        System.out.println("search == m1 : " + (search == m1));  // false
        System.out.println("favorites.contains(search) : "
                + favorites.contains(search));  // true !

        // --- Ajout d'un doublon ---
        favorites.add(new Movie("Inception", 2010, 0, 0.0));  // même titre+année
        System.out.println("Taille après doublon : " + favorites.size());  // 2
    }
}
