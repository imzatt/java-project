package testing;

public class Block_Testing {

	static int min_length;
	String phone;
	
	public Block_Testing(String input) {
		System.out.println("This is arg constructor");
		this.phone = input;
	}
	
	public Block_Testing(){
		System.out.println("This is default constructor");
	}
	
	{ // instance block
		System.out.println("This is instance block");
		phone = "Invalid number";
	}
	
	static {
		System.out.println("This is static block");
		min_length = 11;
	}
	
	public static void main(String[] args) {
		Block_Testing obj1 = new Block_Testing("0912313");
		
		System.out.println("object1 : " + obj1.phone);
		System.out.println("---------------");
		
		Block_Testing obj2 = new Block_Testing();
		System.out.println("object2 : " + obj2.phone);
	}
}
