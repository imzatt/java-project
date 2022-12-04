package assignment3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ArrayList_assign {

	public static void main(String[] args) {
		
		
		
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> list = new ArrayList<>();
		
		list.add("Aung Aung");
		list.add("Maung Maung");
		list.add("Cherry");
		list.add("Hla Hla");
		list.add("Kyaw Kyaw");
		
		//a
		System.out.println("All student name : " + list);
		// list.forEach(name -> System.out.println(name));
		//b
		Collections.sort(list);
		//c
		System.out.println("After sorting : " + list);
		//d
		int index = Collections.binarySearch(list, "Hla Hla");
		System.out.println("Your search student position : " + index);

		//e
		System.out.print("\nEnter your student name : ");
		String new_stu = sc.next();
		new_stu += sc.nextLine();
		if(list.contains(new_stu))
			System.out.println("This student already exist");
		else {
			list.add(new_stu);
			System.out.println("After add : " + list);
		}
		
		//f
		list.removeIf(name -> name.startsWith("K") || name.startsWith("k"));
		System.out.println("After remove startsWith 'K' or 'k' : " + list);
		
		//g
		list.removeIf(name -> name.endsWith("G") || name.endsWith("g"));
		System.out.println("After remove endsWith 'G' or 'g' : " +  list);
		
		//h
		list.clear();
		System.out.println("No of element : " + list.size());
	}
}
