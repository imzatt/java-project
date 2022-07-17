package day9;

import java.util.Scanner;

public class Assign1_Demo {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		try {
			BlankAccount user1 = new BlankAccount();
			
			
			System.out.print("Enter your accountNo : ");
			int No = sc.nextInt();
			System.out.print("Enter your name : ");
			String name = sc.next();
			System.out.print("Enter your pinNo : ");
			String pin = sc.next();
			System.out.print("Enter your balance : ");
			int deposit = sc.nextInt();
			
			user1.initData(No, name,  pin,  deposit);
			System.out.println("\nNo \t Name \t Pass \t Balance");
			
			System.out.println("\nPlease Chioce ....");
			System.out.println("1.Show your deposit");
			System.out.println("2.Would you withdraw ?");
			System.out.println("3.Would you change Password ?");
			System.out.println("4.Show Banklist");
			System.out.println("5.Exit Program");
			System.out.print("Enter you choice : ");
			int ans = sc.nextInt();
			if(ans == 1) {
				user1.deposit();
			}else if(ans == 2) {
				user1.withdraw();
			}else if(ans == 3) {
				user1.changePassword();
			}else if(ans == 4) {
				user1.showInfo();
			}else {
				System.out.println("Terminating from Program .....!");
			}
		}
		catch(InsufficientAmount e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
