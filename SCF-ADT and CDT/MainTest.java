import org.junit.jupiter.api.Test;
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

    
}
