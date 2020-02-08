public class Minesweeper {
    public static void main(String[] args) {
        StdOut.println("welcome to MineSweeper");
        int size=10;
        boolean minefield[][]=new boolean[size][size];
        boolean revealed[][] = new boolean[size][size];
        int numMines=5;
        initMinefield(minefield,numMines);
        drawMinefield(minefield);
        while(!hasWon(minefield, revealed)){
            processClick();
            drawMinefield(minefield);
        }
    }

    private static void processClick() {

    }

    public static boolean hasWon(boolean[][] minefield, boolean[][] revealed) {
        for(int i = 0; i < minefield.length; i++) {
            for(int j = 0; j < minefield.length; j++) {
                if(!(revealed[i][j] || minefield[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void autoClear(boolean[][] minefield, boolean[][] revealed, int x, int y) {
        if(!revealed[x][y]) {
            revealed[x][y] = true;
            if (countNeighboringMines(minefield, x, y) == 0) {
                for (int i = x - 1; i <= x + 1; i++) {
                    for (int j = y - 1; j <= y + 1; j++) {
                        if(i >= 0 && i < minefield.length && j >= 0 && j < minefield.length) {
                            autoClear(minefield, revealed, i, j);
                        }
                    }
                }
            }
        }
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
