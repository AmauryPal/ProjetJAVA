package application;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class ControllerGameName {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private static int whichSave = 1;
	
	@FXML
	TextField gameName;
	
	public void switchToSaves(ActionEvent event) throws IOException {//switch vers la page des sauvegardes
		String name = gameName.getText();
		
		if(!(name.isEmpty())) {//si le nom de la sauvegarde n'est pas vide
			FXMLLoader loader = new FXMLLoader(getClass().getResource("Saves.fxml"));
			root = loader.load();
			
			ControllerSaves controllerSaves = loader.getController();//on appelle la classe dans laquelle on est
			ControllerMain.joueur.setGameName(name);
			
			setStopTime();//date de fin de partie
			save("enCours");//on sauvegarde
			controllerSaves.displayBDD();// afficher les infos dans la bdd
			
			
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public static void save(String where) {//sauvegarder l'instance joueur et board qui contiennent toutes les informations de notre partie.
			
		File directory=new File("./saves/"+where);
		File[] logFiles = directory.listFiles();
		
		int fileCount = (logFiles == null) ? 0 : logFiles.length;//nombre de sauvegardes dispo dans enCours
		
		if(fileCount != 5) {//si il reste des emplacements vides
			fileCount += 1;
			try {
		        FileOutputStream fileOut = new FileOutputStream("./saves/"+where+"/"+fileCount+".ser");
		        ObjectOutputStream out = new ObjectOutputStream(fileOut);

		        out.writeObject(ControllerMain.getBoard());
		        out.writeObject(ControllerMain.getPlayer());
		        out.close();
		        fileOut.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			}else {//sinon on prend le plus récent
				Date oldDate = new Date();
				for (int i = 1; i <= fileCount; i++) {//lire toutes les sauvegardes, puis comparer leurs dates
				    try {
					    ObjectInputStream in = new ObjectInputStream(new FileInputStream("./saves/"+where+"/"+i+".ser"));//on ouvre toutes les sauvegardes pour afficher les éléments
					    @SuppressWarnings("unused")
						int[][] board = (int[][]) in.readObject();
					    Player joueur = (Player) in.readObject();
					    in.close();
					    
					    if(joueur.getFullDate().before(oldDate)) {//oldDate = plus vielle date des 5 sauvegardes
					    	oldDate = joueur.getFullDate();
					    	whichSave = i;
					    }
					    
				    } catch (ClassNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		        FileOutputStream fileOut;
				try {
					fileOut = new FileOutputStream("./saves/"+where+"/"+whichSave+".ser");
					ObjectOutputStream out = new ObjectOutputStream(fileOut);
					
					out.writeObject(ControllerMain.getBoard());
					out.writeObject(ControllerMain.getPlayer());
					out.close();
					fileOut.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	        
		
	}
	public static void setStopTime() {
		DateTimeFormatter FormatObj  = DateTimeFormatter.ofPattern("HH:mm:ss");//save hour
		LocalTime temp = LocalTime.now();
		String stopTime = temp.format(FormatObj);
		ControllerMain.getPlayer().setStopTime(stopTime);
	}

}
