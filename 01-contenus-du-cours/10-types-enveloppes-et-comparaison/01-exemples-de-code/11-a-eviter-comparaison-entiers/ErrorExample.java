// ERREUR À ÉVITER : comparaison d'Integer avec ==
//
// Problème : le comportement de == sur des objets Integer dépend du cache JVM.
// Java met en cache les Integer entre -128 et 127. Au-delà, deux Integer avec
// la même valeur sont des objets distincts → == retourne false.
//
// Ce comportement est IMPRÉVISIBLE et source de bugs difficiles à détecter.
// Toujours utiliser equals() pour comparer des objets Integer.

public class ErrorExample {

    public static void main(String[] args) {

        // --- Valeurs dans le cache (-128 à 127) ---
        Integer a = 100;
        Integer b = 100;
        // ATTENTION : résultat imprévisible selon l'environnement !
        System.out.println("100 == 100 : " + (a == b));   // true (cache)

        // --- Valeurs hors du cache ---
        Integer x = 200;
        Integer y = 200;
        System.out.println("200 == 200 : " + (x == y));   // false (hors cache)

        // --- Comportement imprévisible avec une valeur limite ---
        Integer p = 127;
        Integer q = 127;
        System.out.println("127 == 127 : " + (p == q));   // true (limite haute)

        Integer r = 128;
        Integer s = 128;
        System.out.println("128 == 128 : " + (r == s));   // false (hors cache)

        // --- La bonne façon : toujours utiliser equals() ---
        System.out.println("\n--- Avec equals() (comportement prévisible) ---");
        System.out.println("100.equals(100) : " + a.equals(b));   // true
        System.out.println("200.equals(200) : " + x.equals(y));   // true
        System.out.println("128.equals(128) : " + r.equals(s));   // true
    }
}
