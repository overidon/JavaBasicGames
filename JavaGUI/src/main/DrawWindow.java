/*
 *  	PROJECT: DrawIO
 *  	FILE   : DrawWindow.java 
 *  DESCRIPTION: This file will help draw things to a 
 *  			 JPanel!
 */

package main;

// Abstract Window Toolkit (AWT) imports 
import java.awt.Color;
import java.awt.Graphics;

// swing imports
import javax.swing.JPanel;

public class DrawWindow extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8242558423155622593L;

	// this needs to be paintComponent.. 
	public void paintComponent(Graphics g) {
		
		// fill the screen with White! 
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.RED);
		g.fillOval(256, 256, 16, 16);
		
	// end of the paintComponent method 	
	}
		
// end of the DrawWindow class 	
}
