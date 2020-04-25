public class TextArea {

    private int x;
    private int y;
    private int rows;
    private int cols;
    private PieceTable table;

    private int maxRow;
    private int maxCol;

    private int index;

    public TextArea(int x, int y, int rows, int cols, String text) {
        this.x = x;
        this.y = y;
        this.rows = rows;
        this.cols = cols;
        this.table = new PieceTable(text);

        this.maxRow = 0;
        this.maxCol = 0;

        index = 0;
    }

    public int maxRow() { return maxRow; }
    public int maxCol() { return maxCol; }

    public void setLocation(int row, int col) {
        index = row * rows + col;
    }

    public void input(char c) {
        table.insert(index, c);
    }

    public void draw() {
        int row = 0;
        int col = 0;
        for (Character c : table) {
            draw(row, col, c);
            ++col;
            if (col > cols) {
                col = 0;
                ++row;
            }
        }
        maxRow = row;
        maxCol = col;
    }

    private void draw(int row, int col, char c) {
        StdDraw.textLeft(x + col, y + rows - row, String.valueOf(c));
    }

}