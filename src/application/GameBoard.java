package application;

import java.util.Random;

public class GameBoard {
	//Fields
	public Cell[][] mineField;
	
	private int width;
	private int height;
	private int mineCount;
	
	//Constructors
	public GameBoard(int newWidth, int newHeight, int newMineCount){
		this.width = newWidth;
		this.height = newHeight;
		this.mineCount = newMineCount;
		initializeMineField();
		fillMineField();
		countNeighboringMines();
	}
	
	//Methods
	
	private void countNeighboringMines(){
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				int neighborCount = getNeighborCount(i, j);
				mineField[i][j].setNeighborCount((byte) neighborCount);
			}
		}
	}
	
	private int getNeighborCount(int row, int col){
		int neighboringMines = 0;
		
		if(row == 0 || col == 0 || row == width - 1 || col == height - 1){
			neighboringMines = handleEdgeCell(row, col);
		}
		else{
			neighboringMines = handleRegularCell(row, col);
		}
		
		return neighboringMines;
	}
	
	private int handleEdgeCell(int row, int col){
		int neighborCount;
		if(row == 0){
			
		}
		
		return -1;
	}
	
	/**
	 * Returns the count of neighboring mines for a non edge cell
	 * @param row - row to check
	 * @param col - column to check
	 * @return int - number of neighboring mines
	 */
	private int handleRegularCell(int row, int col){
		int neighboringMines = 0;
		if(mineField[row - 1][col - 1].getHasMine()){
			neighboringMines++;
		}
		if(mineField[row - 1][col].getHasMine()){
			neighboringMines++;
		}
		if(mineField[row - 1][col + 1].getHasMine()){
			neighboringMines++;
		}
		if(mineField[row][col - 1].getHasMine()){
			neighboringMines++;
		}
		if(mineField[row][col + 1].getHasMine()){
			neighboringMines++;
		}
		if(mineField[row + 1][col - 1].getHasMine()){
			neighboringMines++;
		}
		if(mineField[row + 1][col].getHasMine()){
			neighboringMines++;
		}
		if(mineField[row + 1][col + 1].getHasMine()){
			neighboringMines++;
		}
			
		return neighboringMines;
	}
	
	/**
	 * Randomly fills mineField with mines.
	 * @author kalenpw
	 */
	private void fillMineField(){		
		int placedMines = 0;
		
		while(placedMines < mineCount){
			int x = randIntInRange(0, width - 1);
			int y = randIntInRange(0, height - 1);
			
			if(!mineField[x][y].getHasMine()){
				mineField[x][y].setHasMine(true);
				placedMines++;
			}		
		}	
	}
	
	/**
	 * Initialize the minefield with a grid of empty cells
	 * @author kalenpw
	 */
	private void initializeMineField(){
		mineField = new Cell[width][height];
		for(int i = 0; i < width; i++){
			for(int j = 0; j < height; j++){
				mineField[i][j] = new Cell();
			}
		}
	}
	
	/**
	 * Returns a random int in the range inclusive
	 * @param min - minimum number 
	 * @param max - maximum number
	 * @return int - randomly selected int
	 * @author kalenpw
	 */
    private int randIntInRange(int min, int max){
    	Random rnd = new Random();
    	return rnd.nextInt((max - min) + 1);
    }

}
