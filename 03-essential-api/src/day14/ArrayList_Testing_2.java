package day14;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_Testing_2 {

	public static void main(String[] args) {
		String[] data = {"Aung Aung","Jeon","Yuki","Maung Maung"};
		ArrayList<String> list = new ArrayList<>(Arrays.asList(data));
		
		list.add("Jeon");
		System.out.println(list);
		
		//sort asc
		Collections.sort(list);
		System.out.println("After sorting, list : " + list);
		
		//sort desc
		Collections.reverse(list);
		System.out.println("After sorting, list : " + list);
		
		int index = Collections.binarySearch(list, "Jeon");
		System.out.println(index < 0 ? "Not found" : "Found");
		
		index = Collections.binarySearch(list, "Hla Hla");
		System.out.println(index < 0 ? "Not found" : "Found");
		
		//search with contain
		System.out.println("---- serach 'Aung Aung' ----");
		if(list.contains("Aung Aung"))
			System.out.println("Found");
		else
			System.out.println("Not found");
		
		//remove by value
		list.remove("Jeon");
		System.out.println("After remove : " + list);
		
		//remove with lambda expression
		list.removeIf(name -> name.endsWith("ung") & name.length() > 9);
		System.out.println("After remove : " + list);
		
	}
}
