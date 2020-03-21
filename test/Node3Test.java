import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Node3Test {

    @Test
    void size() {
        Node3 a = new Node3(1).add(2).add(3);
        assertEquals(3, a.size());
    }

    @Test
    void testEquals() {
        Node3 a = new Node3(1).add(2).add(3);
        Node3 A = new Node3(1).add(2).add(3);
        Node3 B = new Node3(1).add(2);
        assertTrue(a.equals(A));
        assertFalse(a.equals(B));
    }

    @Test
    void testToString() {
        Node3 a = new Node3(1).add(2).add(3);
        assertEquals("(3, 2, 1)", a.toString());
    }

}
