package testing2;

public class Person {

	private String name;
	protected int phone;
	
	public Person(String name, int phone) {
		super();
		this.name = name;
		this.phone = phone;
	}
	
	void display() {
		System.out.println("Name : " + name);
		System.out.println("Phone : " + phone);
	}
}
