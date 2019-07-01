package TheOtherHatTrick;
/**
 * @author MingQiang
 * 
 */
public class AIPlayer extends Player {
	public static int COUNT=0;
	Player []otherPlayer = new Player[2];
	
	private Strategy myStrategy;
	
	//Constructor

	/**
	 *This is Class AIPlayer's Constructor 
	 */
	public AIPlayer(){
		super(1000,"Robot"+COUNT);
		name=new String("Robot"+COUNT);
		COUNT++;
	}
	
     	
    //choose Trick
	/**
	 * This is Robot's first operation choose the trick or not 
	 */
    public void chooseTrick() {
       System.out.println("Please choose trick");
 	   this.chooseTrick = myStrategy.chooseTrick();
 	   try {
		Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    
    //choose swap
    /**
     * This is Robot's second operation choose to swap card with other players
     */
    public void chooseSwap() {
    	System.out.println("Please choose card to swap");
		this.chooseSwap = myStrategy.chooseSwap();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    //choose Perform
    /**
     * This is Robot's third operation choose perform or not
     */
    public void choosePerform() {
    	System.out.println("Please choose perfrom");
		this.choosePerform = myStrategy.choosePerform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    //change 7th card
    /**
     * This is Robot's fourth operation change the 7th card
     */
	public void change7thCard() {
    	System.out.println("Please change the 7 card:");
		this.choose7thCard = myStrategy.change7thCard();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * This is the function which can get robot's strategy
	 * @return return the strategy the player has chose
	 */
	public Strategy getMyStrategy() {
		return myStrategy;
	}

    /**
     * This is the function which can set the robot's strategy
     * @param myStrategy set the strategy 
     */
	public void setMyStrategy(Strategy myStrategy) {
		this.myStrategy = myStrategy;
	}

}
