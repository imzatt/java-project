package day15;

import java.util.HashMap;
import java.util.Map;

public class Map_with_UserObject {

	public static void main(String[] args) {
		
		Map<Integer, Employee> employees = new HashMap<>();
		
		Employee emp = new Employee(1001, "Aung Aung", "Yangon");
		
		employees.put(1001, emp);
		employees.put(1002, new Employee(1002, "Cherry", "Pyin Oo Lwin"));
		employees.put(1003, new Employee(1003, "Naung Naung", "Yangon"));
		
		System.out.println(employees);
		
		employees.forEach((k,obj) -> {
			System.out.println("ID : " + obj.getId());
			System.out.println("Name : " + obj.getName());
			System.out.println("City : " + obj.getCity());
			System.out.println("--------------------------");
		});
		
		Employee obj = employees.get(1002);
		System.out.println("Obj : " + obj);
		
		System.out.println("---- Employee in Yangon ----");
		employees.forEach((k,val) -> {
			if(val.getCity().toLowerCase().equals("Yangon"))
				System.out.println(val);
		});
	}
}

class Employee{
	
	private int id;
	private String name;
	private String city;
	
	public Employee(int id, String name, String city) {
		super();
		this.setId(id);
		this.setName(name);
		this.setCity(city);
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
}
