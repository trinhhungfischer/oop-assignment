
public class Aims {
	public static void main(String[] args) {
		// TODO Auto-generate method stub
		Order anOrder;
		DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
		dvd1.setCategory("Animation");
		dvd1.setCost(19.0f);
		dvd1.setDirector("Roger Allers");
		dvd1.setLength(87);
		
		DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star War");
		dvd2.setCategory("Science Fiction");
		dvd2.setCost(24.0f);
		dvd2.setDirector("George Lucas");
		dvd2.setLength(124);
		
		DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin");
		dvd3.setCategory("Animation");
		dvd3.setCost(18.5f);
		dvd3.setDirector("John Musker");
		dvd3.setLength(90);
		
		DigitalVideoDisc dvd4 = new DigitalVideoDisc("Alachoke");
		dvd4.setCategory("Animation");
		dvd4.setCost(9999.99f);
		dvd4.setDirector("Trinh Hung");
		dvd4.setLength(90);
		
		// This is to try to make first order
		// Max of order is 2
		try {
			anOrder = new Order();
			
			
			anOrder.addDigitalDisc(dvd1);
			anOrder.addDigitalDisc(dvd2);
			anOrder.addDigitalDisc(dvd3);
			
			DigitalVideoDisc[] discList = {dvd1, dvd2, dvd3};
			
			// Remove two disc to test remvove function
			anOrder.removeDigitalVideoDisc(dvd4);
			anOrder.removeDigitalVideoDisc(dvd2);
			
			// Add disc to fullfill the order which had 2 disc now
			for (int i = 0; i<5; i++)
			{
				anOrder.addDigitalDisc(dvd3);
			}
			
			anOrder.addDigitalDisc(discList);
			anOrder.addDigitalDisc(dvd3, dvd1);
			anOrder.printOrder();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		// Try to make second order
		try {
			Order anOrder2 = new Order();
			anOrder2.addDigitalDisc(dvd1);
			anOrder2.addDigitalDisc(dvd2);
			anOrder2.addDigitalDisc(dvd4);
			
			anOrder2.printOrder();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		try {
			Order anOrder3 = new Order();
			anOrder3.addDigitalDisc(dvd1);
			anOrder3.addDigitalDisc(dvd2);
			anOrder3.addDigitalDisc(dvd4);
			
			anOrder3.printOrder();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		
		
	}
}
