/** Definition for an arbitray long, null-terminated list of integers. */
// BEWARE THIS IS NOT HOW YOU'D ACTUALLY IMPLEMENT A LIST.
// FOR THE PURPOSE OF ILLUSTRATING SOME CONCEPTS AROUND CONSTRUCTORS,
// SETTERS, and GETTERS.
public class Node {

    // Assumption: list has at least one element.

    /** An integer value. */
    private int value;

    /** Next node in the list. */
    private Node next;

    /**
     * Construct a list element with the given value
     * @param value  initial value of the list element
     */
    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    /**
     * Construct a list element.
     */
    public Node() {
        this(0); // Initialize the element to some arbitrary value.
    }

    /**
     * Set the value of this list element to the given value.
     * @param value  a new value for this list element
     */
    public void setValue(int value) {
        this.value = value;
    }

    /**
     * Retrieve the value stored in this list element.
     * @return  the current value store in this list element
     */
    public int getValue() {
        return value;
    }

    /**
     * The next element in the list (which may be null).
     * @return  the next element in the list
     */
    public Node getNext() { return next; }

    public void add(int value) {
        Node n = new Node(value);
        n.next = this.next;
        this.next = n;
    }

    /**
     * Return the length of list.
     * @return the number of nodes in the list
     */
    int length() {
        if (next == null) {
            return 1;
        }
        return 1 + next.length();
    }

    /**
     * Return the sum of the elements in the list.
     * @return the sum of the elements in the list
     */
    static int sum() {
        /*
        ORIGINAL STATIC CODE
        if (list == null) {
            return 0;
        }
        return list.value + sum(list.next);
         */
        return -1;
    }

    /**
     * Return the largest element in the list n.
     *
     *
     * @return the largest element in the list
     */
    int max() {
        /*
        ORIGINAL STATIC CODE
        if (list.next == null) {
            // Singleton list case.
            return list.item;
        }
        // More than one element in the list.
        if (list.value > max(list.next)) {
            return list.value;
        }
        else {
            return max(list.next);
        }
         */
        return -1;
    }

    /**
     * Return true if this list has the same content as .
     *
     * This list and otherList are equal if they have the same number of
     * elements and each element at a given position is the same.

     * @param otherList  another list of numbers
     * @return true if this list and the other contain the same elements.
     */
    boolean equals(Node otherList) {
        /*
        if (n.length() != m.length()) {
            return false;
        }
        if (n.length() == 0) {
            return true;
        }
        if (n.value == m.value) {
            return equals(n.next, m.next);
        }
        return false;
         */
        return false;
    }

    /**
     * Add this list to another.
     * @param otherList
     */
    public void add(Node otherList) {
        // TODO
    }

    /**
     * Scale each element of this list by the given factor.
     * @param factor  the scale factor
     */
    public void scale(int factor) {
        // TODO
    }

    private String toStringHelper() {
        if (next == null) {
            return Integer.toString(value);
        }
        return Integer.toString(value) + ", " + next.toStringHelper();
    }

    /**
     * Creates a String representation of this list.
     * @return a String representing the content of this list
     */
    public String toString() {
        return "[ " + toStringHelper() + " ]";
    }

}