package model;

import java.util.ArrayList;

// The FoodMenu class will represent a list of TamaFood that will allow for easy
// viewing of what foods are available to the TamaPet
// The FoodMenu will be statically typed as adding food to it is not a user feature

public class FoodMenu {

    private ArrayList<TamaFood> foodList;

    //Effects: Creates a FoodMenu object which has a statically typed list of TamaFood objects
    public FoodMenu() {
        
    }

    //Requires that foodList.size() > index >= 0
    //Effects: Returns the food object in FoodMenu which is at the provided index used for testing
    public TamaFood getTamaFood(int index) {

    }

    //Requires: findfood is not null
    //Effects: takes a string of the name of a TamaFood and returns the corresponding TamaFood object
    // from the FoodMenu list
    public TamaFood findFood(String findfood) {
        
    }
}
