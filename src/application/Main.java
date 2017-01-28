//@kalenpw
//Minesweeper game


package application;

import java.awt.ScrollPane;
import java.io.IOException;
import java.util.Random;

import com.sun.javafx.logging.Logger;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	//TODO get mine details from user
    	int width = 10;
    	int height = 10;
    	int mineCount = 10;
    	boolean[][] mineField = createMineField(width, height, mineCount);
    	
    	GridPane gameBoard = new GridPane();
    	primaryStage.setTitle("MineSweeper");
    	//padding?
    	
    	int boardWidth = 10;
    	int boardHeight = 10;
    	
    	for(int row = 0; row < mineField.length; row++){
    		for(int col = 0; col < mineField[0].length; col++){
    			Button btn;
    			if(mineField[col][row] == true){
    				btn = new Button(debug(true));
    				btn.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));
    			}
    			else{
    				btn = new Button(String.valueOf(debug(false)));
    			}
    			btn.setOnAction((event) -> {
    			    buttonClicked(event);
    			});
    			gameBoard.add(btn, col, row);
    	
    		}
    	}
    	
    	Scene scene = new Scene(gameBoard);
    	primaryStage.setScene(scene);
    	primaryStage.show();
    }
    
    public String debug(boolean bool){
    	if(bool) return "True";
    	else return "false";
    }
    
    /*
     * 
     * 
     */
    private boolean[][] createMineField(int width, int height, int totalMines){
    	boolean[][] returnArray = new boolean[width][height];
    	Random rnd = new Random();
    	int placedMines = 0;
    	
    	while(placedMines < totalMines){
    		int x = randIntInRange(0, width - 1);
    		int y = randIntInRange(0, height - 1);
    		
    		returnArray[x][y] = true;
    		placedMines ++;	
    	}
    	return returnArray;
    }
    
    private int randIntInRange(int min, int max){
    	Random rnd = new Random();
    	return rnd.nextInt((max - min) + 1);
    }
    
    
    public void buttonClicked(ActionEvent event){
    	System.out.println("Hello fuck face");
    	Button clicked = (Button) event.getSource();
    	clicked.setText("Clicked");
    	clicked.setDisable(true);
    }

}
