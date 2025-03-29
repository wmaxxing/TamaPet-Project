package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

// This code was taken and repurposed from
// https://github.students.cs.ubc.ca/CPSC210/AlarmSystem/blob/main/src/test/ca/ubc/cpsc210/alarm/test/EventTest.java

/**
 * Unit tests for the Event class
 */
public class EventTest {
    private Event event;
    private Date date;

    // NOTE: these tests might fail if time at which line (2) below is executed
    // is different from time that line (1) is executed. Lines (1) and (2) must
    // run in same millisecond for this test to make sense and pass.

    @BeforeEach
    public void runBefore() {
        event = new Event("The tama pet was fed"); // (1)
        date = Calendar.getInstance().getTime(); // (2)
    }

    @Test
    public void testEvent() {
        assertEquals("The tama pet was fed", event.getDescription());
    }

    @Test
    public void testToString() {
        assertEquals(date.toString() + "\n" + "The tama pet was fed", event.toString());
    }
}