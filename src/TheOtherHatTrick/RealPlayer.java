package TheOtherHatTrick;

/**
 * @author MingQiang
 */
import java.util.*;

public class RealPlayer extends Player{
	
	/**
	 * This is constructor
	 */
    public RealPlayer(){
	    super();
    }
    
    /**
     * This is constructor which initialize the basic information
     * @param age 
     * @param name
     */
    public RealPlayer(int age,String name){
	    super(age,name);
    }
   
    /**
     * This is the operation choose the trick
     */
    public void chooseTrick() {
    	Scanner in = new Scanner(System.in);
    	System.out.println("Please choose trick");
    	chooseTrick = in.nextBoolean();
    	
    }//首先要选择perform第一张还是下一张trick
   
    /**
     * This is the operation choose the cards and swap with other player
     */
    public void chooseSwap() {
    	System.out.println("Please choose card to swap");
    	Scanner in = new Scanner(System.in);
    	System.out.println("Please choose the player:");
    	chooseSwap[0] = in.nextInt();
    	System.out.println("Please choose the other card:");
    	chooseSwap[1] = in.nextInt();
    	System.out.println("Please choose your card:");
    	chooseSwap[2] = in.nextInt();
	}
    
    /**
     * This is the operation choose perform or not
     */
    public void choosePerform() {
    	System.out.println("Please choose perfrom");
    	Scanner in = new Scanner(System.in);
    	choosePerform = in.nextBoolean();
    	
    }
    
    /**
     * This is the operation choose 7th card
     */
   public void change7thCard() {
    	System.out.println("Please change the 7 card:");
    	Scanner in = new Scanner(System.in);
    	choose7thCard = in.nextInt();
    }
    
    public String toString() {
	    return new String("age:"+super.age+" "+"name:"+super.name+" "+"myProps:"+super.myProps.toString()+" "+"myTurn:"+super.myTurn);
    }
		
}
