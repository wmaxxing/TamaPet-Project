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
    public JsonWriter(String dest) {
        this.dest = dest;
    }   

    //MODIFIES: this
    //EFFECTS: opens writer on the file at dest, if file not found throws FileNotFoundException
    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(dest));
    }

    //MODIFIES: this
    //EFFECTS: writes JSON representation of a TamaPet
    public void write(TamaPet tamaPet) {
        JSONObject jsonpet = tamaPet.toJson();
        saveToFile(jsonpet.toString(TAB));
    }

    //MODIFIES: this
    //EFFECTS: closes writer
    public void close() {
        writer.close();
    }

    //MODIFIES: this
    //EFFECTS: writes string to file
    private void saveToFile(String json) {
        writer.print(json);
    }
    

}
