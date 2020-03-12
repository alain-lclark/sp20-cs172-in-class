import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    @org.junit.jupiter.api.Test
    void getValue() {
        Node n = new Node(4);
        assertEquals(4, n.getValue());
    }

    @org.junit.jupiter.api.Test
    void length() {
        Node list = new Node(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.length());
    }

    @org.junit.jupiter.api.Test
    void sum() {
        Node list = new Node(1);
        list.add(2);
        list.add(3);
        assertEquals(6, list.sum());
    }

    @org.junit.jupiter.api.Test
    void max() {
        Node list = new Node(1);
        list.add(2);
        list.add(3);
        assertEquals(3, list.max());
        assertEquals(3, list.getNext().max());
    }

    @org.junit.jupiter.api.Test
    void equals() {
        Node list1 = new Node(1);
        list1.add(2);
        list1.add(3);
        Node list2 = new Node(1);
        list2.add(2);
        list2.add(3);
        assertTrue(list1.equals(list2));
        assertFalse(list1.getNext().equals(list2));
    }

    @org.junit.jupiter.api.Test
    void add() {
        Node list1 = new Node(1);
        list1.add(2);
        list1.add(3);
        Node list2 = new Node(1);
        list2.add(2);
        list2.add(3);

        list1.add(list2);

        Node good = new Node(2);
        good.add(4);
        good.add(6);
        assertTrue(good.equals(list1));
    }

    @org.junit.jupiter.api.Test
    void scale() {
        Node list1 = new Node(1);
        list1.add(2);
        list1.add(3);

        list1.scale(3);

        Node good = new Node(3);
        good.add(6);
        good.add(9);
        assertTrue(good.equals(list1));
    }

}