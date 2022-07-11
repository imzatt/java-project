package day7;

import java.util.Scanner;

public class Assign_3 {

	static void checkMark(int mark) {
		if(mark < 0 || mark > 100) {
			throw new ArrayIndexOutOfBoundsException("Invalid mark");
		}
	}
	
	public static void main(String[] args) {
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter Your Marks : ");
			int mark = sc.nextInt();
			checkMark(mark);
			System.out.println("Your Marks : " + mark);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		
	}
}
