/* Jimmy Yu
 * Nov 28, 2017
 * Desc: Oval Class 
 */
package shape2D;

import java.awt.Graphics;
import java.awt.Color;

public class Oval extends FillableShape{
    //Instance variables
    private static int numOvals = 0;
    
    //No argument constructor
    //public Oval() {
    //  this(0,0,0,0,false);
    //}
    //Parameterized Constructor
    public Oval(int x1, int y1, int x2, int y2, Color color, boolean filled) {
        super(x1,y1,x2,y2,color,filled);
        numOvals++;
    }
    
    //Accessor for number of oval classes variable
    public static int numOvals() {
        return numOvals;
    }
    
    //Calculate the area of the rectangle by multiplying the width and the height
    public double calcArea() {
        return ( (double) (getWidth()/2 * getHeight()/2 * Math.PI) );
    }
    //If the height and width are equal, it is a circle
    public boolean isCircle() {
        if (getWidth() == getHeight()) {
            return true;
        }
        else {
            return false;
        }
    }
    //Returns a String representation of the current Oval object
    @Override
    public String toString() {
        return "Oval coords " + getX1() + "," + getY1() + " and " + getX2() + "," + getY2() + ". Oval filled is: " + getFilled();
    }
    
    @Override
    public void draw(Graphics g) {
        if (getFilled() == true) {
            g.setColor(getColor());
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()); 
            g.fillOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()); 
        }
        else {
            g.setColor(getColor());
            g.drawOval(getUpperLeftX(), getUpperLeftY(), getWidth(), getHeight()); 
        }
        
    }
}






