package assignment3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.naming.spi.DirStateFactory.Result;

public class Demo {

	static List<String> categoryList = new ArrayList<>();
	static List<Authors> authorList = new ArrayList<>();
	static List<Books> booklist = new ArrayList<>();
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		initiallizeData();
		
			
		String output = """
					1.View Authors
					2.View Books
					3.View Category
					4.AddBook
					5.Exit Program
					""";
		System.out.print(output);
		System.out.print("Choose Number ( 1 ~ 4 ) : ");
		int num = sc.nextInt();
			
		if(num == 1)
			viewAuthor();
		else if(num == 2)
			viewBook();
		else if(num == 3)
			viewCategory();
		else if(num == 4)
			addBook();
		else
		System.out.println("Exit Program ........");
			
		
	}

	private static void viewCategory() {
		System.out.println("\n---- Category -----");
		categoryList.forEach(cate -> System.out.println(cate));
	}
	
	private static void viewAuthor() {
		System.out.println("\n---- Author -----");
		System.out.println("Name \tCountry");
		authorList.forEach(auth -> System.out.println(auth.getName() + "\t" + auth.getCountry()));
	}

	private static void addBook() {
		
		// add category
		System.out.print("\nEnter Category : ");
		String cate_name = sc.next();
		cate_name += sc.nextLine();
		
		String category = null;
		for(var cate : categoryList) {
			if(cate.equalsIgnoreCase(cate_name)) {
				category = cate;
				break;
			}
		}
		
		if(category != null) {
			System.out.println(cate_name + " already exist");
		}else {
			categoryList.add(cate_name);
			//System.out.println(categoryList);
		}
		
		// add author
		System.out.print("\nEnter Author : ");
		String auth_name = sc.next();
		auth_name += sc.nextLine();
		
		Authors author = null;
		for(var auth : authorList) {
			if(auth.getName().equalsIgnoreCase(auth_name)) {
				author = auth;
				break;
			}
		}
		
		String city = null;
		if(author != null) {
			System.out.println(auth_name + " already exist");
		}else {
			System.out.print("Enter Author's country : ");
			city = sc.next();
			city += sc.nextLine();
			
			authorList.add(new Authors(auth_name, city));
			//authorList.forEach(a -> System.out.println(a.getName() + "\t" + a.getCountry()));
		}
		
		// add book
		System.out.print("Enter New Book Code : ");
		int code = sc.nextInt();
		System.out.print("Enter New Book Title : ");
		String title = sc.next();
		title += sc.nextLine();
		System.out.println("Fill PublishDate ...... ");
		System.out.print("Enter Year : ");
		int year = sc.nextInt();
		System.out.print("Enter Month : ");
		int month = sc.nextInt();
		System.out.print("Enter Day : ");
		int day = sc.nextInt();
		
		
		var book = new Books();
		book.setCode(code);
		book.setTitle(title);
		book.setPublishData(LocalDate.of(year, month, day));
		book.setAuthor(new Authors(auth_name, city));
		book.setCategory(cate_name);
		
		booklist.add(book);
		
//		System.out.println("\nCode \tTitle \tPublishDate \tAuthor \tCategory");
//		System.out.println(book.getCode() + "\t" + book.getTitle() + "\t" + book.getPublishData() + "\t" + book.getAuthor().getName() + "\t" + book.getCategory());
		
		System.out.println("\nCode \tTitle \t\tPublishDate \tAuthor \tCategory");
		booklist.forEach(b -> System.out.println(b.getCode() + "\t" + b.getTitle() + "\t" + b.getPublishData() + "\t" + b.getAuthor().getName() + "\t" + b.getCategory()));
		
	}
	
	private static void viewBook() {
		
		String output = """
				\n---- Book View ----
				1.View All
				2.View with Category
				3.View with Author
				4.Exit Program
				""";
		
		System.out.print(output);
		System.out.print("Choose Number ( 1 ~ 4 ) : ");
		int num = sc.nextInt();
		
		if(num == 1) {
			viewAll();
		}else if(num == 2) {
			System.out.print("Enter Search Category : ");
			String name = sc.next();
			name += sc.nextLine();
			viewWithcategory(name);
		}else if(num == 3) {
			System.out.print("Enter Search Author : ");
			String name = sc.next();
			name += sc.nextLine();
			viewWithauthor(name);
		}else {
			System.out.println("Exit Program ........");
		}
		
	}


	private static void viewWithauthor(String name) {
		Authors author = null;
		for(var auth : authorList) {
			if(auth.getName().equalsIgnoreCase(name)) {
				author = auth;
				break;
			}
		}
		
		if(author == null) {
			System.out.println(name + " does not exist");
		}else {
			var result = new ArrayList<Books>();
			for(var b : booklist) {
				if(b.getAuthor().getName().equalsIgnoreCase(name)) {
					result.add(b);
				}
			}
			
			if(result.size() > 0) { // found
				System.out.println("\nCode \tTitle \t\tPublishDate \tAuthor");
				result.forEach(b -> {
					System.out.print(b.getCode() + "\t");
					System.out.print(b.getTitle() + "\t");
					System.out.print(b.getPublishData()+ "\t");
					System.out.print(b.getAuthor().getName() + "\t");
				});
			}
		}
		
		
	}

	private static void viewWithcategory(String name) {
		String category = null;
		for(var cate : categoryList) {
			if(cate.equals(name)) {
				category = cate;
				break;
			}
		}
		
		var result = new ArrayList<Books>();
		for(var b : booklist) {
			if(b.getCategory().equalsIgnoreCase(name)) {
				result.add(b);
			}
		}
		
		if(result.size() > 0) {
			System.out.println("\nCode \tTitle \t\tPublishDate \tCategory");
			result.forEach(b -> {
				System.out.print(b.getCode() + "\t");
				System.out.print(b.getTitle() + "\t");
				System.out.print(b.getPublishData()+ "\t");
				System.out.print(b.getCategory() + "\t");
			});
		}else {
			System.out.println(name + " does not exist");
		}
		
	}

	private static void viewAll() {
		System.out.println("\n---- Book Information -----");
		System.out.println("Code \tTitle \t\tPublishDate \tAuthor \tCategory");
		booklist.forEach(b -> System.out.println(b.getCode() + "\t" + b.getTitle() + "\t" + b.getPublishData() + "\t" +  b.getAuthor().getName() + "\t" + b.getCategory()));
	}
	


	
	private static void initiallizeData() {
		
		// category
		categoryList.add("Music");
		categoryList.add("Sport");
		categoryList.add("Science");
		categoryList.add("Health");
		categoryList.add("Romatic");
		
		//author
		authorList.add(new Authors("Jeon", "Frence"));
		authorList.add(new Authors("Mr.Kim", "Seoul"));
		authorList.add(new Authors("Yuki", "Japan"));
		authorList.add(new Authors("Saung", "Myanmar"));
		authorList.add(new Authors("Mary","New York"));
		
		//book
		var book1 = new Books();
		book1.setCode(1001);
		book1.setTitle("No More Life");
		book1.setPublishData(LocalDate.of(2012, 10, 14));
		book1.setAuthor(authorList.get(4));
		book1.setCategory(categoryList.get(2));
		
		var book2 = new Books();
		book2.setCode(1002);
		book2.setTitle("Your Name");
		book2.setPublishData(LocalDate.of(2019, 8, 20));
		book2.setAuthor(authorList.get(2));
		book2.setCategory(categoryList.get(4));
		
		var book3 = new Books();
		book3.setCode(1003);
		book3.setTitle("How To Do");
		book3.setPublishData(LocalDate.of(2012, 4, 24));
		book3.setAuthor(authorList.get(1));
		book3.setCategory(categoryList.get(1));
		
		var book4 = new Books();
		book4.setCode(1004);
		book4.setTitle("Myanmar Food");
		book4.setPublishData(LocalDate.of(2018, 11, 18));
		book4.setAuthor(authorList.get(3));
		book4.setCategory(categoryList.get(3));
		
		var book5 = new Books();
		book5.setCode(1005);
		book5.setTitle("Love");
		book5.setPublishData(LocalDate.of(2011, 8, 7));
		book5.setAuthor(authorList.get(0));
		book5.setCategory(categoryList.get(0));
		
		booklist.add(book1);
		booklist.add(book2);
		booklist.add(book3);
		booklist.add(book4);
		booklist.add(book5);
	}
}
