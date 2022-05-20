package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
	
	@FXML
	Image food = new Image("food.jpg");
	Image casevide = new Image("CaseVide.png");
	Image obstacle = new Image("Obstacle.jpg");
	Image personnage = new Image("Personnage.jpg");
	
	ImageView v1 = new ImageView(casevide);ImageView v2 = new ImageView(casevide);ImageView v3 = new ImageView(casevide);ImageView v4 = new ImageView(casevide);ImageView v5 = new ImageView(casevide);ImageView v6 = new ImageView(casevide);
	ImageView v7 = new ImageView(casevide);ImageView v8 = new ImageView(casevide);ImageView v9 = new ImageView(casevide);ImageView v10 = new ImageView(casevide);ImageView v11 = new ImageView(casevide);ImageView v12 = new ImageView(casevide);ImageView v13 = new ImageView(casevide);ImageView v14 = new ImageView(casevide);
	ImageView v15 = new ImageView(casevide);ImageView v16 = new ImageView(casevide);ImageView v17 = new ImageView(casevide);ImageView v18 = new ImageView(casevide);ImageView v19 = new ImageView(casevide);ImageView v20 = new ImageView(casevide);ImageView v21 = new ImageView(casevide);ImageView v22 = new ImageView(casevide);ImageView v23 = new ImageView(casevide);
	ImageView v24 = new ImageView(casevide);ImageView v25 = new ImageView(casevide);ImageView v26 = new ImageView(casevide);ImageView v27 = new ImageView(casevide);ImageView v28 = new ImageView(casevide);ImageView v29 = new ImageView(casevide);ImageView v30 = new ImageView(casevide);ImageView v31 = new ImageView(casevide);
	ImageView v32 = new ImageView(casevide);ImageView v33 = new ImageView(casevide);ImageView v34 = new ImageView(casevide);ImageView v35 = new ImageView(casevide);ImageView v36 = new ImageView(casevide);ImageView v37 = new ImageView(casevide);ImageView v38 = new ImageView(casevide);ImageView v39 = new ImageView(casevide);ImageView v40 = new ImageView(casevide);
	ImageView v41 = new ImageView(casevide);ImageView v42 = new ImageView(casevide);ImageView v43 = new ImageView(casevide);ImageView v44 = new ImageView(casevide);ImageView v45 = new ImageView(casevide);ImageView v46 = new ImageView(casevide);ImageView v47 = new ImageView(casevide);ImageView v48 = new ImageView(casevide);ImageView v49 = new ImageView(casevide);ImageView v50 = new ImageView(casevide);
	ImageView v51 = new ImageView(casevide);ImageView v52 = new ImageView(casevide);ImageView v53 = new ImageView(casevide);ImageView v54 = new ImageView(casevide);
	ImageView v55 = new ImageView(casevide);ImageView v56 = new ImageView(casevide);ImageView v57 = new ImageView(casevide);ImageView v58 = new ImageView(casevide);ImageView v59 = new ImageView(casevide);ImageView v60 = new ImageView(casevide);ImageView v61 = new ImageView(casevide);ImageView v62 = new ImageView(casevide);
	ImageView v63 = new ImageView(casevide);ImageView v64 = new ImageView(casevide);ImageView v65 = new ImageView(casevide);ImageView v66 = new ImageView(casevide);
	ImageView v67 = new ImageView(casevide);ImageView v68 = new ImageView(casevide);ImageView v69 = new ImageView(casevide);ImageView v70 = new ImageView(casevide);ImageView v71 = new ImageView(casevide);ImageView v72 = new ImageView(casevide);ImageView v73 = new ImageView(casevide);
	ImageView v74 = new ImageView(casevide);ImageView v75 = new ImageView(casevide);ImageView v76 = new ImageView(casevide);ImageView v77 = new ImageView(casevide);
	ImageView v78 = new ImageView(casevide);ImageView v79 = new ImageView(casevide);ImageView v80 = new ImageView(casevide);ImageView v81 = new ImageView(casevide);ImageView v82 = new ImageView(casevide);
	ImageView v83 = new ImageView(casevide);ImageView v84 = new ImageView(casevide);ImageView v85 = new ImageView(casevide);ImageView v86 = new ImageView(casevide);ImageView v87 = new ImageView(casevide);ImageView v88 = new ImageView(casevide);
	ImageView v89 = new ImageView(casevide);ImageView v90 = new ImageView(casevide);ImageView v91 = new ImageView(casevide);ImageView v92 = new ImageView(casevide);ImageView v93 = new ImageView(casevide);ImageView v94 = new ImageView(casevide);ImageView v95 = new ImageView(casevide);ImageView v96 = new ImageView(casevide);ImageView v97 = new ImageView(casevide);ImageView v98 = new ImageView(casevide);ImageView v99 = new ImageView(casevide);ImageView v100 = new ImageView(casevide);
	 ImageView[][] images= {{v1,v2,v3,v4,v5,v6,v7,v8,v9,v10},
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
	
	int[][] board = new int[10][10]; //LE TABLEAU 
	
	Player joueur = new Player(400); // JOUEUR 
	
	public void afficher(int[][] tabl, Player joueur) {
		int i;
		int j;
		
		for (i=0; i<10; i++ ) { 
			for(j=0; j<10; j++) {
		
				if(tabl[i][j]== 1)
					images[i][j].setImage(food);
				else if(tabl[i][j] == 2) 
					images[i][j].setImage(obstacle);
				else if(tabl[i][j]== 3)
					images[i][j].setImage(personnage);
				else
					images[i][j].setImage(casevide);

		
			energie.setText("Energie en stock: "+joueur.getFood());
			Fin(joueur);
			}
		}
	}
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	
	
	public void go(ActionEvent event) throws IOException{
		
		
		
		Board plateau = new Board(10, 5, 5);
		Board.Creer(board, plateau);
		
		int i;
		int j;
		for ( i=0; i<10; i++) {
			for ( j=0; j<10;j++) {
				images[i][j].setFitHeight(60);
				images[i][j].setFitWidth(60);
				grid.add(images[i][j], j, i, 1, 1);
			}
		}
		board[0][0]=3;
		afficher(board, joueur);
		
		
	}
	
	public void up(ActionEvent e) {
		Play.avancer(board, joueur, 8);
		afficher(board, joueur);
	}
	public void down(ActionEvent e) {
		Play.avancer(board, joueur, 5);
		afficher(board, joueur);
	}
	public void left(ActionEvent e) {
		Play.avancer(board, joueur, 4);
		afficher(board, joueur);
	}
	public void right(ActionEvent e) {
		Play.avancer(board, joueur, 6);
		afficher(board, joueur);
	}
	
	public void switchToMenu(ActionEvent event) throws IOException {
		  root = FXMLLoader.load(getClass().getResource("Menu.fxml"));
		  stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public Text textfin = new Text();
	public void Fin(Player j) {
		
		if(j.getX()== 9 && j.getY()== 9)
			textfin.setText("Tu as gagné la partie ! Bravo !");
		
		else if (j.getFood() <= 0) 
			textfin.setText("Tu as perdu la partie, ton énergie est à 0 :(");
	}

}
