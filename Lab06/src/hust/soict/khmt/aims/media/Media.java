package hust.soict.khmt.aims.media;

public class Media 
{	
	private String title;
	private String category;	
	private float cost;
	private String nameTag;
	private int id_to_buy;
	private int id_to_store;

	public int getId_to_store() {
		return id_to_store;
	}

	public void setId_to_store(int id_to_store) {
		this.id_to_store = id_to_store;
	}

	public int getId_to_buy() {
		return id_to_buy;
	}

	public void setId_to_buy(int id) {
		this.id_to_buy = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}


	public String getNameTag() {
		return nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
	}

	public float getCost() {
		return cost;
	}

	public void setCost(float cost) {
		this.cost = cost;
	}
	
	public Media() {
		// TODO Auto-generated constructor stub
		this("Default Title");
	}
	
	public Media(String title)
	{
		this.title = title;
	}
	
	public Media(String title, String category)
	{
		this.title = title;
		this.category = category;
	}
	
	public Media(String title, String category, float cost)
	{
		this(title, category);
		this.cost = cost;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}
	
	public void print(int i, int idFree)
	{
		
	}
	
	public void printInStore()
	{
		
	}
}
