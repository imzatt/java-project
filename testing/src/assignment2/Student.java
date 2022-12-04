package assignment2;

public class Student {

	private int studentId;
	private String name;
	private int mark;
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMark() {
		return mark;
	}
	public void setMark(int mark) {
		this.mark = mark;
	}
	
	public Student(int id, String name, int mark) {
		this.studentId = id;
		this.name = name;
		this.mark = mark;
	}
	
	public void display() {
		System.out.println(studentId + "\t" + name + "\t" + mark);
	}
	
}
