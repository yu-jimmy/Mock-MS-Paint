import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JLabel;
import shape2D.Shape;
import shape2D.Line;
import shape2D.Oval;
import shape2D.Rectangle;

/* Name: Jimmy Yu
 * Date: May 2nd, 2018
 * Desc: DrawPanel is a JPanel class that will be used such that the user can draw using the mouse. */

public class DrawPanel extends JPanel {
    //Create instance variables
    private JLabel statusBar;
    private DynamicStack<Shape> shapes;
    private DynamicStack<Shape> undoShapes;
    private DynamicStack<Shape> drawings;
    private Shape currentShape = null;
    private int shapeIndex;
    private boolean filled = false;
    private Color color = Color.BLACK;
    
    //Constructor method
    public DrawPanel(DynamicStack<Shape> shapes, DynamicStack<Shape> undoShapes, JLabel statusLabel) {
        //Initialize instance variables 
        setBackground( Color.WHITE );
        this.shapes = shapes;
        this.undoShapes = undoShapes;
        statusBar = statusLabel;
        drawings = new DynamicStack<>();
        
        //Create and register listener for mouse and mouse motion events
        MouseEventListener drawPanelListener = new MouseEventListener(); 
        addMouseListener( drawPanelListener ); 
        addMouseMotionListener( drawPanelListener );  
    }
    
    //Mutator used to set the the index of the shape chosen from the shapeChoice combobox
    public void setShapeIndex(int shapeIndex) {
        this.shapeIndex = shapeIndex;
    }
    
    //Mutator used to set the bollean value for the filled instance variable 
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    
    //Mutator used to set the color
    public void setColor(Color color) {
        this.color = color;
    }
    
    //Accessor that returns color
    public Color getColor() {
        return color;
    }
    
    //The paintComponent method will be automatically called when the application window needs to be redrawn
    //It calls the drawShapes helper method to draw the shapes
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        int size = shapes.size();
        Shape drawShape;
        //Push each of the shapes into the helper stack
        for (int i = 0; i < size; i++) {
            drawings.push(shapes.pop());
        }
        //Draw each shape in the helper stack and push it back into the shapes stack
        for (int i = 0; i <size; i++) {
            drawShape = drawings.pop();
            drawShape.draw(g);
            shapes.push(drawShape);
        }        

        //If the currentShape isn't null, draw that shape as well
        if (currentShape != null) {
            currentShape.draw(g);
        }
    }
    
    //Inner class that inherits from MouseAdapter. This class handles the mouse events
    class MouseEventListener extends MouseAdapter {
        //When the mouse is pressed, check the shapeIndex to find which shape the user has selected.
        //Depending on the shapeIndex, draw the corresponding shape 
        @Override 
        public void mousePressed(MouseEvent event) {
            if (currentShape == null) {
                if (shapeIndex == 0) {
                    currentShape = new Rectangle(event.getX(), event.getY(), event.getX(), event.getY(), color, filled);
                }
                else if (shapeIndex == 1) {
                    currentShape = new Line(event.getX(), event.getY(), event.getX(), event.getY(), color);
                }
                else {
                    currentShape = new Oval(event.getX(), event.getY(), event.getX(), event.getY(), color, filled);
                }
            }
            //Call the paintComponent method so that the shapes can be drawn
            repaint();
        }
        
        //When the mouse is released, the new shape is finished.
        @Override 
        public void mouseReleased(MouseEvent event) {
            //Update the ending coordinates
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());
            
            //Add the shape to the shapes stack
            shapes.push(currentShape);
            undoShapes.clear();
            
            //Get ready for the next shape to be drawn
            currentShape = null;
            repaint();
        }
        
        //As the mouse is dragged, update the ending coordinates of the current shape as well as the statusBar label
        @Override 
        public void mouseDragged(MouseEvent event) {
            currentShape.setX2(event.getX());
            currentShape.setY2(event.getY());
            statusBar.setText(String.format("Mouse a (%d, %d)", event.getX(), event.getY()));
            
            repaint();
        }
        
        //As the mouse is moved, update the statusBar label
        @Override 
        public void mouseMoved(MouseEvent event) {
            statusBar.setText(String.format("Mouse at (%d, %d)", event.getX(), event.getY()));
        }
    }
}