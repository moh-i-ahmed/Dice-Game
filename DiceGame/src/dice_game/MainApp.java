package dice_game;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application{
	public void start(Stage primaryStage) throws IOException
	{
		FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root=(Parent)loader.load();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}

}
