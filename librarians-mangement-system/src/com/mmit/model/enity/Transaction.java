package com.mmit.model.enity;

import java.time.LocalDate;

public class Transaction {

	private int id;
	private int cardID;
	private int bookID;
	private LocalDate borrowDate;
	private LocalDate dueDate;
	private int fees;
	private Librarian create_by;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getCardID() {
		return cardID;
	}
	public void setCardID(int cardID) {
		this.cardID = cardID;
	}
	
	public int getBookID() {
		return bookID;
	}
	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	public LocalDate getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(LocalDate borrowDate) {
		this.borrowDate = borrowDate;
	}
	
	public LocalDate getDueDate() {
		return dueDate;
	}
	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}
	
	public int getFees() {
		return fees;
	}
	public void setFees(int fees) {
		this.fees = fees;
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
