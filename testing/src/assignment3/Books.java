package assignment3;

import java.time.LocalDate;

public class Books {

	private int code;
	private String title;
	private LocalDate publishData;
	private String category;
	private Authors author;
	
	public Books() {
		
	}
	
	public Books(int code, String title, LocalDate publishData, String category, Authors author) {
		super();
		this.code = code;
		this.title = title;
		this.publishData = publishData;
		this.category = category;
		this.author = author;
	}

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

	public LocalDate getPublishData() {
		return publishData;
	}
	public void setPublishData(LocalDate publishData) {
		this.publishData = publishData;
	}

	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

	public Authors getAuthor() {
		return author;
	}
	public void setAuthor(Authors author) {
		this.author = author;
	}

	
}
