package polyassignment;

import java.util.Scanner;

public class Circle implements Shape{

	int radius;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public Double Area() {
		System.out.print("Enter radius : ");
		radius = sc.nextInt();
		double area = 2.14*radius*radius;
		
		System.out.println("Calaulate circle area : " + area);
		return area;
	}

	@Override
	public Double Volume() {
		
		System.out.println("Calaulate circle volume : " + (double)0);
		return (double) 0;
	}

	
}
