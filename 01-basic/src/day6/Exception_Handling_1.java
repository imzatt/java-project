package day6;

import java.util.Scanner;

public class Exception_Handling_1 {

	public static void main(String[] args) {
		
		try {
			Display(100);
			Scanner sc = new Scanner(System.in);
			System.out.print("Enter number 1 : ");
			int num1 = Integer.parseInt(sc.nextLine());
			System.out.print("Enter number 2 : ");
			int num2 = Integer.parseInt(sc.nextLine());
			
			var result = num1/num2; // 100/0 (ArithmeticException a  = new ArithmeticExmpe());
			System.out.println("Result: " + result);
		}
		catch(ArithmeticException obj1){// excute when exception occurs in try block
			System.err.print("Divisor must not be zero");
		}
		catch(NumberFormatException obj2){
			System.err.print("User input is not a number");
		}
		catch(Exception obj3) {
			System.out.print(obj3.getMessage());
		}
		System.out.println("Outside try catch block");
	}

	private static void Display(int i) {
		// TODO Auto-generated method stub
		
	}
}
