package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerMenuHistorique {
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private int wichButton = 1;
	
	@FXML
	Text date1;
	@FXML 
	Text time1;
	@FXML 
	Text food1;
	@FXML 
	Text date2;
	@FXML 
	Text time2;
	@FXML 
	Text food2;
	@FXML 
	Text date3;
	@FXML 
	Text time3;
	@FXML 
	Text food3;
	@FXML 
	Text date4;
	@FXML 
	Text time4;
	@FXML 
	Text food4;
	@FXML 
	Text date5;
	@FXML 
	Text time5;
	@FXML 
	Text food5;
	
	public void switchToMenu(ActionEvent event) throws IOException {//switch vers la page menu principal
		  root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		  stage.show();
	}
	
	public void switchToHistorique(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Historique.fxml"));
		root = loader.load();
		
		ControllerHistorique controller = loader.getController();

		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		stage.show();
		
		
		loadData("historique", wichButton);
		controller.goHistorique(event);

	}
	public void loadData(String where, int wichButton) {
	    try {
		    ObjectInputStream in = new ObjectInputStream(new FileInputStream("./saves/"+where+"/"+wichButton+".ser"));
		    @SuppressWarnings("unused")
			int[][] board = (int[][]) in.readObject();
		    Player joueur = (Player) in.readObject();
		    in.close();
		    ControllerHistorique.joueur = joueur;
		    ControllerHistorique.boardInit = joueur.getBoardInit();
		    ControllerHistorique.directions = joueur.getDirections();
		     
		}catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    
	    
	}
	
	
	public void displayBDD() {
		File directory=new File("./saves/historique");
		File[] logFiles = directory.listFiles();
		
		int fileCount = (logFiles == null) ? 0 : logFiles.length;
		
		for (int i = 1; i <= fileCount; i++) {
		    try {
			    ObjectInputStream in = new ObjectInputStream(new FileInputStream("./saves/historique/"+i+".ser"));//on ouvre toutes les sauvegardes pour afficher les éléments
			    @SuppressWarnings("unused")
				int[][] board = (int[][]) in.readObject();
			    Player joueur = (Player) in.readObject();
			    in.close();
			     
			    switch (i) {
					case 1:
					    date1.setText(joueur.getStartDate());
					    time1.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					    food1.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
					case 2:
					    date2.setText(joueur.getStartDate());
					    time2.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					    food2.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
					case 3:
					    date3.setText(joueur.getStartDate());
					    time3.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					    food3.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
					case 4:
					    date4.setText(joueur.getStartDate());
					    time4.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					    food4.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
					case 5:
					     date5.setText(joueur.getStartDate());
					     time5.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					     food5.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
	
					default:
						break;
					}

				}catch (IOException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
		}
	}
	
	public void loadReplay1(ActionEvent event) throws IOException {
		wichButton = 1;
		if(ControllerSaves.verifyDisponibility(wichButton, "historique"))
			switchToHistorique(event);
	}
	public void loadReplay2(ActionEvent event) throws IOException {
		wichButton = 2;
		if(ControllerSaves.verifyDisponibility(wichButton, "historique"))
			switchToHistorique(event);
	}
	public void loadReplay3(ActionEvent event) throws IOException {
		wichButton = 3;
		if(ControllerSaves.verifyDisponibility(wichButton, "historique"))
			switchToHistorique(event);
	}
	public void loadReplay4(ActionEvent event) throws IOException {
		wichButton = 4;
		if(ControllerSaves.verifyDisponibility(wichButton, "historique"))
			switchToHistorique(event);
	}
	public void loadReplay5(ActionEvent event) throws IOException {
		wichButton = 5;
		if(ControllerSaves.verifyDisponibility(wichButton, "historique"))
			switchToHistorique(event);
	}
	
}
