package access2;

import access1.A;

public class D {

	
	void test() {
		var obj = new A();
//		obj.num = 300; // different package
//		obj.name = "cherry"; // non-subclass
		obj.age = 20;
	}
}
