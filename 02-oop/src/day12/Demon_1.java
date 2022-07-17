package day12;

public class Demon_1 {

	public static void main(String[] args) {
		
		Flying[] data = new Flying[3];
		
		data[0] = new Bird();
		data[1] = new Human();
		data[2] = new Airplane();
		
		for(var i=0;i<data.length;i++) {
			data[i].fly();
		}
				
		//Bird a = new Bird();
	}
}
