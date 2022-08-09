package day13;

import java.util.List;

public class Lamba_with_Collection {

	public static void main(String[] args) {
		List<String> languages = List.of("Html","Javascript","Css","Java","PHP");
		
		//languages.forEach(null);
//		for(String lang : languages) {
//			System.out.println(lang);
//		}
		
		languages.forEach(lang -> System.out.println(lang));
		
		System.out.println("------ Contain 'Java' -----");
		languages.forEach(lang -> {
			if(lang.contains("Java"))
				System.out.println(lang);
		});
	}
}
