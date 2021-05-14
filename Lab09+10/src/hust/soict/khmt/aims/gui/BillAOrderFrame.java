package hust.soict.khmt.aims.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hust.soict.khmt.aims.order.Order;

import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class BillAOrderFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */

	private int mode = 0;

	public int getMode() {
		return mode;
	}

	public void setMode(int mode) {
		this.mode = mode;
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BillAOrderFrame frame = new BillAOrderFrame(1);
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
	public BillAOrderFrame(int mode) {
		this.mode = mode;
		
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 964, 730);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(1, 0, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane);

		JTextArea txtrNeuOrderCua = new JTextArea();
		txtrNeuOrderCua.setEditable(false);
		txtrNeuOrderCua.setFont(new Font("Courier New", Font.PLAIN, 14));
		txtrNeuOrderCua.setText("Neu order cua ban tong bill tren 150$\r\nthi co kha nang khuyen mai 1 san \r\npham len toi 49.99$\r\nNeu order cua ban tong bill tren 300$\r\nthi co kha nang khuyen mai 1 san \r\npham len toi 99.99$\r\n");
		scrollPane.setViewportView(txtrNeuOrderCua);

		JLabel lblInstruction = new JLabel("HUONG DAN SALE");
		lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblInstruction.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane.setColumnHeaderView(lblInstruction);

		JScrollPane scrollPane_1 = new JScrollPane();
		contentPane.add(scrollPane_1);

		JTextArea textBill = new JTextArea();
		scrollPane_1.setViewportView(textBill);

		JLabel lblBill = new JLabel("BILL");
		lblBill.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblBill.setHorizontalAlignment(SwingConstants.CENTER);
		scrollPane_1.setColumnHeaderView(lblBill);

		if (this.mode == 0) {
			String text = Order.getCurrentOrder().toString() + Order.getCurrentOrder().strBill();
			textBill.setText(text);
		}
		else {
			String text = Order.getCurrentOrder().printOrder();
			textBill.setText(text);
		}
	}

}
