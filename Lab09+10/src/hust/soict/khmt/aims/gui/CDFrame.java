package hust.soict.khmt.aims.gui;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import hust.soict.khmt.aims.exceptions.OrderException;
import hust.soict.khmt.aims.media.CompactDiscs;
import hust.soict.khmt.aims.media.Track;
import hust.soict.khmt.aims.order.Order;
import hust.soict.khmt.aims.utils.Storage;

public class CDFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private CompactDiscs thisCD = new CompactDiscs();
	public boolean isAdd = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CDFrame frame = new CDFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws Exception
	 */
	public CDFrame() throws OrderException {

		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 894, 704);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelRight = new JPanel();
		panelRight.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelRight.setBounds(425, 11, 451, 681);
		contentPane.add(panelRight);
		panelRight.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("DANH S\u00C1CH TRACK");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 11, 417, 55);
		panelRight.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 431, 575);
		panelRight.add(scrollPane);

		JTextArea textStoreList = new JTextArea();
		textStoreList.setEditable(false);
		textStoreList.setText(Storage.showTrack());
		scrollPane.setViewportView(textStoreList);
		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelLeft.setBounds(10, 11, 412, 681);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		JTextPane textRemove = new JTextPane();
		textRemove.setBounds(297, 107, 47, 47);
		panelLeft.add(textRemove);

		JTextPane textBuy = new JTextPane();
		textBuy.setBounds(297, 49, 47, 47);
		panelLeft.add(textBuy);

		JLabel lblFunction = new JLabel("COMPACT DISC");
		lblFunction.setHorizontalAlignment(SwingConstants.CENTER);
		lblFunction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFunction.setBounds(0, 0, 228, 60);
		panelLeft.add(lblFunction);

		JTextArea textOrder = new JTextArea();
		textOrder.setBounds(10, 165, 385, 423);
		panelLeft.add(textOrder);

		JButton btnConfirmBuy = new JButton("OK");
		btnConfirmBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = 0;
				try {
					ID = Integer.parseInt(textBuy.getText()) - 1;
					if (Storage.mediaList.get(ID).getClass() != Track.class) {
						JOptionPane.showMessageDialog(null, "Wrong ID number in class", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} else {
						thisCD.addTrack((Track) Storage.mediaList.get(ID));
						textOrder.setText(thisCD.printTrack());
					}
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Wrong ID number", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirmBuy.setBounds(348, 49, 57, 47);
		panelLeft.add(btnConfirmBuy);

		JButton btnConfirmRemove = new JButton("OK");
		btnConfirmRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = 0;
				try {
					ID = Integer.parseInt(textBuy.getText()) - 1;
					if (Storage.mediaList.get(ID).getClass() != Track.class) {
						JOptionPane.showMessageDialog(null, "Wrong ID number in class", "ERROR",
								JOptionPane.ERROR_MESSAGE);
					} else {
						thisCD.removeTrack((Track) Storage.mediaList.get(ID));
						textOrder.setText(thisCD.printTrack());
					}
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Wrong ID number", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirmRemove.setBounds(348, 107, 57, 47);
		panelLeft.add(btnConfirmRemove);

		JTextArea txtrNhpIdTrong = new JTextArea();
		txtrNhpIdTrong.setEditable(false);
		txtrNhpIdTrong.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrNhpIdTrong.setText("Nh\u1EADp ID trong danh s\u00E1ch \r\ntrack \u0111\u1EC3 th\u00EAm v\u00E0o CD");
		txtrNhpIdTrong.setBounds(10, 49, 280, 47);
		panelLeft.add(txtrNhpIdTrong);

		JTextArea txtrNhpIdTrong_1 = new JTextArea();
		txtrNhpIdTrong_1.setEditable(false);
		txtrNhpIdTrong_1.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrNhpIdTrong_1.setText("Nh\u1EADp ID trong danh s\u00E1ch \r\ntrack \u0111\u1EC3 x\u00F3a track ra CD");
		txtrNhpIdTrong_1.setBounds(10, 107, 280, 47);
		panelLeft.add(txtrNhpIdTrong_1);

		JButton btnReturn = new JButton("RETURN");
		btnReturn.setHorizontalAlignment(SwingConstants.LEFT);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReturn.setBounds(193, 599, 85, 44);
		panelLeft.add(btnReturn);

		JTextArea textOrderName = new JTextArea();
		textOrderName.setFont(new Font("Courier New", Font.BOLD, 20));
		textOrderName.setEditable(false);
		textOrderName.setText("DS Track");
		textOrderName.setBounds(42, 599, 123, 44);
		panelLeft.add(textOrderName);

		JButton btnNewButton_1 = new JButton("ADD CD");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Order.getCurrentOrder().addMedia(thisCD);
					OrderFrame.getTextOrder().setText(Order.getCurrentOrder().toString());
					int choice = JOptionPane.showConfirmDialog(btnNewButton_1, "Ban co muon phat CD khong?",
							"Phat nhac", JOptionPane.OK_OPTION);
					if (choice == 0) {
						thisCD.play();
					}

				} catch (OrderException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setBounds(290, 599, 105, 44);
		panelLeft.add(btnNewButton_1);
	}
}
