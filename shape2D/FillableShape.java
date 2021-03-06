/* Jimmy Yu
 * Nov 28, 2017
 * Desc: FillableShape parent class
 */
package shape2D;

import java.awt.Graphics;
import java.awt.Color;

abstract class FillableShape extends Shape {
    //Instance variables
    private boolean filled;

    public FillableShape(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1,y1,x2,y2,color);
        setFilled(filled);
    }  
    public boolean getFilled() {
        return filled;
    }
    //Mutator for filled variable
    public void setFilled(boolean newFilled) {
        filled = newFilled;
    }
    //Return the upper left x value
    public int getUpperLeftX() {
      return Math.min(getX1(),getX2());
    }
    //Return the upper left y value
    public int getUpperLeftY() {
      return Math.min(getY1(),getY2()); 
    }
    //Get the absolute x difference
    public int getWidth() {
        return Math.abs(getX2() - getX1());
    }
    //Get the absolute y difference
    public int getHeight() {
        return Math.abs(getY2() - getY1());
    }
    //Returns a String representation of the FillableShape object
    public String toString() {
        return "Coords of this shape: " + getX1() + "," + getY1() + ". " + getX2() + "," + getY2() + ".";
    }
    
}
    