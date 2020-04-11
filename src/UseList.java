public class UseList {

    static void readList(List<Integer> list) {
        In file = new In("nums.txt");
        while (!file.isEmpty()) {
            list.add(file.readInt());
        }
    }

    static int sumList(List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); ++i) {
            sum += list.get(i);
        }
        return sum;
    }

    public static void main(String[] unused){
        List<Integer> list = new List();

        readList(list);

        StdOut.println(sumList(list));
    }

}