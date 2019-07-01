package TheOtherHatTrick;

/**
 * @author MingQiang
 */

import java.util.*;

public class PropsCards {
	       /**
	        * This is the number of cards
	        */
           public final static int NUMBER_OF_CARDS=7;
           public LinkedList<Props>propscards;
           
           /**
            * This is constructor
            */
           PropsCards() {
        	   propscards=new LinkedList<Props>();
        	   for(Attributs a:Attributs.values()){
        		    Props props=new Props(a);
        		    if (Attributs.TheCarrots == props.getAttribut()) {
        		    	 propscards.add(new Props(a));
        		    	 propscards.add(new Props(a));
        		    	 propscards.add(new Props(a));
					}else {
						propscards.add(props);
					}
        	   }
        	   mixing();
           }
           
           /**
            * Mix the card
            */
           public void mixing() {
        	   for(int i=0;i<this.NUMBER_OF_CARDS;i++) {
        		   int position=(int)Math.round((this.NUMBER_OF_CARDS-1)*Math.random());
        		   Props props=propscards.pop();
        		   propscards.add(position,props);
        	      	   
        	   }
           }
           
           public Props getTopProps() {
        	   return propscards.pop();
           }
           
           public Props getProps() {
        	   int position=(int)Math.round((this.NUMBER_OF_CARDS-1)*Math.random());
        	   return propscards.remove(position);
           }
           
           public boolean isEmpty() {
        	   return propscards.isEmpty();
           }
           
           public String toString() {
        	   return propscards.toString();
           }

           
}
