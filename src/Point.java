/**
 * Define a point in a two-dimensional plane.
 */
public class Point {

    int x;
    int y;

    static Point add(Point p1, Point p2) {
        Point p = new Point();
        p.x = p1.x + p2.x;
        p.y = p1.y + p2.y;
        return p;
    }

    static Point nudge(Point p, int amount) {
        Point newP = new Point();
        newP.x = p.x + amount;
        newP.y = p.y + amount;
        return newP;
    }

    static Point scale(Point p, int factor) {
        Point newP = new Point();
        newP.x = p.x * factor;
        newP.y = p.y * factor;
        return newP;
    }

}
