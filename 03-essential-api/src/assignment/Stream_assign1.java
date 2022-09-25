package assignment;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Stream_assign1 {

	public static void main(String[] args) {
		
		Salespeople[] sales = {
				new Salespeople("Peel", "London", 0.12),
				new Salespeople("Serres", "Sam Jose", 0.13),
				new Salespeople("Motika", "London", 0.11),
				new Salespeople("Rifkin", "Barcelona", 0.15),
				new Salespeople("Axelrod", "New York", 0.10)
		};
		
		Map<String, String> s1 = Arrays.stream(sales)
								.filter(s -> s.getCity().equals("London") && s.getComm() > 0.10)
								.collect(Collectors.toMap(Salespeople::getName, Salespeople::getCity));
		System.out.println("All salespeople in London with a commission above .10 ");
		System.out.println(s1);
		
		Map<Double, Salespeople> s2 = Arrays.stream(sales)
											.filter(s -> s.getComm() != 0.10 && s.getComm() != 0.13 && s.getComm() != 0.15)
											.collect(Collectors.toMap(s -> s.getComm(), s -> s));
		System.out.println("\nSalesperson details not having commission .10, .13 or .15.");
		System.out.println(s2);
		
		List<String> s3 = Arrays.stream(sales)
									.map(s -> s.getCity())
									.distinct()
									.toList();
		System.out.println("\nDifferent city names");
		System.out.println(s3);
		
		Map<String, Salespeople> s4 = Arrays.stream(sales)
											.limit(3)
											.collect(Collectors.toMap(s -> s.getName(), s -> s));
		System.out.println("\nThe top of (salespeople 3) records");
 		System.out.println(s4);
 		
 		Map<String, Salespeople> s5 = Arrays.stream(sales)
 											.filter(s -> s.getCity().equals("Barcelona"))
 											.collect(Collectors.toMap(s -> s.getCity(), s -> s));
 		System.out.println("\nThe salespeople who live in ‘Rome’");
 		System.out.println(s5);
 		
 		Map<String, List<Salespeople>> s6 = Arrays.stream(sales)
 				.collect(
 						Collectors.collectingAndThen(
 								Collectors.groupingBy(Salespeople::getCity),
 								map -> map.entrySet()
 								.stream()
 								.filter(e -> e.getValue().size() > 1)
 								.collect(Collectors.toMap(
 										val -> val.getKey(),
 										val -> val.getValue()))
 								));
 		
 		System.out.println("\nThe number of salespeople who stay in London");
 		s6.forEach((k,v) -> {
 			System.out.println(k);
 			v.forEach(name -> System.out.println("\t" + name));
 		});
 		
 		List<Salespeople> s7 = Arrays.stream(sales)
 									.sorted(Comparator.comparing(Salespeople::getComm))
 									.collect(Collectors.toList());
 		System.out.println("\nList of salespeople in descending order of commission");
 		s7.forEach(System.out::println);
 		
	}
}

class Salespeople{
	
	private String name;
	private String city;
	private double comm;
	
	public Salespeople() {
		
	}
	
	public Salespeople(String name, String city, double comm) {
		super();
		this.name = name;
		this.city = city;
		this.comm = comm;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

	public double getComm() {
		return comm;
	}
	public void setComm(double comm) {
		this.comm = comm;
	}
	
	@Override
	public String toString() {
		return "[name = " + name + ", city = " + city + " ,comm = " + comm + "]";
	}
}