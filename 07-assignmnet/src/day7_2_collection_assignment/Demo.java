package day7_2_collection_assignment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Demo {

	static List<String> categoryList = new ArrayList<>();
	static List<Author> authorList = new ArrayList<>();
	static List<Book> bookList = new ArrayList<>();
	
	public static void main(String[] args) {
		initializeData();
		
		try(Scanner sc = new Scanner(System.in)){
			String output = """
					1.View Author
					2.View Category
					3.View Book
					4.Add New Book
					Choose number(1 ~ 4):
					""";
			System.out.print(output);
			int input = Integer.parseInt(sc.nextLine());
			
			switch(input) {
			case 1:
				viewAuhtor();
				break;
			case 2:
				viewCategory();
				break;
			case 3:
				viewBook(sc);
				break;
			case 4:
				addBook(sc);
				break;
			default:
				System.out.println("Invalid number");
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void viewAuhtor() {
		System.out.println("---- Author List ----");
		System.out.println("Author \tCountry");
		System.out.println("---------------------");
		authorList.forEach(obj -> {
			System.out.println(obj.getName() + " \t" + obj.getCountry());
		});
	}

	private static void viewCategory() {
		System.out.println("---- Category List ----");
		System.out.println("---------------------");
		categoryList.forEach(e -> System.out.println(e));
	}
	
	private static void viewBook(Scanner sc) {
		String output = """
				1.View All
				2.View by Category
				3.View by  Author
				Choose number(1,2 or 3):
				""";
		System.out.print(output);
		int input = Integer.parseInt(sc.nextLine());
		if(input == 1) {
			viewAllBook();
		}else if(input == 2) {
			System.out.println("Enter category name : ");
			String name = sc.nextLine();
			viewByCategory(name);
		}else if(input == 3) {
			System.out.println("Enter author name : ");
			String name = sc.nextLine();
			viewByAuthor(name);
		}else {
			System.err.println("Invalid Number");
		}
		
	}

	private static void addBook(Scanner sc) {	
		
		try {
			System.out.print("Enter New Category : ");
			String cate = sc.nextLine();
			
			for(var c : categoryList) {
				if(c.contains(cate)) {
					categoryList.remove(cate);
					System.out.println("This category already exists");
				}else {
					categoryList.add(cate);	
					System.out.println(categoryList);
					
					System.out.print("\nEnter New Author name : ");
					String name = sc.nextLine();
					
					for(var a : authorList) {
						if(a.getName().equalsIgnoreCase(name)) {
							System.out.println("This Author already exist");
							break;
						}else {
							System.out.print("Enter Author's country name :");
							String city = sc.nextLine();
							
							authorList.add(new Author(name, city));
							System.out.println("---- Author List ----");
							System.out.println("Author \tCountry");
							System.out.println("---------------------");
							authorList.forEach(obj -> {
							System.out.println(obj.getName() + " \t" + obj.getCountry());
									
							});
							
							System.out.print("\nEnter Book code : ");
							int code = sc.nextInt();
							System.out.print("Enter Book title : ");
							String title = sc.next();
							System.out.println("Fill PublishData : ");
							System.out.print("Enter Year : ");
							int year = sc.nextInt();
							System.out.print("Enter Month : ");
							int month = sc.nextInt();
							System.out.print("Enter Day : ");
							int day = sc.nextInt();
							LocalDate ld= LocalDate.of(year, month, day);
							
							var book3 = new Book();
							book3.setCategory(categoryList.get(4));
							book3.setAuthor(authorList.get(3));
							book3.setCode(code);
							book3.setPublishDate(ld);
							book3.setTitle(title);
							bookList.add(book3);
							
							System.out.println("\nBook \tAuthor \tCategory");
							System.out.println("-----------------------------");
							for(var b : bookList) {
								System.out.println(b.getTitle() + "\t" + b.getAuthor().getName() + "\t" + b.getCategory());
							}
						}
					}
				}
			}
			
			
		}
		catch (Exception e) {
			e.getMessage();
		}
	}

	// for book selection
	private static void viewAllBook() {
		
		System.out.println("Book \tAuthor \tCategory");
		System.out.println("-----------------------------");
		for(var b : bookList) {
			System.out.println(b.getTitle() + "\t" + b.getAuthor().getName() + "\t" + b.getCategory());
		}
				
	}
	
	private static void viewByCategory(String name) {
		
		String category = null;
		for(var cate : categoryList) {
			if(cate.equals(name)) {
				category = cate;
				break;
			}
		}
		
		if(category == null) {
			System.out.println(name + " does not exist");
		}else {
			var result_list = new ArrayList<Book>();
			for(var b : bookList) {
				if(b.getCategory().equalsIgnoreCase(name)) {
					result_list.add(b);
				}
			}
			
			if(result_list.size() > 0) {
				System.out.println("Name \tTitle \tCountry \tCategory");
				System.out.println("---------------------------------------");
				result_list.forEach(obj -> {
					System.out.print(obj.getAuthor().getName() + "\t");
					System.out.print(obj.getTitle() + "\t");
					System.out.print(obj.getAuthor().getCountry() + "\t");
					System.out.print(obj.getCategory() + "\n");
				});
			}else {
				System.out.println("There have not book in the booklist.");
			}
		}
		
	}
	
	private static void viewByAuthor(String name) {
		Author author = null;
		for(var auth : authorList) {
			if(auth.getName().equalsIgnoreCase(name)) {
				author = auth;
				break;
			}
		}
		
		if(author == null) {
			System.out.println(name + " does not exist");
		}else {
			var result_list = new ArrayList<Book>();
			for(var b : bookList) {
				if(b.getAuthor().getName().equalsIgnoreCase(name)) {
					result_list.add(b);
				}
			}
			
			if(result_list.size() > 0) { // found
				System.out.println("Code \tTitle \tCategory \tPublishDate ");
				System.out.println("------------------------------------------------------------------------------");
				result_list.forEach(obj -> {
					System.out.print(obj.getCode() + "\t");
					System.out.print(obj.getTitle() + "\t");
					System.out.print(obj.getCategory() + "\t");
					System.out.print(obj.getPublishDate() + "\n");
				});
			}else {
				System.out.println("There is no book related to this author");
			}
		}
	}
	

	private static void initializeData() {
		
		// category
		categoryList.add("music");
		categoryList.add("movie");
		categoryList.add("comestic");
		categoryList.add("drinks");
		
		
		// author
		authorList.add(new Author("Jeon", "Korea"));
		authorList.add(new Author("Cherry", "Myanmar"));
		authorList.add(new Author("Chris", "India"));
		
		// book
		var book1 = new Book();
		book1.setCategory(categoryList.get(0));
		book1.setAuthor(authorList.get(0));
		book1.setCode(1001);
		book1.setPublishDate(LocalDate.of(2013, 10, 13));
		book1.setTitle("No more dream");
		
		var book2 = new Book();
		book2.setCategory(categoryList.get(1));
		book2.setAuthor(authorList.get(0));
		book2.setCode(1002);
		book2.setPublishDate(LocalDate.of(2018, 11, 19));
		book2.setTitle("Life goes on");
		
		var book3 = new Book();
		book3.setCategory(categoryList.get(1));
		book3.setAuthor(authorList.get(1));
		book3.setCode(1003);
		book3.setPublishDate(LocalDate.of(2020, 9, 11));
		book3.setTitle("Mahar");
		
		bookList.add(book1);
		bookList.add(book2);
		bookList.add(book3);
	}
}
