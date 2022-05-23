package application;
import java.io.Serializable;
import java.util.Random;

@SuppressWarnings("serial")
public class Board implements Serializable {
	
	private int Lenght;
	private int Obstacle;
	private int Food;
	
	public Board(int Lenght, int Food, int Obstacle) { 
		this.Lenght = Lenght;
		this.Obstacle = Obstacle;
		this.Food = Food;
	}

	public int getLenght() {
		return Lenght;
	}

	public void setLenght(int lenght) {
		Lenght = lenght;
	}

	public int getObstacle() {
		return Obstacle;
	}

	public void setObstacle(int obstacle) {
		Obstacle = obstacle;
	}

	public int getFood() {
		return Food;
	}

	public void setFood(int food) {
		Food = food;
	}
	
	

	
	public static void Creer(int[][] plateau, Board Tab){
		Random random = new Random();	
		int a = Tab.getFood();
		int b = a + Tab.getObstacle();
		
		for ( int i=0; i < Tab.getLenght(); i++) {
			for ( int j=0; j < Tab.getLenght(); j++) {
				int x = random.nextInt(100);
				if (x <= a) { 
					plateau[i][j] = 1;
				}else if (a<x && x<= b) { 
					plateau[i][j] = 2;
				}else
					plateau[i][j] = 0;
			}
		}
		plateau[0][0] = 3;
		plateau[9][9] = 0;
	}
}
