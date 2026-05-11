import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Exemple 04 - Tester les valeurs limites.
 *
 * Ce test illustre l'importance de tester les bornes d'une plage valide.
 * Pour WaterSensor, la plage autorisée est [0.0, 14.0]. Les tests vérifient
 * les bornes exactes et les premières valeurs hors plage.
 */
class ValeursLimitesTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }

    @Test
    void readFromString_borneMinimale_accepte()
            throws InvalidPhException {
        // 0.0 est la valeur minimale autorisée : elle doit être acceptée
        assertEquals(0.0, sensor.readFromString("0.0"));
    }

    @Test
    void readFromString_valeurNominale_accepte()
            throws InvalidPhException {
        // 7.0 est une valeur centrale, représentative du cas normal
        assertEquals(7.0, sensor.readFromString("7.0"));
    }

    @Test
    void readFromString_borneMaximale_accepte()
            throws InvalidPhException {
        // 14.0 est la valeur maximale autorisée : elle doit être acceptée
        assertEquals(14.0, sensor.readFromString("14.0"));
    }

    @Test
    void readFromString_sousLaBorne_leveException() {
        // -0.1 est la première valeur sous la borne : elle doit être refusée
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("-0.1"));
    }

    @Test
    void readFromString_audessusLaBorne_leveException() {
        // 14.1 est la première valeur au-dessus de la borne : refusée
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("14.1"));
    }
}
