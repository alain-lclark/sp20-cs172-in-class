public class BubbleSort {

    /**
     * Simple bubble sort.
     * https://en.wikipedia.org/wiki/Bubble_sort
     * Average performance: O(n^2)
     * @param a  array of ints to be sorted
     */
    private static void bubbleSort(int[] a) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < a.length - 1; ++i) {
                if (a[i] > a[i + 1]) {
                    swapped = true;
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        } while (swapped);
    }

    /**
     * Optimized bubble sort.
     * https://en.wikipedia.org/wiki/Bubble_sort
     * Average performance: O(n^2)
     * @param a  array of ints to be sorted
     */
    private static void bubbleSortOptimized(int[] a) {
        for (int last = a.length - 1; last > 0; --last) {
            for (int i = 0; i < last; ++i) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i];
                    a[i] = a[i + 1];
                    a[i + 1] = temp;
                }
            }
        }
    }

    private static String toString(int[] a) {
        String s = "[";
        for (int i : a) {
            s += " " + i;
        }
        return s + " ]";
    }

    public static double runTrial(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; ++i)
            a[i] = StdRandom.uniform(1000000);
        Stopwatch timer = new Stopwatch();
        bubbleSortOptimized(a);
        return timer.elapsedTime();
    }

    public static void main(String[] unused) {
        int n = 512;
        double previous = runTrial(n/512);
        for (; true; n *= 2) {
            double current = runTrial(n);
            double ratio = current / previous;
            StdOut.printf("%7d %4.2f\n", n, ratio);
            previous = current;
        }
    }

}