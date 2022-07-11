package day3;

import java.util.Scanner;

public class Switch_Expression {
	
	public static void main(String[] args) {
		
		var sc = new Scanner(System.in);
		
		System.out.print("Enter food name : ");
		var name = sc.nextLine();
		
//		var category = 
//				switch (name) {
//					case "burger","pizza","sandwish" -> "Fast Food";
//					case "yogurt","milktea" -> "Desert";
//					case "mohinga" -> "Burmese Food";
//					case "sushi" -> "Japanese Food";
//					default -> "Unknown";
//				};
		
		var category = 
				switch (name) {
					case "burger","pizza","sandwish" : {
						if(name.equals("pizza")) {	
							System.out.println(name + " is an Italian food.");
							yield "Fast Food";
						}
					}
					case "yogurt","milktea" : {yield "Desert";}
					case "mohinga" : yield "Burmese Food";
					case "sushi" : yield "Japanese Food";
					default : yield "Unknown";
				};
		System.out.println(name + " is " + category);	
	}
}
