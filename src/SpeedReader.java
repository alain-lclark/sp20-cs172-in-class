public class SpeedReader {
    public static void main(String[] args) {
        for (;;) {
            In file = new In("speed.txt");
            while (!file.isEmpty()) {
                String s = file.readLine();
                int i = 0;
                while (i < s.length()) {
                    String w = "";
                    for (; i < s.length() && s.charAt(i) != ' '; i++) {
                        w = w + s.charAt(i);
                    }
                    i++;
                    StdDraw.clear();
                    StdDraw.text(0.5, 0.5, w);
                    StdDraw.pause(255);
                }
            }
        }
    }
}
