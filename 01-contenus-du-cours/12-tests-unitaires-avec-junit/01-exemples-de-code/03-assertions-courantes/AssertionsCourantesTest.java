import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Exemple 03 - Les assertions courantes de JUnit.
 *
 * Ce test illustre les cinq assertions les plus utilisées :
 * assertEquals, assertTrue, assertFalse, assertNotNull et assertNull.
 */
class AssertionsCourantesTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }

    @Test
    void assertEquals_identifiant_verifieEgalite() {
        // assertEquals vérifie que deux valeurs sont égales
        assertEquals("TEST-01", sensor.getId());
    }

    @Test
    void assertEquals_phInitial_verifieEgalite() {
        // assertEquals fonctionne aussi avec des doubles
        assertEquals(0.0, sensor.getLastPh());
    }

    @Test
    void assertTrue_identifiantNonVide_conditionVraie() {
        // assertTrue vérifie qu'une condition booléenne est vraie
        assertTrue(sensor.getId().length() > 0);
    }

    @Test
    void assertFalse_phInitial_conditionFausse() {
        // assertFalse vérifie qu'une condition booléenne est fausse
        assertFalse(sensor.getLastPh() > 0);
    }

    @Test
    void assertNotNull_identifiant_objetNonNull() {
        // assertNotNull vérifie qu'une référence n'est pas null
        assertNotNull(sensor.getId());
    }

    @Test
    void assertNull_capteurSansId_identifiantNull() {
        // assertNull vérifie qu'une référence est null
        WaterSensor sensorSansId = new WaterSensor(null);
        assertNull(sensorSansId.getId());
    }
}
