package TheOtherHatTrick;
/**
 * @author MingQiang
 */
import java.util.LinkedList;
import java.util.Stack;

public abstract class Player{
	protected int age;
    
    protected String name=new String();
    
    protected int RecentScore=0;
    
    protected LinkedList<Props> myProps=new LinkedList<Props>();
    
    protected boolean myTurn=false;
    
    /**
     * These three attributes are the operations of the player 
     */
    public boolean chooseTrick;
    public int[] chooseSwap = new int[3];
    public boolean choosePerform;
    public int choose7thCard;

    /**
     * This is constructor without initialize the basic information
     */
    Player(){
 	   
    }
    
    /**
     * This is constructor which initialize the player
     * @param age player's age
     * @param name player's name
     */
    Player(int age,String name){
 	   this.age=age;
 	   this.name=name;
    }
    
    public void getCards(Props props) {
 	   myProps.add(props);
    }
    
    public void setAge(int age) {
 	   this.age=age;
    }
    
    public int getAge() {
 	   return this.age;
    }
    
    public void setName(String name) {
 	   this.name=name;
    }
    
    public String getName() {
 	   return this.name;
    }
    
    public boolean getMyTurn() {
 	   return this.myTurn;
    }
    
    public int getScore() {
 	   return this.RecentScore;
    }
    
    /**
     * 
     * @param score when you successfully performed you will get the score of the trick
     */
    public void changeScore(int score) {
 	   this.RecentScore+=score;
    }
    
    /**
     * 
     * @return the player's card on main
     */
    public LinkedList<Props>getMyprops(){
 	   return this.myProps;
    }
    
    public void setMyProps(LinkedList<Props> myProps) {
 	   this.myProps=myProps;
    }
    
    public void changemyTurn(boolean turn) {
 	   this.myTurn=turn;
    }
    

    /**
     * These abstract functions set the operation of player
     */
	public abstract void chooseTrick();
	public abstract void chooseSwap();
	public abstract void choosePerform();
	public abstract void change7thCard();
	
	
	/**
	 * 
	 * @param tricks This is the trick the player has chose
	 * @return if your card match the trick's attribute return true, else return false
	 * 
	 */
	public boolean match(Tricks tricks) {
		boolean leftMatch=false;
        boolean rightMatch=false;
        LinkedList<Attributs>left=new LinkedList<Attributs>();
        LinkedList<Attributs>right=new LinkedList<Attributs>();
        left=tricks.getLeft();
        right=tricks.getRight();
        Stack<Props>tempStack=new Stack<Props>();
        //testleft
    	int temp1 = myProps.size();
        for(int i = 0;i<left.size()&&!leftMatch;i++) {
     	   for(int j=0;j<temp1;j++) {
         	   if(myProps.get(j).getAttribut()==left.get(i)) {
     			   leftMatch = true;
     			   tempStack.push(myProps.remove(j));
     			   break;
     		   }      		
     	   }
        } 
        //testright
        int temp2=myProps.size();
        for(int i=0;i<right.size()&&!rightMatch;i++) {
     	   for(int j=0;j<temp2;j++) {  
         	   if(myProps.get(j).getAttribut()==right.get(i)) {
     			   rightMatch=true;
     			   tempStack.push(myProps.remove(j));
     			   break;
     		   }      		
     	   }
	       } 
        while(!tempStack.isEmpty()) {
     	   myProps.add(tempStack.pop());
        }
        return leftMatch&&rightMatch;
	   }

	
	/**
	 *
	 * @param perform the result of your perform
	 * @param the7thcard recent the 7th card
	 * @return if you perform successfully return the new 7th card else return recent 7th card
	 * 
	 */
    public Props isSuccessful(boolean perform,Props the7thcard) {
 	   Props thenew7thcard=new Props();
 	   if(perform) {
 		   showMyCard();

 		   the7thcard.changeVisible(true);
 		   System.out.println(the7thcard.toString());
 		   
 		   this.myProps.add(the7thcard);
 		   
 		   this.change7thCard();
 		   int myChoose = choose7thCard;
 		   
 		   //change the 7th card
 		   thenew7thcard=myProps.remove(myChoose);
 		   thenew7thcard.changeVisible(false);
 		  
 		   notShowMyCard();
 		   
 	   }
 	   //if not successful,punished
 	   else {
 		   this.foreit();
 		   thenew7thcard=the7thcard;
 	   }
 	   return thenew7thcard;
    }
    
    /**
     * 
     * change all of your cards to visibe
     */
    public void showMyCard() {
	//change visible to true 
	   int i=0;
	   while(i<myProps.size()) {
		   Props tempprops=new Props();
	   tempprops=this.myProps.get(i);
	   tempprops.changeVisible(true);
	   i++;
	   } 
    }
    
    /**
     * 
     * change all of your cards on main to not visible
     * 
     */
    public void notShowMyCard() {
	   int i=0;
	 //change visible to false 
	   while(i<myProps.size()) {
		   Props tempprops=new Props();
	       tempprops=this.myProps.get(i);
	       tempprops.changeVisible(false);
	       i++;
	   } 
    }
    
    /**
     * if you didn't perform successfully or choose to not perfrom
     * you will be punished and change one of your card to be visible
     */
     public void foreit() {
  	   int i=0;
  	   while(i<2) {
  		   Props tempprops=new Props();
  		   tempprops=this.myProps.get(i);
             if(tempprops.getVisible()) {
          	   i++;
          	   continue;
             }
             else {
          	   tempprops.changeVisible(true);
          	   break;
             }
  	   }
          
     }
     
     /**
      * 
      * @param thelastcard The last card is "The other hat trick"
      *  if you have the attributes of this trick your score will minus 3 
      */
     public void hasTheLast(Tricks thelastcard) {
 
  	   int temp=this.myProps.size();
  	   for(int i=0;i<temp;i++) {    
  		   
      	  Props tempProps=new Props();
  		  tempProps=this.myProps.get(i);
  		 
  		  //match one attribute of the card score -3(left)
  		  int temp1=thelastcard.getLeft().size();
  		  for(int j=0;j<temp1;j++) {
      		  if(tempProps.getAttribut()==thelastcard.getLeft().get(j)) {        		
      			  this.changeScore(-3);
      			  break;
      		  }
  		   }

		  //match one attribute of the card score -3(right)  
  		  int temp2=thelastcard.getRight().size();
  		  for(int j=0;j<temp2;j++) {
  			  
      		  if(tempProps.getAttribut()==thelastcard.getRight().get(j)) {        		
      			  this.changeScore(-3);
      			  break;
      		  }
  		  }

  			  
  	   }
  	   
     }

     /**
      * 
      * @param tricks This is the trick the player has chose
      * @return if perform successfully return true else return false
      */
     public boolean perform(Tricks tricks){
         //change score(if successful)
         if(this.match(tricks)) {
      	   this.changeScore(tricks.getScore());
      	   return true;
         }
         //return false and will be punished in function isSuccessful
         else {
      	   return false;
         }
     }
     
     /**
      * 
      * if player has this attribute return its position else return -1d
      * @param attri This is the attribute which you want to check whether the three players has this attribute
      * @return if find the attribute return the position
      * else return -1
      */
     public int hasAttributs(Attributs attri) {
  	   for(int i=0;i<this.myProps.size();i++) {
  		   if(this.myProps.get(i).getAttribut()==attri) {
  			   return i;
  		   }
  	   }
  	   return -1;
  	   
     }
     
     /**
      * check whether the object is robot
      * @param obj It must be the type player
      * @return if it is robot return true else return false
      */
     public static boolean isRobot(Object obj) {
    	 boolean test = false;
    	 if(obj instanceof AIPlayer) {
    		 test = true;
    	 }
    	 return test;
     }
     
     /**
      * check whether the player has the attribute 
      * @param attri This is the attribute which you want to check whether the three players has this attribute
      * @return if find the attribute return true else return false
      */
     public boolean hasAttribut(Attributs attri) {
    	 boolean test;
    	 if(this.myProps.get(0).getAttribut() == attri|| this.myProps.get(1).getAttribut() == attri ) {
    		 test =true;
    	 }else {
    		 test = false;
    	 }
    	 return test;
     }
     
     public String toString() {
  	   return new String("age:"+this.age+" "+"name:"+this.name+" "+"myProps:"+
     this.myProps.toString()+" "+"myTurn:"+this.myTurn+" Score:"+this.getScore());
     }

}
