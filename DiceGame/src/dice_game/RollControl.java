package dice_game;

import java.util.Arrays;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class RollControl {

    @FXML
    private Label play_name;
    @FXML
    private Label cube_1;
    @FXML
    private Label cube_2;
    @FXML
    private Label cube_3;
    @FXML
    private Label mainScore;
    @FXML
    private Label newScore;
    
    public void setText(String pl_name)
    {
    	play_name.setText(pl_name);
    }

    
    
    @FXML
    void onRollPressed(ActionEvent event) {
    	 
    	Dice dices = new Dice(6);
    	
    	int [] rollDice=new int[3];
    	 for(int i=0;i<3;i++)
    	 {
    	 rollDice[i]=dices.rollDice(6);
    	 }
    	 
    	 
    	 int score = Integer.parseInt(mainScore.getText());
    	 
    	 int scores = 0;
    	 boolean flag = true;
    	 int first = rollDice[0];
    	 for(int i = 1; i < 3 && flag; i++)
    	 {
    	 if (rollDice[i] != first) flag = false;

    	 }
    	 if (flag)
    	 scores= rollDice[0] +  rollDice[1] + rollDice[2];
    	 else
    	 {
    	 Arrays.sort(rollDice);
    	 if (rollDice[0] == rollDice[1])
    	 scores = rollDice[0] + rollDice[1];
    	 else if (rollDice[1] == rollDice[2])
    	 scores = rollDice[1] + rollDice[2];
    	 else
    	 scores=1;

    	 }

    	 newScore.setText(Integer.toString(scores));
    	 mainScore.setText(Integer.toString(score + scores));
    	 
    	 
    	 
    	
    	String firstt = Integer.toString(rollDice[0]);
    	String second = Integer.toString(rollDice[1]);
    	String third = Integer.toString(rollDice[2]);
    	
    	cube_1.setText(firstt);
    	cube_2.setText(second);
    	cube_3.setText(third);
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
