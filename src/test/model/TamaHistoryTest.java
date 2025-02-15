package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.*;
import java.time.format.DateTimeFormatter; 

public class TamaHistoryTest {
    
    TamaHistory testhistory;
    LocalDateTime dt;
    DateTimeFormatter dtf;

    @BeforeEach
    void runBefore() {
        testhistory = new TamaHistory("Feeding", "Fed the TamaPet a Salmon Steak"); 
        dt = LocalDateTime.now();
        dtf = DateTimeFormatter.ofPattern("E, MMM dd yyyy HH:mm:ss");
    }

    @Test
    public void constructortest() {
        TamaHistory contest = new TamaHistory("Feeding", "Fed the TamaPet a Salmon Steak");
        assertEquals(contest.getName(), "Feeding");
        assertEquals(contest.getDesc(), "Fed the TamaPet a Salmon Steak");
    }

    @Test 
    public void getnametest() {
        assertEquals(testhistory.getName(), "Feeding");
    }

    @Test 
    public void getDescription() {
        assertEquals(testhistory.getDesc(), "Fed the TamaPet a Salmon Steak");
    }

    @Test 
    public void getdatandtimetest() {
        assertEquals(testhistory.getDateAndTime(), dt.format(dtf));
    }
}
