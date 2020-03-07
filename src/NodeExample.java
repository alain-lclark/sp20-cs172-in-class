public class NodeExample {

    static public void main(String[] unused) {

        // Read numbers from a file and create a list.
        In f = new In("nums.txt");

        Node head = null;

        while (!f.isEmpty()) {
            Node n = new Node();

            n.item = f.readInt();
            n.next = head;

            head = n;
        }

        // Print some properties of the list.
        StdOut.println("The length of the list is " + Node.length(head));
        StdOut.println("Sum of the elements in the list is " + Node.sum(head));
        StdOut.println("Largest element in the list is " + Node.max(head));
    }

}