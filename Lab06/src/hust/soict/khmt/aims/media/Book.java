package hust.soict.khmt.aims.media;

import java.util.*;

public class Book extends Media {

	private String nameTag = "Book";

	private List<String> authors = new ArrayList<String>();

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public Book() {
		// TODO Auto-generated constructor stub
		super("Defaul title");
	}

	public Book(String title) {
		super(title);
	}

	public Book(String title, String category) {
		super(title, category);
	}

	public boolean addAuthor(String authorName) {
		if (this.authors.contains(authorName))
			return false;
		else {
			authors.add(authorName);
			return true;
		}
	}

	public boolean removeAUthor(String authorName) {
		if (this.authors.contains(authorName)) {
			authors.remove(authors.indexOf(authorName));
			return true;
		} else
			return false;
	}

	@Override
	public void print(int i, int idFree) {
		super.print(i, idFree);
		String price;
		if (idFree == i)
			price = "Free";
		else
			price = Float.toString(this.getCost()) + " $";
		System.out.print((i + 1) + ". " + this.nameTag + " - " + this.getTitle() + " - " + this.getCategory()
				+ " - " + String.join(", ", this.getAuthors()) + " : " + price + "\n");
	}
	
	@Override
	public void printInStore() {
		// TODO Auto-generated method stub
		super.printInStore();
		System.out.print(this.getId_to_store() + ". " + this.nameTag + " - " + this.getTitle() + " - " + this.getCategory()
		+ " - " + String.join(", ", this.getAuthors()) + " : " + this.getCost() + "\n");
	}
}
