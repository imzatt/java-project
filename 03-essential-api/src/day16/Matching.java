package day16;


import java.util.List;

public class Matching {

	public static void main(String[] args) {
		
		var numbers = List.of(2, 4, 6, 8, 10, 11);
		
		boolean rs1 = numbers.stream().allMatch(i -> i%2 == 0); //false
		boolean rs2 = numbers.stream().anyMatch(i -> i%2 == 0); //true
		
		boolean rs3 = numbers.stream().noneMatch(i -> i%2 == 0); //if It's all false, it can be true
		
		System.out.println(rs1);
		System.out.println(rs2);
		System.out.println(rs3);
	}
}
