package dice_game;

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
    	 
    	 
    	 
    	 if(rollDice[0] == rollDice[1]) {
    		 score = score + rollDice[0] + rollDice[1];
    		 newScore.setText(Integer.toString(rollDice[0] + rollDice[1]));
    		 mainScore.setText(Integer.toString(score));
    	 }
    	 else if (rollDice[1] == rollDice[2]) {
    		 score = score + rollDice[1] + rollDice[2];
    		 newScore.setText(Integer.toString(rollDice[1] + rollDice[2]));
    		 mainScore.setText(Integer.toString(score));
    	 }
    	 else if (rollDice[0] == rollDice[2]) {
    		 score = score + rollDice[0] + rollDice[2];
    		 newScore.setText(Integer.toString(rollDice[0] + rollDice[2]));
    		 mainScore.setText(Integer.toString(score));
    	 }
    	 
    	 if(rollDice[0] == rollDice[1] && rollDice[1] == rollDice[2])
    	 {
    		 score = score + rollDice[0] * 3;
    		 newScore.setText(Integer.toString(rollDice[0] * 3));
    		 mainScore.setText(Integer.toString(score));
    	 }
    	 
    	 if(rollDice[0] != rollDice[1] && rollDice[1] != rollDice[2] && rollDice[0] != rollDice[2])
    	 {
    		 score = score + 1;
    		 newScore.setText(Integer.toString(1));
    		 mainScore.setText(Integer.toString(score));
    	 }
    	 
    	 
    	 
    	 
    	 
    	
    	String first = Integer.toString(rollDice[0]);
    	String second = Integer.toString(rollDice[1]);
    	String third = Integer.toString(rollDice[1]);
    	
    	cube_1.setText(first);
    	cube_2.setText(second);
    	cube_3.setText(third);
    	
    	
    	
    	
    	
    	
    	
    	
    }
}
