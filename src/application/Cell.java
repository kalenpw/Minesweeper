package application;

public class Cell {
	//Fields
	private boolean hasMine;
	private byte neighborCount;
	
	//Constructors
	public Cell(){
		hasMine = false;
		neighborCount = 0;
		
	}
	
	//Getters & setters
	public boolean getHasMine(){
		return hasMine;
	}
	public void setHasMine(boolean value){
		hasMine = value;
	}
	
	public byte getNeighborCount(){
		return neighborCount;
	}
	public void setNeighborCount(byte value){
		neighborCount = value;
	}
	
	
}
