package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

public class Stu_demo {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in)) {
			
			int total = 0,count = 0,max = 0;
			Student stu[] = new Student[4];
			
			ArrayList<Student> stuList = new ArrayList<>();

			for(var i=0;i<4;i++) {
				stu[i] = new Student();
				System.out.println("Enter Student " + (i+1) + " information");
				System.out.print("Enter Student ID : ");
				int id = sc.nextInt();
				System.out.print("Enter Student name : ");
				String name = sc.next();
				System.out.print("Enter Student mark : ");
				int mark = sc.nextInt();
				stu[i].initData(id, name, mark);;
			}
			
			System.out.println("ID" + "\tName" + "\tMark");
			for(var i=0;i<4;i++) {
				stu[i].showInfo();
				
			}
			System.out.print("\n");
			
			System.out.print("Search Your Student ID : ");
			int find = sc.nextInt();
			for(var i=0;i<4;i++) {
				if(find == stu[i].getId()) {
					System.out.println("ID : " + stu[i].getId() + "\tName : " + stu[i].getName() + "\tMark : " + stu[i].getMark());
				}
			}
			System.out.print("\n");
			
			for(var i=0;i<4;i++) {
				stuList.add(stu[i]);
				for(var x=0;x<stuList.size();x++) {
					if(stuList.get(i).getMark() > max) {
						max = stuList.get(i).getMark();
						
					}
				}
			}
			System.out.println("Maximum marks : " + max);
			
			for(var i=0;i<4;i++) {
				total += stu[i].getMark();
				count++;
			}
			System.out.println("Total Mark : " + total);
			System.out.println("Average Marks : " + (float)total/count);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println(e.getMessage());
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		
	}
}
