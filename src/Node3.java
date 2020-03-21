public class Node3 {

    private int value;
    private Node3 next;

    public Node3() {
        this(0);
    }

    public Node3(int v) {
        value = v;
        next = null;
    }

    public int getValue() { return value; }

    public Node3 add(int v) {
        Node3 n = new Node3(v);
        n.next = this;
        return n;
    }

    public int size() {
        if (next == null) { return 1; }
        return 1 + this.next.size();
    }

    public boolean equals(Node3 that) {
        if (this.size() != that.size()) { return false; }
        if (this.value != that.value) { return false; }
        if (this.next == null) { return true; }
        return this.next.equals(that.next);
    }

    private String toStringHelper() {
        if (next == null) { return String.valueOf(value); }
        return value + ", " + next.toStringHelper();
    }

    public String toString() {
        return "(" + toStringHelper() + ")";
    }

    public static void main(String[] unused) {
        In file = new In("nums.txt");
        Node3 other = new Node3();

        Node3 head = new Node3(file.readInt());
        while (!file.isEmpty()) {
            head = head.add(file.readInt());
        }

        StdOut.println("Size of list is " + head.size());
        StdOut.println(head);
    }

}
