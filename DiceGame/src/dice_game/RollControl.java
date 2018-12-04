package dice_game;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class RollControl {

	@FXML
	private Label play_name;
	@FXML
	private Label play_name1;
	@FXML
	private Label cube_1;
	@FXML
	private Label cube_2;
	@FXML
	private Label cube_3;
	@FXML
	private Label cube_11;
	@FXML
	private Label cube_21;
	@FXML
	private Label cube_31;
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

		newScore.setText(Integer.toString(game.score(p1)));
		mainScore.setText(Integer.toString(p1.getPlayerScore()));
		
		cube_1.setText(Integer.toString(game.dice.getFirst()));
		cube_2.setText(Integer.toString(game.dice.getSecond()));
		cube_3.setText(Integer.toString(game.dice.getThird()));
		
		roll1.setDisable(true);
		roll2.setDisable(false);
		
		round_count.setText(Integer.toString(game.turn()));

	}

	
	
	
	
	@FXML
	void onRollPressed1(ActionEvent event) {

		newScore1.setText(Integer.toString(game.score(p2)));
		mainScore1.setText(Integer.toString(p2.getPlayerScore()));
		
		cube_11.setText(Integer.toString(game.dice.getFirst()));
		cube_21.setText(Integer.toString(game.dice.getSecond()));
		cube_31.setText(Integer.toString(game.dice.getThird()));
		
		round_count.setText(Integer.toString(game.turn()));

		roll1.setDisable(false);
		roll2.setDisable(true);

	}















}
