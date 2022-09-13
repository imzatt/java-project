package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class StartController {
	
		@FXML
	    void btn_logout_click(ActionEvent event) throws IOException {
			Start.changeScene("view/Main.fxml", "Login");
	    }

	    @FXML
	    void panel_author_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Author.fxml", "Author");
	    }

	    @FXML
	    void panel_book_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Book.fxml", "Book Mangement");
	    }

	    @FXML
	    void panel_borrow_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/BorrowBook.fxml", "Borrow Book");
	    }

	    @FXML
	    void panel_category_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Category.fxml", "Category");
	    }

	    @FXML
	    void panel_librarian_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Librarian.fxml", "Librarian");
	    }

	    @FXML
	    void panel_member_click(MouseEvent event) throws IOException {
	    	Start.changeScene("view/Member.fxml", "Member");
	    }

	    @FXML
	    void panel_return_book(MouseEvent event) throws IOException {
	    	Start.changeScene("view/ReturnBook.fxml", "Return Book");
	    }
}
