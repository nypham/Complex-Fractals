/**
 * This class will represent a triangle.
 * 
 * @author  Ny Pham
 */

public class Triangle extends BaseShapes{
  
  /**
   * Stores one side of the triangle.
   */
  private Line line1;
  /**
   * Stores one side of the triangle.
   */
  private Line line2;
  /**
   * Stores one side of the triangle.
   */
  private Line line3;
  
  /**
   * Intializes the lines of the triangle.
   * 
   * @param  point1  a point on the triangle
   * @param  point2  a point on the triangle
   * @param  point3  a point on the triangle
   */
  public Triangle(Point point1, Point point2, Point point3){
    super(3);
    if((point1.getX() == point2.getX() && point1.getY() == point2.getY()) || (point1.getX() == point3.getX() && point1.getY() == point3.getY()) || (point2.getX() == point3.getX() && point2.getY() == point3.getY()))
      throw new IllegalArgumentException();
    line1 = new Line(point1, point2);
    line2 = new Line(point2, point3);
    line3 = new Line(point3, point1);
  }
  
  /**
   * Initializes the lines of the triangle to form an equaliteral triangle.
   * 
   * @param  center  the centroid of the equilateral triangle
   * @param  length  the length of each line on the equilateral triangle
   */
  public Triangle(Point center, double length){
    super(3);
    if(length <= 0)
      throw new IllegalArgumentException();
    double triangleHeight = Math.sqrt(Math.pow(length, 2) - (Math.pow(length, 2) / 4));                                  //stores the height of the triangle
    
    Point topPoint = new Point(center.getX(), (int)(center.getY() - (triangleHeight * 2 / 3)));                          //stores the top point of the triangle
    Point rightPoint = new Point((int)(center.getX() + (length / 2)), (int)(center.getY() + (triangleHeight / 3)));      //stores the point of the triangle on the right side
    Point leftPoint = new Point((int)(center.getX() - (length / 2)), (int)(center.getY() + (triangleHeight / 3)));       //stores the point of the triangle on the left side
    
    line1 = new Line(topPoint, rightPoint);
    line2 = new Line(rightPoint, leftPoint);
    line3 = new Line(leftPoint, topPoint);
  }
  
  /**
   * Returns an array of the lines that form the triangle.
   * 
   * @return  an array of the lines that form the triangle
   */
  @Override
  public Line[] getLines(){
    Line[] arrayOfLines = new Line[]{line1, line2, line3};                                                                //stores the array of lines that form the triangle
    return arrayOfLines;
  }
}