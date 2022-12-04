package testing4;

public interface InterfaceTesting {

	void abstractMethod();
	
	default void defaultMethod() {
		System.out.println("This is default method");
	}
	static void staticMethod() {
		System.out.println("This is static method");
	}
	private void privateMethod() {
		System.out.println("This is private method");
	}
}

class Myclass implements InterfaceTesting{

	@Override
	public void abstractMethod() {
		System.out.println("This is abstract method");
	}
	
//	@Override
//	public void defaultMethod() {
//		System.out.println("Default method can be overriden");
//	}
	
	
}