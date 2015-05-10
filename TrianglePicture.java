/**
 * This class represents a picture composed of triangle fractals.
 * 
 * @author  Ny Pham
 */

import java.awt.Graphics;

public class TrianglePicture extends FractalPicture{
  
  /**
   * Stores the base shapes.
   */
  private Triangle[] triangles;
  
  /**
   * Initializes the array of base shapes.
   * 
   * @param  triangles  an array of triangles to be part of the picture
   */
  public TrianglePicture(Triangle[] triangles){
    super(triangles);
    this.triangles = triangles;
  }
  
  /**
   * Returns the base fractals that form the triangle fractal picture
   * 
   * @return  the base fractals that form the picture
   */
  public TriangleFractal[][] getBaseFractals(){
    TriangleFractal[][] arrayOfBaseFracts = new TriangleFractal[triangles.length][];            //stores the the base fractals that form the picture
    for(int i = 0; i < triangles.length; i++){
      arrayOfBaseFracts[i] = new TriangleFractal(triangles[i]).subFractals();
    }
    return arrayOfBaseFracts;
  }
}