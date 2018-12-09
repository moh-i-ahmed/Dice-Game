/* GROUP 8
 * CO2001 User Interfaces & HCI Mini-project
 * Lukas Petkevicius - lp288
 * Mohammed Ahmed - mia17
 * Game Class
 */

package dice_game;

import java.util.Arrays;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;


public class Game {
	
	final int MAX = 40;		//Max Score of the Game
	
	//Player Variables
	private static Player player1;
	private static Player player2;
	
	private int count;		//Variable that tracks rounds
	int [] rolls;			//Variable to store rolls
	Dice dice = new Dice(); //Instantiate new dice class object
	
	//Build the Game
	public Game(Player p1, Player p2) {
		player1 = p1;
		player2 = p2;
		count = 1;
	}
	
	int a=1;
	
	//Method that controls Player Turn
	public int turn() {
		if(a == 2) {
			if(draw(player1, player2)) {
				
			}
			else {
				winner(player1);
				winner(player2);
			}	
			count++;
			a = 0;
		}
		a++;
		
		return count;
	}
	
    //Determining if there's a Draw
    private boolean draw(Player player1, Player player2){
        if((winner(player1) == true) && (winner(player2) == true)){
            System.out.println("The game is a draw... :(");
            return true;
        }
        else{
            return false;
        }
    }
    
    //Determining the Winner
    private boolean winner(Player player){
        if(player.getPlayerScore() >= MAX){
            RollControl cont = new RollControl();
        	
        	Alert alert = new Alert(AlertType.CONFIRMATION, player.getPlayerName() + " is the winner!    Wanna play again?", ButtonType.YES, ButtonType.NO);
        	alert.showAndWait();

        	if (alert.getResult() == ButtonType.YES) {       		
        		cont.close();
        	}
        	else if (alert.getResult() == ButtonType.NO) {
        		Platform.exit();
        	}
        	
        	System.out.println(player.getPlayerName() + " is the winner!");
            return true;
        }
        else{
            return false;
        }
    }
    
    //Method to generate and store 3 dice rolls
    public int [] rollDice(){
    	//New dice every time we roll
    	dice = new Dice();
    	
    	int [] rolls= new int[3];
		
		for(int i=0;i<3;i++){
			rolls[i]= dice.rollDice(6);
		}
		//Store dice values
		dice.setFirst(rolls[0]);
		dice.setSecond(rolls[1]);
		dice.setThird(rolls[2]);	
    	
    	return rolls;
    }
    
    //Method that returns the Score of a roll
	public int score(Player player) {
		
		int total_score = player.getPlayerScore();
		int roll_score = 0;
		boolean flag = true;
		
		//Variable to store rolls generated
		int [] rolls= new int[3];
		
		rolls = rollDice();
		
		int first = rolls[0];
		
		//Roll & Store 3 Times
		for(int i = 1; i < 3 && flag; i++){
			if (rolls[i] != first) flag = false;
		}
		//All Rolls Equal
		if (flag) {
			roll_score= 18;
		}
		else{
			Arrays.sort(rolls);
			
			//First = Second
			if (rolls[0] == rolls[1]) {
				roll_score = rolls[0] + rolls[1];
			}
			//Second = Third 
			else if (rolls[1] == rolls[2]) {
				roll_score = rolls[1] + rolls[2];
			}
			//All Rolls Different
			else {
				roll_score=1;
			}
		}
		
		total_score =+ roll_score;
		
		player.updatePlayerScore(total_score);
		
		return roll_score;
	}

    
 
}