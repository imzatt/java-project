package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.enity.Book;
import com.mmit.model.enity.DatabaseHandler;
import com.mmit.model.enity.Transaction;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BorrowBookController implements Initializable{

	private List<Book> avalist;
	List<Integer> ava;

    @FXML
    private TableColumn<Transaction, LocalDate> col_borrowdate;

    @FXML
    private TableColumn<Transaction, Integer> col_borrowid;

    @FXML
    private TableColumn<Transaction, Integer> col_bookcode;

    @FXML
    private TableColumn<Transaction, LocalDate> col_duedate;

    @FXML
    private TableColumn<Transaction, Integer> col_fees;

    @FXML
    private TableColumn<Transaction, Integer> col_librarianid;

    @FXML
    private TableColumn<Transaction, Integer> col_memberid;

    @FXML
    private TableView<Transaction> tbl_borrowbook;

    @FXML
    private TextField txt_code;

    @FXML
    private TextField txt_id;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Start.fxml", "Library Mangement System");
    }

    @FXML
    void btn_borrow_click(ActionEvent event) {

    	try {
        	var mem_id = txt_id.getText();
        	var code = txt_code.getText();
        	LocalDate date = LocalDate.now();
        	var fees = 2000;
        	
        	if(mem_id.isEmpty()) {
        		showAlert(AlertType.ERROR, "Member ID is required");
        	}
        	if(code.isEmpty()) {
        		showAlert(AlertType.ERROR, "Book Code is required");
        	}
        
        	var trans = new Transaction();
        	trans.setCardID(Integer.parseInt(mem_id));
        	trans.setBookID(Integer.parseInt(code));
        	trans.setBorrowDate(date);
        	trans.setDueDate(date.plusDays(7));
        	trans.setFees(fees);
        	trans.setCreate_by(Start.login_user);
        	
        	DatabaseHandler.borrowBook(trans);
        	showAlert(AlertType.INFORMATION, "Success");
        	resetFrom();
        	showData();
		} 
    	catch (Exception e) {
    		e.printStackTrace();
			showAlert(AlertType.ERROR, "Something is wrong");
		}
 
    }

	private void resetFrom() {
		txt_code.setText(null);
		txt_id.setText(null);
		
	}

	private Optional<ButtonType> showAlert(AlertType type, String msg) {
		
		Alert alert = new Alert(type);
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		
		return alert.showAndWait();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_borrowid.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_memberid.setCellValueFactory(new PropertyValueFactory<>("cardID"));
		col_bookcode.setCellValueFactory(new PropertyValueFactory<>("bookID"));
		col_borrowdate.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
		col_duedate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		col_fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
		col_librarianid.setCellValueFactory(new PropertyValueFactory<>("entryName"));
		
		showData();
		
		
	}

	private void showData() {
		
		List<Transaction> list = DatabaseHandler.findAllTransaction();
		tbl_borrowbook.setItems(FXCollections.observableArrayList(list));
		
	}

}
