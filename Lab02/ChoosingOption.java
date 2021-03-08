import javax.swing.JOptionPane;

public class ChoosingOption {
	public static void main(String[] args) {
		String[] options = new String[] {"Yes", "No", "Maybe", "Cancel"};
		int option = JOptionPane.showOptionDialog(null, 
				"Do you wanna change to first ticket?", "Title", 
				JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[0]);
		System.out.println(option);
		JOptionPane.showMessageDialog(null, "You 've chosen:"
				+ (option == 0?"Yes":option == 1?"No":option == 2?"Maybe":"Cancel"));
		
		System.exit(0);
	}
}
