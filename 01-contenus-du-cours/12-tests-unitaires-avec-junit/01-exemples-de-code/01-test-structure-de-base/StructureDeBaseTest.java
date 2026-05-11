import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Exemple 01 - Structure de base d'un test JUnit.
 *
 * Ce test illustre la structure minimale : l'annotation @Test et la méthode
 * assertEquals. Chaque méthode suit explicitement le patron AAA.
 */
class StructureDeBaseTest {

    @Test
    void getId_retourneIdentifiantFourni() {
        // Arrange
        WaterSensor sensor = new WaterSensor("TEST-01");

        // Act
        String id = sensor.getId();

        // Assert
        assertEquals("TEST-01", id);
    }

    @Test
    void getLastPh_retourneZeroApresConstruction() {
        // Arrange
        WaterSensor sensor = new WaterSensor("TEST-01");

        // Act
        double lastPh = sensor.getLastPh();

        // Assert
        assertEquals(0.0, lastPh);
    }
}
