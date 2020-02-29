public class Fibonacci {

    static public void main(String[] unused) {
        int n = 10;
        StdOut.println("Fibonacci of " + n + " is " + fib(n));
        StdOut.println("Fibonacci of " + n + " is " + fibTopDown(n) + " using a top-down approach");
        StdOut.println("Fibonacci of " + n + " is " + fibBottomUp(n) + " using a bottom-up approach");
    }

    // Warning: inefficient!
    static public int fib(int n) {
        //StdOut.println("fib(" + n + ")");
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }

    // A global variable!
    static public int[] f = new int[100];

    // Top-down dynamic programming solution.
    static public int fibTopDown(int n) {
        //StdOut.println("fib(" + n + ")");
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (f[n] > 0) { return f[n]; }
        f[n] = fibTopDown(n - 1) + fibTopDown(n - 2);
        return f[n];
    }

    // Bottom-up dynamic programing solution (but no recursion).
    static public int fibBottomUp(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; ++i) {
            f[i]= f[i - 1] + f[i - 2];
        }
        return f[n];
    }

}