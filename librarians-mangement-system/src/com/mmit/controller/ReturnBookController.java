package com.mmit.controller;

import java.io.IOException;

import com.mmit.Start;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ReturnBookController {

    @FXML
    private TableColumn<?, ?> col_bookcode;

    @FXML
    private TableColumn<?, ?> col_borrowdate;

    @FXML
    private TableColumn<?, ?> col_borrowid;

    @FXML
    private TableColumn<?, ?> col_duedate;

    @FXML
    private TableColumn<?, ?> col_fees;

    @FXML
    private TableColumn<?, ?> col_memberid;

    @FXML
    private TableColumn<?, ?> col_returndate;
    
    @FXML
    private TableView<?> tbl_retrunbook;

    @FXML
    private TextField txt_code;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Start.fxml", "Library Mangement System");
    }

    @FXML
    void btn_return_click(ActionEvent event) {

    }

    @FXML
    void btn_search_click(ActionEvent event) {

    }
}
