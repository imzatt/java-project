package testing2_1;

public class Runtime_poly {

	public static void main(String[] args) {
		
		Developer dev = new Developer();
		
		dev.work();
		
		dev = new Frontend();
		dev.work();
		
		dev = new Backend();
		dev.work();
		
	}
}

class Developer {
	void work () {
		System.out.println("Some work");
	}
}

class Frontend extends Developer{
	
	@Override
	void work() {
		System.out.println("Doing frontend telechongies");
	}
}

class Backend extends Developer{
	
	@Override
	void work() {
		System.out.println("Doing backend telechongies");
	}
}