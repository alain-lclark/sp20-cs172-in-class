public class List<E> implements L<E> {

    private class Node {
        E value;
        Node next;

        public Node(E value) {
            this.value = value;
            this.next = null;
        }
    }

    private int size;
    private Node first;
    private Node last;

    public List() {
        size = 0;
        first = null;
        last = null;
    }

    public List add(E value) {
        Node n = new Node(value);
        if (last != null) {
            // Non-empty list case
            assert first != null;
            last.next = n;
            last = n;
        }
        else {
            // Empty list case
            assert last == null && first == null;
            first = n;
            last = n;
        }
        ++size;
        return this;
    }

    public E get(int index) {
        if (index >= size || index < 0) { return null; }
        Node n = first;
        for (int i = 0; i < index; ++i) {
            n = n.next;
        }
        return n.value;
    }

    public int size() {
        return size;
    }

    private String toStringHelper() {
        String s = "";
        Node n = first;
        while (n != null) {
            s += String.valueOf(n.value);
            if  (n.next != null) { s += ", "; }
            n = n.next;
        }
        return s;
    }

    @Override
    public String toString() {
        return "(" + toStringHelper() + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) { return false; }
        if (this.getClass() != o.getClass()) { return false; }
        List that = (List)o;
        if (this.size() != that.size()) { return false; }
        assert this.size() == that.size();
        Node a = this.first;
        Node b = that.first;
        while (a != null) {
            if (a.value != b.value) { return false; }
            a = a.next;
            b = b.next;
        }
        return true;
    }

    public static void main(String[] unused) {
        In file = new In("nums.txt");
        List<Integer> list = new List();
        while (!file.isEmpty()) {
            list.add(file.readInt());
        }
        StdOut.println("Size of the list is " + list.size());
        StdOut.println(list);
    }

}