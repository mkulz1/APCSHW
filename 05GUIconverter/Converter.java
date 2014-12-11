import java.awt.event.*;
import javax.swing.*;
import java.awt.*; 
public class Converter extends JFrame implements ActionListener{

    private Container pane;

    private JButton b;
    private JLabel l,g,r; // Prints text.
    private JTextField f,c; // Fahrenheit & Celsius
    private JCheckBox a,u;

    public Converter(){
	this.setTitle("Temperature Converter");
	this.setSize(200,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new FlowLayout()); //Grid 

	b = new JButton("Convert"); // What the button says. 
	l = new JLabel("Temperature Converter", null, JLabel.CENTER); 
	g = new JLabel("Fahrenheit:", null, JLabel.CENTER); 
	f = new JTextField(12); 
	r = new JLabel("Celcius:", null, JLabel.CENTER); 
	c = new JTextField(12); 
	a = new JCheckBox("Fahrenheit to Celsius");
	u = new JCheckBox("Celcius to Fahrenheit");


	b.setActionCommand("Convert");
	b.addActionListener(this); 

	// ORDER MATTERS
	pane.add(l);
	pane.add(g);	
	pane.add(f);
	pane.add(r);
	pane.add(c);
	pane.add(a);
	pane.add(u);
	pane.add(b);
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	if (action.equals("Convert")){
	    if(a.isSelected()){
		double temp = Double.valueOf(f.getText());
		temp = ( (temp - 32.0) * (.5556) );
		//Convert f to c
		//	temp = ((5/9) * (temp-32));
		//	c.setText(String.valueOf(temp));
		c.setText(String.valueOf(temp));
	    }
	    if(u.isSelected()){
		double temp;
		temp = Double.valueOf(c.getText());
		temp = ((temp * (9.0/5.0)) + 32.0) ;
		f.setText(String.valueOf(temp)); 
	    }  
	}
    }

    public static void main(String[] args){

	Converter g = new Converter();
	g.setVisible(true);

    }
}
