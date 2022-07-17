package day10;

public class K extends A{

	int b;
	
	public K() {
		System.out.println("K's default constructor");
	}
	
	public K(int j) {
		super(1000);
		System.out.println("K's argument constructor");
	}
}
