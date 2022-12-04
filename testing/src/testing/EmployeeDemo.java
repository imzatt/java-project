package testing;

public class EmployeeDemo {

	public static void main(String[] args) {
		try {
			// create object 
			Employee emp1 = new Employee();
			Employee emp2 = new Employee();
			Employee emp3 = new Employee();
			
			// initilize data
			emp1.initData("Jeon", 100000);
			emp2.initData("Cherry", 500000);
			emp3.initData("Aung Aung", 1400000);
			
			Employee.changeNoOfEmployee(10);
			// show info
			System.out.println("ID \t Name \tSalary");
			emp1.showData();
			emp2.showData();
			emp3.showData();
			
			// creat 4th employee object
			var emp4 = new Employee(); // 
			emp4.initData("Kyaw Kyaw", 3000000);
			emp4.showData();
			
			emp4.viewInformation();
			
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
