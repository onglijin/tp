package tp.acecs2103.model.task;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class WeekNumberTest {

    WeekNumber wk = new WeekNumber("1");
    WeekNumber wk1 = new WeekNumber("1");
    WeekNumber wk2 = new WeekNumber("2");

    @Test
    public void constructor() {
        assertThrows(IllegalArgumentException.class, () -> new WeekNumber("0"));
        assertThrows(IllegalArgumentException.class, () -> new WeekNumber("14"));
    }

    @Test
    public void isValidWeekNumber_StringInput_returnTrue() {
        assertTrue(WeekNumber.isValidWeekNumber("1"));
        assertTrue(WeekNumber.isValidWeekNumber("5"));
        assertTrue(WeekNumber.isValidWeekNumber("13"));
    }

    @Test
    public void isValidWeekNumber_StringInput_returnFalse() {
        assertFalse(WeekNumber.isValidWeekNumber("-2"));
        assertFalse(WeekNumber.isValidWeekNumber("0"));
        assertFalse(WeekNumber.isValidWeekNumber("14"));
        assertFalse(WeekNumber.isValidWeekNumber("20"));
    }

    @Test
    public void getWeekValueInt_null_weekNumberInt() {
        assertEquals(1,wk1.getWeekValueInt());
    }

    @Test
    public void testToString_null_weekNumberString() {
        assertEquals("1",wk1.value);
    }

    @Test
    public void testEquals_ObjectToCompare_returnTrue() {
        assertTrue(wk.equals(wk1));
    }

    @Test
    public void testEquals_ObjectToCompare_returnFalse() {
        assertFalse(wk1.equals(wk2));
        assertFalse(wk1.equals("1"));
        assertFalse(wk1.equals(null));
    }
}
