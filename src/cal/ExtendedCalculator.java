package cal;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

import cal.ExtendedCalculator;

public class ExtendedCalculator extends Calculator {

	CalculatorMode mode;

	public ExtendedCalculator() {
		super();
		this.mode = CalculatorMode.DECIMAL;
		makeHexaPanel();
		changeButtonAction();

	}

	public static void main(String[] args) {
		ExtendedCalculator c = new ExtendedCalculator();
		c.show();
	}
	
	public void makeHexaPanel() {
		JPanel hexaButtonPanel = new JPanel(new GridLayout(5, 2));
		
		JButton openBracketBtn = new JButton("(");
		JButton closeBracketBtn = new JButton(")");
		
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ExtendedCalculator.this.buttonPressed(e.getActionCommand());
				ExtendedCalculator.this.redisplay();
			}
		};
		openBracketBtn.addActionListener(action);
		closeBracketBtn.addActionListener(action);
		
		hexaButtonPanel.add(openBracketBtn);
		hexaButtonPanel.add(closeBracketBtn);

		fillButtons(hexaButtonPanel, new String[] { "A", "B", "C", "D", "E", "F" });
		fillCheckbox(hexaButtonPanel, "hexa");
		
		gui.frame.add(hexaButtonPanel, BorderLayout.WEST);
		gui.frame.setSize(400, 300);

	}

	/**
	 * adds buttons with the given button labels to the container and adds a action
	 * to each button 
	 * 
	 * @param ctn
	 * @param buttons
	 */
	public void fillButtons(Container ctn, String[] buttons) {
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ExtendedCalculator.this.buttonPressed(e.getActionCommand());
				ExtendedCalculator.this.redisplay();
			}
		};
		for (String caption : buttons) {

			JButton button = new JButton(caption);
			button.addActionListener(action);
			button.setEnabled(this.mode.equals(CalculatorMode.HEXA));
			ctn.add(button);
		}
	}

	/**
	 * Adds the hexa checkbox to the given container.
	 * When the checkbox is clicked, the 
	 * 
	 * @param panel
	 * @param label
	 */
	public void fillCheckbox(Container panel, String label) {
		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JCheckBox cb = (JCheckBox) e.getSource();
				ExtendedCalculator.this.setHexaMode(cb.isSelected());
			}
		};

		JCheckBox cb = new JCheckBox(label, false);
		cb.addActionListener(action);
		panel.add(cb);
	}

	/**
	 * This method adds a new action to each button, that triggers the redisplay method.
	 * In order to "override" the redisplay method that is getting triggerd by the UserInterface,
	 * we have to change the order
	 */
	public void changeButtonAction() {

		ActionListener action = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String command = e.getActionCommand();
		        if(command.equals("C")) {
		        	ExtendedCalculator.this.engine.clear();
		        } else if(command.equals("=")) {
		        	switch (mode){
		        	case DECIMAL:
		        		ExtendedCalculator.this.engine.evaluatePostfixDec(ExtendedCalculator.this.engine.getDisplayValue());
		        		break;
		        	case HEXA:
		        		ExtendedCalculator.this.engine.evaluatePostfixHexa(ExtendedCalculator.this.engine.getDisplayValue());
		        		break;
		        	}
		        }
		        else ExtendedCalculator.this.buttonPressed(command);		   	        
		        ExtendedCalculator.this.redisplay();
			}
		};
		
		// Create new JPanel
		JPanel contentPane = (JPanel) gui.frame.getContentPane();
		JPanel c = (JPanel) contentPane.getComponent(1);
		for (Component button : c.getComponents()) {
			if (button instanceof JButton) {
				ActionListener[] al = ((JButton) button).getActionListeners();
				((JButton) button).removeActionListener(al[0]);
				((JButton) button).addActionListener(action);
			}
		}
	}
	
	public void setHexaMode(boolean isHexa) {
		if (isHexa) {
			this.mode = CalculatorMode.HEXA;
		} else {
			this.mode = CalculatorMode.DECIMAL;
		}
		setHexaButtonsEnabled(isHexa);
		this.redisplay();
	}
	
	public void setHexaButtonsEnabled(boolean isHexa) {

		JPanel contentPane = (JPanel) gui.frame.getContentPane( );

		JPanel c = (JPanel) contentPane.getComponent(3);
		for (Component button : c.getComponents()) {
			if (button instanceof JButton) {
				button.setEnabled(isHexa);

			}
		}
	}
	
	public int hexaToDecimal(String hexa) {
		return Integer.parseInt(hexa, 16);
	}

	public String decimalToHexa(int decimal) {
		return Integer.toHexString(decimal);
	}

	public void buttonPressed(String command) {
		engine.displayString += command;
	}

	public void redisplay() {
		gui.display.setText("" + this.engine.getDisplayValue());
	}


}
