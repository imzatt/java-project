package day16;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Collecting {

	public static void main(String[] args) {
		Student[] students = {
				new Student(10,"cherry","yangon"),
				new Student(2,"cherry","mandalay"),
				new Student(5,"khaing","monywa"),
				new Student(1,"htet","mandalay"),
				new Student(11,"htet yadana","yangon")
		};
		
		Set<String> hashSet = Arrays.stream(students)
								.map(Student::getName)
								.collect(Collectors.toSet());
		
		System.out.println("hashset : " + hashSet);
		
		TreeSet<String> treeSet = Arrays.stream(students)
										.map(s -> s.getName())
										.collect(Collectors.toCollection(TreeSet::new));
		
		System.out.println("Treeset : " + treeSet);
		
		Map<Integer, String> map_1 = Arrays.stream(students)
											.collect(
												Collectors.toMap(
														Student::getRno,
														Student::getName)
													);
		
		Map<Integer, Student> map_2 = Arrays.stream(students)
											.filter(s -> !s.getCity().equals("yangon"))
											.collect(Collectors.toMap(
														s -> s.getRno(), // key
														s -> s // value
													));
		
		System.out.println(map_1);
		System.out.println(map_2);
	}
}
