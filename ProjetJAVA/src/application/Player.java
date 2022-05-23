package application;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;

@SuppressWarnings("serial")
public class Player implements Serializable{
	
	private String gameName = "Game4J";
	private int food = 400;
	private int x = 0;
	private int y = 0;
	private int distance = 0;
	private int energyWin = 0;
	private int energyLoss = 0;
	private int nbDeRetour = 0;
	private String startDate;
	private String startTime;
	private String stopTime;
	private Date fullDate = new Date();
	

	ArrayList<Direction> directions = new ArrayList<Direction>();
	ArrayList<ArrayList<Integer>> moves = new ArrayList<ArrayList<Integer>>();
	
	public Player(int food) { 
		this.setFood(food);
		addMove();//ajouter 1ere case
		
		setStartDate("Date : " + LocalDate.now().toString());//set les dates/heures
		DateTimeFormatter FormatObj  = DateTimeFormatter.ofPattern("HH:mm:ss");
		LocalTime temp = LocalTime.now();
		setStartTime(temp.format(FormatObj));
		
	}
	
	public void addDirection(Direction DIRECTION) {
		directions.add(DIRECTION);
	}

	
	public ArrayList<Direction> getDirections() {
		return directions;
	}
	
	
	public void removeLastMove() {
		moves.remove(moves.size()-1);
	}
	
	public ArrayList<ArrayList<Integer>> getMoves() {
		return moves;
		
	}
	
	public void addMove() {
		ArrayList<Integer> newMove = new ArrayList<Integer>(2);
		newMove.add(x);
		newMove.add(y);
		newMove.add(food);
		this.moves.add(newMove);
	}
	
			
	public static boolean avancer(int[][] board, Player j, Direction dir) {// avancer d'une case
		
		if(j.getFood()<= 0)
			return false;
		
		if((dir != Direction.UP && dir != Direction.LEFT && dir != Direction.DOWN && dir != Direction.RIGHT) || (j.getX() == 0 && dir == Direction.UP) || (j.getX() == 9 && dir ==Direction.DOWN) || (j.getY()== 0 && dir ==Direction.LEFT) || (j.getY()==9 && dir ==Direction.RIGHT))
			return false;
				
		if(j.getX()== 9 && j.getY()== 9)
			return false;
		
		if(dir == Direction.UP) {
			if (board[j.getX()-1][j.getY()] == 0 || board[j.getX()-1][j.getY()] == 5) {
				board[j.getX()-1][j.getY()] = 3;
				board[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() -10);
				j.setX(j.getX()-1);
				j.setDistance(j.getDistance() + 1);
				j.setEnergyLoss(j.getEnergyLoss() + 10);
			}
			else if (board[j.getX()-1][j.getY()] == 1)	{
				
				board[j.getX()-1][j.getY()] = 3;
				board[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() + 10);
				j.setX(j.getX() - 1);
				j.setDistance(j.getDistance() + 1);
				j.setEnergyWin(j.getEnergyWin() + 10);
				
			}
			else if(board[j.getX()-1][j.getY()] == 2) {
				j.setFood(j.getFood() - 20);
				j.setEnergyLoss(j.getEnergyLoss() + 20);
			}
		}
		
		if (dir == Direction.DOWN) {
			
			if (board[j.getX()+1][j.getY()] == 0 || board[j.getX()+1][j.getY()] == 5) {
				board[j.getX()+1][j.getY()] = 3;
				board[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() -10);
				j.setX(j.getX() + 1);
				j.setDistance(j.getDistance() + 1);
				j.setEnergyLoss(j.getEnergyLoss() + 10);
			}
			else if (board[j.getX()+1][j.getY()] == 1)	{
				
				board[j.getX()+1][j.getY()] = 3;
				board[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() + 10);
				j.setX(j.getX()+1);
				j.setDistance(j.getDistance() + 1);
				j.setEnergyWin(j.getEnergyWin() + 10);
			}
			else if(board[j.getX()+1][j.getY()] == 2) {
				j.setFood(j.getFood() - 20);
				j.setEnergyLoss(j.getEnergyLoss() + 20);
			}
		}
		
		if (dir == Direction.LEFT) {
			
			if (board[j.getX()][j.getY()-1] == 0 || board[j.getX()][j.getY()-1] == 5) {
				board[j.getX()][j.getY()-1] = 3;
				board[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() - 10);
				j.setY(j.getY()-1);
				j.setDistance(j.getDistance() + 1);
				j.setEnergyLoss(j.getEnergyLoss() + 10);
			}
			else if (board[j.getX()][j.getY()-1] == 1)	{
				
				board[j.getX()][j.getY()-1] = 3;
				board[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() + 10);
				j.setY(j.getY()-1);
				j.setDistance(j.getDistance() + 1);
				j.setEnergyWin(j.getEnergyWin() + 10);
			}
			else if(board[j.getX()][j.getY()-1] == 2) {
				j.setFood(j.getFood() - 20);
				j.setEnergyLoss(j.getEnergyLoss() + 20);
			}
		}
		if (dir == Direction.RIGHT) {
			
			if (board[j.getX()][j.getY()+1] == 0 || board[j.getX()][j.getY()+1] == 5) {
				board[j.getX()][j.getY()+1] = 3;
				board[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() -10);
				j.setY(j.getY()+1);
				j.setDistance(j.getDistance() + 1);
				j.setEnergyLoss(j.getEnergyLoss() + 10);
			}
			else if (board[j.getX()][j.getY()+1] == 1)	{
					
				board[j.getX()][j.getY()+1] = 3;
				board[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() + 10);
				j.setY(j.getY()+1);
				j.setDistance(j.getDistance() + 1);
				j.setEnergyWin(j.getEnergyWin() + 10);
			}
			else if(board[j.getX()][j.getY()+1] == 2) {
				j.setFood(j.getFood() - 20);
				j.setEnergyLoss(j.getEnergyLoss() + 20);
			}
		}
		return true;


	}

	
	public static void back(int[][] board, Player j) {//retour en arrière

		
		if(j.moves.get(j.moves.size()-1).get(2) - j.moves.get(j.moves.size()-2).get(2) == 10) {//si l'énergie à la derniere position - position actuelle égal au plus 1à d'énergie 
			board[j.getX()][j.getY()] = 1;													   //alors la case est de l'énergie
		}else if(j.moves.get(j.moves.size()-1).get(2) - j.moves.get(j.moves.size()-2).get(2) == -20) {//si l'énergie à la derniere position - position actuelle égal au plus 1à d'énergie
			board[j.getX()][j.getY()] = 2;													  		  //alors la case est un obstacle
		}else
			board[j.getX()][j.getY()] = 0;
		j.removeLastMove();
		j.setX(j.getMoves().get(j.getMoves().size()-1).get(0));//set x à la position précédente
		j.setY(j.getMoves().get(j.getMoves().size()-1).get(1));//set y à la position précédente
		board[j.getX()][j.getY()] = 3;//set dans le board à la position précédente (les coordonnées du joueur sont déjà actualisés au dernier move)
		j.setFood(j.getMoves().get(j.getMoves().size()-1).get(2));//set food à sa quantité précédente

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
	
	private int[][] boardInit= new int[10][10];
	
	public int[][] getBoardInit() {
		return boardInit;
	}

	public void setBoardinit(int[][] boardInit) {
//		this.boardInit = boardInit;
		for (int i = 0; i < boardInit.length; i++) {
			for (int j = 0; j < boardInit.length; j++) {
				this.boardInit[i][j] = boardInit[i][j];
			}
		}
	}
	
	
	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}



	public int getEnergyWin() {
		return energyWin;
	}

	public void setEnergyWin(int energyWin) {
		this.energyWin = energyWin;
	}



	public int getEnergyLoss() {
		return energyLoss;
	}

	public void setEnergyLoss(int energyLoss) {
		this.energyLoss = energyLoss;
	}

	
	public int getNbDeRetour() {
		return nbDeRetour;
	}

	public void setNbDeRetour(int nbDeRetour) {
		this.nbDeRetour = nbDeRetour;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}
	
	public String getStopTime() {
		return stopTime;
	}

	public void setStopTime(String stopTime) {
		this.stopTime = stopTime;
	}

	public String getStartDate() {
		
		return startDate;
	}

	public String getStartTime() {
		return startTime;
	}
	
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public Date getFullDate() {
		return fullDate;
	}

	public void setFullDate(Date fullDate) {
		this.fullDate = fullDate;
	}


}
