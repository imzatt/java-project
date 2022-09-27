package day3_string_assignment;

import java.util.Scanner;

public class Assign_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Write one sentence : ");
		String user = sc.nextLine();
		
		String[]data = user.split(" ");
		String start = data[0];
		String forwh = data[1];
		boolean u1 = user.endsWith("?");

		
		//verify question
		if(u1 == false) {
			System.out.println("This is simple sentence.This isn't question.");
		}else {
			System.out.println("The first word of the sentence : " + start);
		}
		
		//do/does question
		if(start.equalsIgnoreCase("Do") || start.equalsIgnoreCase("Does")) {
				System.out.println("It is present simple tense.");
		}
		//what question
		if(forwh.equalsIgnoreCase("Do") || forwh.equalsIgnoreCase("Does")) {	
				System.out.println("It is present simple tense.");
		
		}
	}
}
