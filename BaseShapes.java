/**
 * This abstract class repsents the base shape for fractals.
 * 
 * @author  Ny Pham
 */

import java.awt.Graphics;

public abstract class BaseShapes{
  
  /**
   * Stores the number of sides in the base shape.
   */
  private int numSides;
  
  /**
   * Initializes the number of sides in the base shape.
   * 
   * @param  numSides  the number of sides in the shape
   */
  public BaseShapes(int numSides){
    this.numSides = numSides;
  }
  
  /**
   * Returns the number of sides on the base shape.
   * 
   * @return  the number of sides on the shape
   */
  public int getNumSides(){
    return numSides;
  }
   
   /**
    * Returns the lines that form the base shape.
    * 
    * @return  an array of lines that form the base shape
    */
   public abstract Line[] getLines();
   
   /**
    * Draws the base shape.
    * 
    * @param  graphics  the class used to draw the base shape
    */
   public void draw(Graphics graphics){
     Line[] linesFormingShape = getLines();                                               //stores the array of lines that form the base shape
     //this loop works by getting each element in the array of lines and drawing each line
     for(int i = 0; i < linesFormingShape.length; i++){
       graphics.drawLine(linesFormingShape[i].getFirstPoint().getX(), linesFormingShape[i].getFirstPoint().getY(), linesFormingShape[i].getSecondPoint().getX(), linesFormingShape[i].getSecondPoint().getY());
     }
   }
}