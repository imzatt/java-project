package day7;

public class Throwing {

	static void checkMark(int mark) {
		if(mark < 0 || mark > 100) {
//			ArithmeticException obj = new ArithmeticException("Invalid mark");
//			throw obj;
			throw new ArithmeticException("Invalid mark");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			checkMark(-1);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		catch(ArithmeticException e) {
			System.out.println(e.getMessage());
		}
	}
}
