
public class Aims {
	public static void main(String[] args) {
		// TODO Auto-generate method stub
		Order anOrder = new Order();
		
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
		
		anOrder.addDigitalDisc(dvd1);
		anOrder.addDigitalDisc(dvd2);
		anOrder.addDigitalDisc(dvd3);
		
		// Now cost after add three dvd
		System.out.print("Total cost is ");
		System.out.println(anOrder.totalCost() +" $");
		
		// Remove two disc to test remvove function
		anOrder.removeDigitalVideoDisc(dvd4);
		anOrder.removeDigitalVideoDisc(dvd2);
		System.out.print("Total cost after removed is ");
		System.out.println(anOrder.totalCost() + " $");
		
		// Add disc to fullfill the order which had 2 disc now
		for (int i = 0; i<10; i++)
		{
			anOrder.addDigitalDisc(dvd3);
		}
		
		
	}
}
