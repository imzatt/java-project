package testing5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_Testing_2 {

	public static void main(String[] args) {
		
		String [] data = {"Aung Aung","Jeon","Yuki","Maung Maung"};
		
		ArrayList<String> list = new ArrayList<>(Arrays.asList(data));
		
		list.add("Cherry");
		System.out.println(list);
		
		// sort ascending and descending
		Collections.sort(list);
		System.out.println("After sorting : " + list);
		Collections.reverse(list);
		System.out.println("After reverse sorting : " + list);
		
		// can use binary search after sorting
		int index = Collections.binarySearch(list, "Jeon");
		System.out.println((index < 0 ? "Not found" : "Found"));
		
		index = Collections.binarySearch(list, "Hla Hla");
		System.out.println((index < 0 ? "Not found" : "Found"));
		
		// search with contain
		System.out.println("--- search 'Aung Aung'---");
		if(list.contains("Aung Aung"))
			System.out.println("Found");
		else
			System.out.println("Not Found");
		
		// remove by value
		list.remove("Jeon");
		System.out.println("After remove : " + list);
		
		// remove with lambda expression
		list.removeIf(name -> name.endsWith("ung") && name.length() > 9);
		System.out.println("RemoveIf condition : " + list);
	}
}
