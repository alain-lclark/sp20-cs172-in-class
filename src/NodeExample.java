public class NodeExample {

    static public void main(String[] unused) {

        // Read numbers from a file and create a list.
        In f = new In("nums.txt");

        Node head = new Node(f.readInt());

        while (!f.isEmpty()) {
            head.add(f.readInt());
        }

        // Print some properties of the list.
        StdOut.println("The content of the list is " + head);
        StdOut.println("The length of the list is " + head.length());
        //StdOut.println("Sum of the elements in the list is " + Node.sum(head));
        //StdOut.println("Largest element in the list is " + Node.max(head));
    }

}