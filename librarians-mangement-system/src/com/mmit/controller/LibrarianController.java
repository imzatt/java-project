package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.enity.DatabaseHandler;
import com.mmit.model.enity.Librarian;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class LibrarianController implements Initializable{

    @FXML
    private TableColumn<Librarian, String> col_email;

    @FXML
    private TableColumn<Librarian, Integer> col_id;

    @FXML
    private TableColumn<Librarian, String> col_name;

    @FXML
    private TableColumn<Librarian, String> col_nrc;

    @FXML
    private TableColumn<Librarian, Integer> col_phone;

    @FXML
    private TableView<Librarian> tbl_librarian;

    @FXML
    private TextField txt_email;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_nrcno;

    @FXML
    private TextField txt_phone;
    
    @FXML
    private PasswordField txt_pas;
    
    @FXML
    private TextField txt_searchname;

    private Librarian select_lib;
    @FXML
    void btn_add_click(ActionEvent event) {
    	
    	try {
        	var name = txt_name.getText();
        	var email = txt_email.getText();
        	var pass = txt_pas.getText();
        	var nrc = txt_nrcno.getText();
        	var phone = txt_phone.getText();
        	
        	if(name.isEmpty()) {
        		showAlert(AlertType.ERROR, "Name is required");
        	}
        	if(email.isEmpty()) {
        		showAlert(AlertType.ERROR, "Email is required");
        	}
        	if(pass.isEmpty()) {
        		showAlert(AlertType.ERROR, "Password is required");
        	}
        	if(nrc.isEmpty()) {
        		showAlert(AlertType.ERROR, "NRCno is required");
        	}
        	if(phone.isEmpty()) {
        		showAlert(AlertType.ERROR, "Phone no is required");
        	}
        	
        	var lib = new Librarian();
        	lib.setName(name);
        	lib.setEmail(email);
        	lib.setPassword(pass);
        	lib.setNrcno(nrc);
        	lib.setPhone(Integer.parseInt(phone));
        	
        	DatabaseHandler.addLibrarian(lib);
        	showAlert(AlertType.INFORMATION, "Success");
        	resetFrom();
        	showData();
		} catch (Exception e) {
			e.printStackTrace();
			showAlert(AlertType.ERROR, "Something is wrong");
		}
    }

    private void resetFrom() {
		
    	txt_name.setText(null);
    	txt_email.setText(null);
    	txt_pas.setText(null);
    	txt_nrcno.setText(null);
    	txt_phone.setText(null);
		
	}

	private Optional<ButtonType> showAlert(AlertType type, String msg) {
		
		Alert alert = new Alert(type);
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		
		return alert.showAndWait();
	}

	@FXML
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Start.fxml", "Library Mangement System");
    }

    @FXML
    void btn_edit_click(ActionEvent event) {
    	
    	try {
    		var name = txt_name.getText();
        	var email = txt_email.getText();
        	var pass = txt_pas.getText();
        	var nrc = txt_nrcno.getText();
        	var phone = txt_phone.getText();
        	
        	select_lib.setName(name);
        	select_lib.setEmail(email);
        	select_lib.setPassword(pass);
        	select_lib.setNrcno(nrc);
        	select_lib.setPhone(Integer.parseInt(phone));
        	
        	DatabaseHandler.editLibranrain(select_lib);
        	showAlert(AlertType.INFORMATION, "Success");
        	resetFrom();
        	showData();
		} 
    	catch (Exception e) {
    		e.printStackTrace();
			showAlert(AlertType.ERROR, "Something is wrong");
		}
    }


    @FXML
    void btn_delete_click(ActionEvent event) {
    	if(showAlert(AlertType.CONFIRMATION, "Are you sure delete ?").get() == ButtonType.OK) {
    		DatabaseHandler.deleteLibrarain(select_lib.getId());
    		resetFrom();
    		showData();
    	}
    }

    @FXML
    void btn_search_click(ActionEvent event) {
    	
    	var name = txt_searchname.getText();

    	List<Librarian> data = DatabaseHandler.searchLibraian(name);
    	tbl_librarian.setItems(FXCollections.observableArrayList(data));
    	txt_searchname.setText(null);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_nrc.setCellValueFactory(new PropertyValueFactory<>("nrcno"));
		col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
		
		showData();
		
		tbl_librarian.getSelectionModel().selectedItemProperty()
		.addListener(
		(obs, old_select, new_select) -> {
			if(new_select != null) {
				select_lib = tbl_librarian.getSelectionModel().getSelectedItem();
				txt_name.setText(select_lib.getName());
				txt_email.setText(select_lib.getEmail());
				txt_nrcno.setText(select_lib.getNrcno());
				txt_phone.setText(String.valueOf(select_lib.getPhone()));
			}
		}
				);
	}

	private void showData() {
		
		List<Librarian> list = DatabaseHandler.findAllLibrarain();
		tbl_librarian.setItems(FXCollections.observableArrayList(list));
	}
}
