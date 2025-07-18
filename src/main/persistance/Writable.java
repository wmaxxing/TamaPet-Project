package persistance;

import org.json.JSONObject;

//Citation: This code is based upon and modeled after the JsonSerilizationDemo
// found at https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo/tree/master

// Takes a tamaPet and returns it as a json object 
public interface Writable {
    //Effects: returns this object as a JSON object
    JSONObject toJson();
}