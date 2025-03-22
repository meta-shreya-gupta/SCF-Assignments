import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;
public class MatricesTest {
    @Test
    public void testTranspose(){
        int[][] matrix ={
            {1,0,2},
            {0,3,0},
            {4,0,5}
        };
        MatricesOperation matricesOperation = new MatricesOperation(3, 3, matrix);
        MatricesOperation transpose = matricesOperation.transposeOfMatrix();
        int[][] expected = {
            {1,0,4},
            {0,3,0},
            {2,0,5}
        };
        assertArrayEquals(expected, transpose.toMatrix(transpose.sparseArray));
    }
    @Test
    public void isSymmetricalTest_Positive(){
        int[][] matrix1 = {
            {1,0,2},
            {0,3,0},
            {2,0,4}
        };
        MatricesOperation input1 = new MatricesOperation(3, 3, matrix1);
        assertEquals(true, input1.isSymmetrical());
    }

    @Test
    public void isSymmetricalTest_Negative(){
        int[][] matrix1 = {
            {1,0,7},
            {0,0,0},
            {1,0,4}
        };
        MatricesOperation input1 = new MatricesOperation(3, 3, matrix1);
        assertEquals(false, input1.isSymmetrical());
    }
    @Test
    public void addMatricesTest(){
        int[][] matrix1 = {
            {1,0,2},
            {0,3,0},
            {2,0,4}
        };
        int[][] matrix2 = {
            {2,0,1},
            {0,4,0},
            {3,0,2}
        };
        MatricesOperation input1 = new MatricesOperation(3, 3, matrix1);
        MatricesOperation input2 = new MatricesOperation(3, 3, matrix2);
        MatricesOperation sum = input1.addMatrices(input2);
        int[][] expected = {
            {3,0,3},
            {0,7,0},
            {5,0,6}
        };
        assertArrayEquals(expected, sum.toMatrix(sum.sparseArray));
    }

    @Test
    public void multiplyMatricesTest(){
        int[][] matrix1 = {
            {1,0,2},
            {0,3,0},
            {4,0,5}
        };
        int[][] matrix2 = {
            {2,0,1},
            {0,4,0},
            {3,0,2}
        };
        MatricesOperation input1 = new MatricesOperation(3, 3, matrix1);
        MatricesOperation input2 = new MatricesOperation(3, 3, matrix2);
        MatricesOperation product = input1.multiplyMatrices(input2);
        int[][] expected = {
            {8,0,5},
            {0,12,0},
            {23,0,14}
        };
        assertArrayEquals(expected, product.toMatrix(product.sparseArray));
    }
}
