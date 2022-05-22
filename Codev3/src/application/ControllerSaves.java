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

public class ControllerSaves {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	private int wichButton = 1;
	
	
	public void switchToMenu(ActionEvent event) throws IOException {//switch vers la page menu principal
		  root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
		  
	}
	public void switchToMain(ActionEvent event) throws IOException {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Main.fxml"));
		root = loader.load();
		
		ControllerMain controller = loader.getController();
			 
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
		
		loadData();
		controller.go(event);
	}
	
	public void loadSave1(ActionEvent event) throws IOException {
		wichButton = 1;
		if(verifyDisponibility(wichButton))
			switchToMain(event);
	}
	public void loadSave2(ActionEvent event) throws IOException {
		wichButton = 2;
		if(verifyDisponibility(wichButton))
			switchToMain(event);
	}
	public void loadSave3(ActionEvent event) throws IOException {
		wichButton = 3;
		if(verifyDisponibility(wichButton))
			switchToMain(event);
	}
	public void loadSave4(ActionEvent event) throws IOException {
		wichButton = 4;
		if(verifyDisponibility(wichButton))
			switchToMain(event);
	}
	public void loadSave5(ActionEvent event) throws IOException {
		wichButton = 5;
		if(verifyDisponibility(wichButton))
			switchToMain(event);
	}
	
	@FXML 
	Text gameNameSave1;
	@FXML 
	Text gameNameSave2;
	@FXML 
	Text gameNameSave3;
	@FXML 
	Text gameNameSave4;
	@FXML 
	Text gameNameSave5;
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
	
	
	public boolean verifyDisponibility(int wichButton) {
		File directory=new File("./saves/enCours");
		File[] logFiles = directory.listFiles();
		
		int fileCount = (logFiles == null) ? 0 : logFiles.length;
		
		if (wichButton <= fileCount)
			return true;
		return false;
		
		
	}
	public void displayBDD() {
		File directory=new File("./saves/enCours");
		File[] logFiles = directory.listFiles();
		
		int fileCount = (logFiles == null) ? 0 : logFiles.length;
		
		for (int i = 1; i <= fileCount; i++) {
		    try {
			    ObjectInputStream in = new ObjectInputStream(new FileInputStream("./saves/enCours/"+i+".ser"));//on ouvre toutes les sauvegardes pour afficher les éléments
			    int[][] board = (int[][]) in.readObject();
			    Player joueur = (Player) in.readObject();
			    in.close();
			     
			    switch (i) {
					case 1:
						gameNameSave1.setText(joueur.getGameName());//on écrit les infos de chacuns des fichiers dispo dans le dossier saves/enCours
					    date1.setText(joueur.getStartDate());
					    time1.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					    food1.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
					case 2:
						gameNameSave2.setText(joueur.getGameName());//on écrit les infos de chacuns des fichiers dispo dans le dossier saves/enCours
					    date2.setText(joueur.getStartDate());
					    time2.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					    food2.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
					case 3:
						gameNameSave3.setText(joueur.getGameName());//on écrit les infos de chacuns des fichiers dispo dans le dossier saves/enCours
					    date3.setText(joueur.getStartDate());
					    time3.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					    food3.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
					case 4:
						gameNameSave4.setText(joueur.getGameName());//on écrit les infos de chacuns des fichiers dispo dans le dossier saves/enCours
					    date4.setText(joueur.getStartDate());
					    time4.setText("Début : " + joueur.getStartTime() + " et fin : " + joueur.getStopTime());
					    food4.setText("Energie restante : " + String.valueOf(joueur.getFood()));
						break;
					case 5:
						gameNameSave5.setText(joueur.getGameName());//on écrit les infos de chacuns des fichiers dispo dans le dossier saves/enCours
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

	public void loadData() {
	    try {
		     ObjectInputStream in = new ObjectInputStream(new FileInputStream("./saves/enCours/"+wichButton+".ser"));
		     int[][] board = (int[][]) in.readObject();
		     Player joueur = (Player) in.readObject();
		     in.close();
		     System.out.println("\nRécupération des données terminées avec succès\n");
		     ControllerMain.joueur = joueur;
		     ControllerMain.board = board;
		     
			}catch (IOException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	    
	    
		}
	
	
	
}
