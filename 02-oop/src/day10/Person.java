package day10;

public class Person {

	private String name;
	protected String phone;
	
	//name = "Aung Aung", phone = "09123456789";
	public Person(String name, String phone) {
		super();
		this.name = name; // obj.name = "Aung Aung"
		this.phone = phone; // obj.phone = "09123456789"
	}
	
	void display() {
		System.out.println("Name - " + name);
		System.out.println("Phone - " + phone);
	}
	
	
}
