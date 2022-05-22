package application;

import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ControllerHistorique extends ControllerMain{
Player joueur = new Player(400);	
int i = 0;
int[][] board = new int[10][10];

String[] moves = {"right","up","down","left","right","up","down","left"};


public void x3(ActionEvent e) throws IOException {
	if (i==0) {
		i=1;
	go(e);
	historique(moves, board, joueur, 400);
	}
	
}

public void x2(ActionEvent e) throws IOException {
	if (i==0) {
		i=1;
	go(e);
	historique(moves, board, joueur, 800);
	}
	
}

public void x1(ActionEvent e) throws IOException {
	if (i==0) {
		i=1;
	go(e);
	historique(moves, board, joueur, 1200);
	}
	
}
	
	
	

	public void historique(String[] moves, int[][] board, Player joueur,int time) {
		   
		int j = 0;
		 for (String i : moves) {
			 Timer timer = new Timer();
	     TimerTask task = new TimerTask() {
	    	 
	    	public void run() {
		if ( i == "right") {
		Player.avancer(board, joueur, Direction.RIGHT);
		afficher(board, joueur);

		}

		else if (i =="left") {
		Player.avancer(board, joueur, Direction.LEFT);
		afficher(board, joueur);}

		else if (i == "up") {
		Player.avancer(board, joueur, Direction.UP);
		afficher(board, joueur);}

		else if (i =="down"){
		Player.avancer(board, joueur, Direction.DOWN);
		afficher(board, joueur); }
	    	} };
	    	timer.schedule(task,  time+j);
	    	j = j+time;
		}
	}
		

}
