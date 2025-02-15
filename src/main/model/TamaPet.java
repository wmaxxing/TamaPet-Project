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
    // in order to promote intreacting with the TamaPet
    public void tamaDecay() {

    }

    //Modifies: this
    //Effects: Allows the user to play with the tama pet increasing happieness by PLAYHAPPY and reducing
    // satiation by PLAYHUNGER
    public void tamaPlay() { 

    }

    
    //Effects: returns the happieness value of the TamaPet object
    public float getHappieness() {

    }
    
    //Effects: returns the nutritional value of the TamaPet object
    public float getNutrition() {

    }
    
    //Modifies: this
    //Effects: sets the name of the TamaPet object
    public void setName(String name) {

    }

    //Modifies: this
    //Effects: sets the happieness value of the TamaPet object
    public void setHappieness(float happieness) {

    }

    //Modifies: this
    //Effects: sets the satiation value of the TamaPet object
    public void setSatiation(float satiation) {

    }
    
}
