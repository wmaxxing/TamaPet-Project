package persistance;

import model.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import org.json.*;

//Citation: This code is based upon and modeled after the JsonSerilizationDemo
// found at https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/tree/master

// Reads a json file from the data folder that represents a TamaPet
public class JsonReader {

    private String sourceFile;

    // EFFECTS: constructs reader to read from sourceFile
    public JsonReader(String sourceFile) {
        this.sourceFile = sourceFile;
    }

    // EFFECTS: reads a TamaPet from sourceFile and returns it;
    // throws IOException if an error during data reading from sourceFile
    public TamaPet read() throws IOException {
        String jsonData = readFile(sourceFile);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseTamaPet(jsonObject);
    }

    // EFFECTS: reads sourceFile and returns it as a string
    private String readFile(String sourceFile) throws IOException {

    }

    // EFFECTS: parses a TamaPet from a JSON object and returns a TamaPet
    private TamaPet parseTamaPet(JSONObject jsonObject) {

    }

    // MODIFIES: tamaPet
    // EFFECTS: parses history log from a json file and adds it to a HistoryLog object
    public HistoryLog addHistoryLog() {

    }

}
