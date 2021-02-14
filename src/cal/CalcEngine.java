package cal;

public class CalcEngine{    
	
    // Are we already building a value in the display, or will the
    // next digit be the first of a new one?
    protected boolean buildingDisplayValue;
    protected boolean haveLeftOperand;
    protected char lastOperator;
    // The current value shown in the display.
    protected String displayString;
    protected int leftOperand;
    private Postfix pf = new Postfix();

    /**
     * Create a CalcEngine.
     */
    public CalcEngine()
    {
        clear();
    }

    /**
     * @return The value that should currently be displayed
     * on the calculator display.
     */
    public String getDisplayValue() {
        return displayString;
    }

    /**
     * A number button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     * @param number The number pressed on the calculator.
     */
    public void buttonPressed(String command) {
		displayString += command;
	}
    
    public void evaluatePostfixDec (String ifx) {
    	try {
    		displayString = pf.evaluate(pf.infixToPostfix(ifx));
    	}
    	catch (Exception e) {
    		keySequenceError();
    	}
    }
    
    public void evaluatePostfixHexa (String ifx) {
    	try {
    		displayString = pf.evaluateHexa(pf.infixToPostfix(ifx));
    	}
    	catch (Exception e) {
    		keySequenceError();
    	}
    }
    
    /**
     * The 'C' (clear) button was pressed.
     * Reset everything to a starting state.
     */
    public void clear() {
        lastOperator = '?';
        haveLeftOperand = false;
        buildingDisplayValue = false;
        displayString = "";
    }

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle() {
        return "Java Calculator";
    }

    /**
     * @return The author of this engine.
     */
    public String getAuthor() {
        return "David J. Barnes and Michael Kolling";
    }

    /**
     * @return The version number of this engine.
     */
    public String getVersion() {
       return "Version 1.0";
    }

    protected void keySequenceError() {
        System.out.println("A key sequence error has occurred.");
        // Reset everything.
        clear();
    }
}
