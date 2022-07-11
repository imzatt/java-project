package day5;

import java.util.Arrays;

public class String_Testing {

	public static void main(String[] args) {
		
		String s1 = new String(new char[] {'Y','W','K'});
		String s2 = new String("Java Programming is one of the popular programming languages");
		String s3 = "Myanmar IT Consulting";
		
		System.out.println("s1's length : " + s1.length());
		System.out.println("s1's length : " + s2.length());
		
		System.out.println("s3's uppercase : " + s3.toLowerCase());
		System.out.println("after change : " + s3.toUpperCase());
		
		//substring
		var substr = s2.substring(0, 4); // start, end-1
		System.out.println("substring: " + substr);
		System.out.println("After substring, s2: " + s2);
		System.out.println("substring2, s2: " + s2.substring(8));
		
		//replace
		System.out.println("Replace: " + s2.replace("Java", "Spring"));
		System.out.println("After replace, s2: " + s2);
		
		//concat
		System.out.println("Concat: " + s2.concat(" Language"));
		System.out.println("After concat, s2: " + s2);
		
		//finding
		System.out.println("Contain: " + s2.contains("Java"));
		System.out.println("Contain: " + s2.contains("abc"));
		
		System.out.println("End With 'ing': " + s2.endsWith("ing"));
		System.out.println("Start With 'abc': " + s2.startsWith("abc"));
		System.out.println("After contain, s2: " + s2);
		
		//location
		System.out.println("index of 'a' : " + s2.indexOf("a"));
		System.out.println("index of 'a' : " + s2.lastIndexOf("a"));
		System.out.println("index of 'a' : " + s2.indexOf("abc"));
		
		String[] data = s2.split(" ");
		System.out.println("data[0] : " + data[0]);
		System.out.println("No of words : " + data.length);
		
		char[] characters = s2.toCharArray();
		System.out.println("Character array : " + Arrays.toString(characters));
		
		// convert string from any data type
		String s4 = String.valueOf(characters);
		System.out.println("s4 : " + s4);
		
		s4 = String.valueOf(1000);
		System.out.println("s4 : " + s4);
		
	}
}
