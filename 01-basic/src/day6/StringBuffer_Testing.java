package day6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StringBuffer_Testing {

	public static void main(String[] args) throws IOException {
		
		StringBuffer buffer = new StringBuffer("Java Programming");
		
		buffer.append(" Language");
		
		System.out.println("After append, buffer : " + buffer);
		
		buffer.insert(5,  "is a ");
		System.out.println("After insert, buffer: " + buffer);
		
		buffer.replace(0,  4, "PHP");
		System.out.println("After replace, buffer: " + buffer);
		
		System.out.println("index of 'Language' : " + buffer.indexOf("Language"));
		System.out.println("substring : " + buffer.substring(4));
		System.out.println("No of characters : " + buffer.length());
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		String name = reader.readLine();
	}
}
