public class NodeExample {

    public static void main(String[] unused) {

        In file = new In("nums.txt");

        Node head = null;

        while (!file.isEmpty()) {
            Node n = new Node();
            n.value = file.readInt();
            n.next = head;
            head = n;
        }

        StdOut.println("Size of list is " + size(head));
        print(head);
    }

    public static int size(Node list) {
        if (list == null) { return 0; }
        return 1 + size(list.next);
    }

    public static boolean equals(Node list1, Node list2) {
        if (size(list1) != size(list2)) { return false; }
        if (list1 == null) { return true; }
        if (list1.value != list2.value) { return false; }
        return equals(list1.next, list2.next);
    }

    public static void print(Node list) {
        StdOut.print("(");
        while (list != null) {
            StdOut.print(list.value);
            if (list.next != null) { StdOut.print(", "); }
            list = list.next;
        }
        StdOut.println(")");
    }

}
