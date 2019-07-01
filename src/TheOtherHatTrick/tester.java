package TheOtherHatTrick;

public class tester {
    public static void main(String arg[]){
      Game game=new Game();
      game.setup();
      
  	  //test player
  	  for(int i=0;i<3;i++) {
  		  System.out.println(game.player[i].toString());
  	  }
  	  //test trickpile
  	  int size=game.getTricksPile().size();
  	  System.out.println(size);
  	  for(int i=0;i<size;i++) {
  		  System.out.println(game.getTricksPile().get(i));
  	  }
  	  //test hasAttributs
  	  int []p= {5,5,5,5,5,5,5};
        p[0]=game.player[0].hasAttributs(Attributs.TheCarrots);
        p[1]=game.player[0].hasAttributs(Attributs.TheHat);
        p[2]=game.player[0].hasAttributs(Attributs.TheLecttuce);
        p[3]=game.player[0].hasAttributs(Attributs.TheOtherRabbit);
        p[4]=game.player[0].hasAttributs(Attributs.TheRabbit);
        for(int i=0;i<5;i++) {
      	  System.out.println(p[i]);
        }
        game.launchTheGame();

    }
}