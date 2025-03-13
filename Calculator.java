package Calc;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener{
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addB,subB,mulB,divB,decB,equB,delB,clrB,negB;
	JPanel panel;
	
	Font myFont = new Font("Arial",Font.BOLD,20);
	
	double num1=0,num2=0,result=0;
	char operator;
	
	Calculator(){
	
		frame = new JFrame("Calculator");
		frame.getContentPane().setBackground(Color.DARK_GRAY);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420,550);
		frame.setLayout(null);
		
		
		
		textfield=new JTextField();
		textfield.setBackground(Color.gray);
		textfield.setBounds(50,25,300,50);
		textfield.setFont(myFont);
		textfield.setEditable(false);
		
		
		addB = new JButton("+");
		subB = new JButton("-");
		mulB = new JButton("x");
		divB = new JButton("÷");
		decB = new JButton(".");
		equB = new JButton("=");
		delB = new JButton("DELETE");
		clrB = new JButton("CLEAR");
		negB = new JButton("(-)");

		
		
		functionButtons[0]=addB;
		functionButtons[1]=subB;
		functionButtons[2]=mulB;
		functionButtons[3]=divB;
		functionButtons[4]=decB;
		functionButtons[5]=equB;
		functionButtons[6]=delB;
		functionButtons[7]=clrB;
		functionButtons[8]=negB;

		
		for(int i=0;i<9;i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setBackground(Color.GRAY);
			
		}
		for(int i=0;i<10;i++) {
			numberButtons[i]=new JButton(String.valueOf(i));
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
		    numberButtons[i].addActionListener(this); 
		    numberButtons[i].setBackground(Color.GRAY);


		}
		negB.setBounds(50, 430, 60, 50);
		delB.setBounds(110,430, 120, 50);
		clrB.setBounds(230,430, 120, 50);

		panel = new JPanel();
		panel.setBackground(Color.black);
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4,4,10,10));
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addB);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subB);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulB);
		panel.add(decB);
		panel.add(numberButtons[0]);
		panel.add(equB);
		panel.add(divB);

		frame.add(panel);
		frame.add(negB);
		frame.add(delB);
		frame.add(clrB);
		frame.add(textfield);
		ImageIcon image = new ImageIcon(getClass().getResource("75775.png"));
		frame.setIconImage(image.getImage());
		
		frame.setVisible(true);
		
	}
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		for(int i=0;i<10;i++) {
			if(e.getSource()==numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource()==decB) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource()==addB) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource()==subB) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource()==mulB) {
			num1 = Double.parseDouble(textfield.getText());
			operator = 'x';
			textfield.setText("");
		}
		if(e.getSource()==divB) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		if(e.getSource()==equB) {
			num2=Double.parseDouble(textfield.getText());
			switch(operator) {
			case '+':
				result = num1+num2;
				break;
			case '-':
				result = num1-num2;
				break;
			case 'x':
				result = num1*num2;
				break;
			case '/':
				result = num1/num2;
				break;
			
			}
			textfield.setText(String.valueOf(result));
			num1=result;
		}
		if(e.getSource()==clrB) {
			textfield.setText("");
		}
		if(e.getSource()==delB) {
			String s = textfield.getText();
			textfield.setText("");
			for(int i=0;i<s.length()-1;i++) {
				textfield.setText(textfield.getText()+s.charAt(i));
			}
			
		}
		if(e.getSource()==negB) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
	
		}
	}
}