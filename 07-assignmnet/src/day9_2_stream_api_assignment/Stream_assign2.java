package day9_2_stream_api_assignment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Stream_assign2 {

	public static void main(String[] args) {
		
		LocalDate d1 = LocalDate.of(1995, 02, 12);
		
		List<Employees> emp = Arrays.asList(
				new Employees("Htet Htet", "Yangon", "Electronics", 900000, LocalDate.of(1991, 10, 16)),
				new Employees("Cherry", "Yangon", "Electronics", 820000, LocalDate.of(1994, 8, 14)),
				new Employees("Kyaw Kyaw", "Yangon", "Electronics", 780000, LocalDate.of(1988, 9, 2)),
				new Employees("Aung Aung", "Mandalay", "IT", 600000 , LocalDate.of(1995, 1, 11)),
				new Employees("Jeon", "Mandalay", "IT", 600000, LocalDate.of(1997, 9, 1)),
				new Employees("Hsu Hsu", "Pyin Oo Lwin", "IT", 920000, LocalDate.of(1994, 12, 10)),
				new Employees("Aye Aye", "Yangon", "HR", 500000, LocalDate.of(1992, 10, 10)),
				new Employees("Gay Gay", "Taung Gyi", "HR", 400000, LocalDate.of(1996, 5, 12)),
				new Employees("Phway Phway", "Monywa", "HR", 300000, LocalDate.of(1995, 9, 3)),
				new Employees("Ko Ko", "Monywa", "IT", 500000, LocalDate.of(1992, 11, 11))
				);
		
		Employees s1 = emp.stream()
							.min(Comparator.comparingInt(e -> e.getSalary()))
							.get();
		System.out.println("The minimum salary of employees");
		System.out.println(s1);
		
		//--------------------------------------------------
		
		Comparator<Employees> empage = Comparator.comparing(Employees::getBirthday);
		Employees s2 = emp.stream()
						.max(empage)
						.get();
		System.out.println("The youngest employee");
		System.out.println(s2);
		
		//--------------------------------------------------
		
		long s3 = emp.stream()
					.filter(e -> e.getBirthday().compareTo(d1) <= 0)
					.count();
		System.out.println("Count all employee whose birthday is greater than or equal '1995-02-12' : " + s3 );
		
		//--------------------------------------------------
		
		int s4 = emp.stream()
						.mapToInt(e -> e.getSalary())
						.sum();
		System.out.println("\nTotal salary of all employees : " + s4);
	
		//--------------------------------------------------
		
		Map<Integer, Employees> s5 = emp.stream()
						.sorted(Comparator.comparing(Employees::getSalary).reversed())
						.limit(3)
						.collect(Collectors.toMap(e -> e.getSalary(), e -> e));
		System.out.println("\nFetch the three max salaries");
		System.out.println(s5);
		
		//--------------------------------------------------
		
		double s6 = emp.stream()
						.filter(e -> e.getDepartment().equals("HR"))
						.mapToDouble(Employees::getSalary).average().getAsDouble();
		System.out.println("\nThe average salary of department ‘HR’ : " + s6);
		
		//--------------------------------------------------
		
		Employees s7 = emp.stream()
				.min(Comparator.comparingInt(e -> e.getSalary()))
				.get();
		System.out.println("\nEmployee which gets smallest salary");
		System.out.println(s7);
		
		//------------------------------------------------------
		
		Map<String, Employees> s8 = emp.stream()
										.collect(
											Collectors.groupingBy(
													e -> e.getCity(),
													Collectors.collectingAndThen(
															Collectors.maxBy(Comparator.comparingInt(e -> e.getSalary())), 
															Optional::get)
													)	
												);
				
				
		System.out.println("The highest salary of employee in each city");
		System.out.println(s8);
		
		//--------------------------------------------------
		
		Map<Integer, List<Employees>> s9 = emp.stream()
											.collect(Collectors.groupingBy(Employees::getSalary));
		
		System.out.println("\nList of employee who got the same salary");
		s9.forEach((k,v) -> {
			System.out.println(k + "ks.");
			v.forEach(name -> {
				System.out.println("\t" + name.getName());
			});
		});
		
		//--------------------------------------------------
		
		Map<String, List<String>> s10 = emp.stream()
										.collect(
											Collectors.groupingBy(
												Employees::getDepartment,
												Collectors.mapping(
														e -> e.getName(), 
														Collectors.toList()
														)
													)
												);
		System.out.println("\nList of employee names in each department");
		s10.forEach((k,v) -> {
			System.out.println(k);
			v.forEach(name -> System.out.println("\t" + name));
			});
		}
	
	
}

class Employees{
	
	private String name;
	private String city;
	private String department;
	private int salary;
	private LocalDate birthday;
	
	public Employees() {
		
	}
	
	
	public void forEach(Object object) {
		// TODO Auto-generated method stub
		
	}


	public Employees(String name, String city, String department, int salary, LocalDate birthday) {
		super();
		this.name = name;
		this.city = city;
		this.department = department;
		this.salary = salary;
		this.birthday = birthday;
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

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}

	public LocalDate getBirthday() {
		return birthday;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Employees [Name = " + name + ", City = " + city + ", Department = " + department + ", salary = " + salary + ", birthday = " + birthday + "]" + "\n"; 
	}
}