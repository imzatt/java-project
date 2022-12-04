package testing2;

public class MethodOverriding {

	public static void main(String[] args) {
		
		Animal obj = new Animal();
		Cat obj1 = new Cat();
		
		obj.show();
		obj.sound();
		
		obj1.sound();
	}
}

class Animal{
	
	void show() {
		System.out.println("This is show voice");
	}
	void sound() {
		System.out.println("Some sound");
	}
}

class Cat extends Animal{
	
	@Override
	void sound() {
		System.out.println("Myaung");
	}
}