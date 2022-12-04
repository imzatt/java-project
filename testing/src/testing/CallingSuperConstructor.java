package testing;

public class CallingSuperConstructor {

	public static void main(String[] args) {
		Teacher t = new Teacher("Maung Maung", "Tutor");
	}
	
}

class Employe{
	private String name;
	public Employe() {
		
	}
	public Employe(String name) {
		this.name = name;
		System.out.println("This is emp constructor");
	}
}

// different class 
class Teacher extends Employe{
	private String position;
	public Teacher(String na,String pos) {
		super(na); // calling Class Employee(String name)
		this.position = pos;
		System.out.println("This is teacher constructor");
	}
}

 
