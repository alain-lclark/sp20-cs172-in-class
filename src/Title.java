public class Title {

    private String title;
    private int x;
    private int y;

    public Title(int x, int y, String title) {
        this.x = x;
        this.y = y;
        this.title = title;
    }

    public void draw() {
        StdDraw.textLeft(0, y, title);
    }

}