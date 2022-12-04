package testing7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"),
				new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuri", 6000, "Yangon"),
				new Employee("Jeon", 7800, "Monywa")
				);  
		
		// counting
		Map<String, Long> counting = empList.stream()
				.collect(Collectors.groupingBy(
						Employee::getCity,
						Collectors.counting()
						));
		System.out.println(counting);
		
		// total salary in each city 
		Map<String, Integer> sum = empList.stream()
					.collect(Collectors.groupingBy(
							Employee::getCity,
							Collectors.summingInt(Employee::getSalary)
							));
		System.out.println(sum);
		
		// average salary in each city
		Map<String, Double> avg = empList.stream()
				.collect(Collectors.groupingBy(
						Employee::getCity,
						Collectors.averagingDouble(Employee::getSalary)
						));
		System.out.println(avg);
		// -----------------------------------------
		
		
		// employee who got the same salary
		Map<Integer, List<Employee>> sameSal = empList.stream()
				.collect(Collectors.groupingBy(Employee::getSalary));
		
		System.out.println("\nEmployee who got the same salary");
		sameSal.forEach((k,s) -> {
			System.out.println(k + "ks.");
			s.forEach(emp -> {
				System.out.println("\t" + emp.getName() + "(" + emp.getCity() + ")");
			});
		});
		
		
		// employee names in each city
		Map<String, List<String>> sameCity = empList.stream()
				.collect(Collectors.groupingBy(Employee::getCity, // key
						Collectors.mapping(Employee::getName,  // map emp obj to String
								Collectors.toList()) // convert list
						));
		System.out.println("\nEmployee names in each city");
		sameCity.forEach((k,v) -> {
			System.out.println(k);
			v.forEach(emp -> {
				System.out.println("\t" + emp);
			});
		});
		
		// employee who stay in same city
		Map<String, List<Employee>> data = empList.stream()
				.collect(Collectors.collectingAndThen(
					Collectors.groupingBy(Employee::getCity),
					map -> map.entrySet().stream() // Map <String>, List<Employee>
							.filter(e -> e.getValue().size() > 1) // filter emp size > 1
							.collect(Collectors.toMap(v -> v.getKey(), v -> v.getValue()))
						));
		System.out.println("\nEmployee who stay in same city");
		data.forEach((k,v) -> {
			System.out.println(k);
			v.forEach(emp -> System.out.println("\t" + emp.getName()));
		});
	}
}
