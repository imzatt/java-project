package access2;

import access1.A;

public class F extends A{

	void test() {
		var obj = new F();
		obj.name = "Tom";
		obj.age = 20;
	}
}
