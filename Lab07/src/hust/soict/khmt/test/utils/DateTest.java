package hust.soict.khmt.test.utils;

import hust.soict.khmt.aims.utils.DateUtils;
import hust.soict.khmt.aims.utils.MyDate;

public class DateTest {
	public static void main(String[] args) {
		
		// This is example of three constructor functions with overloading function technique
		MyDate currentDate = new MyDate();
		MyDate inputDate = new MyDate(13, 3, 2020);
		MyDate breakDate = new MyDate("twenty-third", "Feb", "twenty oh one");
		MyDate dogDate = new MyDate("Feb 21 2019");
		
		// Test overload constructor with three string input
		System.out.println(breakDate.getMonth());
		System.out.println(breakDate.getDay());
		System.out.println(breakDate.getYear());
		
		currentDate.print();
		currentDate.print(2);
		currentDate.print(4);
		
		DateUtils.printCompare(inputDate, breakDate);
		DateUtils.printCompare(inputDate, currentDate);
		DateUtils.printCompare(currentDate, currentDate);
		
		// Thu tu truoc do cua cac ngay la
		// CurrentDate is currentdate
		// inputDate is 13/3/2020
		// breakDate is 23/1/2019
		MyDate[] dateList = {currentDate, inputDate, breakDate};
		DateUtils.sortDate(dateList);
	}
}
