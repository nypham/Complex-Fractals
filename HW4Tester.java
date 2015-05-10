/**
 * This class tests the Point and Line class of Project 4.
 * 
 * @author  Ny Pham*/

import org.junit.*;
import static org.junit.Assert.*;
import java.awt.Graphics;
import java.awt.Canvas;

public class HW4Tester{
  
  /**
   * This is a helper method to test whether two points are equal.
   * 
   * @param  expected  the point expected
   * @param  received  the resulting point from the tested method*/
  private void equalsPoint(Point expected, Point received){
    assertEquals(expected.getX(), received.getX());
    assertEquals(expected.getY(), received.getY());
  }
  
  /**
   * This is a helper method to test whether two lines are equal.
   * 
   * @param  expected  the expected line
   * @param  received  the received line
   */
  private void equalsLine(Line expected, Line received){
    equalsPoint(expected.getFirstPoint(), received.getFirstPoint());
    equalsPoint(expected.getSecondPoint(), received.getSecondPoint());
  }
    
  /**
   * This is a helper method to test whether two array of lines are equal.
   * 
   * @param  expected  what is expected from the array of lines
   * @param  received  what is received from the array of lines
   */
  private void equalsArrayLines(Line[] expected, Line[] received){
    assertEquals(expected.length, received.length);
    for(int i = 0; i < expected.length; i++){
      equalsLine(expected[i], received[i]);
    }
  }
    
  /**
   * Tests the Point class.
   */
  @Test
  public void testPointClass(){
    Point test = new Point(0, 0);                                                  //tests zero values for point
    assertEquals(0, test.getX());                                                  //tests getX()
    assertEquals(0, test.getY());                                                  //tests getY()
    test.setX(3);
    test.setY(4);
    assertEquals(3, test.getX());                                                  //tests setX()
    assertEquals(4, test.getY());                                                  //tests setY()
    test.rotate(Math.PI / 6);
    equalsPoint(new Point(1,5), test);                                             //tests rotate
  }
    
  /**
   * Tests the BaseShapes class and Line class.
   */
  @Test
  public void testBaseShapesClassAndLineClass(){
    Line test = new Line(new Point(400,300), new Point(100, 750));
      
    equalsPoint(new Point(400, 300), test.getFirstPoint());                        //tests the constructor that accepts 2 points and tests getFirstPoint() in Line
    equalsPoint(new Point(100, 750), test.getSecondPoint());                       //tests getSecondPoint() in Line
    test.setFirstPoint(new Point(500, 700));
    try{                                                                           //tests the exception in setSecondPoint() in Line
      test.setSecondPoint(new Point(500, 700));
    }
    catch(IllegalArgumentException e){
    }
    test.setSecondPoint(new Point(300, 250));
    try{                                                                           //tests the exception in setFirstPoint() in Line
      test.setFirstPoint(new Point(300, 250));
    }
    catch(IllegalArgumentException e){
    }
    equalsPoint(new Point(500, 700), test.getFirstPoint());                        //tests setFirstPoint() in Line
    equalsPoint(new Point(300, 250), test.getSecondPoint());                       //tests setSecondPoint() in Line
    try{                                                                           //tests exception for constructor that accepts 2 Points in Line
      Line testExcept = new Line(new Point(500, 500), new Point(500, 500));
    }
    catch(IllegalArgumentException e){
    }
    try{                                                                           //tests the exception for constructor that accepts 4 ints in Line
      Line testExcept = new Line(500, 500, 500, 500);
    }
    catch(IllegalArgumentException e){
    }
    assertEquals(1, test.getNumSides());                                           //tests the getNumSides() method in BaseShapes inherited by Line and the constructor of BaseShapes
    equalsArrayLines(new Line[]{new Line(500, 700, 300, 250)}, test.getLines());   //tests getLines() in Line class
    
    Line testNeg = new Line(-500, 200, 600, -800);
    equalsPoint(new Point(-500, 200), testNeg.getFirstPoint());                    //tests negative values for the first point in line
    equalsPoint(new Point(600, -800), testNeg.getSecondPoint());                   //tests the negative values for the second point in line
      
    Line testZero = new Line(0, 0, 100, 100);
    equalsPoint(new Point(0,0), testZero.getFirstPoint());                         //tests zero values for one end point of line
    }
    
  /**
   * Tests the Rectangle Class.
   */
  @Test
  public void testRectangleClass(){
    try{                                                                           //tests the exception in the constructor when the two input points share an x coordinate
      Rectangle test = new Rectangle(new Point(200, 300), new Point(200, 800));
    }
    catch(IllegalArgumentException e){
    }
    try{                                                                           //tests the exception in the constructor when the two input points share a y coordinate
      Rectangle test = new Rectangle(new Point(200, 300), new Point(800, 300));
    }
    catch(IllegalArgumentException e){
   }
    try{                                                                           //tests the exception in the constructor when the length is less than or equal to zero
      Rectangle test = new Rectangle(new Point(200, 300), -500);
    }
    catch(IllegalArgumentException e){
    }
    Rectangle testRect = new Rectangle(new Point(100,100), new Point(600, 500));   //tests getReferencePoint(), getWidth(), getHeight(), and getLines() for a rectangle made with 2 points
    equalsPoint(new Point(100, 100), testRect.getReferencePoint());
    assertEquals(500, testRect.getWidth());
    assertEquals(400, testRect.getHeight());
    equalsArrayLines(new Line[]{new Line(new Point(100, 100), new Point(600, 100)), new Line(new Point(600, 100), new Point(600, 500)), new Line(new Point(600, 500), new Point(100, 500)), new Line(new Point(100, 500), new Point(100, 100))}, testRect.getLines());
    Rectangle testSquare = new Rectangle(new Point(200, 200), 100);                //tests getReferencePoint(), getWidth(), getHeight(), and getLines() for a square made by the Rectangle class
    equalsPoint(new Point(150, 150), testSquare.getReferencePoint());
    assertEquals(100, testSquare.getWidth());
    assertEquals(100, testSquare.getHeight());
    equalsArrayLines(new Line[]{new Line(new Point(150, 150), new Point(250, 150)), new Line(new Point(250, 150), new Point(250, 250)), new Line(new Point(250, 250), new Point(150, 250)), new Line(new Point(150, 250), new Point(150, 150))}, testSquare.getLines());
    Rectangle testNegAndZero = new Rectangle(new Point(0, 0), 10);                 //tests getReferencePoint(), getWidth(), getHeight(), and getLines() for a square made by the Rectangle class such that it ha negative and zero values 
    equalsPoint(new Point(-5, -5), testNegAndZero.getReferencePoint());
    assertEquals(10, testNegAndZero.getWidth());
    assertEquals(10, testNegAndZero.getHeight());
    equalsArrayLines(new Line[]{new Line(new Point(-5, -5), new Point(5, -5)), new Line(new Point(5, -5), new Point(5, 5)), new Line(new Point(5,5), new Point(-5, 5)), new Line(new Point(-5, 5), new Point(-5, -5))}, testNegAndZero.getLines());
  }
    
  /**
   * Tests Triangle class.
   */
  @Test
  public void testTriangleClass(){
    try{                                                                           //tests the exception in the constructor that accepts 3 points
      Triangle test = new Triangle(new Point(100, 200), new Point(100, 200), new Point(800, 600));
    }
    catch(IllegalArgumentException e){
    }
    try{                                                                           //tests the exception in the constructor that acceptes a point and a length
      Triangle test = new Triangle(new Point(100, 100), 500);
    }
    catch(IllegalArgumentException e){
    }
    /*tests the constructor that accepts 3 points tests positive coordinates*/
    Triangle testConstr1 = new Triangle(new Point (400, 100), new Point(600, 600), new Point(200, 650));
    /*tests the getLines() method*/
    equalsArrayLines(new Line[]{new Line(new Point(400, 100), new Point(600, 600)), new Line(new Point(600, 600), new Point(200, 650)), new Line(new Point(200, 650), new Point(400, 100))}, testConstr1.getLines());
      
    /*tests the constructor that accepts a point and a length*/
    Triangle testConstr2 = new Triangle(new Point(90, 90), 90);
    /*tests the getLines() method when the triangle is made using a point and length*/
    equalsArrayLines(new Line[]{new Line(new Point(90,38), new Point(135, 115)), new Line(new Point(135,115), new Point(45, 115)), new Line(new Point(45, 115), new Point(90, 38))}, testConstr2.getLines());
      
    /*tests the constructor that accepts a point and a length with an input that will result in negative values using a (0, 0) centerpoint*/
    Triangle testNegAndZero = new Triangle(new Point(0, 0), 90);
    /*tests getLines() for a triangle involving negative and zero values*/
    equalsArrayLines(new Line[]{new Line(new Point(0, -51), new Point(45, 25)), new Line(new Point(45, 25), new Point(-45, 25)), new Line(new Point(-45, 25), new Point(0, -51))}, testNegAndZero.getLines());
  }
    
  /**
   * Tests Fractal class and FlakeFractal class.
   */
  @Test
  public void testFractalAndFlakeFractalClass(){
    Line testLine = new Line(0, 0, 9, 9);
    FlakeFractal testFlakeFract = new FlakeFractal(testLine);
    
    equalsLine(testLine, (Line)testFlakeFract.getBaseShapes());                      //tests the getBaseShapes() method of the Fractal class
    Line[] testArrayLine = new Line[]{new Line(new Point(0, 0), new Point(3, 3)), new Line(new Point(3, 3), new Point(7, 2)), new Line(new Point(7, 2), new Point(6, 6)), new Line(new Point(6, 6), new Point(9, 9))};
    Fractal[] testArrayFractal = testFlakeFract.subFractals();
    assertEquals(testArrayLine.length, testArrayFractal.length);
    for(int i = 0; i < testArrayFractal.length; i++){                                //tests subFractals method in FlakeFractal
      equalsLine(testArrayLine[i], (Line)(testArrayFractal[i].getBaseShapes()));
    }
  }
  
  /**
   * Tests TreeFractal class.
   */
  @Test
  public void testTreeFractalClass(){
    Line testLine = new Line(0, 0, 30, 30);
    TreeFractal testTree = new TreeFractal(testLine);
    
    Line[] testArrayLine = new Line[]{new Line(new Point(30, 30),new Point(50, 25)), new Line(new Point(30, 30), new Point(25, 50))};
    Fractal[] testArrayFractal = testTree.subFractals();
    assertEquals(testArrayLine.length, testArrayFractal.length);
    for(int i = 0; i < testArrayFractal.length; i++){                                //tests subFractals method in TreeFractal
      equalsLine(testArrayLine[i], (Line)(testArrayFractal[i].getBaseShapes()));
    }
  }
  
  /**
   * Tests the TriangleFractal class.
   */
  @Test
  public void testTriangleFractal(){
    Triangle testTriangle = new Triangle(new Point(90, 38), new Point(135, 115), new Point(45,115));
    TriangleFractal testTriFract = new TriangleFractal(testTriangle);
    
    Triangle[] triangleArray = new Triangle[]{new Triangle(new Point(90,38), new Point(135,115), new Point(90,89)), new Triangle(new Point(90,89), new Point(135,115), new Point(45,115)), new Triangle(new Point(90,38), new Point(90,89), new Point(45,115))};
    assertEquals(triangleArray.length, testTriFract.subFractals().length);
    for(int i = 0; i < triangleArray.length; i++){                                   //tests the subFractals() method
      equalsArrayLines(triangleArray[i].getLines(), ((Triangle)(testTriFract.subFractals()[i].getBaseShapes())).getLines());
    }
  }
  
  /**
   * Tests the RectFractal class.
   */
  @Test
  public void testRectFractal(){
    Rectangle testSquare = new Rectangle(new Point(90, 90), 90);
    RectFractal testRectFract = new RectFractal(testSquare);
    
    Rectangle[] rectArray = new Rectangle[]{new Rectangle(new Point(45, 45), new Point(75, 75)), new Rectangle(new Point(75,45), new Point(105,75)), new Rectangle(new Point(105,45), new Point(135, 75)), new Rectangle(new Point(45,75), new Point(75,105)), new Rectangle(new Point(105,75), new Point(135,105)), new Rectangle(new Point(45,105), new Point(75,135)), new Rectangle(new Point(75,105), new Point(105,135)), new Rectangle(new Point(105,105), new Point(135,135))};
    assertEquals(rectArray.length, testRectFract.subFractals().length);
    for(int i = 0; i < rectArray.length; i++){                                       //tests subFractals() method
      equalsArrayLines(rectArray[i].getLines(), ((Rectangle)(testRectFract.subFractals()[i].getBaseShapes())).getLines());
    }
  }
  
  /**
   * Tests FractalPicture class and TreePicture class.
   */
  @Test
  public void testFractalPictureAndTreePicture(){
    Line testLine1 = new Line(100,100, 200, 200);
    Line testLine2 = new Line(200, 200, 400, 400);
    Line[] testEmpty = new Line[0];
    TreePicture testTreePic = new TreePicture(new Line[]{testLine1, testLine2});
    
    try{                                                                             //tests the exception thrown in constructor of TreePicture and FractalPicture; tests 0 array length
      TreePicture testExcept = new TreePicture(testEmpty); 
    }
    catch(IllegalArgumentException e){
    }
    Line[][] expectedLines = new Line[][]{{testLine1}, {testLine2}};
    assertEquals(expectedLines.length, testTreePic.getBaseFractals().length);        //tests getBaseFractals() method in TreePicture (test many and 1)
    for(int i = 0; i < expectedLines.length; i++){                                   //tests getBaseFractals() method in TreePicture (test many and 1)
      TreeFractal[] temp = testTreePic.getBaseFractals()[i];
      for(int j = 0; j < temp.length; j++){
        equalsArrayLines(expectedLines[i], temp[j].getBaseShapes().getLines());
      }
    }
    try{                                                                             //tests the setFractal exception
      Triangle testTri = new Triangle(new Point(100, 100), new Point(150, 150), new Point(50, 150));
      TreePicture testTree = new TreePicture(new Triangle[]{testTri});
      TreeFractal replacement = new TreeFractal(testLine1);
      testTree.setFractal(-5, replacement);
    }
    catch(IllegalArgumentException e){
    }
    Triangle testTri = new Triangle(new Point(100, 100), new Point(150, 150), new Point(50, 150));
    TreePicture testTree = new TreePicture(new Triangle[]{testTri});
    TreeFractal replacement = new TreeFractal(testLine1);
    testTree.setFractal(0, replacement);                                             //tests setFractal for the first line in the base fractals
    Line[][] expectedLines2 = new Line[][]{{testLine1}, {new Line(new Point(150, 150), new Point(50,150))}, {new Line(new Point(50, 150), new Point(100,100))}};
    assertEquals(expectedLines2[0].length, testTree.getBaseFractals()[0][0].getBaseShapes().getLines().length);
    for(int i = 0; i < expectedLines2.length; i++){
      equalsLine(expectedLines2[0][i], testTree.getBaseFractals()[0][0].getBaseShapes().getLines()[i]);
    }
    testTree.setFractal(1, replacement);                                             //tests setFractal for the middle line in the base fractals
    Line[][] expectedLines3 = new Line[][]{{testLine1}, {testLine1}, {new Line(new Point(50, 150), new Point(100,100))}};
    assertEquals(expectedLines3[0].length, testTree.getBaseFractals()[0][0].getBaseShapes().getLines().length);
    for(int i = 0; i < expectedLines3.length; i++){
      equalsLine(expectedLines3[0][i], testTree.getBaseFractals()[0][0].getBaseShapes().getLines()[i]);
    }
    testTree.setFractal(2, replacement);                                             //tests setFractal for the last line in the base fractals
    Line[][] expectedLines4 = new Line[][]{{testLine1}, {testLine1}, {testLine1}};
    assertEquals(expectedLines4[0].length, testTree.getBaseFractals()[0][0].getBaseShapes().getLines().length);
    for(int i = 0; i < expectedLines4.length; i++){
      equalsLine(expectedLines4[0][i], testTree.getBaseFractals()[0][0].getBaseShapes().getLines()[i]);
    }
  }
  
  /**
   * Tests SnowflakePicture class.
   */
  @Test
  public void testSnowflakePictureClass(){
    Line line1 = new Line(200, 200, 400, 400);
    Line line2 = new Line(500, 500, 600, 600);
    SnowflakePicture testSnow = new SnowflakePicture(new Line[]{line1, line2});
    Line[][] expected = new Line[][]{{line1}, {line2}};
    assertEquals(expected.length, testSnow.getBaseFractals().length);                //tests getBaseFractals() method in SnowflakePicture (test many and 1)
    for(int i = 0; i < expected.length; i++){                                        //tests getBaseFractals() method in SnowflakePicture (test many and 1)
      FlakeFractal[] temp = testSnow.getBaseFractals()[i];
      for(int j = 0; j < temp.length; j++){
        equalsArrayLines(expected[i], temp[j].getBaseShapes().getLines());
      }
    }
  }
  
  /**
   * Tests TrianglePicture class.
   */
  @Test
  public void testTrianglePictureClass(){
    Triangle testTri = new Triangle(new Point(100,100), new Point(150,150), new Point(50, 150));
    TrianglePicture triPic = new TrianglePicture(new Triangle[]{testTri});
    Line[][] expected = new Line[][]{{new Line(new Point(100,100), new Point(150,150)), new Line(new Point(150,150), new Point(100,133)), new Line(new Point(100,133), new Point(100,100))}};
    assertEquals(expected.length, triPic.getBaseFractals().length);                  //tests getBaseFractals() method in TrianglePicture(test many and 1)
    for(int i = 0; i < triPic.getBaseFractals().length; i++){
      TriangleFractal[] temp = triPic.getBaseFractals()[i];
      equalsArrayLines(expected[0], temp[0].getBaseShapes().getLines());
    }
  }
  
  /**
   * Tests CarpetPicture class.
   */
  @Test
  public void testCarpetPictureClass(){
    Rectangle square = new Rectangle(new Point(400,400), 400);
    CarpetPicture testCarpet = new CarpetPicture(new Rectangle[]{square});
    Line[][] expected = new Line[][]{{new Line(new Point(200, 200), new Point(333, 200)), new Line(new Point(333,200), new Point(333,333)), new Line(new Point(333,333), new Point(200,333)), new Line(new Point(200,333), new Point(200,200))}};
    assertEquals(expected.length,testCarpet.getBaseFractals().length);               //tests getBaseFractals() method in CarpetPicture(test many and 1)
    for(int i = 0; i < testCarpet.getBaseFractals().length; i++){
      RectFractal[] temp = testCarpet.getBaseFractals()[i];
      equalsArrayLines(expected[0], temp[0].getBaseShapes().getLines());
    }
  }
  
  /**
   * Tests DrawFractal class.
   */
  @Test
  public void testDrawFractalClass(){
    try{                                                                             //tests the exception in the constructor
      DrawFractal test = new DrawFractal(-100, -200);
    }
    catch(IllegalArgumentException e){
    }
    
  }
}