package hust.soict.khmt.aims.media;

import javax.swing.JOptionPane;

import hust.soict.khmt.aims.exceptions.PlayerException;

public class DigitalVideoDisc extends Disc implements Playable {
	private static String nameTag = "DVD";

	public DigitalVideoDisc() {
		this("Default title");
	}

	public DigitalVideoDisc(String title) {
		this.title = title;
	}

	public boolean search(String title) {
		String[] titleTokens = title.trim().replaceAll(" +", " ").split(" ");
		int num = 0;
		for (String token : titleTokens) {
			if (this.title.indexOf(token) < 0)
				return false;
			num++;
		}
		if (num == this.title.split(" ").length)
			return true;
		else
			return false;
	}

	@Override
	public String print(int i, int idFree) {
		// TODO Auto-generated method stub
		super.print(i, idFree);

		String price;
		if (idFree >= 0)
			price = "Free";
		else
			price = Float.toString(this.getCost()) + " $";
		return ((i + 1) + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - "
				+ this.getDirector() + " - " + this.getLength() + " : " + price + "\n");
	}

	@Override
	public String printInStore() {
		// TODO Auto-generated method stub
		super.printInStore();
		String str = this.getId_to_store() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - "
				+ this.getDirector() + " - " + this.getLength() + " : " + this.getCost() + "\n";
		return str;
	}

	@Override
	public void play() throws PlayerException {
		if (this.getLength() > 0)
		{
			// TODO Auto-generated method stub
			System.out.println("Playing DVD: " + this.getTitle());
			System.out.println("DVD length: " + this.getLength());	
			JOptionPane.showMessageDialog(null, "Dang phat", this.title, JOptionPane.PLAIN_MESSAGE);
		}
		else {
			throw new PlayerException("ERROR: DVD length is non-positive!");
		}
	}

	@Override
	public int compareTo(Object o) {
		if (!(o instanceof DigitalVideoDisc)) {
			return o.getClass().toString().compareTo(DigitalVideoDisc.class.toString());
		} else {
			DigitalVideoDisc dvd = (DigitalVideoDisc) o;
			if (this.cost > dvd.getCost())
				return 1;
			else if (this.cost < dvd.getCost())
				return -1;
			else
				return 0;
		}
	}
}
