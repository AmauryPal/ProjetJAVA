package application;
import java.util.*; 

public class Play {
	
public static void avancer(int[][] plat, Player j,int a) {
	
	if(j.getFood()<= 0)		{return;}
	
	if((a != 8 && a != 4 && a != 5 && a != 6) || 
					(j.getX() == 0 && a == 8) || (j.getX() == 9 && a ==5) || 
					(j.getY()== 0 && a ==4) || (j.getY()==9 && a ==6) ) {return;}
			
		if(j.getX()== 9 && j.getY()== 9) {return;}
		if(a == 8) {
			if (plat[j.getX()-1][j.getY()] == 0) {
				plat[j.getX()-1][j.getY()] = 3;
				plat[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() -10);
				j.setX(j.getX()-1);}
			else if (plat[j.getX()-1][j.getY()] == 1)	{
				
				plat[j.getX()-1][j.getY()] = 3;
				plat[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() + 10);
				j.setX(j.getX()-1);
				}
			else if(plat[j.getX()-1][j.getY()] == 2) {
				j.setFood(j.getFood() -10);
				}
			}
		
		if ( a == 5) {
			
			if (plat[j.getX()+1][j.getY()] == 0) {
				plat[j.getX()+1][j.getY()] = 3;
				plat[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() -10);
				j.setX(j.getX()+1);}
			else if (plat[j.getX()+1][j.getY()] == 1)	{
				
				plat[j.getX()+1][j.getY()] = 3;
				plat[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() + 10);
				j.setX(j.getX()+1);
				}
			else if(plat[j.getX()+1][j.getY()] == 2) {
				j.setFood(j.getFood() -10);
				}
			}
		
		if ( a == 4) {
			
			if (plat[j.getX()][j.getY()-1] == 0) {
				plat[j.getX()][j.getY()-1] = 3;
				plat[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() -10);
				j.setY(j.getY()-1);}
			else if (plat[j.getX()][j.getY()-1] == 1)	{
				
				plat[j.getX()][j.getY()-1] = 3;
				plat[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() + 10);
				j.setY(j.getY()-1);
				}
			else if(plat[j.getX()][j.getY()-1] == 2) {
				j.setFood(j.getFood() -10);
				}
			}
		if ( a == 6) {
			
		if (plat[j.getX()][j.getY()+1] == 0) {
				plat[j.getX()][j.getY()+1] = 3;
				plat[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() -10);
				j.setY(j.getY()+1);}
		else if (plat[j.getX()][j.getY()+1] == 1)	{
				
				plat[j.getX()][j.getY()+1] = 3;
				plat[j.getX()][j.getY()] = 0;
				j.setFood(j.getFood() + 10);
				j.setY(j.getY()+1);
				}
		else if(plat[j.getX()][j.getY()+1] == 2) {
				j.setFood(j.getFood() -10);
				
				}
			}

		
	}
	
}
	
	
