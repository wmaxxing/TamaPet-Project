package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TamaPetTest {
    
    TamaPet testpet;
    TamaFood testFood1;
    TamaFood testFood2;

    @BeforeEach
    void runBefore() {
        testpet = new TamaPet("Kimchi");
        testFood1 = new TamaFood("Rice", 10, 10);
        testFood2 = new TamaFood("Leuttice", -10,10);
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
        testpet.tamaDecay();
        assertEquals(testpet.getHappieness(), 0);
        assertEquals(testpet.getSatiation(), 0);

        testpet.setHappieness(50);
        testpet.setSatiation(0);
        testpet.tamaDecay();
        assertEquals(testpet.getHappieness(), 49.9);
        assertEquals(testpet.getSatiation(), 0);

        testpet.setHappieness(0);
        testpet.setSatiation(50);
        testpet.tamaDecay();
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

    @Test 
    public void tamafeedregular() { 
        testpet.tamaFeed(testFood1);
        assertEquals(testpet.getHappieness(), 60);
        assertEquals(testpet.getSatiation(), 60);
        testpet.tamaFeed(testFood2);
        assertEquals(testpet.getHappieness(), 50);
        assertEquals(testpet.getSatiation(), 70);
    }

    @Test 
    public void tamafeedhighcase() { 
        testpet.setHappieness(99);
        testpet.setSatiation(95);
        testpet.tamaFeed(testFood1);
        assertEquals(testpet.getHappieness(), 100);
        assertEquals(testpet.getSatiation(), 100);

    }

    @Test 
    public void tamafeedlowcase() { 
        testpet.setHappieness(5);
        testpet.setSatiation(20);
        testpet.tamaFeed(testFood2);
        assertEquals(testpet.getHappieness(), 0);
        assertEquals(testpet.getSatiation(), 30);
    }
}
