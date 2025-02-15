package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TamaPetTest {
    
    TamaPet testpet;

    @BeforeEach
    void runBefore() {
        testpet = new TamaPet("Kimchi");
    }

    @Test
    public void constructortest() {
        TamaPet contest = new TamaPet("Kimchi"); 
        assertEquals(contest.getName(), testpet.getName());
        assertEquals(contest.getHappieness(), testpet.getHappieness());
        assertEquals(contest.getSatiation(), testpet.getSatiation());
    }

    @Test 
    public void getnametest() {
        assertEquals(testpet.getName(), "Kimchi");
    }

    @Test 
    public void gethappienesstest() {
        assertEquals(testpet.getHappieness(), 50);
    }

    @Test 
    public void getnutritiontest() {
        assertEquals(testpet.getSatiation(), 50);
    }

    @Test 
    public void setnametest() {
        testpet.setName("Bear");
        assertEquals(testpet.getName(), "Bear");
    }

    @Test 
    public void sethappienesstest() {
        testpet.setHappieness(10);
        assertEquals(testpet.getHappieness(), 10);
    }

    @Test 
    public void setnutritiontest() {
        testpet.setSatiation(10);
        assertEquals(testpet.getSatiation(), 10);
    }

    @Test
    public void tamadecayregulartest() {
        testpet.tamaDecay();
        assertEquals(testpet.getHappieness(), 49.9);
        assertEquals(testpet.getSatiation(), 49.9);
        testpet.tamaDecay();
        assertEquals(testpet.getHappieness(), 49.8);
        assertEquals(testpet.getSatiation(), 49.8);
    }

    @Test
    public void tamadecayedgetest() {
        testpet.setHappieness(0);
        testpet.setSatiation(0);

        assertEquals(testpet.getHappieness(), 0);
        assertEquals(testpet.getSatiation(), 0);

        testpet.setHappieness(50);
        testpet.setSatiation(0);

        assertEquals(testpet.getHappieness(), 49.9);
        assertEquals(testpet.getSatiation(), 0);

        testpet.setHappieness(0);
        testpet.setSatiation(50);

        assertEquals(testpet.getHappieness(), 0);
        assertEquals(testpet.getSatiation(), 49.9);

    }

    @Test 
    public void tamaplayregular() { 
        assertTrue(testpet.tamaPlay());
        assertEquals(testpet.getHappieness(), 75);
        assertEquals(testpet.getSatiation(), 40);
    }

    @Test 
    public void tamaplaylowcase() { 
        testpet.setSatiation(9);
        assertFalse(testpet.tamaPlay());
        testpet.setSatiation(10);
        assertTrue(testpet.tamaPlay());
        assertEquals(testpet.getHappieness(), 75);
        assertEquals(testpet.getSatiation(), 0);
    }

    @Test 
    public void tamaplayhighcase() { 
        testpet.setHappieness(90);
        assertTrue(testpet.tamaPlay());
        assertEquals(testpet.getHappieness(), 100);
        assertEquals(testpet.getSatiation(), 40);

        testpet.setHappieness(75);
        assertTrue(testpet.tamaPlay());
        assertEquals(testpet.getHappieness(), 100);
        assertEquals(testpet.getSatiation(), 30);
    }
}
