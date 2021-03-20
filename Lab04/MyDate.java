import java.time.*;
import java.util.*;

public class MyDate {
//	private DayOfWeek dayInWeek;
	private int day;
	private int month;
	private int year;
	String[] strMonth = new String[] { "January", "February", "March", "April", "May", "June", "July", "August",
			"September", "October", "November", "December" };
	String[] strMonthRutGon = new String[12];
	String[] strMonthThemCham = new String[12];
	
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
		
		for (int i = 0; i < 12; i++) {
			strMonthRutGon[i] = strMonth[i].substring(0, 3);
			strMonthThemCham[i] = strMonthRutGon[i] + ".";
		}
	}
	
	public MyDate(int day, int month, int year)
	{
		this.day = day;
		this.month = month;
		this.year = year;
//		LocalDate currentDate = new LocalDate
		
		for (int i = 0; i < 12; i++) {
			strMonthRutGon[i] = strMonth[i].substring(0, 3);
			strMonthThemCham[i] = strMonthRutGon[i] + ".";
		}
	}
	
	public MyDate(String strDate)
	{
		// Xoa tat ca khoang trang truoc khi lam viec
		strDate = strDate.replaceAll("\\s", "");
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
			this.day = Integer.parseInt(strDate.split("rd")[0]);
			this.year = Integer.parseInt(strDate.split("rd")[1]);
		}
		else if (strDate.indexOf("nd") != -1)
		{
			this.day = Integer.parseInt(strDate.split("nd")[1]);
			this.year = Integer.parseInt(strDate.split("nd")[1]);
		}
		else if (strDate.indexOf("st") != -1)
		{
			this.day = Integer.parseInt(strDate.split("st")[1]);
			this.year = Integer.parseInt(strDate.split("st")[1]);
		}
		else
		{
			System.out.println("Invalid form of date");
			return;
		}
		
	}
	
	public MyDate(String Day, String Month, String Year)
	{
		  String[] numNames = {
				    "",
				    "first",
				    "second",
				    "third",
				    "four",
				    "fifth",
				    "sixth",
				    "seventh",
				    "eighth",
				    "ninth",
				    "tenth",
				    "eleventh",
				    "twelfth",
				    "thirteenth",
				    "fourteenth",
				    "fifteenth",
				    "sixteenth",
				    "seventeenth",
				    "eighteenth",
				    "nineteenth",
				    "twentith"
				};
		  int n = numNames.length;
		  numNames = Arrays.copyOf(numNames, n + 11);
		  for (int i=1; i<= 9; i++)
		  {
			  numNames[n-1 + i] = "twenty-" + numNames[i];
		  }
		  numNames[30] = "thirtith";
		  numNames[31] = "thirty-first";
		  int i = 1;
		  for (i =1; i<=31; i++)
		  {
			  if (numNames[i].equals(Day))
				  break;
		  }
		  
		  if (i == 32)
			  System.out.println("Invalid day to input");
		  else this.day = i;
		  
		  for (i = 0; i<12; i++)
		  {
			  if (strMonth[i].equals(Month))
				  break;
		  }
		  if (i == 12)
			  System.out.println("Invalid month to input");
		  else this.month = i + 1;
		  
		  // Chuyen doi nam ne
		  this.year = Integer.parseInt(wordToYear(Year));
		  
		  
	}
	
	public static String toInteger(String strNum)
	{
		 List<String> allowedStrings = Arrays.asList
				    (
				    "zero","one","two","three","four","five","six","seven",
				    "eight","nine","ten","eleven","twelve","thirteen","fourteen",
				    "fifteen","sixteen","seventeen","eighteen","nineteen","twenty",
				    "thirty","forty","fifty","sixty","seventy","eighty","ninety"
				    );
		 int[] equalInt = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 
				 17, 18, 19, 20, 30, 40, 50, 60, 70, 80, 90};
		
		 int num = 0;
		 
		 if (strNum.equals("thousand"))
			 return "000";
		 if (strNum.equals("oh"))
			 return "0";
		 
		 if (strNum.indexOf('-') != -1)
		 {
			 num += equalInt[allowedStrings.indexOf(strNum.split("-")[0])];
			 num += equalInt[allowedStrings.indexOf(strNum.split("-")[1])];
		 }
		 else
			 num += equalInt[allowedStrings.indexOf(strNum)];
		 
		 
		return Integer.toString(num);
		 
	}
	
	public static String wordToYear(String year)
	{
		if (year.split(" ").length == 1)
			return toInteger(year);
		else if (year.split(" ").length == 2)
			return toInteger(year.split(" ")[0]) + toInteger(year.split(" ")[1]);
		else
			return toInteger(year.split(" ")[0]) + toInteger(year.split(" ")[1]) + toInteger(year.split(" ")[2]);
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
		if (currentDate.getDay() %10 == 1)
			System.out.println(strMonth[currentDate.getMonth()-1] +" 1st " + currentDate.getYear());
		else if (currentDate.getDay() %10 == 2)
			System.out.println(strMonth[currentDate.getMonth()-1] +" 2nd " + currentDate.getYear());
		else if (currentDate.getDay() %10 == 3)
			System.out.println(strMonth[currentDate.getMonth()-1] +" 3rd " + currentDate.getYear());
		else System.out.println(strMonth[currentDate.getMonth()-1] +" " +currentDate.getDay() +  "th " + currentDate.getYear());
		
	}
	
	public void print(int type)
	{
		MyDate currentDate = new MyDate();
		switch (type)
		{
		case 1:
		{
			String day = String.format("%02d", currentDate.getDay());
			String month = String.format("%02d", currentDate.getMonth());
			System.out.println(currentDate.getYear() + "-" + month + "-"+day);
			break;
		}
		case 2:
		{
			System.out.println(currentDate.getDay() + "/" + currentDate.getMonth() +"/" +currentDate.getYear());
			break;
		}
		case 3:
		{
			String day = String.format("%02d", currentDate.getDay());
			System.out.println(day + "-" + strMonthRutGon[currentDate.getMonth()-1] + "-" + currentDate.getYear());
			break;
		}
		case 4:
		{
			System.out.println(strMonthRutGon[currentDate.getMonth()-1] + " " + currentDate.getDay() +" " + currentDate.getYear());
			break;
		}
		case 5:
		{
			String day = String.format("%02d", currentDate.getDay());
			String month = String.format("%02d", currentDate.getMonth());
			System.out.println(month + "-" + day + "-" + currentDate.getYear());
			break;
	
		}
		}
	}
	
	public void printDate()
	{
		System.out.println(this.getDay() + "/" + this.getMonth() +"/" +this.getYear());
	}
	
	public static void main(String[] args) {
		System.out.println(toInteger("twenty-two"));
		System.out.println(wordToYear("twenty nineteen"));
	}
}
