package hust.soict.khmt.aims.media;

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
	}

	@Override
	public void printInStore() {
		// TODO Auto-generated method stub
		super.printInStore();
		System.out.println(this.getId_to_store() + ". Track - " + this.getTitle() + " - " + this.getLength() + " : "
				+ this.getCost());
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
