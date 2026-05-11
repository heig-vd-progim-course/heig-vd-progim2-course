import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Exemple 06 - Tester les effets de bord.
 *
 * Ce test illustre la vérification de l'état interne d'un objet : que lastPh
 * est mis à jour après une lecture réussie, et qu'il n'est pas modifié après
 * une lecture invalide.
 */
class EffetsDeBordTest {

    private WaterSensor sensor;

    @BeforeEach
    void setUp() {
        sensor = new WaterSensor("TEST-01");
    }

    @Test
    void readFromString_valeurValide_metAJourLastPh()
            throws InvalidPhException {
        // Une lecture réussie doit mettre à jour lastPh
        sensor.readFromString("6.5");
        assertEquals(6.5, sensor.getLastPh());
    }

    @Test
    void readFromString_deuxLectures_lastPhEstLaDerniere()
            throws InvalidPhException {
        // La deuxième lecture valide remplace la première dans lastPh
        sensor.readFromString("5.0");
        sensor.readFromString("8.0");
        assertEquals(8.0, sensor.getLastPh());
    }

    @Test
    void readFromString_erreurFormat_lastPhInchange()
            throws InvalidPhException {
        // Une entrée mal formatée ne doit pas modifier lastPh
        sensor.readFromString("7.0");
        try {
            sensor.readFromString("invalide");
        } catch (InvalidPhException e) {
            // exception attendue : on continue la vérification
        }
        assertEquals(7.0, sensor.getLastPh());
    }

    @Test
    void readFromString_erreurPlage_lastPhInchange()
            throws InvalidPhException {
        // Une valeur hors plage ne doit pas modifier lastPh
        sensor.readFromString("7.0");
        try {
            sensor.readFromString("20.0");
        } catch (InvalidPhException e) {
            // exception attendue : on continue la vérification
        }
        assertEquals(7.0, sensor.getLastPh());
    }
}
