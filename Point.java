/**
 * This class will represent a two-dimensional point.The point can be 
 * rotated and manipulated with methods in this class.
 *
 * @author  Ny Pham
 */

public class Point{
  
  /**
   * Stores x-coordinate of point.
   */
  private int x;
  /**
   * Stores y-coordinate of point.
   */
  private int y;
  
  /**
   * Initializes the x and y-component of the point.
   * 
   * @param  x  the x-coordinate of the point
   * @param  y  the y-coordinate of the point
   */
  public Point (int x, int y){
    this.x = x;
    this.y = y;
  }
  
  /**
   * Returns the value of x-coordinate of point.
   * 
   * @return  the value of the x-coordinate
   */
  public int getX(){
    return x;
  }
  
  /**
   * Changes x-coordinate of the point to the specified new one.
   * 
   * @param  x  the new x-coordinate of the point
   */
  public void setX (int x){
    this.x = x;
  }
  
  /**
   * Returns the value of y-coordinate of point.
   * 
   * @return  the value of the y-coordinate
   */
  public int getY(){
    return y;
  }
  
  /**
   * Changes y-coordinate of the point to the specified new one.
   * 
   * @param  y  the new y-coordinate of the point
   */
  public void setY (int y){
    this.y = y;
  }
  
  /**
   * Rotates the vector from the origin to the original point by input angle, counter clockwise.
   * 
   * @param  angle  the angle the point will be rotated by in radians
   */
  public void rotate(double angle){
    double newX = (x * Math.cos(angle)) - (y * Math.sin(angle));                      //temporarily stores the new x-coordinate
    double newY = (x * Math.sin(angle)) + (y * Math.cos(angle));                      //temporarily stores the new y-coordinate
    double xDecimal = newX - (int) newX;                                              //stores the decimal place of the new x-coordinate
       if (xDecimal >= 0.5)
         x = (int) newX + 1;
       else
         x = (int) newX;
    double yDecimal = newY - (int) newY;                                             //stores the decimal place of the new y-coordinate                            
       if (yDecimal >= 0.5)
         y = (int) newY + 1;
       else 
         y = (int) newY;
  }
}
