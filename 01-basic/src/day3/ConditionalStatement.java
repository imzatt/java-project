package day3;

import java.util.Scanner;

public class ConditionalStatement {
	
	public static void main(String[] args) {
		// if state
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("Enter language : ");
//		String lang = sc.nextLine();
//		
//		if(lang.equalsIgnoreCase("Java")) { 
//			System.out.println("Best programming language");
//		}
		
		// if else state
//		System.out.println("---- if else ----");
//		System.out.print("Enter email : ");
//		String mail = sc.nextLine();
//		System.out.print("Enter password : ");
//		String pass = sc.nextLine();
//		if(mail.equals("admin@gmail.com") && pass.equals("123")) {
//			System.out.println("Login success");
//		}else {
//			System.out.println("Login failed");
//		}
//		
		
		// if else if statement
		System.out.println("----- if else if -----\n");
		System.out.print("Enter your bmi value : ");
		float bmi = sc.nextFloat();
		if(bmi < 18.5) {
			System.out.println("Underweight");
		}else if(bmi >= 18.5 && bmi <= 24.9) {
			System.out.println("Normal weight");
		}else if(bmi >= 25 && bmi <= 29.9) {
			System.out.println("Overweight");
		}else {
			System.out.println("Obesity");
		}
	}
}
