import java.util.Random;

public class CreateMap {
	// Initialiser une carte par d�faut ou toutes les routes sont bloqu�es;
	// La rang�e de lignes repr�sente le nombre de lignes de la grille et il y'a les murs entre les grilles de sorte que la taille finale du tableau � 2 dimension soit en fait (2 * row + 1) * (2 * column + 1); 
	
	private int row;
	private int column;
	
	public int[][] map; // Tableau pour stock le labyrinthe;
	// private Vector[] Pos;
	private int r;
	private int c;
	
	CreateMap(int r0, int c0) {
		row = r0;
		column = c0;
		r = 2 * row + 1;
		c = 2* column + 1;
		
		map = new int[r][c];
	}
	
	public void Init() {
		
		for (int i = 0; i < r; i++) // Faire tous les murs de la grille;
			for (int j = 0; j < c; j++)
				map[i][j] = 0; // pour le mur 1 de la route;
		
		// La grille du milieu est d�finie sur 1;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				map[2 * i + 1][2 * j + 1] = 1; //
		
		// Algo de Prim;
		accLabPrime();
	}
	
	// Traiter le tableau avec l'algo de Prim pour g�n�rer le labyrinthe final;
	// Id�es: ;
	// Trouver al�atoirement le point le plus proche � visiter (chaque point n'est visit� qu'une seule fois jusqu'� ce que toutes les routes soient visit�es;
	// Une route qui visite tous les points (non ordonn�s) sera g�n�r�e. Lors de la recherche al�atoire du point usivant, le mur entre les deux grilles adjacentes sera ouvert;

	public void accLabPrime() {
		//acc stocke la file d'attente consult�e, noacc stocke la file d'attente non consult�e;
		int[] acc, noacc;
		int count = row * column;
		int accsize = 0;
		
		acc = new int[count];
		noacc = new int[count];
		
		// Decalage dans chaque direction 0 gauche, 1 droite, 3 haut, 2 bas;
		
		int[] offR = { -1, 1, 0, 0};
		int[] offC = { 0, 0, 1, -1};
		
		// Le d�calage dans quatre directions est � gauche et � droite de haut en bas;
		int[] offS = { -1, 1, row, -row}; // Monter et descendre = changement de ligne;
		// Initialiser acc pour visit�, noacc pour non visit�;
		for (int i = 0; i < count; i++) {
			acc[i] = 0;
			noacc[i] = 0;
		}
	
		// Point de d�part;
		Random rd = new Random();
				acc[0] = rd.nextInt(count); // Point de d�part;
		
		int pos = acc[0];
		// D�pot du premier point;
		noacc[pos] = 1;
		while (accsize < count) {
			// Retirer le point courant;
			int x = pos % row;
			int y = pos /row; //
			int offpos = -1; //
			int w = 0;
			// Essaie les quatre directions jusqu'� avoir travers�
			while (++w < 5) {
				// Acc�s al�atoire au point le plus proche
				int point = rd.nextInt(4); // 0-3
				int repos;
				int move_x, move_y;
				// Calculer la position mobile
				repos = pos + offS[point]; //
				move_x = x + offR[point]; //
				move_y = y + offC[point]; //
				// D�termine si le changement est l�gal
				if (move_y >= 0 && move_x >= 0 && move_x < row && move_y < column && repos >= 0 && repos < count && noacc[repos] != 1) {
					noacc[repos] = 1; // Marquer le point comme visit�
					acc[++accsize] = repos; // R�pr�sente le nombre de points visit�s, repos repr�sente l'indice du point
					pos = repos; // Prend ce point comme nouveau point de d�part
					offpos = point;
					// Place 1 au milieu des grilles adjacentes
					
					map[2 * x + 1 + offR[point]][2 * y + 1 + offC[point]] = 1;
					break;
				} else {
					if (accsize == count - 1)
						return;
					continue;
				}
			}
			if (offpos < 0) { // Il n'y a pas moyen de tourner alors, alors trouve un nouveau point de d�part � partir de la route parcourue
				pos = acc[rd.nextInt(accsize + 1)];}
		}
	}
}



