package testing2_1;

public class Teacher extends Person{

	private String position;
	
	public Teacher(String na, String pos) {
		super(na);
		this.position = pos;	
	}
	
	@Override
	public void showData() {
		super.showData();
		System.out.println("Position : " + position);
		System.out.println("------------");
	}
}
