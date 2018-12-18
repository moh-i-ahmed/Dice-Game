/* GROUP 8
 * CO2001 User Interfaces & HCI Mini-project
 * Lukas Petkevicius - lp288
 * Mohammed Ahmed - mia17
 * Dice Class
 */

package dice_game;

public class Dice {
	private int sides;
	private final int SIDES = 6;
	private int first, second, third;

	public Dice() {
		sides = 6;
	}
	

	public int getSecond() {
		return second;
	}


	public void setSecond(int second) {
		this.second = second;
	}


	public int getThird() {
		return third;
	}


	public void setThird(int third) {
		this.third = third;
	}


	public int getFirst() {
		return first;
	}

	public void setFirst(int first) {
		this.first = first;
	}
	


	public Dice(int sidesToBeSet){
		sides = sidesToBeSet;
	}

	public int rollDice(int sidesToBeSet) {
		return (1 + (int)(Math.random() * sides));
	}
}
