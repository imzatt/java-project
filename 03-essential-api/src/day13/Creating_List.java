package day13;

import java.util.ArrayList;
import java.util.List;

public class Creating_List {

	public static void main(String[] args) {
		
		//create immutable empty list
		List<String> list1 = List.of();
		
		//create immutable data list
		List<String> list2 = List.of("Aung Aung","Maung Maung");
		
		//create mutable empty list
		List<String> list3 = new ArrayList<>();
		
		System.out.println("No of element : " + list3.size());
		
	}
	
}
