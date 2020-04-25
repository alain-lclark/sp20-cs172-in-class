import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PieceTableTest {

    private PieceTable table;

    @Test
    void get() {
        table = new PieceTable("12345");
        assertEquals('1', table.get(0));
        assertEquals('2', table.get(1));
        assertEquals('5', table.get(4));
    }

    @Test
    void insert() {
        table = new PieceTable("12345");
        table.insert(0, 'x');
        table.insert(3, 'y');
        table.insert(7, 'z');
        assertEquals('x', table.get(0));
        assertEquals('1', table.get(1));
        assertEquals('2', table.get(2));
        assertEquals('y', table.get(3));
        assertEquals('5', table.get(6));
        assertEquals('z', table.get(7));
        assertEquals(8, table.length());
        assertEquals("x12y345z", table.toString());
    }

    @Test
    void delete() {
        table = new PieceTable("12345");
        table.delete(3);
        assertEquals('1', table.get(0));
        assertEquals('2', table.get(1));
        assertEquals('3', table.get(2));
        assertEquals('5', table.get(3));
        assertEquals(4, table.length());
    }

    @Test
    void insertAndDelete() {
        table = new PieceTable("12345");
        table.insert(0, 'x');
        table.insert(3, 'y');
        table.insert(7, 'z');
        table.delete(5); // 8
        table.delete(5); // 7
        table.delete(1); // 6
        table.delete(0); // 5
        table.delete(1); // 4
        table.delete(2); // 3
        table.delete(0); // 2
        table.delete(0); // 1
        assertEquals(0, table.length());
    }

    @Test
    void lengthZero() {
        table = new PieceTable();
        assertEquals(0, table.length());
    }

    @Test
    void lengthNonZero() {
        table = new PieceTable("12345");
        assertEquals(5, table.length());
    }

    @Test
    void string() {
        table = new PieceTable("12345");
        table.insert(0, 'x');
        table.insert(3, 'y');
        table.insert(7, 'z');
        assertEquals("x12y345z", table.toString());
    }

    @Test
    void isIterable() {
        table = new PieceTable();
        table.insert(0, 'a');
        table.insert(1, 'b');
        table.insert(2, 'c');
        String s = "";
        for (Character c : table) {
            s += c;
        }
        assertEquals("abc", s);
    }

}