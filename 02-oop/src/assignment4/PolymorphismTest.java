package assignment4;

public class PolymorphismTest {

	public static void main(String[] args) {
		
		Shape[] data = new Shape[2];
		
		data[0] = new Cube();
		data[1] = new Circle();
		
		for(var i=0;i<2;i++) {
			data[i].Area();
			data[i].Volume();
		}
	}
}
