import java.time.*;
import java.util.*;

public class MyDate {
//	private DayOfWeek dayInWeek;
	private int day;
	private int month;
	private int year;
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		if ((day > 31) || (day < 1))
		{
			System.out.println("Invalid day to set to day value");
			return;
		}
		this.day = day;
	}
	public int getMonth() {
		
		return month;
	}
	public void setMonth(int month) {
		if ((month > 12) || (month <1))
		{
			System.out.println("Invalid month to set to month value");
			return;
		}
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		if (year < 0)
		{
			System.out.println("Invalid year to set to year value");	
			return;
		}
		this.year = year;
	}
	
	public MyDate()
	{
		LocalDate currentDate = LocalDate.now();
//		this.dayInWeek = currentDate.getDayOfWeek();
		this.day = currentDate.getDayOfMonth();
		this.month = currentDate.getMonthValue();
		this.year = currentDate.getYear();
	}
	
	public MyDate(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
//		LocalDate currentDate = new LocalDate
	}
	
	public MyDate(String strDate)
	{
		// Xoa tat ca khoang trang truoc khi lam viec
		strDate = strDate.replaceAll("\\s", "");
		
		String[] strMonth = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
				"September", "October", "November", "December" };
		String[] strMonthRutGon = new String[12];
		String[] strMonthThemCham = new String[12];
		
		for (int i = 0; i < 12; i++) {
			strMonthRutGon[i] = strMonth[i].substring(0, 3);
			strMonthThemCham[i] = strMonthRutGon[i] + ".";
		}
		
		int i = 0;
		boolean isValidMonth = false;
		for (i = 0; i<12; i++)
		{
			if (strDate.indexOf(strMonth[i]) != -1 
					|| strDate.indexOf(strMonthRutGon[i]) != -1 
					|| strDate.indexOf(strMonthThemCham[i]) != -1)
			{
				isValidMonth = true;
				break;	
			}
		}
		
		if (!isValidMonth)
		{
			System.out.println("Invalid form of month");
			return;
		}
		
		this.month = i+1;
		
		if (strDate.indexOf(strMonth[i]) != -1)
			strDate = strDate.replaceFirst(strMonth[i], "");
		else if(strDate.indexOf(strMonthThemCham[i]) != -1)
			strDate = strDate.replaceFirst(strMonthThemCham[i], "");
		else strDate = strDate.replaceFirst(strMonthRutGon[i], "");

		// Xem xet den ngay va nam
		if (strDate.indexOf("th") != -1)
		{
			this.day = Integer.parseInt(strDate.split("th")[0]);
			this.year = Integer.parseInt(strDate.split("th")[1]);
		}
		else if (strDate.indexOf("rd") != -1)
		{
			this.day = 3;
			this.year = Integer.parseInt(strDate.split("rd")[1]);
		}
		else if (strDate.indexOf("nd") != -1)
		{
			this.day = 2;
			this.year = Integer.parseInt(strDate.split("nd")[1]);
		}
		else if (strDate.indexOf("st") != -1)
		{
			this.day = 1;
			this.year = Integer.parseInt(strDate.split("st")[1]);
		}
		else
		{
			System.out.println("Invalid form of date");
			return;
		}
		
	}
	
	public void accept()
	{
		System.out.println("Enter your date: ");
		
		Scanner keyboard = new Scanner(System.in);
		String strDate = keyboard.nextLine();
		
		MyDate currentDate = new MyDate(strDate);
		
		this.setDay(currentDate.getDay());
		this.setMonth(currentDate.getMonth());
		this.setYear(currentDate.getYear());
		
		keyboard.close();
	}

	public void print() {
		MyDate currentDate = new MyDate();
		System.out.println(currentDate.getDay() +"/" + currentDate.getMonth() +"/" + currentDate.getYear());
	}
	
}
