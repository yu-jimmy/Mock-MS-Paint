package shape2D;

import java.awt.Graphics;
import java.awt.Color;

public abstract class Shape {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private Color color;
    
    public Shape(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1; 
        this.y1 = y1; 
        this.x2 = x2; 
        this.y2 = y2; 
        this.color = color;     
    }
    //Accessor for the x1 variable
    public int getX1() {
        return x1;
    }
    //Accessor for the y1 variable
    public int getY1() {
        return y1;
    }
    //Accessor for the x2 variable
    public int getX2() {
        return x2;
    }
    //Accessor for the y2 variable
    public int getY2() {
        return y2;
    }
    public Color getColor() {
        return color;
    }
    //Mutator for x1 variable
    public void setX1(int newX1) {
        if (newX1 > 0) {
            x1 = newX1;
        }
        else {
            //System.err.println("x1 must be greater than 0");
            x1 = 0;
        }
    }
    //Mutator for y1 variable
    public void setY1 (int newY1) {
        if (newY1 > 0) {
            y1 = newY1;
        }
        else {
            //System.err.println("y1 must be greater than 0");
            y1 = 0;
        }
    }
    //Mutator for x2 variable
    public void setX2(int newX2) {
        if (newX2 > 0) {
            x2 = newX2;
        }
        else {
            //System.err.println("x2 must be greater than 0");
            x2 = 0;
        }
    }
    //Mutator for y2 variable
    public void setY2(int newY2) {
        if (newY2 > 0) {
            y2 = newY2; 
        }
        else {
            //System.err.println("y2 must be greater than 0");
            y2 = 0;
        }
    }
    public void setColor(Color color) {
        this.color = color;
    }
    public void draw(Graphics g) {

    }
}