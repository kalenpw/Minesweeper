package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Popup extends Application {
	Label text;
	Button btn;
	Stage previousStage;
	Stage newStage;
	FlowPane panel;
	Scene scene;
	
	@Override
	public void start(Stage primaryStage){
		previousStage = primaryStage;
		newStage = new Stage();
		text = new Label("Game over!");
		btn = new Button("Close");
		btn.setOnAction((event) -> {
			System.out.print("clicked");
			newStage.close();
		});
		
		panel = new FlowPane();
		panel.getChildren().addAll(text, btn);
		
		scene = new Scene(panel, 200, 100);
		//stg.initModality(Modality.APPLICATION_MODAL);
		//previousStage.setTitle("Game over");
		//previousStage.setScene(scene);
		//previousStage.show();
		
		newStage.setTitle("Game over");
		newStage.setScene(scene);
		newStage.show();
		
	}
}
