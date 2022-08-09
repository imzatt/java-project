package assignment2;

public class Demo {

	public static void main(String[] args) {
		
		try {
			Teacher u1 = new Teacher("MgMg", "12/mayana(n)123456", "Yangon", "09123456789", "Tutor", "English", 200000);
			Teacher u2 = new Teacher("AgAg", "5/batahta(n)126562", "Sagaing", "09353454653", "Guide", "Math", 150000);
			
//			u1.showInfo();
//			System.out.println();
//			u1.showIdentificationInfo();
			
			u1.showTeacherInfo();
			System.out.println("********************************************************************");
			u2.showTeacherInfo2();
			
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
}
