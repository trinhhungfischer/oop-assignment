
public class DateTest {
	public static void main(String[] args) {
		
		// This is example of three contructor functions with overloading function technique
		MyDate currentDate = new MyDate();
		MyDate inputDate = new MyDate(13, 3, 2020);
		MyDate breakDate = new MyDate("April 13th 2020");
		
		breakDate.setDay(100);
		inputDate.setMonth(5);
		System.out.println(breakDate.getMonth());
		
		
		breakDate.accept();
		System.out.println(breakDate.getMonth());
		
		currentDate.print();
	}
}
