/**
 * This class represents a triangle fractal. The fractal is composed of 3 triangles 
 * found by finding the centroid of the original triangle and connecting it to the 
 * 3 points.
 * 
 * @author  Ny Pham
 */

public class TriangleFractal extends Fractal{
  
  /**
   * Stores the base shape of the fractal.
   */
  private Triangle triangle;
  
  /**
   * Initializes the base shape of the fractal.
   */
  public TriangleFractal(Triangle triangle){
    super(triangle);
    this.triangle = triangle;
  }
  
  /**
   * This method returns an array of subfractals that form this fractal.
   * 
   * @return  the array of subfractals
   */
  @Override
  public TriangleFractal[] subFractals(){
    Line[] lines = triangle.getLines();                                                                                      //stores the lines that form the base shape
    Line line1 = lines[0];                                                                                                   //stores the first line of the triangle
    Line line2 = lines[1];                                                                                                   //stores the second line of the triangle
    Line line3 = lines[2];                                                                                                   //stores the third line of the triangle
    Point A = line1.getFirstPoint();                                                                                         //stores the first point of the triangle
    Point B = line2.getFirstPoint();                                                                                         //stores the second point of the triangle
    Point C = line3.getFirstPoint();                                                                                         //stores the third point of the triangle
    int xCenter = (A.getX() + B.getX() + C.getX()) / 3;                                                                      //stores the x component of the centroid
    int yCenter = (A.getY() + B.getY() + C.getY()) / 3;                                                                      //stores the y component of the centroid
    Point center = new Point(xCenter, yCenter);                                                                              //stores the center point of the triangle
    Triangle triangle1 = new Triangle(A, B, center);                                                                         //stores one of the new triangles made from the base shape
    Triangle triangle2 = new Triangle(center, B, C);                                                                         //stores one of the new triangles made from the base shape
    Triangle triangle3 = new Triangle(A, center, C);                                                                         //stores one of the new triangles made from the base shape
    TriangleFractal trianglefract1 = new TriangleFractal(triangle1);                                                         //stores one of the new triangle subfractals
    TriangleFractal trianglefract2 = new TriangleFractal(triangle2);                                                         //stores one of the new triangle subfractals
    TriangleFractal trianglefract3 = new TriangleFractal(triangle3);                                                         //stores one of the new triangle subfractals
    TriangleFractal[] arrayOfTriangleFracts = new TriangleFractal[]{trianglefract1, trianglefract2, trianglefract3};         //stores the array of subfractals
    return arrayOfTriangleFracts;
  }
}