package assignment;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Stream_assign2 {

	public static void main(String[] args) {
		
		List<Employees> emp = Arrays.asList(
				new Employees("Htet Htet", "Yangon", "Electronics", 900000, "1991-10-16"),
				new Employees("Cherry", "Yangon", "Eletronics", 820000, "1994-08-14"),
				new Employees("Kyaw Kyaw", "Yangon", "Electronics", 780000, "1988-09-02"),
				new Employees("Aung Aung", "Mandalay", "IT", 600000 , "1995-01-11"),
				new Employees("Jeon", "Mandalay", "IT", 600000, "1997-09-01"),
				new Employees("Hsu Hsu", "Pyin Oo Lwin", "IT", 920000, "1994-12-10"),
				new Employees("Aye Aye", "Yangon", "HR", 500000, "1992-10-10"),
				new Employees("Gay Gay", "Taung Gyi", "HR", 400000, "1996-05-12"),
				new Employees("Phway Phway", "Monywa", "HR", 300000, "1995-09-03"),
				new Employees("Ko Ko", "Monywa", "IT", 500000, "1992-11-11")
				);
		
		Employees s1 = emp.stream()
							.min(Comparator.comparingInt(e -> e.getSalary()))
							.get();
		System.out.println("The minimum salary of employees");
		System.out.println(s1);
		
		
		
		
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
		return "Employees [Name = " + name + ", City = " + city + ", Department = " + department + ", salary = " + salary + ", birthday = " + birthday + "]"; 
	}
}