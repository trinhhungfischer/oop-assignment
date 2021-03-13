
public class Order {
	private static final int MAX_NUM_ORDERED = 10;
	private int qtyOrder = 0;
	private DigitalVideoDisc itemOrdered[] = new DigitalVideoDisc[MAX_NUM_ORDERED];
	
	
	public void addDigitalDisc(DigitalVideoDisc disc) {
		if (qtyOrder < MAX_NUM_ORDERED)
		{
			System.out.println("The disc " + disc.getTitle() + " had be added to order");
			this.itemOrdered[qtyOrder] = disc;
			this.qtyOrder += 1;
		}
		else
		{
			if (qtyOrder == MAX_NUM_ORDERED)
				System.out.println("The order is almost full");
		}
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
			sum += this.itemOrdered[i].getCost();
		}
		return sum;
	}
	
	
}
