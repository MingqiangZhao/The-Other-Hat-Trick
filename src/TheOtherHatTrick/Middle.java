package TheOtherHatTrick;

public class Middle implements Strategy{
	Game myGame;
	Player isPlaying;
	Player []notPlayering = new Player[2];
	int capacity;
	
	
    public Middle(Game game) {
		myGame = game;
		intializePlayer();
	}
	
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
	public boolean chooseTrick() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] chooseSwap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean choosePerform() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int change7thCard() {
		// TODO Auto-generated method stub
		return 0;
	}
}
