package day10;

public class PrivateAccessModifier {

	private int number = 100;
	
	void test() {
		System.out.println(number);
	}
}

class B {
	void test() {
		var obj = new PrivateAccessModifier();
		//obj.number = 200; // error
	}
}