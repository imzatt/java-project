package day7_1_collection_assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class assignment1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String[] student = {"Maung Maung","Hla Hla","Aye Aye","Chan Aye","Kaung Kaung"};
		ArrayList<String> list = new ArrayList<>(Arrays.asList(student));
		
		// show
		System.out.println(list);
		
		
		System.out.println("----------------------------------");
		// sort & show
		Collections.sort(list);
		System.out.println(list);
		
		// search & position
		System.out.print("Enter search you name : ");
		String user = sc.nextLine();
		int index = Collections.binarySearch(list, user);
		System.out.println(index < 0 ? "Not Found" : "Found" + "\tpostition : " + (index + 1));
		
		
		// add
		System.out.print("Enter add name : ");
		String input = sc.nextLine();
		if(list.contains(input)) {
			System.out.println("This name is already in the list");
		}else {
			list.add(input);
			System.out.println(list);
		}
		
		// show start with "K" or "k"
		for(var i=0;i<list.size();i++) {
			if(list.get(i).startsWith("K") || list.get(i).startsWith("k")) {
				System.out.println("Start with 'K' or 'k' : " + list.get(i));
			}
		}
		
		// remove "G" or "g"
		list.removeIf(name -> name.endsWith("G") | name.endsWith("g"));
		System.out.println(list);
		
		// clear list
		list.clear();
		System.out.println(list);
	}
}
