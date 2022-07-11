package day6;

public class Exception_Demo {

	public static void main(String[] args) {
		display(100);	
	}

	private static void display(int i) {
		System.out.println("number is " + i);
		display(300);
	}
}
