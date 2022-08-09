package day18;

import java.nio.file.Path;

public class GettingPath {

	public static void main(String[] args) {
		
		Path path = Path.of("./src/day18/GettingPath.java");
		
		System.out.println("Relatice path: " + path);
		System.out.println("Absolute path: " + path.toAbsolutePath());
		
		path = Path.of("src","day18","readme.txt");
		System.out.println("Relative path : " + path);
		
	}
}
