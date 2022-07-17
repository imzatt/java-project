package day10.pkg3;

public class Demo {

	public static void main(String[] args) {
		Person p = new Person("James");
		p.showData();
		
		Teacher t = new Teacher("Jeon","Tutor");
		t.showData();
		
		Person p2 = new Teacher("Cherry","Professor");
		p2.showData(); // call teacher's method
	}
}
