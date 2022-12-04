package testing7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Reduction {

	public static void main(String[] args) {
		
		List<Employee> empList = Arrays.asList(
				new Employee("Kyaw Kyaw", 9800, "Yangon"),
				new Employee("Aung Aung", 6000, "Mandalay"),
				new Employee("Mg Mg", 10000, "Mandalay"),
				new Employee("Yuri", 6000, "Yangon"),
				new Employee("Jeon", 7800, "Monywa")
				);
		
		int total = empList.stream()
						.mapToInt(e -> e.getSalary())
						.sum();
		System.out.println("Total : " + total);
		
		double avg = empList.stream()
							.mapToDouble(Employee::getSalary)
							.average()
							.getAsDouble();
		System.out.println("Average : " + avg);
		
		int max = empList.stream()
						.mapToInt(e -> e.getSalary())
						.max()
						.getAsInt();
		System.out.println("Max salary : " + max);
		
		long count = empList.stream()
							.filter(e -> e.getSalary() > 6000)
							.count();
		System.out.println("No of employee who got salary : " + count);
		
		Employee empMax = empList.stream()
								.max(Comparator.comparingInt(e -> e.getSalary()))
								.get();
		System.out.println("Max emp : " + empMax);
							
		Employee empMin = empList.stream()
								.min((e1,e2) -> e1.getSalary() - e2.getSalary())
								.get();
		System.out.println("Min emp : " + empMin);
		
		
		// custom reduction (.reduce())
		int totalSal = empList.stream()
							.mapToInt(Employee::getSalary)
							.reduce(0, (s1, s2) -> s1 + s2);
		System.out.println("Total Salary : " + totalSal);
		
		int minSal = empList.stream()
							.mapToInt(Employee::getSalary)
							.reduce(Integer::min)
							.getAsInt();
		System.out.println("Min Salary : " + minSal);
		
		var maxSal = empList.stream()
							.reduce((e1,e2) -> e1.getSalary() < e2.getSalary() ? e2 : e1)
							.get();
		System.out.println("Max Salary : " + maxSal);
	}
}
