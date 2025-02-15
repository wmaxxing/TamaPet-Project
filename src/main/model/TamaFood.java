package model;

// The TamaFood class represents a food that is available to a TamaPet
// A TamaFood will have a "Name", a nutritional value and a happieness value

public class TamaFood {

    private String name;
    private double happienessValue;
    private double nutritionalValue;

    //Requires: That name is not null
    //Effects: Creates an instance of the TamaFood object
    public TamaFood(String name, double happienessValue, double nutritionalValue) {
        this.name = name;
        this.happienessValue = happienessValue;
        this.nutritionalValue = nutritionalValue;
    }

    //Effects: returns the name of the TamaFood object
    public String getName() {
        return this.name;
    }

    //Effects: returns the happieness value of the TamaFood object
    public double getHappieness() {
        return this.happienessValue;
    }

    //Effects: returns the nutritional value of the TamaFood object
    public double getNutrition() {
        return this.nutritionalValue;
    }
}
