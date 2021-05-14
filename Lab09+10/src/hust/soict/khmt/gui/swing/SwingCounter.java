package hust.soict.khmt.gui.swing;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Label;
import java.awt.Panel;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import java.awt.Checkbox;
import java.awt.Choice;
import java.awt.List;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import java.awt.TextArea;

public class SwingCounter extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingCounter frame = new SwingCounter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingCounter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 498, 234);
		setTitle("Count");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCounter = new JLabel("Counter:");
		lblCounter.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblCounter);
		
		final Checkbox checkboxUp = new Checkbox("Up");
		final Checkbox checkboxDown = new Checkbox("Down");
		checkboxUp.setState(true);
		checkboxDown.setState(false);
		
		checkboxUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkboxDown.getState())
				{
					checkboxDown.setState(false);
				}
			}
		});
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		checkboxUp.setState(true);
		panel.add(checkboxUp);
		
		checkboxDown.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (checkboxUp.getState())
				{
					checkboxUp.setState(false);
				}
			}
		});
		panel.add(checkboxDown);
		
		JLabel lblNewLabel_1 = new JLabel("Step:");
		panel.add(lblNewLabel_1);
		
		final Choice choice = new Choice();
		choice.add("1");
		choice.add("2");
		choice.add("3");
		choice.add("4");
		panel.add(choice);
		
		Button btnCount = new Button("Count");
		btnCount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int so = Integer.parseInt(textField.getText());
				int add = Integer.parseInt(choice.getSelectedItem());
				int nextNum = 1;
				if (checkboxUp.getState())
				{
					nextNum = so + add;
				}
				else if (checkboxDown.getState())
				{
					nextNum = so - add;
				}
				textField.setText(Integer.toString(nextNum));
			}
		});
		panel.add(btnCount);
	}

}
