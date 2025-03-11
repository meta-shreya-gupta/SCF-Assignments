import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertArrayEquals;

public class ArrOperationTest {
    @Test
    void maxMirrorTest(){
        ArrOperation MaximumMirror = new ArrOperation();
        /**----------Normal Test Cases---------- */
        assertEquals(3,MaximumMirror.maxMirror(new int[]{1,2,3,8,9,3,2,1}));
        assertEquals(2,MaximumMirror.maxMirror(new int[]{7,1,4,9,7,4,1}));
        assertEquals(3,MaximumMirror.maxMirror(new int[]{1,2,1,4}));
        assertEquals(7,MaximumMirror.maxMirror(new int[]{1,4,5,3,5,4,1}));
        /**----------AssertionError empty array Test Cases---------- */
        assertThrows(AssertionError.class, ()->MaximumMirror.maxMirror(new int[]{}));
    }

    @Test
    void countClumps(){
        ArrOperation clumps = new ArrOperation();
        /**----------Normal Test Cases---------- */
        assertEquals(2, clumps.countClumps(new int[]{1,2,2,3,4,4}));
        assertEquals(2, clumps.countClumps(new int[]{1,1,2,1,1}));
        assertEquals(1, clumps.countClumps(new int[]{1,1,1,1,1}));
        /**----------AssertonError empty arrayTest Cases---------- */
        assertThrows(AssertionError.class, ()->clumps.countClumps(new int[]{}));
    }

    @Test
    void fixXY(){
        ArrOperation fix = new ArrOperation();
        /**----------Normal Test Cases---------- */
        assertArrayEquals(new int[] {9,4,5,4,5,9} , fix.fixXY(new int[]{5,4,9,4,9,5}, 4, 5));
        assertArrayEquals(new int[] {1,4,5,1} , fix.fixXY(new int[]{1,4,1,5}, 4, 5));
        assertArrayEquals(new int[] {1,4,5,1,1,4,5} , fix.fixXY(new int[]{1,4,1,5,5,4,1}, 4, 5));
        /**----------AssertionError empty array Test Cases---------- */
        assertThrows(AssertionError.class, ()->fix.fixXY(new int[]{},4,5));
        /**----------AssertionError Enqual X and Y Test Cases---------- */
        assertThrows(AssertionError.class, ()->fix.fixXY(new int[]{4,1,5,2,5},4,5));
        /**----------AssertionError Adjacent X Test Cases---------- */
        assertThrows(AssertionError.class, ()->fix.fixXY(new int[]{1,2,4,4,2,5,5},4,5));
        /**----------AssertionError X at lst index Test Cases---------- */
        assertThrows(AssertionError.class, ()->fix.fixXY(new int[]{5,3,4,3,5,4},4,5));
    }

    @Test
    void splitArray(){
        ArrOperation split = new ArrOperation();
        /**----------Normal Test Cases---------- */
        assertEquals(3,split.splitArray(new int[]{1,1,1,2,1}));
        assertEquals(-1,split.splitArray(new int[]{2,1,1,2,1}));
        assertEquals(1,split.splitArray(new int[]{10,10}));
        /**----------AssertionError empty array Test Cases---------- */
        assertThrows(AssertionError.class, ()->split.splitArray(new int[]{}));
    }
}
