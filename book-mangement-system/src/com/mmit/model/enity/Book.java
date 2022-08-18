package com.mmit.model.enity;

import java.time.LocalDate;

public class Book {

	private int code;
	private String title;
	private double price;
	private LocalDate publishDate;
	private Category category;
	private Author author;
	private User create_by;
	
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
	
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public LocalDate getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(LocalDate publishDate) {
		this.publishDate = publishDate;
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
	
	public String getAuthorName() { // authorName
		return author.getName();
	}
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	public String getEntryName() { // entryName
		return create_by.getEmail();
	}
	public User getCreate_by() {
		return create_by;
	}
	public void setCreate_by(User create_by) {
		this.create_by = create_by;
	}
	
}
