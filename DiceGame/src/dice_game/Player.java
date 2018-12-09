/* GROUP 8
 * CO2001 User Interfaces & HCI Mini-project
 * Lukas Petkevicius - lp288
 * Mohammed Ahmed - mia17
 * Player Class
 */

package dice_game;

public class Player {
	
	private String name;
	private int totalScore;
	private int rollCounter;

	//No args Constructor
	public Player(){
		name = "";
		totalScore = 0;
		rollCounter = 0;
	}
	
	public Player(String playerName){
		name = playerName;
		totalScore = 0;
		rollCounter = 0;
	}

	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
	}

	public int getRollCounter(){
		return rollCounter;
	}

	public void setRollCounter(int rollCounter){
		this.rollCounter = rollCounter;
	}

	public String getPlayerName(){
		return name;
	}

	public int getPlayerScore(){	
		return totalScore;
	}

	public void updatePlayerName(String playerName){
		name = playerName;
	}

	public void updatePlayerScore(int num){
		totalScore = totalScore + num;
	}

}
