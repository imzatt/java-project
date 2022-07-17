package day8;

public class EmployeeDemo {

	public static void main(String[] args) throws Exception {
		
		try {
			//create object
			Employee emp1 = new Employee();
			Employee emp2 = new Employee();
			Employee emp3 = new Employee();
			
			emp1.initData("Jeon", 100000);
			emp2.initData("Cherry", 500000);
			emp3.initData("Aung Aung", 1400000);
			
			System.out.println("ID \t Name \t Salary");
			emp1.showData();
			emp2.showData();
			emp3.showData();
			
			Employee.changeNoofEmployee(10);
			//create 4th employee object
			var emp4 = new Employee(); // exception occurs
			emp4.initData("Kyaw Kyaw", 3000000);
			emp4.showData();
			emp4.viewInformation();
			
		}
		catch(AppException e) {
			System.err.println(e.getMessage());
		}
		
		
	}
}
