public class NodeExample {

    static public void main(String[] unused) {
        Node n1 = new Node();
        Node n2 = new Node();
        Node n3 = new Node();
        n1.item = 1;
        n1.next = n2;
        n2.item = 2;
        n2.next = n3;
        n3.item = 3;
        n3.next = null;
    }

}