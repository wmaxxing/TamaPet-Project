package model;

import java.time.*;
import java.time.format.DateTimeFormatter;

// The TamaHistory class will represent a single interaction event with the TamaPet
// A TamaHistory will have a name, a date, a time, and a string to say what happened 
// during the interaction with the tama pet

public class TamaHistory {

    private String name; 
    private String eventDescription;
    private String formattedDate;

    //Requires: name and eventDescription are not null 
    //Effects: Creats a TamaHistory object
    public TamaHistory(String name, String eventDescription) {
        this.name = name;
        this.eventDescription = eventDescription;
        LocalDateTime dt = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
        this.formattedDate = dt.format(dtf);
    }

    //Effects: Returns the name of the TamaHistory Object
    public String getName() {
        return this.name;
    }

    //Effects: Returns the event description of the TamaHistory Object
    public String getDesc() {
        return this.eventDescription;
    }

    //Effects: Returns the date and time of the TamaHistory Object
    public String getDateAndTime() {
        return this.formattedDate;
    }
}
