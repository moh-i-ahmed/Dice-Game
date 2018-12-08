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

	@FXML
	private Label play_name;
	@FXML
	private Label play_name1;
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
	private Label mainScore;
	@FXML
	private Label newScore;
	@FXML
	private Label mainScore1;
	@FXML
	private Label newScore1;
	@FXML
	private Button roll1;
	@FXML
	private Button roll2;
	@FXML
	private Label round_count;
	
	
	Player p1 = new Player();
	Player p2 = new Player();

	
	
	@FXML
    public void close(){
        // get a handle to the stage
        Stage stage = (Stage) roll1.getScene().getWindow();
        // do what you have to do
        stage.close();
    }
	

	public void setText(String pl_name)
	{
		play_name.setText(pl_name);
		 p1.setName(pl_name);
	}

	public void setText1(String pl_name)
	{
		play_name1.setText(pl_name);
		 p2.setName(pl_name);
	}
	
	public String getScore()
	{
		return mainScore.getText();
	}
    
	Game game = new Game(p1, p2);
	
	
	
	
	@FXML
	void onRollPressed(ActionEvent event) {

		try {

			String musicFile = "roll_sound.mp3";     // For example

			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();

			Thread.sleep(700);
			
		}catch(Exception e) {}
		
		
		
		
		newScore.setText(Integer.toString(game.score(p1)));
		mainScore.setText(Integer.toString(p1.getPlayerScore()));
		
		
		Image img1 = new Image("file:"+ game.dice.getFirst() +".png");
		cube_1.setImage(img1);
		
		Image img2 = new Image("file:"+ game.dice.getSecond() +".png");
		cube_2.setImage(img2);
		
		Image img3 = new Image("file:"+ game.dice.getThird() +".png");
		cube_3.setImage(img3);
		
		
		roll1.setDisable(true);
		roll2.setDisable(false);
		
		round_count.setText(Integer.toString(game.turn()));

	}

	
	
	
	
	@FXML
	void onRollPressed1(ActionEvent event) {

		try {
			
			String musicFile = "roll_sound.mp3";     // For example

			Media sound = new Media(new File(musicFile).toURI().toString());
			MediaPlayer mediaPlayer = new MediaPlayer(sound);
			mediaPlayer.play();

			Thread.sleep(700);
			
		}catch(Exception e) {}
		
		
		
		newScore1.setText(Integer.toString(game.score(p2)));
		mainScore1.setText(Integer.toString(p2.getPlayerScore()));
		
		
		Image img1 = new Image("file:"+ game.dice.getFirst() +".png");
		cube_11.setImage(img1);
		
		Image img2 = new Image("file:"+ game.dice.getSecond() +".png");
		cube_21.setImage(img2);
		
		Image img3 = new Image("file:"+ game.dice.getThird() +".png");
		cube_31.setImage(img3);
		
		round_count.setText(Integer.toString(game.turn()));

		roll1.setDisable(false);
		roll2.setDisable(true);

	}















}
