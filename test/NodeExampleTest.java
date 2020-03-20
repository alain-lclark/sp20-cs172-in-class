import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeExampleTest {

    @Test
    void size() {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        a.next = b;
        b.next = c;
        c.next = null;
        assertEquals(3, NodeExample.size(a));
        assertEquals(2, NodeExample.size(b));
        assertEquals(0, NodeExample.size(null));
    }

    @Test
    void testEquals() {
        Node a = new Node();
        Node b = new Node();
        Node c = new Node();
        a.value = 1; a.next = b;
        b.value = 2; b.next = c;
        c.value = 3; c.next = null;
        Node A = new Node();
        Node B = new Node();
        Node C = new Node();
        A.value = 1; A.next = b;
        B.value = 2; B.next = c;
        C.value = 3; C.next = null;
        assertTrue(NodeExample.equals(null, null));
        assertTrue(NodeExample.equals(a, A));
        assertFalse(NodeExample.equals(a, B));
    }

}