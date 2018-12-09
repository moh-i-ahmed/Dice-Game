/* GROUP 8
 * CO2001 User Interfaces & HCI Mini-project
 * Lukas Petkevicius - lp288
 * Mohammed Ahmed - mia17
 * RollControl Class
 */

package dice_game;

import java.io.File;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class RollControl {

	//Player name labels
	@FXML
	private Label p1_name;
	@FXML
	private Label p2_name;
	
	//Player Score Labels
	@FXML
	private Label p1_mainScore;
	@FXML
	private Label p1_newScore;
	@FXML
	private Label p2_mainScore;
	@FXML
	private Label p2_newScore;
	
	@FXML
	private ImageView cube_1;
	@FXML
	private ImageView cube_2;
	@FXML
	private ImageView cube_3;
	@FXML
	private ImageView cube_11;
	@FXML
	private ImageView cube_21;
	@FXML
	private ImageView cube_31;
	
	@FXML
	private Button btn_roll1;
	@FXML
	private Button btn_roll2;
	@FXML
	private Label round_count;
	
	//Create new Players and Game
	Player p1 = new Player();
	Player p2 = new Player();
	Game game = new Game(p1, p2);
	
	
	@FXML
    public void close(){
        // get a handle to the stage
        Stage stage = (Stage) btn_roll1.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
	

	public void setText(String pl_name){
		p1_name.setText(pl_name);
		p1.setName(pl_name);
	}

	public void setText1(String pl_name){
		p2_name.setText(pl_name);
		p2.setName(pl_name);
	}
	
	public String getScore(){
		return p1_mainScore.getText();
	}
	
	/*
	 * Method controlling Player1's roll
	 */
	@FXML
	void onRollPressed(ActionEvent event) {
		try {
			String musicFile = "resources/roll_sound.mp3";     //Audio file name
			
			//Add the dice roll audio file
			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();

			Thread.sleep(700);
			
		}catch(Exception e) {}
		
		//Display Player1's Scores
		p1_newScore.setText(Integer.toString(game.score(p1)));
		p1_mainScore.setText(Integer.toString(p1.getPlayerScore()));
		
		//Display dice images
		Image img1 = new Image("file:resources/"+ game.dice.getFirst() +".png");
		cube_1.setImage(img1);
		
		Image img2 = new Image("file:resources/"+ game.dice.getSecond() +".png");
		cube_2.setImage(img2);
		
		Image img3 = new Image("file:resources/"+ game.dice.getThird() +".png");
		cube_3.setImage(img3);
		
		btn_roll1.setDisable(true);
		btn_roll2.setDisable(false);
		
		round_count.setText(Integer.toString(game.turn()));
	}
	
	/*
	 * Method controlling Player2's roll
	 */
	@FXML
	void onRollPressed1(ActionEvent event) {
		try {
			String musicFile = "resources/roll_sound.mp3";     //Audio file name

			//Add the dice roll audio file
			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();

			Thread.sleep(700);
			
		}catch(Exception e) {}
	
		//Display Player2's Scores
		p2_newScore.setText(Integer.toString(game.score(p2)));
		p2_mainScore.setText(Integer.toString(p2.getPlayerScore()));

		//Display dice images
		Image img1 = new Image("file:resources/"+ game.dice.getFirst() +".png");
		cube_11.setImage(img1);

		Image img2 = new Image("file:resources/"+ game.dice.getSecond() +".png");
		cube_21.setImage(img2);

		Image img3 = new Image("file:resources/"+ game.dice.getThird() +".png");
		cube_31.setImage(img3);

		round_count.setText(Integer.toString(game.turn()));

		btn_roll1.setDisable(false);
		btn_roll2.setDisable(true);

	}

//End of class
}
