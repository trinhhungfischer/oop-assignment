package hust.soict.khmt.gui.awt;

import java.awt.*;
// Using AWT container and component classes
import java.awt.event.*;

public class AWTCounter extends Frame implements ActionListener, WindowListener {
	private Label lblCount;
// Declare a Label component
	private TextField tfCount; // Declare a TextField component
	private Button btnCount; // Declare a Button component
	private int count = 0;


	public AWTCounter() {
		setAutoRequestFocus(false);
		dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
		setLayout(new FlowLayout());
		addWindowListener(this);
		
		lblCount = new Label("Counter"); // construct the Label component
		add(lblCount);
		tfCount = new TextField(count + "", 10);
		add(tfCount);
		btnCount = new Button("Count"); // construct the Button component
		add(btnCount);
		btnCount.addActionListener(this);
		setTitle("AWT Counter"); // "super" Frame sets its title
		setSize(250, 100);
		setVisible(true);
	}


	public static void main(String[] args) {
//Invoke the constructor to setup the GUI, by allocating an instance
		AWTCounter app = new AWTCounter();
//or simply "new AWTCounter();" for an anonymous instance
	}

//ActionEvent handler - Called back upon button-click.
	@Override
	public void actionPerformed(ActionEvent evt) {
		count = Integer.parseInt(tfCount.getText());
		++count; // Increase the counter value
//Display the counter value on the TextField tfCount
		tfCount.setText(count + ""); // Convert int to String
	}
	
	public void windowActivated(WindowEvent e) {}  
	public void windowClosed(WindowEvent e) {}  
	public void windowClosing(WindowEvent e) {  
	    dispose();  
	}  
	public void windowDeactivated(WindowEvent e) {}  
	public void windowDeiconified(WindowEvent e) {}  
	public void windowIconified(WindowEvent e) {}  
	public void windowOpened(WindowEvent arg0) {}    
}