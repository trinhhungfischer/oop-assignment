package hust.soict.khmt.aims.media;

public class DigitalVideoDisc extends Disc
implements Playable
{
	private String nameTag = "DVD";

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
	public void print(int i, int idFree) {
		// TODO Auto-generated method stub
		super.print(i, idFree);

		String price;
		if (idFree >= 0)
			price = "Free";
		else
			price = Float.toString(this.getCost()) + " $";
		System.out.println((i + 1) + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - "
				+ this.getDirector() + " - " + this.getLength() + " : " + price);
	}
	
	@Override
	public void printInStore() {
		// TODO Auto-generated method stub
		super.printInStore();
		System.out.println(this.getId_to_store() + ". DVD - " + this.getTitle() + " - " + this.getCategory() + " - "
				+ this.getDirector() + " - " + this.getLength() + " : " + this.getCost());
	}
	
	@Override
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
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
			else return 0;
		}
	}
}
