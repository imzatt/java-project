package day5;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class FormatingDate {

	public static void main(String[] args) {
		
		// predefined
		DateTimeFormatter format1 = DateTimeFormatter.BASIC_ISO_DATE;
		DateTimeFormatter format2 = DateTimeFormatter.ISO_LOCAL_TIME;
		DateTimeFormatter format3 = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
		
		LocalDate date = LocalDate.now();
		LocalTime time = LocalTime.now();
		LocalDateTime datetime = LocalDateTime.now();
		
		System.out.println("------ Using Predefined Constants-----");
		String output = date.format(format1);
		System.out.println(output);
		System.out.println("Time format : " + format2.format(time));
		System.out.println("Datetime format : " + datetime.format(format3));
		
		// custom pattern
		DateTimeFormatter f1 = DateTimeFormatter.ofPattern("MMM dd yyyy");
		DateTimeFormatter f2 = DateTimeFormatter.ofPattern("hh-m-ss");
		DateTimeFormatter f3 = DateTimeFormatter.ofPattern("MMMM dd yyyy 'at' h:m:s a");
		
		System.out.println("-----Using custom pattern-----");
		System.out.println("Current date: " + date.format(f1));
		System.out.println("Current time: " + time.format(f2));
		System.out.println("Current datetime: " + datetime.format(f3));
		
		//localized style
		DateTimeFormatter f4 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		DateTimeFormatter f5 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
		DateTimeFormatter f6 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
		
		System.out.println("------- Using Localized Style ------");
		System.out.println("Current date : " + date.format(f4));
		System.out.println("Current time : " + time.format(f5));
		System.out.println("Current time : " + datetime.format(f6));
	}
}
