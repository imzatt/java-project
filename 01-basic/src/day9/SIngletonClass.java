package day9;

public class SIngletonClass {

	public static void main(String[] args) {
		DatabaseConfig obj = DatabaseConfig.getInstance();
		System.out.println(obj);
		
		DatabaseConfig obj2 = DatabaseConfig.getInstance();
		System.out.println(obj2);
	}
}
