/**
 * This class will represent a two-dimensional line segment.
 * Points from the line can be obtained and manipulated from 
 * this class
 *
 * @author  Ny Pham
 */

public class Line extends BaseShapes{
  
  /**
   * Stores the starting point of the line.
   */
  private Point start;
  /**
   * Stores the ending point of the line.
   */
  private Point end;
  
  /**
   * Initilizes the starting and ending point of the line.
   * 
   * @param  start  the starting point of the line
   * @param  end    the ending point of the line
   */
  public Line (Point start, Point end){
    super(1);
    if(start.getX() == end.getX() && start.getY() == end.getY())
      throw new IllegalArgumentException("Inputs do not form a line.");
    this.start = start;
    this.end = end;
  }
  
  /**
   * Assigns coordinate points to starting and ending point.
   * 
   * @param  x1  the x-coordinate of the starting point of the line
   * @param  y1  the y-coordainte of the starting point of the line
   * @param  x2  the x-coordainte of the ending point of the line
   * @param  y2  the y-coordinate of the ending point of the line
   */
  public Line (int x1, int y1, int x2, int y2){
    super(1);
    if(x1 == x2 && y1 == y2)
      throw new IllegalArgumentException("Inputs do not form a line.");
    start = new Point(x1,y1);
    end = new Point(x2,y2);
  }
  
  /**
   * Returns the value of first point on line segment.
   * 
   * @return  the starting point of the line
   */
  public Point getFirstPoint(){
    return start;
  }
  
  /**
   * Returns the value of second point on line segment.
   * 
   * @return  the ending point of the line
   */
  public Point getSecondPoint(){
    return end;
  }
  
  /**
   * Sets the values for the first point on the line segment.
   * 
   * @param  point  the new starting point of the line
   */
  public void setFirstPoint (Point point){
    if(point.getX() == this.getSecondPoint().getX() && point.getY() == this.getSecondPoint().getY())
      throw new IllegalArgumentException("Input does not form a line with other point.");
    start = point;
  }
  
  /**
   * Sets the values for the second point on the line segment.
   * 
   * @param  point  the new ending point of the line
   */
  public void setSecondPoint(Point point){
    if(point.getX() == this.getFirstPoint().getX() && point.getY() == this.getFirstPoint().getY())
      throw new IllegalArgumentException("Input does not form a line with other point.");
    end = point;
  }
  
  /**
   * Returns an array of all of the line types that make up this line.
   * 
   * @return  an array of the lines that make up this line
   */
  @Override
  public Line[] getLines(){
    Line[] lineArray = new Line[]{this};                   //stores an array of lines that form this line
    return lineArray;
  }
}

    