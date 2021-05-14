package hust.soict.khmt.aims.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import hust.soict.khmt.aims.exceptions.OrderException;
import hust.soict.khmt.aims.order.Order;
import hust.soict.khmt.aims.utils.Storage;
import javax.swing.UIManager;

public class Menu extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Storage thisStorage = new Storage();

	private Dimension DEFAULT_SIZE = new Dimension(1200, 800);

	public Menu() throws HeadlessException {
		// TODO Auto-generated constructor stub
		setTitle("Menu");
		setSize(new Dimension(1181, 804));
		getContentPane().setLayout(new BorderLayout(0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setPreferredSize(DEFAULT_SIZE);

		JPanel panelTop = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelTop.getLayout();
		flowLayout.setHgap(200);
		panelTop.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		getContentPane().add(panelTop, BorderLayout.NORTH);

		JLabel lblMenu = new JLabel("Menu");
		lblMenu.setFont(new Font("Verdana", Font.PLAIN, 72));
		panelTop.add(lblMenu);

		TextField textField = new TextField();
		textField.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField.setEditable(false);
		textField.setText("Ban chua co order nao");
		panelTop.add(textField);

		JPanel panelUnder = new JPanel();
		getContentPane().add(panelUnder, BorderLayout.CENTER);
		panelUnder.setLayout(new BorderLayout(0, 0));

		JPanel panelLeft = new JPanel();
		panelLeft.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panelUnder.add(panelLeft, BorderLayout.WEST);
		panelLeft.setLayout(new BorderLayout(0, 0));

		JLabel lblInstruction = new JLabel("H\u01B0\u1EDBng d\u1EABn s\u1EED d\u1EE5ng");
		lblInstruction.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panelLeft.add(lblInstruction, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelLeft.add(panel, BorderLayout.SOUTH);

		JButton btnQuestion = new JButton("");
		btnQuestion.setIcon(new ImageIcon(Menu.class.getResource("/hust/soict/khmt/aims/asset/question.png")));

		boolean isQuestion[] = { false };
		btnQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isQuestion[0] == false) {
					isQuestion[0] = true;
					btnQuestion.setBackground(Color.YELLOW);
				}
			}
		});

		panel.add(btnQuestion);

		JTextArea txtrTnh = new JTextArea();
		txtrTnh.setBackground(Color.WHITE);
		txtrTnh.setFont(new Font("Courier New", Font.PLAIN, 16));
		txtrTnh.setText(
				"Nh\u1EA5n v\u00F4 n\u00FAt bi\u1EC3u \r\nt\u01B0\u1EE3ng b\u1EA5t l\u1EF1c \u1EDD\r\nph\u00EDa d\u01B0\u1EDBi sau \u0111\u00F3 \r\n\u1EA5n v\u00F4 n\u00FAt b\u1EA1n th\u1EA5y\r\nkh\u00F3 hi\u1EC3u \u0111\u1EC3 \u0111\u01B0\u1EE3c \r\nth\u00F4ng tin chi ti\u1EBFt");
		panelLeft.add(txtrTnh, BorderLayout.CENTER);

		JPanel panelRight = new JPanel();
		panelRight.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panelUnder.add(panelRight, BorderLayout.CENTER);
		panelRight.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panelRight.add(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnCreateOrder = new JButton("T\u1EA1o Order");
		btnCreateOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isQuestion[0]) {
					isQuestion[0] = false;
					btnQuestion.setBackground(UIManager.getColor("Button.background"));
					JOptionPane.showMessageDialog(null, "Tao mot order moi thong qua cua so moi", "Instruction",
							JOptionPane.INFORMATION_MESSAGE);
				}
				try {
					new Order();
					OrderFrame order = new OrderFrame();
					String text = "Ban dang o Order " + Order.getCurrentOrder().getOrderName();
					textField.setText(text);
					order.setVisible(true);
				} catch (OrderException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Max of order", "ERROR", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnCreateOrder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnCreateOrder);

		JButton btnDeleteOrder = new JButton("X\u00F3a Order");
		btnDeleteOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isQuestion[0]) {
					isQuestion[0] = false;
					btnQuestion.setBackground(UIManager.getColor("Button.background"));
					JOptionPane.showMessageDialog(null, "Chon mot order de xoa khoi danh sach cac order", "Instruction",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (Order.getListOrder().size() == 0) {
					JOptionPane.showMessageDialog(null, "There are no order", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					List<String> ListOrderName = new ArrayList<>();
					for (int i = 0; i < Order.getListOrder().size(); i++) {
						ListOrderName.add(Order.getListOrder().get(i).getOrderName());
					}

					String choice = (String) JOptionPane.showInputDialog(null, "Chon oder can xoa", "Delete Box",
							JOptionPane.WARNING_MESSAGE, null, ListOrderName.toArray(),
							Order.getCurrentOrder().getOrderName());
					if (choice != null) {
						Order.RemoveOrder(Integer.parseInt(choice));
					}

					if (Order.getListOrder().size() == 0) {
						textField.setText("Ban chua co order nao");
					} else {
						String text = "Ban dang o Order " + Order.getCurrentOrder().getOrderName();
						textField.setText(text);
					}

				}
			}
		});
		btnDeleteOrder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnDeleteOrder);

		JButton btnPrintOrder = new JButton("In Order");
		btnPrintOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isQuestion[0]) {
					isQuestion[0] = false;
					btnQuestion.setBackground(UIManager.getColor("Button.background"));
					JOptionPane.showMessageDialog(null, "In danh sach dang duoc chon hien tai", "Instruction",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (Order.getListOrder().size() == 0) {
					JOptionPane.showMessageDialog(null, "There are no order", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					BillAOrderFrame thisFrame = new BillAOrderFrame(0);
					thisFrame.setVisible(true);
				}
			}
		});
		btnPrintOrder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		panel_1.add(btnPrintOrder);

		JPanel panel_2 = new JPanel();
		panelRight.add(panel_2);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));

		JButton btnSelectOrder = new JButton("Ch\u1ECDn Order");
		btnSelectOrder.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnSelectOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isQuestion[0]) {
					isQuestion[0] = false;
					btnQuestion.setBackground(UIManager.getColor("Button.background"));
					JOptionPane.showMessageDialog(null, "Chon mot order de tiep tuc thao tac", "Instruction",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (Order.getListOrder().size() == 0) {
					JOptionPane.showMessageDialog(null, "There are no order", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					List<String> ListOrderName = new ArrayList<>();
					for (int i = 0; i < Order.getListOrder().size(); i++) {
						ListOrderName.add(Order.getListOrder().get(i).getOrderName());
					}

					String choice = (String) JOptionPane.showInputDialog(null, "Chon oder can thao tac", "Choosen Box",
							JOptionPane.WARNING_MESSAGE, null, ListOrderName.toArray(),
							Order.getCurrentOrder().getOrderName());
					if (choice != null) {
						Order.setCurrentOrderIndex(Integer.parseInt(choice));
					}

					String text = "Ban dang o Order " + Order.getCurrentOrder().getOrderName();
					textField.setText(text);
				}
			}
		});
		panel_2.add(btnSelectOrder);

		JButton btnEditStore = new JButton("S\u1EEDa order");
		btnEditStore.setFont(new Font("Tahoma", Font.PLAIN, 24));
		btnEditStore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isQuestion[0]) {
					isQuestion[0] = false;
					btnQuestion.setBackground(UIManager.getColor("Button.background"));
					JOptionPane.showMessageDialog(null, "Tiep tuc chinh sua order hien tai", "Instruction",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (Order.getListOrder().size() == 0) {
					JOptionPane.showMessageDialog(null, "There are no order", "ERROR", JOptionPane.ERROR_MESSAGE);
				} 
				else {
					OrderFrame frame;
					try {
						frame = new OrderFrame();
						frame.setVisible(true);
						frame.getTextOrder().setText(Order.getCurrentOrder().toString());
					} catch (OrderException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		panel_2.add(btnEditStore);

		JButton btnPayOrder = new JButton("Thanh To\u00E1n M\u1ED9t Order");
		btnPayOrder.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPayOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isQuestion[0]) {
					isQuestion[0] = false;
					btnQuestion.setBackground(UIManager.getColor("Button.background"));
					JOptionPane.showMessageDialog(null, "Thanh toan order hien tai ban dang thao tac", "Instruction",
							JOptionPane.INFORMATION_MESSAGE);
				}
				if (Order.getListOrder().size() == 0) {
					JOptionPane.showMessageDialog(null, "There are no order", "ERROR", JOptionPane.ERROR_MESSAGE);
				} else {
					BillAOrderFrame thisFrame = new BillAOrderFrame(1);
					thisFrame.setVisible(true);
				}
			}
		});
		panel_2.add(btnPayOrder);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.print("fuck");
	}
}
