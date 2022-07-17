package assignment2;

public class Person {

	private String name;
	private String nrcno;
	private String address;
	private String phone;
	

	public Person(String name, String nrcno, String address, String phone) {
		super();
		this.name = name;
		this.nrcno = nrcno;
		this.address = address;
		this.phone = phone;
	}
	
	public void showInfo() {
		System.out.println("Name : " + name);
		System.out.println("NRCno : " + nrcno);
		System.out.println("Address : " + address);
		System.out.println("Phone : " + phone);
	}
	
	public void showIdentificationInfo() {
		String[] division = {"Kachin","Kayar","Kayin","Chin","Sagaing","Tanintharyi","Bago","Magway","Mandalay","Mon","Rakhine","Yangon","Shan","Ayeyawady"};
		
		int index = Integer.parseInt(nrcno.substring(0,nrcno.indexOf("/")));
		String city = nrcno.substring(nrcno.indexOf("/") + 1,nrcno.indexOf("("));
		String num = nrcno.substring(nrcno.indexOf(")") + 1);
		
		System.out.println("Division/state : " + division[index - 1]);
		System.out.println("City : " + city);
		System.out.println("Number : " + num);
		
	}
}

class Teacher extends Person{
	private String position;
	private String department;
	private String salary;
	
	public Teacher(String name, String nrcno, String address, String phone, String pos, String department, String salary) {
		super(name,nrcno,address,phone);
		this.position = pos;
		this.department = department;
		this.salary = salary;
	}
	public String getPos() {
		return position;
	}
	public String getDepartment() {
		return department;
	}
	public String getSalary() {
		return salary;
	}
	public String getPosA(String new_pos) {
		return new_pos;
	}
	public String getDepartmentA(String new_department) {
		return new_department;
	}
	public String getSalaryA(String new_salary) {
		return new_salary;
	}
	
	
	public void showTeacherInfo() {
		showInfo();
		System.out.println();
		showIdentificationInfo();
		
		System.out.println("\nPosition : " + getPos());
		System.out.println("Department : " + getDepartment());
		System.out.println("Salary : " + getSalary());
		
		System.out.println("\nUpdate Position : " + getPosA("Assistant") + "\tSalary : " + getSalaryA("500000"));
		System.out.println("Department : " + getDepartmentA("Physics"));
		
	}
	public void showTeacherInfo2(){
		showInfo();
		System.out.println();
		showIdentificationInfo();
		
		System.out.println("\nPosition : " + getPos());
		System.out.println("Department : " + getDepartment());
		System.out.println("Salary : " + getSalary());
		
		System.out.println("\nUpdate Position : " + getPosA("Lab") + "\tSalary : " + getSalaryA("300000"));
		System.out.println("Department : " + getDepartmentA("Chemistry"));
	}
}
