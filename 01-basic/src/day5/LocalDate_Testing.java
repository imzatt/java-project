package day5;

import java.time.LocalDate;

public class LocalDate_Testing {

	public static void main(String[] args) {
		
		//create data object
		LocalDate date1 = LocalDate.now(); 
		LocalDate date2 = LocalDate.of(2022, 10, 16);
		LocalDate date3 = LocalDate.parse("1997-09-01");
		
		System.out.println("Date1 : " + date1);
		System.out.println("Date2 : " + date2);
		System.out.println("Date3 : " + date3);
		
		LocalDate tomorrow = date1.plusDays(1);
		System.out.println("Tomorrow: " + tomorrow);
		System.out.println("Yesterday: " + date1.minusDays(1));
		
		System.out.println("Current year: " + date1.getYear());
		System.out.println("Current month: " + date1.getMonthValue());
		System.out.println("Current Month: " + date1.getMonth());
		
		System.out.println("Current day of week: " + date1.getDayOfWeek());
		System.out.println("Current day of month: " + date1.getDayOfMonth());
		
		System.out.println(date1 + " is leap year " + date1.isLeapYear());
		System.out.println(date2 + " is leap year " + date2.isLeapYear());
		System.out.println(date1 + " is same to " + date2 + " : " + date1.equals(date2));
	}
}


