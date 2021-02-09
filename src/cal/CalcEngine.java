package cal;

public class CalcEngine{
    // The calculator's state is maintained in three fields:
    //     buildingDisplayValue, haveLeftOperand, and lastOperator.
    
    // Are we already building a value in the display, or will the
    // next digit be the first of a new one?
    protected boolean buildingDisplayValue;
    // Has a left operand already been entered (or calculated)?
    protected boolean haveLeftOperand;
    // The most recent operator that was entered.
    protected char lastOperator;

    // The current value (to be) shown in the display.
    protected String displayString;
    // The value of an existing left operand.
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
    public String getDisplayValue()
    {
        return displayString;
    }

    /**
     * A number button was pressed.
     * Either start a new operand, or incorporate this number as
     * the least significant digit of an existing one.
     * @param number The number pressed on the calculator.
     */
  
    public void buttonPressed(String command){
		displayString += command;
	}

    public void equals()
    {
    	
    }
    
    public void evaluatePostfixDec (String ifx) {
    	try {
    		displayString = pf.evaluate(pf.infixToPostfix(ifx));
    	}
    	catch (Exception e) {
    		keySequenceError();
    	}
    }
    
    public void evaluatePostfixHexa (String ifx){
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
    public void clear()
    {
        lastOperator = '?';
        haveLeftOperand = false;
        buildingDisplayValue = false;
        displayString = "";
    }

    /**
     * @return The title of this calculation engine.
     */
    public String getTitle()
    {
        return "Java Calculator";
    }

    /**
     * @return The author of this engine.
     */
    public String getAuthor()
    {
        return "David J. Barnes and Michael Kolling";
    }

    /**
     * @return The version number of this engine.
     */
    public String getVersion()
    {
       return "Version 1.0";
    }

    protected void keySequenceError()
    {
        System.out.println("A key sequence error has occurred.");
        // Reset everything.
        clear();
    }
}
