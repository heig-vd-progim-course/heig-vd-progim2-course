import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WaterSensorTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }

    // --- Tests du constructeur et des accesseurs ---

    @Test
    void getId_retourneIdentifiantFourni() {
        assertEquals("TEST-01", sensor.getId());
    }

    @Test
    void getLastPh_retourneZeroApresConstruction() {
        assertEquals(0.0, sensor.getLastPh());
    }

    // --- Tests de lecture valide ---

    @Test
    void readFromString_valeurNominale_retourneValeur()
            throws InvalidPhException {
        double result = sensor.readFromString("7.0");
        assertEquals(7.0, result);
    }

    @Test
    void readFromString_valeurNominale_metAJourLastPh()
            throws InvalidPhException {
        sensor.readFromString("6.5");
        assertEquals(6.5, sensor.getLastPh());
    }

    @Test
    void readFromString_borneMinimale_accepte()
            throws InvalidPhException {
        assertEquals(0.0, sensor.readFromString("0.0"));
    }

    @Test
    void readFromString_borneMaximale_accepte()
            throws InvalidPhException {
        assertEquals(14.0, sensor.readFromString("14.0"));
    }

    // --- Tests de cas d'erreur ---

    @Test
    void readFromString_formatInvalide_leveInvalidPhException() {
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("abc"));
    }

    @Test
    void readFromString_phTropEleve_leveInvalidPhException() {
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("15.0"));
    }

    @Test
    void readFromString_phTropBas_leveInvalidPhException() {
        assertThrows(InvalidPhException.class,
            () -> sensor.readFromString("-1.0"));
    }

    @Test
    void readFromString_erreurFormat_lastPhInchange()
            throws InvalidPhException {
        sensor.readFromString("7.0");
        try {
            sensor.readFromString("invalide");
        } catch (InvalidPhException e) {
            // exception attendue
        }
        assertEquals(7.0, sensor.getLastPh());
    }
}
