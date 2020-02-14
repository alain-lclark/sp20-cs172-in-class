public class Minesweeper {
    public static void main(String[] args) {
        StdOut.println("Welcome to MineSweeper");
        int size=10;
        boolean minefield[][]=new boolean[size][size];
        boolean revealed[][] = new boolean[size][size];
        int numMines=5;
        StdDraw.setScale(-0.5, minefield.length - .5);
        StdDraw.enableDoubleBuffering();
        initMinefield(minefield,numMines);
        printMinefield(minefield);
        drawMinefield(minefield, revealed);
        while(!hasWon(minefield, revealed)){
            processClick(minefield, revealed);
            drawMinefield(minefield, revealed);
            if (hasWon(minefield, revealed)) {

                StdOut.println("You Win!") ;
            }
        }

    }

    private static void processClick(boolean[][] minefield, boolean[][] revealed) {

        while (!StdDraw.isMousePressed()) {

            // do nothing!!!!!!
        }
        int x = (int)Math.round(StdDraw.mouseX()) ;
        int y = (int)Math.round(StdDraw.mouseY()) ;

        while (StdDraw.isMousePressed()) {
            // do nothing again!!!!!!!!
        }
        StdOut.println(x + ", " + y);
        autoClear(minefield, revealed, x, y) ;

        if (minefield[x][y]){

            StdOut.println("BOOM!");
        } else {
            StdOut.println("SAFE");
        }


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

    private static void drawMinefield(boolean[][] minefield, boolean[][] revealed) {

        StdDraw.clear();
        for (int x = 0 ; x < minefield.length ; ++x) {
            for (int y = 0 ; y < minefield.length ; ++y) {

                if (!revealed[x][y]) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x, y, .5);
                    StdDraw.setPenColor();
                }
                else if (minefield[x][y]) {
                    StdDraw.setPenColor(StdDraw.RED);
                    StdDraw.filledCircle(x, y, .15);
                    StdDraw.setPenColor();
                } else {
                    int n = countNeighboringMines(minefield, x, y) ;
                    if (n != 0 ){
                        StdDraw.text(x, y, "" + n) ;
                    }
                }
                StdDraw.square(x, y, .5);
            }
        }
        StdDraw.show();
    }

    private static void initMinefield(boolean[][] minefield, int numMines) {

        for (int i = 0; i < numMines ; ++i) {

            int x = StdRandom.uniform(minefield.length) ;
            int y = StdRandom.uniform(minefield.length) ;
            if (minefield[x][y]) {
                --i ;
            } else {
                minefield[x][y] = true ;
            }
        }

    }

    public static void printMinefield(boolean[][] minefield) {

        for (int y = minefield.length - 1 ; y >= 0 ; --y) {
            for (int x = 0 ; x < minefield.length ; ++x) {

                if (minefield[x][y]) {

                    StdOut.print('*') ;
                } else {
                    StdOut.print('.') ;
                }
            }
            StdOut.println() ;
        }
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
