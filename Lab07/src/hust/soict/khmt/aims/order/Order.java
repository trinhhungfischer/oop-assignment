package hust.soict.khmt.aims.order;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hust.soict.khmt.aims.media.DigitalVideoDisc;
import hust.soict.khmt.aims.media.Media;
import hust.soict.khmt.aims.utils.MyDate;

public class Order {
	
	// Declare classifier member of Oder class
	// Max of orders can be declared
	private static final int MAX_LIMIT_OREDERS = 10;
	private static int nbOrders = 0;
	private float totalCost;
	private String orderName;
	
	private static final int MAX_NUM_ORDERED = 10;
	private int LuckyIndex;
	private List<Media> itemOrdered = new ArrayList<Media>();
	
	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	
	public Order() throws Exception {
		// TODO Auto-generated constructor stub\
		nbOrders ++;
		System.out.println("***************************************************");
		
		this.orderName = Integer.toString(nbOrders);
		System.out.println("Try to create order " + this.orderName);
		if (nbOrders > MAX_LIMIT_OREDERS)
		{
			throw new Exception("Too much orders");
		}
		else
		{
			System.out.println("Sucess");
		}
	}
	
	public Order(String nameOrder) throws Exception {
		// TODO Auto-generated constructor stub\
		
		nbOrders ++;
		System.out.println("***************************************************");
		System.out.println("Try to create order " + this.orderName);
		
		this.orderName = nameOrder;
		if (nbOrders > MAX_LIMIT_OREDERS)
		{
			throw new Exception("Too much orders");
		}
		else
		{
			System.out.println("Sucess");
		}
	}
		
	public void addMedia(Media item) {
		if (itemOrdered.size() < MAX_NUM_ORDERED)
		{
			System.out.println("The " + item.getNameTag() + " " + item.getTitle() + " had be added to order "+ this.orderName);
			this.itemOrdered.add(item);
			item.setId_to_buy(this.itemOrdered.size());
		}
		else
		{
			if (itemOrdered.size() == MAX_NUM_ORDERED)
				System.out.println("The order" + this.orderName +  "is almost full");
		}
	}
	
	public void addMedia(Media disc1, Media disc2)
	{
		this.addMedia(disc1);
		this.addMedia(disc2);
	}
	
	public void addMedia(Media... disc)
	{
		for (Media item : disc)
		{
			this.addMedia(item);	
		}
	}

	public void removeMedia(int i) {
	
		if (i <= itemOrdered.size())
		{
			Media item = itemOrdered.get(i - 1);
			System.out.println("The " + item.getNameTag() + " " + item.getTitle() + " had be removed from order " + this.orderName);
			this.itemOrdered.remove(i - 1);		
		}
		
		else
		{
			System.out.println("Your index is out of list Item ");
			return;
		}	
	}
	
	public float totalCost() {
		float sum = 0.0f;
		
		for (int i = 0; i < this.itemOrdered.size(); i++)
		{
			sum += itemOrdered.get(i).getCost();
		}
		this.totalCost = sum;
		return sum;
	}
	
	public void printOrder()
	{
		MyDate currentDate = new MyDate();
		this.LuckyIndex =  this.getALuckyItem();
		
		System.out.println("**********************Order "+ this.orderName + "***********************");
		System.out.print("Date: ");
		currentDate.print();
		System.out.println("Ordered Items:");
		
		for (int i = 0; i < itemOrdered.size(); i++)
		{
			itemOrdered.get(i).print(i, LuckyIndex);
		}
		this.totalCost = this.totalCost() - itemOrdered.get(this.LuckyIndex).getCost();
		
		System.out.println("Total cost: " + this.totalCost + " $");
		System.out.println("***************************************************");	
	}
	
	
	public int getALuckyItem()
	{
		int i = new Random().nextInt(this.itemOrdered.size());
		return i;
	}
}
