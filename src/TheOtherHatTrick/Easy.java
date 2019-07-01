/**
 * @author MingQiang
 * 
 */
package TheOtherHatTrick;


public class Easy implements Strategy{
	Game myGame;
	
	/**
	 * This attribute records the player who is playing right now 
	 */
	Player isPlaying;
	
	/**
	 * This attribute records the player who is not playing right now 
	 */
	Player []notPlayering = new Player[2];
	
	/**
	 * The three attributes record robot's operation 
	 */
	private boolean chooseTricks = true;
	private boolean choosePerform = true;
	private int choose7thCard;
	
	/**
	 * capacity restores the quantity of the tricks
	 */
	int capacity;
	
	/**
	 * This is Constructor
	 * @param game
	 */
    public Easy(Game game) {
		myGame = game;
		intializePlayer();
	}
	
    /**
	 * initialize the attributes isPlaying and notPlaying
	 */
	public void intializePlayer() {
		int i = 0;
		int j = 0;
		while(i<3) {
			if(myGame.player[i].myTurn == true) {
				isPlaying = myGame.player[i];
			}
            i++;
		}
		i=0;
		while(i<3) {
			if(myGame.player[i].myTurn == false&&j<2) {
				notPlayering[j] = myGame.player[i];
				j++;
				if(j==1) {
					break;
				}
			}
			i++;
		}
	}
	@Override
	
	/**
	 * @return the operation choose trick 
	 * if choose the first trick return true else return false
	 */
	public boolean chooseTrick() {
		return chooseTricks;
	}

	@Override
	/**
	 * @return the array which contains 3 values£¼br£¾
	 * First value is the player you want to swap with£¼br£¾
	 * Second value is the player's card£¼br£¾
	 * Third value is your card
	 */
	public int[] chooseSwap() {
		int []chooseSwap = new int[3];
		int i=0;
		int position = 0;
		while(i<3) {
			if(myGame.player[i].myTurn == true) {
				position = i;
				}
			i++;
		}
		int choosePlayer;
		while(true) {
			 choosePlayer = (int)Math.round(2*Math.random());
	         if(choosePlayer == position) {
	        	 continue;
	         }else {
	        	 break;
	         }
		}
		int chooseOtherCard = (int)Math.round(Math.random());
		int  chooseMyCard = (int)Math.round(Math.random());
		
		chooseSwap[0] = choosePlayer;
		chooseSwap[1] = chooseOtherCard;
		chooseSwap[2] = chooseMyCard;
		return chooseSwap;
	}

	/**
	 * @return if choose perform return true else return false 
	 * 
	 */
	public boolean choosePerform() {
		int i = (int)Math.round(2*Math.random());
		if(i==0) {
			choosePerform = true;
			return choosePerform;
		}else {
			choosePerform = false;
			return false;
		}
	}
	
	/**
	 * @return when you performed successfully add the card to your card on main
	 * and choose one card to be the 7th card
	 */
	public int change7thCard() {
		choose7thCard = (int)Math.round(3*Math.random());
		return choose7thCard;
	}

}
