import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class testclass extends DarkMarketFish{

    @Test
    public void testcalculate(){

        float number001 = calculate(0, 0, 1);
        float number010 = calculate(0, 1, 0);
        float number011 = calculate(0, 1, 1);
        float number100 = calculate(1, 0, 0);
        float number101 = calculate(1, 0, 1);
        float number110 = calculate(1, 1, 0);
        float number111 = calculate(1, 1, 1);

        String str001 = String.valueOf(number001);                
        String str010 = String.valueOf(number010);
        String str011 = String.valueOf(number011);
        String str100 = String.valueOf(number100);
        String str101 = String.valueOf(number101);
        String str110 = String.valueOf(number110);
        String str111 = String.valueOf(number111);

        assertEquals("150.0" , str001);
        assertEquals("99.0" , str010);
        assertEquals("249.0" , str011);
        assertEquals("30.0" , str100);
        assertEquals("180.0" , str101);
        assertEquals("129.0" , str110);
        assertEquals("279.0" , str111);
    }
}
