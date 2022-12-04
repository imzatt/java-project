package assignment4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class DemoSale {

	public static void main(String[] args) {
		
		List<Salespeople> salelist = Arrays.asList(
				new Salespeople("Peel", "London", 0.12),
				new Salespeople("Serres", "San Jose", 0.13),
				new Salespeople("Motika", "London", 0.11),
				new Salespeople("Rifkin", "Barcelona", 0.15),
				new Salespeople("Axelrod", "New York", 0.10)
				);
		
		// 1
		Map<String, List<Salespeople>> s1 = salelist.stream()
				.filter(s -> s.getCity().equals("London") && s.getComm() > 0.10)
				.collect(Collectors.groupingBy(s -> s.getCity(), 
						Collectors.toList()));
		System.out.println("s1 : All salespeople in London with a commission above .10");
		s1.forEach((k,v) -> {
			System.out.println(k + "\t");
			v.forEach(s -> System.out.println("\t" + s.getName() + "\t" + s.getComm()));
		});
		
		//2
		Map<Double, List<Salespeople>> s2 = salelist.stream()
				.filter(s -> s.getComm() != 0.10 && s.getComm() != 0.13 && s.getComm() != 0.15 )
				.collect(Collectors.groupingBy(Salespeople::getComm,
						Collectors.toList()));
		System.out.println("\ns2 : Salesperson details not having commission .10, .13 or .15.");
		s2.forEach((k,v) -> {
			System.out.println(k + "\t");
			v.forEach(s -> System.out.println("\t" + s.getName() + "\t" + s.getCity()));
		});
		
		//3
		List<String> s3 = salelist.stream()
				.map(s -> s.getCity())
				.distinct()
				.toList();
		System.out.println("\ns3 : Different city names");
		s3.forEach(s -> System.out.println(s));
		
		//4
		Map<String, List<Salespeople>> s4 = salelist.stream()
				.limit(3)
				.collect(Collectors.groupingBy(Salespeople::getName,
						Collectors.toList()));
		System.out.println("\ns4 : The top of (salespeople 3)");
		s4.forEach((k,v) -> {
			System.out.println(k);
			v.forEach(s -> System.out.println("\t" + s.getCity() + "\t" + s.getComm()));
		});
		
		//5 kyan 
//		Scanner sc = new Scanner(System.in);
//		System.out.println("\ns5 : the salespeople who live in ‘Rome’");
//		System.out.print("Enter Search City : ");
//		String c = sc.nextLine();
//
//		
//		Map<String, List<Salespeople>> s5 = salelist.stream()
//				.filter(s -> s.getCity().equalsIgnoreCase(c))
//				.collect(Collectors.groupingBy(Salespeople::getCity,
//						Collectors.toList()));
//		
//		Salespeople cities = null;
//		for(var city : salelist) {
//			if(city.getCity().equalsIgnoreCase(c))
//				cities = city;
//				break;
//		}
//
//		if(cities == null) {
//			System.out.println( c +" doest exist");
//		}else {
//			s5.forEach((k,v) -> {
//			System.out.println(k + "\t");
//			v.forEach(s -> System.out.println("\t" + s.getName() + "\t" + s.getComm()));
//			});
//		}
		

		//6
		Map<String, Long> s6 = salelist.stream()
				.filter(s -> s.getCity().equals("London"))
				.collect(Collectors.groupingBy(Salespeople::getCity,
						Collectors.counting()));
		System.out.println("\n6 :The number of salespeople who stay in = " + s6);
		
		//7
		
				
				
				
	}
}
