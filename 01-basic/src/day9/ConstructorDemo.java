package day9;

class Person{
	
	String name;
	int age;
	boolean single;
	
	//default constructor
	public Person() {
		name = "unknown";
		age = 100;
		single = true;
	}
	
	// parameterized constructor
	public Person (String name, int age, boolean status) {
		this.name = name;
		this.age = age;
		this.single = status;
	}
	
	public void display() {
		System.out.println("Name : " + name);
		System.out.println("Age : " + age);
		System.out.println("Is single : " + ((single) ? "yes" : "no"));
	}
}

public class ConstructorDemo {

	public static void main(String[] args) {
		Person p1 = new Person();
		// p1.name = "unknown";
		// p1.age = 100;
		// p1.single = true;
		p1.display();
		Person p2 = new Person();
		// p2.name = "unknown";
		// p2.age = 100;
		// p2.single = true;
		System.out.println();
		p2.display();
		
		Person p3 = new Person("Aung Aung",20, true);
		// p3.name = "Aung Aung";
		// p3.age = 20;
		// p3.single = true;
		System.out.println();
		p3.display();
		
		var p4 = new Person("Cherry", 16, false);
		System.out.println();
		p4.display();
	}
	
}
