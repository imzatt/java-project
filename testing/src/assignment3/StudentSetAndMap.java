package assignment3;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class StudentSetAndMap {

	public static void main(String[] args) {
		
		//Test_TreeSet();
		Test_HashMap();
	}

	private static void Test_HashMap() {
		
		var student = new HashMap<Integer, String>();
		
		student.put(3, "Mg Mg");
		student.put(2, "Mary");
		student.put(4, "Ag Ah");
		student.put(5, "Cherry");
		student.put(1, "Hla Hla");
		
		// auto ascending
		System.out.println(student);
		
		//update
		var stu = Map.ofEntries(
				Map.entry(6, "Mg Hla"),
				Map.entry(7, "Mya Mya")
				);
		student.putAll(stu);
		
		student.replace(4, "Ag Ag");
		System.out.println(student);
		
		int num = 5;
		student.forEach((k,v) -> {
			if(k.equals(num)) {
				System.out.println(student.get(num));
			}
		});
			
		student.values().removeIf(v -> v.contains("ry"));
		System.out.println(student);
		
	}

	private static void Test_TreeSet() {
		
		var student = new TreeSet<>();
		
		student.add("Mg Mg");
		student.add("Cherry");
		student.add("Ag Ag");
		student.add("Marry");
		student.add("Hla Hla");
		
		System.out.println(student);
		
		student.removeIf(b -> b.equals("Mg Mg"));
		System.out.println(student);
		
	}
}


