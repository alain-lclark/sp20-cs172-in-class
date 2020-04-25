public class Editor {

    public static void main(String[] unused) {
        StdDraw.enableDoubleBuffering();
        View v = new View();
        v.draw();
        while (true) {
            while (!StdDraw.isMousePressed() && !StdDraw.hasNextKeyTyped()) { /* do nothing */; }
            if (StdDraw.isMousePressed()) {
                v.setCursor(StdDraw.mouseX(), StdDraw.mouseY());
                double x = StdDraw.mouseX();
                double y = StdDraw.mouseY();
                while (StdDraw.isMousePressed()) { /* do nothing */; }
            }
            else {
                char c = StdDraw.nextKeyTyped();
                v.input(c);
                StdOut.println(c);
            }
            v.draw();
        }
    }
}