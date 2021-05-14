package hust.soict.khmt.aims.media;

import javax.swing.JOptionPane;

public class Track extends Media implements Playable, Comparable<Object> {

	private int length;

	public Track() {
		this("Default title");
	}

	public Track(String title) {
		this.title = title;
	}

	public Track(String title, int length) {
		this.title = title;
		this.length = length;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		JOptionPane.showMessageDialog(null, "Dang phat", this.title, JOptionPane.PLAIN_MESSAGE);
	}

	@Override
	public String printInStore() {
		// TODO Auto-generated method stub
		super.printInStore();
		String str = this.getId_to_store() + ". Track - " + this.getTitle() + " - " + this.getLength() + " : "
				+ this.getCost() + "\n";
		return str;
	}
	
	@Override
	public String print(int i, int idFree) {
		// TODO Auto-generated method stub
		return super.print(i, idFree);
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Track))
			return false;
		else {
			Track newTrack = (Track) obj;
			if (newTrack.length == this.length && newTrack.title == this.title)
				return true;
			else
				return false;
		}
	}
}
