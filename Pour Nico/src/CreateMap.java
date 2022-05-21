import java.util.Random;

public class CreateMap {
	// Initialiser une carte par défaut ou toutes les routes sont bloquées;
	// La rangée de lignes représente le nombre de lignes de la grille et il y'a les murs entre les grilles de sorte que la taille finale du tableau à 2 dimension soit en fait (2 * row + 1) * (2 * column + 1); 
	
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
		
		// La grille du milieu est définie sur 1;
		for (int i = 0; i < row; i++)
			for (int j = 0; j < column; j++)
				map[2 * i + 1][2 * j + 1] = 1; //
		
		// Algo de Prim;
		accLabPrime();
	}
	
	// Traiter le tableau avec l'algo de Prim pour générer le labyrinthe final;
	// Idées: ;
	// Trouver aléatoirement le point le plus proche à visiter (chaque point n'est visité qu'une seule fois jusqu'à ce que toutes les routes soient visitées;
	// Une route qui visite tous les points (non ordonnés) sera générée. Lors de la recherche aléatoire du point usivant, le mur entre les deux grilles adjacentes sera ouvert;

	public void accLabPrime() {
		//acc stocke la file d'attente consultée, noacc stocke la file d'attente non consultée;
		int[] acc, noacc;
		int count = row * column;
		int accsize = 0;
		
		acc = new int[count];
		noacc = new int[count];
		
		// Decalage dans chaque direction 0 gauche, 1 droite, 3 haut, 2 bas;
		
		int[] offR = { -1, 1, 0, 0};
		int[] offC = { 0, 0, 1, -1};
		
		// Le décalage dans quatre directions est à gauche et à droite de haut en bas;
		int[] offS = { -1, 1, row, -row}; // Monter et descendre = changement de ligne;
		// Initialiser acc pour visité, noacc pour non visité;
		for (int i = 0; i < count; i++) {
			acc[i] = 0;
			noacc[i] = 0;
		}
	
		// Point de départ;
		Random rd = new Random();
				acc[0] = rd.nextInt(count); // Point de départ;
		
		int pos = acc[0];
		// Dépot du premier point;
		noacc[pos] = 1;
		while (accsize < count) {
			// Retirer le point courant;
			int x = pos % row;
			int y = pos /row; //
			int offpos = -1; //
			int w = 0;
			// Essaie les quatre directions jusqu'à avoir traversé
			while (++w < 5) {
				// Accès aléatoire au point le plus proche
				int point = rd.nextInt(4); // 0-3
				int repos;
				int move_x, move_y;
				// Calculer la position mobile
				repos = pos + offS[point]; //
				move_x = x + offR[point]; //
				move_y = y + offC[point]; //
				// Détermine si le changement est légal
				if (move_y >= 0 && move_x >= 0 && move_x < row && move_y < column && repos >= 0 && repos < count && noacc[repos] != 1) {
					noacc[repos] = 1; // Marquer le point comme visité
					acc[++accsize] = repos; // Réprésente le nombre de points visités, repos représente l'indice du point
					pos = repos; // Prend ce point comme nouveau point de départ
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
			if (offpos < 0) { // Il n'y a pas moyen de tourner alors, alors trouve un nouveau point de départ à partir de la route parcourue
				pos = acc[rd.nextInt(accsize + 1)];}
		}
	}
}



