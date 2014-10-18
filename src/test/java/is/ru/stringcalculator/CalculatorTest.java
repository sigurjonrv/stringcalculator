package is.ru.stringcalculator;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class CalculatorTest {

    public static void main(String args[]) {
      org.junit.runner.JUnitCore.main("is.ru.stringcalculator.CalculatorTest");
    }

    @Test
    public void testEmptyString() {
        assertEquals(0, Calculator.add(""));
    }

    @Test
    public void testOneNumber() {
        assertEquals(1, Calculator.add("1"));
    }

    @Test
    public void testTwoNumbers() {
        assertEquals(3, Calculator.add("1,2"));
    }   

    @Test
    public void testMultipleNumbers(){
        assertEquals(6, Calculator.add("1,2,3"));
    }

    @Test
    public void testManyNumbers(){
        assertEquals(36, Calculator.add("1,2,3,4,5,6,7,8"));
    }
    @Test
    public void testNumbersNewline(){
        assertEquals(5, Calculator.add("2\n3"));
    }
    @Test
    public void testNumbersBoth(){
        assertEquals(6, Calculator.add("1,2\n3"));
    }
    @Test
    public void testNumbersBoth2(){
        assertEquals(13, Calculator.add("1,2\n3,4\n1\n2"));
    }
    @Test
    public void testNumberDelimiter(){
        assertEquals(3, Calculator.add("//;\n1;2"));
    }
    @Test
    public void testNumberDelimiter2(){
        assertEquals(3, Calculator.add("//]\n1]2"));
    }
    @Test
    public void testNumberDelimiter3(){
        assertEquals(7, Calculator.add("//}\n1}2,4"));
    }
    @Test
    public void testNegativNumber(){
        try
        {
            Calculator.add("-1,2");
        } catch(RuntimeException ex)
        {
            //
        }
    }
     @Test
        public void testBigNumber(){
            assertEquals(2, Calculator.add("1001,2"));
    }
    @Test
        public void testBigNumber2(){
            assertEquals(0, Calculator.add("1001,2000"));
    }
    @Test
        public void testBigNumber3(){
            assertEquals(2000, Calculator.add("1000,1000"));
    }
    @Test
        public void testBigNumber4(){
            assertEquals(5, Calculator.add("5,2000"));
    }
    @Test
        public void testDelimeterLengt(){
            assertEquals(6, Calculator.add("//[***]\n1***2***3"));
    }
    @Test
        public void testDelimeterLengt2(){
            assertEquals(6, Calculator.add("//[^^^^]\n1^^^^2^^^^3"));
    }
    @Test
        public void testDelimeterLengt3(){
            assertEquals(6, Calculator.add("//[aaa]\n1aaa2aaa3"));
    }
}