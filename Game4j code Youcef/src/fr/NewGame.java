package fr;

public class NewGame {
	public static void NewGame() {
	
	Board plateau = new Board(10,10,10);
	
	
	int[][] tab = {{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0}
			};
	
	Board.Creer(tab, plateau);
	tab[0][0]= 3;
	
	Player joueur = new Player();
	
	Play.play(tab, joueur);
}
}