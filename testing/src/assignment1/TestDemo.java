package assignment1;

import java.util.Scanner;

public class TestDemo {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			BankAccountTest user = new BankAccountTest();
			
			System.out.print("Enter Your AccNo : ");
			int no = sc.nextInt();
			System.out.print("Enter Your Name : ");
			String name = sc.nextLine();
			name += sc.nextLine();
			System.out.print("Enter Your PinNo : ");
			int pin = sc.nextInt();
			System.out.print("Enter Your Balance : ");
			int balance = sc.nextInt();
			
			user.initData(no, name, pin, balance);
			
			System.out.println("\nPlease Choice .....");
			System.out.println("1.Show Your Deposit");
			System.out.println("2.Would you withdraw ?");
			System.out.println("3.Would you change Password ?");
			System.out.println("4.Show Your Info");
			System.out.println("5.Exit Program");
			System.out.print("Enter your choice : ");
			int num = sc.nextInt();
			if(num == 1 ) {
				user.deposit();
			}else if(num == 2) {
				user.withdraw();
			}else if(num == 3) {
				user.changePassword();
			}else if(num == 4 ) {
				user.showInfo();
			}else if(num == 5) {
				System.out.println("Termintaing from Program ........");
			}
			
		}
		catch (InsufficientTest e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
