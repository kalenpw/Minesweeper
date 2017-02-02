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
    	
    	GameBoard game = new GameBoard(width, height, mineCount);
    	
    	GridPane gameBoard = new GridPane();
    	primaryStage.setTitle("MineSweeper");
    	//padding?
    	
    	
    	for(int row = 0; row < game.mineField.length; row++){
    		for(int col = 0; col < game.mineField[0].length; col++){
    			Button btn;
    			if(game.mineField[col][row].getHasMine()){
    				btn = new Button(game.mineField[col][row].getHasMine() + "");
    				btn.setBackground(new Background(new BackgroundFill(Color.CORNFLOWERBLUE, CornerRadii.EMPTY, Insets.EMPTY)));

    			}
    			else{
    				btn = new Button(game.mineField[col][row].getHasMine() + "");
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
      
 
    
    public void buttonClicked(ActionEvent event){
    	System.out.println("Test ");
    	Button clicked = (Button) event.getSource();
    	clicked.setText("Clicked");
    	clicked.setDisable(true);
    }

}
