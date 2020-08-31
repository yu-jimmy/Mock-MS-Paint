import javax.swing.JFrame;

/* Name: Jimmy Yu
 * Date: May 2nd, 2018
 * Desc: This is the class that will define the main window of the paint application */

class SuperPaint {
    //The main method of this paint class initializes the DrawFrame paint window
    public static void main(String[] args) {
        DrawFrame application = new DrawFrame();
        
        application.setSize( 600, 600 );
        application.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        application.setVisible( true );
    }
}