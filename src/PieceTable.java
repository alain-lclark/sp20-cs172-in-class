import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PieceTable implements Iterable<Character> {

    private List<Character> originalFile;
    private List<Character> addFile;
    private List<Piece> table;

    public PieceTable() {
        originalFile = new ArrayList();
        addFile = new ArrayList();
        table = new ArrayList();
    }

    public PieceTable(String s) {
        originalFile = new ArrayList();
        addFile = new ArrayList();
        table = new ArrayList();
        for (char c : s.toCharArray()) {
            originalFile.add(c);
        }
        table.add(new Piece(originalFile, 0, s.length()));
    }

    /**
     * Return the character at position i of the text.
     * @param i  the position of the desired character
     * @return the character at position i
     */
    public Character get(int i) {
        for (Piece p : table) {
            if (i < p.length) {
                return p.whichFile.get(p.start + i);
            }
            i -= p.length;
        }
        return 0;
    }

    /**
     * Insert a character at position i of the text.
     * @param i  the position to insert the character
     * @param c  the character to insert
     */
    public void insert(int i, Character c) {
        // Add to addFile.
        int indexInAddFile = addFile.size();
        addFile.add(c);

        // Find the insertion point.
        int pieceIndex = 0;
        for (Piece p : table) {
            if (i < p.length) {
                break;
            }
            i -= p.length;
            ++pieceIndex;
        }

        // Two cases.
        if (i == 0) {
            // Insert a piece between 2 existing ones.
            Piece p = new Piece(addFile, indexInAddFile, 1);
            table.add(pieceIndex, p);
        }
        else {
            // Insert within an existing piece => split.
            Piece left = table.get(pieceIndex);
            Piece right = new Piece(left);
            right.length = left.length - i;
            right.start += i;
            left.length = i;
            Piece middle = new Piece(addFile, indexInAddFile, 1);
            table.add(pieceIndex + 1, middle);
            table.add(pieceIndex + 2, right);
        }
    }

    /**
     * Delete a character at position i in the text.
     * @param i  position of the character to delete
     */
    public void delete(int i) {
        int pieceIndex = 0;
        Piece p = null;
        for (Piece p1 : table) {
            if (i < p1.length) {
                p = p1;
                break;
            }
            i -= p1.length;
            ++pieceIndex;
        }

        // Three cases.
        if (i == 0) {
            // Remove the first character of the piece.
            ++p.start;
            --p.length;
        }
        else if (i == p.length) {
            // Remove the last character of the piece.
            --p.length;
        }
        else {
            // Split the piece
            Piece p1 = new Piece(p);
            p.length = i;
            p1.start += i + 1;
            p1.length -= i + 1;
            table.add(pieceIndex + 1, p1);
        }

        // Clean up
        if (p.length == 0) {
            table.remove(pieceIndex);
        }
    }

    /**
     * Return the length of the text.
     * @return the length of the text
     */
    public int length() {
        int length = 0;
        for (Piece p : table) {
            length += p.length;
        }
        return length;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Piece p : table) {
            for (int i = p.start; i < p.start + p.length; ++i) {
                sb.append(p.whichFile.get(i));
            }
        }
        return sb.toString();
    }

    @Override
    public Iterator<Character> iterator() {
        return new PieceTableIterator();
    }

    private class Piece {
        List<Character> whichFile;
        int start;
        int length;

        Piece(List<Character> whichFile, int start, int length) {
            this.whichFile = whichFile;
            this.start = start;
            this.length = length;
        }

        Piece(Piece p) {
            this(p.whichFile, p.start, p.length);
        }
    }

    private class PieceTableIterator implements Iterator<Character> {

        int i = 0;

        @Override
        public boolean hasNext() { return i < length(); }

        @Override
        public Character next() { return get(i++); }

    }

}