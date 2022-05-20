package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerMenuPrincipal {
	
	private Stage stage;
	private Scene scene;
	private Parent root;

	public void switchToMain(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		root = loader.load();
			  
		ControllerMain controller = loader.getController();
			 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		controller.go(event);
	}
	
	@FXML
	private Button logoutButton;
	@FXML
	private AnchorPane scenePane;
	public void logout(ActionEvent event) {
		stage = (Stage) scenePane.getScene().getWindow();
		System.out.println("You successfully logged out!");
		stage.close();
	}
}
