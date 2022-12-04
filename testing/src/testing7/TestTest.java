package testing7;

public class TestTest {

	public static void main(String[] args) {
		
		base bb = new der();
		bb.show();
		
	}
}

class base {
	
	void show() {
		System.out.println("Base");
	}
	
}
class der extends base{
	
	void show() {
		System.out.println("Der");
	}
}