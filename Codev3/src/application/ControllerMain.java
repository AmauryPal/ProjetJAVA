package application;

import java.io.IOException;
import java.lang.ModuleLayer.Controller;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerMain {
	
	
	Image food = new Image("food.jpg");
	Image caseVide = new Image("caseVide.png");
	Image obstacle = new Image("obstacle.jpg");
	Image personnage = new Image("personnage.jpg");
	Image caseAlerte = new Image("caseAlerte.png");
	
	ImageView v1 = new ImageView(caseVide);ImageView v2 = new ImageView(caseVide);ImageView v3 = new ImageView(caseVide);ImageView v4 = new ImageView(caseVide);ImageView v5 = new ImageView(caseVide);ImageView v6 = new ImageView(caseVide);ImageView v7 = new ImageView(caseVide);ImageView v8 = new ImageView(caseVide);ImageView v9 = new ImageView(caseVide);ImageView v10 = new ImageView(caseVide);ImageView v11 = new ImageView(caseVide);ImageView v12 = new ImageView(caseVide);ImageView v13 = new ImageView(caseVide);ImageView v14 = new ImageView(caseVide);ImageView v15 = new ImageView(caseVide);ImageView v16 = new ImageView(caseVide);ImageView v17 = new ImageView(caseVide);ImageView v18 = new ImageView(caseVide);ImageView v19 = new ImageView(caseVide);ImageView v20 = new ImageView(caseVide);ImageView v21 = new ImageView(caseVide);ImageView v22 = new ImageView(caseVide);ImageView v23 = new ImageView(caseVide);ImageView v24 = new ImageView(caseVide);ImageView v25 = new ImageView(caseVide);ImageView v26 = new ImageView(caseVide);ImageView v27 = new ImageView(caseVide);ImageView v28 = new ImageView(caseVide);ImageView v29 = new ImageView(caseVide);ImageView v30 = new ImageView(caseVide);ImageView v31 = new ImageView(caseVide);ImageView v32 = new ImageView(caseVide);ImageView v33 = new ImageView(caseVide);ImageView v34 = new ImageView(caseVide);ImageView v35 = new ImageView(caseVide);ImageView v36 = new ImageView(caseVide);ImageView v37 = new ImageView(caseVide);ImageView v38 = new ImageView(caseVide);ImageView v39 = new ImageView(caseVide);ImageView v40 = new ImageView(caseVide);ImageView v41 = new ImageView(caseVide);ImageView v42 = new ImageView(caseVide);ImageView v43 = new ImageView(caseVide);ImageView v44 = new ImageView(caseVide);ImageView v45 = new ImageView(caseVide);ImageView v46 = new ImageView(caseVide);ImageView v47 = new ImageView(caseVide);ImageView v48 = new ImageView(caseVide);ImageView v49 = new ImageView(caseVide);ImageView v50 = new ImageView(caseVide);ImageView v51 = new ImageView(caseVide);ImageView v52 = new ImageView(caseVide);ImageView v53 = new ImageView(caseVide);ImageView v54 = new ImageView(caseVide);ImageView v55 = new ImageView(caseVide);ImageView v56 = new ImageView(caseVide);ImageView v57 = new ImageView(caseVide);ImageView v58 = new ImageView(caseVide);ImageView v59 = new ImageView(caseVide);ImageView v60 = new ImageView(caseVide);ImageView v61 = new ImageView(caseVide);ImageView v62 = new ImageView(caseVide);ImageView v63 = new ImageView(caseVide);ImageView v64 = new ImageView(caseVide);ImageView v65 = new ImageView(caseVide);ImageView v66 = new ImageView(caseVide);ImageView v67 = new ImageView(caseVide);ImageView v68 = new ImageView(caseVide);ImageView v69 = new ImageView(caseVide);ImageView v70 = new ImageView(caseVide);ImageView v71 = new ImageView(caseVide);ImageView v72 = new ImageView(caseVide);ImageView v73 = new ImageView(caseVide);ImageView v74 = new ImageView(caseVide);ImageView v75 = new ImageView(caseVide);ImageView v76 = new ImageView(caseVide);ImageView v77 = new ImageView(caseVide);ImageView v78 = new ImageView(caseVide);ImageView v79 = new ImageView(caseVide);ImageView v80 = new ImageView(caseVide);ImageView v81 = new ImageView(caseVide);ImageView v82 = new ImageView(caseVide);ImageView v83 = new ImageView(caseVide);ImageView v84 = new ImageView(caseVide);ImageView v85 = new ImageView(caseVide);ImageView v86 = new ImageView(caseVide);ImageView v87 = new ImageView(caseVide);ImageView v88 = new ImageView(caseVide);ImageView v89 = new ImageView(caseVide);ImageView v90 = new ImageView(caseVide);ImageView v91 = new ImageView(caseVide);ImageView v92 = new ImageView(caseVide);ImageView v93 = new ImageView(caseVide);ImageView v94 = new ImageView(caseVide);ImageView v95 = new ImageView(caseVide);ImageView v96 = new ImageView(caseVide);ImageView v97 = new ImageView(caseVide);ImageView v98 = new ImageView(caseVide);ImageView v99 = new ImageView(caseVide);ImageView v100 = new ImageView(caseVide);
	ImageView[][] images= {{v1 ,v2 ,v3 ,v4 ,v5 ,v6 ,v7 ,v8 ,v9 ,v10},
						   {v11,v12,v13,v14,v15,v16,v17,v18,v19,v20},
						   {v21,v22,v23,v24,v25,v26,v27,v28,v29,v30},
						   {v31,v32,v33,v34,v35,v36,v37,v38,v39,v40},
						   {v41,v42,v43,v44,v45,v46,v47,v48,v49,v50},
						   {v51,v52,v53,v54,v55,v56,v57,v58,v59,v60},
						   {v61,v62,v63,v64,v65,v66,v67,v68,v69,v70},
						   {v71,v72,v73,v74,v75,v76,v77,v78,v79,v80},
						   {v81,v82,v83,v84,v85,v86,v87,v88,v89,v90},
						   {v91,v92,v93,v94,v95,v96,v97,v98,v99,v100}};
	 
	
	public Text energie = new Text();
	public GridPane grid; // LA GRILLE
	public static int[][] board = new int[10][10]; 
	public static int[][] boardinit = new int[10][10];// LE TABLEAU
	static Player joueur = new Player(400); // JOUEUR
	boolean partieEnCours = true;
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	public Text gameName = new Text();
	public Text textfin = new Text();
	public Text distance = new Text();
	public Text energyLoss = new Text();
	public Text energyWin = new Text();
	
	public void afficher(int[][] tabl, Player joueur) {
		for (int i=0; i<10; i++ ) { 
			for(int j=0; j<10; j++) {
		
				if(tabl[i][j]== 1)
					images[i][j].setImage(food);
				else if(tabl[i][j] == 2) 
					images[i][j].setImage(obstacle);
				else if(tabl[i][j]== 3)
					images[i][j].setImage(personnage);
				else
					images[i][j].setImage(caseVide);
			}
		}			
		energie.setText("Energie en stock: "+joueur.getFood());
		fin(joueur);
	}
	
	
	public void init() {//réinitialise tout à null, recréé une grille et une instance joueur

		Board plateau = new Board(10, 5, 5);
		Board.Creer(board, plateau);
		int i;
		int j;
		for (i=0;i<10;i++) {
			for (j=0;j<10;j++) {
				boardinit[i][j] = board[i][j];
			}
		}
		joueur = new Player(400);
		
		partieEnCours = true;
		
		energie.setText(null);
		textfin.setText(null);
		distance.setText(null);
		energyLoss.setText(null);
		energyWin.setText(null);
		gameName.setText("Game4J");
	}
	
	public void go(ActionEvent event) throws IOException{
		
		for (int i=0; i<10; i++) {
			for (int j=0; j<10;j++) {
				images[i][j].setFitHeight(60);
				images[i][j].setFitWidth(60);
				grid.add(images[i][j], j, i, 1, 1);
			}
		}
		gameName.setText(joueur.getGameName());
		afficher(board, joueur);
	}
	
	
	public void up(ActionEvent e) {
		if(Player.avancer(board, joueur, Direction.UP)) {
			afficher(board, joueur);
			alerte();//détecter si le joueur repasse sur une case
			joueur.addMove();//ajouter le prochain déplacement
			joueur.addDirection(Direction.UP);//ajouter la direction prise à chaque
		}
	}
	public void down(ActionEvent e) {
		if(Player.avancer(board, joueur, Direction.DOWN)) {
			afficher(board, joueur);
			alerte();
			joueur.addMove();
			joueur.addDirection(Direction.DOWN);
		}
		
	}
	public void left(ActionEvent e) {
		if(Player.avancer(board, joueur, Direction.LEFT)) {
			afficher(board, joueur);
			alerte();
			joueur.addMove();
			joueur.addDirection(Direction.LEFT);
		}
	}
	public void right(ActionEvent e) {
		if(Player.avancer(board, joueur, Direction.RIGHT)) {
			afficher(board, joueur);
			alerte();
			joueur.addMove();
			joueur.addDirection(Direction.RIGHT);
		}
	}
	

	public void switchToMenu(ActionEvent event) throws IOException {//switch vers la page menu principal
		  root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void switchToGameName(ActionEvent event) throws IOException {//page ou l'on donne le nom de la partie
		if(partieEnCours) {//si la partie n'est pas terminé alors on peut sauvegarder.
			root = FXMLLoader.load(getClass().getResource("GameName.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		}
	}
	
	public static int[][] getBoard() {
		return board;
	}
	public static void setBoard(int[][] savedBoard) {
		 board = savedBoard;
	}
	
	public static Player getPlayer() {
		return joueur;
	}
	public static void setPlayer(Player savedJoueur) {
		 joueur = savedJoueur;
	}

	
	
	public void fin(Player j) {
		if(j.getX()== 9 && j.getY()== 9) {
			textfin.setText("Tu as gagné la partie ! Bravo !");
			distance.setText("Distance parcourue : " + j.getDistance() + "cases");
			energyLoss.setText("Energie perdue : " + j.getEnergyLoss());
			energyWin.setText("Enegie gagnée : " + j.getEnergyWin());
			partieEnCours = false;
		}
		else if (j.getFood() <= 0) {
			textfin.setText("Tu as perdu la partie, ton énergie est à 0 :(");
			partieEnCours = false;
		}
	}
	
	
	public void back(ActionEvent e) {
		if (partieEnCours == true) {//si la partie est en cours
			if(joueur.getMoves().size() == 1) {//si nous nous sommes déjà déplacé avant
				System.out.println("Impossible de retourner en arrière !");
	
			}else if(joueur.getNbDeRetour() < 6){// si on a fait moins de 6 coups ou 6 coups
				Player.back(board, joueur);
				joueur.setNbDeRetour(joueur.getNbDeRetour()+1);
				afficher(board, joueur);
			}else//sinon c'est que l'on a plus de coup possible
				System.out.println("Vous n'avez plus de coups possibles !");
		}
	}
	
	public void alerte() {
		boolean maxAlerte = true;
		for (int i = 0; i < joueur.getMoves().size(); i++) {
			if (joueur.getMoves().get(i).get(0) == joueur.getX() && joueur.getMoves().get(i).get(1) == joueur.getY() && maxAlerte) {//comparaison de la position du joueuroueur avec ses anciennes positions
				maxAlerte = false;//éviter les repetitions et prendre le plus vieux déplacement égal au coup actuel
				System.out.println("Vous repassez sur votre chemin !");
				
				for (int k = 1; k < joueur.getMoves().size() - i; k++)
					images[joueur.getMoves().get(k+i).get(0)][joueur.getMoves().get(k+i).get(1)].setImage(caseAlerte);
				
				images[joueur.getX()][joueur.getY()].setImage(personnage);//si par erreur l'algorithme ci dessus coloris 
				
			}
		}
		
	}
	


}
