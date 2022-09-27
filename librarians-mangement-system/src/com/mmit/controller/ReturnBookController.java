package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.enity.DatabaseHandler;
import com.mmit.model.enity.Transaction;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class ReturnBookController implements Initializable{

	private Transaction selected_book = null;
    @FXML
    private TableColumn<Transaction, Integer> col_bookcode;

    @FXML
    private TableColumn<Transaction, LocalDate> col_borrowdate;

    @FXML
    private TableColumn<Transaction, Integer> col_borrowid;

    @FXML
    private TableColumn<Transaction, LocalDate> col_duedate;

    @FXML
    private TableColumn<Transaction, Integer> col_fees;

    @FXML
    private TableColumn<Transaction, Integer> col_memberid;

    @FXML
    private TableColumn<Transaction, Integer> col_libID;
    
    @FXML
    private TableView<Transaction> tbl_retrunbook;

    @FXML
    private TextField txt_code;
    
    @FXML
    private TextField txt_borrowid;

    @FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Start.fxml", "Library Mangement System");
    }

    @FXML
    void btn_return_click(ActionEvent event) {
    	
    	var code = txt_code.getText();
    	var id = txt_borrowid.getText();
    	
    	LocalDate return_date = LocalDate.now();
    	
    	var trans = new Transaction();
    	trans.setId(Integer.parseInt(id));
    	trans.setBookID(Integer.parseInt(code));
    	
    	int i = DatabaseHandler.delete(trans,id);
    	LocalDate borrrow_date = selected_book.getBorrowDate();
    	
    	int days = Period.between(borrrow_date, return_date).getDays();
    	
    	if(i > 0) {
    		if(days <= 7) {
    			showAlert(AlertType.INFORMATION, "Return Book");
        		showData();
                txt_code.setText(null);
                txt_borrowid.setText(null);
                
    		}else {
    			showAlert(AlertType.INFORMATION, "Overdue Fees : 2000");
        		showData();
                txt_code.setText(null);
                txt_borrowid.setText(null);
    		}
    	}
    	
    	
    	
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	
    	try {
    		var code = txt_code.getText();
        	
        	List<Transaction> list = DatabaseHandler.searchCode(code);
        	tbl_retrunbook.setItems(FXCollections.observableArrayList(list));
        	if(list == null) {
        		showAlert(AlertType.ERROR, code + " is invalid");
        		return;
        	}
        	
        	
        	txt_code.setText(null);
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}
    	
    }

	private Optional<ButtonType> showAlert(AlertType type, String msg) {
		Alert alert = new Alert(type);
		alert.setContentText(msg);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		
		return alert.showAndWait();
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		col_memberid.setCellValueFactory(new PropertyValueFactory<>("cardID"));
		col_borrowid.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_bookcode.setCellValueFactory(new PropertyValueFactory<>("bookID"));
		col_borrowdate.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
		col_duedate.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
		col_libID.setCellValueFactory(new PropertyValueFactory<>("entryName"));
		col_fees.setCellValueFactory(new PropertyValueFactory<>("fees"));
		
		showData();
		
		tbl_retrunbook.getSelectionModel().selectedItemProperty()
		.addListener(
		(obs, old_select,new_select) -> {
			if(new_select != null) {
				selected_book = tbl_retrunbook.getSelectionModel().getSelectedItem();
				txt_code.setText(String.valueOf(selected_book.getBookID()));
				txt_borrowid.setText(String.valueOf(selected_book.getId()));
			}
		});
		
	}

	private void showData() {
		
		List<Transaction> list = DatabaseHandler.findAllTransaction();
		tbl_retrunbook.setItems(FXCollections.observableArrayList(list));
	}
	
}
