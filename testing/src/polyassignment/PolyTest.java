package polyassignment;

public class PolyTest {

	public static void main(String[] args) {
		
		Shape[] s = new Shape[2];
		
		s[0] = new Cube();
		s[1] = new Circle();
		
		for(var i=0; i<s.length; i++) {
			s[i].Area();
			s[i].Volume();
			System.out.println();
		}
	}
}
