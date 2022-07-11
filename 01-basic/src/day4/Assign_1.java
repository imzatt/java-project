package day4;

import java.util.Scanner;

public class Assign_1 {

	public static void main(String[] args) {
		
		var pos = 0;
		var zero = 0;
		var neg = 0;
		boolean condition = false;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("How many numbers you want to type : ");
		int limit = sc.nextInt();
		
		do {
			System.out.print("Enter any number : ");
			int num = sc.nextInt();
			
			if(num>0) {
				pos++;
			}else if(num<0) {
				neg++;
			}else {
				zero++;
			}
			limit--;
			
			if(limit == 0) condition = true;
			
		}while(!condition);
		sc.close();
		
		System.out.println("Numbers of zero : " + zero);
		System.out.println("Numbers of positive number : " + pos);
		System.out.println("Numbers of negative number : " + neg);
	}
}
