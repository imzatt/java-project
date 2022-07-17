package assignment4;

import java.util.Scanner;

public class  Cube implements Shape{

	int x;
	
	Scanner sc = new Scanner(System.in);
	
	@Override
	public double Area() {
		System.out.print("Enter Edge for Area : ");
		int x = sc.nextInt();
		
		int area = x*x*x;
		System.out.println("The calculated area of the cube : " + area);
		return area;
	}

	@Override
	public double Volume() {
		System.out.print("\nEnter Edge for Volume : ");
		int x = sc.nextInt();
		
		int volume = x*x*x;
		System.out.println("The calculated volume of the cube : " + volume);
		return volume;
	}

}
