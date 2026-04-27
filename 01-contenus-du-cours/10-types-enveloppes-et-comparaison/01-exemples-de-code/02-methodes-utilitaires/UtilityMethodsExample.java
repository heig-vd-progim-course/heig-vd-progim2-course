// Types enveloppes - exemple 02 : méthodes utilitaires
//
// Objectif : utiliser les méthodes utilitaires des classes enveloppes
// pour convertir des chaînes, accéder aux constantes, et travailler
// avec les caractères.
//
// Sortie attendue :
//   Année : 2010
//   Note : 8.5
//   Durée (long) : 148
//   Max int : 2147483647
//   Min int : -2147483648
//   Taille int : 32 bits
//   'A' est une lettre : true
//   '3' est un chiffre : true
//   ' ' est un espace : true
//   Minuscule de 'A' : a
//   Majuscule de 'b' : B

public class UtilityMethodsExample {

    public static void main(String[] args) {

        // --- Conversion de chaîne en nombre ---
        String yearInput = "2010";
        int year = Integer.parseInt(yearInput);
        System.out.println("Année : " + year);

        String ratingInput = "8.5";
        double rating = Double.parseDouble(ratingInput);
        System.out.println("Note : " + rating);

        String durationInput = "148";
        long duration = Long.parseLong(durationInput);
        System.out.println("Durée (long) : " + duration);

        // --- Constantes utiles ---
        System.out.println("Max int : " + Integer.MAX_VALUE);
        System.out.println("Min int : " + Integer.MIN_VALUE);
        System.out.println("Taille int : " + Integer.SIZE + " bits");

        // --- Méthodes utilitaires de Character ---
        char letter = 'A';
        char digit = '3';
        char space = ' ';

        System.out.println("'" + letter + "' est une lettre : "
                + Character.isLetter(letter));
        System.out.println("'" + digit + "' est un chiffre : "
                + Character.isDigit(digit));
        System.out.println("' ' est un espace : "
                + Character.isWhitespace(space));
        System.out.println("Minuscule de '" + letter + "' : "
                + Character.toLowerCase(letter));
        System.out.println("Majuscule de 'b' : "
                + Character.toUpperCase('b'));
    }
}
