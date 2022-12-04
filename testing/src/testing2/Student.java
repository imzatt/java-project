package testing2;

public class Student extends Person{

	private int rno;
	
	public Student(int rno, String name, int phone) {
		super(name, phone);
		this.rno = rno;
	}
	
	public int getRno() {
		return rno;
	}
	
	public void setRno(int rno) {
		this.rno = rno;
	}
}
