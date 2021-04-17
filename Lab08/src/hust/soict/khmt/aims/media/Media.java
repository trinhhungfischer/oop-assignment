package hust.soict.khmt.aims.media;

public abstract class Media implements Comparable<Object> {
	protected String title;
	protected String category;
	protected float cost;
	protected String nameTag;
	protected int id_to_store;

	public int getId_to_store() {
		return id_to_store;
	}

	public void setId_to_store(int id_to_store) {
		this.id_to_store = id_to_store;
	}

	public String getTitle() {
		return title;
	}

	public String getCategory() {
		return category;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	public String getNameTag() {
		return nameTag;
	}

	public float getCost() {
		return cost;
	}

	public Media() {

	}

	public Media(String title) {
		this.title = title;
	}

	public Media(String title, String category) {
		this.title = title;
		this.category = category;
	}

	public void print(int i, int idFree) {

	}

	public void printInStore() {

	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		if (!(obj instanceof Media))
			return false;
		else {
			Media thisObj = (Media) obj;
			if (thisObj.id_to_store == this.id_to_store) {
				return true;
			} else
				return false;
		}
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (!(o instanceof Media)) {
			return o.getClass().toString().compareTo(Media.class.toString());
		} else {
			Media item = (Media) o;
			return this.title.compareTo(item.title);
		}
	}
}
