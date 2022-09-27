package day3_string_assignment;

import java.util.Scanner;

public class Assign_3 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Please write the township in 6 characters\n e.g 12/mayana(N)123456 or 12/mayana(naing)123456");
		System.out.print("\nEnter Your NRCNO : "); // 12/
		String user = sc.nextLine();
		
		int u1 = user.length();
		
		// Full NRCNO
		System.out.println("Your NRCNO : " + user);
//		System.out.println("Your NRCNO : " + u1);
		
		// Township
		if(u1 == 22) {
			System.out.println("Township : " + user.substring(3, 9));
			System.out.println("Number : " + user.substring(16, 22));
		}else if(u1 == 21) {
			System.out.println("Township : " + user.substring(2, 8));
			System.out.println("Number : " + user.substring(15, 21));
		}else if(u1 == 18) {
			System.out.println("Township : " + user.substring(3, 9));
			System.out.println("Number : " + user.substring(12, 18));
		}else if(u1 == 17) {
			System.out.println("Township : " + user.substring(2, 8));
			System.out.println("Number : " + user.substring(11, 17));
		}
		

	}
}
