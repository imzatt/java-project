package assignment2;

import java.util.Scanner;

public class Person {

	private String name;
	private String nrcno;
	private String address;
	private String phone;
	
	public Person(String na, String nrc, String add, String ph) {
		this.name = na;
		this.nrcno = nrc;
		this.address = add;
		this.phone = ph;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNrcno() {
		return nrcno;
	}

	public void setNrcno(String nrcno) {
		this.nrcno = nrcno;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void showInfo(){
		System.out.println(name + "\t" + nrcno + "\t" + address + "\t" + phone);
	}
	
	public void showIden() {
		
		String [] division = {"Kachin","Kayar","Kayin","Chin","Sagaing","Tanintharyi","Bago","Magway","Mandalay","Mon","Rakhine","Yangon","Shan","Ayeyawady"};
		
		int state = Integer.parseInt(nrcno.substring(0, nrcno.indexOf("/")));
		String city = nrcno.substring(nrcno.indexOf("/") + 1,nrcno.indexOf("("));
		String number = nrcno.substring(nrcno.indexOf(")") + 1);
		
		System.out.println("Division / State : " + division[state - 1]);
		System.out.println("City : " + city);
		System.out.println("Number : " + number);	
	}
	
}

class Teacher extends Person{

	Scanner sc = new Scanner(System.in);
	
	private String position;
	private String department;
	private Double salary;
	
	public Teacher(String na, String nrc, String add, String ph, String pos, String dep, double sal) {
		super(na, nrc, add, ph);
		this.position = pos;
		this.department = dep;
		this.salary = sal;
	}

	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}

	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}

	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	
	public void promote() {
		
		showTeacherInfo();
		
		String up_pos;
		Double up_salary;
		
		System.out.print("\nEnter Promote Position : ");
		up_pos = sc.next();
		up_pos += sc.nextLine();
		System.out.print("Enter Promote Salary : ");
		up_salary = sc.nextDouble();
		
		System.out.println("Update Position : " + up_pos);
		System.out.println("Update Salary : "  + up_salary);
		
		
	}
	
	public void transfer() {
		
		showTeacherInfo();
		
		String dep;
		
		System.out.print("\nEnter Transfer Department : ");
		dep = sc.next();
		dep += sc.nextLine();
		
		System.out.println("Transfer Department : " + dep);
	}
	
	public void showTeacherInfo() {
		System.out.println("\nName : " + getName());
		System.out.println("NRCNo : " + getNrcno());
		System.out.println("Address : " + getAddress());
		System.out.println("Phone : " + getPhone());
		
		System.out.println("\nPosition : " + position);
		System.out.println("Department : " + department);
		System.out.println("Salary : " + salary);
	}
}
