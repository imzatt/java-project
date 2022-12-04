package testing7;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Collecting {

	public static void main(String[] args) {
		
		Student[] students = {
				new Student(10, "cherry", "yangon"),
				new Student(2, "cherry", "mandalay"),
				new Student(5, "khaing", "monywa"),
				new Student(1, "htet", "mandalay" ),
				new Student(11, "htet yadana", "yangon")
		};
		
		Set<String> hashSet = Arrays.stream(students)
									.map(Student::getName)
									.collect(Collectors.toSet());
		System.out.println("hashset : " + hashSet);
		
		TreeSet<String> treeSet = Arrays.stream(students)
										.map(s -> s.getName())
										.collect(Collectors.toCollection(TreeSet::new));
		System.out.println("treeset : " + treeSet);
		
		List<String> list = Arrays.stream(students)
								.map(Student::getName)
								.collect(Collectors.toList());
		System.out.println("List : " + list);
								
		Map<Integer, String> map_1 = Arrays.stream(students)
										.collect(Collectors.toMap(Student::getRno, Student::getName));
		System.out.println("Map_1 : " + map_1);
		
		Map<Integer, Student> map_2 = Arrays.stream(students)
											.filter(s -> s.getCity().equals("yangon"))
											.collect(Collectors.toMap(s -> s.getRno(), s -> s));
		System.out.println("Map_2 : " + map_2);
		
	}
}
