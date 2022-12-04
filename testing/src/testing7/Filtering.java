package testing7;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Filtering {

	public static void main(String[] args) {
		
		List<User> users = List.of(
				new User("Kyaw Kyaw", "admin"),
				new User("Aung Aung", "Staff"),
				new User("Maung Maung", "Staff"),
				new User("Yuri", "customer"),
				new User("Jeon", "customer")
				);
		
//		users.stream()
//			//.filter(u -> u.getRole().equals("Staff")) 
//			.filter(User::IsStaff)
//			.forEach(u -> {
//				System.out.println("Name : " + u.getName());
//				System.out.println("Role : " + u.getRole());
//			});

//		List<String> name = users.stream()
//								.filter(u -> u.getName().contains("Aung") && u.getRole().equals("Staff"))
//								.map(u -> u.getName())
//								.collect(Collectors.toList());
//		
//		System.out.println(name);
		
		Stream<Integer> num = Stream.iterate(1, i -> i +1)
									.limit(15);
		
		Predicate<Integer> evens = i -> i%2 == 0; // create predicate
		
		num.filter(n -> n > 4 && n <= 10)
			.filter(evens)
			.forEach(System.out::println);
		
	}
}
