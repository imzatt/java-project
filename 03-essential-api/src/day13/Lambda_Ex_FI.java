package day13;

public class Lambda_Ex_FI {
	
	public static void main(String[] args) {
		MyInterface1 inter1 = new Myclass();
		
		System.out.println("---- using with concrete class ----");
		inter1.display("Aung Aung");
		
		MyInterface1 inter2 = new MyInterface1() {
			
			@Override
			public void display(String name) {
				System.out.println("Name = " + name);
			}
		};
		
		System.out.println("---- using with annoy inter class ----");
		inter2.display("Cherry");
		
		System.out.println("---- using with lambda expression ----");
		MyInterface1 inter3 = (str) -> System.out.println("Name : " + str);
		inter3.display("Jeon");
		
		MyInterface2 add = (n1, n2) -> n1 + n2;
		MyInterface2 sub = (n1, n2) -> n1 - n2;
		MyInterface2 mul = (n1, n2) -> n1 * n2;
		MyInterface2 div = (n1, n2) -> n1 / n2;

		System.out.println();
		System.out.println("100 + 200 = " + add.operate(100, 200));
		System.out.println("100 - 200 = " + sub.operate(100, 200));
		System.out.println("100 * 200 = " + mul.operate(100, 200));
		System.out.println("100 / 200 = " + div.operate(100, 200));
		
		MyInterface3 obj = (name, pass) -> {
			if(name.equals("admin") && pass.equals("123")) 
				return true;
			else
				return false;
		};
		
		System.out.println("Login : " + ((obj.checkLogin("jeon", "123")) ? "success" : "fail")) ;
		System.out.println("Login : " + ((obj.checkLogin("admin", "123")) ? "success" : "fail")) ;
	}
}

@FunctionalInterface
interface MyInterface1{
	void display(String name);
}
interface MyInterface2{
	int operate(int a,int b);
}
interface MyInterface3{
	boolean checkLogin(String uname, String upass);
}

class Myclass implements MyInterface1{
	
	int i;
	@Override
	public void display(String name) {
		System.out.println("Name is : " + name);
	}
	
	class A {
		
	}
	
}