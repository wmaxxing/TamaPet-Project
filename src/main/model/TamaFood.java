package model;

// The TamaFood class represents a food that is available to a TamaPet
// A TamaFood will have a "Name", a nutritional value and a happieness value

public class TamaFood {

    private String name;
    private float happienessValue;
    private float nutritionalValue;

    //Requires: That name is not null
    //Effects: Creates an instance of the TamaFood object
    public TamaFood(String name, float happienessValue, float nutritionalValue) {
        this.name = name;
        this.happienessValue = happienessValue;
        this.nutritionalValue = nutritionalValue;
    }

    //Effects: returns the name of the TamaFood object
    public String getName() {
        return this.name;
    }

    //Effects: returns the happieness value of the TamaFood object
    public float getHappieness() {
        return this.happienessValue;
    }

    //Effects: returns the nutritional value of the TamaFood object
    public float getNutrition() {
        return this.nutritionalValue;
    }
}
