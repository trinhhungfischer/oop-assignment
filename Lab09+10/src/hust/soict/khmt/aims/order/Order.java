package hust.soict.khmt.aims.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import hust.soict.khmt.aims.exceptions.OrderException;
import hust.soict.khmt.aims.exceptions.WrongIDException;
import hust.soict.khmt.aims.media.DigitalVideoDisc;
import hust.soict.khmt.aims.media.Media;
import hust.soict.khmt.aims.utils.MyDate;
import hust.soict.khmt.aims.utils.Storage;

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
	private List<Media> listMedia = Storage.mediaList;
	private static List<Order> listOrder = new ArrayList<>();
	private static int currentOrderIndex;
	
	public static int getCurrentOrderIndex() {
		return currentOrderIndex;
	}

	public static void setCurrentOrderIndex(int currentOrderIndex) {
		Order.currentOrderIndex = currentOrderIndex;
	}
	
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public float getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(float totalCost) {
		this.totalCost = totalCost;
	}

	public Order() throws OrderException {
		// TODO Auto-generated constructor stub\
		System.out.println("***************************************************");
		System.out.println("Try to create order ");
		if (nbOrders > MAX_LIMIT_OREDERS - 1) {
			throw new OrderException("Too much orders");
		} else {
			nbOrders++;
			listOrder.add(this);
			currentOrderIndex = listOrder.size();
			System.out.println("Sucess");
		}
		this.orderName = Integer.toString(nbOrders);
		
	}

	public Order(String nameOrder) throws OrderException {
		// TODO Auto-generated constructor stub\
		System.out.println("***************************************************");
		System.out.println("Try to create order ");

		this.orderName = nameOrder;
		if (nbOrders > MAX_LIMIT_OREDERS - 1) {
			throw new OrderException("Too much orders");
		} else {
			nbOrders++;
			listOrder.add(this);
			currentOrderIndex = listOrder.size();
			System.out.println("Sucess");
		}


	}
	
	public int size()
	{
		return itemOrdered.size();
	}
	
	public static void RemoveOrder(int ID)
	{
		listOrder.remove(ID - 1);
		for (int i = 0; i < listOrder.size(); i++)
		{
			listOrder.get(i).setOrderName(Integer.toString(i + 1));
		}
		nbOrders -= 1;
		if (ID - 1 <= currentOrderIndex)
			currentOrderIndex -= 1;
	}

	public void addMedia(Media item) throws Exception {
		if (itemOrdered.size() < MAX_NUM_ORDERED) {
			System.out.println(
					"The " + item.getNameTag() + " " + item.getTitle() + " had be added to order " + this.orderName);
			this.itemOrdered.add(item);
		} else {
			if (itemOrdered.size() == MAX_NUM_ORDERED) {
				System.out.println("The order" + this.orderName + "is almost full");
				throw new Exception("The Order is Full");
			}
		}
	}

	public void addMediaById(int ID) throws Exception {
		if (ID > listMedia.size() + 1) {
			throw new WrongIDException("ID is out of range List Media");
		} else {
			this.addMedia(listMedia.get(ID - 1));
		}
	}

	public void addMedia(Media disc1, Media disc2) throws Exception {
		this.addMedia(disc1);
		this.addMedia(disc2);
	}

	public void addMedia(Media... disc) throws Exception {
		for (Media item : disc) {
			this.addMedia(item);
		}
	}

	public void removeMediaByID(int i) throws Exception {

		if (i <= itemOrdered.size() || i >= 1) {
			Media item = itemOrdered.get(i - 1);
			System.out.println("The " + item.getNameTag() + " " + item.getTitle() + " had be removed from order "
					+ this.orderName);
			this.itemOrdered.remove(i - 1);
			}

		else {
			System.out.println("Your index is out of list Item ");
			throw new WrongIDException("Your index is out of list Item");
		}
	}

	private float totalCost() {
		float sum = 0.0f;

		for (int i = 0; i < this.itemOrdered.size(); i++) {
			sum += itemOrdered.get(i).getCost();
		}
		this.totalCost = sum;
		return sum;
	}

	public String printOrder() {
		MyDate currentDate = new MyDate();
		this.LuckyIndex = this.getALuckyItem();

		StringBuffer strBuffer = new StringBuffer();
		strBuffer.append("**********************Order " + this.orderName + "***********************\n");
		strBuffer.append("Date: " + currentDate.toString());
		strBuffer.append("Items: \n");

		for (int i = 0; i < itemOrdered.size(); i++) {
			if (i == LuckyIndex) {
				strBuffer.append(itemOrdered.get(i).print(i, LuckyIndex));
			} else
				strBuffer.append(itemOrdered.get(i).print(i, -1));
		}
		if (this.LuckyIndex != -1)
			this.totalCost = this.totalCost() - itemOrdered.get(this.LuckyIndex).getCost();
		else this.totalCost = this.totalCost();
		strBuffer.append("Total cost: " + this.totalCost + " $\n");
		strBuffer.append("***************************************************");
		return strBuffer.toString();
	}

	public static List<Order> getListOrder() {
		return listOrder;
	}

	public static void setListOrder(List<Order> listOrder) {
		Order.listOrder = listOrder;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		StringBuffer strBuffer = new StringBuffer();
		for (int i = 0; i < itemOrdered.size(); i++) {
			strBuffer.append(itemOrdered.get(i).print(i, -1));
		}
		return strBuffer.toString();
	}

	public String strBill() {
		StringBuffer strBuffer = new StringBuffer();
		MyDate currentDate = new MyDate();
		strBuffer.append("_____Order " + this.orderName + "______\n");
		strBuffer.append("Date: " + currentDate.toString() + "\n");
		strBuffer.append("Total cost: " + this.totalCost() + " $\n");
		this.totalCost = this.totalCost();
		return strBuffer.toString();
	}

	public int getALuckyItem() {
		if (this.getTotalCost() > 150)
		{
			int luckyId = this.generateALuckyId(50);
			return luckyId;			
		}
		else if (this.getTotalCost() > 300)
		{
			int luckyId = this.generateALuckyId(100);
			return luckyId;				
		}
		else return -1;
	}
	
	private int generateALuckyId(float cost)
	{
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < itemOrdered.size(); i++)
		{
			if (itemOrdered.get(i).getCost() < cost)
			{
				str.append(Integer.toString(i));
			}
		}
		int bound = str.length();
		if (bound > 0)
		{
			int lucky = new Random().nextInt(bound);
			return Integer.parseInt(str.substring(lucky, lucky + 1));			
		}
		else return -1;
	}
	
	public static Order getCurrentOrder()
	{
		return listOrder.get(currentOrderIndex - 1);
	}
}
