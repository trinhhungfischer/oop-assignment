package hust.soict.khmt.aims.media;

import java.util.*;

public class Book extends Media {

	private String nameTag = "Book";

	private List<String> authors = new ArrayList<String>();

	private TreeMap<String, Integer> wordFrequency = new TreeMap<>();

	private List<String> contentTokens = new ArrayList<>();

	private String content;

	public List<String> getAuthors() {
		return authors;
	}

	public void setAuthors(List<String> authors) {
		this.authors = authors;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		processContent();
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

	public boolean removeAuthor(String authorName) {
		if (this.authors.contains(authorName)) {
			authors.remove(authors.indexOf(authorName));
			return true;
		} else
			return false;
	}

	@Override
	public String print(int i, int idFree) {
		super.print(i, idFree);
		String price;
		if (idFree >= 0)
			price = "Free";
		else
			price = Float.toString(this.getCost()) + " $";
		return ((i+1) + ". " + this.nameTag + " - " + this.getTitle() + " - " + this.getCategory() + " - "
				+ String.join(", ", this.getAuthors()) + " : " + price + "\n");
	}

	@Override
	public String printInStore() {
		// TODO Auto-generated method stub
		super.printInStore();
		String str = this.getId_to_store() + ". " + this.nameTag + " - " + this.getTitle() + " - "
				+ this.getCategory() + " - " + String.join(", ", this.getAuthors()) + " : " + this.getCost() + "\n";
		return str;
	}

	public void processContent() {
		String[] tokens = this.content.replaceAll("[^a-zA-Z0-9]", " ").split(" |\\.");
		for (int i = 0; i < tokens.length; i++)
			contentTokens.add(tokens[i]);

		Collections.sort(contentTokens);

		int i = 0;
		int value = 1;
		while (i < contentTokens.size() - 1) {
			if (contentTokens.get(i).equals(contentTokens.get(i + 1)))
				value++;
			else {
				wordFrequency.put(contentTokens.get(i), value);
				value = 1;
			}
			i++;
		}
		if (!(contentTokens.get(i).equals(contentTokens.get(i - 1))))
			wordFrequency.put(contentTokens.get(i), 1);

	}

	@Override
	public String toString() {
		StringBuffer strbuffer = new StringBuffer();
		strbuffer.append(this.title + " / " + this.category + "/ " + String.join("-", this.authors));
		strbuffer.append("\ncost:" + this.cost + " $/ Length:" + this.wordFrequency.size() + "/ content: \n");
		for (Map.Entry<String, Integer> entry : wordFrequency.entrySet())
			strbuffer.append(entry.getKey() + ": " + entry.getValue() + " \n");
		return strbuffer.toString();
	}

}
