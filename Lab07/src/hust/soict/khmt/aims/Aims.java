package hust.soict.khmt.aims;

import java.util.*;
import java.util.Scanner;


import hust.soict.khmt.aims.media.Book;
import hust.soict.khmt.aims.media.CompactDiscs;
import hust.soict.khmt.aims.media.DigitalVideoDisc;
import hust.soict.khmt.aims.media.Disc;
import hust.soict.khmt.aims.media.Media;
import hust.soict.khmt.aims.media.Track;
import hust.soict.khmt.aims.order.Order;

public class Aims {
	private static boolean status = true;
	private static List<Order> listOrder = new ArrayList<>();
	private static int index = 0;
	private static int currentOrder = 0;
	private static List<Media> listMedia = new storage().mediaList; 
	private static Scanner keyboard = new Scanner(System.in);
	
	

	public static void main(String[] args) {
		loopMenu();
		MemoryDaemon md = new MemoryDaemon();
		Thread newThread = new Thread(md);		
		newThread.setDaemon(true);
		newThread.start();
	}
	
	private static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------");
		System.out.println("1. Create new order");
		System.out.println("2. Add item to the order");
		System.out.println("3. Delete item by id");
		System.out.println("4. Display the items list of order");
		System.out.println("5. Display the items my store have");
		System.out.println("6. Switch the order");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	
	public static void loopMenu()
	{
		while (status)
		{
			try {
				showMenu();
				
				if (keyboard.hasNextLine()) 
				{
					int cmd = keyboard.nextInt();
					switch (cmd)
					{
					case 1:
					{
						Order newOrder = new Order();
						listOrder.add(newOrder);
						index ++;
						currentOrder ++;
						break;
					}
					case 2: // Add media to order
					{
						
						if (index <= 0)
						{
							System.out.println("You haven't create any order");
							break;
						}
						System.out.println("Input the item you want to add (1.DVD, 2.Book, 3.CD)");
						int choice = keyboard.nextInt();
						switch (choice) {
							case 1:
							{
								showDVD();
								addItem();
								
								
								break;
							}
							case 2:
							{
								showBook();
								addItem();
								break;
							}
							case 3:
							{
								showTrack();
								addCD();
								break;
							}
							
						}
						break;
						
					}
					case 3:
					{ 
						if (index <= 0)
						{
							System.out.println("You haven't create any order");
							break;
						}
						System.out.println("Input the ID of Item (To know item ID to remoce, use 4 of main menu)");
						System.out.println("Input 0 to return menu, or input item ID");
						if (keyboard.hasNextLine())
						{
							int k = keyboard.nextInt();
							if (k == 0) break;
							else 
							{
								listOrder.get(currentOrder - 1).removeMedia(k);
							}
						}
						break;
						
					}
					case 4:
					{
						if (index <= 0)
						{
							System.out.println("You haven't create any order");
							break;
						}
						listOrder.get(currentOrder - 1).printOrder();
						break;
					}
					case 5:
					{
						showStore();
						break;
					}
					case 6:
					{
						if (index <= 0)
						{
							System.out.println("You haven't create any order");
							break;
						}
						System.out.println("Input the ID of Order to switch");
						System.out.println("Input 0 to return menu, or input item ID");
						if (keyboard.hasNextLine())
						{
							int k = keyboard.nextInt();
							if (k == 0) break;
							else 
							{
								currentOrder = k;
							}
						}
					}
					case 0:
					{
						status = false;
						break;
					}
					}
				}
			}
			catch (Exception e)
			{
				e.printStackTrace(System.out);
			}
			finally {
				if (status != false)
				{
					System.out.println("________________________________________________________________________");
					System.out.println("________________________________________________________________________");
					if (currentOrder > 0)
					{
						System.out.println("_______________________________Order "+ currentOrder  +"__________________________________");	
					}
				}
			}
		}
	}
	
	public static void addCD()
	{
		CompactDiscs newCD = new CompactDiscs();
		while (true)
		{
			System.out.println("Input the ID of Track to add");
			System.out.println("Input 0 to return menu, or input item ID");
			

			if (keyboard.hasNextLine())
			{
				int k = keyboard.nextInt();
				if (k == 0) break;
				else 
				{
					Track aTrack = (Track) listMedia.get(k-1);
					newCD.addTrack(aTrack);
				}
			}
		}
		
		listOrder.get(currentOrder - 1).addMedia(newCD);
		System.out.println("Do you wana play this DVD: 1.Yes 2.No");
		int isPlay = keyboard.nextInt();
		if (isPlay == 1) {
			newCD.play();
		}
		
	}
	
	public static void showDVD()
	{
			System.out.println("____________________________THIS IS MY DVD______________________________");
		 
			for (int i = 0; i < listMedia.size(); i++)
			{
				if (listMedia.get(i).getClass() == DigitalVideoDisc.class)
					listMedia.get(i).printInStore();
			}

		    System.out.println("________________________________________________________________________");
	}
	
	public static void showBook()
	{
			System.out.println("____________________________THIS IS MY BOOK_____________________________");
		 
			for (int i = 0; i < listMedia.size(); i++)
			{
				if (listMedia.get(i).getClass() == Book.class)
					listMedia.get(i).printInStore();
			}

		    System.out.println("________________________________________________________________________");
	}
	 
	public static void showTrack()
	{
			System.out.println("____________________________THIS IS MY TRACK____________________________");
		 
			for (int i = 0; i < listMedia.size(); i++)
			{
				if (listMedia.get(i).getClass() == Track.class)
					listMedia.get(i).printInStore();
			}

		    System.out.println("________________________________________________________________________");
	}

	public static void showStore()
	{ 
		System.out.println("____________________________THIS IS MY STORE____________________________");
	 
		for (int i = 0; i < listMedia.size(); i++)
		{
			listMedia.get(i).printInStore();;
		}

	    System.out.println("________________________________________________________________________");
	}
	
	public static void addItem()
	{
		System.out.println("Input the ID of Item to add (To know item ID, use 5 of main menu)");
		System.out.println("Input 0 to return menu, or input item ID");
		if (keyboard.hasNextLine())
		{
			int k = keyboard.nextInt();
			if (k == 0) return;
			else 
			{
				listOrder.get(currentOrder - 1).addMedia(listMedia.get(k -1));
			}
			if (listMedia.get(k-1).getClass() == DigitalVideoDisc.class || listMedia.get(k-1).getClass() == CompactDiscs.class)
			{
				System.out.println("Do you wana play this DVD: 1.Yes 2.No");
				int isPlay = keyboard.nextInt();
				if (isPlay == 1) {
					Disc item = (Disc) listMedia.get(k-1);
					item.play();
				}
			}
		}
	}
}
