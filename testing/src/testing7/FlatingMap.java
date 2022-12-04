package testing7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class FlatingMap {

	public static void main(String[] args) {
		
		var book = Arrays.asList("Cola", "Milk Tea", "Pessi");
		var food = Arrays.asList("Burger", "Kyay O", "Noodles", "Cake");
		var deserts = List.of("Ice cream", "Cake");
		
		List<List<String>> items = new ArrayList<>();
		items.add(book);
		items.add(food);
		items.add(deserts);
		
		for(var item : items)
			System.out.println(item);
		
		Set<String> flatList = items.stream()
									.flatMap(data -> data.stream())
									.collect(Collectors.toSet());
		System.out.println(flatList);
	}
}
