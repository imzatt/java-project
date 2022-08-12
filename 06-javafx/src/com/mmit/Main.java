package com.mmit;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	
	static Stage originStage = null;
	@Override
	public void start(Stage primaryStage) {
		try {
			// convert fxml to group obj that contains components
			Parent root = FXMLLoader.load(getClass().getResource("Start.fxml"));
			Scene scene = new Scene(root); // create scene and blind to component group
						
			originStage = primaryStage;
			primaryStage.setScene(scene); // add scene to stage
			primaryStage.setResizable(false);
			primaryStage.show();// show stage
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void changeScene(String input_file) throws IOException {
		
		Parent root = FXMLLoader.load(Main.class.getResource(input_file));
		Scene scene = new Scene(root);
		
		originStage.hide();
		originStage.setScene(scene);
		originStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
