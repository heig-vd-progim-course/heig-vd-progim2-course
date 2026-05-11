import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Exemple 05 - Tester les exceptions avec assertThrows.
 *
 * Ce test illustre l'utilisation de assertThrows pour vérifier qu'une méthode
 * lève bien une exception dans les cas d'erreur.
 */
class AssertThrowsTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }

    @Test
    void readFromString_formatInvalide_leveInvalidPhException() {
        // "abc" n'est pas un nombre : InvalidPhException attendue
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("abc"));
    }

    @Test
    void readFromString_phNegatif_leveInvalidPhException() {
        // -1.0 est hors plage : InvalidPhException attendue
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("-1.0"));
    }

    @Test
    void readFromString_phTropEleve_leveInvalidPhException() {
        // 15.0 est hors plage : InvalidPhException attendue
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("15.0"));
    }

    @Test
    void readFromString_chaineVide_leveInvalidPhException() {
        // Une chaîne vide ne peut pas être convertie en double
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString(""));
    }
}
