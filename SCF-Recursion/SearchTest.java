import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import org.junit.jupiter.api.Test;

public class SearchTest {
    @Test
    void LinearTest_Basic(){
        Search search = new Search();
        assertEquals(2 , search.linearSearch(new int[]{1,5,3,4,7,6,9} , 3 ,0));
        assertEquals(3 , search.linearSearch(new int[]{4,6,3,-3,5,-6} , -3 ,0));
        assertEquals(6 , search.linearSearch(new int[]{4,3,2,7,8,-2,0} , 0 ,0));
    }

    @Test
    void LinearTest_EmptyArrayAssertionArror(){
        Search search = new Search();
        assertThrows(AssertionError.class , ()->search.linearSearch(new int[]{}, 0, 0));
    }

    @Test
    void BinaryTest_Basic(){
        Search search = new Search();
        assertEquals(2 , search.binarySearch(new int[]{1,2,3,4,7,8,9} , 3 ,0,6));
        assertEquals(0 , search.binarySearch(new int[]{-3,-6,3,4,5,6} , -3 ,0,5));
        assertEquals(1 , search.binarySearch(new int[]{-2,0,2,3,7,8,10} , 0 ,0,6));
    }

    @Test
    void BinaryTest_EmptyArrayAssertionArror(){
        Search search = new Search();
        assertThrows(AssertionError.class , ()->search.binarySearch(new int[]{}, 0, 0,-1));
    }
}
