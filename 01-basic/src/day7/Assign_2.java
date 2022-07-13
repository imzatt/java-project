package day7;

import java.util.Scanner;

public class Assign_2 {
	public static void main(String[] args) {
		
		String[]division = {"Kachin","Kayar","Kayin","Chin","Sagaing","Tanintharyi","Bago","Magway","Mandalay","Mon","Rakhine","Yangon","Shan","Ayeyawady",};
		String state = null;
		
		try{
			Scanner sc = new Scanner(System.in);
			
			System.out.print("Enter Your NRCNO : "); // 12/
			String user = sc.nextLine();
			int u1 = user.length();
				
			if(u1 == 17) {
				String s1 = user.substring(0,2);
//				System.out.println(s1);
				
				switch(s1) {
				case "1/":
					state = "Kachin";
					break;
				case "2/":
					state = "Kayar";
					break;
				case "3/":
					state = "Kayin";
					break;
				case "4/":
					state = "Chin";
					break;
				case "5/":
					state = "Sagaing";
					break;
				case "6/":
					state = "Tanintharyi";
					break;
				case "7/":
					state = "Bago";
					break;
				case "8/":
					state = "Magway";
					break;
				case "9/":
					state = "Mandalay";
					break;
				default:
					state = "Unknown";
				}
				if(state.equals("Unknown")) {
					System.out.println("The input NRC is Invalid");
				}else {
					System.out.println("Division/State : " + state);
					System.out.println("Township : " + user.substring(2, 8));
					System.out.println("Number : " + user.substring(11, 17));
				}
			}else if(u1 == 18){
				
				String s2 = user.substring(0,3);
//				System.out.println(s2);
				
				switch(s2) {
				case "10/":
					state = "Mon";
					break;
				case "11/":
					state = "Rakhine";
					break;
				case "12/":
					state = "Yangon";
					break;
				case "13/":
					state = "Shan";
					break;
				case "14/":
					state = "Ayeyawady";
					break;
				default:
					state = "Unknown";
				}
				if(state.equals("Unknown")) {
					System.out.println("The input NRC is Invalid");
				}else {
					System.out.println("Division/State : " + state);
					System.out.println("Township : " + user.substring(3, 9));
					System.out.println("Number : " + user.substring(12, 18));
				}
			}
				
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("The input NRC is Invalid");
		}
			
	}
}
