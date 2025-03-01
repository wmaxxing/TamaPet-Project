package model;

import org.json.JSONObject;

import persistance.Writable;

// The TamaPet class will represent a pet which will have a satiation meter and 
// a happieness meter that the user will have to maintain in order to keep the 
// TamaPet thriving it will also have a history list of all interactions with the pet

public class TamaPet implements Writable {

    private static final double DEFAULTVALUE = 50;
    private static final double PLAYHAPPY = 25;
    private static final double PLAYHUNGER = 10;
    private static final double DECAYVAL = 0.1;
    private double satiation;
    private double happieness;
    private String name;
    private HistoryLog hisLog;

    //Requires: name is not null 
    //Effects: Creates a TamaPet object with satiation and happieness set to DEFAULTVALUE and an empty history log
    public TamaPet(String name) {
        this.name = name;
        this.satiation = DEFAULTVALUE; 
        this.happieness = DEFAULTVALUE;
        this.hisLog = new HistoryLog();
    }

    //Modifies: this 
    //Effects: Decays the happieness and satiation by 0.1 every x mins the program is running
    // in order to promote intreacting with the TamaPet if the TamaPet has any stat that is 0
    // then the stat remains at 0 and does not go negative
    public void tamaDecay() { // This method has not yet to be implemented
        if (satiation >= 0.1) {
            satiation -= DECAYVAL;
        }
        if (happieness >= 0.1) {
            happieness -= DECAYVAL; 
        }
    }

    //Modifies: this
    //Effects: Allows the user to play with the tama pet increasing happieness by PLAYHAPPY and reducing
    // satiation by PLAYHUNGER returns true if the play is successful and false if they TamaPet does not 
    // have enough satiation to play, the happieness stat is capped at 100 and cannot exceed it
    public boolean tamaPlay() { 
        if (satiation >= PLAYHUNGER) {
            if (happieness > 75) {
                happieness = 100;
                satiation -= PLAYHUNGER;
            } else {
                happieness += PLAYHAPPY;
                satiation -= PLAYHUNGER; 
            }
            return true;
        } else {
            return false;
        }
    }

    //Requires: food is a valid TamaFood object and not null
    //Modifies: this
    //Effects: Allows the user to feed the tama pet increasing satiation and happieness by the
    // amount provided by the food object, the happieness stat is capped at 100 and cannot exceed it
    public void tamaFeed(TamaFood food) { 
        if (food.getHappieness() >= 0) {
            if (happieness > 100 - food.getHappieness()) {
                happieness = 100;
            } else {
                happieness += food.getHappieness();
            }
            if (satiation > 100 - food.getNutrition()) {
                satiation = 100;
            } else {
                satiation += food.getNutrition();
            }
        } else {
            if (happieness + food.getHappieness() <= 0) {
                happieness = 0;
            } else {
                happieness += food.getHappieness();
            }
            if (satiation > 100 - food.getNutrition()) {
                satiation = 100;
            } else {
                satiation += food.getNutrition();
            }
        }
    }

    //Effects: returns the name of the TamaPet object
    public String getName() {
        return this.name;
    }

    //Effects: returns the happieness value of the TamaPet object
    public double getHappieness() {
        return this.happieness;
    }
    
    //Effects: returns the nutritional value of the TamaPet object
    public double getSatiation() {
        return this.satiation;
    }
    
    //Requires: name is not null
    //Modifies: this
    //Effects: sets the name of the TamaPet object
    public void setName(String name) {
        this.name = name;
    }

    //Requires: 100 >= happieness >= 0
    //Modifies: this
    //Effects: sets the happieness value of the TamaPet object
    public void setHappieness(double happieness) {
        this.happieness = happieness;
    }

    //Requires: 100 >= satiation >= 0
    //Modifies: this
    //Effects: sets the satiation value of the TamaPet object
    public void setSatiation(double satiation) {
        this.satiation = satiation; 
    }

    //Effects: Writes a TamaPet object to Json
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);
        json.put("satiation", satiation);
        json.put("happieness", happieness);
        json.put("history", hisLog.tamaHistoryToJson());
        return json;
    }

    //Effects: returns the historylog hisLog of this TamaPet
    public HistoryLog getHistoryLog() {
        return this.hisLog;
    }

    //Modifies: this 
    //Effects: sets the historylog hisLog of this TamaPet
    public void setHistoryLog(HistoryLog hisLog) {
        this.hisLog = hisLog; 
    }
    
}
