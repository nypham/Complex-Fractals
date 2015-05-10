/**
 * This class represents a Sierpinski carpet.
 * 
 * @author  Ny Pham
 */

import java.awt.Graphics;

public class CarpetPicture extends FractalPicture{
  
  /**
   * Stores the base shape of the carpet.
   */
  private Rectangle[] rectangles;
  
  /**
   * Initializes the base shape of the Sierpinski carpet.
   * 
   * @param  rectangle  the base shape of the Sierpinski carpet
   */
  public CarpetPicture(Rectangle[] rectangles){
    super(rectangles);
    this.rectangles = rectangles;
  }
  
  /**
   * Returns an array of the base fractals that form the Sierpinski carpet.
   * 
   * @return  the array of base fractals
   */
  @Override
  public RectFractal[][] getBaseFractals(){
    RectFractal[][] arrayOfBaseFracts = new RectFractal[rectangles.length][];
    for(int i = 0; i < rectangles.length; i++){
      arrayOfBaseFracts[i] = new RectFractal(rectangles[i]).subFractals();
    }
    return arrayOfBaseFracts;
  }
  
  /**
   * This draws the picture of the carpet.
   * 
   * @param  level     the number of layers of fractals that will exist
   * @param  graphics  the class used to draw the fractal
   */
  @Override
  public void draw(int level, Graphics graphics){
    if(level < 0)
      throw new IllegalArgumentException("Fractal levels cannot be negative.");
    if(level == 0){
      for(int i = 0; i < rectangles.length; i++){
        rectangles[i].draw(graphics);
      }
    }
    else{
      RectFractal[][] baseFracts = getBaseFractals();                             //stores the array of fractals that form the picture
      for(int i = 0; i < baseFracts.length; i++){
        rectangles[i].draw(graphics);
        for(int j = 0; j < baseFracts[i].length; j++){
          baseFracts[i][j].draw(level - 1, graphics);
        }
      }
    }
  }
}