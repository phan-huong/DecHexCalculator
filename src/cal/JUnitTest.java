package cal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JUnitTest {

    private ExtendedCalculator calc = new ExtendedCalculator();

    @BeforeEach                                         
    public void setUp() throws Exception {
    	calc = new ExtendedCalculator();
    }

    @Test
    @DisplayName("Calculating Decimals")   
    public void testSimpleDec() {
    	calc.engine.evaluatePostfixDec(calc.engine.displayString = "1+2*3");
    	String result = calc.engine.displayString;
        assertEquals("7", result, "Regular decimal calculation should work");
    }
    
    @Test
    @DisplayName("Calculating Decimals")   
    public void testComplexDec() {
    	calc.engine.evaluatePostfixDec(calc.engine.displayString = "(2+1)*(2+2)/(3-2)");
    	String result = calc.engine.displayString;
        assertEquals("12", result, "Regular decimal calculation should work");
    }
    
    @Test
    @DisplayName("Calculating Hexadecimals")   
    public void testSimpleHex() {
    	calc.engine.evaluatePostfixHexa(calc.engine.displayString = "F+F*2");
    	String result = calc.engine.displayString;
        assertEquals("2d", result, "Regular hexadecimal calculation should work");
    }
    
    @Test
    @DisplayName("Calculating Hexadecimals")   
    public void testComplexHex() {
    	calc.engine.evaluatePostfixHexa(calc.engine.displayString = "(F-F)*2");
    	String result = calc.engine.displayString;
        assertEquals("0", result, "Regular hexadecimal calculation should work");
    }
    
}
