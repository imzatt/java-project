package access1;

public class B {

	void test() {
		A obj = new A();
		obj.num = 200; // within same pkg
		
		obj.name = "Cherry";
		obj.age = 20;
	}
}

class C extends A {
	// int num;
	// protected String name;
	// public int age;
	void test() {
		System.out.println(num);
		System.out.println(name);
		System.out.println(age);
	}
}
