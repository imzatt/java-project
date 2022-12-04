package assignment2;

public abstract class Shape {

	private String color;

	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	public abstract double Area();
	
}
