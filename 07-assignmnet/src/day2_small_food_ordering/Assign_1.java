package day2_small_food_ordering;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Assign_1 {

public static void main(String[] args) {
		
		String[] weekdays = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY"};
		
		LocalDate date = LocalDate.now();
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("EEEE");
		String d1 = date.format(f2);
		System.out.println(date.format(f1));
		System.out.println("**********************");
		
			if(d1.equals("Saturday") || d1.equals("Sunday")) {
			System.out.println("Today is my holiday.");
			}else {
			System.out.println("I have no time. I am studying Programming Language");
			}
		
	}
}
