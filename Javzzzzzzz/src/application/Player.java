package application;

public class Player {
	
	private int food = 400;
	private int x = 0;
	private int y = 0;
	
	public Player(int f) { 
		this.setFood(f);
		
	}
	
	
	
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

}
