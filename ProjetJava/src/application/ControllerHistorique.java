package application;

import java.util.Timer;
import java.util.TimerTask;
import java.io.IOException;
import java.util.ArrayList;
import javafx.event.ActionEvent;


public class ControllerHistorique extends ControllerMain{
	static Player joueur;
	static int[][] boardInit;
	static ArrayList<Direction> directions;
	
	public void x3(ActionEvent e) throws IOException {

		historique(directions, boardInit, joueur, 250);
		
	}
	
	public void x2(ActionEvent e) throws IOException {

		historique(directions, boardInit, joueur, 500);
	}
	
	public void x1(ActionEvent e) throws IOException {


		historique(directions, boardInit, joueur, 1000);
	}
	
	
	

	public void historique(ArrayList<Direction> moves, int[][] boardInit, Player joueur,int time) {
		joueur.setX(0);
		joueur.setY(0);
		joueur.setFood(10000000);
		int[][] boardInitClone = new int[10][10];
		for (int i = 0; i < boardInit.length; i++) {
			for (int j = 0; j < boardInit.length; j++) {
				boardInitClone[i][j] = boardInit[i][j];
			}
		}
		int baseTime = 0;
		afficher(boardInitClone, joueur);
		for (Direction i : moves) {
			
			Timer timer = new Timer();
			TimerTask task = new TimerTask() {
				public void run() {
		
					if ( i == Direction.RIGHT) {
						Player.avancer(boardInitClone, joueur, Direction.RIGHT);
						afficher(boardInitClone, joueur);
			
					}		
			
					else if (i == Direction.LEFT) {
						Player.avancer(boardInitClone, joueur, Direction.LEFT);
						afficher(boardInitClone, joueur);
					}
			
					else if (i == Direction.UP) {
						Player.avancer(boardInitClone, joueur, Direction.UP);
						afficher(boardInitClone, joueur);
					}
			
					else if (i == Direction.DOWN){
						Player.avancer(boardInitClone, joueur, Direction.DOWN);
						afficher(boardInitClone, joueur); 
					}
		    	}
				
			};
	    	timer.schedule(task, time+baseTime);
	    	baseTime += time;
		}
		
	}
		

}
