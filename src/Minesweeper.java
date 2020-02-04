public class Minesweeper {
    public static void main(String[] args) {
        StdOut.println("welcome to MineSweeper");
        int size=10;
        boolean minefield[][]=new boolean[size][size];
        int numMines=5;
        initMinefield(minefield,numMines);
        drawMinefield(minefield);
        while(!hasWon(minefield)){
            processClick();
            drawMinefield(minefield);
        }
    }

    private static void processClick() {

    }

    private static boolean hasWon(boolean[][] minefield) {

        return true;
    }

    private static void drawMinefield(boolean[][] minefield) {

    }

    private static void initMinefield(boolean[][] minefield, int numMines) {

    }

    public static int countNeighboringMines(boolean[][] minefield,int x,int y) {
        int count=0;
        for (int i=x-1;i<=x+1;i++){
            for(int j=y-1; j<=y+1; j++){
                if(i>=0&&i<minefield.length&&j>=0&&j<minefield.length && minefield[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}
