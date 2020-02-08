import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {

    @org.junit.jupiter.api.Test
    void countNeighboringMines() {
        boolean[][]minefield= new boolean[3][3];
        minefield[1][0]=true;
        assertEquals(1, Minesweeper.countNeighboringMines(minefield,0,0));
        assertEquals(0, Minesweeper.countNeighboringMines(minefield,2,2));
    }

    @org.junit.jupiter.api.Test
    void aWinner() {
        boolean[][]minefield= new boolean[3][3];
        minefield[1][0]=true;
        boolean[][] revealed = new boolean[3][3];
        revealed[0][0] = true;
        revealed[0][1] = true;
        revealed[0][2] = true;
        revealed[1][1] = true;
        revealed[1][2] = true;
        revealed[2][0] = true;
        revealed[2][1] = true;
        revealed[2][2] = true;
        assertTrue(Minesweeper.hasWon(minefield, revealed));
    }

    @org.junit.jupiter.api.Test
    void aLoser() {
        boolean[][]minefield= new boolean[3][3];
        minefield[1][0]=true;
        boolean[][] revealed = new boolean[3][3];
        revealed[0][0] = true;
        revealed[0][1] = true;
        revealed[0][2] = true;
        revealed[1][1] = true;
        revealed[1][2] = true;
        revealed[2][0] = true;
        revealed[2][1] = true;
        assertFalse(Minesweeper.hasWon(minefield, revealed));
    }

}