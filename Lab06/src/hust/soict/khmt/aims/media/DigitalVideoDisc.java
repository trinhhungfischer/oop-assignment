package hust.soict.khmt.aims.media;

public class DigitalVideoDisc extends Media {
	private String title;
	private String director;
	private int length;
	private String nameTag = "DVD";

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public DigitalVideoDisc() {
		this("Default title");
	}

	public DigitalVideoDisc(String title) {
		super(title);
	}

	public DigitalVideoDisc(String title, String category) {
		super(title, category);
	}

	public DigitalVideoDisc(String title, String category, String director) {
		super(title, category);
		this.director = director;
	}

	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, cost);
		this.director = director;
		this.length = length;
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
		if (idFree == i)
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
}
