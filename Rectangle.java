/**
 * This class will represent a rectangle.
 * 
 * @author  Ny Pham
 */

import java.awt.Graphics;

public class Rectangle extends BaseShapes{
  
  /**
   * Stores the top line of the rectangle.
   */
  private Line topLine;
  /**
   * Stores the right line of the rectangle.
   */
  private Line rightLine;
  /**
   * Stores the bottom line of the rectangle.
   */
  private Line bottomLine;
  /**
   * Stores the left line of the rectangle.
   */
  private Line leftLine;
  /**
   * Stores the most top, left point of the rectangle.
   */
  private Point referencePoint;
  /**
   * Stores the width of the rectangle.
   */
  private int width;
  /**
   * Stores the height of the rectangle.
   */
  private int height;
  
  /**
   * Initializes all lines that form the rectangle, the reference point, the width, and height.
   * 
   * @param  point1  a point on one of the corners of the rectangle
   * @param  point2  the point opposite to point1 that also lies on one of the corners
   */
  public Rectangle(Point point1, Point point2){
    super(4);
    if(point1.getX() == point2.getX() || point1.getY() == point2.getY())
      throw new IllegalArgumentException("Input points are not opposite to each other.");
    int point1X = point1.getX();                 //stores the x of the first point
    int point1Y = point1.getY();                 //stores the y of the first point
    int point2X = point2.getX();                 //stores the x of the second point
    int point2Y = point2.getY();                 //stores the y of the second point
    
    if(point1X < point2X){
      width = point2X - point1X;
      if(point1Y < point2Y){
        height = point2Y - point1Y;
        topLine = new Line(point1X, point1Y, point2X, point1Y);
        rightLine = new Line(point2X, point1Y, point2X, point2Y);
        bottomLine = new Line(point2X, point2Y, point1X, point2Y);
        leftLine = new Line(point1X, point2Y, point1X, point1Y);
      }
      if(point1Y > point2Y){
        height = point1Y - point2Y;
        topLine = new Line(point1X, point2Y, point2X, point2Y);
        rightLine = new Line(point2X, point2Y, point2X, point1Y);
        bottomLine = new Line(point2X, point1Y, point1X, point1Y);
        leftLine = new Line(point1X, point1Y, point1X, point2Y);
      }
    }
    if(point1X > point2X){
      width = point1X - point2X;
      if(point1Y > point2Y){
        height = point1Y - point2Y;
        bottomLine = new Line(point1X, point1Y, point2X, point1Y);
        leftLine = new Line(point2X, point1Y, point2X, point2Y);
        topLine = new Line(point2X, point2Y, point1X, point2Y);
        rightLine = new Line(point1X, point2Y, point1X, point1Y);
      }
      if(point1Y < point2Y){
        height = point2Y - point1Y;
        leftLine = new Line(point2X, point2Y, point2X, point1Y);
        topLine = new Line(point2X, point1Y, point1X, point1Y);
        rightLine = new Line(point1X, point1Y, point1X, point2Y);
        bottomLine = new Line(point1X, point2Y, point2X, point2Y);
      }
    }
    referencePoint = topLine.getFirstPoint();
  }
  
  /**
   * Initializes all lines that form the rectangle, the reference point, the width, and height.
   * In this constructor, a square is made. 
   * 
   * @param  center  this is point that the square will be centered around
   * @param  length  this is the length of each side of the square
   */
  public Rectangle(Point center, int length){
    super(4);
    if(length <= 0)
      throw new IllegalArgumentException("Length cannot be negative or zero.");
    width = length;  
    height = length;  
    int centerX = center.getX();                        //stores the x of the center point
    int centerY = center.getY();                        //stores the y of the center point
    int distanceFromCenter = length / 2;                //stores the distance from the center point each line will be
    topLine = new Line(centerX - distanceFromCenter, centerY - distanceFromCenter, centerX + distanceFromCenter, centerY - distanceFromCenter);
    rightLine = new Line(centerX + distanceFromCenter, centerY - distanceFromCenter, centerX + distanceFromCenter, centerY + distanceFromCenter);
    bottomLine = new Line(centerX + distanceFromCenter, centerY + distanceFromCenter, centerX - distanceFromCenter, centerY + distanceFromCenter);
    leftLine = new Line(centerX - distanceFromCenter, centerY + distanceFromCenter, centerX - distanceFromCenter, centerY - distanceFromCenter);
    referencePoint = topLine.getFirstPoint();
  }
  
  /**
   * Returns the point of the rectangle in the top, left corner.
   * 
   * @return  the point of the rectangle in the top, left corner
   */
  public Point getReferencePoint(){
    return referencePoint;
  }
  
  /**
   * Returns the width of the rectangle.
   * 
   * @param  the width of the rectangle
   */
  public int getWidth(){
    return width;
  }
  
  /**
   * Returns the height of the rectangle.
   * 
   * @param  the height of the rectangle
   */
  public int getHeight(){
    return height;
  }
  
  /**
   * Returns an array of lines that form the rectangle.
   * 
   * @return  an array of the lines that form the rectangle
   */
  @Override
  public Line[] getLines(){
    Line[] arrayOfLines = new Line[]{topLine, rightLine, bottomLine, leftLine};       //stores the array of lines that form the rectangle
    return arrayOfLines;
  }
  
  /**
   * Draws the the solid center part of the rectangle.
   * 
   * @param  graphics  the graphics class used to draw the rectangle
   */
  @Override
  public void draw(Graphics graphics){
    graphics.fillRect(referencePoint.getX() + width / 3, referencePoint.getY() + height / 3, width / 3, height / 3);
  }
}
  
  