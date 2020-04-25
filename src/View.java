public class View {

    private int width = 512;
    private int height = 512;

    private final int fontXStride = 11;
    private final int fontPointSize = 16;

    private int cols = (int)((double)width/fontXStride);
    private int rows = (int)((double)height/fontPointSize);

    private int textMaxRow;
    private int textMaxCol;

    private Title title;
    private TextArea text;
    private Cursor cursor;

    public View() {
        StdDraw.setCanvasSize(width, height);
        StdDraw.setYscale(0, (double)height/fontPointSize);
        StdDraw.setXscale(0, (double)width/fontXStride);

        StdOut.println("Rows: " + rows + " Cols: " + cols);

        int titleRow = rows - 1;
        int titleCol = 0;

        title = new Title(titleCol, titleRow, "Untitled");

        int textMinRow = 0;
        textMaxRow = rows - 3;
        int textMinCol = 0;
        textMaxCol = cols;

        text = new TextArea(0, 0, textMaxRow, textMaxCol, "012345678901234567890");
        cursor = new Cursor(0, 0, textMaxRow, textMaxCol);
    }

    public void draw() {
        StdDraw.clear();
        title.draw();
        cursor.draw();
        text.draw();
        StdDraw.show();
    }

    public void setCursor(double x, double y) {
        int maxRow = text.maxRow();
        int maxCol = text.maxCol();
        int whichRow = whichRow(y);
        int whichCol = whichCol(x);
        if (whichRow > maxRow) {
            whichRow = maxRow;
            whichCol = maxCol;
        }
        else if (whichRow == maxRow && whichCol > maxCol) {
            whichCol = maxCol;
        }
        cursor.setLocation(whichRow, whichCol);
        text.setLocation(whichRow, whichCol);
    }

    public void input(char c) {
        text.input(c);
    }

    private int whichRow (double y) {
        int yy = textMaxRow - (int)y;
        if (yy < 0) yy = 0;
        if (yy > textMaxRow) yy = textMaxRow;
        return yy;
    }

    private int whichCol (double x) {
        int xx = (int)x;
        if (xx < 0) xx = 0;
        if (xx > textMaxCol) xx = textMaxCol;
        return xx;
    }

}