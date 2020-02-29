public class Tree {

    static public void main(String[] unused) {
        tree(10, 0.25, 0, 0.5, 0);
    }

    /**
     * Draw a tree recursively.
     *
     * @param depth  the tree depth (must be positive)
     * @param length  the branch length
     * @param x  x coordinate of the branch starting point
     * @param y  y coordinate of the branch starting point
     * @param angle  branch direction in degrees
     */
    static public void tree(int depth, double length, double x, double y, double angle) {
        // Base case.
        if (depth == 0) {
            return;
        }

        // General case.
        double xp = x + Math.cos(Math.toRadians(angle)) * length;
        double yp = y + Math.sin(Math.toRadians(angle)) * length;
        // Draw a branch...
        StdDraw.line(x, y, xp, yp);
        // ... and call tree recursively to draw finer details.
        tree(depth - 1, length * 0.7, xp, yp, angle + 20);
        tree(depth - 1, length * 0.7, xp, yp, angle - 30);
    }

}
