/* Jimmy Yu
 * Nov 24, 2017
 * Desc: Rectangle Class
 */
package shape2D;

import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends FillableShape {
    //Instance variables
    private static int numberOfRectangles = 0;
    
    //No-Argument Constructor
    //public Rectangle() {
    // this(0,0,0,0, false);
    //}
    
    //Parameterized Constructor
    public Rectangle(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1,y1,x2,y2,color,filled);
        numberOfRectangles++;
    }
    
    //Accessor for numberOfRectangles static class variable
    public static int getNumberOfRectangles() {
        return numberOfRectangles;
    }
    
    //Calculate the area of the rectangle by multiplying the width and the height
    public double calcArea() {
        return ((double)(getWidth() * getHeight()));
    }
    //Return true if two rectangles are overlapping
    public boolean isOverlapping(Rectangle r2) {
        if ( (getX1() < r2.getX2()) && (getX2() > r2.getX1()) && (getY1() < r2.getY2()) && (getY2() > r2.getY1()) ) {
            return true;
        }
        else {
            return false;
        }
    }
    //Returns a String representation of the current Rectangle object
    @Override
    public String toString() {
        return "Rectangle coords " + getX1() + "," + getY1() + " and " + getX2() + "," + getY2() + ". Rectangle filled is: " + getFilled();
    }
    
    @Override
    public void draw(Graphics g) {
        if (getFilled() == true) {
            g.setColor(getColor());
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
            g.fillRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
        else{
            g.setColor(getColor());
            g.drawRect(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight());
        }
    }
}



