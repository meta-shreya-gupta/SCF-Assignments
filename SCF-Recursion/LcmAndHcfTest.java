import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class LcmAndHcfTest {
    @Test
    void HcfTest_Basic(){
        LcmAndHcf hcfObj = new LcmAndHcf();
        assertEquals(5 , hcfObj.hcf(5,10));
        assertEquals(1 , hcfObj.hcf(47,97));
        assertEquals(2 , hcfObj.hcf(2,6));
    }

    @Test
    void HcfTest_NegativeNumber(){
        LcmAndHcf hcfObj = new LcmAndHcf();
        assertThrows(AssertionError.class,()->hcfObj.hcf(-2,-5));
        assertThrows(AssertionError.class,()->hcfObj.hcf(-2,5));
        assertThrows(AssertionError.class,()->hcfObj.hcf(2,-5));
    }

    @Test
    void LcmTest_Basic(){
        LcmAndHcf lcmObj = new LcmAndHcf();
        assertEquals(10 , lcmObj.lcm(5,10));
        assertEquals(4559 , lcmObj.lcm(47,97));
        assertEquals(6 , lcmObj.lcm(2,6));
    }

    @Test
    void LcmTest_NegativeNumber(){
        LcmAndHcf lcmObj = new LcmAndHcf();
        assertThrows(AssertionError.class,()->lcmObj.lcm(-2,-5));
        assertThrows(AssertionError.class,()->lcmObj.lcm(-2,5));
        assertThrows(AssertionError.class,()->lcmObj.lcm(2,-5));
    }
}
