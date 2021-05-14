package hust.soict.khmt.aims.gui;

import java.awt.Choice;
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
import hust.soict.khmt.aims.exceptions.WrongIDException;
import hust.soict.khmt.aims.media.DigitalVideoDisc;
import hust.soict.khmt.aims.order.Order;
import hust.soict.khmt.aims.utils.Storage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Order thisOrder = Order.getCurrentOrder();
	private static JTextArea textOrder;

	public static JTextArea getTextOrder() {
		return textOrder;
	}

	public void setTextOrder(JTextArea textOrder) {
		OrderFrame.textOrder = textOrder;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderFrame frame = new OrderFrame();
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
	public OrderFrame() throws OrderException {
		setTitle("Order");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 902, 742);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		
		JPanel panelRight = new JPanel();
		panelRight.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelRight.setBounds(425, 11, 451, 681);
		contentPane.add(panelRight);
		panelRight.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("DANH S\u00C1CH C\u1EECA H\u00C0NG");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(24, 11, 417, 55);
		panelRight.add(lblNewLabel_1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 431, 575);
		panelRight.add(scrollPane);

		JTextArea textStoreList = new JTextArea();
		textStoreList.setEditable(false);
		textStoreList.setText(Storage.showStore());
		scrollPane.setViewportView(textStoreList);

		JButton btnDVD = new JButton("DVD");
		btnDVD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textStoreList.setText(Storage.showDVD());
			}
		});
		btnDVD.setBounds(139, 650, 89, 23);
		panelRight.add(btnDVD);

		JButton btnTrack = new JButton("Track");
		btnTrack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textStoreList.setText(Storage.showTrack());
			}
		});
		btnTrack.setBounds(238, 650, 89, 23);
		panelRight.add(btnTrack);

		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textStoreList.setText(Storage.showBook());
			}
		});
		btnBook.setBounds(337, 650, 89, 23);
		panelRight.add(btnBook);

		JButton btnStore = new JButton("Store");
		btnStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textStoreList.setText(Storage.showStore());
			}
		});
		btnStore.setBounds(40, 650, 89, 23);
		panelRight.add(btnStore);
		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelLeft.setBounds(10, 11, 412, 681);
		contentPane.add(panelLeft);
		panelLeft.setLayout(null);

		Choice choice = new Choice();
		choice.setBounds(201, 20, 143, 20);
		choice.add("");
		choice.add("DVD");
		choice.add("Book");
		choice.add("CD");

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 220, 385, 450);
		panelLeft.add(scrollPane_1);

		textOrder = new JTextArea();
		textOrder.setEditable(false);
		scrollPane_1.setViewportView(textOrder);
		panelLeft.add(choice);

		JTextPane textRemove = new JTextPane();
		textRemove.setBounds(297, 107, 47, 47);
		panelLeft.add(textRemove);

		JTextPane textBuy = new JTextPane();
		textBuy.setBounds(297, 49, 47, 47);
		panelLeft.add(textBuy);
		textBuy.setVisible(false);
		textRemove.setVisible(false);

		JLabel lblFunction = new JLabel("TH\u00CAM M\u1EB6T H\u00C0NG");
		lblFunction.setHorizontalAlignment(SwingConstants.CENTER);
		lblFunction.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFunction.setBounds(0, 0, 228, 60);
		panelLeft.add(lblFunction);

		JButton btnConfirmBuy = new JButton("OK");
		btnConfirmBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = 0;
				try {
					ID = Integer.parseInt(textBuy.getText());
					try {
						if (choice.getSelectedIndex() != 3) {
							thisOrder.addMediaById(ID);
							int choice = 0;
							if (Storage.mediaList.get(ID - 1).getClass() == DigitalVideoDisc.class) {
								choice = JOptionPane.showConfirmDialog(btnConfirmBuy, "Ban co muon phat DVD khong?",
										"Phat nhac", JOptionPane.OK_OPTION);
								if (choice == 0) {
									((DigitalVideoDisc) Storage.mediaList.get(ID - 1)).play();
								}
							}
							textOrder.setText(thisOrder.toString());
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						if (e1.getClass() == WrongIDException.class) {
							JOptionPane.showMessageDialog(null, "Wrong ID", "ERROR", JOptionPane.ERROR_MESSAGE);
						} else {
							JOptionPane.showMessageDialog(null, "The order is full", "ERROR",
									JOptionPane.ERROR_MESSAGE);
						}
					}
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Wrong ID number", "ERROR", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		
		btnConfirmBuy.setVisible(false);
		btnConfirmBuy.setBounds(348, 49, 57, 47);
		panelLeft.add(btnConfirmBuy);

		JButton btnConfirmRemove = new JButton("OK");
		btnConfirmRemove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int ID = 0;
				try {
					ID = Integer.parseInt(textRemove.getText());
					try {
						thisOrder.removeMediaByID(ID);
						textOrder.setText(thisOrder.toString());
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(null, "Wrong ID", "ERROR", JOptionPane.ERROR_MESSAGE);
					}
				} catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Wrong ID number", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnConfirmRemove.setBounds(348, 107, 57, 47);
		panelLeft.add(btnConfirmRemove);
		btnConfirmRemove.setVisible(false);

		JTextArea txtrNhpIdTrong = new JTextArea();
		txtrNhpIdTrong.setEditable(false);
		txtrNhpIdTrong.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrNhpIdTrong.setText(
				"Nh\u1EADp ID trong danh s\u00E1ch c\u1EE7a \r\nc\u1EEDa h\u00E0ng \u0111\u1EC3 th\u00EAm s\u1EA3n ph\u1EA9m");
		txtrNhpIdTrong.setBounds(10, 49, 280, 47);
		panelLeft.add(txtrNhpIdTrong);
		txtrNhpIdTrong.setVisible(false);

		JTextArea txtrNhpIdTrong_1 = new JTextArea();
		txtrNhpIdTrong_1.setEditable(false);
		txtrNhpIdTrong_1.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrNhpIdTrong_1.setText(
				"Nh\u1EADp ID trong danh s\u00E1ch c\u1EE7a\r\norder \u0111\u1EC3 x\u00F3a s\u1EA3n ph\u1EA9m ra order");
		txtrNhpIdTrong_1.setBounds(10, 107, 280, 47);
		panelLeft.add(txtrNhpIdTrong_1);
		txtrNhpIdTrong_1.setVisible(false);
		
		JButton btnReturn = new JButton("RETURN");
		btnReturn.setHorizontalAlignment(SwingConstants.LEFT);
		btnReturn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReturn.setBounds(20, 165, 85, 44);
		panelLeft.add(btnReturn);

		JTextArea textOrderName = new JTextArea();
		textOrderName.setFont(new Font("Courier New", Font.BOLD, 20));
		textOrderName.setEditable(false);
		textOrderName.setText("Order " + thisOrder.getOrderName());
		textOrderName.setBounds(251, 165, 123, 44);
		panelLeft.add(textOrderName);

		JButton btnBill = new JButton("H\u00F3a \u0110\u01A1n");
		btnBill.setHorizontalAlignment(SwingConstants.LEFT);
		btnBill.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textOrder.append(thisOrder.strBill());
			}
		});
		btnBill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBill.setBounds(135, 165, 93, 44);
		panelLeft.add(btnBill);

		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch (choice.getSelectedIndex()) {
				case 1: {
					textBuy.setVisible(true);
					textRemove.setVisible(true);
					txtrNhpIdTrong.setVisible(true);
					txtrNhpIdTrong_1.setVisible(true);
					btnConfirmBuy.setVisible(true);
					btnConfirmRemove.setVisible(true);
					textStoreList.setText(Storage.showDVD());
					
					
					break;
				}
				case 2: {
					textBuy.setVisible(true);
					textRemove.setVisible(true);
					txtrNhpIdTrong.setVisible(true);
					txtrNhpIdTrong_1.setVisible(true);
					btnConfirmBuy.setVisible(true);
					btnConfirmRemove.setVisible(true);
					textStoreList.setText(Storage.showBook());
					break;
				}
				case 3: {
					try {
						textBuy.setVisible(false);
						textRemove.setVisible(false);
						txtrNhpIdTrong.setVisible(false);
						txtrNhpIdTrong_1.setVisible(false);
						btnConfirmBuy.setVisible(false);
						btnConfirmRemove.setVisible(false);
						CDFrame cdFrame = new CDFrame();
						cdFrame.setVisible(true);
					} catch (OrderException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					break;
				}
				case 0: {
					textBuy.setVisible(false);
					textRemove.setVisible(false);
					txtrNhpIdTrong.setVisible(false);
					txtrNhpIdTrong_1.setVisible(false);
					btnConfirmBuy.setVisible(false);
					btnConfirmRemove.setVisible(false);
					break;
				}
				}
			}
		});
		btnNewButton.setBounds(350, 20, 52, 23);
		panelLeft.add(btnNewButton);
	}
}
