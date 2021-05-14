package hust.soict.khmt.test.disc;

import hust.soict.khmt.aims.media.DigitalVideoDisc;
import hust.soict.khmt.aims.order.Order;

public class DiskTest {
	public static void main(String[] args) throws Exception {
		Order anOrder = new Order();
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

		System.out.println(dvd1.search("    The   Lion     King    "));
		System.out.println(dvd1.search("    lion     King    "));
		System.out.println(dvd1.search("    King   Lion    The   "));
		System.out.println(dvd1.search("    King   The"));

		anOrder.addMedia(dvd1, dvd2, dvd3, dvd4, dvd1, dvd2, dvd3, dvd4);
		anOrder.printOrder();

	}
}
