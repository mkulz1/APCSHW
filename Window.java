import java.awt.event.*;
import javax.swing.*;
import java.awt.*; // Has a container.
public class Window extends JFrame implements ActionListener{

    private Container pane;

    private JButton b;
    private JLabel l; // Prints text.
    private JTextField t; // Place where you type in text.
    private JCheckBox c;

    public Window(){
	this.setTitle("My first GUI");
	this.setSize(600,400);
	this.setLocation(100,100);
	this.setDefaultCloseOperation(EXIT_ON_CLOSE);

	pane = this.getContentPane(); //I want the content pane of my window.You get the one part of your original window.

	//How do you want stuff to be added to your pane?
	//	pane.setLayout(new FlowLayout()); // Flow layout: Adding stuff from one to another. Let's you arrange stuff on your screen.

	pane.setLayout(new GridLayout(3,3)); //Grid 

	// Contructor takes 3 parameters. JLabel static variable that tells how you want your text to be.
	// It's just a text label.
	b = new JButton("Punctuate!"); // What the button says. 
	l = new JLabel("This is AWESOME! (lies)", null, JLabel.CENTER); 
	t = new JTextField(12); // Size aka. width   
	c = new JCheckBox("Check this box! (nothing will happen)");

	b.setActionCommand("addPeriod");
	b.addActionListener(this); //I'm gonna add mysels to this window (class).

	// ORDER MATTERS
	pane.add(b);
	pane.add(l);
	pane.add(t);
	pane.add(c);

	// this.getContentPane().add(); ?? 
    }

    public void actionPerformed(ActionEvent e){
	String action = e.getActionCommand();
	System.out.println(action);
    }

    public static void main(String[] args){

	Window g = new Window();
	g.setVisible(true);

    }
}
