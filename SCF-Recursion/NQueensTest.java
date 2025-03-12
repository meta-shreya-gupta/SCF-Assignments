import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class NQueensTest {
    
    @Test
    void NQueens_checkMinimumLength(){
        NQueens queen = new NQueens();
        assertThrows(AssertionError.class,()->queen.positionOfQueens(new int[][] {{0,0},{0,0}},0,2));
    }

    @Test
    void NQueens_Basic(){
        NQueens queen = new NQueens();
        int[][] input1 = new int[][] {{0,0,0,0},{0,0,0,0},{0,0,0,0},{0,0,0,0}};
        int[][] input2 = new int[][] {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        assertEquals(true , queen.positionOfQueens(input1, 0, 4));
        assertEquals(true , queen.positionOfQueens(input2, 0, 5));
    }
}
