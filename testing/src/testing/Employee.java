package testing;

public class Employee {

	static int noOfEmployee = 3; // static field
	static int nextId = 1; // static field
	final int empId; // final field
	String name; // instance field
	int salary; // instance field
	
	static final float BONUS = 2.5f; // const var
	
	public Employee() throws AppException {
		if(nextId > noOfEmployee)
			throw new AppException("Sorry! Limited number had been reached");
		empId = nextId;
		nextId++;
	}
	
	public void initData(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}
	
	public void changeData(String new_name, int new_salary) {
		if(! name.equalsIgnoreCase(new_name))
			this.name = new_name;
		if(salary != new_salary)
			this.salary = new_salary;
	}
	
	public void showData() {
		System.out.println(empId + "\t" + name + "\t" + salary + "ks");
	}
	
	public static void changeNoOfEmployee(int no) {
		noOfEmployee = no; // static
		// this.name = ""; // can't use this 
		// salary = 1000 // can't access instance data
		// Only static Data
	}
	
	public void viewInformation() {
		System.out.println("Total emp : " + noOfEmployee); // can access
		System.out.println("------- Current employee info -------");
		this.showData(); // access instance method
		System.out.println("Next employee id " + nextId);
	}
}
