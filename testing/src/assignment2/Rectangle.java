package assignment2;

public class Rectangle extends Shape{

	int length;
	int width;
	
	public Rectangle(String color, int length, int width) {
		this.setColor(color);
		this.length = length;
		this.width = width;
	}

	@Override
	public double Area() {
		double area = length * width;
		return area;
	}
	
	public void displayArea() {
		System.out.println("Color : " + getColor());
		System.out.println("Length : " + length);
		System.out.println("Width : " + width);
		System.out.println("Rectangle Area : " + Area());
		
	}
}
