package polyassignment;

import java.util.Scanner;

public class Cube implements Shape{

	int x;
	Scanner sc = new Scanner(System.in);
	
	@Override
	public Double Area() {
		System.out.print("Enter the edge of cube for area : ");
		x = sc.nextInt();
		double area = 6*x*x ;
		
		System.out.println("Calaulate cube area : " + area);
		return area;
	}

	@Override
	public Double Volume() {
		System.out.print("Enter the edge of cube for volume : ");
		x = sc.nextInt();
		double vol = x*x*x;
		
		System.out.println("Calaulate cube volume : " + vol);
		return vol;
	}

}
