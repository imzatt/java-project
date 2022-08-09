package day16;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


public class FlatingMap {

	public static void main(String[] args) {
		
		var books = Arrays.asList("Cola","Milk Tea","Pessi");
		var foods = List.of("Burger","Kyaw Oho","Noodles","Cake");
		var desserts = List.of("Ice cream","Cake");
		
		List<List<String>> items = new ArrayList<>();
		
		items.add(books);
		items.add(foods);
		items.add(desserts);
		
		for(var item : items)
			System.out.println(item);
		
		Set<String> flatList = items.stream()
									.flatMap(data -> data.stream())
									.collect(Collectors.toSet());
		System.out.println(flatList);
	}
}
