package persistance;

import model.*;
import org.json.JSONObject;
import java.io.*;

//Citation: This code is based upon and modeled after the JsonSerilizationDemo
// found at https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/tree/master

// Writes a json file to the data folder that represents a TamaPet
public class JsonWriter {

    private static final int TAB = 4;
    private PrintWriter writer;
    private String dest;

    //EFFECTS: constructs writer which can write to the dest file
    public JsonWriter(String destination) {

    }

    //MODIFIES: this
    //EFFECTS: opens writer on the file at dest, if file not found throws FileNotFoundException
    public void open() throws FileNotFoundException {

    }

    //MODIFIES: this
    //EFFECTS: writes JSON representation of a TamaPet and a HistoryLog to a file
    public void write(TamaPet tamaPet, HistoryLog hLog) {

    }

    //MODIFIES: this
    //EFFECTS: closes writer
    public void close() {

    }

    //MODIFIES: this
    //EFFECTS: writes string to file
    private void saveToFile(String json) {
 
    }
    

}
