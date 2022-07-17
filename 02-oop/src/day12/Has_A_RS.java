package day12;

public class Has_A_RS {

	public static void main(String[] args) {
		Author author =  new Author("Mya Than Tint", "Myaing");
		Book book = new Book("War and Peace", 2000 , "");
		
		System.out.println("Book Name : " + book.name);
		System.out.println("Book Price : " + book.price);
		System.out.println("**** Author Details *****");
		System.out.println("Author Name : " + author.name);
		System.out.println("Natice Town : " + author.nativeTown);
	}
}

class Author{
	String name;
	String nativeTown;
	
	public Author(String name, String town) {
		this.name = name;
		this.nativeTown = town;
	}
}

class Book{
	String name;
	int price;
	Author author;
	
	public Book(String name, int price, Author author) {
		this.name = name;
		this.price = price;
		this.author = author;
	}

	public Book(String name2, int price2, String string) {
		// TODO Auto-generated constructor stub
	}
}