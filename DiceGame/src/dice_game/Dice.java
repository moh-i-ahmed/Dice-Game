package dice_game;

public class Dice {
private int sides;
 public Dice(int sidesToBeSet)
 {
 sides = sidesToBeSet;
 }


 public int rollDice(int sidesToBeSet)
 {

	int side = (1 + (int)(Math.random() * sides));
	 
 return side;
 }
}
