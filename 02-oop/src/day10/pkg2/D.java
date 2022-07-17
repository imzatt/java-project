package day10.pkg2;

import day10.pkg1.A;

public class D {

	void test() {
		var obj = new A();
		//obj.number = 300; // different pkg
		//obj.name = "cherry"; (non-subclass)
		obj.age = 20;
	}
}
