package persistance;

import model.*;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.*;

//Citation: This code is based upon and modeled after the JsonSerilizationDemo
// found at https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/tree/master

public class JsonReaderTest {

    @Test
    void testReaderNoFile() {
        JsonReader reader = new JsonReader("./data/nonExistant.json");
        try {
            TamaPet tamaPet = reader.read();
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
            assertEquals(50, tamaPet.getSatiation());
            assertEquals(50, tamaPet.getHappieness());
            assertEquals(tamaPet.getHistoryLog().getSize(), 0);
        } catch (IOException e) {
            fail("Non expected error");
        }
    }

    @Test
    void testReaderGeneralTamaPet() {
        JsonReader reader = new JsonReader("./data/readerGeneralTamaPet.json");
        try {
            TamaPet tamaPet = reader.read();
            assertEquals("generalname", tamaPet.getName());
            assertEquals(1, tamaPet.getHistoryLog().getSize());

        } catch (IOException e) {
            fail("Non expected error");
        }
    }
}
