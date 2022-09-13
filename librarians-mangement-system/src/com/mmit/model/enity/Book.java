package com.mmit.model.enity;

import java.time.LocalDate;

public class Book {

	private int code;
	private String title;
	private LocalDate publishDate;
	private Author author;
	private Category category;
	private int available;
	private Librarian create_by;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
	}
	
	public String getAuthorName() { // authorName
		return author.getName();
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getCategoryName() { // categoryName
		return category.getName();
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public int getAvailable() {
		return available;
	}
	public void setAvailable(int available) {
		this.available = available;
	}
	
	public String getEntryName() {
		return create_by.getEmail();
	}
	public Librarian getCreate_by() {
		return create_by;
	}
	public void setCreate_by(Librarian create_by) {
		this.create_by = create_by;
	}
	

}
