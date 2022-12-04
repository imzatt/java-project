package testing;

public class ConstructorChained {

	public ConstructorChained() {
		this(100);
		System.out.println("This is default constructor");
	}
	
	public ConstructorChained(int i) { // i = 200
		System.out.println("i = " + i);
	}
	
	public ConstructorChained(int i, int j) { // i = 100, j = 200
		this(j); // this = 200
		System.out.println("i = " + i + ",j =" + j);	
	}
	
	public static void main(String[] args) {
		ConstructorChained obj = new ConstructorChained(100,200);
	}
}
