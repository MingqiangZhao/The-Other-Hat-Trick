package TheOtherHatTrick;
/**
 * @author MingQiang
 */
import java.util.*;

import javax.swing.ImageIcon;

public class Tricks { 
   /**
    * Each trick has the attributes "leftAttribut" and "rightAttribut"
    * Each trick relate to a score and a image
    */
   private LinkedList<Attributs>leftAttribut=new LinkedList<Attributs>();
   private LinkedList<Attributs>rightAttribut=new LinkedList<Attributs>();
   private int score;
   public ImageIcon image;
   
   /**
    * This is constructor
    */
   Tricks(){
	   
   }
   
   /**
    * This is constructor
    * @param score initialize the basic information
    */
   Tricks(int score){
	   this.score=score;
   }
   
   /**
    * 
    * @param left This initialize the "leftAttribut"
    * @param right This initialize the "rightAttribut" 
    * @param score This initialize the score
    */
   Tricks(LinkedList<Attributs>left,LinkedList<Attributs>right,int score){
	   this.leftAttribut=left;
	   this.rightAttribut=right;
	   this.score=score;
   } 
   
   public void setScore(int score) {
	   this.score=score;
   }
   
   public int getScore() {
	   return this.score;
   }
   
   public void setLeft(Attributs attr1){
	   this.leftAttribut.add(attr1);
   }

   public void setLeft(Attributs attr1,Attributs attr2){
	   this.leftAttribut.add(attr1);
	   this.leftAttribut.add(attr2);
   }
   
   public LinkedList<Attributs> getLeft(){
	   return this.leftAttribut;
   }
   
   public void setRight(Attributs attr1) {
	   this.rightAttribut.add(attr1);
   }
   
   public void setRight(Attributs attr1,Attributs attr2) {
	   this.rightAttribut.add(attr1);
	   this.rightAttribut.add(attr2);
   }
   
   public LinkedList<Attributs> getRight(){
	   return this.rightAttribut;
   }
   
   public void setImage(ImageIcon image) {
	   this.image = image;
   }
   
   public String toString() {
	   StringBuffer sb=new StringBuffer();
	   sb.append("The attributs are:");
	   sb.append(this.leftAttribut);
	   sb.append(this.rightAttribut);
	   sb.append("Scaore:"+this.getScore());
	   return sb.toString();
   }
               
}
