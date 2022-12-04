package testing6;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Map_Testing2 {

	public static void main(String[] args) {
		
		test_linkHashMap();
		//test_TreeMap();
		
	}



	private static void test_TreeMap() {
		
		var file_extensions = new TreeMap<String, String>();
		
		 file_extensions.put("java", ".java");
		 file_extensions.put("html", ".html");
		 file_extensions.put("javascript", ".js");
		 file_extensions.put("cplusplus", ".c++");
		 file_extensions.put("php", ".php");
		
		 System.out.println(file_extensions);
		 file_extensions.remove("java");
		 System.out.println("value of java : " + file_extensions.get("java"));
		 // System.out.println(file_extensions);
	}



	private static void test_linkHashMap() {
		
		var student = new LinkedHashMap<Integer, String>();
		
		student.put(11, "Aung");
		student.put(5, "Kyaw Kyaw");
		student.put(8, "Honey");
		
		student.putIfAbsent(10, "Cherry");
		
		System.out.println(student);
		
		student.replace(8, "Honey Tun");
		System.out.println("Value of 8 : " + student);
		
		student.remove(11);
		System.out.println("Value of 11 : " + student.get(11));
	}
	
}
