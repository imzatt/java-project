package com.mmit.controller;

import java.io.IOException;
import java.util.Optional;

import com.mmit.Start;
import com.mmit.model.enity.DatabaseHandler;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {

    @FXML
    private TextField txt_email;

    @FXML
    private PasswordField txt_pass;

    @FXML
    void btn_login_click(ActionEvent event) throws IOException {
    	
    	var email = txt_email.getText();
    	var pass = txt_pass.getText();
    	
    	if(email.isEmpty()) {
    		showAlert(AlertType.ERROR, "Email is required");
    		return;
    	}
    	if(pass.isEmpty()) {
    		showAlert(AlertType.ERROR, "Password is required");
    		return;
    	}
    	
    	var lib = DatabaseHandler.Login(email,pass);
    	if(lib == null) {
    		showAlert(AlertType.ERROR, "Authentication failed");
    	}else {
    		Start.login_user = lib;
    		Start.changeScene("view/Start.fxml", "Library Mangement System");
    	}
    }
    
    

	private Optional<ButtonType> showAlert(AlertType type, String msg) {
		
		Alert alert = new Alert(type);
		alert.setContentText(msg);
		alert.setHeaderText(null);
		alert.setTitle("Message");
		
		return alert.showAndWait();
		
	}



	@FXML
    void lbl_close_click(MouseEvent event) {
    	System.exit(0);;
    }
	
}
