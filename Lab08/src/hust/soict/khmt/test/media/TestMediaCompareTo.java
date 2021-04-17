package hust.soict.khmt.test.media;

import java.util.*;

import hust.soict.khmt.aims.media.DigitalVideoDisc;

public class TestMediaCompareTo {

	private static List<DigitalVideoDisc> listDVD = new ArrayList<>();
	
	public TestMediaCompareTo() {
		// TODO Auto-generated constructor stub
	}

	
	public static void main(String[] args) {
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.95f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.95f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.95f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Alachoke");
		dvd4.setCategory("Animation");
		dvd4.setCost(9999.99f);
		dvd4.setDirector("Trinh Hung");
		dvd4.setLength(90);
		
		listDVD.add(dvd4);
		listDVD.add(dvd2);
		listDVD.add(dvd3);
		listDVD.add(dvd1);
		
		Iterator iterator = listDVD.iterator();
		System.out.println("__________________________________");
		System.out.println("The DVD currently in the order are");
		
		while (iterator.hasNext())
		{
			DigitalVideoDisc dvd = ((DigitalVideoDisc)iterator.next());
			System.out.println(dvd.getTitle() + ": " + dvd.getCost() + " $");
		}
		
		Collections.sort(listDVD);
		iterator = listDVD.iterator();
		System.out.println("______________________________________");
		System.out.println("The DVD currently in sorted oreder are");
		
		while (iterator.hasNext())
		{

			DigitalVideoDisc dvd = ((DigitalVideoDisc)iterator.next());
			System.out.println(dvd.getTitle() + ": " + dvd.getCost() + " $");		}
	}
}

