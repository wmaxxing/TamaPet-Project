package model;

// The TamaPet class will represent a pet which will have a satiation meter and 
// a happieness meter that the user will have to maintain in order to keep the 
// TamaPet thriving

public class TamaPet {

    private static final float DEFAULTVALUE = 50;
    private static final float PLAYHAPPY = 25;
    private static final float PLAYHUNGER = 10;
    private float satiation;
    private float happieness;
    private String name;

    //Effects: Creates a TamaPet object with satiation and happieness set to DEFAULTVALUE
    public TamaPet(String name) {

    }

    //Modifies: this 
    //Effects: Decays the happieness and satiation by 0.1 every x mins the program is running
    // in order to promote intreacting with the TamaPet if the TamaPet has any stat that is 0
    // then the stat remains at 0 and does not go negative
    public void tamaDecay() {

    }

    //Modifies: this
    //Effects: Allows the user to play with the tama pet increasing happieness by PLAYHAPPY and reducing
    // satiation by PLAYHUNGER returns true if the play is successful and false if they TamaPet does not 
    // have enough satiation to play, the happieness stat is capped at 100 and cannot exceed it
    public boolean tamaPlay() { 

    }

    //Effects: returns the name of the TamaPet object
    public float getName() {

    }

    //Effects: returns the happieness value of the TamaPet object
    public float getHappieness() {

    }
    
    //Effects: returns the nutritional value of the TamaPet object
    public float getSatiation() {

    }
    
    //Requires: name is not null
    //Modifies: this
    //Effects: sets the name of the TamaPet object
    public void setName(String name) {

    }

    //Requires: 100 >= happieness >= 0
    //Modifies: this
    //Effects: sets the happieness value of the TamaPet object
    public void setHappieness(float happieness) {

    }

    //Requires: 100 >= satiation >= 0
    //Modifies: this
    //Effects: sets the satiation value of the TamaPet object
    public void setSatiation(float satiation) {

    }
    
}
