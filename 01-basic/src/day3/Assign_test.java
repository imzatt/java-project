package day3;

//import java.io.BufferedReader;
import java.util.Scanner;

public class Assign_test {

	public static void main(String[] args)  {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Name : ");
		String name = sc.nextLine();
		System.out.print("Enter Email : ");
		String email = sc.nextLine();
		System.out.print("Enter Phone : ");
		String phone = sc.nextLine();
		System.out.print("Enter Education : ");
		String edu = sc.nextLine();
		System.out.print("Enter Income : ");
		double income = Double.parseDouble(sc.nextLine());
		System.out.print("Enter Age : ");
		int age = sc.nextInt();
		
		//close
		sc.close();
		
		// buffer
//		BufferedReader re = new BufferedReader (new InputStreamReader(System.in));
//		
//		System.out.print("Enter Name : ");
//		String name = re.readLine();
//		System.out.print("Enter Email : ");
//		String email = re.readLine();
//		System.out.print("Enter Phone : ");
//		String phone = re.readLine();
//		System.out.print("Enter Education : ");
//		String edu = re.readLine();
//		System.out.print("Enter Income : ");
//		double income = Double.parseDouble(re.readLine());
//		System.out.print("Enter Age : ");
//		int age = Integer.parseInt(re.readLine());
//		
//		//close
//		re.close();
//		
		System.out.println("------- Data --------\n");
		System.out.println("Name : " + name);
		System.out.println("Email : " + email);
		System.out.println("Phone : " + phone);
		System.out.println("Education : " + edu);
		System.out.println("Income : " + income);
		System.out.println("Age : " + age);
	}
}
