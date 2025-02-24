package persistance;

import model.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

public class JsonReaderTest {

    @Test
    void testReaderNoFile() {
        JsonReader reader = new JsonReader("./data/nonExistant.json");
        try {
            @SuppressWarnings("unused") // Will not be used for correct operation of this test
            TamaPet tamaPet = reader.read();
            @SuppressWarnings("unused") // Will not be used for correct operation of this test
            HistoryLog testLog = reader.addHistoryLog();
            fail("IOException expected");
        } catch (IOException e) {
            // Expected
        }
    }

    @Test
    void testReaderTamaPetEmpty() {
        JsonReader reader = new JsonReader("./data/readerEmptyTamaPet.json");
        try {
            TamaPet tamaPet = reader.read();
            assertEquals("emptyname", tamaPet.getName());
            HistoryLog testLog = reader.addHistoryLog();
            assertEquals(50, tamaPet.getSatiation());
            assertEquals(50, tamaPet.getHappieness());
            assertEquals(testLog.getSize(), 0);
        } catch (IOException e) {
            fail("Non expected error");
        }
    }

    @Test
    void testReaderGeneralTamaPet() {
        JsonReader reader = new JsonReader("./data/readerGeneralTamaPet.json");
        try {
            TamaPet tamaPet = reader.read();
            HistoryLog testLog = reader.addHistoryLog();
            assertEquals("emptyname", tamaPet.getName());
            assertEquals(1, testLog.getSize());

        } catch (IOException e) {
            fail("Non expected error");
        }
    }
}
