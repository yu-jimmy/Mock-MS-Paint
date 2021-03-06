import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JColorChooser;
import shape2D.Shape;
import shape2D.Line;
import shape2D.Oval;
import shape2D.Rectangle;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

/* Name: Jimmy Yu
 * Date: May 2nd, 2018
 * Desc: This class defines the drawing panel that is used to draw lines, rectangles and ovals.
 * The mouse location is also tracked on the panel. */

public class DrawFrame extends JFrame {
    //Create instance variables
    private DynamicStack<Shape> shapes = new DynamicStack<>();
    private DynamicStack<Shape> undoShapes = new DynamicStack<>();
    private JLabel statusLabel;
    private JButton undo;
    private JButton redo;
    private JButton clear;
    private JButton colorChoice;
    private JCheckBox filled;
    private JComboBox<String> shapeChoice;
    private String[] shapeList = {"Rectangle", "Line", "Oval"};
    private JPanel paintOptions;
    private DrawPanel drawPanel;
    
    //Constructor method
    public DrawFrame() {
        super("Super Paint GUI"); 
        
        //JLabel to keep track of mouse coords
        JLabel statusLabel = new JLabel();
        add(statusLabel, BorderLayout.SOUTH);
        
        //Create an eventlistener object
        ActionListener eventListener = new ButtonEventListener();
        
        //Initialize all the instance variables and associate them with action or item listeners
        undo = new JButton("Undo");
        undo.addActionListener(eventListener);
        
        redo = new JButton("Redo");
        redo.addActionListener(eventListener);
        
        clear = new JButton("Clear");
        clear.addActionListener(eventListener);
        
        colorChoice = new JButton("Colors");
        colorChoice.addActionListener(eventListener);
        
        shapeChoice = new JComboBox<String>(shapeList);
        shapeChoice.setMaximumRowCount(3);
        ItemListener shapeListener = new ShapeChoiceEventListener();
        shapeChoice.addItemListener(shapeListener);
        
        filled = new JCheckBox("Filled");
        ItemListener filledBoxListener = new FilledEventListener();
        filled.addItemListener(filledBoxListener);
        
        //Initialize the JPanel for the paint options and add each JButton, JCheckBox, JComboBox to the panel
        paintOptions = new JPanel();
        paintOptions.setBackground(Color.lightGray);
        paintOptions.add(undo);
        paintOptions.add(redo);
        paintOptions.add(clear);
        paintOptions.add(colorChoice);
        paintOptions.add(shapeChoice);
        paintOptions.add(filled);
        //Add the panel to the north section of the window
        add(paintOptions, BorderLayout.NORTH);
        
        //Initialize the drawPanel and pass in the stacks, and label 
        drawPanel = new DrawPanel(shapes, undoShapes, statusLabel);
        add(drawPanel, BorderLayout.CENTER);
    }
    
    //Inner class for handling events for the filled checkbox
    class FilledEventListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            drawPanel.setFilled(filled.isSelected());
        }
    }
    
    //Inner class for handling events for the shapeChoice combobox
    class ShapeChoiceEventListener implements ItemListener {
        @Override
        public void itemStateChanged(ItemEvent e) {
            drawPanel.setShapeIndex(shapeChoice.getSelectedIndex());
        }
    }
    
    //Inner class for handling events associated with JButtons
    class ButtonEventListener implements ActionListener {
        @Override 
        public void actionPerformed(ActionEvent e) {
            /*If the event that occurred was from the colorChoice button, call the drawPanel's set color method
             *to assign the color */
            if (e.getSource() == colorChoice) {
                drawPanel.setColor(JColorChooser.showDialog(null, "Please choose a color", drawPanel.getColor()));
            }
            //If the event that occurred was from the clear button, clear the two stacks
            else if (e.getSource() == clear) {
                undoShapes.clear();
                shapes.clear();
            }
            /*If the event that occurred was from the redo button, and if the undoShapes stack is not empty
             *pop the undoShapes back into the shapes stack */
            else if (e.getSource() == redo && undoShapes.size() != 0) {
                shapes.push(undoShapes.pop());
            }
            /*If the event that occurred was from the undo button and the shapes stack is not empty
             *pop the shapes back into the undoShapes stack */
            else if (e.getSource() == undo && shapes.size() != 0) {
                undoShapes.push(shapes.pop());
            } 
            
            //Call the paint component method to update the window
            drawPanel.repaint();
        }
    }
} 