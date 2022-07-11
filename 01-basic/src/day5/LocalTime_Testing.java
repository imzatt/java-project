package day5;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class LocalTime_Testing {

	public static void main(String[] args) {
//		//create
		LocalTime time1= LocalTime.now();
//		LocalTime time2= LocalTime.of(4, 30, 29);
//		LocalTime time3= LocalTime.parse("04:50");
//		
//		System.out.println("Time1 : " + time1);
//		System.out.println("Time2 : " + time2);
//		System.out.println("Time3 : " + time3);
//		
//		// localdatatime
//		LocalDateTime obj1 = LocalDateTime.now();
//		LocalDateTime obj2 = LocalDateTime.of(2022, Month.OCTOBER, 16, 10, 30);
//		
//		System.out.println("obj1 : " + obj1);
//		System.out.println("obj2 : " + obj2);
		
		System.out.println("Previous hour: " + time1.getHour() +":"+ time1.plusMinutes(10).getMinute() +":"+ time1.getSecond());

		
	}
}
