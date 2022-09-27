package day6_4_oop_assignment;

import java.util.Scanner;

public class Circle implements Shape{
	
	int r; // radius
	Scanner sc = new Scanner(System.in);
	
	@Override
	public double Area() {
		System.out.print("\nEnter radius : ");
		int r = sc.nextInt();
		
		double area = Math.PI * r * r;
		System.out.println("The calculated area of the circle : " + area);
		return area;
	}

	@Override
	public double Volume() {
		return 0;
	}

}
