package access;

public class PrivateAccess {

	private int num = 100;
	
	void test() {
		System.out.println(num);
	}
}

class B {
	void test() {
		var obj = new PrivateAccess();
//		obj.num = 200; // error private
	}
}
