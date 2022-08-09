package day15;

import java.util.HashMap;
import java.util.Map;

public class Map_Testing {

	public static void main(String[] args) {
		
		test_HashMap();
	}

	private static void test_HashMap() {
		
		var foods = new HashMap<String, String>();
		
		foods.put("Orange", "Fruit");
		foods.put("Grape", "Fruit");
		System.out.println(foods);
		
		var another1 = Map.of("Mango","Fruit","Potato","Vegetable");
		foods.putAll(another1);
		System.out.println(foods);
		
		var another2 = Map.ofEntries(
				Map.entry("Coffee", "Juice"),
				Map.entry("Lemon Tea", "Juice")
				);
		foods.putAll(another2);
		
		//foreach
		foods.forEach((k,v) -> {
			System.out.println(k + " -> " + v);
		});
		
		foods.putIfAbsent("kiwi", "Fruit");
		System.out.println("After new element : " + foods);
		
		System.out.println("Contains 'coffee' : " + foods.containsKey("Coffee"));
		System.out.println("Contains 'coffee' : " + foods.containsValue("Snack"));
		
		var keys = foods.keySet();
		System.out.println("All keys : " + keys);
		
		var values = foods.values();
		System.out.println("All values : " + values);
		
		System.out.println("Specified element : " + foods.get("Coffee"));
		System.out.println("Specified element : " + foods.get("abc"));
		
		//remove
//		foods.remove("Mango");
//		System.out.println("After remove 'Mango' : " + foods);
//		
//		foods.keySet().removeIf(k -> k.contains("Tea"));
//		System.out.println("After remove : " + foods);
		
		//update
		foods.replace("Mango", "Juice");
		System.out.println("value of 'Mango' : " + foods.get("Mango"));
		
		foods.compute("Coffee", (k,v) -> v.toLowerCase());
		System.out.println("value of 'Coffee' : " + foods.get("Coffee"));
		
		foods.compute("Cake", (k,v) -> "Snack");
		System.out.println(foods);
		
		foods.computeIfAbsent("Orange", k -> "Juice");
		System.out.println("values of 'Orange' : " + foods);
		
		foods.computeIfAbsent("Banana", k -> "Fruit");
		System.out.println("values of 'Banana' : " + foods);
		
		foods.computeIfPresent("Orange", (k,v) -> "Juice");
		System.out.println("value of Orange : " + foods.get("Orange"));
		
		foods.computeIfPresent("Corn", (k,v) -> "Vegetable");
		System.out.println("value of Corn : " + foods.get("Corn"));
	}
}
