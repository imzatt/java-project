package day6_3_oop_assignment;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			
			System.out.print("Enter Color : ");
			String color = sc.nextLine();
			System.out.print("Enter Length : ");
			int length = sc.nextInt();
			System.out.print("Enter Width : ");
			int width = sc.nextInt();
			
			Rectangle rec = new Rectangle(color, length, width);
			System.out.println();
			rec.displayArea();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
