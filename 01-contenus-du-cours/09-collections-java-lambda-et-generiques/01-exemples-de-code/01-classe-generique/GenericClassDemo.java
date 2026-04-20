/**
 * Démonstration de classes génériques.
 */
public class GenericClassDemo {
    public static void main(String[] args) {
        System.out.println("=== Classe générique ===");

        // --- Box<String> ---
        // Le type T est remplacé par String.
        Box<String> stringBox = new Box<>("Tomate");
        System.out.println("Boîte de String : " + stringBox);
        // Pas besoin de cast : getValue() retourne directement
        // un String.
        String value = stringBox.getValue();
        System.out.println("Valeur : " + value);
        System.out.println();

        // --- Box<Integer> ---
        // Le type T est remplacé par Integer.
        // Note : on ne peut pas utiliser int (type primitif),
        // il faut utiliser Integer (classe wrapper).
        Box<Integer> intBox = new Box<>(42);
        System.out.println("Boîte de Integer : " + intBox);
        int number = intBox.getValue();
        System.out.println("Valeur : " + number);
        System.out.println();

        // --- Box<Double> ---
        Box<Double> doubleBox = new Box<>(3.14);
        System.out.println("Boîte de Double : " + doubleBox);
        System.out.println("Valeur : " + doubleBox.getValue());
        System.out.println();

        // --- Pair<K, V> avec deux paramètres de type ---
        System.out.println("=== Pair générique ===");
        Pair<String, String> nameEntry =
                new Pair<>("Nom", "Alice");
        System.out.println("Paire : " + nameEntry);
        System.out.println("Clé : " + nameEntry.getKey());
        System.out.println("Valeur : " + nameEntry.getValue());
        System.out.println();

        Pair<String, Integer> ageEntry =
                new Pair<>("Âge", 25);
        System.out.println("Paire : " + ageEntry);
        System.out.println("Clé : " + ageEntry.getKey());
        System.out.println("Valeur : " + ageEntry.getValue());
    }
}

/**
 * Classe générique avec un paramètre de type T.
 */
class Box<T> {
    private T value;

    public Box(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Box[" + value + "]";
    }
}

/**
 * Classe générique avec deux paramètres de type K et V.
 */
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "(" + key + ", " + value + ")";
    }
}
