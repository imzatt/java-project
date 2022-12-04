package testing5;

public interface Lambd_Ex_Fun {

	@FunctionalInterface
	interface Myinterface1 {
		void display(String name);
	}
	
	interface Myinterface2{
		int operate(int n1,int n2);
	}
	
	interface Myinterface3{
		boolean checkLogin(String uname, String upass);
	}
	
	public static void main(String[] args) {
		
		Myinterface1 test1 = (str) -> System.out.println("Name is : " + str);
		test1.display("Jeon");
		
		Myinterface3 test3 = (name,pass) -> {
			if(name.equals("admin") && pass.equals("123")) {
				System.out.println("Login success");
			}else {
				System.out.println("Login failed");
			}
			return false;
		};
		test3.checkLogin("admin", "123");
		test3.checkLogin("jeon", "321");
		
		Myinterface2 t2_add = (a, b) -> a +b ; 
		Myinterface2 t2_sub = (a, b) -> a -b ; 
		Myinterface2 t2_mul = (a, b) -> a *b ; 
		Myinterface2 t2_div = (a, b) -> a /b ; 
		
		System.out.println(t2_add.operate(100, 200));
		System.out.println(t2_sub.operate(100, 200));
		System.out.println(t2_mul.operate(100, 200));
		System.out.println(t2_div.operate(100, 200));
	}
	
}
