package day9;

public class ConstructorChaining {

	public ConstructorChaining() {
		this(100);
		System.out.println("This is default constructor");
	}
	
	public ConstructorChaining(int i) {
		System.out.println("i = " + i);
	}
	
	public ConstructorChaining(int i, int j) {
		this(j); //this(200)
		System.out.println("i = " + i + ",j = " + j);
	}
	
	public static void main(String[] args) {
		ConstructorChaining obj = new ConstructorChaining(100, 200); 
	}
}
