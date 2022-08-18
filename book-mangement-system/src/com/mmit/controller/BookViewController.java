package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.enity.Book;
import com.mmit.model.enity.DatebaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class BookViewController implements Initializable{

	 	@FXML
	    private TableColumn<Book, String> col_author;

	    @FXML
	    private TableColumn<Book, String> col_category;

	    @FXML
	    private TableColumn<Book, Integer> col_code;

	    @FXML
	    private TableColumn<Book, String> col_entryby;

	    @FXML
	    private TableColumn<Book, Double> col_price;

	    @FXML
	    private TableColumn<Book, LocalDate> col_publish;

	    @FXML
	    private TableColumn<Book, String> col_title;

	    @FXML
	    private TableView<Book> tbl_book;

	    @FXML
	    void btn_back_click(ActionEvent event) throws IOException {
	    	Start.changeScene("view/Book.fxml", "Book");
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
			col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
			col_price.setCellValueFactory(new PropertyValueFactory<>("price"));
			col_publish.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
			col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
			col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
			col_entryby.setCellValueFactory(new PropertyValueFactory<>("entryName"));
			
			List<Book> list = DatebaseHandler.findAllBook();
			tbl_book.setItems(FXCollections.observableArrayList(list));
		}

}
