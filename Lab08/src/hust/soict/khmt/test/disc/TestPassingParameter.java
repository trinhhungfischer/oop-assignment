package hust.soict.khmt.test.disc;
import hust.soict.khmt.aims.media.DigitalVideoDisc;

public class TestPassingParameter {
	public static void main(String[] args) {
		DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
		DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");
		
		swap(jungleDVD, cinderellaDVD);
		System.out.println("Jungle DVD title  is: "+ jungleDVD.getTitle());
		System.out.println("Cinderella DVD title is: "+ cinderellaDVD.getTitle());
		
		changeTitle(jungleDVD, cinderellaDVD.getTitle());
		System.out.println("Jungle DVD title  is: "+ jungleDVD.getTitle());
	}
	
	public static void  swap(Object o1, Object o2) {
		Object tmp = o1;
		o1 = o2;
		o2 = tmp;
	}
	
	// This is really swap function in this game
	public static void  swap(DigitalVideoDisc o1, DigitalVideoDisc o2) {
		DigitalVideoDisc tmp = new DigitalVideoDisc();
		tmp.setTitle(o1.getTitle());
		tmp.setCategory(o1.getCategory());
		tmp.setLength(o1.getLength());
		tmp.setCost(o1.getCost());
		tmp.setDirector(o1.getDirector());	
		
		o1.setTitle(o2.getTitle());
		o1.setCategory(o2.getCategory());
		o1.setLength(o2.getLength());
		o1.setCost(o2.getCost());
		o1.setDirector(o2.getDirector());
		
		o2.setTitle(tmp.getTitle());
		o2.setCategory(tmp.getCategory());
		o2.setLength(tmp.getLength());
		o2.setCost(tmp.getCost());
		o2.setDirector(tmp.getDirector());
	}
	
	public static void changeTitle(DigitalVideoDisc dvd, String title)
	{
		String oldtitle = dvd.getTitle();
		dvd.setTitle(title);
		dvd = new DigitalVideoDisc(oldtitle);
	}
}
