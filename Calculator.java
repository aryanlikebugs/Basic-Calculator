import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[8];
    JButton addButton, subButton, mulButton, divButton;
    JButton decButton, equButton, delButton, clrButton;
    double num1 = 0, num2 = 0, result = 0;
    char operator;
    JPanel panel;
    //Font myFont = new Font("Ink Free", Font.BOLD, 30);

    Calculator(){
        frame = new JFrame("Calculator");
        panel = new JPanel();
        panel.setBounds(30, 100, 300, 300);
        panel.setLayout(new GridLayout(4, 4));
        
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.add(panel);

        textField = new JTextField();
        textField.setBounds(30, 25, 300, 50);
        //textField.setFont(myFont);
        textField.setEditable(false);
        frame.add(textField);

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("Delete");
        clrButton = new JButton("Clear");

        functionButtons[0] = addButton;
        functionButtons[1] = subButton;
        functionButtons[2] = mulButton;
        functionButtons[3] = divButton;
        functionButtons[4] = decButton;
        functionButtons[5] = equButton;
        functionButtons[6] = delButton;
        functionButtons[7] = clrButton;

        for(int i = 0; i < 8; i++){
            functionButtons[i].addActionListener(this);
            //functionButtons[i].setFont(myFont);
            functionButtons[i].setFocusable(false);
        }
       
        
        for(int i = 0; i < 10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
           // numberButtons[i].setFont(myFont);
            numberButtons[i].setFocusable(false);
        }

        
        
        
        
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(addButton);
        panel.add(numberButtons[4]);    
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(subButton);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButtons[0]);
        panel.add(equButton); 
        panel.add(divButton);
        
       


        delButton.setBounds(30, 400, 150, 50);
        clrButton.setBounds(180, 400, 150, 50);
        frame.add(delButton);
        frame.add(clrButton);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        
    }

    @Override
    public void actionPerformed(ActionEvent e){
        for(int i=0; i<10; i++){
            if(e.getSource() == numberButtons[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }

        if(e.getSource() == decButton){
            textField.setText(textField.getText().concat("."));
        }

        if(e.getSource() == addButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }

        if(e.getSource() == subButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }

        if(e.getSource() == mulButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }

        if(e.getSource() == divButton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }

        if(e.getSource() == equButton){
            num2 = Double.parseDouble(textField.getText());

            switch(operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }

            textField.setText(String.valueOf(result));
            num1 = result;

            if(result == (double)result){
                textField.setText(String.valueOf(result));
            }
            else{
                textField.setText("Error");
            }

        }

        if(e.getSource() == clrButton){
            textField.setText("");
        }

        if(e.getSource() == delButton){
            String str = textField.getText();
            textField.setText("");
            for(int i=0; i<str.length()-1; i++){
                textField.setText(textField.getText()+str.charAt(i));
            }
        }

    }
}