package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FoodMenuTest {
    
    FoodMenu testfm;

    @BeforeEach
    void runBefore() {
        testfm = new FoodMenu();
    }

    @Test
    public void constructortest() {
        assertEquals(testfm.getTamaFood(0).getName(), "Bacon Cheeseburger");
        assertEquals(testfm.getTamaFood(0).getHappieness(), 15);
        assertEquals(testfm.getTamaFood(0).getNutrition(), 10);

        assertEquals(testfm.getTamaFood(5).getName(), "Chicken Salad");
        assertEquals(testfm.getTamaFood(5).getHappieness(), 25);
        assertEquals(testfm.getTamaFood(5).getNutrition(), 25);
    }

    @Test 
    public void gettamafoodtest() {
        assertEquals(testfm.getTamaFood(1).getName(), "Mochi");
    }

}
