package TheOtherHatTrick;
import java.util.*;
/**
 * 
 * @author MingQiang
 *
 */
public class TricksCards {
	public final static int NUMBER_OF_CARDS=10;
	private Tricks bottomTricks=new Tricks();
	public LinkedList<Tricks>trickscards;
	
	/**
	 * This is constructor which initialize all the trick cards
	 */
	TricksCards(){
		trickscards=new LinkedList<Tricks>();
		this.bottomTricks=new Tricks(6);
		this.bottomTricks.setLeft(Attributs.TheHat);
		this.bottomTricks.setRight(Attributs.TheOtherRabbit);
		this.bottomTricks.setImage(ImageCard.c10);
		trickscards.add(bottomTricks);
		
		//the hungry rabbit
		Tricks trick1=new Tricks(1);
		trick1.setLeft(Attributs.TheRabbit,Attributs.TheOtherRabbit);
		trick1.setRight(Attributs.TheCarrots,Attributs.TheLecttuce);
		trickscards.add(trick1);
		trick1.setImage(ImageCard.c9);
		
		//the vegetable hat trick
		Tricks trick2=new Tricks(2);
		trick2.setLeft(Attributs.TheHat);
		trick2.setRight(Attributs.TheCarrots,Attributs.TheLecttuce);
		trickscards.add(trick2);
		trick2.setImage(ImageCard.c14);
		
		//the bunch of carrots
		Tricks trick3=new Tricks(2);
		trick3.setLeft(Attributs.TheCarrots);
		trick3.setRight(Attributs.TheCarrots);
		trickscards.add(trick3);
		trick3.setImage(ImageCard.c6);
		
		//the vegetable patch
		Tricks trick4=new Tricks(3);
		trick4.setLeft(Attributs.TheCarrots);
		trick4.setRight(Attributs.TheLecttuce);
		trickscards.add(trick4);
		trick4.setImage(ImageCard.c15);
		
		//the carrot hat trick
	    Tricks trick5=new Tricks(3);
	    trick5.setLeft(Attributs.TheHat);
	    trick5.setRight(Attributs.TheCarrots);
	    trickscards.add(trick5);
	    trick5.setImage(ImageCard.c7);
	    
	    //the rabbit that didn't like carrots
	    Tricks trick6=new Tricks(4);
	    trick6.setLeft(Attributs.TheRabbit,Attributs.TheOtherRabbit);
	    trick6.setRight(Attributs.TheLecttuce);
	    trickscards.add(trick6);
	    trick6.setImage(ImageCard.c12);
	    
	    //the slightly easier hat trick
	    Tricks trick7=new Tricks(4);
	    trick7.setLeft(Attributs.TheHat);
	    trick7.setRight(Attributs.TheRabbit,Attributs.TheOtherRabbit);
	    trickscards.add(trick7);
	    trick7.setImage(ImageCard.c13);
	    
	    //the hat Trick
	    Tricks trick8=new Tricks(5);
	    trick8.setLeft(Attributs.TheHat);
	    trick8.setRight(Attributs.TheRabbit);
	    trickscards.add(trick8);
	    trick8.setImage(ImageCard.c8);
	    
	    //the pair of rabbits
	    Tricks trick9=new Tricks(5);
	    trick9.setLeft(Attributs.TheRabbit);
	    trick9.setRight(Attributs.TheOtherRabbit);
	    trickscards.add(trick9);
	    trick9.setImage(ImageCard.c11);
	}
	
	/**
	 * Mix the cards
	 */
	public void mixing() {
		for(int i=0;i<this.NUMBER_OF_CARDS;i++) {
			int position=(int)Math.round((this.NUMBER_OF_CARDS-1)*Math.random());
			Tricks tricks=trickscards.pop();
			trickscards.add(position,tricks);
		}
	}
	
	/**
	 * 
	 * @return the top cards
	 */
	public Tricks getTopTricks() {
 	   return trickscards.pop();
    }
    
    public Tricks getTricks() {
 	   int position=(int)Math.round((TricksCards.NUMBER_OF_CARDS-1)*Math.random());
 	   return trickscards.remove(position);
    }
    
    /**
     * 
     * @return if the collection is empty return true else return false 
     */
    public boolean isEmpty() {
 	   return trickscards.isEmpty();
    }
    
    public String toString() {
    	return trickscards.toString();
    }
	public void addTricks() {
		
	}

}
