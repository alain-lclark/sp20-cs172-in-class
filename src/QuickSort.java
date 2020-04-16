public class QuickSort {

    /**
     * Sort the given array with the QuickSort algorithm.
     * https://en.wikipedia.org/wiki/Quicksort
     * Average performance: O(n log n)
     * @param a  array of ints to be sorted
     */
    private static void quickSort(int[] a) {
        quickSortHelper(a, 0, a.length - 1);
    }

    /**
     * Sort the given array in the range [lo, hi] inclusive.
     * @param a  array of ints, a subrange of which to be sorted
     * @param lo  beginning of the range
     * @param hi  end of the range
     */
    private static void quickSortHelper(int[] a, int lo, int hi) {
        // Divide: partition around the pivot
        if (lo >= hi) return;
        int pivot = a[hi];
        int i = lo;
        for (int j = lo; j <= hi; ++j) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                ++i;
            }
        }
        int temp = a[i]; // Store the pivot in between the low and high partitions
        a[i] = a[hi];
        a[hi] = temp;
        // Conquer: sort the low and high partitions.
        quickSortHelper(a, lo, i - 1);
        quickSortHelper(a, i + 1, hi);
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
        quickSort(a);
        return timer.elapsedTime();
    }

    public static void main(String[] unused) {
        int n = 512;
        double previous = runTrial(n/512);
        for (; true; n *= 2) {
            double current = runTrial(n);
            double ratio = current/previous;
            StdOut.printf("%7d %4.2f\n", n, ratio);
            previous = current;
        }
    }

}