public class Hanoi {

    public static void Hanoi(int n, String start, String dest, String spare) {
        if (n == 1) {
            StdOut.println("move 1 disc from " + start + " to " + dest);
        }
        else {
            Hanoi(n - 1, start, spare, dest);
            Hanoi(1, start, dest, spare);
            Hanoi(n - 1, spare, dest, start);
        }
    }

    public static void main(String[] args) {
        Hanoi(3, "start", "dest", "spare");
    }

}