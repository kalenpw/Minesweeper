package application;

import java.util.Random;

public class GameBoard {
	//Fields
	public Cell[][] mineField;
	
	//Constructors
	public GameBoard(int width, int height, int mineCount){
		mineField = createMineField(width, height, mineCount);
	}
	
	//Methods
	private Cell[][] createMineField(int width, int height, int mineCount){
		Cell[][] newMineField = new Cell[width][height];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				newMineField[i][j] = new Cell();
			}
		}
		int placedMines = 0;
		
		while(placedMines < mineCount){
			int x = randIntInRange(0, width - 1);
			int y = randIntInRange(0, height - 1);
			
			if(!newMineField[x][y].getHasMine()){
				newMineField[x][y].setHasMine(true);
				placedMines++;
			}
			
		}
		return newMineField;
	
	}
	
	
	
    private int randIntInRange(int min, int max){
    	Random rnd = new Random();
    	return rnd.nextInt((max - min) + 1);
    }

}
