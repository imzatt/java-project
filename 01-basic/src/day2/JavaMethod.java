package day2;

public class JavaMethod {
	
	int num1 = 10;
	static int num2 = 20;
	
	void instance_method() {
		System.out.println("num1 = " + num1);
		System.out.println("num2 = " + num2);
	}
	
	static void static_method() {
//		JavaMethod oj = new JavaMethod();
//		System.out.println("num1 = " + num1); //cannot access
		System.out.println("num2 = " + num2);
		// instance_method();
	}
	
	public static void main(String [] args) {
		JavaMethod obj = new JavaMethod();
		obj.instance_method();
		
		static_method();
	}
}
