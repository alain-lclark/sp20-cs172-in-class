/** Definition for a list of integer of arbitrary length. */
public class Node {

    /** An integer item. */
    int item;

    /** Next node in the list. */
    Node next;

    /**
     * Return the length of list start at n.
     * @param list  a list
     * @return the number of nodes in the list n
     */
    static int length(Node list) {
        if (list == null) {
            return 0;
        }
        int length = 1;
        Node here = list;
        while (here.next != null) {
            ++length;
            here = here.next;
        }
        return length;
    }

    /**
     * Return the sum of the elements in the list n.
     * @param n  a list of numbers
     * @return the sum of the elements in the list n
     */
    static int sum(Node n) {
        return 0;
    }

    /**
     * Return the largest element in the list n.
     * @param n  a list of numbers
     * @return the largest element in the list n
     */
    static int max(Node n) {
        return 0;
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
        return false;
    }

}