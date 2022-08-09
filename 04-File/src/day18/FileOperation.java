package day18;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.stream.Stream;

public class FileOperation {

	public static void main(String[] args) throws IOException{
//		createFile();
//		createDirectory();
//		deleteFile();
//		deleteDirectories();
//		copy();
//		move();	
//		browseWith_list();
		browseWith_walk();
	}

	private static void createFile() throws IOException{
		
		//locate
		Path path = Path.of("src/readme.txt");
		if(Files.exists(path)) {
			System.out.println("File already exist");
		}else {
			Files.createFile(path);
			System.out.println("Creating new file");
		}
	}

	private static void createDirectory() throws IOException{
		
		Path path = Path.of("./test");
		if(Files.notExists(path)) {
			Files.createDirectories(path);
			System.out.println("Creating new directory");
		}else {
			System.out.println("This directory already exist!");
		}
	}

	private static void deleteFile() throws IOException{
		
		var path = Path.of("src/readme.txt");
		boolean fileDeleted = Files.deleteIfExists(path);
		if(fileDeleted)
			System.out.println("Delete success");
		else
			System.out.println("Something is wrong");
	}

	private static void deleteDirectories() throws IOException{
		
		//delete empty folder
		//var path = Path.of("./test");
		//var path = Path.of("./data"); // non-delete 
		
//		var deletedDir = Files.deleteIfExists(path);
//		if(deletedDir)
//			System.out.println("Delete Success");
//		else
//			System.out.println("Something is wrong");
		
		
		//delete non-empty folder
		var path = Path.of("./data");
		if(Files.exists(path)) {
			Files.walk(path) // list all the files
					.map(p -> p.toFile()) // convert Path to File
					.forEach(f -> f.delete());
			
			Files.delete(path);
			System.out.println("Delete success");
		}else {
			System.out.println("This directory does not exists");
		}
		
	}

	private static void copy() throws IOException{
		 
		var source = Path.of("src/readme.txt");
		var dest = Path.of("src/another.txt");
		
		Files.copy(source, dest);
		System.out.println("Copy success");
		
	}
	
	private static void move() throws IOException{
		var source = Path.of("src/readme.txt");
		var dest = Path.of("src/day18/readme.txt");
		
		Files.move(source, dest, StandardCopyOption.REPLACE_EXISTING);
		System.out.println("Files move success");
	}
	
	private static void browseWith_list() {
		 
		var path = Path.of(".");
		try(Stream<Path> fileList = Files.list(path)){
			fileList.forEach(System.out::println);
		}
		catch(Exception e) {
			
		}
	}
	
	private static void browseWith_walk() {
		var path = Path.of(".");
		
		try(Stream<Path> files = Files.walk(path)){
//			System.out.println("--- All files and directories ----");
//			files.forEach(System.out::println);
			
//			System.out.println("\n--- Only directories ----");
//			files
//				.filter(Files::isDirectory)
//				.forEach(System.out::println);
			
			System.out.println("---- only java files");
			files
				.filter(p -> p.toString().contains(".java"))
				.forEach(System.out::println);
			
		}
		catch(Exception e){
			
		}
		
	}
}
