package day15;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_Testing {

	private static void test_Hashset() {
	var set1 = new HashSet<>();
			
			set1.add("Orange");
			set1.add("Apple");
			set1.add(null);
			set1.add("Orange");
			set1.add("Mango");
			set1.add("Strawberry");
			
			System.out.println(set1);
			
			set1.remove("Apple");
			System.out.println("After remove, " + set1);
			
			var set2 = Set.of("Potato","PinApple");
			
			// add collection
			set1.addAll(set2);
			System.out.println("After addall, " + set1);
		}
	
	private static void test_LinkHashSet() {
		var set1 = new LinkedHashSet<String>();
				
				set1.add("Orange");
				set1.add("Apple");
				set1.add(null);
				set1.add("Orange");
				set1.add("Mango");
				set1.add("Strawberry");
				
				System.out.println(set1);
				
				set1.removeIf(str -> str != null && str.toLowerCase().contains("o"));
				System.out.println("After remove 'o', " + set1);
				
		}
	
	private static void test_treeSet() {
		var set1 = new TreeSet<String>();
		
			set1.add("Orange");
			set1.add("Apple");
			//set1.add(null);
			set1.add("Orange");
			set1.add("Mango");
			set1.add("Strawberry");
			
			System.out.println(set1);
		
	}
	
	public static void main(String[] args) {
		//test_Hashset();
		//test_LinkHashSet();
		test_treeSet();
		
	}

	

	
}
