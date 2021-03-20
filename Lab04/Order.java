
public class Order {
	
	// Declare classifier member of Oder class
	// Max of orders can be declared
	private static final int MAX_LIMIT_OREDERS = 2;
	private static int nbOrders = 0;
	
	private String orderName;
	
	private static final int MAX_NUM_ORDERED = 10;
	private int qtyOrder = 0;
	private Object itemOrdered[] = new Object[MAX_NUM_ORDERED];
	
	
	public Order() throws Exception {
		// TODO Auto-generated constructor stub\
		nbOrders ++;
		this.orderName = Integer.toString(nbOrders);
		
		if (nbOrders > MAX_LIMIT_OREDERS)
		{
			throw new Exception("Too much orders");
		}
	}
	
	public Order(String nameOrder) throws Exception {
		// TODO Auto-generated constructor stub\
		
		nbOrders ++;
		this.orderName = nameOrder;
		if (nbOrders > MAX_LIMIT_OREDERS)
		{
			throw new Exception("Too much orders");
		}
	}
	
	
	public void addDigitalDisc(DigitalVideoDisc disc) {
		if (qtyOrder < MAX_NUM_ORDERED)
		{
			System.out.println("The disc " + disc.getTitle() + " had be added to order "+ this.orderName);
			this.itemOrdered[qtyOrder] = disc;
			this.qtyOrder += 1;
		}
		else
		{
			if (qtyOrder == MAX_NUM_ORDERED)
				System.out.println("The order is almost full");
		}
	}
	
	public void addDigitalDisc(DigitalVideoDisc[] discList)
	{
		int n = discList.length;
		for (int i = 0; i<n; i++)
		{
			this.addDigitalDisc(discList[i]);
		}
	}
	
	public void addDigitalDisc(DigitalVideoDisc disc1, DigitalVideoDisc disc2)
	{
		this.addDigitalDisc(disc1);
		this.addDigitalDisc(disc2);
	}
	public int getQtyOrder() {
		return qtyOrder;
	}

	public void setQtyOrder(int qtyOrder) {
		this.qtyOrder = qtyOrder;
	}

	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
		
		int i = 0;
		boolean isFound = false;
		for (i =0; i < this.qtyOrder; i++)
		{
			if (this.itemOrdered[i] == disc)
			{
				System.out.println("The disc " + disc.getTitle() + " had be removed from order");
				this.qtyOrder -= 1;
				isFound = true;
				break;
			}
		}
		if (!isFound)
		{
			System.out.println("Can found this disc "+ disc.getTitle());
			return;
		}
		for (;i < this.qtyOrder; i++)
		{
			this.itemOrdered[i] = this.itemOrdered[i+1];
		}
		this.itemOrdered[i] = null;
	}
	
	public float totalCost() {
		float sum = 0.0f;
		
		for (int i = 0; i < this.qtyOrder; i++)
		{
			if (this.itemOrdered[i].getClass() == DigitalVideoDisc.class)
			{
				DigitalVideoDisc item = (DigitalVideoDisc) itemOrdered[i];
				sum += item.getCost();
			}
		}
		return sum;
	}
	
	public void printOrder()
	{
		MyDate currentDate = new MyDate();
		System.out.println("**********************Order "+ this.orderName + "***********************");
		System.out.print("Date: ");
		currentDate.print();
		System.out.println("Ordered Items:");
		int i = 1;
		for (Object item : itemOrdered) {
			if (item == null)
				continue;
			if (item.getClass() == DigitalVideoDisc.class)
			{
				DigitalVideoDisc item1 = (DigitalVideoDisc) item;
				System.out.println(i + ". DVD - " + item1.getTitle() + " - " +  item1.getCategory() + " - " 
						+ item1.getDirector() + " - " + item1.getLength() + " : " + item1.getCost() + " $");
				i++;
			}
		}
		
		System.out.println("Total cost: " + this.totalCost() + " $");
		System.out.println("***************************************************");
		
		
	}
}
