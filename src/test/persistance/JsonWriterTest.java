package persistance;

import model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.IOException;

public class JsonWriterTest {

    @Test
    void testWriteBadFile() {
        try {
            @SuppressWarnings("unused") // Will not be used for correct operation of this test
            TamaPet tamaPet = new TamaPet("testname");
            @SuppressWarnings("unused") // Will not be used for correct operation of this test
            HistoryLog testLog = new HistoryLog();
            JsonWriter writer = new JsonWriter("./data/\0");
            writer.open();
            fail("IOException should have been thrown");
        } catch (IOException e) {
            // expected
        }
    }

    @Test
    void testWriterEmptyTamaPet() {
        try {
            TamaPet tamaPet = new TamaPet("emptyname");
            HistoryLog testLog = new HistoryLog();
            JsonWriter writer = new JsonWriter("./data/writerTestEmpty.json");
            writer.open();
            writer.write(tamaPet, testLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/writerTestEmpty.json");
            tamaPet = reader.read();
            assertEquals("emptyname", tamaPet.getName());
            assertEquals(50, tamaPet.getSatiation());
            assertEquals(50, tamaPet.getHappieness());
            assertEquals(tamaPet.getHistoryLog().getSize(), 0);
        } catch (IOException e) {
            fail("Non expected error");
        }
    }

    @Test
    void testWriterGeneralTamaPet() {
        try {
            TamaPet tamaPet = new TamaPet("newname");
            tamaPet.setHappieness(10);
            tamaPet.setSatiation(100);
            HistoryLog testLog = new HistoryLog();
            testLog.newTamaHistory("Feed" , 1);
            testLog.newTamaHistory("Play", -1);
            JsonWriter writer = new JsonWriter("./data/writerTestGeneralTamaPet.json");
            writer.open();
            writer.write(tamaPet, testLog);
            writer.close();

            JsonReader reader = new JsonReader("./data/writerTestGeneralTamaPet.json");
            tamaPet = reader.read();
            assertEquals("newname", tamaPet.getName());
            assertEquals(10, tamaPet.getHappieness());
            assertEquals(100, tamaPet.getSatiation());
            assertEquals(tamaPet.getHistoryLog().getSize(), 2);
        } catch (IOException e) {
            fail("Non expected error");
        }
    }
}
