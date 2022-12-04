package testing7;

import java.util.List;

public class Matching {

	public static void main(String[] args) {
		
		var numbers = List.of(2,4,6,8,10, 11);
		
		boolean allEven = numbers.stream().allMatch(i -> i%2 == 0);
		boolean oneEven = numbers.stream().anyMatch(i -> i%2 == 0);
		boolean noneEven = numbers.stream().noneMatch(i -> i%2 == 0);
		
		System.out.println(allEven);
		System.out.println(oneEven);
		System.out.println(noneEven);
		
	}
}
