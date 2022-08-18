package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.enity.Author;
import com.mmit.model.enity.Book;
import com.mmit.model.enity.Category;
import com.mmit.model.enity.DatebaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class BookEditController implements Initializable{

		private List<Author> authorList;
		private List<Category> categoryList;
		private Book search_book;
	   @FXML
	    private ComboBox<String> cbo_author;

	    @FXML
	    private ComboBox<String> cbo_category;

	    @FXML
	    private TextField txt_code;

	    @FXML
	    private TextField txt_price;

	    @FXML
	    private DatePicker txt_publishdate;

	    @FXML
	    private TextField txt_title;

	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	Start.changeScene("view/Book.fxml", "Book");
	    }

	    @FXML
	    void btn_delete_click(ActionEvent event) throws Exception, Exception {
	    	var code = txt_code.getText();
	    	if(code.isEmpty()) {
	    		showAlert(AlertType.ERROR, "Code is required");
	    		return;
	    	}
	    	
	    	var result = showAlert(AlertType.CONFIRMATION, "Are you sure to delete");
	    	if(result.get() == ButtonType.OK) {
	    		if(DatebaseHandler.deleteBook(Integer.parseInt(code)))
	    			showAlert(AlertType.INFORMATION, "Delete Success");
	    		else
	    			showAlert(AlertType.ERROR, "Something is wrong");
	    	}
	    }
	    

	    @FXML
	    void btn_search_click(ActionEvent event) {
	    	var code = txt_code.getText();
	    	if(code.isEmpty()) {
	    		showAlert(AlertType.ERROR, "Code is required");
	    		return;
	    	}
	    	
	    	search_book = DatebaseHandler.findByCode(Integer.parseInt(code));
	    	if(search_book == null) {
	    		showAlert(AlertType.ERROR, code + " is invalid");
	    		return;
	    	}
	    	
	    	txt_code.setText(String.valueOf(search_book.getCode()));
	    	txt_title.setText(search_book.getTitle());
	    	txt_price.setText(String.valueOf(search_book.getPrice()));
	    	txt_publishdate.setValue(search_book.getPublishDate());
	    	
	    	cbo_author.getSelectionModel().select(search_book.getAuthorName());
	    	cbo_category.getSelectionModel().select(search_book.getCategoryName());;
	    }

	    private Optional<ButtonType> showAlert(AlertType type, String msg) {
	    	Alert alert = new Alert(type);
	    	alert.setContentText(msg);
	    	alert.setTitle("Message");
	    	alert.setHeaderText(null);
	    	
	    	return alert.showAndWait();	
		}

		@FXML
	    void btn_update_click(ActionEvent event) {

			try {
				// get data
				var title = txt_title.getText();
				var price = txt_price.getText();
				var publishDate = txt_publishdate.getValue();
				var cat_index = cbo_category.getSelectionModel().getSelectedIndex();
				var auth_index = cbo_author.getSelectionModel().getSelectedIndex();
				
				// set data to object's field 
				search_book.setTitle(title);
				search_book.setPrice(Double.parseDouble(price));
				search_book.setPublishDate(publishDate);
				search_book.setAuthor(authorList.get(auth_index));
				search_book.setCategory(categoryList.get(cat_index));
				
				// update
				DatebaseHandler.updateBook(search_book);
				showAlert(AlertType.INFORMATION, "Update success");
			} 
			catch (Exception e) {
				e.printStackTrace();
				showAlert(AlertType.ERROR, "Something is wrong");
			}
			
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			authorList = DatebaseHandler.findAllAuthor();
			categoryList = DatebaseHandler.findAllCategory();
			
			var authors = authorList.stream()
									.map(a -> a.getName())
									.toList();
			var categories = categoryList.stream()
										.map(c -> c.getName())
					 					.toList();
			cbo_author.setItems(FXCollections.observableArrayList(authors));
			cbo_category.setItems(FXCollections.observableArrayList(categories));
		}
}
