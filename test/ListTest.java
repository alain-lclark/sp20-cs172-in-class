import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {

    @Test
    void get() {
        List a = new List().add(1).add(2).add(3);
        assertEquals(1, a.get(0));
        assertEquals(3, a.get(2));
        assertEquals(-1, a.get(3));
        assertEquals(-1, a.get(-1));
    }

    @Test
    void size() {
        List a = new List().add(1).add(2).add(3);
        assertEquals(3, a.size());
    }

    @Test
    void testEquals() {
        List a = new List().add(1).add(2).add(3);
        List A = new List().add(1).add(2).add(3);
        List B = new List().add(1).add(2);
        assertEquals(a, A);
        assertNotEquals(a, B);
    }

    @Test
    void testToString() {
        List a = new List().add(1).add(2).add(3);
        assertEquals("(1, 2, 3)", a.toString());
    }

}
