package com.mmit.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import com.mmit.Start;
import com.mmit.model.enity.Author;
import com.mmit.model.enity.Book;
import com.mmit.model.enity.Category;
import com.mmit.model.enity.DatabaseHandler;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class BookController implements Initializable{

	private List<Author> authorlist;
	private List<Category> catlist;
	
	List<String> authors;
	List<String> categories;
    @FXML
    private ComboBox<String> cbo_author;

    @FXML
    private ComboBox<String> cbo_category;

    @FXML
    private TableColumn<Book, String> col_author;

    @FXML
    private TableColumn<Book, Integer> col_available;

    @FXML
    private TableColumn<Book, String> col_category;

    @FXML
    private TableColumn<Book, Integer> col_code;

    @FXML
    private TableColumn<Book, Integer> col_librarianid;

    @FXML
    private TableColumn<Book, LocalDate> col_publishdate;

    @FXML
    private TableColumn<Book, String> col_title;

    @FXML
    private TableView<Book> tbl_book;

    @FXML
    private TextField txt_available;

    @FXML
    private TextField txt_code;

    @FXML
    private DatePicker txt_date;

    @FXML
    private TextField txt_searchauthor;

    @FXML
    private TextField txt_searchcategory;

    @FXML
    private TextField txt_searchtitle;

    @FXML
    private TextField txt_title;
    
    private Book selected_book = null;
    @FXML
    void btn_add_click(ActionEvent event) {
    	
    	try {
        	var code = txt_code.getText();
        	var title = txt_title.getText();
        	var publishDate = txt_date.getValue();
        	var available = txt_available.getText();
        	
        	if(code.isEmpty()) {
        		showAlert(AlertType.ERROR, "Code is required");
        	}
        	if(title.isEmpty()) {
        		showAlert(AlertType.ERROR, "Title is required");
        	}
        	if(publishDate == null) {
        		showAlert(AlertType.ERROR, "Publish Date is required");
        	}
        	if(available.isEmpty()) {
        		showAlert(AlertType.ERROR, "Avaliable is required");
        	}
        	
        	var author_index = cbo_author.getSelectionModel().getSelectedIndex();
        	var category_index = cbo_category.getSelectionModel().getSelectedIndex();
        	
        	if(author_index < 0) {
        		showAlert(AlertType.ERROR, "Author is required");
        		return;
        	}
        	if(category_index < 0) {
        		showAlert(AlertType.ERROR, "Category is required");
        		return;
        	}
        	
        	var select_author = authorlist.get(author_index);
        	var select_category = catlist.get(category_index);
        	
        	var book = new Book();
        	book.setCode(Integer.parseInt(code));
        	book.setTitle(title);
        	book.setPublishDate(publishDate);
        	book.setAvailable(Integer.parseInt(available));
        	book.setAuthor(select_author);
        	book.setCategory(select_category);
        	book.setCreate_by(Start.login_user);
        	
        	DatabaseHandler.addBook(book);
        	showAlert(AlertType.INFORMATION, "Success");
        	resetFrom();
        	showData();
        	
		} 
    	catch (Exception e) {
    		e.printStackTrace();
			showAlert(AlertType.ERROR, e.getMessage());
		}
    	
    }

    private void resetFrom() {
		txt_code.setText(null);
		txt_title.setText(null);
		txt_date.setValue(null);
		txt_available.setText(null);
		cbo_author.getSelectionModel().clearSelection();
		cbo_category.getSelectionModel().clearSelection();
		
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
    void btn_delete_click(ActionEvent event) throws Exception, Exception {
    	
    	var code = txt_code.getText();
    	if(code.isEmpty()) {
    		showAlert(AlertType.ERROR, "Code is required");
    		return;
    	}
    	
    	var result = showAlert(AlertType.CONFIRMATION, "Are you sure delete ?");
    	if(result.get() == ButtonType.OK) {
    		if(DatabaseHandler.deleteBook(Integer.parseInt(code))) {
    			showAlert(AlertType.INFORMATION, "Delete Success");
    		}else {
    			showAlert(AlertType.ERROR, "Something is wrong");
    		}
    	}
    	
    	resetFrom();
    	showData();
    }

    @FXML
    void btn_edit_click(ActionEvent event) {
    	
    	try {
    		var title = txt_title.getText();
        	var publihdate = txt_date.getValue();
        	var auht_index = cbo_author.getSelectionModel().getSelectedIndex();
        	var cat_index = cbo_category.getSelectionModel().getSelectedIndex();
        	var available = txt_available.getText();
        	
        	selected_book.setTitle(title);
        	selected_book.setPublishDate(publihdate);
        	selected_book.setAuthor(authorlist.get(auht_index));
        	selected_book.setCategory(catlist.get(cat_index));
        	selected_book.setAvailable(Integer.parseInt(available));
        	
        	DatabaseHandler.editBook(selected_book);
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
    void btn_search_click(ActionEvent event) {
    	
    	var title = txt_searchtitle.getText();
    	var author = txt_searchauthor.getText();
    	var category = txt_searchcategory.getText();
    	
    	List<Book> data = DatabaseHandler.searchBook(title, author, category);
    	tbl_book.setItems(FXCollections.observableArrayList(data));
    	txt_searchtitle.setText(null);
    	txt_searchauthor.setText(null);
    	txt_searchcategory.setText(null);
    
    	
    }



	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		col_code.setCellValueFactory(new PropertyValueFactory<>("code"));
		col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
		col_publishdate.setCellValueFactory(new PropertyValueFactory<>("publishDate"));
		col_author.setCellValueFactory(new PropertyValueFactory<>("authorName"));
		col_category.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
		col_available.setCellValueFactory(new PropertyValueFactory<>("available"));
		col_librarianid.setCellValueFactory(new PropertyValueFactory<>("entryName"));
		
		
		authorlist = DatabaseHandler.findAllAuthor();
		catlist = DatabaseHandler.findAllCategory();
		
		authors = authorlist.stream()
							.map(a -> a.getName())
							.toList();
		categories = catlist.stream()
							.map(c -> c.getName())
							.toList();
		
		showData();
		
		tbl_book.getSelectionModel().selectedItemProperty()
		.addListener(
		(obs, old_select, new_select) -> {		
			if(new_select != null) {
				selected_book = tbl_book.getSelectionModel().getSelectedItem();
				txt_code.setText(String.valueOf(selected_book.getCode()));
				txt_title.setText(selected_book.getTitle());
				txt_date.setValue(selected_book.getPublishDate());
				cbo_author.getSelectionModel().select(selected_book.getAuthorName());
				cbo_category.getSelectionModel().select(selected_book.getCategoryName());
				txt_available.setText(String.valueOf(selected_book.getAvailable()));
			}
		}
				);
		
		
	}

	private void showData() {
		
		List<Book> list = DatabaseHandler.findAllBook();
		tbl_book.setItems(FXCollections.observableArrayList(list));
		cbo_author.setItems(FXCollections.observableArrayList(authors));
		cbo_category.setItems(FXCollections.observableArrayList(categories));
		
	}


}

