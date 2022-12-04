package assignment2;

import java.util.Scanner;

public class DemPerson {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Person p1 = new Person("Mg Mg", "12/pazata(n)123456", "Yangon", "12121212");
//		Person p2 = new Person("Aye Aye", "10/mayana(n)123456", "Mandalay", "13131313");
//		
//		p1.showInfo();
//		p1.showIden();
//		
//		System.out.println();
//		p2.showInfo();
//		p2.showIden();
		
		Teacher t1 = new Teacher("Mg Mg", "12/pazata(n)123456", "Yangon", "12121212", "Tutor", "English", 21000.0);
		
		
		
		System.out.println("Choice Your Option ......");
		System.out.println("1.Promote position and salary");
		System.out.println("2.Transfer new department");
		System.out.println("3.ShowTeacherInfo");
		System.out.println("4.Exit Program");
		System.out.print("Enter number : ");
		int num = sc.nextInt();
		if(num == 1) {
			t1.promote();
		}else if(num == 2) {
			t1.transfer();
		}else if(num == 3) {
			t1.showTeacherInfo();
		}else {
			System.out.println("Exit Program");
		}
	
	}
}
