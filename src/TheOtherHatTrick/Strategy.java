package TheOtherHatTrick;
/**
 * 
 * @author MingQiang
 *
 */

public interface Strategy {
	public abstract boolean chooseTrick();
	public abstract int[] chooseSwap();
	public abstract boolean choosePerform();
	public abstract int change7thCard();
}
