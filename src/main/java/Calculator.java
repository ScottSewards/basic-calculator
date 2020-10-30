
import java.awt.*; 
import javax.swing.*; 

public class Calculator {
    JPanel windowContent; //instantiates a JPanel variable called windowContent for BorderLayout content
    JTextField displayField; //instantiates a JTextField variable called displayField

    JButton buttonClearEntry = new JButton("CE");
    JButton buttonClearAll = new JButton("CA");
    JButton buttonAdd = new JButton("+");
    JButton buttonMinus = new JButton("-");
    JButton buttonTimes = new JButton("*");
    JButton buttonDivide = new JButton("/");
    JButton buttonDelete = new JButton("Del");
    JButton buttonDecimal = new JButton(".");
    JButton buttonRemainder = new JButton("%");
    JButton buttonEquals = new JButton("=");
    JPanel panel = new JPanel();
  
    Calculator(){ //CLASS CONSTRUCTOR
        windowContent = new JPanel(); //creates an instance of the JPanel windowContent
        BorderLayout b1 = new BorderLayout(); //instantiates and declares an instance of a BorderLayout method called b1
    
        windowContent.setLayout(b1); //assigns the layout of b1 to windowContent

        displayField = new JTextField(30); //calls the JTextField variable displayField and assigns a width of 30
        windowContent.add("North", displayField); //adds the displayField to windowContent whilst arguing it should be rendered at the top of the window (i.e. north)

        JButton button7 = new JButton("7");
        JButton button8 = new JButton("8");
        JButton button9 = new JButton("9");

        JButton button4 = new JButton("4");
        JButton button5 = new JButton("5");
        JButton button6 = new JButton("6");

        JButton button1 = new JButton("1");
        JButton button2 = new JButton("2");
        JButton button3 = new JButton("3");

        buttonDelete = new JButton("Delete");
        JButton button0 = new JButton("0"); 
        buttonDecimal = new JButton(".");
        
        GridLayout grid = new GridLayout(4,5); //SET GridLayout TO 4 ROWS AND 5 COLUMNS
        panel.setLayout(grid); //SET JPanel LAYOUT TO GridLayout
        //ROW 1
        panel.add(button7);
        panel.add(button8);
        panel.add(button9);
        panel.add(buttonClearEntry);
        panel.add(buttonClearAll);
        //ROW 2
        panel.add(button4);
        panel.add(button5);
        panel.add(button6);
        panel.add(buttonAdd); 
        panel.add(buttonMinus); 
        //ROW 3
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        panel.add(buttonTimes); 
        panel.add(buttonDivide); 
        //ROW 4
        panel.add(buttonDelete);
        panel.add(button0); 
        panel.add(buttonDecimal); 
        panel.add(buttonRemainder);
        panel.add(buttonEquals); 
        windowContent.add("Center", panel);

        JFrame frame = new JFrame("Calculator"); // argument contains a string that is displayed in the border
        frame.setContentPane(windowContent); //creates the components that will go into the frame when the program is executed
        frame.pack(); //sets the size of the frame appropriately so all of the contents are at the preference size
        frame.setVisible(true); //SET JFrame VISIBLE

        CalculatorEngine engine = new CalculatorEngine(this);
        //ROW 1
        button7.addActionListener(engine);
        button8.addActionListener(engine);
        button9.addActionListener(engine);
        buttonClearEntry.addActionListener(engine);
        buttonClearAll.addActionListener(engine);
        //ROW 2
        button4.addActionListener(engine);
        button5.addActionListener(engine);
        button6.addActionListener(engine);
        buttonAdd.addActionListener(engine);
        buttonMinus.addActionListener(engine);
        //ROW 3
        button1.addActionListener(engine);
        button2.addActionListener(engine);
        button3.addActionListener(engine);
        buttonTimes.addActionListener(engine);
        buttonDivide.addActionListener(engine);
        //ROW 4
        buttonDelete.addActionListener(engine);
        button0.addActionListener(engine);
        buttonDecimal.addActionListener(engine);
        buttonRemainder.addActionListener(engine);
        buttonEquals.addActionListener(engine);
    }
    
    public static void main(String[] args){ 
        Calculator calculator = new Calculator(); 
        calculator.displayField.setText("");
    }	
}

