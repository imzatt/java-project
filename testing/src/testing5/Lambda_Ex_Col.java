package testing5;

import java.util.List;

public class Lambda_Ex_Col {

	public static void main(String[] args) {
		
		List<String> languages = List.of("Java","JavaScript" ,"Python","PHP");
		
		// simple for each
//		for(String lang : languages) {
//			System.out.println(lang);
//		}
		
		// lambda exp
		System.out.println("----Lambda Exp");
		languages.forEach(lang -> System.out.println(lang));
		
		// contain "JAVA"
		System.out.println("\n---- Contain Java");
		languages.forEach(lang -> {
			if(lang.contains("Java"))
				System.out.println(lang);
		});
	}
	
	
}
