package day2_small_food_ordering;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Assign_2 {
	public static void main(String[] args) {
		
		int x=0,y=0;
		int count=1;
		String food = null;
		String place = null;
		String time = null;
		int min = 0;
		
		Scanner sc = new Scanner(System.in);
		
		String[] townships = {"AA","BB","CC","DD"};
		int[] times = {15,30,10,45};
		String[] menus = {"Pizza","Burger","Milk Tea","Spicy Noodle"};
		
		// for food
		System.out.println("***** Available Menu *****\n");
		for(var r=0;r<4;r++) {
			x++;
			System.out.println( x + "." + menus[r]);
		}

		System.out.print("\nPlease choose item : ");
		String item = sc.nextLine();
		switch(item) {
		case "1" :
			food = "Pizza";
			break;
		case "2" :
			food = "Burger";
			break;
		case "3" :
			food = "Milk Tea";
			break;
		case "4" :
			food = "Spicy Noodle";
			break;
		default:
			food = "Does not exist";
		}

		// verify & township
		if(food.equals("Does not exist")) {
			System.out.println("Does not exist");
		}else {
			System.out.println("\n***** Deliverable Township *****\n");
			for(var r=0;r<4;r++) {
				y++;
				System.out.println(y + "." + townships[r] + " (" + times[r] + " mins)");
			}
			
			System.out.print("\nPlease choose township : ");
			String township = sc.nextLine();
			switch(township) {
			case "1" :
				place = "AA";
				time = "15 mins";
				min = 15;
				break;
			case "2" :
				place = "BB";
				time = "30 mins";
				min = 30;
				break;
			case "3" :
				place = "CC";
				time = "10 mins";
				min = 10;
				break;
			case "4" :
				place = "DD";
				time = "45 mins";
				min = 45;
				break;
			default:
				place = "Does not exist";
			}
			
			// verify && order
			if(place.equals("Does not exist")) {
				System.out.println("Does not exist");
			}else {
				System.out.println("\n***** Order Type *****\n");
				System.out.println("1.Order Now?");
				System.out.println("2.Preorder");
				
				System.out.print("\nPlease choose 1 or 2 : ");
				int order = sc.nextInt();
				
				// last result
				if(order == 1) {
					
					LocalTime t1 = LocalTime.now().plusMinutes(min);
					DateTimeFormatter f1 = DateTimeFormatter.ofPattern("hh:mm:ss a");
					String data1 = t1.format(f1);
					
					System.out.println("\n***** Your Order Information *****\n");
					System.out.println("Item Name : " + food);
					System.out.println("Your Address : " + place);
					System.out.println("Duration : " + time);
					System.out.println("Arrival Time : " + data1 +"\n");
					System.out.println("***** Thank you for your ordering *****");
				}else {
					System.out.print("\nEnter deliver date : ");
					int orderDate = sc.nextInt();
					
					LocalDate t2 = LocalDate.now().plusDays(orderDate);
					DateTimeFormatter f2 = DateTimeFormatter.ofPattern("EEEE, MMM dd yyyy");
					String data2 = t2.format(f2);
					
					System.out.println("***** Your Preorder Information *****\n");
					System.out.println("Item Name : " + food);
					System.out.println("Your Address : " + place);
					System.out.println("Arrival Date : " + data2 + "\n");
					System.out.println("***** Thank you for your ordering *****");
				}
			}
		}
			
	}
}
