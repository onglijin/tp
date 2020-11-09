package tp.acecs2103.model.task;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RemarkTest {
    Remark remark1 =  new Remark("remark");
    Remark remark2 =  new Remark("remark");
    Remark remark3 =  new Remark("ABC");

    @Test
    public void contains_keyword_returnTrue() {
        assertTrue(remark1.contains("remark"));
    }

    @Test
    public void contains_keyword_returnFalse() {
        assertFalse(remark1.contains("ABC"));
    }

    @Test
    public void equals_objectToCompare_returnTrue() {
        assertTrue(remark1.equals(remark2));
    }

    @Test
    public void equals_objectToCompare_returnFalse() {
        assertFalse(remark1.equals(remark3));
        assertFalse(remark1.equals(null));
        assertFalse(remark1.equals("remark"));
    }
}