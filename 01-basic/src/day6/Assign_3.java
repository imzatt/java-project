package day6;

import java.util.Scanner;

public class Assign_3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Your NRC StateNo : "); // 12/
		String s1 = sc.nextLine();
		System.out.print("Enter Your NRC Township : "); // PaZaDa
		String s2 = sc.nextLine();
		System.out.print("Enter Your NRC Citizens or not : "); // (N)
		String s3 = sc.nextLine();
		System.out.print("Enter Your NRC No : "); // 123456
		String s4 = sc.nextLine();
		
		// Full NRCNO
		System.out.println("Your NRCNO :" + s1 + s2 + s3 + s4);
		
		// Township
		System.out.println("Township : " + s2);
		
		// NRC no
		System.out.println("Number : " + s4);
	}
}
