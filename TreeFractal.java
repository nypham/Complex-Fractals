/**
 * This class will represent a tree fractal whose base shape is a line.
 * 
 * @author  Ny Pham
 */

import java.awt.Graphics;

public class TreeFractal extends Fractal{
  
  /**
   * This stores the base shape.
   */
  private Line line;
  
  /**
   * This initializes the base shape.
   * 
   * @param  line  the line used to create the tree fractal
   */
  public TreeFractal(Line line){
    super(line);
    this.line = line;
  }
  
  /**
   * Returns an array of subfractals.
   * 
   * @return  the array of subfractals
   */
  @Override
  public TreeFractal[] subFractals(){
    int xStart = line.getFirstPoint().getX();                                                    //stores the x-coordinate of the first point of the line
    int yStart = line.getFirstPoint().getY();                                                    //stores the y-coordinate of the first point of the line 
    int xEnd = line.getSecondPoint().getX();                                                     //stores the x-coordinate of the end point of the line
    int yEnd = line.getSecondPoint().getY();                                                     //stores the y-coordinate of the end point of the line
    int xHalfDifference = (xEnd - xStart) / 2;                                                   //stores difference between the x values of the points that make the line
    int yHalfDifference = (yEnd - yStart) / 2;                                                   //stores difference between the y values of the points that make the line   
    Point halfWay = new Point(xStart + xHalfDifference, yStart + yHalfDifference);               //stores the point that is halfway between the two end points of the line
    Point tempPoint = new Point(halfWay.getX() - xEnd, halfWay.getY() - yEnd);                   //stores the point to be adjusted and temporarily stores the point that is to be rotated
    tempPoint.rotate(Math.PI * 2 / 3);
    Point rightPoint = new Point(tempPoint.getX() + xEnd, tempPoint.getY() + yEnd);              //stores the new end point for the fractal to the right of the original line
    tempPoint.rotate(Math.PI * 2 / 3);
    Point leftPoint = new Point(tempPoint.getX() + xEnd, tempPoint.getY() + yEnd);               //stores the new end point for the fractal to the left of the original line
    
    TreeFractal rightTreeFract = new TreeFractal(new Line(line.getSecondPoint(), rightPoint));   //stores the new tree fractal for the tree fractal to the right of the original
    TreeFractal leftTreeFract = new TreeFractal(new Line(line.getSecondPoint(), leftPoint));     //stores the new tree fractal for the tree fractal to the left of the original
    TreeFractal[] arrayOfTreeFractals = new TreeFractal[]{rightTreeFract, leftTreeFract};        //sotres the array of new tree fractals
    return arrayOfTreeFractals;
  }
  
  /**
   * Draws the fractal.
   * 
   * @param  level     the number of layers of fractals that will exist
   * @param  graphics  the graphics context used to draw the fractal
   */
  @Override
  public void draw(int level, Graphics graphics){
    if(level < 0)
      throw new IllegalArgumentException("Fractal levels cannot be negative.");
    line.draw(graphics);
    if(level == 0){
      line.draw(graphics);
    }
    else{
      TreeFractal[] subFractals = this.subFractals();                        //this temporarily stores the subfractals that form the fractal
      //this loop works by going through each element in the array of subfractals
      //and by recursion, drawing each line in the subfractal
      for(int i = 0; i < subFractals.length; i++){
        TreeFractal temp = subFractals[i];                                  //temporarily stores the element in the array
        temp.draw(level - 1, graphics);
      }
    }
  }
}