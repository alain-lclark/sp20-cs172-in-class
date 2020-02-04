import static org.junit.jupiter.api.Assertions.*;

class MinesweeperTest {

    @org.junit.jupiter.api.Test
    void countNeighboringMines() {
        boolean[][]minefield= new boolean[3][3];
        minefield[1][0]=true;
        assertEquals(1, Minesweeper.countNeighboringMines(minefield,0,0));
        assertEquals(0, Minesweeper.countNeighboringMines(minefield,2,2));
    }

}