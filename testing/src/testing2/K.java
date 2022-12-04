package testing2;

public class K extends A{

	int b;
	public K() {
		System.out.println("K's default constructor");
	}
	
	public K(int j) {
		super(100);
		System.out.println("K's argument constructor");
	}
}
