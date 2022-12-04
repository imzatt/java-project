package testing4;

public class Demofly {

	public static void main(String[] args) {
		
		Flying []data = new Flying[3];
		data[0] = new Human();
		data[1] = new Birds();
		data[2] = new Airplane();
			
		for(var i=0; i<3; i++) {
			data[i].fly();
		}
	}
}
