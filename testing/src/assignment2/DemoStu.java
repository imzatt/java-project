package assignment2;

import java.util.ArrayList;
import java.util.Scanner;

public class DemoStu {

	public static void main(String[] args) {
		
		
		try(Scanner sc = new Scanner(System.in);) {
			
			int max = 0, count = 0, total = 0;
			Student [] stu = new Student[4];
			ArrayList<Student> stulist = new ArrayList<>();
			
			stu[0] = new Student(101, "Mg Mg", 70);
			stu[1] = new Student(202, "Ag Ag", 60);
			stu[2] = new Student(303, "Aye Aye", 75);
			stu[3] = new Student(404, "Hla Hla", 90);
			
//			stu[4] = new Student(404, "Hla Hla", 90);
			// showInfo
			System.out.println("ID \tName \tMark");
			for(var i=0; i<4; i++) {
				stu[i].display();
			}
			
			// Search Data
			System.out.print("\nEnter Your Search student ID : ");
			int id = sc.nextInt();
			int index = -1;
			for(var i=0; i<4; i++) {
				if(id == stu[i].getStudentId()) {
					index = i;
				}
			}
			
			if(index == -1) {
				System.out.println("Student id - " + id + " is not found");
			}else {
				System.out.println("ID \tName \tMark");
				System.out.println(stu[index].getStudentId() + "\t" + stu[index].getName() + "\t" + stu[index].getMark());
			}
			
			// Max marks
			for(var i=0; i<4; i++) {
				stulist.add(stu[i]);
				for(var j=0; j<stulist.size(); j++) {
					if(stulist.get(i).getMark() > max) {
						max = stulist.get(i).getMark();
					}
				}
			}
			System.out.println("\nMaximum Mark : " + max);
			
			// Total and Average
			for(var i=0; i<4; i++) {
				total += stu[i].getMark();
				count++;
			}
			System.out.println("Total Mark : " + total);
			System.out.println("Average Mark : " + (float)total/count);
			
		}catch(IndexOutOfBoundsException e) { 
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
