import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
public class MatricesTest {
    @Test
    void transposeOfMatrixTest(){
        int[][] array1 = {{0,0,0,0,9,0},{0,8,0,0,0,0},{4,0,0,2,0,0},{0,0,0,0,0,5},{0,0,2,0,0,0}};
        MatricesOperation input1 = new MatricesOperation(5, 6, array1);
        MatricesOperation output1 = input1.transposeOfMatrix();
        int[][] actualOutput = output1.getArray();
        int[][] expectedOutput = {{0,0,4,0,0},{0,8,0,0,0},{0,0,0,0,2},{0,0,2,0,0},{9,0,0,0,0},{0,0,0,5,0}};
        assertArrayEquals(expectedOutput,actualOutput);
    }

    @Test
    void isSymmetricalTest(){
        int[][] array1 = {{0,0,0,0,9,0},{0,8,0,0,0,0},{4,0,0,2,0,0},{0,0,0,0,0,5},{0,0,2,0,0,0}};
        MatricesOperation input1 = new MatricesOperation(5, 6, array1);
        boolean actualOutput = input1.isSymmetrical();
        boolean expectedOutput = false;
        assertEquals(expectedOutput,actualOutput);
    }

    @Test
    void addMatricesTest(){
        int[][] array1 = {{1,2,3},{1,2,3},{1,2,3}};
        MatricesOperation input1 = new MatricesOperation(3, 3, array1);
        int[][] array2 = {{4,5,6},{4,5,6},{4,5,6}};
        MatricesOperation input2 = new MatricesOperation(3, 3, array2);
        MatricesOperation output = input1.addMatrices(input2);
        int[][] actualOutput = output.getArray();
        int[][] output1 = {{5,7,9},{5,7,9},{5,7,9}};
        MatricesOperation expectedArray = new MatricesOperation(3, 3, output1);
        int[][] expectedOutput = expectedArray.getArray();
        assertArrayEquals(expectedOutput,actualOutput);
    }

    @Test
    void multiplyMatricesTest(){
        int[][] array1 = {{1,2,3},{1,2,3},{1,2,3}};
        MatricesOperation input1 = new MatricesOperation(3, 3, array1);
        int[][] array2 = {{4,5,6},{4,5,6},{4,5,6}};
        MatricesOperation input2 = new MatricesOperation(3, 3, array2);
        MatricesOperation output = input1.multiplyMatrices(input2);
        int[][] actualOutput = output.getArray();
        int[][] output1 = {{24,30,36},{24,30,36},{24,30,36}};
        MatricesOperation expectedArray = new MatricesOperation(3, 3, output1);
        int[][] expectedOutput = expectedArray.getArray();
        assertArrayEquals(expectedOutput,actualOutput);
    }
}
