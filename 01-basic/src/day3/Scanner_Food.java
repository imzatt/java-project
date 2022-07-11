package day3;

import java.util.Scanner;

public class Scanner_Food {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter food name : ");
		String name = sc.nextLine();
		String category;
		switch(name) {
			case "burger","pizza","sandwish" :
				category = "Fast Food";
				break;
			case "yogurt","milktea" :
				category = "Desert";
				break;
			case "mohinga" :
				category = "Burmese Food";
				break;
			case "sushi" :
				category = "Japanese Food";
				break;
			default: 
				category = "unknown";
		}
		System.out.println(name + " is " + category);
		sc.close();
	}
}
