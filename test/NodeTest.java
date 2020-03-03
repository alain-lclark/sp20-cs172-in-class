import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @org.junit.jupiter.api.Test
    void length() {
        assertEquals(0, Node.length(null));

        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        n1.item = 1;
        n1.next = n2;
        n2.item = 2;
        n2.next = n3;
        n3.item = 3;
        n3.next = null;
        assertEquals(3, Node.length(n1));
    }

    @org.junit.jupiter.api.Test
    void sum() {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        n1.item = 1;
        n1.next = n2;
        n2.item = 2;
        n2.next = n3;
        n3.item = 3;
        n3.next = null;
        assertEquals(6, Node.sum(n1));
    }

    @org.junit.jupiter.api.Test
    void max() {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        n1.item = 1;
        n1.next = n2;
        n2.item = 2;
        n2.next = n3;
        n3.item = 3;
        n3.next = null;
        assertEquals(3, Node.sum(n1));
        assertEquals(2, Node.sum(n2));
    }

    @org.junit.jupiter.api.Test
    void equals() {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        n1.item = 1;
        n1.next = n2;
        n2.item = 2;
        n2.next = n3;
        n3.item = 3;
        n3.next = null;
        Node m1 = new Node();
        Node m2 = new Node();
        Node m3 = new Node();
        m1.item = 1;
        m1.next = n2;
        m2.item = 2;
        m2.next = n3;
        m3.item = 3;
        m3.next = null;
        assertTrue(Node.equals(n1, m1));
        assertFalse(Node.equals(n2, m1));
    }

}