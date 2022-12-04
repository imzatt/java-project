package testing2_1;

public class Demo {

	public static void main(String[] args) {
		
		Person p = new Person("Jean");
		p.showData();
		
		Teacher t = new Teacher("Jean" , "Tutor");
		t.showData();
		
		Person p2 = new Teacher("Cherry", "Professor");
		p2.showData(); // call teacher's method
	}
}
