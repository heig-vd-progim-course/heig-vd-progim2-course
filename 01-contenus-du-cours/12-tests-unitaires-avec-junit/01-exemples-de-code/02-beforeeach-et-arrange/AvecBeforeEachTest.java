import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Exemple 02 - Déléguer l'étape Arrange à @BeforeEach.
 *
 * Ce test reprend les mêmes vérifications que l'exemple 01, mais centralise
 * la création du WaterSensor dans setUp(). JUnit appelle setUp() avant chaque
 * méthode @Test : chaque test repart d'un état propre, sans répétition.
 */
class AvecBeforeEachTest {

    // Le capteur est partagé entre les tests via ce champ
    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        // Arrange centralisé : un capteur frais avant chaque test
        sensor = new WaterSensor("TEST-01");
    }

    @Test
    void getId_retourneIdentifiantFourni() {
        // sensor est déjà prêt grâce à setUp()
        assertEquals("TEST-01", sensor.getId());
    }

    @Test
    void getLastPh_retourneZeroApresConstruction() {
        assertEquals(0.0, sensor.getLastPh());
    }
}
