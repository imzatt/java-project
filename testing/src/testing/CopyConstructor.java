package testing;

import java.time.LocalDate;

public class CopyConstructor {

	public static void main(String[] args) {
		Book book = new Book("U San Shar", LocalDate.of(1961, 10, 16), 3000);
		System.out.println("Book :  " + book);
		
		System.out.println();
		Book book2 = new Book(book);  
		
		changePrice(book2);
		System.out.println("After changePrice, price = " + book2.price);
		int a = 100;
		changeValue(a);
		System.out.println("After changeValue, a = " + a);
		System.out.println("Book2 : " + book2);
		
	}

	private static void changeValue(int a) {
		a = 300;
	}

	private static void changePrice(Book book2) {
		book2.price = 10000;
	}
}

class Book{
	String title;
	LocalDate publishDate;
	int price;
	
	public Book(String title, LocalDate p_date, int price) {
		this.title = title;
		this.publishDate = p_date;
		this.price = price;
	}
	
	public Book(Book other) { // copy constructor
		this.title = other.title;
		this.publishDate = other.publishDate;
		this.price = other.price;
	}
	
	@Override
	public String toString() {
		return "Title = " + this.title + " ,date = " + 
					this.publishDate + " ,price = " + this.price;
	}
}