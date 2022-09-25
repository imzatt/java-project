package assignment;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SetAndMap_assignment {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		Map<Integer, Student> student = new HashMap<>();
		
		Student stu1 = new Student(1001, "Maung Maung", "Yangon");
		Student stu2 = new Student(1002, "Aung Aung", "Mandalay");
		Student stu3 = new Student(1003, "Hla Hla", "Yangon");
		Student stu4 = new Student(1004, "Cherry", "Monywa");
		Student stu5 = new Student(1005, "Jeon", "Chin");
		
		student.put(1001, stu1);
		student.put(1002, stu2);
		student.put(1003, stu3);
		student.put(1004, stu4);
		student.put(1005, stu5);
		
		System.out.println("Rno \tName \t\tCity");
		student.forEach((k,obj) -> {
			System.out.println(obj.getRno() +"\t"+ obj.getName() +"\t\t"+ obj.getCity());
			
		});
		
		System.out.print("\nEnter new student Rno : ");
		int rno = sc.nextInt();
		System.out.print("Enter new student Name : ");
		String name = sc.nextLine();
		name+=sc.nextLine();
		System.out.print("Enter new student Address : ");
		String city = sc.next();
		Student stu6 = new Student(rno , name, city);
		student.put(1006, stu6);
		
		System.out.println("\nRno \tName \t\tCity");
		student.forEach((k,obj) -> {
			System.out.println(obj.getRno() +"\t"+ obj.getName() +"\t\t"+ obj.getCity());
			
		});
		
		System.out.print("\nEnter search your student : ");
		int find = sc.nextInt();
		student.forEach((k,obj) -> {
			if(k.equals(find)) {
				System.out.println(obj.getRno() +"\t"+ obj.getName() +"\t\t"+ obj.getCity());
			}
		});
		
		System.out.print("\nEnter delete your student : ");
		int del = sc.nextInt();
		student.remove(del);
		System.out.println("\nRno \tName \t\tCity");
		student.forEach((k,obj) -> {
			System.out.println(obj.getRno() +"\t"+ obj.getName() +"\t\t"+ obj.getCity());
			
		});
		
	}
}

class Student{
	private int rno;
	private String name;
	private String city;
	
	public Student(int rno, String name, String city) {
		super();
		this.setRno(rno);
		this.setName(name);
		this.setCity(city);
	}

	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
}
