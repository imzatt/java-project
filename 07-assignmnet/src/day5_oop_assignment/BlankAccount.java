package day5_oop_assignment;

import java.util.Scanner;

public class BlankAccount {
	
	Scanner sc = new Scanner(System.in);

	int accountNo;
	String holderName;
	String pinNo;
	String password;
	int balance;
	
	int withdraw;

	public void initData(int No, String name, String pin, int deposit) {
		this.accountNo = No;
		this.holderName = name;
		this.pinNo = pin;
		this.balance = deposit;
	}
	
	
	public void showInfo() {
		System.out.println("\n" + accountNo + "\t" + holderName + "\t" + pinNo + "\t" + balance );
	}
	
	public void deposit() {
		System.out.println("\nYour deposit : " + balance );
	}
	
	public void withdraw() throws Exception{
		System.out.print("\nEnter Your Withdraw amount : ");
		int withdraw = sc.nextInt();
		if(withdraw < balance) {
			int get_amount = balance - withdraw;
			System.out.println("\nYour deposit : " + get_amount);
			System.out.println("Your withdraw : " + withdraw);
		}else {
			System.out.println("\nYour deposit : " + balance);
			throw new InsufficientAmount("Withdraw amount is not enough");
		}
	}
	

	
	public void changePassword() {
		System.out.print("\nEnter your pinNo : ");
		String pass = sc.nextLine();
	
		if(pinNo.equals(pass)) {
			System.out.print("Enter your new password : ");
			String newpass = sc.nextLine();
			if(! pinNo.equals(newpass))
				this.pinNo = newpass;
			
			System.out.println("\n" + accountNo + "\t" + holderName + "\t" + pinNo + "\t" + balance );
		}else {
			System.out.println("Invalid pin number!");
		}
	}
}

