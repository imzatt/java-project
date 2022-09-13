package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.enity.Author;
import com.mmit.model.enity.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class AuthorController implements Initializable{
	
	 @FXML
	    private TableColumn<Author, LocalDate> col_birthday;

	    @FXML
	    private TableColumn<Author, String> col_city;

	    @FXML
	    private TableColumn<Author, Integer> col_id;

	    @FXML
	    private TableColumn<Author, String> col_name;

	    @FXML
	    private TableView<Author> tbl_author;

	    @FXML
	    private DatePicker txt_birthday;

	    @FXML
	    private TextField txt_city;

	    @FXML
	    private TextField txt_name;

	    private Author selected_author;
	    @FXML
	    void btn_add_click(ActionEvent event) {
	    	
	    	try {
	    		if(txt_birthday.getValue() == null) {
		    		showAlert(AlertType.ERROR, "Birthday required");
		    	}
		    	var auth = new Author();
		    	
		    	auth.setName(txt_name.getText());
		    	auth.setCity(txt_city.getText());
		    	auth.setBirthday(txt_birthday.getValue());
		    	
		    	DatabaseHandler.saveAuthor(auth);
		    	showAlert(AlertType.INFORMATION, "Success");
		    	resetData();
		    	showData();
			} 
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

	    private void resetData() {
			txt_name.setText(null);
			txt_city.setText(null);
			txt_birthday.setValue(null);
			
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
	    void btn_delete_click(ActionEvent event) {
	    	
	    	if(showAlert(AlertType.CONFIRMATION, "Are you sure delete ?").get() == ButtonType.OK) {
	    		DatabaseHandler.deleteAuthor(selected_author.getId());
	    		resetData();
	    		showData();
	    	}
	    }

	    @FXML
	    void btn_update_click(ActionEvent event) {
	    	
	    	try {
	    		selected_author.setName(txt_name.getText());
		    	selected_author.setCity(txt_city.getText());
		    	selected_author.setBirthday(txt_birthday.getValue());
		    	
		    	DatabaseHandler.updateAuthor(selected_author);
		    	showAlert(AlertType.INFORMATION, "Success");
		    	resetData();
		    	showData();
			} 
	    	catch (Exception e) {
				showAlert(AlertType.ERROR, e.getMessage());
			}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
			col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
			col_city.setCellValueFactory(new PropertyValueFactory<>("city"));
			col_birthday.setCellValueFactory(new PropertyValueFactory<>("birthday"));
			
			showData();
			
			tbl_author.getSelectionModel().selectedItemProperty()
			.addListener(
			(obs, old_select, new_select) -> {		
				if(new_select != null) {
					selected_author = tbl_author.getSelectionModel().getSelectedItem();
					txt_name.setText(selected_author.getName());
					txt_city.setText(selected_author.getCity());
					txt_birthday.setValue(selected_author.getBirthday());
				}
			}
					);
		}

		private void showData() {
			
			List<Author> list = DatabaseHandler.findAllAuthor();
			tbl_author.setItems(FXCollections.observableArrayList(list));
			
		}

}
