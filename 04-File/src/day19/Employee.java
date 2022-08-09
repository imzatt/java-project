package day19;

public class Employee {

	private int id;
	private String name;
	private String address;
	
	public Employee(){
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public static Employee getEmployeeFromLine(String line) {
		String[] data = line.split("\t");
		Employee emp = new Employee();
		emp.setId(Integer.parseInt(data[0]));
		emp.setAddress(data[2]);
		emp.setName(data[1]);
		
		return emp;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", city=" + address + "]";
	}
	
}
