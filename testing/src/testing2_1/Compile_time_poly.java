package testing2_1;

import java.util.Arrays;

public class Compile_time_poly {

	public static void main(String[] args) {
		
		System.out.println("100 + 200 = " + Addition.add(100, 200));
		System.out.println("3.5 + 5.6 = " + Addition.add(3.5f, 5.6f));
		System.out.println("Hello + World = " + Addition.add("Hello", "World"));
		System.out.println("int array's sum = " + Addition.add(new int [] {100, 200}));
	}
}

class Addition {
	static int add (int a, int b) {
		return (a + b);
	}
	
	static int add (int [] numbers) {
		return Arrays.stream(numbers).sum();
	}
	
	static float add (float a, float b) {
		return (a + b);
	}
	
	static String add (String a, String b) {
		return (a + b);
	}
}
