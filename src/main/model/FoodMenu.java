package model;

import java.util.ArrayList;

// The FoodMenu class will represent a list of TamaFood that will allow for easy
// viewing of what foods are available to the TamaPet
// The FoodMenu will be statically typed as adding food to it is not a user feature

public class FoodMenu {

    private ArrayList<TamaFood> foodList;

    //Effects: Creates a FoodMenu object which has a statically typed list of TamaFood objects
    public FoodMenu() {
        foodList.add(new TamaFood("Bacon Cheeseburger", 15, 10));
        foodList.add(new TamaFood("Mochi", 20, 5));
        foodList.add(new TamaFood("Lettuce", -10, 15));
        foodList.add(new TamaFood("Baby Carrots", -15, 10));
        foodList.add(new TamaFood("Tuna Steak", 20, 20));
        foodList.add(new TamaFood("Chicken Salad", 25, 25));
    }

    //Requires that foodList.size() > index >= 0
    //Effects: Returns the food object in FoodMenu which is at the provided index used for testing
    public TamaFood getTamaFood(int index) {

    }
}
