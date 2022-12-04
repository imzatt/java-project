package testing5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayList_Testing {

	public static void main(String[] args) {
		
		// create empty list
		ArrayList<Integer> list = new ArrayList<>();
		
		// add an element
		list.add(100);
		list.add(50);
		list.add(30);
		
		System.out.println("No of element : " + list.size());
		System.out.println(list);
		
		// add with specific index
		list.add(1, 300);
		System.out.println("After add, [1] : " + list.get(1));
		System.out.println("After add, [2] : " + list.get(2));
		System.out.println("After add, [1] : " + list);
		
		// display all items with foreach
		list.forEach(num -> System.out.println(num));
		
		// update element
		list.set(0, 250);
		System.out.println("After add, [0] : " + list.get(0));
		System.out.println("After update, [0] : " + list);
		
		System.out.println("List is empty? : " + list.isEmpty());
		
		System.out.println("Size before remove : " + list.size());
		
		// remove element
		list.remove(1);
		System.out.println("After remove, [1] : " + list);
		
		System.out.println("Max value : " + Collections.max(list));
		System.out.println("Min value : " + Collections.min(list));
		
		list.clear();
		System.out.println("After all remove : " + list.isEmpty());
		System.out.println("Size : " + list.size());
		
	}
}
