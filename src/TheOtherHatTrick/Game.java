package TheOtherHatTrick;
/**
 * @author MingQiang
 * 
 */
import java.util.*;

public class Game {
	
      public int gameMode = 3;
      public int level;
      private  PropsCards propsCards=new PropsCards();
      private  TricksCards tricksCards=new TricksCards();
      private  Stack<Tricks> tricksPile=new Stack<Tricks>();
     
      public Player []player=new Player[3];
      
      public Props seventhCard=new Props();
      public Tricks thelastcard=new Tricks();
     
      public  int turn=0;
      
      public Game(){
    	  
      }
      public Stack<Tricks> getTricksPile(){
    	  return this.tricksPile;
      }
      
      public void mode0SetUpPlayer() {
		  Scanner in = new Scanner(System.in);
		  int age1;
		  String name1=new String();
		  System.out.println("Please input your name:\n");
		  name1 = in.next();
		  System.out.println("Please input your age\n");
		  age1 = in.nextInt();
		  player[0] = new RealPlayer(age1,name1);
		  
		  int age2;
		  String name2=new String();
		  System.out.println("Please input your name:\n");
		  name2 = in.next();
		  System.out.println("Please input your age\n");
		  age2 = in.nextInt();
		  player[1] = new RealPlayer(age2,name2);
		  
		  int age3;
		  String name3=new String();
		  System.out.println("Please input your name:\n");
		  name3 = in.next();
		  System.out.println("Please input your age\n");
		  age3 = in.nextInt();
		  player[2] = new RealPlayer(age3,name3);
      }
      
      public void mode1SetUpPlayer() {
    	  Scanner in = new Scanner(System.in);
		  int age;
		  String name=new String();
		  
		  System.out.println("Please input your name:");
		  name = in.next();
		  System.out.println("Please input your age");
		  age = in.nextInt();
		  
		  player[0]=new RealPlayer(age,name);
		  player[1]=new AIPlayer();
		  player[2]=new AIPlayer();  
      }
      
      public void setUpPlayer() {
    	  
    	  if(this.gameMode==0) {
              mode0SetUpPlayer();
    		  
    	  }
    	  else if(this.gameMode==1) {
    		  mode1SetUpPlayer();
    	  }    	
      }
      
      

      public void distributeCard() {
    	  int i=0;
    	  while(i<3&&!this.propsCards.propscards.isEmpty()){
    		  this.player[i].getCards(this.propsCards.propscards.pop());
    		  this.player[i].getCards(this.propsCards.propscards.pop());
    		  i++;
    	  }
    	  seventhCard=propsCards.propscards.pop();
      }
      
      //³õÊ¼»¯tricks¶Ñ
      public void mixTrick() {
    	  this.tricksCards.mixing();
      }
      
      public void setPile() {
    	  mixTrick();//mix trick cards
    	  //find the card "the other hat trick"
    	  int i=0;
    	  int size=this.tricksCards.trickscards.size();
    	  while(i<size) {
    		  if(this.tricksCards.trickscards.get(i).getScore()==6) {
    			  this.thelastcard=this.tricksCards.trickscards.get(i);
    			  this.tricksPile.push(this.thelastcard);
    			  break;
    		  }
    		  else {
    			  i++;
    			  continue;
    		  }
    	  }
    	  //push other tricks cards into pile
    	  int j=0;
     	  while(j<size) {
     		 if(this.tricksCards.trickscards.get(j).getScore()!=6) {
     		 this.tricksPile.push(this.tricksCards.trickscards.get(j));
     		 j++;
     		 }
     		 else {
     			 j++;
     		 }
    	  }
      }
      
      /**
       * initialize the game
       */
      public void setup() {
    	   setGameMode();
    	   if(gameMode == 1) {
        	   chooseLevel();
    	   }
    	   setUpPlayer();
    	   distributeCard();
    	   setOrder();
    	   setPile();
      }

      /**
       * decide which player will play first
       */
      public void setOrder() {
    	  int []age=new int[3];
    	  for(int i=0;i<3;i++) {
    		  age[i]=this.player[i].getAge();
    	  }
    	  
    	  int temp=10000;
    	  int flag=0;
    	  for(int i=0;i<3;i++) {
    		  if(temp>=age[i]) {
    			  temp=age[i];
    			  flag=i;
    		  }
    		  if(i==2) {
    	    	  this.player[flag].changemyTurn(true);
    		  }
    	  }
      }
      
      /**
       * check whether the round has finished  
       */
      public boolean round() {
    	  for(int i=0;i<3;i++) {
    		  if(player[i].getMyTurn()&&!this.isLastCard()) {
    			  this.play(player[i]);			  
    			  this.player[i].changemyTurn(false);
    			  if(i<2) {
    				  this.player[i+1].changemyTurn(true);
    			  }
    			  if(i==2) {
    				  this.player[0].changemyTurn(true);
    			  }
    		  }
    	  }
    	  if(this.tricksPile.isEmpty()) {
    		  return true;
    	  }
    	  else {
    		  return false;
    	  }
      }
      
      /**
       * check whether the top of tricks pile is "the other hat trick"
       * @return if the top of tricks pile is "the other hat trick" return true, else return false
       */
      public boolean isLastCard() {
    	if(this.tricksPile.size()==1) {
    		for(int i=0;i<3;i++) {
    			player[i].hasTheLast(this.thelastcard);
    		}
    		this.tricksPile.pop();
    		return true;
    	}
    	else {
    		return false;
    	} 
      }
      
      /**
       * when id the player's turn, he begin to play
       * @param player
       */
      
      public void play(Player player) {
    	  System.out.println("Now "+player.getName()+" is playing.");
    	  
    	  if(gameMode == 1&&level == 0) {
    		  Easy strategy = new Easy(this);
    		  AIPlayer AI1 = (AIPlayer)this.player[1];
    		  AIPlayer AI2 = (AIPlayer)this.player[2];
    		  AI1.setMyStrategy(strategy);
    		  AI2.setMyStrategy(strategy);
    	  }
    	  
    	  if(gameMode == 1&&level == 1) {
    		  Middle strategy = new Middle(this);
    		  AIPlayer AI1 = (AIPlayer)this.player[1];
    		  AIPlayer AI2 = (AIPlayer)this.player[2];
    		  AI1.setMyStrategy(strategy);
    		  AI2.setMyStrategy(strategy);
    	  }
    	  
    	  if(gameMode == 1&&level == 2) {
    		  Difficult strategy = new Difficult(this);
    		  AIPlayer AI1 = (AIPlayer)this.player[1];
    		  AIPlayer AI2 = (AIPlayer)this.player[2];
    		  AI1.setMyStrategy(strategy);
    		  AI2.setMyStrategy(strategy);
    	  }
    	  
    	  System.out.println("Your card is:");
    	  System.out.println(player.toString());
    	  System.out.println("The Trick is:");
    	  System.out.println(this.getTricksPile().peek().toString());
    	  
    	  //choose the tricks 
    	  player.chooseTrick();
    	  if(player.chooseTrick == false) {
    		  getTricksPile().pop();
    		  System.out.println("The Trick is:");
        	  System.out.println(this.getTricksPile().peek().toString());
    	  }
    	  
    	  //swap card
    	  for(int i=0;i<3;i++) {
    		  for(int j=0;i<2;i++) {
    			  if(this.player[i].getMyprops().get(j).getVisible()) {
    				  System.out.println(this.player[i].getName()+" 's "+
    			      this.player[i].getMyprops().get(j).toString()+" is visible");
    			  }
    		  }
    	  }
    	  
    	  swap(player);
    	  perform(player);
    	  
      }
      
	 public void swap(Player player) {
		player.chooseSwap();
		int []choose = player.chooseSwap;
	    int choosePlayer = choose[0];
	    int chooseOtherCard = choose[1];
	    int chooseMyCard = choose[2];
	    swapCard(choosePlayer, chooseOtherCard, chooseMyCard,player);
	 }
      
	 /**
	  * 
	  * @param player player who will play 
	  */
	 public void perform(Player player) {
	   //perform
	    if(player.chooseTrick) {
			//choose perform
	    	player.choosePerform();
	    	//success or be punished
	    	if(player.choosePerform) {
	     	    boolean success=player.perform(this.tricksPile.pop());
	    		this.seventhCard=player.isSuccessful(success, this.seventhCard);
	    	  }
	    	if(!player.choosePerform) {
	    		player.foreit();
	    	 }
		 }else {
			  boolean success=player.perform(this.tricksPile.peek());
			  this.seventhCard=player.isSuccessful(success, this.seventhCard);
		  }
	  }
      
      /**
       * launch the game and output the winner
       */
      public void launchTheGame() {
    	  boolean finish=false;
    	  while(!finish) {
    	  finish=this.round();
    	  this.turn++;
    	  }
    	  LinkedList<Player> winner = findWinner();
    	  while(!winner.isEmpty()) {
    		  System.out.println(winner.pop().getName()+" is the winner !");
    	  }
    	  endGame();
      }
      
      /**
       * find the winner
       * @return the winner
       */
      public LinkedList<Player> findWinner() {
    	  LinkedList<Player>winner=new LinkedList<Player>();
    	  int temp=-1;
    	  int flag=0;
    	  for(int i=0;i<3;i++) {
    		  if(temp<this.player[i].getScore()) {
    			  temp=this.player[i].getScore();
    			  flag=i;
    		  }
    	  }
    	  winner.add(this.player[flag]);
    	  for(int i=0;i<3;i++) {
    		  if(temp==this.player[i].getScore()&&i!=flag) {
    			  winner.add(this.player[i]);    		  }
    	  }
    	  return winner;
      }
    
      /**
       * initialize the game mode
       */
      public void setGameMode() {
    	  System.out.println("Please Choose Game Mode:");
          
    	  Scanner in = new Scanner(System.in);
    	  gameMode = in.nextInt();
      }
      
      /**
       * end the game
       */
      public void endGame() {
    	  for(int i=0;i<3;i++) {
    		  player[i].changemyTurn(false);
    	  }
    	  System.out.println("The game is ended!");
      }
      
      /**
       * choose the difficulty of playing with robot 
       */
      public void chooseLevel() {
    	  if(gameMode == 1) {
    		  Scanner in = new Scanner(System.in);
    		  System.out.println("Please choose the level:");
    		  System.out.println("0:easy,1:middle,2:difficult");
    		  level = in.nextInt();
    	  }
      }
      
      /**
       * 
       * @param choosePlayer the player to be swapped with 
       * @param chooseOtherCard the player's card
       * @param chooseMyCard the card of the player who is playing
       * @param nowPlayer the player who is playing
       */
      public void swapCard(int choosePlayer,int chooseOtherCard, int chooseMyCard,Player nowPlayer) {
          Props tempProps=new Props();
  	      tempProps=nowPlayer.myProps.remove(chooseMyCard);
  	      nowPlayer.myProps.add(chooseMyCard,player[choosePlayer].myProps.remove(chooseOtherCard));
  	      player[choosePlayer].myProps.add(chooseOtherCard,tempProps); 
  	      if(player[choosePlayer].myProps.get(chooseOtherCard).getVisible()||nowPlayer.myProps.get(chooseMyCard).getVisible()) {
  	    	player[choosePlayer].myProps.get(chooseOtherCard).changeVisible(true);
  	    	nowPlayer.myProps.get(chooseMyCard).changeVisible(true);
  	      }
  	 }
      
      public String toString() {
    	  return new String(player[0].toString()+"\n"+player[1].toString()+"\n"+player[2].toString());
      }
	
      
}
