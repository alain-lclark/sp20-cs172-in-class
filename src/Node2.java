public class Node2 {

    private int value;
    private Node2 next;

    public void setValue(int v) { value = v; }
    public int getValue() { return value; }
    public void setNext(Node2 n) { next = n; }

    public int size() {
        if (next == null) { return 1; }
        return 1 + this.next.size();
    }

    public boolean equals(Node2 that) {
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

        Node2 head = new Node2();
        head.setValue(file.readInt());
        head.setNext(null);
        while (!file.isEmpty()) {
            Node2 n = new Node2();
            n.setValue(file.readInt());
            n.setNext(head);
            head = n;
        }

        StdOut.println("Size of list is " + head.size());
        StdOut.println(head);
    }

}
