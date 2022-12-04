package testing4;

public class HAS_A_Rs {

	public static void main(String[] args) {
		
		Author a1 = new Author("Mya Tan Tint", "Myaing");
		Book b1 = new Book("War and Peace", 10000, a1);
		
		
	}
}

class Author {
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
	
	public Book(String name, int price , Author auth) {
		this.name = name;
		this.price = price;
		this.author = auth;
	}
}
