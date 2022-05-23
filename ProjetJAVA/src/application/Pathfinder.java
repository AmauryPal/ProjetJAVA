package application;

import java.util.List;

public class Pathfinder {
	
    public static boolean searchPath(int[][] board, int x, int y, List<Integer> path) {
    	
        if (board[y][x] == 9) { // on vérifie si la case finale est atteinte
            path.add(x);
            path.add(y);
            return true;
        }
    	
    	
    	if (board[y][x] == 0 || board[y][x] == 2) { // on note que la case a été visité
    		
    		board[y][x] = 4;
    		
    	
    		int dx = -1; // Visite récursive de tous les voisins
            int dy = 0;
            
            if (searchPath(board, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 1;
            dy = 0;
            if (searchPath(board, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = -1;
            if (searchPath(board, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }

            dx = 0;
            dy = 1;
            if (searchPath(board, x + dx, y + dy, path)) {
                path.add(x);
                path.add(y);
                return true;
            }
    	
    	
    	}
    	
    	return false;
    
    }

}
