package day17;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import day16.Employee;

public class Grouping {

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw",9800,"Yangon"),
				new Employee("Aung Aung",6000,"Mandalay"),
				new Employee("Mg Mg",10000,"Mandalay"),
				new Employee("Yuri",6000,"Yangon"),
				new Employee("Jeon",7800,"Monywa")
				);
		
		//count
		Map<String, Long> counting = empList.stream()
											.collect(
											Collectors.groupingBy(
													Employee::getCity, // key
													Collectors.counting()
												)
											);
		System.out.println(counting);
		
		//total salary in each city
		Map<String, Integer> sum = empList.stream()
										.collect(
												Collectors.groupingBy(
														e -> e.getCity(),
														Collectors.summingInt(
																Employee::getSalary)
														)
												);
		System.out.println(sum);
		
		//average salary in each city
		Map<String, Double> avg = empList.stream()
										.collect(Collectors.groupingBy(
												e -> e.getCity(),
												Collectors.averagingDouble(e -> e.getSalary())
													)
												);
		System.out.println(avg);
		System.out.println();
		//-----------------------------------------------
		//group by salary
		Map<Integer, List<Employee>> sameSalary = empList.stream()
														.collect(Collectors.groupingBy(Employee::getSalary));
		sameSalary.forEach((key, value) -> {
			System.out.println(key + "ks.");
			value.forEach(emp -> {
				System.out.println("\t" + emp.getName() + "(" + emp.getCity() + ")");
			});
		});
		
		System.out.println();
		//------------ employee names in each city -----------------
		Map<String, List<String>> eachCity = empList.stream()
													.collect(
														Collectors.groupingBy(
																Employee::getCity, // key
																Collectors.mapping(
																		e -> e.getName(), // map  
																		Collectors.toList() //
																		)
																)
															);
		System.out.println("Employee names who stay in each city");
		eachCity.forEach((k, v) -> {
			System.out.println(k);
			v.forEach(name -> System.out.println("\t" + name));
		});
		
		System.out.println();
		//------------ employee who stay in the same city -------------
		Map<String, List<Employee>> sameCity = empList.stream()
														.collect(
															Collectors.collectingAndThen(
																	Collectors.groupingBy(Employee::getCity), //Map<String, List<Employee>>
																	map -> map.entrySet() // String,Set<Employee>
																		.stream()
																		.filter(e -> e.getValue().size() > 1) // emp size > 1
																		.collect(Collectors.toMap(
																				val -> val.getKey(),
																				val -> val.getValue()
																				)
																		)
																	)
															);
		System.out.println("Employee who stay in same city");
		sameCity.forEach((k,v) -> {
			System.out.println(k);
			v.forEach(name -> System.out.println("\t" + name));
		});
	}
}
