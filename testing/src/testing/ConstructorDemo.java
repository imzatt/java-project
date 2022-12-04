package testing;

class Person {

	String name;
	int age;
	boolean single;
	
	// default constructor
	public Person() {
		name = "unknown";
		age = 16;
		single = true;
	}
	
	// parameterized constructor
	public Person(String name, int age , boolean status) {
		this.name = name;
		this.age = age;
		this.single = status;
	}
	
	public void display() {
		System.out.println("Name :" + name);
		System.out.println("Age :" + age);
		System.out.println("Is single:" + ((single == true) ? "Yes" : "No"));
	}
}

public class ConstructorDemo{
	public static void main(String[] args) {
		Person p1 = new Person();
		p1.display();
		
		System.out.println();
		Person p2 = new Person();
		p2.display();
		
		System.out.println();
		Person p3 = new Person("Aung Aung", 20 , true);
		p3.display();
		
		System.out.println();
		var p4 = new Person("Cherry", 16 , false);
		p4.display();
	}
}
