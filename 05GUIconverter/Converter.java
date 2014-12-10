import java.awt.event.*;
import javax.swing.*;
import java.awt.*; 
public class Window extends JFrame implements ActionListener{

    private Container pane;

    private JButton b;
    private JLabel l; // Prints text.
    private JTextField f; // Fahrenheit
    private JTextField c; // Celcius
    private JCheckBox a;
    private JCheckBox u;

    public Window(){
	this.setTitle("Temperature Converter");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane();
	pane.setLayout(new GridLayout(3,3)); //Grid 

	b = new JButton("Convert"); // What the button says. 
	l = new JLabel("Temperature Converter", null, JLabel.CENTER); 
	f = new JTextField(12); 
	c = new JTextField(12); 
	a = new JCheckBox("Fahrenheit to Celsius");
	u = new JCheckBox("Celcius to Fahrenheit");


	b.setActionCommand("Convert");
	b.addActionListener(this); //I'm gonna add myself to this window (class).
	//clear.setActionCommand("delete");
	//clear.addActionListener(this);

	// ORDER MATTERS
	pane.add(b);
	pane.add(l);
	pane.add(f);
	pane.add(c);
	pane.add(a);
	pane.add(u);

    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	//	System.out.println(action);
	if (action.equals("Convert")){
	    if(a.isSelected()){
		String temp = f.getText();
		//Convert f to c
		temp = ((5/9) * (temp-32));

	    }else{
		temp = (temp * (9/5)) + 32;
	    }
	    c.setText(temp);
	    
	}
	if (action.equals("delete")){
	    .setText("");
	}
    }

    public static void main(String[] args){

	Window g = new Window();
	g.setVisible(true);

    }
}
