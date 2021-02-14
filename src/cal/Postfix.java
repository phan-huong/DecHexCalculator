package cal;

import java.util.Scanner;

public class Postfix {

	public Postfix() {
		super();
	}
	
	public int precedence(char operator) {
		switch (operator){
		    case '+':
		    case '-':
		        return 1;
		
		    case '*':
		    case '/':
		        return 2;
		
		    case '^':
		        return 3;
		    default:
		    	return -1;
		}
    }
	
	private boolean isOperand(char operand) { 
		if (Character.isDigit(operand)
				|| (operand == 'A')
				|| (operand == 'B')
				|| (operand == 'C')
				|| (operand == 'D')
				|| (operand == 'E')
				|| (operand == 'F')) return true;
		else return false;
	}
	
	public static Boolean isOperator(char op) {
		switch(op) {
		case '+':
			return true;
		case '-':
			return true;
		case '*':
			return true;
		case '/':
			return true;
		case '^':
			return true;
		default:
			return false;
		}
	}
    
    public String infixToPostfix(String infix) throws Overflow, Underflow{
        StackAsList<Character> stack = new StackAsList<Character>();
        char[] chars= infix.toCharArray();
        String result ="";
        
        for(char element : chars) {
        	if(element!=' ') {
        		if(isOperand(element)) {
        			result+=element;
        		}else if(element == '(') {
        			stack.push(element);
        		}else if(element == ')') {
                    while(!(stack.top() == '(')) {
                    	result+=stack.pop();
                    }
                    stack.pop();
                } else if(isOperator(element)) {
                    while(!stack.isEmpty() && precedence(stack.top()) >= precedence(element)) {
                        result+=stack.pop();
                    }
                    stack.push(element);
                }
        	}
        }
        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
	}

	public String evaluate(String pfx) throws Underflow, Overflow {

		StackAsList<Integer> stack = new StackAsList<Integer>();
		char[] chars = pfx.toCharArray();

		for (char element : chars) {
			if (Character.isDigit(element)) {
				stack.push(Character.getNumericValue(element));
			} else {

				int rhs = stack.pop();
				int lhs = stack.pop();

				switch (element) {
				case '+':
					stack.push(lhs + rhs);
					break;
				case '-':
					stack.push(lhs - rhs);
					break;
				case '*':
					stack.push(lhs * rhs);
					break;
				case '/':
					stack.push(lhs / rhs);
					break;
				case '^':
					stack.push((int)(Math.pow(lhs, rhs)));
					break;
				}
			}
		}
		return stack.pop().toString();
	}
	
	public int hexaToDecimal(String hexa) {
		return Integer.parseInt(hexa, 16);
	}

	public String decimalToHexa(int decimal) {
		return Integer.toHexString(decimal);
	}
	
	public String evaluateHexa(String pfx) throws Underflow, Overflow {

		StackAsList<Integer> stack = new StackAsList<Integer>();
		char[] chars = pfx.toCharArray();
		
		for (char element : chars) {
			if (isOperand(element)) {
				stack.push(hexaToDecimal(Character.toString(element)));
			} else {

				int rhs = stack.pop();
				int lhs = stack.pop();

				switch (element) {
				case '+':
					stack.push(lhs + rhs);
					break;
				case '-':
					stack.push(lhs - rhs);
					break;
				case '*':
					stack.push(lhs * rhs);
					break;
				case '/':
					stack.push(lhs / rhs);
					break;
				case '^':
					stack.push((int)(Math.pow(lhs, rhs)));
					break;
				}
			}
		}
		return decimalToHexa(stack.pop());
	}
	
	public void evaluateInfixUserInput() {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the postfix expression here: ");
		String userInput = sc.nextLine();
		Postfix p = new Postfix();
		try {
			
			String s = p.infixToPostfix(userInput);
			System.out.println("The result: " + evaluate(s));
			sc.close();
		}catch(Exception e) {
			System.out.println("Error: the input you entered cannot be calculated");
			sc.close();
		}
	}
}
