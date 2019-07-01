package TheOtherHatTrick;

/**
 * @author MingQiang
 */
import javax.swing.ImageIcon;

public class Props {
         
          private Attributs attribut;        
          private boolean visible=false;
          public ImageIcon image;
          
          /**
           * This is constructor
           */
          public Props() {
        	  
          }
          
          /**
           * This is constructor
           * @param attribut
           */
          public Props(Attributs attribut) {
        	  this.attribut=attribut;
        	  setImageProps();
          }
          
          public Attributs getAttribut() {
        	  return this.attribut;
          }
          
          public void setAttribut(Attributs attr ) {
        	  this.attribut=attr;
          }
          
          public void changeVisible(boolean bool) {
        	  this.visible=bool;
          }
          
          public boolean getVisible() {
        	  return this.visible;
          }
          
          /**
           * connect the card with image
           */
          public void setImageProps() {
        	  if(this.attribut == Attributs.TheCarrots) {
        		  image = ImageCard.c1;
        	  }
        	 
        	  if(this.attribut == Attributs.TheHat) {
        		  image = ImageCard.c2;
        	  }
        	  if(this.attribut == Attributs.TheLecttuce) {
        		  image = ImageCard.c3;
        	  }
        	  if(this.attribut == Attributs.TheOtherRabbit) {
        		  image = ImageCard.c4;
        	  }
        	  if(this.attribut == Attributs.TheRabbit) {
        		  image = ImageCard.c5;
        	  }
          }
          
          public String toString() {
        	  StringBuffer sb=new StringBuffer();
        	  sb.append(this.attribut.toString());
        	  return sb.toString();
         }        
}
