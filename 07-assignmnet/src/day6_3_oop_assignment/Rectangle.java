package day6_3_oop_assignment;

public class Rectangle extends Shape{

	private int length;
	private int width;
	double area;
	
	public Rectangle(String color, int length, int width) {
		super(color);
		this.length = length;
		this.width = width;
	}
	
	@Override
	public double Area() {
		 return area = length * width;
	}
	
	public void displayArea() {
		System.out.println("Color : " + setCol());
		System.out.println("Length : " + length);
		System.out.println("Width : " + width);
		System.out.println("The area of rectangle : " + Area());
	}

}
