/**
 * @author MingQiang
 * 
 */
package TheOtherHatTrick;

import java.util.LinkedList;
import java.util.Stack;

public class Difficult implements Strategy{
	
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
	public Difficult(Game game) {
		myGame = game;
		capacity = game.getTricksPile().size();
		initializePlayer();
	}
	
	/**
	 * initialize the attributes isPlaying and notPlaying
	 */
	public void initializePlayer() {
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
	
	/**
	 * @return the operation choose trick 
	 * if choose the first trick return true else return false
	 */
	public boolean chooseTrick() {
		return chooseTricks;
	}

	/**
	 * @return the array which contains 3 values£¼br£¾
	 * First value is the player you want to swap with£¼br£¾
	 * Second value is the player's card£¼br£¾
	 * Third value is your card
	 */
	public int[] chooseSwap() {
		Stack<Integer> choose = strategyChooseSwap();
		int [] chooseSwap = new  int [3];
		chooseSwap[0] = choose.pop();
		chooseSwap[1] = choose.pop();
		chooseSwap[2] = choose.pop();
		return chooseSwap;
	}

	/**
	 * @return if choose perform return true else return false and we always choose to perform
	 */
	public boolean choosePerform() {
		return choosePerform;
	}

	/**
	 * @return when you performed successfully add the card to your card on main
	 * and choose one card to be the 7th card
	 */
	public int change7thCard() {
		choose7thCard = (int)Math.round(4*Math.random());
		return choose7thCard;
	}
	
	
	public Stack<Integer> strategyChooseSwap(){
    	Stack<Integer>finalChoose=new Stack<Integer>();
    	if(myGame.getTricksPile().size()>1/3*this.capacity) {
    		finalChoose=this.strategyBegin(this.findCards());
    	}
    	else {
    		finalChoose=this.strategyFinal(this.findCards());
    	}
    	return finalChoose;
    }
	
	/**
	 * 
	 * @param choose
	 * @return if choose not empty which means there exists a match, just return choose
	 */
    public Stack<Integer> strategyBegin(Stack<Integer>choose) {
    	Stack<Integer>newChoose=new Stack<Integer>();
    	if(choose.isEmpty()) {
    		this.chooseTricks=false;
    		newChoose=this.findCards();
    		return newChoose;
    	}
    	return choose;
    }
    
    /**
     * when there have few cards, the AI try not to hold the card "The Hat" and "The other rabbit"
     * @param choose
     * @return
     */
    public Stack<Integer> strategyFinal(Stack<Integer> choose) {
    	Stack<Integer>newChoose=new Stack<Integer>();
    	//for each player, find whether he has the card
    	if(choose.isEmpty()) {
    	 	for(int i=0;i<2;i++) {
    			if(this.notPlayering[i].hasAttributs(Attributs.TheHat)==-1&&isPlaying.hasAttributs(Attributs.TheHat)!=-1) {
    				int index=isPlaying.hasAttributs(Attributs.TheHat);
    				newChoose.push(index);
    				newChoose.push(0);
    				newChoose.push(i);
    				return newChoose;
    			}
    			else if(this.notPlayering[i].hasAttributs(Attributs.TheOtherRabbit)==-1&&isPlaying.hasAttributs(Attributs.TheOtherRabbit)!=-1) {
    				     int index=isPlaying.hasAttributs(Attributs.TheOtherRabbit);
    				     newChoose.push(index);
    				     newChoose.push(0);
    				     newChoose.push(i);
    				     return newChoose;
    		   }
    			else if(isPlaying.hasAttributs(Attributs.TheHat)==-1&&isPlaying.hasAttributs(Attributs.TheOtherRabbit)==-1) {
    				this.chooseTricks=false;
    				if(this.notPlayering[i].hasAttributs(Attributs.TheHat)!=-1&&this.notPlayering[i].hasAttributs(Attributs.TheOtherRabbit)!=-1) {
    					newChoose.push(0);
    					newChoose.push(0);
    					if(i<1) {
    					   newChoose.push(i);
    					}
    					else {
    						newChoose.push(i+1);
    					}
    					return newChoose;
    				}
    			}
        	}
    	}
    	return choose;	
    }
    
    /**
     * 
     * @return the player's position, his card and robot's card which can match the top trick
     */
    public Stack<Integer> findCards() {
    	Stack<Integer>choose=new Stack<Integer>();
    	LinkedList<Props>thePropsVisible=new LinkedList<Props>();
    	
    	/**
    	 * 
    	 */
    	for(int j=0;j<2;j++) {
    	  	for(int i=0;i<2;i++) {
        		if(this.notPlayering[j].getMyprops().get(i).getVisible()) {
        			thePropsVisible.add(this.notPlayering[j].getMyprops().get(i));
        		}
        	}
    	}
 
        if(!this.findMatch().isEmpty()&&!thePropsVisible.isEmpty()) {
    		choose=this.findMatch();
    		return choose;
    	}
        
        int positionPlayer=(int)Math.round(2*Math.random());
        int positionCard=(int)Math.round(2*Math.random());
        int myPosition=0;
        choose.push(myPosition);
    	choose.push(positionCard);
		choose.push(positionPlayer);
		return choose;   	
    }
    
    /**
     * find the visible card which can match the trick with your card and restore the best choice 
     * @return
     */
    public Stack<Integer>findMatch(){
    	Stack<Integer>choose=new Stack<Integer>();
    	LinkedList<Props>thePropsVisible=new LinkedList<Props>();
    	LinkedList<Integer>positionPlayer=new LinkedList<Integer>();
    	LinkedList<Integer>positionCard=new LinkedList<Integer>();
    	
    	//restore the cards which are visible  
    	for(int j=0;j<2;j++) {
    	  	for(int i=0;i<2;i++) {
        		if(this.notPlayering[j].getMyprops().get(i).getVisible()) {
        			thePropsVisible.add(this.notPlayering[j].getMyprops().get(i));
        			//restore the player and the card position 
        			positionPlayer.add(j);
        			positionCard.add(i);
        			i++;
        		}
        	}
    	}
    	
    	//find the visible card which can match the trick with your card 
		for(int i=0;i<thePropsVisible.size();i++) {
			for(int j=0;j<2;j++) {
		    	RealPlayer virtual=new RealPlayer();
				LinkedList<Props>tempProps=new LinkedList<Props>();
				tempProps.add(thePropsVisible.get(i));
				tempProps.add(isPlaying.getMyprops().get(j));
				virtual.setMyProps(tempProps);
				boolean match=virtual.match(myGame.getTricksPile().peek());
				if(match) {
					choose.push(j);//j is the position of my card
					choose.push(positionCard.get(i));
					choose.push(positionPlayer.get(i));
				  	return choose;
				}
				else {
					continue;
				}
			}
		}
		return choose;
    }
    
   
    /**
     * give the robot's choice to swap
     * @param choose
     */
    public void swapCard(Stack<Integer> choose) {
       int positionPlayer=choose.pop();
       int positionCard=choose.pop();
       int myCardPosition=choose.pop();
 	   Props tempProps=new Props();
 	   tempProps=isPlaying.getMyprops().get(myCardPosition);
 	   isPlaying.getMyprops().add(myCardPosition,this.notPlayering[positionPlayer].getMyprops().get(positionCard));
 	   this.notPlayering[positionPlayer].getMyprops().add(myCardPosition,tempProps);	   
    }
    
}
