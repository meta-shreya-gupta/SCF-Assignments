import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;
import java.util.Arrays;
public class MainTest{
    @Test
    void isMemberTest_positive(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        assertEquals(true,set.isMember(7));
    }
    @Test
    void isMemberTest_negative(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        assertEquals(false,set.isMember(4));
    }

    @Test
    void sizeTest(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        assertEquals(6,set.size());
    }

    @Test
    void isSubsetTest_Positive(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        assertEquals(true, set.isSubSet(new IntSet(new ArrayList<>(Arrays.asList(1,7)))));
    }

    @Test
    void isSubsetTest_Negative(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        assertEquals(false, set.isSubSet(new IntSet(new ArrayList<>(Arrays.asList(1,9)))));
    }

    @Test
    void getComplimentTest(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        IntSet actualComplimentSet = set.getCompliment();
        boolean[] actualSet = actualComplimentSet.getElements();
        IntSet expectedComplimentSet = new IntSet(new ArrayList<>(Arrays.asList(3,4,6,8,9,10,11,12,13,14,16,17,18,20)));
        boolean[] expectedSet = expectedComplimentSet.getElements();
        assertArrayEquals(expectedSet,actualSet);
    }

    @Test
    void getUnionTest(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        IntSet s = new IntSet(new ArrayList<>(Arrays.asList(3,5,8,18)));
        IntSet expectedUnionSet = new IntSet(new ArrayList<>(Arrays.asList(1,2,3,5,7,8,15,18,19)));
        boolean[] expectedUnion = expectedUnionSet.getElements();
        IntSet actualUnionSet = set.getUnion(s);
        boolean [] actualUnion = actualUnionSet.getElements();
        assertArrayEquals(expectedUnion, actualUnion);
    }
    
    @Test
    void getDifferenceTest(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        IntSet s = new IntSet(new ArrayList<>(Arrays.asList(3,5,8,18)));
        IntSet expectedDifferenceSet = new IntSet(new ArrayList<>(Arrays.asList(1,2,7,15,19)));
        boolean[] expectedDifference = expectedDifferenceSet.getElements();
        IntSet actualDifferenceSet = set.getDifference(s);
        boolean [] actualDifference = actualDifferenceSet.getElements();
        assertArrayEquals(expectedDifference, actualDifference);
    }

    @Test
    void getIntersectionTest(){
        IntSet set = new IntSet(new ArrayList<>(Arrays.asList(1,2,5,7,15,19)));
        IntSet s = new IntSet(new ArrayList<>(Arrays.asList(3,5,8,18)));
        IntSet expectedIntersectionSet = new IntSet(new ArrayList<>(Arrays.asList(5)));
        boolean[] expectedIntersection = expectedIntersectionSet.getElements();
        IntSet actualIntersectionSet = set.getIntersection(s);
        boolean [] actualIntersection = actualIntersectionSet.getElements();
        assertArrayEquals(expectedIntersection, actualIntersection);
    }

}
