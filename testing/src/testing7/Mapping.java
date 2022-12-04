package testing7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Mapping {

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"),
				new Employee("Mg MG", 10000, "Mandalay"),
				new Employee("Yuri", 6000, "Yangon"),
				new Employee("Jeon", 7800, "Monywa")
				);
		
		List<String> distictCities = empList.stream()
											.map(emp -> emp.getCity())
											.distinct()
											// same
											//.collect(Collectors.toList())
											.toList();
		System.out.println(distictCities);
		
		int[] salaries = empList.stream()
								.filter(emp -> emp.getSalary() > 6000)
								.mapToInt(emp -> emp.getSalary())
								.toArray();
		System.out.println(Arrays.toString(salaries));
		
		List<Integer> salaryList = empList.stream()
										.map(e -> e.getSalary())
										.filter(sal -> sal < 10000)
										.limit(3)
										.toList();
		System.out.println(salaryList);
		
		// find max & min
		int max_sal = empList.stream()
							.mapToInt(e -> e.getSalary())
							.max()
							.getAsInt();
		int min_sal = empList.stream()
							.mapToInt(e -> e.getSalary())
							.min()
							.getAsInt();
		
		System.out.println("Max salary : " + max_sal);
		System.out.println("Min salary : " + min_sal);
	}	
}
