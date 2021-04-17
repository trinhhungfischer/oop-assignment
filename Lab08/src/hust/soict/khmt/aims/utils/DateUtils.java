package hust.soict.khmt.aims.utils;

public class DateUtils {
	public static void printCompare(MyDate date1, MyDate date2) {
		if (date1.getYear() < date2.getYear())
			System.out.println("The first date is before the second date");
		else if (date1.getYear() > date2.getYear())
			System.out.println("The first date is after the second date");
		else
		{
			if (date1.getMonth() < date2.getMonth())
				System.out.println("The first date is before the second date");
			else if (date1.getMonth() > date2.getMonth())
				System.out.println("The first date is after the second date");
			else
			{
				if (date1.getDay() < date2.getDay())
					System.out.println("The first date is before the second date");
				else if (date1.getDay() > date2.getDay())
					System.out.println("The first date is after the second date");
				else System.out.println("The two date is same day");
			}
		}
	}
	
	private static int compare(MyDate date1, MyDate date2) {
		if (date1.getYear() < date2.getYear())
			return -1;
		else if (date1.getYear() > date2.getYear())
			return 1;
		else
		{
			if (date1.getMonth() < date2.getMonth())
				return -1;
			else if (date1.getMonth() > date2.getMonth())
				return 1;
			else
			{
				if (date1.getDay() < date2.getDay())
					return -1;
				else if (date1.getDay() > date2.getDay())
					return 1;
				else return 0;
			}
		}
	}
	
	private static void swapDate(MyDate date1, MyDate date2)
	{
		MyDate temp = new MyDate(date1.getDay(), date1.getMonth(), date1.getYear());
		
		date1.setDay(date2.getDay());
		date1.setMonth(date2.getMonth());
		date1.setYear(date2.getYear());
		
		date2.setDay(temp.getDay());
		date2.setMonth(temp.getMonth());
		date2.setYear(temp.getYear());
		
	}
	
	public static void sortDate(MyDate[] dateList)
	{
		System.out.println("The sort of date is");
		for (int i = 0; i < dateList.length -1; i++)
		{
			for (int j = i+1; j < dateList.length; j++)
			{
				if (compare(dateList[i], dateList[j]) == 1)
					swapDate(dateList[i], dateList[j]);
			}
		}
		for (int i = 0; i < dateList.length; i++)
		{
			dateList[i].printDate();
		}
	}
}
