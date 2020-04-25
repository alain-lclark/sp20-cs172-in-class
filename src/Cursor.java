public class Cursor {

    private int x;
    private int y;
    private int rows;
    private int cols;
    private int row;
    private int col;

    public Cursor(int x, int y, int rows, int cols) {
        this.x = x;
        this.y = y;
        this.rows = rows;
        this.cols = cols;
        this.row = 0;
        this.col = 0;
    }

    public void setLocation(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void draw() {
        //StdDraw.line(x, (double)y - 0.5, x, (double)y + 0.75);
        StdDraw.line(x + col, (double)(y + rows - row) - 0.5, x + col, (double)(y + rows - row) + 0.75);
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

}