package day10;

public class MethodOverriding {

	public static void main(String[] args) {
		var cat = new Cat();
		cat.show(); // super's method
		cat.sound(); // child's method
		cat.display(); // child's method
		
		System.out.println("------------");
		//poly
		Animal ani = new Animal();
		ani.sound(); // animal's sound
		
		System.out.println("------------");
		//poly
		ani = new Cat();
		ani.sound(); // cat's sound
		
		Cat cat1 = new Cat();
		cat1.display();
		cat1.display("Shwe war");
	}
}

class Animal{
	void show() {
		System.out.println("This is show method");
	}
	
	void sound() { // overriden method
		System.out.println("Some sound");
	}
}

class Cat extends Animal{
	void display() {
		System.out.println("display one");
	}
	
	void display(String name) {
		System.out.println("display two");
	}
	@Override
	void sound() { // overriding method
		System.out.println("Mweo");
	}
}