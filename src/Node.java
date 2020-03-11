/** Definition for a list of integer of arbitrary length. */
public class Node {

    /** An integer item. */
    int item;

    /** Next node in the list. */
    Node next;

    /**
     * Return the length of list.
     * @param list  a list
     * @return the number of nodes in the list
     */
    static int length(Node list) {
        if (list == null) {
            return 0;
        }
        return 1 + length(list.next);
    }

    /**
     * Return the sum of the elements in the list.
     * @param list  a list of numbers
     * @return the sum of the elements in the list
     */
    static int sum(Node list) {
        if (list == null) {
            return 0;
        }
        return list.item + sum(list.next);
    }

    /**
     * Return the largest element in the list n.
     *
     * Assumption n has at least one element.
     *
     * @param list  a list of numbers
     * @return the largest element in the list
     */
    static int max(Node list) {
        if (list.next == null) {
            // Singleton list case.
            return list.item;
        }
        // More than one element in the list.
        if (list.item > max(list.next)) {
            return list.item;
        }
        else {
            return max(list.next);
        }
    }

    /**
     * Return true if lists n and m are equal.
     *
     * List n and m are equal if they have the same number of
     * elements and each element at a given position are the same.

     * @param n  a list of numbers
     * @param m  another list of numbers
     * @return true if the lists n and m contains the same elements.
     */
    static boolean equals(Node n, Node m) {
        if (length(n) != length(m)) {
            return false;
        }
        if (length(n) == 0) {
            return true;
        }
        if (n.item == m.item) {
            return equals(n.next, m.next);
        }
        return false;
    }

    private String toStringHelper() {
        if (next == null) {
            return Integer.toString(item);
        }
        return Integer.toString(item) + ", " + next.toStringHelper();
    }

    public String toString() {
        return "[ " + toStringHelper() + " ]";
    }

}