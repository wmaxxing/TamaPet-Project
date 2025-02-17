package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TamaHistoryLogTest {
    
    HistoryLog testlog;

    @BeforeEach
    void runBefore() {
        testlog = new HistoryLog();
    }

    @Test
    public void constructortest() {
        testlog.addTamaHistory(new TamaHistory("Feeding", "Feeding"));
        assertEquals(testlog.getTamaHistory(0).getName(), "Feeding");
    }

    @Test 
    public void gettamahistorytest() { 
        testlog.addTamaHistory(new TamaHistory("yes", "yes"));
        assertEquals(testlog.getTamaHistory(0).getName(), "yes");
    }

    @Test 
    public void addtamahistorytest() {
        testlog.addTamaHistory(new TamaHistory("no", "no"));
        assertEquals(testlog.getTamaHistory(0).getName(), "no");
    }

    @Test 
    public void tamahistorysizetest() {
        testlog.addTamaHistory(new TamaHistory("no", "no"));
        assertEquals(testlog.getSize(), 1);
    }

    @Test 
    public void tamahistorynewfeed() {
        testlog.newTamaHistory("Feed", 0);
        assertEquals(testlog.getTamaHistory(0).getName(), "Feed");
        testlog.newTamaHistory("Feed", 1);
        assertEquals(testlog.getTamaHistory(1).getName(), "Feed");
    }

    @Test 
    public void tamahistorynewplay() {
        testlog.newTamaHistory("Play", 0);
        assertEquals(testlog.getTamaHistory(0).getName(), "Play");
    }

}
