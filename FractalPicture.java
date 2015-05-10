/**
 * This abstract class will representh the idea of a picture of a fractal.
 * 
 * @author  Ny Pham
 */

import java.awt.Graphics;

public abstract class FractalPicture{
  
  /**
   * Stores the base shape used to create the subfractals.
   */
  private BaseShapes[] baseShapes;
  
  /**
   * Initializes the base shape.
   * 
   * @param  baseShape  the base shape used to create the subfractals of the picture
   */
  public FractalPicture(BaseShapes[] baseShapes){
    if(baseShapes.length == 0)
      throw new IllegalArgumentException("Empty array.");
    this.baseShapes = baseShapes;
  }
  
  /**
   * This draws the picture of the fractal.
   * 
   * @param  level     the number of layers of fractals that will exist
   * @param  graphics  the class used to draw the fractal
   */
  public void draw(int level, Graphics graphics){
    if(level < 0)
      throw new IllegalArgumentException("Fractal levels cannot be negative.");
    if(level == 0){
      for(int i = 0; i < baseShapes.length; i++){
        baseShapes[i].draw(graphics);
      }
    }
    else{
      Fractal[][] baseFracts = getBaseFractals();                             //stores the array of fractals that form the picture
      for(int i = 0; i < baseFracts.length; i++){
        //this loop works by going through each element in the array of base fractals and drawing each one
        for(int j = 0; j < baseFracts[i].length; j++){
          baseFracts[i][j].draw(level - 1, graphics);
        }
      }
    }
  }
  
  /**
   * Returns an array of base fractals.
   * 
   * @return  an array of base fractals that form the picture
   */
  public abstract Fractal[][] getBaseFractals();
  
  /**
   * This method changes the base fractal in the array at the given index to be a different one.
   * 
   * @param  index    index in the array of the element that we want to replace
   * @param  fractal  the fractal that will replace the element at the specified index
   */
  public void setFractal(int index, Fractal fractal){
    if(index < 0)
      throw new IllegalArgumentException("The index of an array cannot be negative.");
    for(int i = 0; i < getBaseFractals().length; i++){
    getBaseFractals()[i][index] = fractal;
    }
  }
}