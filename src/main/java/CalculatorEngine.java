
import java.awt.event.*;
import javax.swing.JButton; 

public class CalculatorEngine implements ActionListener { 
    Calculator calculator; 
    char action; //stores the type of operator for example, +
    double result = 0; //this value that is shown to the operator, the one they have selected
	
    CalculatorEngine(Calculator calculator) { 
        this.calculator = calculator; //creates an instance of the calculator class
    }

    private void updateField(char action, double displayValue) {
        this.action = action;
        result = displayValue;
        calculator.displayField.setText("");
    }
        
    public void actionPerformed(ActionEvent e) {
        JButton clickedButton = (JButton)e.getSource();
        String displayFieldText = calculator.displayField.getText(); 
	double displayValue = 0; 

        if(!"".equals(displayFieldText)) displayValue = Double.parseDouble(displayFieldText);

        Object src = e.getSource(); 

        if(src == calculator.buttonAdd) updateField('+', displayValue);
	else if (src == calculator.buttonMinus) updateField('-', displayValue);
	else if (src == calculator.buttonTimes) updateField('*', displayValue);
	else if (src == calculator.buttonDivide) updateField('/', displayValue);
	else if (src == calculator.buttonRemainder) updateField('%', displayValue); 
        
	else if (src == calculator.buttonClearAll) { 
            result = 0;
            calculator.displayField.setText("0");
	} else if (src == calculator.buttonClearEntry) 
            calculator.displayField.setText("0");
        else if (src == calculator.buttonDelete) {
            if(displayFieldText.length() > 0) 
                calculator.displayField.setText(displayFieldText.substring(0, displayFieldText.length() - 1));
            else calculator.displayField.setText("");
	} else if (src == calculator.buttonEquals) {
            switch(action) {
                case '+': 
                    result += displayValue;
                    break;
                case '-': 
                    result -= displayValue;
                    break;
                case '*': 
                    result *= displayValue;
                    break;
                case '/': 
                    result /= displayValue;
                    break;
            }
            calculator.displayField.setText("" + result);
	} else {
            String clickedButtonLabel = clickedButton.getText();
            switch(clickedButtonLabel) {
                case ".":
                    if(!displayFieldText.contains("."))  
                        calculator.displayField.setText(displayFieldText + clickedButtonLabel);                    
                    break;
                default:
                    calculator.displayField.setText(displayFieldText + clickedButtonLabel);                    
            }
        }
    }
}