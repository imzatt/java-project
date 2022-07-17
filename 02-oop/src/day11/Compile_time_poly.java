package day11;

import java.util.Arrays;

public class Compile_time_poly {

	public static void main(String[] args) {
		
		System.out.println("100 + 200 = " + Addition.add(100, 200));
		System.out.println("23.3 + 20.5 = " + Addition.add(23.3f, 20.5f));
		System.out.println("'hello' + 'wold' = " + Addition.add("Hello", "Word"));
		System.out.println("int array's sum = " + Addition.add(new int[]{10,20,30,40}));
	}
}

class Addition{
	static int add(int a, int b) {
		return(a + b);
	}
	static int add(int[] input) {
		return Arrays.stream(input).sum();
	}
	static float add(float a, float b) {
		return(a + b);
	}
	static String add(String a, String b) {
		return(a + b);
	}
	
}
