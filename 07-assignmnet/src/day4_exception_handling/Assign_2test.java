package day4_exception_handling;

import java.util.Scanner;

public class Assign_2test {

	public static void main(String[] args) {
		
		String[] division = {"Kachin","Kayar","Kayin","Chin","Sagaing","Tanintharyi","Bago","Magway","Mandalay","Mon","Rakhine","Yangon","Shan","Ayeyawady",};
		try (Scanner sc = new Scanner(System.in)){
			String nrcno;
			System.out.print("Enter Your nrcno: ");
			nrcno = sc.nextLine();
			
			int index = Integer.parseInt(nrcno.substring(0,nrcno.indexOf("/")));
			String township = nrcno.substring(nrcno.indexOf("/") + 1, nrcno.indexOf("("));
			String number = nrcno.substring(nrcno.lastIndexOf(")")+1);
			

			System.out.println("division/state: " + division[index - 1]);
			System.out.println("Township: " + township);
			System.out.println("number: " + number);
			System.out.println("\nNrcno: " + nrcno);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.print("Invalid division/state number ");
		}
	}
}
