package assignment2;

import java.util.Scanner;

public class Demo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Color : ");
		String col = sc.next();
		col += sc.nextLine();
		System.out.print("Length : ");
		int len = sc.nextInt();
		System.out.print("Width : ");
		int wid = sc.nextInt();
		
		Rectangle r1 = new Rectangle(col, len, wid);
		System.out.println();
		r1.displayArea();
		
	}
}
