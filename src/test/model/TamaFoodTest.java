package model;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TamaFoodTest {
    
    TamaFood testfood;

    @BeforeEach
    void runBefore() {
        testfood = new TamaFood("Kimchi", 10, 10); 
    }

    @Test
    public void constructortest() {
        TamaFood constest = new TamaFood("Kimchi", 10, 10);
        assertEquals(constest.getName(), testfood.getName());
        assertEquals(constest.getHappieness(), testfood.getHappieness());
        assertEquals(constest.getNutrition(), testfood.getNutrition());
    }

    @Test 
    public void getnametest() {
        assertEquals(testfood.getName(), "Kimchi");
    }

    @Test 
    public void gethappienesstest() {
        assertEquals(testfood.getHappieness(), 10);
    }

    @Test 
    public void getnutritiontest() {
        assertEquals(testfood.getNutrition(), 10);
    }
}
