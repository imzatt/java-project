package day6_3_oop_assignment;

public abstract class Shape {

	private String color;
	
	public Shape(String color) {
		this.color = color;
	}

	public String getCol() {
		return color;
	}
	
	public String setCol() {
		return color;
	}
	
	public abstract double Area();
		
}
