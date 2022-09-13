package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.enity.DatabaseHandler;
import com.mmit.model.enity.Member;

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

public class MemberController implements Initializable{

    @FXML
    private TableColumn<Member, String> col_academicyear;

    @FXML
    private TableColumn<Member, Integer> col_cardid;

    @FXML
    private TableColumn<Member, String> col_classyear;

    @FXML
    private TableColumn<Member, LocalDate> col_createddate;

    @FXML
    private TableColumn<Member, LocalDate> col_experieddate;

    @FXML
    private TableColumn<Member, String> col_name;

    @FXML
    private TableColumn<Member, Integer> col_rollno;

    @FXML
    private TableView<Member> tbl_member;

    @FXML
    private TextField txt_academicyear;


    @FXML
    private TextField txt_classyear;

    @FXML
    private DatePicker txt_createddate;

    @FXML
    private TextField txt_name;

    @FXML
    private TextField txt_rollno;

    @FXML
    private TextField txt_searchcardid;
    
    private Member selected_mem = null;

    @FXML
    void btn_add_click(ActionEvent event) {

    	try {
        	var name = txt_name.getText();
        	var rollno = txt_rollno.getText();
        	var class_year = txt_classyear.getText();
        	var academic_year = txt_academicyear.getText();
        	var created_date = txt_createddate.getValue();
        	

        	if(name.isEmpty()) {
        		showAlert(AlertType.ERROR, "Name is required");
        	}
        	if(rollno.isEmpty()) {
        		showAlert(AlertType.ERROR, "Roll No is required");
        	}
        	if(class_year.isEmpty()) {
        		showAlert(AlertType.ERROR, "Class Year is required");
        	}
        	if(academic_year.isEmpty()) {
        		showAlert(AlertType.ERROR, "Academic Year is required");
        	}
        	if(created_date == null) {
        		showAlert(AlertType.ERROR, "Create Date is required");
        	}
        	
        	var user = new Member();
        	user.setName(name);
        	user.setRollno(Integer.parseInt(rollno));
        	user.setYear(class_year);
        	user.setAcademicYear(academic_year);
        	user.setCreatedDate(created_date);
        	user.setExpiredDate(created_date.plusYears(1));
        	
        	DatabaseHandler.addMember(user);
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
		txt_rollno.setText(null);
		txt_classyear.setText(null);
		txt_academicyear.setText(null);
		txt_createddate.setValue(null);
		
	}

	private Optional<ButtonType> showAlert(AlertType type, String msg) {
		
    	Alert alert = new Alert(type);
    	alert.setContentText(msg);
    	alert.setHeaderText(null);
    	alert.setTitle("Message");
    	
    	return alert.showAndWait();
		
	}
	

    @FXML
    void btn_edit_click(ActionEvent event) {
    	
    	try {
        	var name = txt_name.getText();
        	var rollno = txt_rollno.getText();
        	var class_year = txt_classyear.getText();
        	var academic_year = txt_academicyear.getText();
        	var created_date = txt_createddate.getValue();
        	
        	selected_mem.setName(name);
        	selected_mem.setRollno(Integer.parseInt(rollno));
        	selected_mem.setYear(class_year);
        	selected_mem.setAcademicYear(academic_year);
        	selected_mem.setCreatedDate(created_date);
        	selected_mem.setExpiredDate(created_date.plusYears(1));
        	
        	DatabaseHandler.editMember(selected_mem);
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
    void btn_back_click(ActionEvent event) throws IOException {
    	Start.changeScene("view/Start.fxml", "Library Mangement System");
    }

    @FXML
    void btn_delete_click(ActionEvent event) {

    	if(showAlert(AlertType.CONFIRMATION, "Are you sure delete ?").get() == ButtonType.OK) {
    		DatabaseHandler.deleteMember(selected_mem.getCardID());
    		resetFrom();
    		showData();
    	}else {
    		showAlert(AlertType.ERROR, "Something is wrong");
    	}
    }

    @FXML
    void btn_search_click(ActionEvent event) {

    	var card_id = txt_searchcardid.getText();
    	
    	List<Member> data = DatabaseHandler.searchMember(card_id);
    	tbl_member.setItems(FXCollections.observableArrayList(data));
    	txt_searchcardid.setText(null);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_cardid.setCellValueFactory(new PropertyValueFactory<>("cardID"));
		col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
		col_rollno.setCellValueFactory(new PropertyValueFactory<>("rollno"));
		col_classyear.setCellValueFactory(new PropertyValueFactory<>("year"));
		col_academicyear.setCellValueFactory(new PropertyValueFactory<>("academicYear"));
		col_createddate.setCellValueFactory(new PropertyValueFactory<>("createdDate"));
		col_experieddate.setCellValueFactory(new PropertyValueFactory<>("expiredDate"));
		
		showData();
		
		tbl_member.getSelectionModel().selectedItemProperty()
		.addListener(
		(obs, old_select, new_select) -> {
			if(new_select != null) {
				selected_mem = tbl_member.getSelectionModel().getSelectedItem();
				txt_name.setText(selected_mem.getName());
				txt_rollno.setText(String.valueOf(selected_mem.getRollno()));
				txt_classyear.setText(selected_mem.getYear());
				txt_academicyear.setText(selected_mem.getAcademicYear());
				txt_createddate.setValue(selected_mem.getCreatedDate());
			}
		}
				);
		
	}

	private void showData() {
		
		List<Member> list = DatabaseHandler.findAllMember();
		tbl_member.setItems(FXCollections.observableArrayList(list));
	}

}
