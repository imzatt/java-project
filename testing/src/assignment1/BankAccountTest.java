package assignment1;

import java.util.Scanner;

public class BankAccountTest {

	Scanner sc = new Scanner(System.in);
	
	int accountNo;
	String holderName;
	int pinNo;
	int balance;
	
	public void initData(int no, String name, int pin, int balance) {
		this.accountNo = no;
		this.holderName = name;
		this.pinNo = pin;
		this.balance = balance;
	}
	
	
	public void deposit() {
		System.out.print("\nYour deposit : " + balance);
	}
	
	public void withdraw() throws Exception{
		System.out.print("\nEnter Your Withdraw Amount : ");
		int amount = sc.nextInt();
		if(amount <= balance) {
			int get = balance - amount;
			System.out.print("Your Deposit : " + get);
			System.out.print("\nYour Withdraw : " + amount);
		}else {
			System.out.println("Withdraw amount isn't enough");
		}
	}
	
	public void changePassword() {
		System.out.print("\nEnter Your PinNo : ");
		int old_pass = sc.nextInt();
		if(old_pass == pinNo) {
			System.out.print("Enter Change New PinNo : ");
			int new_pass = sc.nextInt();
			if( pinNo != new_pass) {
				this.pinNo = new_pass;
				
				System.out.println("\nNo \t Name \t Pin \t Balance");
				System.out.println(accountNo + "\t" + holderName + "\t" + pinNo  + "\t" + balance);
			}
		}else {
			System.out.println("Your PinNo is wrong!");
		}
	}
	
	public void showInfo() {
		System.out.println("No \t Name \t Pin \t Balance");
		System.out.println(accountNo + "\t" + holderName + "\t" + pinNo  + "\t" + balance);
	}
	
}
