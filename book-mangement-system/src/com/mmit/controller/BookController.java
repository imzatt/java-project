package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class BookController {

	@FXML
    void btn_add_click(ActionEvent event) throws IOException {
		Start.changeScene("view/BookAdd.fxml", "Add New Book");
    }

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Start.fxml", "Book Mangement System");
    }

    @FXML
    void btn_editanddel_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/BookEdit.fxml", "Edit / Delete Book");
    }

    @FXML
    void btn_serach_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/BookSearch.fxml", "Search Book");
    }

    @FXML
    void btn_view_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/BookView.fxml", "View Book");
    }
}
