package access1;

public class A {

	// default access 
	int num = 100;
	
	protected String name;
	
	public int age;
	
	void test() {
		System.out.println(num);
		System.out.println(name);
		System.out.println(age);
	}
}
