package cal;

public class Test {
    
    public static void main(String[] args) throws Underflow, Overflow {
   	 
   	 ExtendedCalculator calc = new ExtendedCalculator();

   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "1+2*3");
   	 String result = calc.engine.displayString;
   	 System.out.println("The result: " + result);
   	 System.out.println("Exected: 7");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(1+2)*3");
   	 String result1 = calc.engine.displayString;
   	 System.out.println("The result: " + result1);
   	 System.out.println("Exected: 9");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(1*2)+3");
   	 String result2 = calc.engine.displayString;
   	 System.out.println("The result: " + result2);
   	 System.out.println("Exected: 5");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(1)*(2)+(3)");
   	 String result3 = calc.engine.displayString;
   	 System.out.println("The result: " + result3);
   	 System.out.println("Exected: 5");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "2*(2+3)");
   	 String result4 = calc.engine.displayString;
   	 System.out.println("The result: " + result4);
   	 System.out.println("Exected: 10");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "9/3+5");
   	 String result5 = calc.engine.displayString;
   	 System.out.println("The result: " + result5);
   	 System.out.println("Exected: 8");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "2*2*2-4");
   	 String result6 = calc.engine.displayString;
   	 System.out.println("The result: " + result6);
   	 System.out.println("Exected: 4");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "2*2*2+4");
   	 String result7 = calc.engine.displayString;
   	 System.out.println("The result: " + result7);
   	 System.out.println("Exected: 12");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "2*2*(2+4)");
   	 String result8 = calc.engine.displayString;
   	 System.out.println("The result: " + result8);
   	 System.out.println("Exected: 24");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(2-2)*(2+4)");
   	 String result9 = calc.engine.displayString;
   	 System.out.println("The result: " + result9);
   	 System.out.println("Exected: 0");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(2-2)*(2-4)");
   	 String result10 = calc.engine.displayString;
   	 System.out.println("The result: " + result10);
   	 System.out.println("Exected: 0");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(2+1)*(2+2)+(6/2)");
   	 String result11 = calc.engine.displayString;
   	 System.out.println("The result: " + result11);
   	 System.out.println("Exected: 15");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(2+1)*(2+2)/(2+2)");
   	 String result12 = calc.engine.displayString;
   	 System.out.println("The result: " + result12);
   	 System.out.println("Exected: 3");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(2+1)*(2+2)/(3-2)");
   	 String result13 = calc.engine.displayString;
   	 System.out.println("The result: " + result13);
   	 System.out.println("Exected: 12");
   	 
   	 calc.engine.evaluatePostfixDec(calc.engine.displayString = "(2+1)/(3-2)");
   	 String result14 = calc.engine.displayString;
   	 System.out.println("The result: " + result14);
   	 System.out.println("Exected: 3");
   	 
   	 calc.engine.evaluatePostfixHexa(calc.engine.displayString = "(F+F)*2");
   	 String result15 = calc.engine.displayString;
   	 System.out.println("The result: " + result15);
   	 System.out.println("Exected: 3c");

   	 calc.engine.evaluatePostfixHexa(calc.engine.displayString = "F+F*2");
   	 String result16 = calc.engine.displayString;
   	 System.out.println("The result: " + result16);
   	 System.out.println("Exected: 2d");

   	 calc.engine.evaluatePostfixHexa(calc.engine.displayString = "(F+F)/2");
   	 String result17 = calc.engine.displayString;
   	 System.out.println("The result: " + result17);
   	 System.out.println("Exected: f");

   	 calc.engine.evaluatePostfixHexa(calc.engine.displayString = "(F-F)*2");
   	 String result18 = calc.engine.displayString;
   	 System.out.println("The result: " + result18);
   	 System.out.println("Exected: 0");
    
    }
}
