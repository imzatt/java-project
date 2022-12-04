package testing6;

import java.util.HashMap;
import java.util.Map;

public class Map_Testing {

	public static void main(String[] args) {
		
		test_HashMap();
		
	}

	private static void test_HashMap() {

		// create empty map
		var food = new HashMap<String, String>();
		
		food.put("Orange", "Fruit"); // put a new obj
		food.put("Grape", "Fruit");
		
		
		//						K		V		K			V
		var another1 = Map.of("Mango", "Fruit", "Potato", "Vegetable");
		
		food.putAll(another1);
		System.out.println(food);
		
		var another2 = Map.ofEntries(
				Map.entry("Coffee", "Juice"),
				Map.entry("Lemon Tea", "Juice")
				);
		food.putAll(another2);
		
		food.forEach((k,v) -> System.out.println(k + " -> " + v));
		
		food.putIfAbsent("Coffee", "Fruit");
		System.out.println("After new element, " + food);
		
		System.out.println("Contains 'coffee' : " + food.containsKey("Coffee"));
		System.out.println("Contains 'icecream' : " + food.containsValue("icecream"));
		
		var keys = food.keySet(); // get key only
		System.out.println("All key : " + keys);
		
		var values = food.values(); // get value only
		System.out.println("All values : " + values);
		
		System.out.println("Specified element : " + food.get("Coffee"));
		System.out.println("Specified element : " + food.get("abc"));
		
		// remove 
		//food.remove("Mango");
		//System.out.println("After Mango : " + food);
		
		food.keySet().removeIf(k -> k.contains("Tea"));
		System.out.println("After remove 'Tea' : " + food);
		
		// update
		food.replace("Mango", "Juice");
		System.out.println("Value of Mango : " + food);
		System.out.println("Value of Mango : " + food.get("Mango"));
		
		food.compute("Coffee", (k,v) -> v.toUpperCase());
		System.out.println("value of 'Coffee' : " + food.get("Coffee"));
		
		food.compute("Cake", (k,v) -> "Snack"); // auto add and compute, But dangerous
		System.out.println(food);
		
		food.computeIfAbsent("Orange", k -> "Juice");
		System.out.println("Value of 'Orange' : " + food.get("Orange"));
		
		food.computeIfAbsent("Banana", k -> "Fruit");
		System.out.println(food);
		
		food.computeIfPresent("Orange", (k, v) -> "Juice");
		System.out.println("value of Orange : " + food.get("Orange"));
		System.out.println(food);
		
		food.computeIfPresent("Con", (k,v) -> "Vegetable");
		System.out.println("value of con : " + food.get("Con"));
		System.out.println(food);
	}
}
