package assignment1;

import java.util.Scanner;

public class Student {
	
	int studentId;
	String name;
	int mark;
	
	Student stu[];
	
	Scanner sc = new Scanner(System.in);
	
	public void initData(int id, String name, int mark) {
		this.studentId = id;
		this.name = name;
		this.mark = mark;
		return;
	}
	
	public void showInfo() {
		System.out.println(studentId + "\t" +  name + "\t" + mark);
	}
	
	public int getId() {
		return studentId ;
	}
	public String getName() {
		return name;
	}
	public int getMark() {
		return mark;
	}
	
	
}
