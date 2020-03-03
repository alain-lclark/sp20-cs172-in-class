public class PointExample {

    static public void main(String[] unused) {
        Point p = new Point();
        p.x = 2;
        p.y = 3;
        Point p2 = new Point();
        p2.x = -1;
        p2.y = -1;

        StdOut.println(p.x);
        StdOut.println(p.y);

        Point p3 = Point.add(p, p2);
        StdOut.println(p3.x);
        StdOut.println(p3.y);
    }

}