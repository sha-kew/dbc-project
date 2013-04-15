package edu.rit.cs.dbc;

import edu.rit.cs.dbc.db.DatabaseConnection;
import edu.rit.cs.dbc.view.BrowseMoviesPanel;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 * @author ptr5201
 */
public class DatabaseApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("main starting");
        String user = "p48501a";
        String pass = "uixohphieshiechu";
        
        DatabaseConnection db = DatabaseConnection.getInstance();
        
        db.connect(user, pass);
        System.out.println("Connection successful");
        
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Browse Movies Screen Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        BrowseMoviesPanel newContentPane = new BrowseMoviesPanel();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                DatabaseConnection.getInstance().close();
            }
        });

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}
