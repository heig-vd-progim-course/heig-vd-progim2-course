import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WaterSensorTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }

    @Test
    void getId_retourneIdentifiantFourni() {
        assertEquals("TEST-01", sensor.getId());
    }

    @Test
    void getLastPh_retourneZeroApresConstruction() {
        assertEquals(0.0, sensor.getLastPh());
    }
}
