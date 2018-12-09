/* GROUP 8
 * CO2001 User Interfaces & HCI Mini-project
 * Lukas Petkevicius - lp288
 * Mohammed Ahmed - mia17
 * MainControl Class
 */

package dice_game;

import java.io.File;
import java.io.IOException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

public class MainControl extends Application{
	

    @FXML
    private TextField player_name;
    
    @FXML
    private TextField player_name1;
    
    @FXML
    private ImageView logo;

  
    public void start(Stage primaryStage) throws IOException{
    	//Build and show the landing pane
		FXMLLoader loader=new FXMLLoader(getClass().getResource("Main.fxml"));
		Parent root=(Parent)loader.load();
		primaryStage.setScene(new Scene(root));
		primaryStage.show();	
	}

    @FXML
    void onPlayClicked(ActionEvent event) throws IOException {
    	//Get player names
    	String name1= player_name.getText();
    	String name2= player_name1.getText();
    	
    	//show the game pane
    	Stage stage=new Stage();
    	FXMLLoader loader=new FXMLLoader(getClass().getResource("Roll_Pane.fxml"));
		Parent root=(Parent)loader.load();
		RollControl sc =loader.getController();
		sc.setText(name1);
		sc.setText1(name2);
		
		stage.setScene(new Scene(root));
		stage.show();
    }
    
    @FXML
    void onHelpClicked(ActionEvent event) throws IOException {
    	Stage stage=new Stage();
    	stage.setTitle("Dice Game Tutorial");
		String videoFile = "video.mp4";    	 //Video File name
		
		//Add the help video file
		Media video = new Media(new File(videoFile).toURI().toString());
		MediaPlayer mediaPlayer = new MediaPlayer(video);
		mediaPlayer.setAutoPlay(true);
		MediaView mediaView = new MediaView(mediaPlayer);
		
		//add the video object to the pane
		StackPane p = new StackPane();
		p.setPrefSize(1280, 720);
		p.getChildren().add(mediaView);
		
		stage.setScene(new Scene(p, 1400, 800));
		stage.show();
    }    
    
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);

	}
	

}

