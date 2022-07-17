package day10;

public class Student extends Person{

	private int rno;

	//rno = 1, name = "Aung Aung", phone = "09123456789";
	public Student(int rno, String name, String phone) {
		super(name, phone); // ("Aung Aung",09123456789);
		this.rno = rno; // obj.rno = 1
	}
	
	public int getRno() {
		return rno;
	}
	
	public void setRno(int rno) {
		this.rno = rno;
	}
	
}
