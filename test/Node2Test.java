import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Node2Test {

    @Test
    void size() {
        Node2 a = new Node2();
        Node2 b = new Node2();
        Node2 c = new Node2();
        a.setNext(b); b.setNext(c); c.setNext(null);
        assertEquals(3, a.size());
        assertEquals(2, b.size());
    }

    @Test
    void testEquals() {
        Node2 a = new Node2(); Node2 b = new Node2(); Node2 c = new Node2();
        a.setValue(1); a.setNext(b);
        b.setValue(2); b.setNext(c);
        c.setValue(3); c.setNext(null);
        Node2 A = new Node2(); Node2 B = new Node2(); Node2 C = new Node2();
        A.setValue(1); A.setNext(b);
        B.setValue(2); B.setNext(c);
        C.setValue(3); C.setNext(null);
        assertTrue(a.equals(A));
        assertFalse(a.equals(B));
    }

    @Test
    void testToString() {
        Node2 a = new Node2();
        Node2 b = new Node2();
        Node2 c = new Node2();

        a.setValue(1); a.setNext(b);
        b.setValue(2); b.setNext(c);
        c.setValue(3); c.setNext(null);

        assertEquals("(1, 2, 3)", a.toString());
    }

}
