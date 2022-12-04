package testing6;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class Set_Testing {

	static void test_HashSet() {
		
		var set1 = new HashSet<String>();
		
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Orange");
		set1.add("Mango");
		set1.add("Strawberry");
		
		System.out.println(set1);
		
		set1.remove("Apple");
		System.out.println("After remove : " + set1);
		
		var set2 = Set.of("Potato","Pinapple");
		
		// add collection
		
		set1.addAll(set2);
		System.out.println("After AddAll : " + set1); 
	}
	
	public static void main(String[] args) {
		
		//test_HashSet();
		//test_LinkedHashSet();
		test_TreeSet();
	}

	private static void test_TreeSet() {
		
		var set1 = new TreeSet<String>();
		
		set1.add("Orange");
		set1.add("Apple");
		//set1.add(null);
		set1.add("Orange");
		set1.add("Mango");
		set1.add("Strawberry");
		
		System.out.println(set1);
		
	}

	private static void test_LinkedHashSet() {
		
		var set1 = new LinkedHashSet<String>();
		
		// add an element
		set1.add("Orange");
		set1.add("Apple");
		set1.add(null);
		set1.add("Orange");
		set1.add("Mango");
		set1.add("Strawberry");
		
		System.out.println(set1);
		
		set1.removeIf(b -> b != null && b.toLowerCase().contains("o"));
		System.out.println("After remove : " + set1);
	}
}
